package fr.infoking.eboutique.metier;

import java.util.List;

import fr.infoking.eboutique.entites.Categorie;
import fr.infoking.eboutique.entites.Client;
import fr.infoking.eboutique.entites.Commande;
import fr.infoking.eboutique.entites.Panier;
import fr.infoking.eboutique.entites.Produit;

public interface InternauteMetier {
	
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idC);
	public List<Produit> listProduits();
	public List<Produit> listProduitsParMc(String mc);
	public List<Produit> listProduitsSelectionne();
	public List<Produit> listProduitsParCategorie(Long idCat);
	public Produit getProduit(Long idPro);
	public Commande enrigistrerCommande(Panier p , Client c);


}
