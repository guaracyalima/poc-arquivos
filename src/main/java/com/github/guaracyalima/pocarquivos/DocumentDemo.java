package com.github.guaracyalima.pocarquivos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.github.guaracyalima.pocarquivos.dto.MascaraIncialCliente;
import com.github.guaracyalima.pocarquivos.dto.MascaraNotificacao;
import com.github.guaracyalima.pocarquivos.dto.MascaraNotificacaoFinalizacaoCliente;

public class DocumentDemo {

	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private Validator validator = factory.getValidator();
	
	public void atualizarDocumentoMascaraNotificacao
	(
			String input, 
			String output, 
			MascaraNotificacao mascaraNotificacao) throws IOException {

		try (XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(input)))) {

			List<XWPFParagraph> xwpfParagraphList = doc.getParagraphs();
			
			for (XWPFParagraph xwpfParagraph : xwpfParagraphList) {
				
				for (XWPFRun xwpfRun : xwpfParagraph.getRuns()) {
					
					String docText = xwpfRun.getText(0);
					
					if (docText == null) {
						continue;
					}
										
					docText = docText.replace("VAR1", mascaraNotificacao.getDiaMesCorrente());
					docText = docText.replace("VAR2", mascaraNotificacao.getMesCorrente());
					docText = docText.replace("VAR3", mascaraNotificacao.getAnoMesCorrente());
					docText = docText.replace("VAR4", mascaraNotificacao.getNumeroDemandaSISAQ());
					docText = docText.replace("VAR5", mascaraNotificacao.getSiglaUnidadeOperacional());
					docText = docText.replace("VAR6", mascaraNotificacao.getAnoMesCorrente());
					docText = docText.replace("VAR7", mascaraNotificacao.getNumeroDemandaSISAQ());
					docText = docText.replace("VAR8", mascaraNotificacao.getDataRegistro());
					docText = docText.replace("VAR9", mascaraNotificacao.getCpfConstrutora());
					docText = docText.replace("VAR10", mascaraNotificacao.getNomeConstrutora());
					docText = docText.replace("VAR11", mascaraNotificacao.getCpfRt());
					docText = docText.replace("VAR12", mascaraNotificacao.getNomeRt());
					docText = docText.replace("VAR13", mascaraNotificacao.getEnderecoImovelReclamado());
					docText = docText.replace("${CPF}", mascaraNotificacao.getCpfCliente());
					docText = docText.replace("VAR15", mascaraNotificacao.getNomeCliente());
					docText = docText.replace("VAR16", mascaraNotificacao.getTelefoneCliente());
					docText = docText.replace("${CPF}", mascaraNotificacao.getEmailCliente());
					docText = docText.replace("VAR18", mascaraNotificacao.getManifesto());
					docText = docText.replace("VAR19", mascaraNotificacao.getTokenAcesso());
					docText = docText.replace("${EMAIL}", mascaraNotificacao.getEmailUnidadeResponsavel());
					
					xwpfRun.setText(docText, 0);
				
				}
			}

			try (FileOutputStream out = new FileOutputStream(output)) {
				doc.write(out);
			}

		}
	}
	
	public void atualizarDocumentoMascaraFinalizacaoCliente(
			String input, 
			String output, 
			MascaraNotificacaoFinalizacaoCliente mascaraNotificacaoFinalizacaoCliente) throws IOException {

		try (XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(input)))) {

			List<XWPFParagraph> xwpfParagraphList = doc.getParagraphs();
			
			for (XWPFParagraph xwpfParagraph : xwpfParagraphList) {
				
				for (XWPFRun xwpfRun : xwpfParagraph.getRuns()) {
					
					String docText = xwpfRun.getText(0);
					
					if (docText == null) {
						continue;
					}
										
					docText = docText.replace("VAR1", mascaraNotificacaoFinalizacaoCliente.getDiaMesCorrente());
					docText = docText.replace("VAR2", mascaraNotificacaoFinalizacaoCliente.getMesCorrente());
					docText = docText.replace("VAR3", mascaraNotificacaoFinalizacaoCliente.getAnoMesCorrente());
					docText = docText.replace("VAR4", mascaraNotificacaoFinalizacaoCliente.getNumeroDemandaSIUV());
					docText = docText.replace("VAR5", mascaraNotificacaoFinalizacaoCliente.getNomeCliente());
					docText = docText.replace("VAR6", mascaraNotificacaoFinalizacaoCliente.getNumeroDemandaSIUV());
					docText = docText.replace("VAR7", mascaraNotificacaoFinalizacaoCliente.getTextoAcao());
					xwpfRun.setText(docText, 0);
				}
			}

			try (FileOutputStream out = new FileOutputStream(output)) {
				doc.write(out);
			}

		}
	}
	
	public void atualizarDocumentoMascaraInicialCliente
	(
			String input, 
			String output, 
			MascaraIncialCliente mascaraIncialCliente) throws IOException {
		Set<ConstraintViolation<MascaraIncialCliente>> violations = validator.validate(mascaraIncialCliente);
		for (ConstraintViolation<MascaraIncialCliente> violation : violations) {
		    System.out.println("Deu PAU IN " + violation.getMessage());
		}
		
		try (XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(input)))) {

			List<XWPFParagraph> xwpfParagraphList = doc.getParagraphs();
			
			for (XWPFParagraph xwpfParagraph : xwpfParagraphList) {
				
				for (XWPFRun xwpfRun : xwpfParagraph.getRuns()) {
					
					String docText = xwpfRun.getText(0);
					
					if (docText == null) {
						continue;
					}
										
					docText = docText.replace("VAR1", mascaraIncialCliente.getDiaMesCorrente());
					docText = docText.replace("VAR2", mascaraIncialCliente.getMesCorrente());
					docText = docText.replace("VAR3", mascaraIncialCliente.getAnoMesCorrente());
					docText = docText.replace("VAR4", mascaraIncialCliente.getNumeroDemandaSiouv());
					docText = docText.replace("VAR5", mascaraIncialCliente.getNomeCliente());
					docText = docText.replace("VAR6", mascaraIncialCliente.getNumeroDemandaSiouv());
					docText = docText.replace("VAR7", mascaraIncialCliente.getDataRegistro());
					docText = docText.replace("VAR8", mascaraIncialCliente.getNomeConstrutora());
					xwpfRun.setText(docText, 0);
				}
			}

			try (FileOutputStream out = new FileOutputStream(output)) {
				doc.write(out);
			}

		}
	}
}
