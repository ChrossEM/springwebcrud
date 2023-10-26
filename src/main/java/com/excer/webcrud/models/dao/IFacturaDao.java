package com.excer.webcrud.models.dao;

import com.excer.webcrud.models.entity.Factura;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDao extends CrudRepository<Factura, Long> {

}