package com.raffi_estoque.mapper;

import com.raffi_estoque.dto.*;
import com.raffi_estoque.entities.Produto;
import com.raffi_estoque.entities.Venda;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component()
public interface VendaMepper {

    VendaMepper INSTANCE = Mappers.getMapper(VendaMepper.class);

    VendaResponseDto toVendaResponseDto(Venda venda);

    Venda toVenda(VendaCreateDto vendaCreateDto);

    List<VendaResponseDto> toListResponseDto(List<Venda> venda);

    Venda toVenda(VendaUpdateDto updateDto);

    VendaUpdateDto toUpdate(Venda venda);
}
