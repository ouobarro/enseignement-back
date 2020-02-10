package com.example.enseignement.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tabnote database table.
 * 
 */
@Entity
@Table(name="tabnote")
@NamedQuery(name="Tabnote.findAll", query="SELECT t FROM Tabnote t")
public class Tabnote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idtabnote;

	@Column(nullable=false)
	private float note;

	//bi-directional many-to-one association to Etudiant
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="numet", nullable=false)
	private Etudiant etudiant;

	//bi-directional many-to-one association to Matiere
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idmat", nullable=false)
	private Matiere matiere;

	public Tabnote() {
	}

	public int getIdtabnote() {
		return this.idtabnote;
	}

	public void setIdtabnote(int idtabnote) {
		this.idtabnote = idtabnote;
	}

	public float getNote() {
		return this.note;
	}

	public void setNote(float note) {
		this.note = note;
	}

	public Etudiant getEtudiant() {
		return this.etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Matiere getMatiere() {
		return this.matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

}