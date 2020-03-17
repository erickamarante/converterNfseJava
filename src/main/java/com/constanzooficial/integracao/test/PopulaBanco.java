/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.constanzooficial.integracao.test;

import com.constanzooficial.integracao.util.ExcelReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

/**
 *
 * @author yurib
 */
public class PopulaBanco {

    public static String status = "Não conectou...";

    public static java.sql.Connection getConexaoMySQL() {

        Connection connection = null;                                               //atributo do tipo Connection

        try {
            // Carregando o JDBC Driver padrão
            String driverName = "com.mysql.cj.jdbc.Driver";

            Class.forName(driverName);

            // Configurando a nossa conexão com um banco de dados //
            String serverName = "localhost";                                        //caminho do servidor do BD
            String mydatabase = "constanzodb";                                      //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useTimezone=true&serverTimezone=UTC";
            String username = "root";                                               //nome de um usuário de seu BD      
            String password = null;                                                   //sua senha de acesso

            connection = DriverManager.getConnection(url, username, password);

            //Testa sua conexão//  
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }

            return connection;

        } catch (ClassNotFoundException e) {  //Driver não encontrado

            System.out.println("O driver expecificado nao foi encontrado.");

            return null;

        } catch (SQLException e) {

            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            System.out.println(e);

            return null;

        }
    }

    public static String statusConection() {
        return status;
    }

    public static boolean FecharConexao() {
        try {
            PopulaBanco.getConexaoMySQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return PopulaBanco.getConexaoMySQL();
    }

    public static String buscaApelido(ArrayList<String[]> clientes, String cnpj) {

        for (String[] umCliente : clientes) {

            if (umCliente[0].equals(cnpj)) {
                System.out.println("boa pra nois - " + umCliente[1]);
                return umCliente[1];
            }
        }

        return null;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {

        ExcelReader er = new ExcelReader(new FileInputStream(new File("arquivoDp.xlsx")));

        ArrayList<String[]> clientes = new ArrayList<>();
        for (int i = 3; i < er.numeroLinhas(); i++) {
            er.selecionarLinha(i);
            if (!er.linhaEmBranco()) {
                String[] linha = new String[3];
                String cnpj = er.getConteudoCelulaString(2);
                String apelido = er.getConteudoCelulaString(0);
                String razao = er.getConteudoCelulaString(1);
                if (cnpj != null && !cnpj.equals("") && apelido != null && !apelido.equals("") && razao != null && !razao.equals("")) {
                    linha[0] = cnpj.replaceAll("[^0-9]", ""); // CNPJ
                    linha[1] = apelido; // Apelido
                    linha[2] = razao; // Razão social
                    clientes.add(linha);
                }
            }
        }

        Connection conn = getConexaoMySQL();
        for(String[] umCliente : clientes) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO clientes(apelido, nome_clientes, cnpj_clientes) VALUES ('" + umCliente[1] + "', '" + umCliente[2] + "', '" + umCliente[0] + "')");
        }

        /*
        while (rs.next()) {
            DecimalFormat df = new DecimalFormat("#");
            Double cnpj1 = rs.getDouble("cnpj_clientes");
            String cnpj = df.format(cnpj1);
            System.out.println("Empresa " + cnpj);
            String apelido = buscaApelido(clientes, cnpj);
            System.out.println("Apelido: " + apelido);
            if (apelido != null) {
                Connection conn2 = getConexaoMySQL();
                Statement stmt2 = conn2.createStatement();
                String query = "UPDATE clientes SET apelido='" + apelido + "' WHERE cnpj_clientes='" + cnpj1 + "'";
                stmt2.executeUpdate(query);
                conn2.close();
            }
        }
        */

        conn.close();
    }
}
