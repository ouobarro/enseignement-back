package com.example.enseignement.repository;

import java.util.List;

import com.example.enseignement.model.Etudiant;

public interface EtudiantInterface {

	public List<Etudiant> findAll();
	public Etudiant findOne(int idEtud);
	public void insert(Etudiant e);
	public void update(Etudiant e);
	public void delete(Etudiant e);
}
