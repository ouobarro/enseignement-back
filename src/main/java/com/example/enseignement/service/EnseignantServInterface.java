package com.example.enseignement.service;

import java.util.List;

import com.example.enseignement.model.Enseignant;

public interface EnseignantServInterface {

	public List<Enseignant> findAll();
	public Enseignant findOne(int idEns);
	public void insert(Enseignant e);
	public void update(Enseignant e);
	public void delete(Enseignant e);
	
}
