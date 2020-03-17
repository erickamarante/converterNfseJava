package com.constanzooficial.integracao.controller.nfse.sp.saoPaulo.v001;

import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelDetalhe;
import com.constanzooficial.integracao.model.nfse.sp.saoPaulo.v001.ModelNota;
import com.constanzooficial.integracao.util.MyUtils;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.action.PdfAction;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class GeradorPDF {

    private ModelNota nota;
    public static final int EMITIDA = 0;
    public static final int RECEBIDA = 1;

    public GeradorPDF(ModelNota nota) {
        this.nota = nota;
    }

    public void gerarPDFEmitidas(String caminhoDestino) throws FileNotFoundException, IOException, Exception {

        PdfWriter pdfWriter = new PdfWriter(caminhoDestino + "/NFSe_E_"
                + ((getNota().getCabecalho().getInscricaoMunicipalContribuinte() == null) ? "" : getNota().getCabecalho().getInscricaoMunicipalContribuinte()
                + "_") + getNota().getCabecalho().getDataInicioArquivo()[2]
                + getNota().getCabecalho().getDataInicioArquivo()[1]
                + getNota().getCabecalho().getDataInicioArquivo()[0] + "_"
                + getNota().getCabecalho().getDataFimArquivo()[2]
                + getNota().getCabecalho().getDataFimArquivo()[1]
                + getNota().getCabecalho().getDataFimArquivo()[0] + ".pdf");
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument, PageSize.A4);
        document.setMargins(20, 20, 20, 20);

        // Fontes
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        PdfFont bold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);

        document.setFont(font);
        document.setFontSize(8);

        Calendar data = Calendar.getInstance();
        document.add(new Paragraph(data.get(Calendar.DAY_OF_MONTH) + "/" + (data.get(Calendar.MONTH) + 1) + "/" + data.get(Calendar.YEAR)));

        document.add(new Paragraph("NFS-e EMITIDAS").setTextAlignment(TextAlignment.CENTER).setFont(bold));
        document.add(new Paragraph("CCM nº.: " + MyUtils.formatarIMSP(nota.getCabecalho().getInscricaoMunicipalContribuinte()) + " - " + nota.getCabecalho().getRazaoSocialContribuinte()).setTextAlignment(TextAlignment.CENTER).setFont(bold));

        Table tabelaCabecalho = new Table(new float[]{2, 2});
        tabelaCabecalho.setWidth(150);
        tabelaCabecalho.setHorizontalAlignment(HorizontalAlignment.CENTER);
        tabelaCabecalho.setBorder(Border.NO_BORDER);

        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("")));
        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Totais").setTextAlignment(TextAlignment.RIGHT).setFont(bold)));
        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Quantidade NFS-e").setTextAlignment(TextAlignment.RIGHT).setFont(bold)));
        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph(Integer.valueOf(nota.getRodape().getNumeroLinhasDetalhe()).toString()).setTextAlignment(TextAlignment.RIGHT).setFont(bold)));

        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Valor dos Serviços").setTextAlignment(TextAlignment.RIGHT).setFont(bold)));
        String valor = "R$ " + Integer.valueOf(nota.getRodape().getValorTotalServicos().substring(0, nota.getRodape().getValorTotalServicos().length() - 2)).toString() + "," + nota.getRodape().getValorTotalServicos().substring(nota.getRodape().getValorTotalServicos().length() - 2);
        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph(valor).setTextAlignment(TextAlignment.RIGHT).setFont(bold)));

        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Valor das Deduções").setTextAlignment(TextAlignment.RIGHT).setFont(bold)));
        valor = "R$ " + Integer.valueOf(nota.getRodape().getValorTotalDeducoes().substring(0, nota.getRodape().getValorTotalDeducoes().length() - 2)).toString() + "," + nota.getRodape().getValorTotalDeducoes().substring(nota.getRodape().getValorTotalDeducoes().length() - 2);
        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph(valor).setTextAlignment(TextAlignment.RIGHT).setFont(bold)));

        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Valor dos Créditos").setTextAlignment(TextAlignment.RIGHT).setFont(bold)));
        valor = "R$ " + Integer.valueOf(nota.getRodape().getValorTotalCreditos().substring(0, nota.getRodape().getValorTotalCreditos().length() - 2)).toString() + "," + nota.getRodape().getValorTotalCreditos().substring(nota.getRodape().getValorTotalCreditos().length() - 2);
        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph(valor).setTextAlignment(TextAlignment.RIGHT).setFont(bold)));

        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Valor do ISS").setTextAlignment(TextAlignment.RIGHT).setFont(bold)));
        valor = "R$ " + Integer.valueOf(nota.getRodape().getValorTotalIss().substring(0, nota.getRodape().getValorTotalIss().length() - 2)).toString() + "," + nota.getRodape().getValorTotalIss().substring(nota.getRodape().getValorTotalIss().length() - 2);
        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph(valor).setTextAlignment(TextAlignment.RIGHT).setFont(bold)));

        document.add(tabelaCabecalho);

        Table tabelaNotas = new Table(new float[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
        tabelaNotas.setWidth(UnitValue.createPercentValue(100));

        tabelaNotas.addCell(new Cell().add(new Paragraph("NFS-e").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("RPS").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("Emissão").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("Data Fato Gerador").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("Tomador de Serviços").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("Intermediário de Serviços").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("Valor Serviços (R$)").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("Valor Dedução (R$)").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("ISS devido (R$)").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("ISS a pagar (R$)").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("Valor Crédito (R$)").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("ISS Retido ?").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("Situação").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("ISS pago por guia NFS-e (R$) (?)").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("Carta de Correção").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("Nº da obra").setTextAlignment(TextAlignment.CENTER)));

        for (ModelDetalhe d : nota.getDetalhe()) {

            boolean cancelada = d.getSituacaoNotaFiscal().equals("C");

            // Número da NFS-e
            Paragraph p = new Paragraph(d.getNumeroNfse());
            p.setAction(PdfAction.createURI("https://nfe.prefeitura.sp.gov.br/contribuinte/notaprint.aspx?inscricao=" + d.getInscricaoMunicipalPrestador() + "&nf=" + d.getNumeroNfse() + "&verificacao=" + d.getCodigoVerificacaoNfse()));
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // Número do RPS
            p = new Paragraph(d.getNumeroRps());
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // Data de emissão
            p = new Paragraph(d.getDataHoraNfse()[0] + "/" + d.getDataHoraNfse()[1] + "/" + d.getDataHoraNfse()[2] + " " + d.getDataHoraNfse()[3] + ":" + d.getDataHoraNfse()[4] + ":" + d.getDataHoraNfse()[5]);
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // Data do fato gerador
            if (!d.getDataEmissaoRps()[2].equals("0000")) {
                p = new Paragraph(d.getDataEmissaoRps()[0] + "/" + d.getDataEmissaoRps()[1] + "/" + d.getDataEmissaoRps()[2]);
            } else {
                p = new Paragraph("");
            }
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // Tomador de Serviços
            p = new Paragraph(d.getRazaoSocialTomador());
            if (!d.getEmailTomador().equals("")) {
                p.setAction(PdfAction.createURI("mailto:" + d.getEmailTomador()));
            }
            p.setFont(bold);
            p.setTextAlignment(TextAlignment.CENTER);
            Paragraph p2;
            try {
                p2 = new Paragraph(MyUtils.formataCpfCnpj(d.getCpfCnpjTomador()));
            } catch (Exception e) {
                p2 = new Paragraph("");
            }
            p2.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
                p2.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p).add(p2));

            // Intermediário de Serviços
            p = new Paragraph(!d.getCpfCnpjIntermediario().equals("") ? MyUtils.formataCpfCnpj(d.getCpfCnpjIntermediario()) : "");
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // Valor Serviços (R$)
            valor = Integer.valueOf(d.getValorServicos().substring(0, d.getValorServicos().length() - 2)).toString() + "," + d.getValorServicos().substring(d.getValorServicos().length() - 2);
            p = new Paragraph(valor);
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // Valor Dedução (R$)
            valor = Integer.valueOf(d.getValorDeducoes().substring(0, d.getValorDeducoes().length() - 2)).toString() + "," + d.getValorDeducoes().substring(d.getValorDeducoes().length() - 2);
            p = new Paragraph(valor);
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // ISS devido (R$)
            valor = Integer.valueOf(d.getValorIss().substring(0, d.getValorIss().length() - 2)).toString() + "," + d.getValorIss().substring(d.getValorIss().length() - 2);
            p = new Paragraph(valor);
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // ISS a pagar (R$)
            // ver
            tabelaNotas.addCell(new Cell().add(new Paragraph("").setTextAlignment(TextAlignment.CENTER)));

            // Valor Crédito (R$)
            valor = Integer.valueOf(d.getValorCredito().substring(0, d.getValorCredito().length() - 2)).toString() + "," + d.getValorCredito().substring(d.getValorCredito().length() - 2);
            p = new Paragraph(valor);
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // ISS Retido ?
            p = new Paragraph(d.getIssRetido().equals("S") ? "Sim" : "Não");
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // Situação
            String situacao = d.getSituacaoNotaFiscal().equals("C") ? "Cancelada\n" + d.getDataCancelamento()[0] + "/" + d.getDataCancelamento()[1] + "/" + d.getDataCancelamento()[2] : "Normal";
            p = new Paragraph(situacao);
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // ISS pago por guia NFS-e (R$) (?)
            tabelaNotas.addCell(new Cell().add(new Paragraph("").setTextAlignment(TextAlignment.CENTER)));

            // Carta de Correção
            p = new Paragraph("Consultar");
            p.setAction(PdfAction.createURI("https://nfe.prefeitura.sp.gov.br/contribuinte/cartaemit.aspx?cancelar=1&inscricao=" + d.getInscricaoMunicipalPrestador() + "&nf=" + d.getNumeroNfse() + "&verificacao=" + d.getCodigoVerificacaoNfse()));
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // Nº da obra
            tabelaNotas.addCell(new Cell().add(new Paragraph("").setTextAlignment(TextAlignment.CENTER)));
        }

        document.add(tabelaNotas);

        document.close();
    }

    public void gerarPDFRecebidas(String caminhoDestino) throws FileNotFoundException, IOException, Exception {

        PdfWriter pdfWriter = new PdfWriter(caminhoDestino + "/NFSe_"
                + ((getNota().getCabecalho().getInscricaoMunicipalContribuinte() == null) ? "" : getNota().getCabecalho().getInscricaoMunicipalContribuinte()
                + "_") + getNota().getCabecalho().getDataInicioArquivo()[2]
                + getNota().getCabecalho().getDataInicioArquivo()[1]
                + getNota().getCabecalho().getDataInicioArquivo()[0] + "_"
                + getNota().getCabecalho().getDataFimArquivo()[2]
                + getNota().getCabecalho().getDataFimArquivo()[1]
                + getNota().getCabecalho().getDataFimArquivo()[0] + ".pdf");
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument, PageSize.A4);
        document.setMargins(20, 20, 20, 20);

        // Fontes
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        PdfFont bold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);

        document.setFont(font);
        document.setFontSize(6);

        Calendar data = Calendar.getInstance();
        document.add(new Paragraph(data.get(Calendar.DAY_OF_MONTH) + "/" + (data.get(Calendar.MONTH) + 1) + "/" + data.get(Calendar.YEAR)));

        document.add(new Paragraph("NFS-e RECEBIDAS").setTextAlignment(TextAlignment.CENTER).setFont(bold));
        document.add(new Paragraph("CCM nº.: " + MyUtils.formatarIMSP(nota.getCabecalho().getInscricaoMunicipalContribuinte()) + " - " + nota.getCabecalho().getRazaoSocialContribuinte()).setTextAlignment(TextAlignment.CENTER).setFont(bold));

        Table tabelaCabecalho = new Table(new float[]{2, 2});
        tabelaCabecalho.setWidth(150);
        tabelaCabecalho.setHorizontalAlignment(HorizontalAlignment.CENTER);
        tabelaCabecalho.setBorder(Border.NO_BORDER);

        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("")));
        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Totais").setTextAlignment(TextAlignment.RIGHT).setFont(bold)));
        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Quantidade NFS-e").setTextAlignment(TextAlignment.RIGHT).setFont(bold)));
        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph(Integer.valueOf(nota.getRodape().getNumeroLinhasDetalhe()).toString()).setTextAlignment(TextAlignment.RIGHT).setFont(bold)));

        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Valor dos Serviços").setTextAlignment(TextAlignment.RIGHT).setFont(bold)));
        String valor = "R$ " + Integer.valueOf(nota.getRodape().getValorTotalServicos().substring(0, nota.getRodape().getValorTotalServicos().length() - 2)).toString() + "," + nota.getRodape().getValorTotalServicos().substring(nota.getRodape().getValorTotalServicos().length() - 2);
        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph(valor).setTextAlignment(TextAlignment.RIGHT).setFont(bold)));

        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Valor das Deduções").setTextAlignment(TextAlignment.RIGHT).setFont(bold)));
        valor = "R$ " + Integer.valueOf(nota.getRodape().getValorTotalDeducoes().substring(0, nota.getRodape().getValorTotalDeducoes().length() - 2)).toString() + "," + nota.getRodape().getValorTotalDeducoes().substring(nota.getRodape().getValorTotalDeducoes().length() - 2);
        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph(valor).setTextAlignment(TextAlignment.RIGHT).setFont(bold)));

        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Valor dos Créditos").setTextAlignment(TextAlignment.RIGHT).setFont(bold)));
        valor = "R$ " + Integer.valueOf(nota.getRodape().getValorTotalCreditos().substring(0, nota.getRodape().getValorTotalCreditos().length() - 2)).toString() + "," + nota.getRodape().getValorTotalCreditos().substring(nota.getRodape().getValorTotalCreditos().length() - 2);
        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph(valor).setTextAlignment(TextAlignment.RIGHT).setFont(bold)));

        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph("Valor do ISS").setTextAlignment(TextAlignment.RIGHT).setFont(bold)));
        valor = "R$ " + Integer.valueOf(nota.getRodape().getValorTotalIss().substring(0, nota.getRodape().getValorTotalIss().length() - 2)).toString() + "," + nota.getRodape().getValorTotalIss().substring(nota.getRodape().getValorTotalIss().length() - 2);
        tabelaCabecalho.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph(valor).setTextAlignment(TextAlignment.RIGHT).setFont(bold)));

        document.add(tabelaCabecalho);

        Table tabelaNotas = new Table(new float[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
        tabelaNotas.setWidth(UnitValue.createPercentValue(100));

        tabelaNotas.addCell(new Cell().add(new Paragraph("Prestador de Serviços").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("Intermediário de Serviços").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("NFS-e").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("RPS").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("Emissão").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("Data Fato Gerador").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("Valor Serviços (R$)").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("Valor Dedução (R$)").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("ISS devido (R$)").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("ISS a recolher (R$)").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("Valor Crédito (R$)").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("ISS Retido ?").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("Situação").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("ISS recolhido (R$) (?)").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("Situação do aceite").setTextAlignment(TextAlignment.CENTER)));
        tabelaNotas.addCell(new Cell().add(new Paragraph("Nº da obra").setTextAlignment(TextAlignment.CENTER)));

        for (ModelDetalhe d : nota.getDetalhe()) {

            boolean cancelada = d.getSituacaoNotaFiscal().equals("C");

            // Prestador de Serviços
            Paragraph p = new Paragraph(d.getRazaoSocialPrestador());
            if (!d.getEmailPrestador().equals("")) {
                p.setAction(PdfAction.createURI("mailto:" + d.getEmailPrestador()));
            }
            p.setFont(bold);
            p.setTextAlignment(TextAlignment.CENTER);
            Paragraph p2;
            try {
                p2 = new Paragraph(MyUtils.formataCpfCnpj(d.getCpfCnpjPrestador()));
            } catch (Exception e) {
                p2 = new Paragraph("");
            }
            p2.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
                p2.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p).add(p2));

            // Intermediário de Serviços
            p = new Paragraph(!d.getCpfCnpjIntermediario().equals("") ? MyUtils.formataCpfCnpj(d.getCpfCnpjIntermediario()) : "");
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // Número da NFS-e
            p = new Paragraph(d.getNumeroNfse());
            p.setAction(PdfAction.createURI("https://nfe.prefeitura.sp.gov.br/contribuinte/notaprint.aspx?inscricao=" + d.getInscricaoMunicipalPrestador() + "&nf=" + d.getNumeroNfse() + "&verificacao=" + d.getCodigoVerificacaoNfse()));
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // Número do RPS
            p = new Paragraph(d.getNumeroRps());
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // Data de emissão
            p = new Paragraph(d.getDataHoraNfse()[0] + "/" + d.getDataHoraNfse()[1] + "/" + d.getDataHoraNfse()[2] + " " + d.getDataHoraNfse()[3] + ":" + d.getDataHoraNfse()[4] + ":" + d.getDataHoraNfse()[5]);
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // Data do fato gerador
            if (!d.getDataEmissaoRps()[2].equals("0000")) {
                p = new Paragraph(d.getDataEmissaoRps()[0] + "/" + d.getDataEmissaoRps()[1] + "/" + d.getDataEmissaoRps()[2]);
            } else {
                p = new Paragraph("");
            }
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // Valor Serviços (R$)
            valor = Integer.valueOf(d.getValorServicos().substring(0, d.getValorServicos().length() - 2)).toString() + "," + d.getValorServicos().substring(d.getValorServicos().length() - 2);
            p = new Paragraph(valor);
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // Valor Dedução (R$)
            valor = Integer.valueOf(d.getValorDeducoes().substring(0, d.getValorDeducoes().length() - 2)).toString() + "," + d.getValorDeducoes().substring(d.getValorDeducoes().length() - 2);
            p = new Paragraph(valor);
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // ISS devido (R$)
            if (d.getOpcaoPeloSimples().equals("4")) {
                p = new Paragraph("0,00");
                p.setTextAlignment(TextAlignment.CENTER);
                if (cancelada) {
                    p.setFontColor(ColorConstants.RED);
                }
                tabelaNotas.addCell(new Cell().add(p));
            } else {
                valor = Integer.valueOf(d.getValorIss().substring(0, d.getValorIss().length() - 2)).toString() + "," + d.getValorIss().substring(d.getValorIss().length() - 2);
                p = new Paragraph(valor);
                p.setTextAlignment(TextAlignment.CENTER);
                if (cancelada) {
                    p.setFontColor(ColorConstants.RED);
                }
                tabelaNotas.addCell(new Cell().add(p));
            }

            // ISS a recolher (R$)
            // ver
            if (d.getOpcaoPeloSimples().equals("4")) {
                p = new Paragraph("0,00");
                p.setTextAlignment(TextAlignment.CENTER);
                if (cancelada) {
                    p.setFontColor(ColorConstants.RED);
                }
                tabelaNotas.addCell(new Cell().add(p));
            } else {
                tabelaNotas.addCell(new Cell().add(new Paragraph("").setTextAlignment(TextAlignment.CENTER)));
            }

            // Valor Crédito (R$)
            valor = Integer.valueOf(d.getValorCredito().substring(0, d.getValorCredito().length() - 2)).toString() + "," + d.getValorCredito().substring(d.getValorCredito().length() - 2);
            p = new Paragraph(valor);
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // ISS Retido ?
            p = new Paragraph(d.getIssRetido().equals("S") ? "Sim" : "Não");
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // Situação
            String situacao = d.getSituacaoNotaFiscal().equals("C") ? "Cancelada\n" + d.getDataCancelamento()[0] + "/" + d.getDataCancelamento()[1] + "/" + d.getDataCancelamento()[2] : "Normal";
            p = new Paragraph(situacao);
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // ISS recolhido (R$) (?)
            // ver
            if (d.getOpcaoPeloSimples().equals("4")) {
                p = new Paragraph("S.\nNacional");
                p.setTextAlignment(TextAlignment.CENTER);
                if (cancelada) {
                    p.setFontColor(ColorConstants.RED);
                }
                tabelaNotas.addCell(new Cell().add(p));
            } else {
                tabelaNotas.addCell(new Cell().add(new Paragraph("").setTextAlignment(TextAlignment.CENTER)));
            }

            // Situação do aceite
            p = new Paragraph("-");
            p.setTextAlignment(TextAlignment.CENTER);
            if (cancelada) {
                p.setFontColor(ColorConstants.RED);
            }
            tabelaNotas.addCell(new Cell().add(p));

            // Nº da obra
            tabelaNotas.addCell(new Cell().add(new Paragraph("").setTextAlignment(TextAlignment.CENTER)));
        }

        document.add(tabelaNotas);

        document.close();
    }

    public ModelNota getNota() {
        return nota;
    }

    public void setNota(ModelNota nota) {
        this.nota = nota;
    }
}
