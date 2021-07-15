package com.github.guaracyalima.pocarquivos.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.guaracyalima.pocarquivos.helpers.DtoHelper;
import com.github.guaracyalima.pocarquivos.services.DocumentService;

@Path("/docs")
public class DocumentResource {

	@GET
	@Path("/t1")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response gerarDocumentosMascaraUm () {
		new DocumentService()
				.geraTxtTabuladoParaRegistroIdentificadorDoClienteECorrespondenciaTipoUmMascaraUm(
						new DtoHelper().layoutUm(), new DtoHelper().listaMascaraUm());
		
		return Response.ok("pong").status(200).build();
	}
}
