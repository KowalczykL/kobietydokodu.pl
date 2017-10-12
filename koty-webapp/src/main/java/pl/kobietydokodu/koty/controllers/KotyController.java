package pl.kobietydokodu.koty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.kobietydokodu.koty.KotDAO;

@Controller
public class KotyController {

	@Autowired
	private KotDAO dao;
	
	@RequestMapping("/lista")
	public String listaKotow(Model model) {
		model.addAttribute("koty", dao.getKoty());
		return "lista";
	}
	
	@RequestMapping("/dodaj")
	public String dodajKota(Model model) {
		return "dodaj";
	}
	
	@RequestMapping("/kot/{imie}")
    public String szczegolyKota(@PathVariable("imie") String imieKota) {
        return "glowny";
    }	
	
	@RequestMapping("/kot-{id}")
	public String szczegolyKota(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("kot", dao.getKotById(id));
		return "szczegoly";
	}
	@Repository
	public class KotDAO{
		
	}
	}
}
