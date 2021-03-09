package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	List<String> listaParole;
		
	public Parole() {
		this.listaParole= new LinkedList<>();
	}
	
	public void addParola(String p) {
		this.listaParole.add(p);
	}
	
	public List<String> getElenco() {
		List<String> temp= new LinkedList<>(this.listaParole);
		ComparatoreDiParole c= new ComparatoreDiParole();
		
		Collections.sort(temp, c);
		
		return temp;
	}
	
	public void reset() {
		this.listaParole.removeAll(this.listaParole);
	}
	
	public void delete(String p) {
		this.listaParole.remove(p);
		
	}
	
	

}
