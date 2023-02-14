package com.ptf.rs.zadaca4.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ptf.rs.zadaca4.alerts.*;
import com.ptf.rs.zadaca4.*;
import com.ptf.rs.zadaca4.models.*;
import com.ptf.rs.zadaca4.controllers.*;
import com.ptf.rs.zadaca4.dao.tiketDAO;
import com.ptf.rs.zadaca4.App;
import com.ptf.rs.zadaca4.models.tiket;
import com.ptf.rs.zadaca4.util.DateConverter;
import com.ptf.rs.zadaca4.util.seedData;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ManageTiketController implements Initializable{

	@FXML 
	private Label lblInfo;
	@FXML 
	private ComboBox<String> cbTipUsluge;
	@FXML 
	private TextField txtNaslov;
	@FXML 
	private TextField txtOsoba;
	@FXML 
	private DatePicker dpDatumPrijave;
	@FXML 
	private ComboBox<String> cbNacinPrijave;
	@FXML 
	private ComboBox<String> cbPrioritet;
	@FXML 
	private TextField txtOpis;
	@FXML 
	private ComboBox<String> cbAgent;
	@FXML 
	private TextField txtEmail;
	@FXML 
	private TextField txtTelefon;
	@FXML 
	private ComboBox <String> cbStatus;
	@FXML
	private Label labelTipUslugeError;
	@FXML
	private Label labelNaslovError;
	@FXML
	private Label labelOsobaError;
	@FXML
	private Label labelDatumPrijaveError;
	@FXML
	private Label labelNacinPrijaveError;
	@FXML
	private Label labelPrioritetError;
	@FXML
	private Label labelOpisError;
	@FXML
	private Label labelAgentError;
	
	
	private tiket currentTiket;
	
	
	public void loadData(tiket tiket) {
		cbTipUsluge.setValue(tiket.getTipUsluge());
		cbTipUsluge.setDisable(true);
		txtNaslov.setText(tiket.getNaslovProblema());
		txtNaslov.setDisable(true);
		txtOsoba.setText(tiket.getImeOsobe());
		txtOsoba.setDisable(true);
		dpDatumPrijave.setValue(DateConverter.toLocalDate(tiket.getDatum()));
		dpDatumPrijave.setDisable(true);
		cbNacinPrijave.setValue(tiket.getNacinPrijave());
		cbNacinPrijave.setDisable(true);
		cbPrioritet.setValue(tiket.getPrioritet());
		cbPrioritet.setDisable(true);
		txtOpis.setText(tiket.getOpis());
		txtOpis.setDisable(true);
		cbAgent.setValue(tiket.getAgent());
		txtEmail.setText(tiket.getEmail());
		txtEmail.setDisable(true);
		txtTelefon.setText(tiket.getTelefon());
		txtTelefon.setDisable(true);
		cbStatus.setValue(tiket.getStatus());
		cbStatus.setDisable(false);
		currentTiket = tiket;
		
	}
	
    public void loadData(Integer tiketId) {
		
	}
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
    	ArrayList<String> usluge = seedData.getInstance().getUsluga();
    	ArrayList<String> status = seedData.getInstance().getStatus();
    	ArrayList<String> agent = seedData.getInstance().getAgent();
    	ArrayList<String> nacin = seedData.getInstance().getNacinPrijave();
    	ArrayList<String> prioritet = seedData.getInstance().getPrioritet();
    	cbTipUsluge.setItems(FXCollections.observableArrayList(usluge));
    	cbAgent.setItems(FXCollections.observableArrayList(agent));
    	cbNacinPrijave.setItems(FXCollections.observableArrayList(nacin));
    	cbPrioritet.setItems(FXCollections.observableArrayList(prioritet));
    	cbStatus.setItems(FXCollections.observableArrayList(status));
    	cbStatus.setValue("novi");
    	cbStatus.setDisable(true);
    	
    	labelTipUslugeError.setVisible(false);
		labelNaslovError.setVisible(false);
		labelOsobaError.setVisible(false);
		labelDatumPrijaveError.setText("");
		labelNacinPrijaveError.setVisible(false);
		labelPrioritetError.setVisible(false);
		labelOpisError.setVisible(false);
		labelAgentError.setVisible(false);
    	
	}
    
    
    public void odustaniAction(ActionEvent event) throws IOException {
		//ymFX.setRoot("Main");
		
		App.setRoot("Pocetna");
	}
	
	
    private void setMinAndMaxDate() {
		LocalDate currentDate = LocalDate.now();
		LocalDate minDate = DateConverter.addYears(currentDate, -100);
		LocalDate maxDate = DateConverter.addYears(currentDate, 0);
		
		dpDatumPrijave.setValue(maxDate);
		dpDatumPrijave.setDayCellFactory(d -> new DateCell() {
			@Override
			public void updateItem(LocalDate item, boolean empty) {
				super.updateItem(item, empty);
				setDisable(item.isAfter(maxDate) || item.isBefore(minDate));
			}
		});
	}
    
    
    public void prijaviAction(ActionEvent event) throws ClassNotFoundException, SQLException {
    	if(!isValid()) {
			return;
		}
    	
    	/*tiket TIKET=new tiket(
    			seedData.getInstance().getNextTiketId(),
    			cbTipUsluge.getValue(),
    			txtNaslov.getText(),
    			txtOsoba.getText(),
    			DateConverter.toDate(dpDatumPrijave.getValue()),
    			cbNacinPrijave.getValue(),
    			cbPrioritet.getValue(),
    			txtOpis.getText(),
    			cbAgent.getValue(),
    			txtEmail.getText(),
    			txtTelefon.getText(),
    			cbStatus.getValue()
    			
    			);*/
    	
    	if(currentTiket != null) {
			tiketDAO.updateTiket(
					currentTiket.getId(),
					cbAgent.getValue(),
					cbStatus.getValue()
					);
			if((cbStatus.getValue()).equals("otvoren")) {
				tiketDAO.updateDatumRj(currentTiket.getId());
			}
		
			return;
		}
    	
    	tiketDAO.addTiket(
    			    cbTipUsluge.getValue(), 
					txtNaslov.getText(),
					txtOsoba.getText(),
					DateConverter.toDate(dpDatumPrijave.getValue()),
					cbNacinPrijave.getValue(),
					cbPrioritet.getValue(),
					txtOpis.getText(),
					cbAgent.getValue(),
					txtEmail.getText(),
					txtTelefon.getText(),
					cbStatus.getValue());
		
    	
    	
    	Optional<ButtonType> result = CustomAlert.showConfirmation(
				"Novi tiket",
				"Dodavanje novog tiketa", 
				"Da li želite dodati još jedan tiket? U suprotnom bit ćete vraćeni na prozor sa podacima o tiketima.", 
				"Da želim", 
				"Ne");
		
		if(result.get() == ButtonType.OK) {
			cbTipUsluge.setValue(null);
			txtNaslov.setText(null);
			txtOsoba.setText(null);
			dpDatumPrijave.setValue(null);
			cbNacinPrijave.setValue(null);
			cbPrioritet.setValue(null);
			txtOpis.setText(null);
			cbAgent.setValue(null);
			txtEmail.setText(null);
			txtTelefon.setText(null);
			cbStatus.setValue(null);
			
			txtNaslov.requestFocus();
		}
		if(result.get() == ButtonType.CANCEL) {
			try {
				//GymFX.setRoot("Main");
				App.setRoot("pocetna");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
    	
    	
    	
    	
    	
    
    
    
    private boolean isValid() {
		boolean isValid = true;
		labelTipUslugeError.setVisible(false);
		labelNaslovError.setVisible(false);
		labelOsobaError.setVisible(false);
		labelDatumPrijaveError.setVisible(false);
		labelNacinPrijaveError.setVisible(false);
		labelPrioritetError.setVisible(false);
		labelOpisError.setVisible(false);
		labelAgentError.setVisible(false);
		
		if(cbTipUsluge.getValue()==null) {
			labelTipUslugeError.setVisible(true);
			isValid = false;
		}
		
		if(txtNaslov.getText().isEmpty() || txtNaslov.getText().length() > 500) {
			labelNaslovError.setVisible(true);
			isValid = false;
		}
		
		if(txtOsoba.getText().isEmpty() || txtOsoba.getText().length() > 100) {
			labelOsobaError.setVisible(true);
			isValid = false;
		}
		if(dpDatumPrijave.getValue() == null) {
			labelDatumPrijaveError.setVisible(true);
			isValid = false;
		}
		if(cbNacinPrijave.getValue()==null) {
			labelNacinPrijaveError.setVisible(true);
			isValid = false;
		}
		if(cbPrioritet.getValue()==null) {
			labelPrioritetError.setVisible(true);
			isValid = false;
		}
		
		if(txtOpis.getText().isEmpty() || txtOpis.getText().length() > 5000) {
			labelOpisError.setVisible(true);
			isValid = false;
		}
		if(cbAgent.getValue()==null) {
			labelAgentError.setVisible(true);
			isValid = false;
		}
		
		
		return isValid;
	}
	
	
}