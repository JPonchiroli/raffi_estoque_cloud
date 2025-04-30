package com.raffi_estoque.controllers;

import com.raffi_estoque.services.EventService;
import com.raffi_estoque.mapper.ClienteMapper;
import com.raffi_estoque.dto.ViaCepResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private ClienteMapper mapper;
    /*
        @PostMapping("/create-event")
        public ResponseEntity<EventResponseDto> createEvent(@RequestBody @Valid EventCreateDto event) {
            Event eventCreated = mapper.toEvent(event);
            ViaCepResponse address = getAddress(event.getCep());

            eventCreated.setStreet(address.getLogradouro());
            eventCreated.setNeighborhood(address.getBairro());
            eventCreated.setCity(address.getLocalidade());
            eventCreated.setState(address.getEstado());

            eventCreated.setFloorPriceUSD(event.getFloorPriceBRL() * 5);
            eventCreated.setVipAreaPriceUSD(event.getVipAreaPriceBRL() * 5);

            eventService.save(eventCreated);
            return ResponseEntity.status(201).body(mapper.toEventResponseDto(eventCreated));
        }

        @GetMapping("/get-event/{id}")
        public ResponseEntity<EventResponseDto> findById(@PathVariable("id") Long id){
            Event event = eventService.findById(id);
            return ResponseEntity.ok().body(mapper.toEventResponseDto(event));
        }

        @GetMapping("/get-all-events")
        public ResponseEntity<List<EventResponseDto>> findAll(){
            List<Event> events = eventService.findAll();
            return ResponseEntity.ok().body(mapper.toListResponseDto(events));
        }

        @GetMapping("/get-all-events/sorted")
        public ResponseEntity<List<EventResponseDto>> findAllSorted(){
            List<Event> events = eventService.findAll();
            events.sort(Comparator.comparing(Event::getEventName));
            return ResponseEntity.ok().body(mapper.toListResponseDto(events));
        }

        @PutMapping("/update-event/{id}")
        public ResponseEntity<EventUpdateDto> updateEvent(@PathVariable Long id, @RequestBody @Valid EventUpdateDto updateDto){
            Event event = eventService.update(id, mapper.toEvent(updateDto));
            return ResponseEntity.ok(mapper.toUpdateDto(event));
        }
    */
    @GetMapping("/get-address/{cep}")
    public ViaCepResponse getAddress(@PathVariable String cep) {
        return eventService.getAddress(cep);
    }

}