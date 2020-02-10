package com.example.enseignement.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.enseignement.model.Enseignant;
import com.example.enseignement.model.Etudiant;

@Repository
@Transactional
public class EtudiantRepoImp implements EtudiantInterface {

	@PersistenceContext
	private transient EntityManager em;

	@Override
	public List<Etudiant> findAll() {
		List<Etudiant> etudiant=em.createQuery("SELECT e FROM Etudiant e").getResultList();
		return etudiant;
	}

	@Override
	public Etudiant findOne(int idEtud) {
		Etudiant etudiant=(Etudiant) em.createQuery("SELECT e FROM Etudiant e where numet= :idEtud")
				.setParameter("idEtud", idEtud)
				.getSingleResult();
		return etudiant;
	}

	@Override
	public void insert(Etudiant e) {
		em.merge(e);
		
	}

	@Override
	public void update(Etudiant e) {
		em.merge(e);
		
	}

	@Override
	public void delete(Etudiant e) {
		em.remove(e);
		
	}
	
	
	

}
