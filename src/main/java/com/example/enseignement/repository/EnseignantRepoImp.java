package com.example.enseignement.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.enseignement.model.Enseignant;

@Repository
@Transactional
public class EnseignantRepoImp implements EnseignantInterface {
	
	@PersistenceContext
	private transient EntityManager em;

	@Override
	public List<Enseignant> findAll() {
		List<Enseignant> enseignantList = em.createQuery("SELECT e FROM Enseignant e").getResultList();
		return enseignantList;
	}

	@Override
	public Enseignant findOne(int idEns) {
		Enseignant enseignant = (Enseignant) em.createQuery("SELECT e FROM Enseignant where e.numens = :idEns")
				.setParameter("idEns", idEns)
				.getSingleResult();
		return enseignant;
	}

	@Override
	public void insert(Enseignant e) {
		em.merge(e);

	}

	@Override
	public void update(Enseignant e) {
		em.merge(e);
	}

	@Override
	public void delete(Enseignant e) {
		em.remove(e);
	}
	
	

}
