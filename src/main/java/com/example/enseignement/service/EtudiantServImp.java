package com.example.enseignement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.enseignement.model.Etudiant;
import com.example.enseignement.repository.EtudiantInterface;

@Service
@Transactional
public class EtudiantServImp implements EtudiantServInterface {

	@Autowired
	private EtudiantInterface etudiantRepo;
	
	@Override
	public List<Etudiant> findAll() {
		// TODO Auto-generated method stub
		return etudiantRepo.findAll();
	}

	@Override
	public Etudiant findOne(int idEtud) {
		// TODO Auto-generated method stub
		return etudiantRepo.findOne(idEtud);
	}

	@Override
	public void insert(Etudiant e) {
		// TODO Auto-generated method stub
		etudiantRepo.insert(e);

	}

	@Override
	public void update(Etudiant e) {
		// TODO Auto-generated method stub
		etudiantRepo.update(e);

	}

	@Override
	public void delete(Etudiant e) {
		// TODO Auto-generated method stub
		etudiantRepo.delete(e);

	}

}
