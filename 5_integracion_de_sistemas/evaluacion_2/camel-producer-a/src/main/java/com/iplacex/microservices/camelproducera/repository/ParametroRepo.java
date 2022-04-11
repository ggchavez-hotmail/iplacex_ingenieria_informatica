package com.iplacex.microservices.camelproducera.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.iplacex.microservices.camelproducera.model.Parametro;

@Repository
public interface ParametroRepo extends MongoRepository<Parametro,String> {
	public List<Parametro> findAllByEmpresa(String empresa);
}
