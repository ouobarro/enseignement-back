package com.example.enseignement.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the etudiant database table.
 * 
 */
@Entity
@Table(name="etudiant")
@NamedQuery(name="Etudiant.findAll", query="SELECT e FROM Etudiant e")
public class Etudiant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int numet;

	@Column(nullable=false, length=45)
	private String nom;

	@Column(nullable=false, length=45)
	private String prenom;

	//bi-directional many-to-one association to Tabnote
	@OneToMany(mappedBy="etudiant")
	private List<Tabnote> tabnotes;

	public Etudiant() {
	}

	public int getNumet() {
		return this.numet;
	}

	public void setNumet(int numet) {
		this.numet = numet;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Tabnote> getTabnotes() {
		return this.tabnotes;
	}

	public void setTabnotes(List<Tabnote> tabnotes) {
		this.tabnotes = tabnotes;
	}

	public Tabnote addTabnote(Tabnote tabnote) {
		getTabnotes().add(tabnote);
		tabnote.setEtudiant(this);

		return tabnote;
	}

	public Tabnote removeTabnote(Tabnote tabnote) {
		getTabnotes().remove(tabnote);
		tabnote.setEtudiant(null);

		return tabnote;
	}

}