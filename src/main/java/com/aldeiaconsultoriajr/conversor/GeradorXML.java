package com.aldeiaconsultoriajr.conversor;

import com.aldeiaconsultoriajr.nfe.rs.canoas.CompNfse;
import com.aldeiaconsultoriajr.nfe.rs.canoas.ConsultarNfseLote;
import com.aldeiaconsultoriajr.nfe.rs.canoas.InfNfse;
import com.sun.org.apache.xml.internal.security.c14n.CanonicalizationException;
import com.sun.org.apache.xml.internal.security.c14n.InvalidCanonicalizerException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class GeradorXML {
    
    private ArrayList<CompNfse> listaNfse;
    
    public GeradorXML(ConsultarNfseLote consultarNfseLote) {
        this.listaNfse = consultarNfseLote.getListaNfse();
    }
    
    public void gerarTodosXMLs() {
        
        for (CompNfse compNfse : listaNfse) {
            try {
                gerarXML(compNfse.getNfse().getInfNfse());
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(GeradorXML.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidAlgorithmParameterException ex) {
                Logger.getLogger(GeradorXML.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(GeradorXML.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GeradorXML.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(GeradorXML.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidCanonicalizerException ex) {
                Logger.getLogger(GeradorXML.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CanonicalizationException ex) {
                Logger.getLogger(GeradorXML.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void gerarXML(InfNfse origem) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, FileNotFoundException, SAXException, IOException, TransformerConfigurationException, TransformerException, InvalidCanonicalizerException, CanonicalizationException {
        
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("ConsultarNfseRpsResposta");
            doc.appendChild(rootElement);

            // setting attributes to root element
            Attr xmlns = doc.createAttribute("xmlns");
            xmlns.setValue("http://www.issnetonline.com.br/webserviceabrasf/vsd/servico_consultar_nfse_rps_resposta.xsd");
            rootElement.setAttributeNode(xmlns);
            
            Attr xmlnsts = doc.createAttribute("xmlns:ts");
            xmlnsts.setValue("http://www.issnetonline.com.br/webserviceabrasf/vsd/tipos_simples.xsd");
            rootElement.setAttributeNode(xmlnsts);
            
            Attr xmlnstc = doc.createAttribute("xmlns:tc");
            xmlnstc.setValue("http://www.issnetonline.com.br/webserviceabrasf/vsd/tipos_complexos.xsd");
            rootElement.setAttributeNode(xmlnstc);

            // CompNfse element
            Element compNfse = doc.createElement("CompNfse");
            rootElement.appendChild(compNfse);

            // tc:Nfse element
            Element tcNfse = doc.createElement("tc:Nfse");
            compNfse.appendChild(tcNfse);

            // tc:InfNfse element
            Element tcInfNfse = doc.createElement("tc:InfNfse");
            tcNfse.appendChild(tcInfNfse);

            // tc:Numero element
            Element element = doc.createElement("tc:Numero");
            // element.appendChild(doc.createTextNode(parametros.getTcNumero()));
            element.appendChild(doc.createTextNode(origem.getNumero()));
            tcInfNfse.appendChild(element);

            // tc:CodigoVerificacao element
            element = doc.createElement("tc:CodigoVerificacao");
            element.appendChild(doc.createTextNode(origem.getCodigoVerificacao()));
            tcInfNfse.appendChild(element);

            // tc:DataEmissao element
            element = doc.createElement("tc:DataEmissao");
            element.appendChild(doc.createTextNode(origem.getDataEmissao()));
            tcInfNfse.appendChild(element);

            // tc:NaturezaOperacao element
            element = doc.createElement("tc:NaturezaOperacao");
            element.appendChild(doc.createTextNode(origem.getNaturezaOperacao()));
            tcInfNfse.appendChild(element);

            // tc:RegimeEspecialTributacao element
            element = doc.createElement("tc:RegimeEspecialTributacao");
            element.appendChild(doc.createTextNode("1"));
            tcInfNfse.appendChild(element);

            // tc:OptanteSimplesNacional element
            element = doc.createElement("tc:OptanteSimplesNacional");
            element.appendChild(doc.createTextNode(origem.getOptanteSimplesNacional()));
            tcInfNfse.appendChild(element);

            // tc:IncentivadorCultural element
            element = doc.createElement("tc:IncentivadorCultural");
            element.appendChild(doc.createTextNode(origem.getIncentivadorCultural()));
            tcInfNfse.appendChild(element);

            // tc:Competencia element
            element = doc.createElement("tc:Competencia");
            element.appendChild(doc.createTextNode(origem.getCompetencia()));
            tcInfNfse.appendChild(element);

            // tc:NfseSubstituida element
            element = doc.createElement("tc:NfseSubstituida");
            element.appendChild(doc.createTextNode("1"));
            tcInfNfse.appendChild(element);

            // tc:OutrasInformacoes element
            element = doc.createElement("tc:OutrasInformacoes");
            element.appendChild(doc.createTextNode(origem.getOutrasInformacoes()));
            tcInfNfse.appendChild(element);

            // tc:Servico element
            Element tcServico = doc.createElement("tc:Servico");
            tcInfNfse.appendChild(tcServico);

            // tc:ItemListaServico element
            element = doc.createElement("tc:ItemListaServico");
            element.appendChild(doc.createTextNode(origem.getServico().getItemListaServico()));
            tcServico.appendChild(element);

            // tc:CodigoCnae element
            element = doc.createElement("tc:CodigoCnae");
            element.appendChild(doc.createTextNode("8630504"));
            tcServico.appendChild(element);

            // tc:CodigoTributacaoMunicipio element
            element = doc.createElement("tc:CodigoTributacaoMunicipio");
            element.appendChild(doc.createTextNode(origem.getServico().getCodigoTributacaoMunicipio()));
            tcServico.appendChild(element);

            // tc:Discriminacao element
            element = doc.createElement("tc:Discriminacao");
            element.appendChild(doc.createTextNode(origem.getServico().getDiscriminacao()));
            tcServico.appendChild(element);

            // tc:MunicipioPrestacaoServico element
            element = doc.createElement("tc:MunicipioPrestacaoServico");
            element.appendChild(doc.createTextNode(origem.getServico().getCodigoMunicipio()));
            tcServico.appendChild(element);

            // tc:Valores element
            Element tcValores = doc.createElement("tc:Valores");
            tcServico.appendChild(tcValores);

            // tc:ValorServicos element
            element = doc.createElement("tc:ValorServicos");
            element.appendChild(doc.createTextNode(origem.getServico().getValores().getValorServicos()));
            tcValores.appendChild(element);

            // tc:ValorDeducoes element
            element = doc.createElement("tc:ValorDeducoes");
            element.appendChild(doc.createTextNode(origem.getServico().getValores().getValorDeducoes()));
            tcValores.appendChild(element);

            // tc:ValorPis element
            element = doc.createElement("tc:ValorPis");
            element.appendChild(doc.createTextNode(origem.getServico().getValores().getValorPis()));
            tcValores.appendChild(element);

            // tc:ValorCofins element
            element = doc.createElement("tc:ValorCofins");
            element.appendChild(doc.createTextNode(origem.getServico().getValores().getValorCofins()));
            tcValores.appendChild(element);

            // tc:ValorInss element
            element = doc.createElement("tc:ValorInss");
            element.appendChild(doc.createTextNode(origem.getServico().getValores().getValorInss()));
            tcValores.appendChild(element);

            // tc:ValorIr element
            element = doc.createElement("tc:ValorIr");
            element.appendChild(doc.createTextNode(origem.getServico().getValores().getValorIr()));
            tcValores.appendChild(element);

            // tc:ValorCsll element
            element = doc.createElement("tc:ValorCsll");
            element.appendChild(doc.createTextNode(origem.getServico().getValores().getValorCsll()));
            tcValores.appendChild(element);

            // tc:IssRetido element
            element = doc.createElement("tc:IssRetido");
            element.appendChild(doc.createTextNode(origem.getServico().getValores().getIssRetido()));
            tcValores.appendChild(element);

            // tc:OutrasRetencoes element
            element = doc.createElement("tc:OutrasRetencoes");
            element.appendChild(doc.createTextNode(origem.getServico().getValores().getOutrasRetencoes()));
            tcValores.appendChild(element);

            // tc:BaseCalculo element
            element = doc.createElement("tc:BaseCalculo");
            element.appendChild(doc.createTextNode(origem.getServico().getValores().getBaseCalculo()));
            tcValores.appendChild(element);

            // tc:Aliquota element
            element = doc.createElement("tc:Aliquota");
            element.appendChild(doc.createTextNode(origem.getServico().getValores().getAliquota()));
            tcValores.appendChild(element);

            // tc:ValorLiquidoNfse element
            element = doc.createElement("tc:ValorLiquidoNfse");
            element.appendChild(doc.createTextNode(origem.getServico().getValores().getValorLiquidoNfse()));
            tcValores.appendChild(element);

            // tc:ValorIssRetido element
            element = doc.createElement("tc:ValorIssRetido");
            element.appendChild(doc.createTextNode(origem.getServico().getValores().getValorIssRetido()));
            tcValores.appendChild(element);

            // tc:ValorIss element
            element = doc.createElement("tc:ValorIss");
            element.appendChild(doc.createTextNode(origem.getServico().getValores().getValorIss()));
            tcValores.appendChild(element);

            // tc:DescontoCondicionado element
            element = doc.createElement("tc:DescontoCondicionado");
            element.appendChild(doc.createTextNode(origem.getServico().getValores().getDescontoCondicionado()));
            tcValores.appendChild(element);

            // tc:DescontoIncondicionado element
            element = doc.createElement("tc:DescontoIncondicionado");
            element.appendChild(doc.createTextNode(origem.getServico().getValores().getDescontoIncondicionado()));
            tcValores.appendChild(element);

            // tc:PrestadorServico element
            Element tcPrestadorServico = doc.createElement("tc:PrestadorServico");
            tcInfNfse.appendChild(tcPrestadorServico);

            // tc:IdentificacaoPrestador element
            Element tcIdentificacaoPrestador = doc.createElement("tc:IdentificacaoPrestador");
            tcPrestadorServico.appendChild(tcIdentificacaoPrestador);

            // tc:CpfCnpj element
            Element tcCpfCnpj = doc.createElement("tc:CpfCnpj");
            tcIdentificacaoPrestador.appendChild(tcCpfCnpj);

            // tc:Cnpj element
            element = doc.createElement("tc:Cnpj");
            element.appendChild(doc.createTextNode(origem.getPrestadorServico().getIdentificacaoPrestador().getCnpj()));
            tcCpfCnpj.appendChild(element);

            // tc:InscricaoMunicipal element
            element = doc.createElement("tc:InscricaoMunicipal");
            element.appendChild(doc.createTextNode(origem.getPrestadorServico().getIdentificacaoPrestador().getInscricaoMunicipal()));
            tcIdentificacaoPrestador.appendChild(element);

            // tc:RazaoSocial element
            element = doc.createElement("tc:RazaoSocial");
            element.appendChild(doc.createTextNode(origem.getPrestadorServico().getRazaoSocial()));
            tcPrestadorServico.appendChild(element);

            // tc:NomeFantasia element
            element = doc.createElement("tc:NomeFantasia");
            element.appendChild(doc.createTextNode(origem.getPrestadorServico().getNomeFantasia()));
            tcPrestadorServico.appendChild(element);

            // tc:Endereco element
            Element tcEndereco = doc.createElement("tc:Endereco");
            tcPrestadorServico.appendChild(tcEndereco);

            // tc:Endereco element
            element = doc.createElement("tc:Endereco");
            element.appendChild(doc.createTextNode(origem.getPrestadorServico().getEndereco().getEndereco()));
            tcEndereco.appendChild(element);

            // tc:Numero element
            element = doc.createElement("tc:Numero");
            element.appendChild(doc.createTextNode(origem.getPrestadorServico().getEndereco().getNumero()));
            tcEndereco.appendChild(element);

            // tc:Bairro element
            element = doc.createElement("tc:Bairro");
            element.appendChild(doc.createTextNode(origem.getPrestadorServico().getEndereco().getBairro()));
            tcEndereco.appendChild(element);

            // tc:Cidade element
            element = doc.createElement("tc:Cidade");
            element.appendChild(doc.createTextNode(origem.getPrestadorServico().getEndereco().getCodigoMunicipio()));
            tcEndereco.appendChild(element);

            // tc:Estado element
            element = doc.createElement("tc:Estado");
            element.appendChild(doc.createTextNode(origem.getPrestadorServico().getEndereco().getUf()));
            tcEndereco.appendChild(element);

            // tc:Cep element
            element = doc.createElement("tc:Cep");
            element.appendChild(doc.createTextNode(origem.getPrestadorServico().getEndereco().getCep()));
            tcEndereco.appendChild(element);

            // tc:Contato element
            Element tcContato = doc.createElement("tc:Contato");
            tcPrestadorServico.appendChild(tcContato);

            // tc:Telefone element
            element = doc.createElement("tc:Telefone");
            element.appendChild(doc.createTextNode(origem.getPrestadorServico().getContato().getTelefone()));
            tcContato.appendChild(element);

            // tc:Email element
            element = doc.createElement("tc:Email");
            element.appendChild(doc.createTextNode(origem.getPrestadorServico().getContato().getEmail()));
            tcContato.appendChild(element);

            // tc:TomadorServico element
            Element tcTomadorServico = doc.createElement("tc:TomadorServico");
            tcInfNfse.appendChild(tcTomadorServico);

            // tc:IdentificacaoTomador element
            Element tcIdentificacaoTomador = doc.createElement("tc:IdentificacaoTomador");
            tcTomadorServico.appendChild(tcIdentificacaoTomador);

            // tc:CpfCnpj element
            Element tcCpfCnpj2 = doc.createElement("tc:CpfCnpj");
            tcIdentificacaoTomador.appendChild(tcCpfCnpj2);

            // tc:Cpf element
            element = doc.createElement("tc:Cpf");
            element.appendChild(doc.createTextNode(origem.getTomadorServico().getIdentificacaoTomador().getCpfCnpj().getCpf()));
            tcCpfCnpj2.appendChild(element);

            // tc:RazaoSocial element
            element = doc.createElement("tc:RazaoSocial");
            element.appendChild(doc.createTextNode(origem.getTomadorServico().getRazaoSocial()));
            tcTomadorServico.appendChild(element);

            // tc:Endereco element
            Element tcEndereco2 = doc.createElement("tc:Endereco");
            tcTomadorServico.appendChild(tcEndereco2);

            // tc:Endereco element
            element = doc.createElement("tc:Endereco");
            element.appendChild(doc.createTextNode(origem.getTomadorServico().getEndereco().getEndereco()));
            tcEndereco2.appendChild(element);

            // tc:Numero element
            element = doc.createElement("tc:Numero");
            element.appendChild(doc.createTextNode(origem.getTomadorServico().getEndereco().getNumero()));
            tcEndereco2.appendChild(element);

            // tc:Bairro element
            element = doc.createElement("tc:Bairro");
            element.appendChild(doc.createTextNode(origem.getTomadorServico().getEndereco().getBairro()));
            tcEndereco2.appendChild(element);

            // tc:Cidade element
            element = doc.createElement("tc:Cidade");
            element.appendChild(doc.createTextNode(origem.getTomadorServico().getEndereco().getCodigoMunicipio()));
            tcEndereco2.appendChild(element);

            // tc:Estado element
            element = doc.createElement("tc:Estado");
            element.appendChild(doc.createTextNode(origem.getTomadorServico().getEndereco().getUf()));
            tcEndereco2.appendChild(element);

            // tc:Cep element
            element = doc.createElement("tc:Cep");
            element.appendChild(doc.createTextNode(origem.getTomadorServico().getEndereco().getCep()));
            tcEndereco2.appendChild(element);

            // tc:Contato element
            Element tcContato2 = doc.createElement("tc:Contato");
            tcTomadorServico.appendChild(tcContato2);

            // tc:OrgaoGerador element
            Element tcOrgaoGerador = doc.createElement("tc:OrgaoGerador");
            tcInfNfse.appendChild(tcOrgaoGerador);

            // tc:CodigoMunicipio element
            element = doc.createElement("tc:CodigoMunicipio");
            element.appendChild(doc.createTextNode(origem.getOrgaoGerador().getCodigoMunicipio()));
            tcOrgaoGerador.appendChild(element);

            // tc:Uf element
            element = doc.createElement("tc:Uf");
            element.appendChild(doc.createTextNode(origem.getOrgaoGerador().getUf()));
            tcOrgaoGerador.appendChild(element);

            // tc:ValorCredito element
            element = doc.createElement("tc:ValorCredito");
            element.appendChild(doc.createTextNode(origem.getValorCredito()));
            tcInfNfse.appendChild(element);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(origem.getPrestadorServico().getIdentificacaoPrestador().getInscricaoMunicipal()
                    + "_NFSeNotaFiscaldeServiu00feosEletru00b6nica_"
                    + String.format("%06d", Integer.parseInt(origem.getNumero()))
                    + ".xml"));
            transformer.transform(source, result);

            /*
            // create the transformer in order to transform the document from
            // DOM Source as a JAVA document class, into a character stream (StreamResult) of
            // type String writer, in order to be converted to a string later on
            TransformerFactory tf = new TransformerFactoryImpl();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
            
            // create the string writer and transform the document to a character stream
            StringWriter sw = new StringWriter();
            transformer.transform(new DOMSource(tcInfNfse), new StreamResult(sw));

            String documentAsString = sw.toString();

            // initialize the XML security object, which is necessary to run the apache canonicalization
            Init.init();

            // canonicalize the document to a byte array and convert it to string
            // Canonicalizer canon = Canonicalizer.getInstance(Canonicalizer.ALGO_ID_C14N_EXCL_OMIT_COMMENTS);
            Canonicalizer canon = Canonicalizer.getInstance(Canonicalizer.ALGO_ID_C14N_EXCL_OMIT_COMMENTS);
            byte canonXmlBytes[] = canon.canonicalize(documentAsString.getBytes());
            String canonXmlString = new String(canonXmlBytes);

            // get instance of the message digest based on the SHA-256 hashing algorithm
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // call the digest method passing the byte stream on the text, this directly updates the message
            // being digested and perform the hashing
            byte[] hash = digest.digest(canonXmlString.getBytes(StandardCharsets.UTF_8));

            // encode the endresult byte hash
            byte[] encodedBytes;
            encodedBytes = Base64.encodeBase64(hash);
            
            System.out.println(new String(encodedBytes));
             */
 /*
            // ASSINATURA
            // Create a DOM XMLSignatureFactory that will be used to
            // generate the enveloped signature.
            XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

            // Create a Reference to the enveloped document (in this case,
            // you are signing the whole document, so a URI of "" signifies
            // that, and also specify the SHA1 digest algorithm and
            // the ENVELOPED Transform.
            DigestMethod digestMethod = fac.newDigestMethod(DigestMethod.SHA1, null);
            Transform transform = fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null);
            Reference ref = fac.newReference(tcInfNfse.getBaseURI(), digestMethod, Collections.singletonList(transform), null, null);

            // Create the SignedInfo.
            SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE,
                    (C14NMethodParameterSpec) null),
                    fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                    Collections.singletonList(ref));

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(parametros.getNomeArquivo() + ".xml"));
            transformer.transform(source, result);

            // Instantiate the document to be signed.
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            Document doc = dbf.newDocumentBuilder().parse(new FileInputStream(parametros.getNomeArquivo() + ".xml"));

            // Create a DOMSignContext and specify the RSA PrivateKey and
            // location of the resulting XMLSignature's parent element.
            DOMSignContext dsc = new DOMSignContext(keyEntry.getPrivateKey(), doc.getDocumentElement());

            // Create the XMLSignature, but don't sign it yet.
            XMLSignature signature = fac.newXMLSignature(si, ki);

            // Marshal, generate, and sign the enveloped signature.
            signature.sign(dsc);
             */
            // Output to console for testing
            /*
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
             */
        } catch (ParserConfigurationException | DOMException e) {
        }
    }
}
