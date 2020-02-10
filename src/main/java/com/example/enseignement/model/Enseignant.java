package com.example.enseignement.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the enseignant database table.
 * 
 */
@Entity
@Table(name="enseignant")
@NamedQuery(name="Enseignant.findAll", query="SELECT e FROM Enseignant e")
public class Enseignant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int numens;

	@Column(nullable=false, length=45)
	private String nomens;

	@Column(nullable=false, length=45)
	private String prenomens;

	//bi-directional many-to-one association to Formation
	@OneToMany(mappedBy="enseignant")
	private List<Formation> formations;

	//bi-directional many-to-one association to Matiere
	@OneToMany(mappedBy="enseignant")
	private List<Matiere> matieres;

	public Enseignant() {
	}

	public int getNumens() {
		return this.numens;
	}

	public void setNumens(int numens) {
		this.numens = numens;
	}

	public String getNomens() {
		return this.nomens;
	}

	public void setNomens(String nomens) {
		this.nomens = nomens;
	}

	public String getPrenomens() {
		return this.prenomens;
	}

	public void setPrenomens(String prenomens) {
		this.prenomens = prenomens;
	}

	public List<Formation> getFormations() {
		return this.formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public Formation addFormation(Formation formation) {
		getFormations().add(formation);
		formation.setEnseignant(this);

		return formation;
	}

	public Formation removeFormation(Formation formation) {
		getFormations().remove(formation);
		formation.setEnseignant(null);

		return formation;
	}

	public List<Matiere> getMatieres() {
		return this.matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	public Matiere addMatiere(Matiere matiere) {
		getMatieres().add(matiere);
		matiere.setEnseignant(this);

		return matiere;
	}

	public Matiere removeMatiere(Matiere matiere) {
		getMatieres().remove(matiere);
		matiere.setEnseignant(null);

		return matiere;
	}

}