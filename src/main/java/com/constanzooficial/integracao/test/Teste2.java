package com.constanzooficial.integracao.test;

import com.constanzooficial.integracao.controller.ControllerGuiaIss;
import com.constanzooficial.integracao.model.ModelGuiaIss;
import com.lowagie.text.DocumentException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Teste2 {
    
    public static void main(String[] args) throws IOException, FileNotFoundException, DocumentException {
        
        ControllerGuiaIss c = new ControllerGuiaIss(new File("Guiaa.pdf"));
        ModelGuiaIss m = new ModelGuiaIss();
        m.setNomeRazaoSocial("GRÃO FRANCHISING E PARTICIPAÇÕES LTDA");
        m.setCpfCnpj("67.894.360/0001-55");
        m.setCcm("2.069.891-7");
        m.setIncidencia("SET / 2018");
        m.setReceita("ISS incidente sobre Notas Fiscais de Serviços Eletrônicas - NFS-e");
        m.setOutrasInformacoes("Recolhimentos por Código de Serviço:\nR$ 1.982,00 (06009)\n\n\nPague somente pelo código de barras desta guia até 10/10/2018. As demais opções oferecidas pelos estabelecimentos bancários não se aplicam a este tributo.");
        m.setVencimento("10/10/2018");
        m.setValor("1.982,99");
        m.setMulta("0,00");
        m.setJuros("0,00");
        m.setAtualizacaoMonetaria("0,00");
        m.setTotal("1.982,99");
        m.setNumeroBoleto("81800000019829957011810100200316855870029900");
        c.gerarGuia(m, "guiaTeste.pdf");
    }
}
