package com.aldeiaconsultoriajr.util;

import java.io.IOException;
import java.text.DecimalFormat;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.text.WordUtils;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@Deprecated
public class MyUtils {

    /**
     *
     * @param str A string que se deseja definir o tamanho
     * @param tamanho O tamanho que a string deve ter
     * @param tipo "numerico" ou "texto"
     * @return Uma string com o tamanho exato definido pelo parâmetro "tamanho".
     * Caso a string seja maior, ela será truncada. Caso seja menor, será
     * preenchida com zeros ou espaços, dependendo do tipo.
     */
    public static String strTamanhoMax(String str, int tamanho, String tipo) {

        if (str != null) {
            if (str.length() > tamanho) {
                return str.substring(0, tamanho);
            } else if (str.length() == tamanho) {
                return str;
            } else if (str.length() < tamanho) {
                if ("texto".equals(tipo)) {
                    return StringUtils.rightPad(str, tamanho, ' ');
                } else if ("numerico".equals(tipo)) {
                    return StringUtils.leftPad(str, tamanho, '0');
                }
            }
        } else {
            if ("texto".equals(tipo)) {
                return StringUtils.rightPad("", tamanho, ' ');
            } else if ("numerico".equals(tipo)) {
                return StringUtils.leftPad("", tamanho, '0');
            }
        }
        return null;
    }

