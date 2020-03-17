package com.constanzooficial.integracao.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.text.WordUtils;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class UtilCidades {

    /**
     * Connect to the cidades.db database
     *
     * @return the Connection object
     */
    private static Connection connect() {
        // SQLite database file
        File dbFile = new File("db/cidades.db");
        // SQLite connection string
        String url = "jdbc:sqlite:" + dbFile.getAbsolutePath();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static String nomeCidade(String codigo) {
        return nomeCidade(Integer.valueOf(codigo));
    }

    public static String nomeCidade(int codigo) {

        String sql = "SELECT nome FROM cidades WHERE codigoIbge = ?";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setInt(1, codigo);
            // execute
            ResultSet rs = pstmt.executeQuery();

            return WordUtils.capitalizeFully(rs.getString("nome"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
