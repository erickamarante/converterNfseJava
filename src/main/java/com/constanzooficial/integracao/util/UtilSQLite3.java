package com.constanzooficial.integracao.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class UtilSQLite3 {

    private File dbFile;

    public UtilSQLite3(File dbFile) {
        this.dbFile = dbFile;
    }

    private Connection getConnection() throws SQLException {

        // SQLite connection string
        String url = "jdbc:sqlite:" + getDbFile().getAbsolutePath();
        Connection conn = DriverManager.getConnection(url);

        return conn;
    }

    public boolean existeTabela(String nomeTabela) throws Exception {
        String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='" + nomeTabela + "'";

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            return rs.next();
        }
    }

    /**
     * O primeiro elemento da lista deverá conter o nome da tabela. Em seguida,
     * para cada campo da tabela, deve-se inserir 6 informações: nome, tipo
     * (INTEGER, TEXT, BLOB, REAL ou NUMERIC), não nulo, primary key, auto
     * increment e unique. Para valores booleanos, qualquer coisa diferente de
     * null será considerada true.
     *
     *
     * @param tabela
     * @return
     * @throws java.lang.Exception
     */
    public boolean criarTabela(ArrayList<String> tabela) throws Exception {

        if (tabela.size() >= 7) {

            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE '").append(tabela.get(0)).append("' (");

            ArrayList<String> primaryKeys = new ArrayList<>();
            boolean temAutoIncrement = false;
            for (int i = 1; i < tabela.size();) {

                String nome = tabela.get(i);
                String tipo = tabela.get(i + 1);
                boolean naoNulo = tabela.get(i + 2) != null;
                boolean chavePrimaria = tabela.get(i + 3) != null;
                boolean autoIncremento = tabela.get(i + 4) != null;
                boolean unico = tabela.get(i + 5) != null;
                i += 6;

                sb.append("\n\t");
                sb.append("'").append(nome).append("' ");
                sb.append(tipo);
                sb.append(naoNulo ? " NOT NULL" : "");
                if (chavePrimaria && autoIncremento && primaryKeys.isEmpty()) {
                    sb.append(" PRIMARY KEY AUTOINCREMENT");
                    temAutoIncrement = true;
                    primaryKeys.add(nome);
                } else if (chavePrimaria && autoIncremento && !primaryKeys.isEmpty()) {
                    throw new Exception("Multiplas colunas como PK e AI.");
                } else if (autoIncremento && primaryKeys.isEmpty()) {
                    sb.append(" PRIMARY KEY AUTOINCREMENT");
                    temAutoIncrement = true;
                    primaryKeys.add(nome);
                } else if (autoIncremento && !primaryKeys.isEmpty()) {
                    throw new Exception("A coluna com AI deve ser a PK.");
                } else if (chavePrimaria) {
                    primaryKeys.add(nome);
                }
                sb.append(unico ? " UNIQUE" : "");
                if (i < tabela.size()) {
                    sb.append(",");
                }
            }

            if (!temAutoIncrement && !primaryKeys.isEmpty()) {
                sb.append(",\n\tPRIMARY KEY(");
                for (int i = 0; i < primaryKeys.size(); i++) {
                    if (i != 0) {
                        sb.append(",");
                    }
                    sb.append("'").append(primaryKeys.get(i)).append("'");
                }
                sb.append(")\n);");
            } else {
                sb.append("\n);");
            }

            String sql = sb.toString();
            executarQuery(sql);
            return true;
        }
        throw new Exception("Argumentos pendentes.");
    }

    public List<Map<String, Object>> executarQuery(String query) throws SQLException {

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement()) {

            stmt.execute(query);

            List<Map<String, Object>> resultList = new ArrayList<>();

            if (stmt.getResultSet() != null) {

                ResultSet rs = stmt.getResultSet();

                ResultSetMetaData metaData = rs.getMetaData();
                Integer columnCount = metaData.getColumnCount();

                while (rs.next()) {
                    Map<String, Object> row = new HashMap<>();
                    for (int i = 1; i <= columnCount; i++) {
                        row.put(metaData.getColumnName(i), rs.getObject(i));
                    }
                    resultList.add(row);
                }
            }

            return resultList;
        }
    }

    public File getDbFile() {
        return dbFile;
    }

    public void setDbFile(File dbFile) {
        this.dbFile = dbFile;
    }
}
