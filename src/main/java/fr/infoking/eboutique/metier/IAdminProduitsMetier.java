package fr.infoking.eboutique.metier;

import fr.infoking.eboutique.entites.Produit;

public interface IAdminProduitsMetier extends InternauteMetier {
	public Long ajouterProduit(Produit p, Long  IdCat);
	public void supprimerProduit(Long idPro);
	public void modifierProduit(Produit p);
}
