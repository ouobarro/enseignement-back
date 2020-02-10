package com.example.enseignement.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the formation database table.
 * 
 */
@Entity
@Table(name="formation")
@NamedQuery(name="Formation.findAll", query="SELECT f FROM Formation f")
public class Formation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=45)
	private String nomform;

	@Column(nullable=false)
	private int nbretud;

	//bi-directional many-to-one association to Enseignant
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="enseignantresp", nullable=false)
	private Enseignant enseignant;

	//bi-directional many-to-one association to Matiere
	@OneToMany(mappedBy="formation")
	private List<Matiere> matieres;

	public Formation() {
	}

	public String getNomform() {
		return this.nomform;
	}

	public void setNomform(String nomform) {
		this.nomform = nomform;
	}

	public int getNbretud() {
		return this.nbretud;
	}

	public void setNbretud(int nbretud) {
		this.nbretud = nbretud;
	}

	public Enseignant getEnseignant() {
		return this.enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public List<Matiere> getMatieres() {
		return this.matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	public Matiere addMatiere(Matiere matiere) {
		getMatieres().add(matiere);
		matiere.setFormation(this);

		return matiere;
	}

	public Matiere removeMatiere(Matiere matiere) {
		getMatieres().remove(matiere);
		matiere.setFormation(null);

		return matiere;
	}

}