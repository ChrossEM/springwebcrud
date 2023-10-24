package com.excer.webcrud.models.dao;

import com.excer.webcrud.models.entity.Cliente;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface IClienteDao {
    public List<Cliente> findAll();
    public void save(Cliente cliente);
    public Cliente findOne(Long id);
    public void delete(Long id);
}
