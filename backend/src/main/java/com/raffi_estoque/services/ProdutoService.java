package com.raffi_estoque.services;

import com.raffi_estoque.entities.Fornecedor;
import com.raffi_estoque.entities.Produto;
import com.raffi_estoque.repositories.FornecedorRepository;
import com.raffi_estoque.repositories.ProdutoRepository;
import com.raffi_estoque.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Transactional
    public Produto save(Produto produto){

        if (produto.getFornecedor() == null) {
            throw new RuntimeException("Fornecedor não pode ser nulo.");
        }

        int codFornecedor = produto.getFornecedor().getCodFornecedor();

        Optional<Fornecedor> fornecedorOptional = fornecedorRepository.findById(codFornecedor);

        if (fornecedorOptional.isEmpty()) {
            throw new ObjectNotFoundException("Fornecedor com código " + codFornecedor + " não encontrado.");
        }

        return produtoRepository.save(produto);
    }

    @Transactional
    public Produto findById(Integer id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElseThrow(() -> new ObjectNotFoundException("Produto Não Encontrado"));
    }

    @Transactional
    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    @Transactional
    public Produto update(Integer id, Produto produto){
        Produto produtoUpd = findById(id);
        produtoUpd.setNomeProduto(produto.getNomeProduto());
        produtoUpd.setUnidadeMedida(produto.getUnidadeMedida());
        produtoUpd.setValorCusto(produto.getValorCusto());
        produtoUpd.setValorVenda(produto.getValorVenda());
        produtoUpd.setEstoqueAtual(produto.getEstoqueAtual());
        produtoUpd.setEstoqueMinimo(produto.getEstoqueMinimo());
        produtoUpd.setAvisoRepor(produto.isAvisoRepor());
        return produtoRepository.save(produtoUpd);
    }

    @Transactional
    public void deleteById(Integer id) {
        Optional<Produto> event = produtoRepository.findById(id);

        produtoRepository.deleteById(id);
    }
}
