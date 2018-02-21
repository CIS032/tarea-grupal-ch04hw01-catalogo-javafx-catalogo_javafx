/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jorgefx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.NumberBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import javax.swing.ImageIcon;

/**
 *
 * @author Personal
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ComboBox cmcolor;
    @FXML
    private ComboBox cmbfigura;
    @FXML
    private Circle circulo;
    @FXML
    private Rectangle rectangulo;
    @FXML
    private Ellipse elipse;
    @FXML
    private Slider sldtamanio;
    @FXML
    private TextField txtvalor;
    @FXML
    private Label labelgra;
    @FXML
    private void cmcolorAction(ActionEvent event) {
        String valor = (String) cmcolor.getValue();
        switch (valor) {
            case "Yellow":
                circulo.setFill(Paint.valueOf("Yellow"));
                rectangulo.setFill(Paint.valueOf("Yellow"));
                elipse.setFill(Paint.valueOf("Yellow"));
                break;
            case "Red":
                circulo.setFill(Paint.valueOf("Red"));
                rectangulo.setFill(Paint.valueOf("Red"));
                elipse.setFill(Paint.valueOf("Red"));
                break;
            case "Blue":
                circulo.setFill(Paint.valueOf("Blue"));
                rectangulo.setFill(Paint.valueOf("Blue"));
                elipse.setFill(Paint.valueOf("Blue"));
                break;
        }
    }

    @FXML
    private void cmbfiguraAction(ActionEvent event) {
        String valor = (String) cmbfigura.getValue();
        switch (valor) {
            case "Circulo":
                circulo.setVisible(true);
                rectangulo.setVisible(false);
                elipse.setVisible(false);
                break;
            case "Rectangulo":
                circulo.setVisible(false);
                rectangulo.setVisible(true);
                elipse.setVisible(false);
                break;
            case "Elipse":
                circulo.setVisible(false);
                rectangulo.setVisible(false);
                elipse.setVisible(true);
                break;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NumberBinding tamaElipseX = sldtamanio.valueProperty().add(30);
        NumberBinding tamaElipseY = sldtamanio.valueProperty().add(0);
        elipse.radiusXProperty().bind(tamaElipseX);
        elipse.radiusYProperty().bind(tamaElipseY);
        NumberBinding tamanio = sldtamanio.valueProperty().add(0);
        circulo.radiusProperty().bind(tamanio);
        rectangulo.setVisible(false);
        elipse.setVisible(false);
        cmcolor.getItems().removeAll(cmcolor.getItems());
        cmcolor.getItems().addAll("Red", "Blue", "Yellow");
        cmcolor.getSelectionModel().select("Blue");
        StringConverter<Number> converter = new NumberStringConverter();
        txtvalor.textProperty().bindBidirectional(sldtamanio.valueProperty(), converter);
        cmbfigura.getItems().removeAll(cmbfigura.getItems());
        cmbfigura.getItems().addAll("Circulo", "Rectangulo", "Elipse");
        cmbfigura.getSelectionModel().select("Circulo");
        rectangulo.heightProperty().bind(tamanio);
        rectangulo.widthProperty().bind(tamanio.add(40));
        Image image = new Image(getClass().getResourceAsStream("unl_logo.jpg"));
        labelgra.setGraphic(new ImageView(image));
    }

}
