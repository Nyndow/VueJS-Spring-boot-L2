package com.waterlood.school.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.waterlood.school.model.Material;
import com.waterlood.school.service.MaterialService;


@RestController
public class MaterialController {
	
	@Autowired
	private MaterialService materialService;
	
	@GetMapping("/list_mat")
	public List<Material> getCustomers()
	{
		List<Material> materials = materialService.getCustomers();
		return materials ;
	}
	
	@GetMapping("/get_mat/{num_materiel}")
	public ResponseEntity<Material> getCustomer(@PathVariable int num_materiel)
	{
		Optional<Material> customerOptional = materialService.getCustomer(num_materiel);

	    if (customerOptional.isPresent()) {
	    	Material material = customerOptional.get();
	        return ResponseEntity.ok(material);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
		
	}
	
	@PostMapping("/add_mat")
	public ResponseEntity<String> addCustomer(@RequestBody Material savedCustomer)
	{
		materialService.addCustomer(savedCustomer);
		return ResponseEntity.ok("Material added");
	}
	
	@PutMapping("/edit_mat/{num_materiel}")
	public ResponseEntity<Material> updateCustomer(@PathVariable int num_materiel, @RequestBody Material updatedCustomer)
	{
		Material material = materialService.updateCustomer(updatedCustomer);
		return ResponseEntity.ok(material);
		
	}
	
	@DeleteMapping("/delete_mat/{num_materiel}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int num_materiel )
	{
		materialService.deleteCustomer(num_materiel);
		return ResponseEntity.ok("Material deleted");
	}
	
	

	
}
