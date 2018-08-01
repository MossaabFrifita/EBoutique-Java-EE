package fr.infoking.eboutique.dao;

import java.util.List;

import fr.infoking.eboutique.entites.Categorie;
import fr.infoking.eboutique.entites.Client;
import fr.infoking.eboutique.entites.Commande;
import fr.infoking.eboutique.entites.Panier;
import fr.infoking.eboutique.entites.Produit;
import fr.infoking.eboutique.entites.Role;
import fr.infoking.eboutique.entites.User;

public interface IBoutiqueDAO {
	
	/* CATEGORIE  */
	public Long ajouterCategorie(Categorie c );
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idC);
	public void supprimerCategorie(Long idCat);
	public void modifierCategorie(Categorie c);
	/* PRODUIT  */
	public Long ajouterProduit(Produit p, Long  IdCat);
	public List<Produit> listProduits();
	public List<Produit> listProduitsParMc(String mc);
	public List<Produit> listProduitsSelectionne();
	public List<Produit> listProduitsParCategorie(Long idCat);
	public Produit getProduit(Long idPro);
	public void supprimerProduit(Long idPro);
	public void modifierProduit(Produit p);
	
	/* USER  */
	public void ajouterUser(User u );
	public void attribueRole(User u, Role e);
	
	public Commande enrigistrerCommande(Panier p , Client c);

}
