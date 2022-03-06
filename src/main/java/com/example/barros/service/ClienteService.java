package com.example.barros.service;


import com.example.barros.exception.ClienteNotFoundException;
import com.example.barros.model.Cliente;
import com.example.barros.repository.ClienteRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteService extends BaseService<Cliente, Long, ClienteRepository> {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente addCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente modifyCliente(Long id, Cliente newCliente) throws ClienteNotFoundException {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new
                ClienteNotFoundException(id));
        newCliente.setIdCliente(cliente.getIdCliente());
        return clienteRepository.save(newCliente);
    }

    public void deleteCliente(Long id) throws ClienteNotFoundException {
       clienteRepository.findById(id).orElseThrow(() -> new ClienteNotFoundException(id));
        clienteRepository.deleteById(id);
    }

    public Page<Cliente> getClientes(Pageable pageable, @SearchSpec
            Specification<Cliente> specs){
        return clienteRepository.findAll(pageable);
    }




}
