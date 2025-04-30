package com.raffi_estoque.services;

import com.raffi_estoque.dto.ViaCepResponse;
import com.raffi_estoque.feign.ViaCepClient;
import com.raffi_estoque.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ViaCepClient viaCepclient;
/*
    @Transactional
    public Event save(Event event){
        return eventRepository.save(event);
    }

    @Transactional
    public Event findById(Long id){
        Optional<Event> event = eventRepository.findById(id);
        return event.orElseThrow(() -> new ObjectNotFoundException("Event Not Found"));
    }

    @Transactional
    public List<Event> findAll(){
        return eventRepository.findAll();
    }

    @Transactional
    public Event update(Long id, Event event){
        Event eventUpd = findById(id);
        eventUpd.setEventName(event.getEventName());
        eventUpd.setDateTime(event.getDateTime());
        return eventRepository.save(eventUpd);
    }

    @Transactional
    public void deleteById(Long id) {
        Optional<Event> event = eventRepository.findById(id);

        eventRepository.deleteById(id);
    }

 */

    public ViaCepResponse getAddress(String cep) {
        return viaCepclient.getAddress(cep);
    }


}
