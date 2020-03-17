package com.constanzooficial.integracao.model.nfse.rj.novaIguacu;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.ArrayList;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
@XStreamAlias("NOTA_FISCAL")
public class NotaFiscal {

    @XStreamAlias("TIPO")
    private String tipo;

    @XStreamAlias("NUM_NOTA")
    private String numNota;

    @XStreamAlias("DATA_HORA_EMISSAO")
    private String dataHoraEmissao;

    @XStreamAlias("DIA_EMISSAO")
    private String diaEmissao;

    @XStreamAlias("MES_COMPETENCIA")
    private String mesCompetencia;

    @XStreamAlias("SITUACAO_NF")
    private String situacaoNf;

    @XStreamAlias("CODIGO_CIDADE")
    private String codigoCidade;

    @XStreamAlias("USUARIO_CPF_CNPJ")
    private String usuarioCpfCnpj;

    @XStreamAlias("USUARIO_RAZAO_SOCIAL")
    private String usuarioRazaoSocial;

    @XStreamAlias("DATA_HORA_CANCELAMENTO")
    private String dataHoraCancelamento;

    @XStreamAlias("RPS_EMISSAO")
    private String rpsEmissao;
    
    @XStreamAlias("SUB_NUM")
    private String subNum;

    @XStreamAlias("SUB_EMISSAO")
    private String subEmissao;

    @XStreamAlias("PRESTADOR_CPF_CNPJ")
    private String prestadorCpfCnpj;

    @XStreamAlias("PRESTADOR_INSCRICAO_MUNICIPAL")
    private String prestadorInscricaoMunicipal;

    @XStreamAlias("PRESTADOR_RAZAO_SOCIAL")
    private String prestadorRazaoSocial;

    @XStreamAlias("PRESTADOR_NOME_FANTASIA")
    private String prestadorNomeFantasia;

    @XStreamAlias("PRESTADOR_TIPO_LOGRADOURO")
    private String prestadorTipoLogradouro;

    @XStreamAlias("PRESTADOR_LOGRADOURO")
    private String prestadorLogradouro;

    @XStreamAlias("PRESTADOR_PREST_NUMERO")
    private String prestadorPrestNumero;

    @XStreamAlias("PRESTADOR_COMPLEMENTO")
    private String prestadorComplemento;

    @XStreamAlias("PRESTADOR_TIPO_BAIRRO")
    private String prestadorTipoBairro;

    @XStreamAlias("PRESTADOR_BAIRRO")
    private String prestadorBairro;

    @XStreamAlias("PRESTADOR_CIDADE_CODIGO")
    private String prestadorCidadeCodigo;

    @XStreamAlias("PRESTADOR_CIDADE")
    private String prestadorCidade;

    @XStreamAlias("PRESTADOR_UF")
    private String prestadorUf;

    @XStreamAlias("PRESTADOR_CEP")
    private String prestadorCep;

    @XStreamAlias("PRESTADOR_DDD_TELEFONE")
    private String prestadorDddTelefone;

    @XStreamAlias("PRESTADOR_TELEFONE")
    private String prestadorTelefone;

    @XStreamAlias("PRESTADOR_DDD_FAX")
    private String prestadorDddFax;

    @XStreamAlias("PRESTADOR_FAX")
    private String prestadorFax;

    @XStreamAlias("TOMADOR_CPF_CNPJ")
    private String tomadorCpfCnpj;

    @XStreamAlias("TOMADOR_RAZAO_SOCIAL")
    private String tomadorRazaoSocial;

    @XStreamAlias("TOMADOR_TIPO_LOGRADOURO")
    private String tomadorTipoLogradouro;

    @XStreamAlias("TOMADOR_LOGRADOURO")
    private String tomadorLogradouro;

    @XStreamAlias("TOMADOR_NUMERO")
    private String tomadorNumero;

    @XStreamAlias("TOMADOR_COMPLEMENTO")
    private String tomadorComplemento;

    @XStreamAlias("TOMADOR_TIPO_BAIRRO")
    private String tomadorTipoBairro;

    @XStreamAlias("TOMADOR_BAIRRO")
    private String tomadorBairro;

    @XStreamAlias("TOMADOR_CIDADE_CODIGO")
    private String tomadorCidadeCodigo;

    @XStreamAlias("TOMADOR_CIDADE")
    private String tomadorCidade;

    @XStreamAlias("TOMADOR_UF")
    private String tomadorUf;

    @XStreamAlias("TOMADOR_CEP")
    private String tomadorCep;

    @XStreamAlias("TOMADOR_EMAIL")
    private String tomadorEmail;

    @XStreamAlias("TOMADOR_OPTANTE_SIMPLES")
    private String tomadorOptanteSimples;
    
    @XStreamAlias("TOMADOR_DDD_TELEFONE")
    private String tomadorDDDTelefone;
    
    @XStreamAlias("TOMADOR_TELEFONE")
    private String tomadorTelefone;

    @XStreamAlias("VALOR_NOTA")
    private String valorNota;

    @XStreamAlias("VALOR_DEDUCAO")
    private String valorDeducao;

    @XStreamAlias("VALOR_SERVICO")
    private String valorServico;

