package com.github.guaracyalima.pocarquivos.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MascaraNotificacao extends Mascara {

	private String codigoObjeto;
	private String diaMesCorrente;
	private String mesCorrente;
	private String anoMesCorrente;
	private String numeroDemandaSISAQ;
	private String siglaUnidadeOperacional;
	private String dataRegistro;
	private String cpfConstrutora;
	private String nomeConstrutora;
	private String cpfCnpjEntidadeOrganizadora;
	private String nomeEntidadeOrganizadora;
	private String cpfCnpjVendedor;
	private String nomeVendedor;
	private String cpfRt;
	private String nomeRt;
	private String enderecoImovelReclamado;
	private String cpfCliente;
	private String nomeCliente;
	private String telefoneCliente;
	private String emailCliente;
	private String manifesto;
	private String tokenAcesso;
	private String emailUnidadeResponsavel;

}
