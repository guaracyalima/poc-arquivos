package com.github.guaracyalima.pocarquivos;

import java.io.IOException;
import java.time.LocalDateTime;

import org.junit.Test;

import com.github.guaracyalima.pocarquivos.dto.MascaraIncialCliente;
import com.github.guaracyalima.pocarquivos.dto.MascaraNotificacao;
import com.github.guaracyalima.pocarquivos.dto.MascaraNotificacaoFinalizacaoCliente;

public class DocumentDemoTest {

	@Test
	public void test_deve_substituir_mes_no_arquivo() throws IOException {

		String input = "/home/araujo/sisaq/input.docx";
		String output = "/home/araujo/sisaq/gerados/Mascara_1_" + LocalDateTime.now() + ".docx";
		LocalDateTime now = LocalDateTime.now();

		new DocumentDemo().atualizarDocumentoMascaraNotificacao(input, output,
					MascaraNotificacao.builder()
												.diaMesCorrente(String.valueOf(now.getDayOfMonth()))
												.mesCorrente(now.getMonth().toString())
												.anoMesCorrente(String.valueOf(now.getYear()))
												.numeroDemandaSISAQ("123")
												.siglaUnidadeOperacional("SISAQ")
												.dataRegistro("null")
												.cpfConstrutora("null")
												.nomeConstrutora("null")
												.cpfRt("null")
												.nomeRt("null")
												.enderecoImovelReclamado("null")
												.cpfCliente("03676459393")
												.nomeCliente("null")
												.telefoneCliente("null")
												.emailCliente("null")
												.manifesto("null")
												.tokenAcesso("5c07c06622b0eb031a4658d8aa235af4")
												.emailUnidadeResponsavel("user@user.net")
												.build());

	}

	@Test
	public void test_deve_realizar_subistituicao_em_arquivo_mascara_dois() throws IOException {

		String input = "/home/araujo/sisaq/input2.docx";
		String output = "/home/araujo/sisaq/gerados/Mascara_2_" + LocalDateTime.now() + ".docx";
		LocalDateTime now = LocalDateTime.now();

		new DocumentDemo().atualizarDocumentoMascaraFinalizacaoCliente(input, output,
					MascaraNotificacaoFinalizacaoCliente.builder()
					.diaMesCorrente(String.valueOf(now.getDayOfMonth()))
					.mesCorrente(String.valueOf(now.getMonth()))
					.anoMesCorrente(String.valueOf(now.getYear()))
					.numeroDemandaSIUV("123456789")
					.nomeCliente("Antoin Xico")
					.numeroDemandaSIUV("123456789")
					.textoAcao("Mussumipsun")
					.build());

	}
	
	@Test
	public void test_deve_realizar_subistituicao_em_arquivo_mascara_tres() throws IOException {

		String input = "/home/araujo/sisaq/input3.docx";
		String output = "/home/araujo/sisaq/gerados/Mascara_3_" + LocalDateTime.now() + ".docx";
		LocalDateTime now = LocalDateTime.now();

		new DocumentDemo().atualizarDocumentoMascaraInicialCliente(input, output,
				MascaraIncialCliente.builder()
					.diaMesCorrente(String.valueOf(now.getDayOfMonth()))
					.mesCorrente(String.valueOf(now.getMonth()))
					.anoMesCorrente(String.valueOf(now.getYear()))
					.numeroDemandaSiouv("123456789")
					.nomeCliente("Antoin Xico")
					.dataRegistro("10/10/1910")
					.nomeConstrutora("Araújo Construtora S/A")
					.build());

	}
}
