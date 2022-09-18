package org.acme.rest;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Id;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.ProdutoModel.ProdutoModel;
import org.acme.dto.ProdutoDto;
import org.acme.service.ProdutoService;

@Path("/produto")
@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoRest {

    @Inject ProdutoService produtoService;


    @GET
    public List<ProdutoDto> listarTodosProdutos() {
    return produtoService.listarTodos();
    
    }

    @GET
    @Path("/{id}")
    public ProdutoDto consultarPorId(@PathParam("id") long id) {
    return produtoService.consultarPorId(id);
     
}
    
    @POST
    @Transactional    
    public Response criarNovoProduto(ProdutoDto produtoDto) {
        produtoService.criarNovoProduto(produtoDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response atualizarProduto(@PathParam("id") Long id, ProdutoDto produtoDto) {
        produtoService.atualizarProduto(id, produtoDto);
        return Response.status(Response.Status.NO_CONTENT).build();

    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deletarProduto(@PathParam("id") Long id) {
        produtoService.deletarProduto(id);
        return Response.status(Response.Status.NO_CONTENT).build();
        
    }
}
