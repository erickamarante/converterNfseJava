package com.aldeiaconsultoriajr.conversor;

import com.sun.org.apache.xml.internal.security.Init;
import com.sun.org.apache.xml.internal.security.c14n.CanonicalizationException;
import com.sun.org.apache.xml.internal.security.c14n.Canonicalizer;
import com.sun.org.apache.xml.internal.security.c14n.InvalidCanonicalizerException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.codec.binary.Base64;
import org.xml.sax.SAXException;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class AssinadorXML {

    public void assinar(String caminhoXML) throws FileNotFoundException, IOException, InvalidCanonicalizerException, ParserConfigurationException, SAXException, CanonicalizationException, NoSuchAlgorithmException {

        Init.init();
        
        // Lendo o arquivo
        File inputXmlFile = new File(caminhoXML);
        FileInputStream fis = new FileInputStream(inputXmlFile);
        byte[] xmlBytes = new byte[fis.available()];
        
        fis.read(xmlBytes);
        fis.close();
        
        // String xmlText2 = new String(xmlBytes, Charset.forName("UTF-8"));
        String xmlText2 = new String(xmlBytes, Charset.forName("ISO-8859-1"));
        System.out.println("#> TEXTO XML: " + xmlText2);

        //canonizando o texto do arquivo
        Canonicalizer canonicalizer = Canonicalizer.getInstance(Canonicalizer.ALGO_ID_C14N_OMIT_COMMENTS);
        byte[] canonXmlTextBytes = canonicalizer.canonicalize(xmlBytes);

        // String canonXmlText = new String(canonXmlTextBytes, Charset.forName("UTF-8"));
        String canonXmlText = new String(canonXmlTextBytes, Charset.forName("ISO-8859-1"));
        System.out.println("#> TEXTO XML (CANON): " + canonXmlText);
        
        System.out.println("--- PASSO 1 ---");
        //XXX Passo 1
        String digestValueTagText = null;
        Pattern digestValueTagPattern = Pattern.compile("(<DigestValue>)(.*)(</DigestValue>)", Pattern.DOTALL);
        Matcher digestValueTagMatcher = digestValueTagPattern.matcher(canonXmlText);
        if(digestValueTagMatcher.find()){
            digestValueTagText = digestValueTagMatcher.group(2);
        }

        //retirar tag <Signature> do xml
        String xmlWithoutSignatureTag = Pattern.compile("(<Signature.*)(.*)(</Signature>)", Pattern.DOTALL).matcher(canonXmlText).replaceAll("");

        //a nota fiscal nao eh o conteudo todo e sim só a parte do <NFe>
        String NFeTagText = null;
        Pattern NFePattern = Pattern.compile("(<tc:InfNfse.*)(.*)(</tc:InfNfse>)", Pattern.DOTALL);
        Matcher NFeMatcher = NFePattern.matcher(xmlWithoutSignatureTag);
        if(NFeMatcher.find()){
            NFeTagText = NFeMatcher.group(0);
        }

        System.out.println("#> <NFe> TAG TEXT (CANON): " + NFeTagText);
        System.out.println("---");

        // System.out.println("#> <NFe> TAG DIGEST (BASE64): " + getDigestBase64String(NFeTagText.getBytes("UTF-8")));
        System.out.println("#> <NFe> TAG DIGEST (BASE64): " + getDigestBase64String(NFeTagText.getBytes("ISO-8859-1")));
        System.out.println("#> <DIGESTVALUE> TAG VALUE (BASE64): " + digestValueTagText);
    }
    
    /*
     * Digest Method 
     */
    private static String getDigestBase64String(byte[] data) throws NoSuchAlgorithmException{
        MessageDigest messageDisgester = MessageDigest.getInstance("SHA-1");
        return Base64.encodeBase64String(messageDisgester.digest(data));
    }
}
