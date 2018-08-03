package fr.infoking.eboutique.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
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

import fr.infoking.eboutique.entites.Categorie;
import fr.infoking.eboutique.metier.IAdminCategoriesMetier;

@Controller
@RequestMapping(value="/adminCat")
public class AdminCategorieController {
	
	
	@Autowired
	private IAdminCategoriesMetier metier;
	
	@RequestMapping(value="/index")
	public String home(Model model)
	{
		model.addAttribute("categorie",new Categorie());
		model.addAttribute("categories",metier.listCategories());
		return "categorie";
	}
	
	@RequestMapping(value="saveCat" , method = RequestMethod.POST)
	public String saveCat(@Valid Categorie c ,BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile multipartFile) throws IOException
	{
		
		
		if(bindingResult.hasErrors())
		{
			
			model.addAttribute("categories",metier.listCategories());
			return "categorie";
		}
		
		
		if(! multipartFile.isEmpty() )
		{
			
			BufferedImage bi = ImageIO.read(multipartFile.getInputStream());  //  Image Validation
			c.setPhoto(multipartFile.getBytes());
			c.setNomPhoto(multipartFile.getOriginalFilename());
		}
		
		if(c.getIdCategorie() != null)	
			metier.modifierCategorie(c);
		else
		{
			metier.ajouterCategorie(c);
		}
		
		model.addAttribute("categorie",new Categorie());
		model.addAttribute("categories",metier.listCategories());
		return "categorie";
	}
	
	@RequestMapping(value="CatPhoto", produces =MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoCat(@RequestParam Long idCat) throws IOException
	{
		Categorie c = metier.getCategorie(idCat);
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
	}

}
