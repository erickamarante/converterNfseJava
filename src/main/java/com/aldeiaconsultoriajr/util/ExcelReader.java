package com.aldeiaconsultoriajr.util;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class ExcelReader {

    // private final FileInputStream inputStream;
    private final Workbook workbook;
    private Sheet planilha;
    private Row linha;

    /**
     *
     * @param is InputStream do arquivo .xlsx
     * @throws java.io.FileNotFoundException Arquivo não encontrado
     */
    public ExcelReader(InputStream is) throws IOException {
        //this.inputStream = (FileInputStream) is;
        this.workbook = new XSSFWorkbook(is);
        this.planilha = this.workbook.getSheetAt(0);
    }

    /**
     *
     * @param numeroPlanilha Número da planilha do Excel, começando com 0.
     * @return True se a planilha pode ser selecionada; False se a planilha não
     * existe.
     */
    public boolean selecionarPlanilha(int numeroPlanilha) {

        if (numeroPlanilha < 0 || numeroPlanilha >= this.workbook.getNumberOfSheets()) {
            return false;
        } else {
            this.planilha = this.workbook.getSheetAt(numeroPlanilha);
            this.linha = this.planilha.getRow(this.planilha.getFirstRowNum());
            return true;
        }
    }

    /**
     *
     * @param numeroLinha Número da linha;
     * @return True se a linha pode ser selecionada; False se a linha não
     * existe.
     */
    public boolean selecionarLinha(int numeroLinha) {
        if (numeroLinha < this.planilha.getFirstRowNum() || numeroLinha > this.planilha.getLastRowNum()) {
            return false;
        } else {
            this.linha = this.planilha.getRow(numeroLinha);
            return true;
        }
    }

    public boolean linhaEmBranco() {

        for (int i = this.linha.getFirstCellNum(); i < this.linha.getLastCellNum(); i++) {
            if (this.linha.getCell(i).getCellTypeEnum() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

    public Cell getCelula(int numeroCelula) {
        if (numeroCelula < this.linha.getFirstCellNum() || numeroCelula > this.linha.getLastCellNum()) {
            return null;
        } else {
            return this.linha.getCell(numeroCelula);
        }
    }

    public String getConteudoCelulaString(int numeroCelula) {
        if (numeroCelula < this.linha.getFirstCellNum() || numeroCelula > this.linha.getLastCellNum()) {
            return null;
        } else {

            String retorno;
            switch (this.linha.getCell(numeroCelula).getCellTypeEnum()) {
                case STRING:
                    retorno = this.linha.getCell(numeroCelula).getStringCellValue();
                    if (retorno.endsWith(".0")) {
                        retorno = retorno.substring(0, retorno.length() - 2);
                    }
                    return retorno;
                case NUMERIC:
                    double valor = this.linha.getCell(numeroCelula).getNumericCellValue();
                    retorno = String.format("%.0f", valor);
                    if (retorno.endsWith(".0")) {
                        retorno = retorno.substring(0, retorno.length() - 2);
                    }
                    if (retorno.endsWith(",00")) {
                        retorno = retorno.substring(0, retorno.length() - 3);
                    }
                    return retorno;
                default:
                    return "";
            }
        }
    }

    /**
     *
     * @param codigoMunicipio Código do município que se deseja buscar o nome
     * @return O nome do município. Retorna null caso o município não seja
     * encontrado.
     */
    public String buscaBinariaMunicipio(double codigoMunicipio) {

        int esquerda = this.planilha.getFirstRowNum();
        int direita = this.planilha.getLastRowNum();
        int meio;

        while (esquerda <= direita) {
            meio = (esquerda + direita) / 2;
            if (codigoMunicipio == this.planilha.getRow(meio).getCell(0).getNumericCellValue()) {
                return this.planilha.getRow(meio).getCell(1).getStringCellValue();
            } else if (codigoMunicipio > this.planilha.getRow(meio).getCell(0).getNumericCellValue()) {
                esquerda = meio;
            } else if (codigoMunicipio < this.planilha.getRow(meio).getCell(0).getNumericCellValue()) {
                direita = meio;
            }
        }
        return null;
    }

    public int numeroLinhas() {
        return this.planilha.getLastRowNum() + 1;
    }

    public int numeroPrimeiraLinha() {
        return this.planilha.getFirstRowNum();
    }

}
