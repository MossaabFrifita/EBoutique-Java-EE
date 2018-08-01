package fr.infoking.eboutique.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.infoking.eboutique.dao.IBoutiqueDAO;
import fr.infoking.eboutique.entites.Categorie;
import fr.infoking.eboutique.entites.Client;
import fr.infoking.eboutique.entites.Commande;
import fr.infoking.eboutique.entites.Panier;
import fr.infoking.eboutique.entites.Produit;
import fr.infoking.eboutique.entites.Role;
import fr.infoking.eboutique.entites.User;

@Transactional
public class BoutiqueMetierImpl implements IAdminCategoriesMetier {

	private IBoutiqueDAO dao;
	
	public void setDao(IBoutiqueDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public Long ajouterProduit(Produit p, Long IdCat) {
		return dao.ajouterProduit(p,IdCat);
	}

	@Override
	public void supprimerProduit(Long idPro) {
		dao.supprimerProduit(idPro);
		
	}

	@Override
	public void modifierProduit(Produit p) {
		dao.modifierProduit(p);
		
	}

	@Override
	public List<Categorie> listCategories() {
		return dao.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idC) {
		return dao.getCategorie(idC);
	}

	@Override
	public List<Produit> listProduits() {
		return dao.listProduits();
	}

	@Override
	public List<Produit> listProduitsParMc(String mc) {
		return dao.listProduitsParMc(mc);
	}

	@Override
	public List<Produit> listProduitsSelectionne() {
		return dao.listProduitsSelectionne();
	}

	@Override
	public List<Produit> listProduitsParCategorie(Long idCat) {
		return dao.listProduitsParCategorie(idCat);
	}

	@Override
	public Produit getProduit(Long idPro) {
		return dao.getProduit(idPro);
	}

	@Override
	public Commande enrigistrerCommande(Panier p, Client c) {
		return dao.enrigistrerCommande(p, c);
	}

	@Override
	public Long ajouterCategorie(Categorie c) {
		return dao.ajouterCategorie(c);
	}

	@Override
	public void supprimerCategorie(Long idCat) {
		dao.supprimerCategorie(idCat);
		
	}

	@Override
	public void modifierCategorie(Categorie c) {
		dao.modifierCategorie(c);
	}

	@Override
	public void ajouterUser(User u) {
		dao.ajouterUser(u);
	}

	@Override
	public void attribueRole(User u, Role e) {
		dao.attribueRole(u, e);
	}



}
