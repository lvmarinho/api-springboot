package com.api.produto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.produto.model.ProdutoModel;

public interface ProdutoRepository extends CrudRepository<ProdutoModel, Integer>{

	//listar produtos
	List<ProdutoModel> findAll ();
	
	//pesquisar por codigo
	ProdutoModel findByCodigo(int codigo);
	
	//remover produto
	void delete(ProdutoModel produto);
	
	//cadastrar/alterar produto
	<ProdMod extends ProdutoModel> ProdMod save (ProdMod produto);
	
	
	
}
