package com.ptf.rs.zadaca4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.ptf.rs.zadaca4.controllers.*;



/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static FXMLLoader loader;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("pocetna"));
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        
        tiketcontroller tiketcontroller = (tiketcontroller)loader.getController();
        
        
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    public static void setContent(String xml) throws IOException {
    	Parent pane = loadFXML(xml);
    	
    }
    
    @SuppressWarnings("exports")
   	public static FXMLLoader getLoader() {
       	return loader;
       }

    private static Parent loadFXML(String fxml) throws IOException {
    	 loader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
         return loader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}