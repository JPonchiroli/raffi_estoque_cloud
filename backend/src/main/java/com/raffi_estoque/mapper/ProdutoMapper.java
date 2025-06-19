package com.raffi_estoque.mapper;

import com.raffi_estoque.dto.produto.ProdutoCreateDto;
import com.raffi_estoque.dto.produto.ProdutoResponseDto;
import com.raffi_estoque.dto.produto.ProdutoUpdateDto;
import com.raffi_estoque.entities.Produto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component()
public interface ProdutoMapper {
    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    @Mapping(source = "fornecedor.codFornecedor", target = "codFornecedor")
    ProdutoResponseDto toProdutoResponseDto(Produto cliente);

    @InheritInverseConfiguration
    @Mapping(target = "fornecedor", ignore = true)
    Produto toProduto(ProdutoCreateDto clienteCreateDto);

    @Mapping(source = "fornecedor.codFornecedor", target = "codFornecedor")
    List<ProdutoResponseDto> toListResponseDto(List<Produto> cliente);

    Produto toProduto(ProdutoUpdateDto updateDto);

    ProdutoUpdateDto toUpdate(Produto cliente);
}