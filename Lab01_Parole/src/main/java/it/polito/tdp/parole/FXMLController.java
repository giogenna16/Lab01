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
    private TextArea txtTempi;

    @FXML
    void doInsert(ActionEvent event) {
    	
    	String s= this.txtParola.getText();
    	String paroleElenco="";
    	
    	long tempoIniziale=System.nanoTime();
    	elenco.addParola(s);
    	long tempoFinale=System.nanoTime();
    	
    	for(String temp: this.elenco.getElenco())
    		paroleElenco+=temp+"\n";
    		
    	
    	this.txtResult.setText(paroleElenco);
    	this.txtParola.setText("");
    	
    	
    	this.txtTempi.setText("Il tempo di esecuzione del comando è pari a "+(tempoFinale-tempoIniziale)+" nanosecondi");
    
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	elenco.reset();
    	this.txtParola.setText("");
    	this.txtResult.setText("");
    	this.txtTempi.setText("");
    }
    
    @FXML
    void doDelete(ActionEvent event) {
    	
    	String s = this.txtResult.getSelectedText();
    	
    	String paroleElenco="";
    	
    	long tempoIniziale=System.nanoTime();
    	elenco.delete(s);
    	long tempoFinale=System.nanoTime();
    	
    	for(String temp: this.elenco.getElenco())
    		paroleElenco+=temp+"\n";
    	
    	this.txtResult.setText(paroleElenco);
    	
    	
    	this.txtTempi.setText("Il tempo di esecuzione del comando è pari a "+(tempoFinale-tempoIniziale)+" nanosecondi");
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
