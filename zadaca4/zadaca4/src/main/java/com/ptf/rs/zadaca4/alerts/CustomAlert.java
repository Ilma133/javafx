package com.ptf.rs.zadaca4.alerts;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class CustomAlert {
	
	public static Optional<ButtonType> showConfirmation(
		String headerText,
		String title,
		String contentText,
		String okText,
		String cancelText
		) {
		
		if(headerText.isEmpty()) {
			headerText = "Potvrda";
		}
		if(title.isEmpty()) {
			title = "Potvrda";
		}
		if(contentText.isEmpty()) {
			contentText = "Da li ste sigurni?";
		}
		if(okText.isEmpty()) {
			okText = "Uredu";
		}
		if(cancelText.isEmpty()) {
			cancelText = "Odustani";
		}
		
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setContentText(contentText);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
		okButton.setText(okText);
		Button cancelButton = (Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL);
		cancelButton.setText(cancelText);
		
		return alert.showAndWait();
	}
}
