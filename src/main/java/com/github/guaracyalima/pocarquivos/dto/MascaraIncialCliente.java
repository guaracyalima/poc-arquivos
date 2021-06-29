package com.github.guaracyalima.pocarquivos.dto;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class MascaraIncialCliente extends Mascara{

	@NotNull(message = "Dia mês corrente não pode ser null")
	private String diaMesCorrente;
	
	@NotNull(message = "Mês corrente não pode ser null")
	private String mesCorrente;
	
	@NotNull(message = "Ano corrente não pode ser null")
	private String anoMesCorrente;
	
	@NotNull(message = "Numero da demanda SIOUV não pode ser null")
	private String numeroDemandaSiouv;
	
	@NotNull(message = "Nome do cliente não pode ser null")
	private String nomeCliente;
	
	@NotNull(message = "Data de registro não pode ser null")
	private String dataRegistro;
	
	@NotNull(message = "Nome da construtora não pode ser null")
	private String nomeConstrutora;

}
