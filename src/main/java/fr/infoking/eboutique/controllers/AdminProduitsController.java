package fr.infoking.eboutique.controllers;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import javax.validation.Valid;


import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import fr.infoking.eboutique.entites.Produit;
import fr.infoking.eboutique.metier.IAdminProduitsMetier;
import net.coobird.thumbnailator.Thumbnails;


@Controller
@RequestMapping(value="adminProd")
public class AdminProduitsController {
	
	@Autowired
	IAdminProduitsMetier metier;
	
	public  BufferedImage resize(BufferedImage img, int newW, int newH) throws IOException {
		  return Thumbnails.of(img).forceSize(newW, newH).asBufferedImage();
		}
	
	@RequestMapping(value="/index" , method =  RequestMethod.GET)
	public String index(Model model)
	{
		model.addAttribute("produits",metier.listProduits());
		model.addAttribute("categories",metier.listCategories());
		model.addAttribute("produit", new Produit());
		
		return "produits";
	}
	
	@RequestMapping(value="/saveProd" , method =  RequestMethod.POST)
	public String save(@Valid Produit p, BindingResult bindingResult ,@RequestParam("file") MultipartFile file , Model model) throws IOException
	{
		if(bindingResult.hasErrors())
		{
			model.addAttribute("produits",metier.listProduits());
			model.addAttribute("categories",metier.listCategories());
			return "produits";
		}
		
		String path = System.getProperty("java.io.tmpdir");
		
		if(p.getIdProduit() == null){	
			addProduit(p, file, path);
		}
		else{
			updateProduit(p, file, path);
		}
		
	
		model.addAttribute("produits",metier.listProduits());
		model.addAttribute("categories",metier.listCategories());
		model.addAttribute("produit", new Produit());
		
		
		return "produits";
	}
	
	@RequestMapping(value="ProdPhoto", produces =MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoProd(@RequestParam Long idProd) throws IOException
	{
		Produit p = metier.getProduit(idProd);
		File file = new File( System.getProperty("java.io.tmpdir")+'/'+"PROD_"+idProd+"_"+p.getPhoto());
		return IOUtils.toByteArray(new FileInputStream(file));
	}
	
	@RequestMapping(value="deleteProd" , method = RequestMethod.GET)
	public String deleteProd(@RequestParam Long idProd, Model model)
	{
		metier.supprimerProduit(idProd);
		model.addAttribute("produits",metier.listProduits());
		model.addAttribute("categories",metier.listCategories());
		model.addAttribute("produit", new Produit());
		return "produits";
	}
	
	@RequestMapping(value="editProd" , method = RequestMethod.GET)
	public String editProdProd(@RequestParam Long idProd, Model model)
	{
		
		model.addAttribute("produits",metier.listProduits());
		model.addAttribute("categories",metier.listCategories());
		model.addAttribute("produit",metier.getProduit(idProd));
		return "produits";
	}
	
	public void addProduit(Produit p, MultipartFile file, String path ) throws IllegalStateException, IOException{
		if(!file.isEmpty())
		{
			p.setPhoto(file.getOriginalFilename());
			
			Long idProd = metier.ajouterProduit(p, p.getCategorie().getIdCategorie());
		    file.transferTo(new File(path+'/'+"PROD_"+idProd+"_"+file.getOriginalFilename()));
		}
		else
		{
			p.setCategorie(metier.getCategorie(p.getCategorie().getIdCategorie()));
			metier.ajouterProduit(p, p.getCategorie().getIdCategorie());
		}
	}
	
	public void updateProduit(Produit p, MultipartFile file, String path ) throws IllegalStateException, IOException{
		if(!file.isEmpty())
		{
			p.setPhoto(file.getOriginalFilename());
			
			metier.modifierProduit(p);
		    file.transferTo(new File(path+'/'+"PROD_"+p.getIdProduit()+"_"+file.getOriginalFilename()));
		}
		else
		{
			Produit prod = metier.getProduit(p.getIdProduit());
			p.setPhoto(prod.getPhoto());
			p.setCategorie(metier.getCategorie(p.getCategorie().getIdCategorie()));
			metier.modifierProduit(p);
		}
	}
	
	

}