package com.example.clientes.clientes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.clientes.clientes.model.Cliente;
import com.example.clientes.clientes.repository.ClienteRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
    
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping()
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");

        modelAndView.addObject("home", "Ola mundo");
        return modelAndView;
    }

    @GetMapping("/listar")
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("cliente/listar");

        List<Cliente> clientes = clienteRepository.findAll();

        modelAndView.addObject("clientes", clientes);
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(){
        ModelAndView modelAndView = new ModelAndView("cliente/cadastrar");

        modelAndView.addObject("cliente", new Cliente());
        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Cliente cliente){
        
        clienteRepository.save(cliente);

        return "redirect:/home/listar";
    }

    @GetMapping("/{id}/cliente")
    public ModelAndView clienteId(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("cliente/clienteId");

        Optional<Cliente> cliente = clienteRepository.findById(id);
        modelAndView.addObject("cliente",cliente.get());
        return modelAndView;
    }

    @GetMapping("/{id}/cliente/editar")
    public ModelAndView editarCliente(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("cliente/editar");

        Optional<Cliente> cliente = clienteRepository.findById(id);
        modelAndView.addObject("cliente",cliente.get());
        return modelAndView;
    }
    @PostMapping("/cliente/editar")
    public String editarCliente(Cliente cliente){
        
        clienteRepository.save(cliente);

        return "redirect:/home/listar";
    }

    @GetMapping("/{id}/cliente/apagar")
    public String apagarCliente(@PathVariable Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        clienteRepository.delete(cliente.get());

        return "redirect:/home/listar";
    }
}
