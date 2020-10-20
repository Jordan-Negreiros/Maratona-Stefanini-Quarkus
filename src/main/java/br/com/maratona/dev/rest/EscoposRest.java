package br.com.maratona.dev.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.maratona.dev.service.EscoposService;

/**
 * Requisição usada na explicação sobre as diferenças
 * entre ApplicationScoped e RequestScoped
 * @author jordan negreiros
 *
 */
@Path("escopo")
public class EscoposRest {

	@Inject EscoposService escoposService;
	
	@GET
	@Path("/{nome}")
	public Response adicionarList(@PathParam("nome") String nome) {
		escoposService.adicionar(nome);
		return Response
				.status(Status.CREATED)
				.entity(escoposService.listar())
				.build();
	}
	
}
