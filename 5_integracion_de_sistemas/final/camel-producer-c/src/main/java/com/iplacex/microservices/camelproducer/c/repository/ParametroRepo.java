package com.iplacex.microservices.camelproducer.c.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.iplacex.microservices.camelproducer.c.model.Parametro;

@Repository
public interface ParametroRepo extends MongoRepository<Parametro,String> {
	public List<Parametro> findAllByRut(String rut);
}
