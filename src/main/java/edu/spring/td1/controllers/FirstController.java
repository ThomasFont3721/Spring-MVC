package edu.spring.td1.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import edu.spring.td1.models.Ccategorie;
import edu.spring.td1.models.Celement;

@SessionAttributes("categories")
@Controller
public class FirstController {

	@GetMapping("/")
	public String index(ModelMap model) {
		model.put("name", "wookie");
		return "index";
	}
	
	@GetMapping("/item")
	public String item() {
		return "item";
	}
	
	@ModelAttribute("categories") 
    public List<Ccategorie> getCcategories(){
		List<Ccategorie> categoris =new ArrayList<>();
		categoris.add(new Ccategorie("Amis"));
		categoris.add(new Ccategorie("Famille"));
		categoris.add(new Ccategorie("Professionnels"));
		categoris.add(new Ccategorie("Autre"));
        return categoris;
    }
	
	@PostMapping("item/addNew")
	public RedirectView addNew(@RequestParam String nom, @RequestParam String libelle, @SessionAttribute List<Ccategorie> categories) {
	    for (Ccategorie cat : categories) {
			if (cat.getLibelle().equals(libelle)) {
				cat.addElements(new Celement(nom));
			}
		}
	    return new RedirectView("/item");
	}
	
	@GetMapping("/item/new")
	public String Newitem() {
		return "new";
	}
	@GetMapping("/item/inc/{nom}/{libelle}")
	public RedirectView inc(@PathVariable String nom, @PathVariable String libelle, @SessionAttribute List<Ccategorie> categories) {
		for (Ccategorie cat : categories) {
			if (cat.getLibelle().equals(libelle)) {
				for (Celement elem : cat.getElements()) {
					if (elem.getNom().equals(nom)) {
						elem.inc();
					}
				}
			}
		}
	    return new RedirectView("/item");
	}
	
	@GetMapping("/item/dec/{nom}/{libelle}")
	public RedirectView dec(@PathVariable String nom, @PathVariable String libelle, @SessionAttribute List<Ccategorie> categories) {
		for (Ccategorie cat : categories) {
			if (cat.getLibelle().equals(libelle)) {
				for (Celement elem : cat.getElements()) {
					if (elem.getNom().equals(nom)) {
						elem.dec();
					}
				}
			}
		}
	    return new RedirectView("/item");
	}
	
	@GetMapping("/item/delete/{nom}/{libelle}")
	public RedirectView delete(@PathVariable String nom, @PathVariable String libelle, @SessionAttribute List<Ccategorie> categories) {
		int i=0;
		int j=0;
		for (Ccategorie cat : categories) {
			if (cat.getLibelle().equals(libelle)) {
				for (Celement element : cat.getElements()) {
					if (element.getNom().equals(nom)) {
						j=i;
					}
					i++;
				}
				cat.getElements().remove(j);
			}
		}
		
	    return new RedirectView("/item");
	}
}

