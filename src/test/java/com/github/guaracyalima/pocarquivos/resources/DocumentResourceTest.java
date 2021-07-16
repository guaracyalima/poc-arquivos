package com.github.guaracyalima.pocarquivos.resources;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.guaracyalima.pocarquivos.dto.LayoutRegistroIdentificadorClienteCorrespondenciaTipoUm;
import com.github.guaracyalima.pocarquivos.dto.MascaraIncialCliente;
import com.github.guaracyalima.pocarquivos.dto.MascaraNotificacao;
import com.github.guaracyalima.pocarquivos.dto.MascaraNotificacaoFinalizacaoCliente;
import com.github.guaracyalima.pocarquivos.services.DocumentService;

public class DocumentResourceTest {

	@Test
	public void test() {

		List<MascaraNotificacao> listaMascaraNotificacao = new ArrayList<>();

		LocalDateTime now = LocalDateTime.now();
		MascaraNotificacao mascaraNotificacao = MascaraNotificacao
				.builder()
				.codigoObjeto("FF17139351-5 BR")
				.diaMesCorrente(String.valueOf(now.getDayOfMonth()))
				.mesCorrente(now.getMonth().toString())
				.anoMesCorrente(String.valueOf(now.getYear()))
				.numeroDemandaSISAQ("123")
				.siglaUnidadeOperacional("SISAQ")
				.dataRegistro("10/10/1910")
				.cpfConstrutora("12345678900")
				.nomeConstrutora("ARAUJO CONSTRUTORA S/A")
				.cpfCnpjEntidadeOrganizadora("19176393000117")
				.nomeEntidadeOrganizadora("Araújo Construtora S/A")
				.cpfCnpjVendedor("19176393000117")
				.nomeVendedor("Casa Mariri S/A")
				.cpfRt("12345678900")
				.nomeRt("RT FULANO DE TALCO")
				.enderecoImovelReclamado("ENDERECO IMOVEL RECLAMADO")
				.cpfCliente("12345678900")
				.nomeCliente("NOME CLIENTE FULANO DE TALCO")
				.telefoneCliente("6198774185")
				.emailCliente("user@user.com")
				.manifesto("MANIFESTO")
				.tokenAcesso("5c07c06622b0eb031a4658d8aa235af4")
				.emailUnidadeResponsavel("user@user.net")
				.build();

		listaMascaraNotificacao.add(mascaraNotificacao);
		listaMascaraNotificacao.add(mascaraNotificacao);
		listaMascaraNotificacao.add(mascaraNotificacao);
		listaMascaraNotificacao.add(mascaraNotificacao);
		listaMascaraNotificacao.add(mascaraNotificacao);

		new DocumentService().geraTxtTabuladoParaRegistroIdentificadorDoClienteECorrespondenciaTipoUmMascaraUm(
				LayoutRegistroIdentificadorClienteCorrespondenciaTipoUm
						.builder()
						.bairro("Sincerino")
						.cep("64980000")
						.cidade("Corrente")
						.cif("")
						.complemento("Casa Mariri")
						.contrato("ABCD1234")
						.cpfCnpjPisNis("12345678900")
						.endereco("Rua Gabriel Ferreira, Nº 19")
						.nome("Araujo Lima")
						.tipoRegistro("1")
						.uf("PI")
						.build(),
				listaMascaraNotificacao);
	}

	@Test
	public void testDeveGeraTxtTabuladoParaRegistroIdentificadorDoClienteECorrespondenciaTipoUmMascaraFinalizacaoCliente()
			throws Exception {
		List<MascaraNotificacaoFinalizacaoCliente> listaMascaraNotificacao = new ArrayList<>();
		LocalDateTime now = LocalDateTime.now();

		MascaraNotificacaoFinalizacaoCliente mascaraNotificacaoFinalizacaoCliente = MascaraNotificacaoFinalizacaoCliente
				.builder()
				.anoMesCorrente(String.valueOf(now.getYear()))
				.diaMesCorrente(String.valueOf(now.getDayOfMonth()))
				.mesCorrente(now.getMonth().toString())
				.nomeCliente("CLIENTE 007 da silva ")
				.numeroDemandaSIUV("123")
				.textoAcao("TEXTO AÇÃO")
				.build();


		listaMascaraNotificacao.add(mascaraNotificacaoFinalizacaoCliente);
		listaMascaraNotificacao.add(mascaraNotificacaoFinalizacaoCliente);
		listaMascaraNotificacao.add(mascaraNotificacaoFinalizacaoCliente);
		listaMascaraNotificacao.add(mascaraNotificacaoFinalizacaoCliente);
		listaMascaraNotificacao.add(mascaraNotificacaoFinalizacaoCliente);
		new DocumentService()
				.geraTxtTabuladoParaRegistroIdentificadorDoClienteECorrespondenciaTipoUmMascaraFinalizacaoCliente(
						LayoutRegistroIdentificadorClienteCorrespondenciaTipoUm
						.builder()
						.bairro("Sincerino")
								.cep("64980000")
								.cidade("Corrente")
								.cif("")
								.complemento("Casa Peyote")
								.contrato("ABCD1234")
								.cpfCnpjPisNis("12345678900")
								.endereco("Rua Gabriel Ferreira, Nº 19")
								.nome("Araujo Lima")
								.tipoRegistro("2")
								.uf("PI")
								.build(),
						listaMascaraNotificacao);

	}

	@Test
	public void testDeveGeraTxtTabuladoParaRegistroIdentificadorDoClienteECorrespondenciaTipoUmMascaraInicialCliente()
			throws Exception {
		List<MascaraIncialCliente> listaMascaraInicial = new ArrayList<>();
		LocalDateTime now = LocalDateTime.now();

		MascaraIncialCliente mascaraNotificacaoFinalizacaoCliente = MascaraIncialCliente
				.builder()
				.codigoObjeto("FF17139351-5 BR")
				.anoMesCorrente(String.valueOf(now.getYear()))
				.diaMesCorrente(String.valueOf(now.getDayOfMonth()))
				.mesCorrente(now.getMonth().toString())
				.nomeCliente("CLIENTE 007 da silva ")
				.numeroDemandaSiouv("123456")
				.dataRegistro(String.valueOf(now.getDayOfMonth()) + "/"
						+ String.valueOf(now.getMonthValue()) + "/" + String.valueOf(now.getYear()))
				.nomeConstrutora("Araujo Construtora S/A")
				.build();

		listaMascaraInicial.add(mascaraNotificacaoFinalizacaoCliente);
		listaMascaraInicial.add(mascaraNotificacaoFinalizacaoCliente);
		listaMascaraInicial.add(mascaraNotificacaoFinalizacaoCliente);
		listaMascaraInicial.add(mascaraNotificacaoFinalizacaoCliente);
		listaMascaraInicial.add(mascaraNotificacaoFinalizacaoCliente);

		new DocumentService()
				.geraTxtTabuladoParaRegistroIdentificadorDoClienteECorrespondenciaTipoUmMascaraInicialCliente(
						LayoutRegistroIdentificadorClienteCorrespondenciaTipoUm
								.builder()
								.bairro("Sincerino")
								.cep("64980000")
								.cidade("Corrente")
								.cif("")
								.complemento("Malhada do Capitão")
								.contrato("ABCD1234")
								.cpfCnpjPisNis("12345678900")
								.endereco("Rua Gabriel Ferreira, Nº 19")
								.nome("Araujo Lima")
								.tipoRegistro("3")
								.uf("PI")
								.build(),
						listaMascaraInicial);
	}

}
