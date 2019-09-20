package edu.spring.td1.models;

public class Celement{
	private String nom;
	private int eval;
	
	
	public Celement(String nom) {
		super();
		this.nom = nom;
		this.eval = 0;
	}
	
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public int getEval() {return eval;}
	public void setEval(int eval) {this.eval = eval;}

	public void inc() {
		this.eval++;
	}
	public void dec() {
		this.eval--;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Celement) {
			Celement elem =(Celement) obj;
			if (elem.getNom()==null) {
				return this.nom==null;
			}
			return this.nom.equals(elem.getNom());
		}
		else {
			return false;
		}
	}
} 
