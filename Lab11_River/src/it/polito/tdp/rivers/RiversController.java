package it.polito.tdp.rivers;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.rivers.model.Model;
import it.polito.tdp.rivers.model.River;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RiversController 
{
	Model m = new Model();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<River> boxRiver;

    @FXML
    private TextField txtEndDate;

    @FXML
    private TextField txtNumMeasurements;

    @FXML
    private TextArea txtResult;

    @FXML
    private TextField txtStartDate;

    @FXML
    private TextField txtFMed;

    @FXML
    private Button btnSimula;

    @FXML
    private TextField txtK;

    @FXML
    void doSimula(ActionEvent event) 
    {
    	double K = Double.parseDouble(txtK.getText());
    	m.simula(boxRiver.getValue(), K);
    	txtResult.clear();
    	txtResult.appendText("Numero giorni mancati: "+m.getNumeroGiorni()+"\nBacino medio: "+ m.getOccupazione());
    }
    
    @FXML
    void initialize() 
    {
        assert boxRiver != null : "fx:id=\"boxRiver\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtEndDate != null : "fx:id=\"txtEndDate\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtNumMeasurements != null : "fx:id=\"txtNumMeasurements\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtStartDate != null : "fx:id=\"txtStartDate\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtFMed != null : "fx:id=\"txtFMed\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtK != null : "fx:id=\"txtK\" was not injected: check your FXML file 'Rivers.fxml'.";
        
        for (River r : m.getRivers())
        {
        	boxRiver.getItems().add(r);
		}
        
        boxRiver.valueProperty().addListener(new ChangeListener<River>() 
        {
			@Override
			public void changed(ObservableValue<? extends River> observable, River oldValue, River newValue) 
			{
				txtStartDate.setText(m.getStartDate(newValue).toString());
				txtEndDate.setText(m.getEndDate(newValue).toString());
				txtFMed.setText(m.mediaMisurazioni(newValue)+"");
				txtNumMeasurements.setText(""+m.numTotFlow(newValue));	
			}
		});
    }
}
