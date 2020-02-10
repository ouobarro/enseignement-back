package com.example.enseignement.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the matiere database table.
 * 
 */
@Entity
@Table(name="matiere")
@NamedQuery(name="Matiere.findAll", query="SELECT m FROM Matiere m")
public class Matiere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idmat;

	@Column(nullable=false)
	private float coef;

	@Column(nullable=false, length=45)
	private String nommat;

	//bi-directional many-to-one association to Enseignant
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="numens", nullable=false)
	private Enseignant enseignant;

	//bi-directional many-to-one association to Formation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="nomform", nullable=false)
	private Formation formation;

	//bi-directional many-to-one association to Tabnote
	@OneToMany(mappedBy="matiere")
	private List<Tabnote> tabnotes;

	public Matiere() {
	}

	public int getIdmat() {
		return this.idmat;
	}

	public void setIdmat(int idmat) {
		this.idmat = idmat;
	}

	public float getCoef() {
		return this.coef;
	}

	public void setCoef(float coef) {
		this.coef = coef;
	}

	public String getNommat() {
		return this.nommat;
	}

	public void setNommat(String nommat) {
		this.nommat = nommat;
	}

	public Enseignant getEnseignant() {
		return this.enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Formation getFormation() {
		return this.formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public List<Tabnote> getTabnotes() {
		return this.tabnotes;
	}

	public void setTabnotes(List<Tabnote> tabnotes) {
		this.tabnotes = tabnotes;
	}

	public Tabnote addTabnote(Tabnote tabnote) {
		getTabnotes().add(tabnote);
		tabnote.setMatiere(this);

		return tabnote;
	}

	public Tabnote removeTabnote(Tabnote tabnote) {
		getTabnotes().remove(tabnote);
		tabnote.setMatiere(null);

		return tabnote;
	}

}