    @XStreamAlias("VALOR_ISS")
    private String valorIss;

    @XStreamAlias("VALOR_PIS")
    private String valorPis;

    @XStreamAlias("VALOR_COFINS")
    private String valorCofins;

    @XStreamAlias("VALOR_INSS")
    private String valorInss;

    @XStreamAlias("VALOR_IR")
    private String valorIr;

    @XStreamAlias("VALOR_CSLL")
    private String valorCsll;

    @XStreamAlias("AIQUOTA_PIS")
    private String aliquotaPis;

    @XStreamAlias("AIQUOTA_COFINS")
    private String aliquotaCofins;

    @XStreamAlias("AIQUOTA_INSS")
    private String aliquotaInss;

    @XStreamAlias("AIQUOTA_IR")
    private String aliquotaIr;

    @XStreamAlias("AIQUOTA_CSLL")
    private String aliquotaCsll;

    @XStreamAlias("CODIGO_ATIVIDADE")
    private String codigoAtividade;

    @XStreamAlias("DESCRICAO_ATIVIDADE")
    private String descricaoAtividade;

    @XStreamAlias("ENQUADRAMENTO_ATVIDIDADE")
    private String enquadramentoAtividade;

    @XStreamAlias("LOCAL_INCIDENCIA_ATVIDADE")
    private String localIncidenciaAtividade;

    @XStreamAlias("TRIBUTAVEL_ATVIDADE")
    private String tributavelAtividade;

    @XStreamAlias("DEDUCAO_VALOR_ATVIDADE")
    private String deducaoValorAtividade;

    @XStreamAlias("DEDUCAO_ATVIDADE")
    private String deducaoAtividade;

    @XStreamAlias("ATV_ECON_ATV")
    private String atvEconAtv;

    @XStreamAlias("COS_SERVICO")
    private String cosServico;

    @XStreamAlias("DESCRICAO_SERVICO")
    private String descricaoServico;

    @XStreamAlias("ALIQUOTA")
    private String aliquota;

    @XStreamAlias("TIPO_RECOLHIMENTO")
    private String tipoRecolhimento;

    @XStreamAlias("OPERACAO_TRIBUTACAO")
    private String operacaoTributacao;

    @XStreamAlias("MOTIVO_PAGAMENTO")
    private String motivoPagamento;

    @XStreamAlias("CODIGO_REGIME")
    private String codigoRegime;

    @XStreamAlias("CIDADE_CODIGO_PRESTACAO")
    private String cidadeCodigoPrestacao;

    @XStreamAlias("CIDADE_PRESTACAO")
    private String cidadePrestacao;

    @XStreamAlias("UF_PRESTACAO")
    private String ufPrestacao;

    @XStreamAlias("DOCUMENTO_PRESTACAO")
    private String documentoPrestacao;

    @XStreamAlias("SERIE_PRESTACAO")
    private String seriePrestacao;

    @XStreamAlias("TRIBUTACAO_PRESTACAO")
    private String tributacaoPrestacao;

    @XStreamAlias("DESCRICAO_NOTA")
    private String descricaoNota;

    @XStreamAlias("CODIGO_VERIFICACAO")
    private String codigoVerificacao;

    @XStreamAlias("ID_NOTA_FISCAL")
    private String idNotaFiscal;

    @XStreamAlias("VALOR_ISS_RET")
    private String valorIssRet;

    @XStreamAlias("ALIQ_RET")
    private String aliqRet;

    @XStreamAlias("DESCONTO_RET")
    private String descontoRet;
    
    @XStreamAlias("ITENS")
    private ArrayList<Item> itens;
    
    @XStreamAlias("DEDUCOES")
    private String deducoes;

    public String getTipo() {
        return tipo;
    }

    public String getNumNota() {
        return numNota;
    }

    public String getDataHoraEmissao() {
        return dataHoraEmissao;
    }

    public String getDiaEmissao() {
        return diaEmissao;
    }

    public String getMesCompetencia() {
        return mesCompetencia;
    }

    public String getSituacaoNf() {
        return situacaoNf;
    }

    public String getCodigoCidade() {
        return codigoCidade;
    }

    public String getUsuarioCpfCnpj() {
        return usuarioCpfCnpj;
    }

    public String getUsuarioRazaoSocial() {
        return usuarioRazaoSocial;
    }

    public String getDataHoraCancelamento() {
        return dataHoraCancelamento;
    }

    public String getRpsEmissao() {
        return rpsEmissao;
    }

    public String getSubEmissao() {
        return subEmissao;
    }

    public String getPrestadorCpfCnpj() {
        return prestadorCpfCnpj;
    }

    public String getPrestadorInscricaoMunicipal() {
        return prestadorInscricaoMunicipal;
    }

    public String getPrestadorRazaoSocial() {
        return prestadorRazaoSocial;
    }

    public String getPrestadorNomeFantasia() {
        return prestadorNomeFantasia;
    }

    public String getPrestadorTipoLogradouro() {
        return prestadorTipoLogradouro;
    }

    public String getPrestadorLogradouro() {
        return prestadorLogradouro;
    }

