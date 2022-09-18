package org.acme.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.acme.ProdutoModel.ProdutoModel;
import org.acme.dto.ProdutoDto;
import org.acme.repository.ProdutoRepository;

@RequestScoped
public class ProdutoService {
    
    @Inject ProdutoRepository produtoRepository;

    public List<ProdutoDto> listarTodos() {
       List<ProdutoDto> produto = new ArrayList<>();
     produtoRepository.findAll().stream().forEach(item -> {
        produto.add(dto(item));
     });
        return produto;
    }

    public ProdutoDto consultarPorId(Long id) {
         return dto(produtoRepository.findById(id));     
              
     }

    public void criarNovoProduto(ProdutoDto produtoDto) {
        produtoRepository.persist(entidade(produtoDto));
    }

    public void atualizarProduto(Long id, ProdutoDto produtoDto) {
        ProdutoModel produtoModel = produtoRepository.findById(id);
        produtoModel.setNome(produtoDto.getNome());
        produtoModel.setDescricao(produtoDto.getDescricao());
        produtoModel.setCategoria(produtoDto.getCategoria());
        produtoModel.setPreco(produtoDto.getPreco());
        produtoModel.setModel(produtoDto.getModel());
        produtoRepository.persist(produtoModel);
    }


    public Response deletarProduto(Long id) {    
        ProdutoModel produto = produtoRepository.findById(id);    
       
        if (produto != null) {
        produtoRepository.deleteById(id);
        return Response.ok().build();        
    }
        return Response.status(Response.Status.NOT_FOUND).build();

       } 
    
    
    
    
    private ProdutoDto dto(ProdutoModel produtoModel) {
        ProdutoDto dto = new ProdutoDto();       
        dto.setNome(produtoModel.getNome());
        dto.setDescricao(produtoModel.getDescricao());
        dto.setCategoria(produtoModel.getCategoria());
        dto.setPreco(produtoModel.getPreco());
        dto.setModel(produtoModel.getModel());               
        
        return dto;
    }
    
    private ProdutoModel entidade(ProdutoDto produtoDto) {
        ProdutoModel produto = new ProdutoModel();
        produto.setNome(produtoDto.getNome());
        produto.setDescricao(produtoDto.getDescricao());
        produto.setCategoria(produtoDto.getCategoria());
        produto.setPreco(produtoDto.getPreco());
        produto.setModel(produtoDto.getModel());
        return produto;
     
    }
}
