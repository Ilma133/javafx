package com.ptf.rs.zadaca4.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import com.ptf.rs.zadaca4.models.*;
import com.ptf.rs.zadaca4.util.*;
import com.ptf.rs.zadaca4.App;
import com.ptf.rs.zadaca4.dao.tiketDAO;
import com.ptf.rs.zadaca4.models.tiket;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class tiketcontroller implements Initializable{
	
	@FXML
	private TableView<tiket> table;
	@FXML
	private TableColumn<tiket, String> colNaslovProblema;
	@FXML
	private TableColumn<tiket, String> colTipUsluge;
	@FXML
	private TableColumn<tiket, String> colKorisnik;
	@FXML
	private TableColumn<tiket, Date> colDatumPrijave;
	@FXML
	private TableColumn<tiket, String> colAgent;
	@FXML
	private TableColumn<tiket, Date> colDatumRjesavanja;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		SetColumns();
		setRowActions();
		try {
			table.setItems(getData());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void  dodajTicketAction(ActionEvent event) throws IOException{
		App.setRoot("tiketi");
	}
	
	private void SetColumns() {
		colNaslovProblema.setCellValueFactory(
				new PropertyValueFactory<tiket, String>("naslovProblema"));
		colTipUsluge.setCellValueFactory(
				new PropertyValueFactory<tiket, String>("tipUsluge"));
		colKorisnik.setCellValueFactory(
				new PropertyValueFactory<tiket, String>("ImeOsobe"));
		colDatumPrijave.setCellValueFactory(
				new PropertyValueFactory<tiket, Date>("datum"));
		colAgent.setCellValueFactory(
				new PropertyValueFactory<tiket, String>("agent"));
		colDatumRjesavanja.setCellValueFactory(
				new PropertyValueFactory<tiket, Date>("datumRjesavanja"));
	}
	
	private void setRowActions() {
		table.setRowFactory(tableView -> {
			final TableRow<tiket> row = new TableRow<>();
			final ContextMenu rowMenu = new ContextMenu();
			MenuItem editItem = new MenuItem("Izmjeni");
			
			editItem.setOnAction(event -> {
				try {
					//GymFX.setRoot("ManageMember");
					App.setRoot("tiketi");
					ManageTiketController controller = App.getLoader().getController();
					controller.loadData(row.getItem());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
	
			rowMenu.getItems().addAll(editItem);
			row.contextMenuProperty().bind(
				Bindings.when(row.emptyProperty())
				.then((ContextMenu) null)
				.otherwise(rowMenu));
			
			return row;
		});
	}
	
	
	
	
	private ObservableList<tiket> getData() throws ClassNotFoundException, SQLException {
		return FXCollections.observableArrayList(tiketDAO.getTickets());
	}
	
}