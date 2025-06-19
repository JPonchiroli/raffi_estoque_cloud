package com.raffi_estoque.dto.produto;

import com.raffi_estoque.entities.Produto;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapperHelper {

    @Named("produtoFromId")
    public Produto mapIdToProduto(Integer codProduto) {
        Produto p = new Produto();
        p.setCodProduto(codProduto);
        return p;
    }
}