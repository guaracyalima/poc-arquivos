package com.github.guaracyalima.pocarquivos.resources;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.Path;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.github.guaracyalima.pocarquivos.dto.LayoutRegistroIdentificadorClienteCorrespondenciaTipoUm;
import com.github.guaracyalima.pocarquivos.dto.LayoutRegistroTotatilizadorArquivoTipoNove;
import com.github.guaracyalima.pocarquivos.dto.Mascara;
import com.github.guaracyalima.pocarquivos.dto.MascaraIncialCliente;
import com.github.guaracyalima.pocarquivos.dto.MascaraNotificacao;
import com.github.guaracyalima.pocarquivos.dto.MascaraNotificacaoFinalizacaoCliente;
import com.github.guaracyalima.pocarquivos.dto.TipoMascaraEnum;

@Path("/documents")
public class DocumentResource {

	private static Logger log = Logger.getLogger(DocumentResource.class.getName());
	private static final String ESPACAMENTO = "\s";

	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private Validator validator = factory.getValidator();

	private static final String NOME_ARQUIVO_SAIDA_MASCARA_01 = "SISAQM01FCR01";
	private static final String NOME_ARQUIVO_SAIDA_MASCARA_02 = "SISAQM02FSR01";
	private static final String NOME_ARQUIVO_SAIDA_MASCARA_03 = "SISAQM03FSR01";

	private LocalDateTime now = LocalDateTime.now();

