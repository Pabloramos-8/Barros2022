package com.example.barros.rest;

import com.example.barros.exception.ClienteNotFoundException;
import com.example.barros.exception.NotPageException;
import com.example.barros.model.Cliente;
import com.example.barros.service.ClienteService;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteREST {

    @Autowired
    private ClienteService clienteService;

    @CrossOrigin("http://localhost:4200")
    @GetMapping(path="getClientes")
    public List<Cliente> getClientes(@PageableDefault(size=10, page = 0)
                                             Pageable pageable, @SearchSpec Specification<Cliente> specs) {

        Page<Cliente> response;
        response=clienteService.getClientes(pageable,specs);
        if ( pageable.getPageNumber() > response.getTotalPages()) {
            throw new NotPageException();
        }

        return response.getContent();
    }


    @CrossOrigin("http://localhost:4200")
    @PostMapping
    private ResponseEntity<Cliente> saveCliente (@RequestBody Cliente cliente){
        Cliente addedCliente = clienteService.addCliente(cliente);
        return new ResponseEntity<>(addedCliente, HttpStatus.OK);
    }


    @CrossOrigin("http://localhost:4200")
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> modifyCliente(@PathVariable Long id, @RequestBody Cliente
            newCliente) {
        Cliente addedCliente = clienteService.modifyCliente(id, newCliente);
        return new ResponseEntity<>(addedCliente, HttpStatus.OK);
    }

    @CrossOrigin("http://localhost:4200")
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id).orElseThrow(() -> new
                ClienteNotFoundException(id));
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

}