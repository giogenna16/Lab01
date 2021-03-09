package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnDelete;

    @FXML
    void doInsert(ActionEvent event) {
    	String s= this.txtParola.getText();
    	String paroleElenco="";
    	elenco.addParola(s);
    	
    	
    	for(String temp: this.elenco.getElenco())
    		paroleElenco+=temp+"\n";
    		
    	
    	this.txtResult.setText(paroleElenco);
    	this.txtParola.setText("");
    
    }

    @FXML
    void doReset(ActionEvent event) {
    	elenco.reset();
    	this.txtParola.setText("");
    	this.txtResult.setText("");
    }
    
    @FXML
    void doDelete(ActionEvent event) {
    	String s = this.txtResult.getSelectedText();
    	String paroleElenco="";
    	elenco.delete(s);
    	
    	for(String temp: this.elenco.getElenco())
    		paroleElenco+=temp+"\n";
    	
    	this.txtResult.setText(paroleElenco);
    	
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
