package com.waterlood.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waterlood.school.model.Material;
import com.waterlood.school.repository.MaterialRepository;

@Service
public class MaterialService {
	
	@Autowired
	private MaterialRepository materialRepository;

	public List<Material> getCustomers() {
		return (List<Material>) materialRepository.findAll();	}
	
	public Optional<Material> getCustomer(int num_materiel)
	{
		return materialRepository.findById(num_materiel);
	}
	
	public Material addCustomer(Material material)
	{
		Material savedCustomer = materialRepository.save(material); 
		return savedCustomer;
	}
	
	public Material updateCustomer(Material material) {
	        Material savedCustomer = materialRepository.save(material);
	        return savedCustomer;
	    }

	
	public void deleteCustomer(int getNum_materiel)
	{
		materialRepository.deleteById(getNum_materiel);
	}
	

	
}
