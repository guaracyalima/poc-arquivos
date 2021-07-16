package com.github.guaracyalima.pocarquivos.dto;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class MascaraIncialCliente extends Mascara{

	@NotNull(message = "Código do objeto não pode ser null")
	private String codigoObjeto;
	
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
	
	@NotNull(message = "Nome da entidade organizadora não pode ser null")
	private String nomeEntidadeOganizadora;
	
	@NotNull(message = "Nome do vendedor não pode ser null")
	private String nomeVendedor;

	@NotNull(message = "Nome do responsavel tecnico não pode ser null")
	private String nomeResponsavelTecnico;
}
