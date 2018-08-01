package fr.infoking.eboutique.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.infoking.eboutique.entites.Categorie;
import fr.infoking.eboutique.entites.Client;
import fr.infoking.eboutique.entites.Commande;
import fr.infoking.eboutique.entites.LigneCommande;
import fr.infoking.eboutique.entites.Panier;
import fr.infoking.eboutique.entites.Produit;
import fr.infoking.eboutique.entites.Role;
import fr.infoking.eboutique.entites.User;

public class BoutiqueDaoImpl implements IBoutiqueDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Long ajouterCategorie(Categorie c) {
		em.persist(c);
		return c.getIdCategorie();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> listCategories() {
		return em.createQuery("select c from Categorie c").getResultList();
	}

	@Override
	public Categorie getCategorie(Long idC) {
		return em.find(Categorie.class, idC);
	}

	@Override
	public void supprimerCategorie(Long idCat) {
		if(getCategorie(idCat)!= null){
			Categorie c = getCategorie(idCat);
			em.remove(c);
			
		}

	}

	@Override
	public void modifierCategorie(Categorie c) {
		em.merge(c);
		
	}

	@Override
	public Long ajouterProduit(Produit p, Long IdCat) {
		p.setCategorie(getCategorie(IdCat));
		em.persist(p);
		return p.getIdProduit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> listProduits() {
		return em.createQuery("from Produit").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> listProduitsParMc(String mc) {
		Query query =  em.createQuery("select p from Produit p where p.designation like :x or description like :x");
		query.setParameter("x","%"+ mc + "%");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> listProduitsParCategorie(Long idCat) {
	  Query q = em.createQuery("select p from Produit p where  p.idCategorie = :x");
	  q.setParameter("x", idCat);
	  return  q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> listProduitsSelectionne() {
		return em.createQuery("select p from Produit p where  p.selected = true").getResultList();
	}

	@Override
	public Produit getProduit(Long idPro) {
		return em.find(Produit.class, idPro);
	}

	@Override
	public void supprimerProduit(Long idPro) {
		if(getProduit(idPro) != null)
		 em.remove(getProduit(idPro));
		
	}

	@Override
	public void modifierProduit(Produit p) {
		em.merge(p);
		
	}

	@Override
	public void ajouterUser(User u) {
		em.persist(u);
		
	}

	@Override
	public void attribueRole(User u, Role e) {
		Role role = em.find(Role.class, e.getIdRole());
		if(role != null)
			em.persist(e);
		u.getRoles().add(e) ;
		em.persist(u);
		
	}

	@Override
	public Commande enrigistrerCommande(Panier p, Client client) {
		em.persist(client);
		Commande c = new Commande();
		c.setClient(client);
		c.setLignes(p.getCommandes());
		c.setDateCommande(new Date());
		for(LigneCommande lc : p.getCommandes())
			em.persist(lc);
		em.persist(c);
		return c;
	}


}
