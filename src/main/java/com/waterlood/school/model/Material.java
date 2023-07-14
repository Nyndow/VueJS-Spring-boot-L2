package com.waterlood.school.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="materiels")
public class Material {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="num_materiel")
	private int num_materiel;
	
	@Column(name="design")
	private String design;
	
	@Column(name="etat")
	private String etat;
	
	@Column(name="quantite")
	private int quantite;

//------------------------------------------------
//UNCOMMENT the getters and setters if you can't see any data but get the right count 
	
//	public int getNum_materiel() {
//		return num_materiel;
//	}
//
//	public void setNum_materiel(int num_materiel) {
//		this.num_materiel = num_materiel;
//	}
//
//	public String getDesign() {
//		return design;
//	}
//
//	public void setDesign(String design) {
//		this.design = design;
//	}
//
//	public String getEtat() {
//		return etat;
//	}
//
//	public void setEtat(String etat) {
//		this.etat = etat;
//	}
//
//	public int getQuantite() {
//		return quantite;
//	}
//
//	public void setQuantite(int quantite) {
//		this.quantite = quantite;
//	}


}
