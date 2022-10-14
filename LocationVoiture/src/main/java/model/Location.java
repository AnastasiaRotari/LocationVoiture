package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Location {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private LocalDate dateDebut;
	
	@Column(nullable = false)
	private LocalDate dateFin;
	
	@Column(columnDefinition = "DECIMAL(7,2)",nullable = false)
	private double prixTotal;

	@OneToOne
	private Annonce annonce;
	
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


	@Override
	public String toString() {
		return "Location [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", prixTotal=" + prixTotal
				+ "]";
	}
	
	
	
	
}
