package com.ptf.rs.zadaca4.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;

import com.ptf.rs.zadaca4.database.AppDatabase;
import com.ptf.rs.zadaca4.models.tiket;
import com.ptf.rs.zadaca4.util.DateConverter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;




public class tiketDAO{
	
	
	public static ObservableList<tiket> getTickets() throws SQLException, ClassNotFoundException {
		String selectStatement = "SELECT * FROM tiket";

		try {
			ResultSet resultSetTiket = AppDatabase.dbExecuteQuery(selectStatement);
			ObservableList<tiket> tiketList = getTiketList(resultSetTiket);
			return tiketList;
		} catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			throw e;
		}
	}
	
	
	
	
	public static tiket getTiket(Integer tiketId) throws SQLException, ClassNotFoundException {
		String selectStatement = "SELECT * FROM tiket" + "WHERE Id=" + tiketId;

		try {
			ResultSet resultSetTiket = AppDatabase.dbExecuteQuery(selectStatement);

			tiket TIKET = getTiketFromResultSet(resultSetTiket);

			return TIKET;
		} catch (SQLException e) {
			System.out.println("While searching an member with " + tiketId + " id, an error occurred: " + e);

			throw e;
		}
	}
	
	
	
	
	public static void addTiket(String TipUsluge, String NaslovProblema, String ImeOsobe,Date Datum ,String NacinPrijave,
			String Prioritet, String Opis, String Agent, String Email, String Telefon, String Status ) throws SQLException, ClassNotFoundException {
		String insertStatement = "INSERT INTO tiket\n"
				+ "(TipUsluge, NaslovProblema, ImeOsobe, Datum, NacinPrijave, Prioritet, Opis, Agent, Email, Telefon, Statusy)\n"
				+ "VALUES\n" + "('" + TipUsluge + "', " + "'" + NaslovProblema + "', " + " '" + ImeOsobe + "',"+"'" + DateConverter.toSqlDate(Datum)
				+ "', " + "'" + NacinPrijave + "', " + "'" + Prioritet + "', "+"'" + Opis + "', " + " '"+ Agent +"', " + " '"+ Email 
				+"', " + " '"+ Telefon +"', " + " '"+ Status +"');";

		try {
			AppDatabase.dbExecuteUpdate(insertStatement);
		} catch (SQLException e) {
			System.out.print("Error occurred while INSERT Operation: " + e);
			throw e;
		}
	}
	
	
	
	
	public static void updateTiket(Integer Id, String Agent, String Status)
			throws SQLException, ClassNotFoundException {

		String updateStatement = "   UPDATE tiket " + " SET Agent = '" + Agent + "', "+" Statusy = '" + Status + "'  WHERE Id = " + Id + ";";

		try {
			AppDatabase.dbExecuteUpdate(updateStatement);
		} catch (SQLException e) {
			System.out.print("Error occurred while UPDATE Operation: " + e);
			throw e;
		}
	}
	
	
	public static void updateDatumRj(Integer Id)
			throws SQLException, ClassNotFoundException {

		String updateStatement = "   UPDATE tiket " + " SET DatumRjesavanja = '" + new Date() + "'  WHERE Id = " + Id + ";";

		try {
			AppDatabase.dbExecuteUpdate(updateStatement);
		} catch (SQLException e) {
			System.out.print("Error occurred while UPDATE Operation: " + e);
			throw e;
		}
	}
	
	
	
	
	public static void deleteTiket(Integer tiketId) throws SQLException, ClassNotFoundException {
		String deleteStatement = "DELETE FROM tiket\n" + "WHERE id =" + tiketId + ";";

		try {
			AppDatabase.dbExecuteUpdate(deleteStatement);
		} catch (SQLException e) {
			System.out.print("Error occurred while DELETE Operation: " + e);
			throw e;
		}
	}
	
	
	
	
	
	private static ObservableList<tiket> getTiketList(ResultSet rs) throws SQLException, ClassNotFoundException {
		ObservableList<tiket> tiketList = FXCollections.observableArrayList();

		while (rs.next()) {
			tiket TIKET= new tiket(rs.getInt("Id"), rs.getString("TipUsluge"), rs.getString("NaslovProblema"),
					rs.getString("ImeOsobe"),DateConverter.parse(rs.getObject("Datum")), rs.getString("NacinPrijave"),
					rs.getString("Prioritet"), rs.getString("Opis"),rs.getString("Agent"),rs.getString("Email"),rs.getString("Telefon")
					,rs.getString("Statusy"), DateConverter.parse(rs.getObject("DatumRjesavanja")));
			tiketList.add(TIKET);
		}
		return tiketList;
	}
	
	
	private static tiket getTiketFromResultSet(ResultSet rs) throws SQLException {
		tiket TIKET = null;
		if (rs.next()) {
			TIKET = new tiket(rs.getInt("Id"), rs.getString("TipUsluge"), rs.getString("NaslovProblema"),
					rs.getString("ImeOsobe"),DateConverter.parse(rs.getObject("Datum")), rs.getString("NacinPrijave"),
					rs.getString("Prioritet"), rs.getString("Opis"),rs.getString("Agent"),rs.getString("Email"),rs.getString("Telefon")
					,rs.getString("Statusy"), DateConverter.parse(rs.getObject("DatumRjesavanja")));
			

		}
		return TIKET;
	}
	
}