package com.raffi_estoque.mapper;

import com.raffi_estoque.dto.ClienteCreateDto;

import com.raffi_estoque.dto.ClienteResponseDto;
import com.raffi_estoque.entities.Cliente;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
@Component()
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteResponseDto toClienteResponseDto(Cliente cliente);

    @Mapping(source = "nomeCliente", target = "nomeCliente")
    Cliente toCliente(ClienteCreateDto clienteCreateDto);

    List<ClienteResponseDto> toListResponseDto(List<Cliente> cliente);
}