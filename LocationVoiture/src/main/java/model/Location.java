package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Location {

	@JsonView(JsonViews.Common.class)
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonView(JsonViews.Common.class)
	@Column(nullable = false)
	private LocalDate dateDebut;
	
	@JsonView(JsonViews.Common.class)
	@Column(nullable = false)
	private LocalDate dateFin;
	
	@JsonView(JsonViews.Common.class)
	@Column(columnDefinition = "DECIMAL(7,2)",nullable = false)
	private double prixTotal;

	@JsonView(JsonViews.Common.class)
	@OneToOne
	private Annonce annonce;
	
	@JsonView(JsonViews.Common.class)
	@OneToOne
	private Client client;
	
	
	
	public Location() {
	}


	public Location(LocalDate dateDebut, LocalDate dateFin, double prixTotal) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prixTotal = prixTotal;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDate getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}


	public LocalDate getDateFin() {
		return dateFin;
	}


	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}


	public double getPrixTotal() {
		return prixTotal;
	}


	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}
	

	public Annonce getAnnonce() {
		return annonce;
	}


	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	@Override
	public String toString() {
		return "Location [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", prixTotal=" + prixTotal
				+ "]";
	}
	
	
	
	
}
