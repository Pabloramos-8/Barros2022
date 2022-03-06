package com.example.barros.service;

import com.example.barros.exception.EventoNotFoundException;
import com.example.barros.model.Cliente;
import com.example.barros.model.Evento;
import com.example.barros.model.Evento;
import com.example.barros.repository.EventoRepository;
import com.example.barros.repository.EventoRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class EventoService extends BaseService<Evento, Long, EventoRepository> {

   private EventoRepository eventoRepository;

   public Evento addEvento(Evento evento) {
      return eventoRepository.save(evento);
   }

   public Evento modifyEvento(Long id, Evento newEvento) throws EventoNotFoundException {
      Evento evento = eventoRepository.findById(id).orElseThrow(() -> new
              EventoNotFoundException(id));
      newEvento.setIdEvento(evento.getIdEvento());
      return eventoRepository.save(newEvento);
   }

   public void deleteEvento(Long id) throws EventoNotFoundException {
      eventoRepository.findById(id).orElseThrow(() -> new EventoNotFoundException(id));
      eventoRepository.deleteById(id);
   }

   public Page<Evento> getEventos(Pageable pageable, @SearchSpec
           Specification<Evento> specs){
      return eventoRepository.findAll(pageable);
   }
}
