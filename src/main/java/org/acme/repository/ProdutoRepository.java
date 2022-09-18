package org.acme.repository;

import javax.enterprise.context.ApplicationScoped;

import org.acme.ProdutoModel.ProdutoModel;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<ProdutoModel> {
    
}
