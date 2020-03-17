package com.constanzooficial.integracao.controller;

import com.constanzooficial.integracao.model.ModelClientes;
import com.constanzooficial.integracao.model.ModelClientesComparator;
import com.constanzooficial.integracao.util.ExcelReader;
import com.constanzooficial.integracao.util.MyUtils;
import com.constanzooficial.integracao.util.UtilFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class ControllerClientes extends Observable {

    private static ArrayList<ModelClientes> clientes = new ArrayList<>();
    //private static ArrayList<ModelClientes> clientes = (ArrayList)Collections.synchronizedList(new ArrayList<>());

    public ArrayList<ModelClientes> pesquisar(String pesquisa) {

        if (!clientes.isEmpty()) {

            String pesq = pesquisa.replaceAll("[\".\"]|/|-", "");
            if (pesq.length() != 0) {
                ArrayList<ModelClientes> resultado = new ArrayList<>();
                for (ModelClientes cliente : clientes) {
                    if (cliente.getRazaoSocial() != null && cliente.getRazaoSocial().toLowerCase().contains(pesq.toLowerCase())) {
                        resultado.add(cliente);
                    } else if (cliente.getCpfCnpj().contains(pesq)) {
                        resultado.add(cliente);
                    }
                }
                return resultado;
            }
        }
        return null;
    }

    public int pesquisarPosicao(String cpfCnpj) {

        if (!clientes.isEmpty()) {

            String pesq = cpfCnpj.replaceAll("[^0-9]", "");

            if (pesq.length() == 11 || pesq.length() == 14) {

                for (int i = 0; i < clientes.size(); i++) {

                    if (clientes.get(i).getCpfCnpj().equals(pesq)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public boolean adicionarCliente(String razaoSocial, String cpfCnpj, boolean considerarIss) throws Exception {

        if (pesquisarPosicao(cpfCnpj) == -1) {

            ControllerWebService webService = new ControllerWebService(null);
            ArrayList<String> consulta = webService.consultaCNPJ(cpfCnpj);

            if (!consulta.isEmpty()) {
                ModelClientes mc = new ModelClientes();
                mc.setRazaoSocial(razaoSocial);
                mc.setCpfCnpj(cpfCnpj);
                mc.setInscricaoMunicipal(consulta.get(0));
                mc.setEmiteNFe((consulta.get(1).equals("true")));
                mc.setConsiderarIss(considerarIss);
                mc.setAtivo(true);
                clientes.add(mc);
                Collections.sort(clientes, new ModelClientesComparator());
                setChanged();
                notifyObservers(1);
                return true;
            } else {
                throw new Exception("Não foi encontrada nenhuma inscrição municipal associada ao CPF/CNPJ informado.");
            }
        }
        return false;
    }

    /**
     * Atenção: Nunca modificar o CPF/CNPJ!
     *
     * @param clienteModificado
     * @return
     * @throws java.io.IOException
     */
    public boolean editarCliente(ModelClientes clienteModificado) throws IOException {

        ModelClientes cliente = getCliente(clienteModificado.getCpfCnpj());
        cliente.setRazaoSocial(clienteModificado.getRazaoSocial());
        cliente.setConsiderarIss(clienteModificado.isConsiderarIss());
        cliente.setAtivo(clienteModificado.isAtivo());
        salvarClientes();
        setChanged();
        notifyObservers(1);
        return true;
    }

    public boolean removerCliente(String cpfCnpj) throws IOException {

        int posicao = pesquisarPosicao(cpfCnpj);
        if (posicao != -1) {
            clientes.remove(posicao);
            salvarClientes();
            return true;
        }
        return false;
    }

    public synchronized void importarClientes() throws FileNotFoundException, IOException {

        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Excel", "xlsx"));
        fc.setAcceptAllFileFilterUsed(false);
        int opcao = fc.showOpenDialog(null);

        if (opcao == JFileChooser.APPROVE_OPTION) {

            File chosenFile = fc.getSelectedFile();
            FileInputStream fis = new FileInputStream(chosenFile);
            ExcelReader excel = new ExcelReader(fis);

            for (int i = 0; i < excel.numeroLinhas(); i++) {

                if (excel.selecionarLinha(i) && !excel.linhaEmBranco()) {

                    String conteudo = excel.getConteudoCelulaString(0);

                    if (conteudo != null && !conteudo.equals("")) {

                        conteudo = MyUtils.trataCpfCnpj(conteudo);

                        if (conteudo.length() == 11 || conteudo.length() == 14) {
                            ModelClientes mc = new ModelClientes();
                            mc.setRazaoSocial(excel.getConteudoCelulaString(1) == null? null : excel.getConteudoCelulaString(1).replace("\\", "").replace("/", ""));
                            mc.setCpfCnpj(conteudo);
                            mc.setConsiderarIss(true);
                            mc.setAtivo(true);
                            clientes.add(mc);
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        Collections.sort(clientes, new ModelClientesComparator());
        removerDuplicados();
        setChanged();
        notifyObservers(1);
    }

    private synchronized int removerDuplicados() {

        int qtdDuplicados = 0;
        for (int i = 0; i < clientes.size(); i++) {
            if (i + 1 < clientes.size()) {
                while (i + 1 < clientes.size() && clientes.get(i).getCpfCnpj().equals(clientes.get(i + 1).getCpfCnpj())) {
                    if (clientes.get(i).getInscricaoMunicipal() != null && clientes.get(i + 1).getInscricaoMunicipal() != null && clientes.get(i).getInscricaoMunicipal().equals(clientes.get(i + 1).getInscricaoMunicipal())) {
                        clientes.remove(i + 1);
                        qtdDuplicados++;
                    } else if (clientes.get(i).getInscricaoMunicipal() == null && clientes.get(i + 1).getInscricaoMunicipal() == null) {
                        clientes.remove(i + 1);
                        qtdDuplicados++;
                    } else {
                        break;
                    }
                }
            }
        }

        return qtdDuplicados;
    }

    public synchronized void selecionarTodos() {

        Thread t = new Thread(() -> {
            for (ModelClientes cliente : clientes) {
                cliente.setAtivo(true);
            }
        });
        t.start();
    }

    public synchronized void selecionarNenhum() {

        Thread t = new Thread(() -> {
            for (ModelClientes cliente : clientes) {
                cliente.setAtivo(false);
            }
        });
        t.start();
    }

    public synchronized void issEmTodos() {

        Thread t = new Thread(() -> {
            for (ModelClientes cliente : clientes) {
                cliente.setConsiderarIss(true);
            }
        });
        t.start();
    }

    public synchronized void issEmNenhum() {

        Thread t = new Thread(() -> {
            for (ModelClientes cliente : clientes) {
                cliente.setConsiderarIss(false);
            }
        });
        t.start();
    }

    public void carregarClientes() throws IOException {

        clientes.clear();
        ArrayList<String> linhas = UtilFile.readFile(new File("data/clientes.cfg"));
        for (String linha : linhas) {
            String[] split;
            split = linha.split(";");
            if (split.length == 6) {
                ModelClientes c = new ModelClientes();
                c.setRazaoSocial(split[0].equals("null") ? null : split[0]);
                c.setCpfCnpj(split[1]);
                if (!split[2].equals("null")) {
                    c.setInscricaoMunicipal(split[2]);
                }
                c.setEmiteNFe(split[3].equals("1"));
                c.setConsiderarIss(split[4].equals("1"));
                c.setAtivo(split[5].equals("1"));
                clientes.add(c);
            } else {
                split = linha.split(" ");
                if (split.length == 5) {
                    ModelClientes c = new ModelClientes();
                    c.setCpfCnpj(split[0]);
                    if (!split[1].equals("null")) {
                        c.setInscricaoMunicipal(split[1]);
                    }
                    c.setEmiteNFe(split[2].equals("1"));
                    c.setConsiderarIss(split[3].equals("1"));
                    c.setAtivo(split[4].equals("1"));
                    clientes.add(c);
                }
            }
        }
        
        Collections.sort(clientes, new ModelClientesComparator());
    }

    public synchronized void salvarClientes() throws IOException {

        if (clientes.size() > 0) {
            ArrayList<String> linhas = new ArrayList<>();
            for (ModelClientes cliente : clientes) {
                StringBuilder sb = new StringBuilder();
                sb.append(cliente.getRazaoSocial()).append(';');
                sb.append(cliente.getCpfCnpj()).append(';');
                sb.append(cliente.getInscricaoMunicipal()).append(';');
                sb.append((cliente.emiteNFe()) ? 1 : 0).append(';');
                sb.append((cliente.isConsiderarIss()) ? 1 : 0).append(';');
                sb.append((cliente.isAtivo()) ? 1 : 0);
                linhas.add(sb.toString());
            }
            UtilFile.createFileFromLines(new File("data/clientes.cfg"), linhas);
        }
    }

    public ModelClientes getCliente(String cpfCnpj) {

        if (cpfCnpj != null && (cpfCnpj.length() == 11 || cpfCnpj.length() == 14) && clientes.size() > 0) {

            int esquerda = 0;
            int direita = clientes.size() - 1;
            while (esquerda <= direita) {
                int meio = (esquerda + direita) / 2;
                if (cpfCnpj.equals(clientes.get(meio).getCpfCnpj())) {
                    return clientes.get(meio);
                } else if (Double.parseDouble(cpfCnpj) < Double.parseDouble(clientes.get(meio).getCpfCnpj())) {
                    direita = meio - 1;
                } else {
                    esquerda = meio + 1;
                }
            }
        }        
        return null;
    }

    public static ArrayList<ModelClientes> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<ModelClientes> aClientes) {
        clientes = aClientes;
    }
}
