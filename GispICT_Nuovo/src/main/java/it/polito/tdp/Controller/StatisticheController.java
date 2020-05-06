/**
 * Sample Skeleton for 'Statistiche.fxml' Controller Class
 */

package it.polito.tdp.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.GispICT.Farmaco;
import it.polito.tdp.GispICT.FarmacoNelReparto;
import it.polito.tdp.db.MartaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class StatisticheController {
	MartaDAO dao=new MartaDAO();
	int id=106;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="grafico"
    private ImageView grafico; // Value injected by FXMLLoader

    @FXML // fx:id="cmbFarmaco"
    private ComboBox<Farmaco> cmbFarmaco; // Value injected by FXMLLoader

    @FXML // fx:id="btnBack"
    private Button btnBack; // Value injected by FXMLLoader
    @FXML // fx:id="image2"
    private ImageView image2; // Value injected by FXMLLoader

    @FXML
    void handleBack(ActionEvent event) throws IOException {
    	
    	Parent secondaSchermataParent=FXMLLoader.load(getClass().getResource("/fxml/FinestraHome.fxml"));
    	Scene secondaSchermataScene=new Scene(secondaSchermataParent);
    	//Questa riga prende le informazioni dello stage
    	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(secondaSchermataScene);
    	window.show();
    }
    @FXML
    void handleMostraGrafico(ActionEvent event) {
    	Farmaco f=new Farmaco (1,"Oki");
    	if(cmbFarmaco.getValue().equals(f)) {
    		image2.setVisible(true);
    		grafico.setVisible(false);
    	}
    	else {
    		image2.setVisible(false);
    		grafico.setVisible(true);
    	}
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
       
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'Statistiche.fxml'.";
        assert grafico != null : "fx:id=\"grafico\" was not injected: check your FXML file 'Statistiche.fxml'.";
        assert cmbFarmaco != null : "fx:id=\"cmbFarmaco\" was not injected: check your FXML file 'Statistiche.fxml'.";
        assert image2 != null : "fx:id=\"image2\" was not injected: check your FXML file 'Statistiche.fxml'.";
        popola();
    }
	private void popola() {
		
		List <Farmaco> farmaci=new ArrayList<Farmaco>();
		farmaci=dao.getFarmaci();
		System.out.println(farmaci);
		cmbFarmaco.getItems().addAll(farmaci);
		
	}
}
