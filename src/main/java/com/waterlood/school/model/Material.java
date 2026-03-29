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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="num_materiel")
	private int numMateriel;

	@Column(name="design")
	private String design;

	@Column(name="etat")
	private String etat;

	@Column(name="quantite")
	private int quantite;
}
