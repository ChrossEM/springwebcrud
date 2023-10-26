package com.excer.webcrud.models.dao;

import com.excer.webcrud.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface IClienteDao extends PagingAndSortingRepository<Cliente,Long>,CrudRepository<Cliente, Long>{


}
