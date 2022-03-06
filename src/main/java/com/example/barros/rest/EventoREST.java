package com.example.barros.rest;


import com.example.barros.exception.EventoNotFoundException;
import com.example.barros.exception.NotPageException;
import com.example.barros.model.Evento;
import com.example.barros.model.Evento;
import com.example.barros.service.EventoService;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoREST {

    @Autowired
    private EventoService eventoService;

    @CrossOrigin("http://localhost:4200")
    @GetMapping(path="getEventos")
    public List<Evento> getEventos(@PageableDefault(size=10, page = 0)
                                             Pageable pageable, @SearchSpec Specification<Evento> specs) {

        Page<Evento> response;
        response=eventoService.getEventos(pageable,specs);
        if ( pageable.getPageNumber() > response.getTotalPages()) {
            throw new NotPageException();
        }

        return response.getContent();
    }
    @CrossOrigin("http://localhost:4200")
    @PostMapping
    private ResponseEntity<Evento> saveEvento (@RequestBody Evento evento){
        try {
            Evento eventoGuardado = eventoService.save(evento);
            return ResponseEntity.created(new URI("/personas/"+eventoGuardado.getIdEvento())).body(eventoGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @CrossOrigin("http://localhost:4200")
    @PutMapping("/{id}")
    public ResponseEntity<Evento> modifyEvento(@PathVariable Long id, @RequestBody Evento
            newEvento) {
        Evento addedEvento = eventoService.modifyEvento(id, newEvento);
        return new ResponseEntity<>(addedEvento, HttpStatus.OK);
    }

    @CrossOrigin("http://localhost:4200")
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteEvento(@PathVariable Long id) {
        eventoService.deleteEvento(id);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }
    @CrossOrigin("http://localhost:4200")
    @GetMapping("{id}")
    public ResponseEntity<Evento> findById(@PathVariable Long id) {
        Evento evento = eventoService.findById(id).orElseThrow(() -> new
                EventoNotFoundException(id));
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }

}
