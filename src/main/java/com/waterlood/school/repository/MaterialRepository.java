package com.waterlood.school.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.waterlood.school.model.Material;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Integer>{
	
}
