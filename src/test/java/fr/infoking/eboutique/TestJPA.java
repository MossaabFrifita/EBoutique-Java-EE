package fr.infoking.eboutique;

import static org.junit.Assert.*;

import java.util.List;



import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.infoking.eboutique.entites.Categorie;
import fr.infoking.eboutique.entites.Produit;
import fr.infoking.eboutique.metier.IAdminCategoriesMetier;

public class TestJPA {
	ClassPathXmlApplicationContext	context;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});
		
	}

	@Test
	public void AddCategorie() {
		try {
			
			IAdminCategoriesMetier metier = (IAdminCategoriesMetier) context.getBean("metier");
			List<Categorie> CAT1 = metier.listCategories();
			metier.ajouterCategorie(new Categorie("Ordinateurs", "ord", null, "image1.jpg"));
			metier.ajouterCategorie(new Categorie("Imprimantes", "imp", null, "image2.jpg"));
			List<Categorie> CAT2 = metier.listCategories();
			context.close();
			if(CAT1.size() + 2 == CAT2.size())
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
		
	}
	
	@Test
	public void AddProduit() {
		try {
			
			IAdminCategoriesMetier metier = (IAdminCategoriesMetier) context.getBean("metier");
			List<Produit> PROD1 = metier.listProduits();
			metier.ajouterProduit(new Produit("PAR222","ABCDERF",10.3,3,true,"image1.jpg"),1L);
			metier.ajouterProduit(new Produit("CATRS1","ABCDERF",10.3,3,true,"image1.jpg"),1L);
			List<Produit> PROD2 = metier.listProduits();
			context.close();
			if(PROD1.size() + 2 == PROD2.size())
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
		
	}

}
