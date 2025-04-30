package com.raffi_estoque.mapper;

import com.raffi_estoque.dto.EventResponseDto;
import com.raffi_estoque.dto.EventCreateDto;
import com.raffi_estoque.dto.EventUpdateDto;

import com.raffi_estoque.entities.Cliente;
import org.springframework.stereotype.Component;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
@Component()
public interface ClienteMapper {
    /*
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteResponseDto toEventResponseDto(Cliente event);

    Cliente toEvent(EventCreateDto eventCreateDto);

    List<EventResponseDto> toListResponseDto(List<Event> event);

    Cliente toEvent(EventUpdateDto updateDto);

    EventUpdateDto toUpdateDto(Cliente event);
    */

}