	public void geraTxtTabuladoParaRegistroIdentificadorDoClienteECorrespondenciaTipoUm(
			LayoutRegistroIdentificadorClienteCorrespondenciaTipoUm identificadorClienteCorrespondenciaTipoUm,
			List<Mascara> mascara,
			TipoMascaraEnum tipoMascara) {

		Set<ConstraintViolation<LayoutRegistroIdentificadorClienteCorrespondenciaTipoUm>> violations = validator
				.validate(identificadorClienteCorrespondenciaTipoUm);

		for (ConstraintViolation<LayoutRegistroIdentificadorClienteCorrespondenciaTipoUm> violation : violations) {

			log.error("Erros no preenchimento do DTO " + violation.getMessage());
		}

		String fileName = getPathDosArquivosTxt() + "/" + NOME_ARQUIVO_SAIDA_MASCARA_01 + now.getYear()
				+ now.getMonthValue() + now.getDayOfMonth() + ".txt";

		System.out.println("fileName " + fileName);
		String tipoRegistro = StringUtils
				.rightPad(identificadorClienteCorrespondenciaTipoUm.getTipoRegistro().toString(), 1);
		String nome = StringUtils.rightPad(identificadorClienteCorrespondenciaTipoUm.getNome(), 80, ESPACAMENTO);
		String endereco = StringUtils.rightPad(identificadorClienteCorrespondenciaTipoUm.getEndereco(), 60,
				ESPACAMENTO);
		String complemento = StringUtils.rightPad(identificadorClienteCorrespondenciaTipoUm.getComplemento(), 80,
				ESPACAMENTO);
		String bairro = StringUtils.rightPad(identificadorClienteCorrespondenciaTipoUm.getBairro(), 20, ESPACAMENTO);
		String cep = StringUtils.rightPad(identificadorClienteCorrespondenciaTipoUm.getCep(), 8, ESPACAMENTO);
		String cidade = StringUtils.rightPad(identificadorClienteCorrespondenciaTipoUm.getCidade(), 20, ESPACAMENTO);
		String uf = StringUtils.rightPad(identificadorClienteCorrespondenciaTipoUm.getUf(), 2);
		String cpfCnpjPisNis = StringUtils.rightPad(identificadorClienteCorrespondenciaTipoUm.getCpfCnpjPisNis(), 14,
				ESPACAMENTO);
		String contrato = StringUtils.rightPad(identificadorClienteCorrespondenciaTipoUm.getContrato(), 20,
				ESPACAMENTO);
		
		String dadosCorrespondencia;
		
		switch (tipoMascara) {
		case MASCARA_UM:
			dadosCorrespondencia  = montaCorpoDocumentoMascaraNotificacao(mascara);
			break;

		case MASCARA_DOIS:
			dadosCorrespondencia  = montaCorpoDocumentoMascaraNotificacao(mascara);
			break;
		case MASCARA_TRES:
			dadosCorrespondencia  = montaCorpoDocumentoMascaraNotificacao(mascara);
			break;
		default:
			break;
		}

		
		String cif = StringUtils.rightPad(identificadorClienteCorrespondenciaTipoUm.getCif(), 20, ESPACAMENTO);

		try {
			FileWriter writer = new FileWriter(fileName);

			writer.append(tipoRegistro);
			writer.append(nome);
			writer.append(endereco);
			writer.append(complemento);
			writer.append(bairro);
			writer.append(cep);
			writer.append(cidade);
			writer.append(uf);
			writer.append(cpfCnpjPisNis);
			writer.append(contrato);
			writer.append(dadosCorrespondencia);
			writer.append(cif);

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void geraTxtTabuladoParaRegistroIdentificadorDoClienteECorrespondenciaTipoUmMascaraDois(
			LayoutRegistroIdentificadorClienteCorrespondenciaTipoUm identificadorClienteCorrespondenciaTipoUm,
			List<MascaraNotificacaoFinalizacaoCliente> mascaraNotificacao) {

		Set<ConstraintViolation<LayoutRegistroIdentificadorClienteCorrespondenciaTipoUm>> violations = validator
				.validate(identificadorClienteCorrespondenciaTipoUm);

		for (ConstraintViolation<LayoutRegistroIdentificadorClienteCorrespondenciaTipoUm> violation : violations) {

			log.error("Erros no preenchimento do DTO " + violation.getMessage());
		}

		String fileName = getPathDosArquivosTxt() + "/" + NOME_ARQUIVO_SAIDA_MASCARA_02 + now.getYear()
				+ now.getMonthValue() + now.getDayOfMonth() + ".txt";

		System.out.println("fileName " + fileName);
		String tipoRegistro = StringUtils
				.rightPad(identificadorClienteCorrespondenciaTipoUm.getTipoRegistro().toString(), 1);
		String nome = StringUtils.rightPad(identificadorClienteCorrespondenciaTipoUm.getNome(), 80, ESPACAMENTO);
		String endereco = StringUtils.rightPad(identificadorClienteCorrespondenciaTipoUm.getEndereco(), 60,
				ESPACAMENTO);
		String complemento = StringUtils.rightPad(identificadorClienteCorrespondenciaTipoUm.getComplemento(), 80,
				ESPACAMENTO);
		String bairro = StringUtils.rightPad(identificadorClienteCorrespondenciaTipoUm.getBairro(), 20, ESPACAMENTO);
		String cep = StringUtils.rightPad(identificadorClienteCorrespondenciaTipoUm.getCep(), 8, ESPACAMENTO);
		String cidade = StringUtils.rightPad(identificadorClienteCorrespondenciaTipoUm.getCidade(), 20, ESPACAMENTO);
		String uf = StringUtils.rightPad(identificadorClienteCorrespondenciaTipoUm.getUf(), 2);
		String cpfCnpjPisNis = StringUtils.rightPad(identificadorClienteCorrespondenciaTipoUm.getCpfCnpjPisNis(), 14,
				ESPACAMENTO);
		String contrato = StringUtils.rightPad(identificadorClienteCorrespondenciaTipoUm.getContrato(), 20,
				ESPACAMENTO);

		String dadosCorrespondencia = montaCorpoDocumentoMascaraFinalziacaoCliente(mascaraNotificacao);

		String cif = StringUtils.rightPad(identificadorClienteCorrespondenciaTipoUm.getCif(), 20, ESPACAMENTO);

		try {
			FileWriter writer = new FileWriter(fileName);

			writer.append(tipoRegistro);
			writer.append(nome);
			writer.append(endereco);
			writer.append(complemento);
			writer.append(bairro);
			writer.append(cep);
			writer.append(cidade);
			writer.append(uf);
			writer.append(cpfCnpjPisNis);
			writer.append(contrato);
			writer.append(dadosCorrespondencia);
			writer.append(cif);

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void geraTxtParaRegistroTotalizadorDoArquivoTipoNove(LayoutRegistroTotatilizadorArquivoTipoNove registro)
			throws NoSuchAlgorithmException {

		Set<ConstraintViolation<LayoutRegistroTotatilizadorArquivoTipoNove>> violations = validator.validate(registro);

		for (ConstraintViolation<LayoutRegistroTotatilizadorArquivoTipoNove> violation : violations) {

			log.error("Erros no preenchimento do DTO " + violation.getMessage());

		}

		String fileName = getPathDosArquivosTxt() + "/" + NOME_ARQUIVO_SAIDA_MASCARA_01 + now.getYear()
				+ now.getMonthValue() + now.getDayOfMonth() + ".txt";

		String tipoRegistro = StringUtils.rightPad(registro.getTipoRegistro().toString(), 1);
		String quantidadeTipoRegistro = StringUtils.rightPad(registro.getQuantidadeTipoRegistro(), 6, ESPACAMENTO);
		String quantidadeTotalRegistros = StringUtils.rightPad(registro.getQuantidadeTotalRegistros(), 6, ESPACAMENTO);
		String filler = StringUtils.rightPad(registro.getFiller(), 4987, ESPACAMENTO);

		try {
			FileWriter writer = new FileWriter(fileName);
			writer.append(tipoRegistro);
			writer.append(quantidadeTipoRegistro);
			writer.append(quantidadeTotalRegistros);
			writer.append(filler);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getPathDosArquivosTxt() {

		Properties properties = new Properties();
		String propertie = "file.txt.path";

		try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {

			properties.load(input);

			return properties.getProperty(propertie);

		} catch (Exception e) {
			log.error("ERRO ao buscar arquivo de propriedades");
		}

		return null;
	}

	private String montaCorpoDocumentoMascaraNotificacao(List<MascaraNotificacao> _) {

		log.info("Tamanho da lista de documentos " + _.size());

		List<String> b = new ArrayList<String>();

		for (MascaraNotificacao mascaraNotificacao : _) {

			StringBuilder builder = new StringBuilder();

			String diaMesCorrente = StringUtils.rightPad(mascaraNotificacao.getDiaMesCorrente().toString(), 2,
					ESPACAMENTO);
			String mesCorrente = StringUtils.rightPad(mascaraNotificacao.getMesCorrente(), 9, ESPACAMENTO);
			String anoCorrente = StringUtils.rightPad(mascaraNotificacao.getAnoMesCorrente(), 4, ESPACAMENTO);
			String numeroDemanadaSISAQ = StringUtils.rightPad(mascaraNotificacao.getNumeroDemandaSISAQ(), 7,
					ESPACAMENTO);
			String sigalUnidadeOperacional = StringUtils.rightPad(mascaraNotificacao.getSiglaUnidadeOperacional(), 8,
					ESPACAMENTO);
			String dataRegistro = StringUtils.rightPad(mascaraNotificacao.getDataRegistro(), 15, ESPACAMENTO);
			String cpfConstrutora = StringUtils.rightPad(mascaraNotificacao.getCpfConstrutora(), 14, ESPACAMENTO);
			String nomeConstrutora = StringUtils.rightPad(mascaraNotificacao.getNomeConstrutora(), 50, ESPACAMENTO);
			String cpfRt = StringUtils.rightPad(mascaraNotificacao.getCpfRt(), 14, ESPACAMENTO);
			String nomeRt = StringUtils.rightPad(mascaraNotificacao.getNomeRt(), 50, ESPACAMENTO);
			String cpfRepresentates = StringUtils.rightPad(mascaraNotificacao.getCpfRepresentantes(), 14, ESPACAMENTO);
			String nomeRepresentantes = StringUtils.rightPad(mascaraNotificacao.getNomeRepresentantes(), 50,
					ESPACAMENTO);
			String _cpfRepresentates = StringUtils.rightPad(mascaraNotificacao.getCpfRepresentantes(), 14, ESPACAMENTO);
			String _nomeRepresentantes = StringUtils.rightPad(mascaraNotificacao.getNomeRepresentantes(), 50,
					ESPACAMENTO);
			String enderecoImovelReclamado = StringUtils.rightPad(mascaraNotificacao.getEnderecoImovelReclamado(), 120,
					ESPACAMENTO);

			String cpfCliente = StringUtils.rightPad(mascaraNotificacao.getCpfCliente(), 11, ESPACAMENTO);
			String nomeCliente = StringUtils.rightPad(mascaraNotificacao.getNomeCliente(), 50, ESPACAMENTO);
			String telefonesCliente = StringUtils.rightPad(mascaraNotificacao.getTelefoneCliente(), 154, ESPACAMENTO);
			String emailCliente = StringUtils.rightPad(mascaraNotificacao.getEmailCliente(), 154, ESPACAMENTO);
			String manifesto = StringUtils.rightPad(mascaraNotificacao.getManifesto(), 2300, ESPACAMENTO);
			String toekAcesso = StringUtils.rightPad(mascaraNotificacao.getTokenAcesso(), 32, ESPACAMENTO);
			String emailUnidadeResponsavel = StringUtils.rightPad(mascaraNotificacao.getEmailUnidadeResponsavel(), 50,
					ESPACAMENTO);

			builder.append(diaMesCorrente);
			builder.append(mesCorrente);
			builder.append(anoCorrente);
			builder.append(numeroDemanadaSISAQ);
			builder.append(sigalUnidadeOperacional);
			builder.append(dataRegistro);
			builder.append(cpfConstrutora);
			builder.append(nomeConstrutora);
			builder.append(cpfRt);
			builder.append(nomeRt);
			builder.append(cpfRepresentates);
			builder.append(nomeRepresentantes);
			builder.append(nomeRepresentantes);
			builder.append(_cpfRepresentates);
			builder.append(_nomeRepresentantes);
			builder.append(enderecoImovelReclamado);
			builder.append(cpfCliente);
			builder.append(nomeCliente);
			builder.append(telefonesCliente);
			builder.append(emailCliente);
			builder.append(manifesto);
			builder.append(toekAcesso);
			builder.append(emailUnidadeResponsavel);

			b.add(builder.toString());
		}

		return b.toString();
	}

	private String montaCorpoDocumentoMascaraFinalziacaoCliente(List<MascaraNotificacaoFinalizacaoCliente> _) {

		log.info("Tamanho da lista de documentos " + _.size());

		List<String> b = new ArrayList<String>();

		for (MascaraNotificacaoFinalizacaoCliente mascaraNotificacao : _) {

			StringBuilder builder = new StringBuilder();

			String diaMesCorrente = StringUtils.rightPad(mascaraNotificacao.getDiaMesCorrente().toString(), 2,
					ESPACAMENTO);
			String mesCorrente = StringUtils.rightPad(mascaraNotificacao.getMesCorrente(), 9, ESPACAMENTO);
			String anoCorrente = StringUtils.rightPad(mascaraNotificacao.getAnoMesCorrente(), 4, ESPACAMENTO);
			String numeroDemandaSIUV = StringUtils.rightPad(mascaraNotificacao.getNumeroDemandaSIUV(), 7, ESPACAMENTO);

			String nomeCliente = StringUtils.rightPad(mascaraNotificacao.getNomeCliente(), 50, ESPACAMENTO);
			String textoAcao = StringUtils.rightPad(mascaraNotificacao.getTextoAcao(), 154, ESPACAMENTO);

			builder.append(diaMesCorrente);
			builder.append(mesCorrente);
			builder.append(anoCorrente);
			builder.append(numeroDemandaSIUV);
			builder.append(nomeCliente);
			builder.append(textoAcao);

			b.add(builder.toString());
		}

		return b.toString();
	}

	private String montaCorpoDocumentoMascaraInicialCliente(List<MascaraIncialCliente> _) {

		log.info("Tamanho da lista de documentos " + _.size());

		List<String> b = new ArrayList<String>();

		for (MascaraIncialCliente mascaraNotificacao : _) {

			StringBuilder builder = new StringBuilder();

			String diaMesCorrente = StringUtils.rightPad(mascaraNotificacao.getDiaMesCorrente().toString(), 2,
					ESPACAMENTO);
			String mesCorrente = StringUtils.rightPad(mascaraNotificacao.getMesCorrente(), 9, ESPACAMENTO);
			String anoCorrente = StringUtils.rightPad(mascaraNotificacao.getAnoMesCorrente(), 4, ESPACAMENTO);
			String numeroDemandaSIUOV = StringUtils.rightPad(mascaraNotificacao.getNumeroDemandaSiouv(), 7,
					ESPACAMENTO);

			String nomeCliente = StringUtils.rightPad(mascaraNotificacao.getNomeCliente(), 50, ESPACAMENTO);
			String dataRegistro = StringUtils.rightPad(mascaraNotificacao.getDataRegistro(), 154, ESPACAMENTO);
			String nomeConstrutora = StringUtils.rightPad(mascaraNotificacao.getNomeConstrutora(), 154, ESPACAMENTO);

			builder.append(diaMesCorrente);
			builder.append(mesCorrente);
			builder.append(anoCorrente);
			builder.append(numeroDemandaSIUOV);
			builder.append(nomeCliente);
			builder.append(dataRegistro);
			builder.append(nomeConstrutora);

			b.add(builder.toString());
		}

		return b.toString();
	}
}
