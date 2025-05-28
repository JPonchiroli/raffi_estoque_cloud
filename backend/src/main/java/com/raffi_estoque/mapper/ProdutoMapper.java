package com.raffi_estoque.mapper;

import com.raffi_estoque.dto.*;
import com.raffi_estoque.entities.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component()
public interface ProdutoMapper {
    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    ProdutoResponseDto toProdutoResponseDto(Produto cliente);

    Produto toProduto(ProdutoCreateDto clienteCreateDto);

    List<ProdutoResponseDto> toListResponseDto(List<Produto> cliente);

    Produto toProduto(ProdutoUpdateDto updateDto);

    ProdutoUpdateDto toUpdate(Produto cliente);
}