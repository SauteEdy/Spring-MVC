package com.example.clientes.clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
