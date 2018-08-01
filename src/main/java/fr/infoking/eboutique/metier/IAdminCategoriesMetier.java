package fr.infoking.eboutique.metier;

import fr.infoking.eboutique.entites.Categorie;
import fr.infoking.eboutique.entites.Role;
import fr.infoking.eboutique.entites.User;

public interface IAdminCategoriesMetier extends IAdminProduitsMetier {
	public Long ajouterCategorie(Categorie c );
	public void supprimerCategorie(Long idCat);
	public void modifierCategorie(Categorie c);
	
	public void ajouterUser(User u );
	public void attribueRole(User u, Role e);

}
