package com.excer.webcrud.controller;

import com.excer.webcrud.models.dao.IClienteDao;
import com.excer.webcrud.models.entity.Cliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
    @Autowired
    private IClienteDao clienteDao;
    @RequestMapping(value = "/listar",method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo","listado de clientes");
        model.addAttribute("clientes",clienteDao.findAll());
        return "listar";
    }
    @RequestMapping(value = "/form")
    public String crear(Map<String,Object> model) {
        Cliente cliente = new Cliente();
        model.put("cliente",cliente);
        model.put("titulo","Formulario de Cliente");
        return "form";
    }
    @RequestMapping(value = "/form/{id}")
    public String editar(@PathVariable(value="id") Long id, Map<String,Object> model){
        Cliente cliente = null;
        if (id > 0){
            cliente =clienteDao.findOne(id);
        } else {
            return "redirect:/listar";
        }
        model.put("cliente", cliente);
        model.put("tiutlo", "Editar Cliente");
        return "form";
    }
    @RequestMapping(value = "/form",method = RequestMethod.POST)
    public String guardar(@Valid Cliente cliente, BindingResult result,Model model, SessionStatus status ){
        if(result.hasErrors()){
            model.addAttribute("titulo", "Formulario de Cliente");
            return "form";
        }
        clienteDao.save(cliente);
        status.setComplete();
        return "redirect:listar";
    }
    @RequestMapping(value = "eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Long id){
        if(id > 0){
            clienteDao.delete(id);
        }
        return  "redirect:/listar";
    }
}