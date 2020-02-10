package com.example.enseignement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.enseignement.model.Enseignant;
import com.example.enseignement.repository.EnseignantInterface;

@Service
@Transactional
public class EnseigantServImp implements EnseignantServInterface {

	@Autowired
	private EnseignantInterface enseignantRepo;
	
	@Override
	public List<Enseignant> findAll() {
		// TODO Auto-generated method stub
		return enseignantRepo.findAll();
	}

	@Override
	public Enseignant findOne(int idEns) {
		// TODO Auto-generated method stub
		return enseignantRepo.findOne(idEns);
	}

	@Override
	public void insert(Enseignant e) {
		// TODO Auto-generated method stub
		enseignantRepo.insert(e);
	}

	@Override
	public void update(Enseignant e) {
		// TODO Auto-generated method stub
		enseignantRepo.update(e);

	}

	@Override
	public void delete(Enseignant e) {
		// TODO Auto-generated method stub
		enseignantRepo.delete(e);

	}

}
