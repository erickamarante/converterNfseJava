package com.constanzooficial.integracao.controller;

//import br.com.nordestefomento.jrimum.utilix.FileUtil;
//import br.com.nordestefomento.jrimum.utilix.PDFUtil;
import com.constanzooficial.integracao.model.ModelGuiaIss;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.Barcode128;
import com.lowagie.text.pdf.Barcode39;
import com.lowagie.text.pdf.BarcodeCodabar;
import com.lowagie.text.pdf.BarcodeEAN;
import com.lowagie.text.pdf.BarcodeInter25;
import com.lowagie.text.pdf.BarcodePostnet;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class ControllerGuiaIss {

    private final PdfReader reader;
    private final PdfStamper stamper;
    private final AcroFields form;
    private final ByteArrayOutputStream outputStream;

    public ControllerGuiaIss(File template) throws FileNotFoundException, IOException, DocumentException {

        reader = new PdfReader(new FileInputStream(template));
        outputStream = new ByteArrayOutputStream();
        stamper = new PdfStamper(reader, outputStream);
        form = stamper.getAcroFields();
    }

    public void gerarGuia(ModelGuiaIss guia, String destino) throws IOException, DocumentException {

        form.setField("txtNomeRazaoSocial1", guia.getNomeRazaoSocial());
        form.setField("txtCpfCnpj1", guia.getCpfCnpj());
        form.setField("txtCcm1", guia.getCcm());
        form.setField("txtIncidencia1", guia.getIncidencia());
        form.setField("txtReceita1", guia.getReceita());
        form.setField("txtOutrasInformacoes1", guia.getOutrasInformacoes());
        form.setField("txtVencimento1", guia.getVencimento());
        form.setField("txtValor1", guia.getValor());
        form.setField("txtMulta1", guia.getMulta());
        form.setField("txtJuros1", guia.getJuros());
        form.setField("txtAtualizacaoMonetaria1", guia.getAtualizacaoMonetaria());
        form.setField("txtOutrosEncargos1", guia.getOutrosEncargos());
        form.setField("txtTotal1", guia.getTotal());
        form.setField("txtVia1", "VIA DO CONTRIBUINTE - Documento No. " + guia.getNumeroDocumento());
        
        form.setField("txtNomeRazaoSocial2", guia.getNomeRazaoSocial());
        form.setField("txtCpfCnpj2", guia.getCpfCnpj());
        form.setField("txtCcm2", guia.getCcm());
        form.setField("txtIncidencia2", guia.getIncidencia());
        form.setField("txtReceita2", guia.getReceita());
        form.setField("txtOutrasInformacoes2", guia.getOutrasInformacoes());
        form.setField("txtVencimento2", guia.getVencimento());
        form.setField("txtValor2", guia.getValor());
        form.setField("txtMulta2", guia.getMulta());
        form.setField("txtJuros2", guia.getJuros());
        form.setField("txtAtualizacaoMonetaria2", guia.getAtualizacaoMonetaria());
        form.setField("txtOutrosEncargos2", guia.getOutrosEncargos());
        form.setField("txtTotal2", guia.getTotal());
        form.setField("txtVia2", "VIA DO BANCO - Documento No. " + guia.getNumeroDocumento());
        
        BarcodeInter25 barCode = new BarcodeInter25();
        barCode.setCode(guia.getNumeroBoleto());
        barCode.setX((float) 0.6);
        Image img = Image.getInstance(barCode.createAwtImage(Color.black, Color.white), Color.black);
        float posBarCode[] = form.getFieldPositions("txtCodBarra2");
//        PDFUtil.changeField2Image(stamper, posBarCode, img);

        reader.consolidateNamedDestinations();
        stamper.setFormFlattening(true);
        stamper.setRotateContents(true);
        reader.removeFields();
        stamper.setFullCompression();
        reader.eliminateSharedStreams();
        outputStream.flush();
        outputStream.close();
        reader.close();
        stamper.close();
        
//        File file = FileUtil.bytes2File(destino, outputStream.toByteArray());
    }
}
