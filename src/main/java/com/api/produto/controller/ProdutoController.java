package com.api.produto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.produto.model.ProdutoModel;
import com.api.produto.model.RespostaModel;
import com.api.produto.repository.ProdutoRepository;

@RestController
@RequestMapping("/api")
public class ProdutoController {

	// ações
	@Autowired
	private ProdutoRepository acoes;

	// Listar Produtos
	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public @ResponseBody List<ProdutoModel> listar() {
		return acoes.findAll();
	}

	// Cadastrar Produtos
	@RequestMapping(value = "/produtos", method = RequestMethod.POST)
	public @ResponseBody ProdutoModel cadastrar(@RequestBody ProdutoModel produto) {
		return acoes.save(produto);
	}

	// Filtrar Produtos
	@RequestMapping(value = "/produtos/{codigo}", method = RequestMethod.GET)
	public @ResponseBody ProdutoModel filtrar(@PathVariable Integer codigo) {
		return acoes.findByCodigo(codigo);
	}

	// Alterar Produto
	@RequestMapping(value = "/produtos", method = RequestMethod.PUT)
	public @ResponseBody ProdutoModel alterar(@RequestBody ProdutoModel produto) {
		return acoes.save(produto);

	}

	// Deletar produto
	@RequestMapping(value = "/produtos/{codigo}", method = RequestMethod.DELETE)
	public @ResponseBody RespostaModel deletar(@PathVariable Integer codigo) {
		RespostaModel resposta = new RespostaModel();

		try {
			ProdutoModel produto = filtrar(codigo);
			this.acoes.delete(produto);
			resposta.setMensagem("produto removido com sucesso!!");

		} catch (Exception e) {
			resposta.setMensagem("falha ao deletar produto: " + e.getMessage());
		}

		return resposta;

	}

}