package com.github.guaracyalima.pocarquivos.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistroTrailler {

	@NotNull(message = "O tipo de registro não pode ser null")
	@Size(min = 1, max = 1, message = "Tipo registro deve ter 1 caracteres")
	private String tipoRegistro;
	
	@NotNull(message = "Quantidade tipo de registro não pode ser null")
	@Size(min = 1, max = 6, message = "Quantidade tipo registro deve ter 6 caracteres")
	private String quantidadeTipoRegistro;
	
	@NotNull(message = "O tipo de registro não pode ser null")
	@Size(min = 1, max = 6, message = "Quantidade total registro deve ter 6 caracteres")
	private String quantidadeTotalRegistros;
	
	@Size(min = 0, max = 4987, message = "Filler deve ter 4987 caracteres")
	private String filler;
}
