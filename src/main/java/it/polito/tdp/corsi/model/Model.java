package it.polito.tdp.corsi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {
	private CorsoDAO corsoDao;
	
	public Model() {
		corsoDao = new CorsoDAO();
	}
	
	public List<Corso> getCorsiByPeriodo(Integer pd){
		return corsoDao.getCorsiByPeriodo(pd);
	}
	
	public Map<Corso, Integer> getIscrittiByPeriodo(Integer pd){
		return corsoDao.getIscrittibyPeriodo(pd);
	}
	
	public List<Studente> getStudenteByCorso(String codice){
		return corsoDao.getStudentiByCorso(new Corso(codice, null, null, null));
	}
	
	public Map<String, Integer> getDivisioneCDS(String codice) {
		//cosa ci aspettiamo 
		//dato il corso con codice ABC
		//gest -> 50
		//inf -> 40
		//mec -> 30
		
		//soluzione 1
		/*
		Map<String, Integer> divisione = new HashMap<String, Integer>();
		List<Studente> studenti = this.getStudenteByCorso(codice);
		for(Studente s:studenti) {
			if(divisione.get(s.getCDS())==null) {
				divisione.put(s.getCDS(), 1);
			} else {
				divisione.put(s.getCDS(), divisione.get(s.getCDS())+1);
			}
		}*/
		
		
		
		return corsoDao.getDivisioneStudenti(new Corso(codice, null, null, null));
		
	}

	public boolean esisteCorso(String codice) {
		return corsoDao.esisteCorso(new Corso(codice, null, null, null));
	}
	
}
