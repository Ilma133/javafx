package com.ptf.rs.zadaca4.controllers;

import java.io.IOException;

import com.ptf.rs.zadaca4.App;

public class MainController{
	
	public void showTickets () throws IOException{
		App.setContent("pocetna");
	}
	
	public void dodajTicket () throws IOException{
		App.setContent("tiketi");
	}
	
}