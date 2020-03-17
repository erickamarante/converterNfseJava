package com.constanzooficial.integracao.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class SQLite {

    private Connection connection;
    private String url;

    public SQLite() {
        this.connection = null;
        this.url = null;
    }

    public Connection connect(File dbFile) {

        String urlTemp = "jdbc:sqlite:" + dbFile.getAbsolutePath();

        try (Connection conn = DriverManager.getConnection(urlTemp)) {
            if (conn != null) {
                this.connection = conn;
                this.url = urlTemp;
                return conn;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void executeStatement(String statement) {

        if (isConnected()) {
            try (Connection conn = DriverManager.getConnection(url);
                    Statement stmt = conn.createStatement()) {
                stmt.execute(statement);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public void insert(Integer codigoIbge, String nome) {
        String sql = "INSERT INTO cidades(codigoIbge,nome) VALUES(?,?)";

        try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigoIbge);
            pstmt.setString(2, nome);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isConnected() {
        return this.connection != null;
    }
}
