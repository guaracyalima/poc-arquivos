package com.github.guaracyalima.pocarquivos.resources;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.guaracyalima.pocarquivos.dto.LayoutRegistroIdentificadorClienteCorrespondenciaTipoUm;
import com.github.guaracyalima.pocarquivos.dto.LayoutRegistroTotatilizadorArquivoTipoNove;
import com.github.guaracyalima.pocarquivos.dto.MascaraNotificacao;

public class DocumentResourceTest {

	@Test
	public void test() {
		
		List<MascaraNotificacao> listaMascaraNotificacao = new ArrayList<>();
		
		LocalDateTime now = LocalDateTime.now();
		
		MascaraNotificacao mascaraNotificacao = MascaraNotificacao.builder()
		.diaMesCorrente(String.valueOf(now.getDayOfMonth()))
		.mesCorrente(now.getMonth().toString())
		.anoMesCorrente(String.valueOf(now.getYear()))
		.numeroDemandaSISAQ("123")
		.siglaUnidadeOperacional("SISAQ")
		.dataRegistro("10/10/1910")
		.cpfConstrutora("12345678900")
		.nomeConstrutora("ARAUJO CONSTRUTORA S/A")
		.cpfRt("12345678900")
		.nomeRt("NOME RT")
		.enderecoImovelReclamado("ENDERECO IMOVEL RECLAMADO")
		.cpfCliente("03676459393")
		.nomeCliente("NOME CLIENTE")
		.telefoneCliente("6198774185")
		.emailCliente("user@user.com")
		.manifesto("MANIFESTO")
		.tokenAcesso("5c07c06622b0eb031a4658d8aa235af4")
		.emailUnidadeResponsavel("user@user.net")
		.build();

//		listaMascaraNotificacao.add(mascaraNotificacao);
//		listaMascaraNotificacao.add(mascaraNotificacao);
//		listaMascaraNotificacao.add(mascaraNotificacao);
//		listaMascaraNotificacao.add(mascaraNotificacao);
		listaMascaraNotificacao.add(mascaraNotificacao);
		
		new DocumentResource().geraTxtTabuladoParaRegistroIdentificadorDoClienteECorrespondenciaTipoUm(
				LayoutRegistroIdentificadorClienteCorrespondenciaTipoUm
				.builder()
				.bairro("Sincerino")
				.cep("64980000")
				.cidade("Corrente")
				.cif("")
				.complemento("Casa do araújo")
				.contrato("ABCD1234")
				.cpfCnpjPisNis("12345678900")
				.dadosCorrespondencia("Brasília, VAR1 de VAR2 de VAR3. \n"
						+ "\n"
						+ "Assunto: Programa de Olho na Qualidade do Minha Casa, Minha Vida – Protocolo VAR4\n"
						+ "\n"
						+ "À(o) Sr(a) \n"
						+ "VAR5\n"
						+ "\n"
						+ "1. Informamos o fechamento do protocolo VAR6, registrado no Programa de Olho na Qualidade, a respeito de problemas no seu imóvel financiado na Caixa, considerando as informações abaixo:\n"
						+ "\n"
						+ "VAR7\n"
						+ "\n"
						+ "2. Lembramos que conforme código civil 2002, art 618, o construtor é o responsável pela solidez e segurança do imóvel construído pelo prazo de 5 anos a contar da entrega da obra, por qualquer vício do produto pelo prazo de 90 dias após o surgimento do defeito e por prazo indeterminado, com base no artigo 26, parágrafo 3° do Código do consumidor, desde que se tratem de vícios ocultos. Portanto, cabe à construtora a responsabilidade pela execução da obra de modo a garantir sua solidez e responder pelos defeitos decorrentes de vícios construtivos.\n"
						+ "3. Reforçamos, que caso para problemas provocados por algum dos itens relacionados a seguir, orientamos dirigir-se à sua agência e solicitar a abertura de processo para habilitação de sinistro: \n"
						+ "oTempestade, temporal, chuva forte;\n"
						+ "oAlagamento, inundação, enchente; \n"
						+ "oExplosão, incêndio;\n"
						+ "oVendaval, destelhamento, desabamento, desmoronamento, deslizamento;\n"
						+ "oMorte e invalidez permanente do participante do contrato que pactuou renda.\n"
						+ "Atenciosamente,\n"
						+ "\n"
						+ "PROGRAMA DE OLHO NA QUALIDADE\n"
						+ "CAIXA ECONÔMICA FEDERAL")
				.endereco("Rua Gabriel Ferreira, Nº 19")
				.nome("Araujo Lima")
				.tipoRegistro("1")
				.uf("PI")
				.build(),
				listaMascaraNotificacao);
	}
	
	@Test
	public void testName() throws Exception {
		new DocumentResource().geraTxtParaRegistroTotalizadorDoArquivoTipoNove(LayoutRegistroTotatilizadorArquivoTipoNove
				.builder()
				.tipoRegistro("1")
				.quantidadeTipoRegistro("1")
				.quantidadeTotalRegistros("1")
				.filler("Brasília, VAR1 de VAR2 de VAR3. \n"
						+ "\n"
						+ "Assunto: Programa de Olho na Qualidade do Minha Casa, Minha Vida – Protocolo VAR4\n"
						+ "\n"
						+ "À(o) Sr(a) \n"
						+ "VAR5\n"
						+ "\n"
						+ "1. Informamos o fechamento do protocolo VAR6, registrado no Programa de Olho na Qualidade, a respeito de problemas no seu imóvel financiado na Caixa, considerando as informações abaixo:\n"
						+ "\n"
						+ "VAR7\n"
						+ "\n"
						+ "2. Lembramos que conforme código civil 2002, art 618, o construtor é o responsável pela solidez e segurança do imóvel construído pelo prazo de 5 anos a contar da entrega da obra, por qualquer vício do produto pelo prazo de 90 dias após o surgimento do defeito e por prazo indeterminado, com base no artigo 26, parágrafo 3° do Código do consumidor, desde que se tratem de vícios ocultos. Portanto, cabe à construtora a responsabilidade pela execução da obra de modo a garantir sua solidez e responder pelos defeitos decorrentes de vícios construtivos.\n"
						+ "3. Reforçamos, que caso para problemas provocados por algum dos itens relacionados a seguir, orientamos dirigir-se à sua agência e solicitar a abertura de processo para habilitação de sinistro: \n"
						+ "oTempestade, temporal, chuva forte;\n"
						+ "oAlagamento, inundação, enchente; \n"
						+ "oExplosão, incêndio;\n"
						+ "oVendaval, destelhamento, desabamento, desmoronamento, deslizamento;\n"
						+ "oMorte e invalidez permanente do participante do contrato que pactuou renda.\n"
						+ "Atenciosamente,\n"
						+ "\n"
						+ "PROGRAMA DE OLHO NA QUALIDADE\n"
						+ "CAIXA ECONÔMICA FEDERAL")
				.build());
	}

}