    /**
     *
     * @param valor Um valor double.
     * @return Uma string com o valor com duas casas decimais, porém sem ponto.
     * Exemplo: 33.2 -> 3320
     */
    public static String doubleParaStringSemPontoCom2CasasDecimais(double valor) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(valor).replace(".", "").replace(",", "");
    }

    /*
    public static String capitalizar(String str) {

        String[] split;
        split = str.split(" ");

        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].toLowerCase();
            
            if(split[i].length() > 1 && split[i].charAt(1) == '\'') {
                
            }
            
            if(!"de".equals(split[i]) && !"da".equals(split[i])){
                
            }
        }
    }*/
    /**
     *
     * @param codigoIBGE O código do município, fornecido pelo IBGE.
     * @return O nome do município, com as primeiras letras em maiúsculo.
     * Exemplo:
     * @throws IOException
     */
    public static String nomeMunicipio(double codigoIBGE) throws IOException {
        ExcelReader excelReader = new ExcelReader(MyUtils.class.getResourceAsStream("/res/codigosMunicipios.xlsx"));
        excelReader.selecionarPlanilha(0);
        String nomeMunicipio = excelReader.buscaBinariaMunicipio(codigoIBGE);
        return WordUtils.capitalizeFully(nomeMunicipio);
    }

    public static String ufMunicipio(String codigoMunicipio) {
        if (codigoMunicipio != null && codigoMunicipio.length() == 7) {
            switch (codigoMunicipio.substring(0, 2)) {
                case "12":
                    return "AC";
                case "27":
                    return "AL";
                case "16":
                    return "AP";
                case "13":
                    return "AM";
                case "29":
                    return "BA";
                case "23":
                    return "CE";
                case "53":
                    return "DF";
                case "32":
                    return "ES";
                case "52":
                    return "GO";
                case "21":
                    return "MA";
                case "51":
                    return "MT";
                case "50":
                    return "MS";
                case "31":
                    return "MG";
                case "15":
                    return "PA";
                case "25":
                    return "PB";
                case "41":
                    return "PR";
                case "26":
                    return "PE";
                case "22":
                    return "PI";
                case "33":
                    return "RJ";
                case "24":
                    return "RN";
                case "43":
                    return "RS";
                case "11":
                    return "RO";
                case "14":
                    return "RR";
                case "42":
                    return "SC";
                case "35":
                    return "SP";
                case "28":
                    return "SE";
                case "17":
                    return "TO";
                default:
                    return null;
            }
        } else {
            return null;
        }
    }

    /**
     *
     * @param ano Um ano qualquer.
     * @return True caso o ano seja bissexto.
     */
    private static boolean anoBissexto(int ano) {

        return (ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0));
    }

    /**
     *
     * @param mes O mês que se deseja saber o último dia.
     * @param ano O ano.
     * @return O último dia do mês, podendo ser 28, 29, 30 ou 31.
     */
    public static int ultimoDiaMes(int mes, int ano) {

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (anoBissexto(ano)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1;
        }
    }

    /**
     *
     * @param endereco O endereço com o tipo.
     * @param nCaracteresTipo Quantidade de caracteres que a string do tipo do
     * endereço deve ter.
     * @param nCaracteresEndereco Quantidade de caracteres que a string do
     * endereço deve ter.
     * @return O tipo e o endereço separados. Por exemplo:
     * separaTipoEndereco("Rua Dr. Wilson Rafael Danza", 3, 25) retorna {"R ",
     * "Dr. Wilson Rafael Danza "}.
     */
    public static String[] separaTipoEndereco(String endereco, int nCaracteresTipo, int nCaracteresEndereco) {

        String[] retorno = new String[2];
        String[] split = endereco.split(" ");

        boolean enderecoTemTipo = false;
        if (split.length > 1) {
            switch (split[0].toLowerCase()) {
                case "rua":
                case "ru":
                case "ru.":
                case "r":
                case "r.":
                    retorno[0] = StringUtils.rightPad("R", nCaracteresTipo, ' ');
                    enderecoTemTipo = true;
                    break;
                case "avenida":
                case "av":
                case "av.":
                    retorno[0] = StringUtils.rightPad("AV", nCaracteresTipo, ' ');
                    enderecoTemTipo = true;
                    break;
                case "travessa":
                case "t":
                case "t.":
                case "tv":
                case "tv.":
                case "trv":
                case "trv.":
                    retorno[0] = StringUtils.rightPad("TV", nCaracteresTipo, ' ');
                    enderecoTemTipo = true;
                    break;
                case "praca":
                case "praça":
                case "pca":
                case "pca.":
                case "pça":
                case "pça.":
                case "pc":
                case "pc.":
                case "pç":
                case "pç.":
                    retorno[0] = StringUtils.rightPad("PC", nCaracteresTipo, ' ');
                    enderecoTemTipo = true;
                    break;
                case "alameda":
                case "al":
                case "al.":
                    retorno[0] = StringUtils.rightPad("AL", nCaracteresTipo, ' ');
                    enderecoTemTipo = true;
                    break;
                case "rodovia":
                case "rod":
                case "rod.":
                    retorno[0] = StringUtils.rightPad("ROD", nCaracteresTipo, ' ');
                    enderecoTemTipo = true;
                    break;
                case "quadra":
                case "q":
                case "q.":
                    retorno[0] = StringUtils.rightPad("Q", nCaracteresTipo, ' ');
                    enderecoTemTipo = true;
                    break;
                case "acesso":
                case "ac":
                case "ac.":
                    retorno[0] = StringUtils.rightPad("AC", nCaracteresTipo, ' ');
                    enderecoTemTipo = true;
                    break;
                default:
                    retorno[0] = StringUtils.rightPad("", nCaracteresTipo, ' ');
                    break;
            }
        } else {
            retorno[0] = StringUtils.rightPad("", nCaracteresTipo, ' ');
        }

        int contador = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = (enderecoTemTipo ? 1 : 0); i < split.length && (contador + split[i].length()) <= nCaracteresEndereco; i++) {
            sb.append(split[i]);
            contador += split[i].length();
            if (i != split.length - 1 && (contador + split[i + 1].length()) <= nCaracteresEndereco) {
                sb.append(' ');
                contador += 1;
            }
        }
        while (contador < nCaracteresEndereco) {
            sb.append(' ');
            contador++;
        }
        retorno[1] = sb.toString();

        return retorno;
    }

    /**
     *
     * @param cpf
     * @return CPF sem pontos e traço.
     */
    public static String trataCpf(String cpf) {
        if (cpf != null) {
            return cpf.replace(".", "").replace("-", "");
        } else {
            return null;
        }
    }

    /**
     *
     * @param cnpj
     * @return CNPJ Sem pontos, traço e barra.
     */
    public static String trataCnpj(String cnpj) {
        if (cnpj != null) {
            return cnpj.replace(".", "").replace("/", "").replaceAll("-", "");
        } else {
            return null;
        }
    }

    /**
     * Trata uma string no padrão AAAA-MM-DDTHH:mm:ss
     *
     * @param dataHora
     * @return Array de String com 6 posições.
     */
    public static String[] trataDataHora(String dataHora) {
        if (dataHora != null) {

            String[] retorno = new String[6];
            String[] split;

            split = dataHora.split("-");
            retorno[0] = split[0];
            retorno[1] = split[1];
            split = split[2].split("T");
            retorno[2] = split[0];
            split = split[1].split(":");
            retorno[3] = split[0];
            retorno[4] = split[1];
            retorno[5] = split[2];

            return retorno;

        } else {
            return null;
        }
    }

    /**
     * Verifica se uma string é uma data válida
     *
     * @param data
     * @return
     */
    public static boolean validaData(String data) {

        if (data.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Trata uma string no padrão AAAA-MM-DD ou DD/MM/AAAA
     *
     * @param data
     * @return Array com 3 posições: ano, mês e dia, respectivamente.
     */
    public static String[] trataData(String data) {

        String[] retorno = new String[3];
        String[] split;

        if (data != null) {

            if (data.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
                split = data.split("/");
                retorno[0] = split[2];
                retorno[1] = split[1];
                retorno[2] = split[0];
                return retorno;

            } else {
                split = data.split("-");
                retorno[0] = split[0];
                retorno[1] = split[1];
                retorno[2] = split[2];

                return retorno;
            }
        } else {
            return null;
        }
    }

    /**
     * Trata uma data no padrão HH:mm:ss
     *
     * @param hora
     * @return Array com 3 posições: hora, minuto e segundo, respectivamente.
     */
    public static String[] trataHora(String hora) {

        String[] split;

        if (hora != null) {
            if (hora.matches("[0-9]{2}:[0-9]{2}:[0-9]{2}")) {
                split = hora.split(":");
                return split;
            }
        }
        return null;
    }

    /**
     * Trata um valor com vírgula.
     *
     * @param valor
     * @return Exemplo: 2,50 -> 2.50
     */
    public static String trataValor(String valor) {

        if (valor != null) {
            return valor.replace(',', '.');
        }
        return null;
    }
}
