package com.constanzooficial.integracao.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.output.FileWriterWithEncoding;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class UtilFile {

    public static void createFileFromString(File file, String data) throws IOException {

        try (FileWriterWithEncoding writer = new FileWriterWithEncoding(file, Charset.forName("UTF-8"))) {

            writer.write(data);

        }
    }

    public static void createFileFromLines(File file, ArrayList<String> lines) throws IOException {
        try (FileWriterWithEncoding writer = new FileWriterWithEncoding(file, Charset.forName("UTF-8"))) {
            int size = lines.size();
            for (int i = 0; i < size; i++) {
                String str = lines.get(i);
                writer.write(str);
                if (i < size - 1) {
                    //**This prevent creating a blank like at the end of the file**
                    writer.write("\n");
                }
            }
        }
        /*
            try (FileWriter writer = new FileWriter(file)) {
            int size = lines.size();
            for (int i = 0; i < size; i++) {
            String str = lines.get(i);
            writer.write(str);
            if (i < size - 1) {
            //**This prevent creating a blank like at the end of the file**
            writer.write("\n");
            }
            }
            }
             */
    }

    public static ArrayList<String> readFile(File file) throws IOException {

        return new ArrayList<>(FileUtils.readLines(file, "UTF-8"));
        
        /*
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String sCurrentLine = br.readLine();
            while (sCurrentLine != null) {
                linhas.add(sCurrentLine);
                sCurrentLine = br.readLine();
            }
        }
        return linhas;
        */
    }

    public static String fileToStringInline(File file) throws IOException {
        
        return FileUtils.readFileToString(file, "UTF-8").replaceAll("\n|\r", "");
        
        /*
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String sCurrentLine = br.readLine();
            while (sCurrentLine != null) {
                sb.append(sCurrentLine);
                sCurrentLine = br.readLine();
            }
        }
        return sb.toString();
        */
    }

    public static String fileToString(File file) throws IOException {

        return FileUtils.readFileToString(file, "UTF-8");
        
        /*
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String sCurrentLine = br.readLine();
            while (sCurrentLine != null) {
                sb.append(sCurrentLine).append('\n');
                sCurrentLine = br.readLine();
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
        */
    }
}
