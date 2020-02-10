package com.example.enseignement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.enseignement.model.Etudiant;
import com.example.enseignement.service.EtudiantServInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class EtudiantController {

	@Autowired
	private EtudiantServInterface etudiantServ;

	// Get All Etudiant
	@GetMapping("/etudiants")
	public List<Etudiant> getAllEtudiant() {
		System.out.println("Hello from controller");
		return etudiantServ.findAll();
	}

	// Create a new Etudiant
	@PostMapping("/etudiants")
	public String createEtudiant(@Valid @RequestBody Etudiant etudiant) {
		etudiantServ.insert(etudiant);
		return "Success";
	}

	// Get a Single Etudiant
	@GetMapping("/etudiants/{id}")
	public Etudiant getEtudiantById(@PathVariable(value = "id") int idEtud) {
		return etudiantServ.findOne(idEtud);

	}

	// Update a Etudiant
	@PutMapping("/etudiants/{id}")
	public void updateNote(@PathVariable(value = "id") int idEtud, @Valid @RequestBody Etudiant detailsEtud) {

		Etudiant etudiant = etudiantServ.findOne(idEtud);

		etudiant.setNumet(detailsEtud.getNumet());
		etudiant.setNom(detailsEtud.getNom());
		etudiant.setPrenom(detailsEtud.getPrenom());

		etudiantServ.update(etudiant);
	}

	// Delete a Etudiant
	@DeleteMapping("/etudiants/{id}")
	public void deleteEtudiant(@PathVariable(value = "id") int idEtud) {
		Etudiant etudiant = etudiantServ.findOne(idEtud);
		etudiantServ.delete(etudiant);
	}

}
