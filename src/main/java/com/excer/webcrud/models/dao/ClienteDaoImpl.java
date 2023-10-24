package com.excer.webcrud.models.dao;

import com.excer.webcrud.models.entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteDaoImpl implements IClienteDao{
    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Cliente> findAll() {
        return null;
    }

    @Override
    public void save(Cliente cliente) {

    }

    @Override
    public Cliente findOne(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
