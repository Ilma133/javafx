package com.ptf.rs.zadaca4.util;


import java.util.ArrayList;

import com.ptf.rs.zadaca4.models.tiket;
import com.ptf.rs.zadaca4.util.*;

public class seedData {
	
	public ArrayList<tiket>tiketi=new ArrayList<>();
	private static seedData singleInstance = null;
	private Integer Id=1;
	
	private seedData() {
	}
	
	public static seedData getInstance() {
		if (singleInstance == null)
            singleInstance = new seedData();
  
        return singleInstance;
	}
	
	public Integer getNextTiketId() {
		return Id++;
	}
	
	
	public ArrayList<String> getUsluga() {
		ArrayList <String> usluge=new ArrayList<>();
		usluge.add("Pitanje");
		usluge.add("Incident");
		usluge.add("Problem");
		usluge.add("Zahtjev za promjenom");
		return usluge;
	}
	
	public ArrayList<String> getStatus() {
		ArrayList <String> status=new ArrayList<>();
		status.add("novi");
		status.add("otvoren");
		status.add("na cekanju");
		status.add("rijesen");
		status.add("zatvoren");
		status.add("ceka kupca");
		status.add("ceka trecu stranu");
		return status;
	}
	
	public ArrayList<String> getAgent() {
		ArrayList <String> agent=new ArrayList<>();
		agent.add("Agent1");
		agent.add("Agent2");
		agent.add("Agent3");
		agent.add("Agent4");
		return agent;
	}
	
	public ArrayList<String> getNacinPrijave() {
		ArrayList <String> nacin=new ArrayList<>();
		nacin.add("Email");
		nacin.add("Telefon");
		nacin.add("Web stranica");
		return nacin;
	}
	
	public ArrayList<String> getPrioritet() {
		ArrayList <String> prioritet=new ArrayList<>();
		prioritet.add("nisko");
		prioritet.add("srednje");
		prioritet.add("visoko");
		prioritet.add("hitno");
		return prioritet;
	}
	
	
	
	}