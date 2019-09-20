package edu.spring.td1.models;

import java.util.ArrayList;
import java.util.List;

public class Ccategorie{
	private String libelle;
	private List<Celement> elements;
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public List<Celement> getElements() {
		return elements;
	}
	public Celement getElement(int index) {
		return this.elements.get(index);
	}
	public void setElements(List<Celement> elements) {
		this.elements = elements;
	}
	public Ccategorie(String libelle) {
		this.libelle = libelle;
		this.elements = new ArrayList<Celement>();
	}
	
	public void addElements(Celement element) {
		this.elements.add(element);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ccategorie) {
			Ccategorie cat =(Ccategorie) obj;
			if (cat.getLibelle()==null) {
				return this.libelle==null;
			}
			return this.libelle.equals(cat.getLibelle());
		}
		else {
			return false;
		}
	}
	
}
