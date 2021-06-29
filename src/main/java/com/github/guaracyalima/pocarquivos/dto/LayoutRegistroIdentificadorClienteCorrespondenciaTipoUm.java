package com.github.guaracyalima.pocarquivos.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LayoutRegistroIdentificadorClienteCorrespondenciaTipoUm {

	@NotNull(message = "O tipo de registro não pode ser null")
	@Size(min = 1, max = 1, message = "O tipo de registro deve ter 1 caracteres")
	private String tipoRegistro;
	
	@NotNull(message = "Nome do cliente não pode ser null")
	@Size(min = 1, max = 80, message = "Nome do cliente deve ter de 1 a 80 caracteres")
	private String nome;
	
	@NotNull(message = "Logradouro do cliente não pode ser null")
	@Size(min = 1, max = 60, message = "Logradouro do cliente deve ter de 1 a 60 caracteres")
	private String endereco;
	
	@NotNull(message = "Complemento do endereço do cliente não pode ser null")
	@Size(min = 1, max = 80, message = "Complemento do endereço do cliente deve ter de 2 a 80 caracteres")
	private String complemento;
	
	@NotNull(message = "Bairro do endereço do cliente não pode ser null")
	@Size(min = 1, max = 20, message = "Bairro do endereço do cliente deve ter de 1 a 20 caracteres")
	private String bairro;
	
	@NotNull(message = "CEP do cliente não pode ser null")
	@Size(min = 8, max = 8, message = "CEP do cliente deve ter 8 caracteres")
	private String cep;
	
	@NotNull(message = "Cidade do endereço do cliente não pode ser null")
	@Size(min = 1, max = 20, message = "Cidade do endereço do cliente deve ter de 1 a 20 caracteres")
	private String cidade;
	
	@NotNull(message = "UF do endereço do cliente não pode ser null")
	@Size(min = 2, max = 2, message = "UF do endereço do cliente deve ter de 1 a 20 caracteres")
	private String uf;
	
	@Size(min = 0, max = 14, message = "Documento de identificação do cliente deve ter de no maximo 14 caracteres")
	private String cpfCnpjPisNis;
	
	@Size(min = 0, max = 20, message = "Contraro deve ter de no maximo 20 caracteres")
	private String contrato;
	
	@Size(min = 0, max = 4675, message = "Dados da correspondencia deve ter de no maximo 4675  caracteres")
	private String dadosCorrespondencia;
	
	@Size(min = 0, max = 20, message = "CIF deve ter de no maximo 20  caracteres")
	private String cif;
	
}
