package com.raffi_estoque.mapper;

import com.raffi_estoque.dto.*;
import com.raffi_estoque.entities.ItemVenda;
import com.raffi_estoque.entities.Venda;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProdutoMapperHelper.class)
@Component()
public interface VendaMapper {

    @Mapping(target = "itens", source = "itens")
    VendaResponseDto toVendaResponseDto(Venda venda);

    @Mapping(target = "produto", source = "codProduto", qualifiedByName = "produtoFromId")
    ItemVenda toItemVenda(ItemVendaCreateDto dto);

    @Mapping(target = "codProduto", source = "produto.codProduto")
    @Mapping(target = "nomeProduto", source = "produto.nomeProduto")
    @Mapping(target = "valorUnitario", source = "produto.valorVenda")
    @Mapping(target = "subTotal", source = ".", qualifiedByName = "calculateSubTotal")
    ItemVendaResponseDto toItemVendaResponseDto(ItemVenda item);

    Venda toVenda(VendaCreateDto vendaCreateDto);

    List<VendaResponseDto> toListResponseDto(List<Venda> venda);

    //Venda toVenda(VendaUpdateDto updateDto);

    ClienteUpdateDto toUpdate(Venda venda);

    @Named("calculateSubTotal")
    static double calculateSubTotal(ItemVenda item) {
        return item.getQuantidade() * item.getProduto().getValorVenda();
    }
}