    public String getPrestadorPrestNumero() {
        return prestadorPrestNumero;
    }

    public String getPrestadorComplemento() {
        return prestadorComplemento;
    }

    public String getPrestadorTipoBairro() {
        return prestadorTipoBairro;
    }

    public String getPrestadorBairro() {
        return prestadorBairro;
    }

    public String getPrestadorCidadeCodigo() {
        return prestadorCidadeCodigo;
    }

    public String getPrestadorCidade() {
        return prestadorCidade;
    }

    public String getPrestadorUf() {
        return prestadorUf;
    }

    public String getPrestadorCep() {
        return prestadorCep;
    }

    public String getPrestadorDddTelefone() {
        return prestadorDddTelefone;
    }

    public String getPrestadorTelefone() {
        return prestadorTelefone;
    }

    public String getPrestadorDddFax() {
        return prestadorDddFax;
    }

    public String getPrestadorFax() {
        return prestadorFax;
    }

    public String getTomadorCpfCnpj() {
        return tomadorCpfCnpj;
    }

    public String getTomadorRazaoSocial() {
        return tomadorRazaoSocial;
    }

    public String getTomadorTipoLogradouro() {
        return tomadorTipoLogradouro;
    }

    public String getTomadorLogradouro() {
        return tomadorLogradouro;
    }

    public String getTomadorNumero() {
        return tomadorNumero;
    }

    public String getTomadorComplemento() {
        return tomadorComplemento;
    }

    public String getTomadorTipoBairro() {
        return tomadorTipoBairro;
    }

    public String getTomadorBairro() {
        return tomadorBairro;
    }

    public String getTomadorCidadeCodigo() {
        return tomadorCidadeCodigo;
    }

    public String getTomadorCidade() {
        return tomadorCidade;
    }

    public String getTomadorUf() {
        return tomadorUf;
    }

    public String getTomadorCep() {
        return tomadorCep;
    }

    public String getTomadorEmail() {
        return tomadorEmail;
    }

    public String getTomadorOptanteSimples() {
        return tomadorOptanteSimples;
    }

    public String getValorNota() {
        return valorNota;
    }

    public String getValorDeducao() {
        return valorDeducao;
    }

    public String getValorServico() {
        return valorServico;
    }

    public String getValorIss() {
        return valorIss;
    }

    public String getValorPis() {
        return valorPis;
    }

    public String getValorCofins() {
        return valorCofins;
    }

    public String getValorInss() {
        return valorInss;
    }

    public String getValorIr() {
        return valorIr;
    }

    public String getValorCsll() {
        return valorCsll;
    }

    public String getAliquotaPis() {
        return aliquotaPis;
    }

    public String getAliquotaCofins() {
        return aliquotaCofins;
    }

    public String getAliquotaInss() {
        return aliquotaInss;
    }

    public String getAliquotaIr() {
        return aliquotaIr;
    }

    public String getAliquotaCsll() {
        return aliquotaCsll;
    }

    public String getCodigoAtividade() {
        return codigoAtividade;
    }

    public String getDescricaoAtividade() {
        return descricaoAtividade;
    }

    public String getEnquadramentoAtividade() {
        return enquadramentoAtividade;
    }

    public String getLocalIncidenciaAtividade() {
        return localIncidenciaAtividade;
    }

    public String getTributavelAtividade() {
        return tributavelAtividade;
    }

    public String getDeducaoValorAtividade() {
        return deducaoValorAtividade;
    }

    public String getDeducaoAtividade() {
        return deducaoAtividade;
    }

    public String getAtvEconAtv() {
        return atvEconAtv;
    }

    public String getCosServico() {
        return cosServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public String getAliquota() {
        return aliquota;
    }

    public String getTipoRecolhimento() {
        return tipoRecolhimento;
    }

    public String getOperacaoTributacao() {
        return operacaoTributacao;
    }

    public String getMotivoPagamento() {
        return motivoPagamento;
    }

    public String getCodigoRegime() {
        return codigoRegime;
    }

    public String getCidadeCodigoPrestacao() {
        return cidadeCodigoPrestacao;
    }

    public String getCidadePrestacao() {
        return cidadePrestacao;
    }

    public String getUfPrestacao() {
        return ufPrestacao;
    }

    public String getDocumentoPrestacao() {
        return documentoPrestacao;
    }

    public String getSeriePrestacao() {
        return seriePrestacao;
    }

    public String getTributacaoPrestacao() {
        return tributacaoPrestacao;
    }

    public String getDescricaoNota() {
        return descricaoNota;
    }

    public String getCodigoVerificacao() {
        return codigoVerificacao;
    }

    public String getIdNotaFiscal() {
        return idNotaFiscal;
    }

    public String getValorIssRet() {
        return valorIssRet;
    }

    public String getAliqRet() {
        return aliqRet;
    }

    public String getDescontoRet() {
        return descontoRet;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public String getDeducoes() {
        return deducoes;
    }

    public String getTomadorDDDTelefone() {
        return tomadorDDDTelefone;
    }

    public String getTomadorTelefone() {
        return tomadorTelefone;
    }

    public String getSubNum() {
        return subNum;
    }
    
}
