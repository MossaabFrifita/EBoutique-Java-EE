package fr.infoking.eboutique.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


@Entity
@Table(name="LIGNE_COMMANDE")
public class LigneCommande implements Serializable {
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLigne;
	@ManyToOne
	@JoinColumn(name = "idCommande")
	private Commande commande;
	@ManyToOne
	@JoinColumn(name = "idProduit")
	private Produit produit;
	private int quantite;
	private double prix;
	
	
	
	
	public LigneCommande(Commande commande, Produit produit, int quantite, double prix) {
		super();
		this.commande = commande;
		this.produit = produit;
		this.quantite = quantite;
		this.prix = prix;
	}
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdLigne() {
		return idLigne;
	}
	public void setIdLigne(Long idLigne) {
		this.idLigne = idLigne;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	

	
	
}
