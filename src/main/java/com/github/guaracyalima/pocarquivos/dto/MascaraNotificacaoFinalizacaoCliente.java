package com.github.guaracyalima.pocarquivos.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MascaraNotificacaoFinalizacaoCliente  extends Mascara{

	private String codigoObjeto;
	private String diaMesCorrente;
	private String mesCorrente;
	private String anoMesCorrente;
	private String numeroDemandaSIUV;
	private String nomeCliente;
	private String textoAcao;
}
