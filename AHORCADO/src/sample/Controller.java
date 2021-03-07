package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.util.Random;

public class Controller {
    @FXML HBox contenedor;
    @FXML AnchorPane padre;
    String[] palabras={"CELULAR","COMPUTADORA","TELEVISION","XBOX","CARGADOR","CABLE","CONTROL"};
    TextField[] arrayText=null;
    int contadorerror=0;
    @FXML protected void initialize(){
        Random random=new Random();
        int aleatorio=random.nextInt(6);
        String palabra=palabras[aleatorio].toLowerCase();
        System.out.println(palabra);
        arrayText=new TextField[palabra.length()];
        int ayuda=1;



        for (int x=0;x<palabra.length();x++){
            arrayText[x]= new TextField();
            arrayText[x].setPrefWidth(50);
            arrayText[x].setPrefHeight(50);
            arrayText[x].setId("txt-"+x+"-"+palabra.charAt(x));
            arrayText[x].setOnKeyReleased(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    TextField textField=(TextField) event.getTarget();
                    String[] nombre=textField.getId().split("-");
                    if(nombre[2].equals(textField.getText().toLowerCase())){
                        System.out.println("CORRECTO"+textField.getId());
                        textField.setDisable(true);
                    }else{

                        System.out.println("INCORRECTO"+textField.getId());
                        textField.setText("");
                        if(contadorerror==0){
                           Cabeza();
                           contadorerror++;
                        }else if(contadorerror==1){
                            Cuerpo();
                            contadorerror++;
                        }else if(contadorerror==2){
                            Pies();
                            contadorerror++;
                        }else if(contadorerror==3){
                            brazo();
                            contadorerror++;
                        }else if(contadorerror==4){
                            brazo2();
                            contadorerror++;
                            Alert alerta=new Alert(Alert.AlertType.INFORMATION);
                            alerta.setContentText("JUEGO TERMINADO");
                            alerta.show();
                        }

                    }

                }
            });
            contenedor.getChildren().add(arrayText[x]);
        }
    }
    public void Cabeza(){
        ImageView Cabezaaa=new ImageView(new Image("sample/img/Cabezaaa.png"));
        Cabezaaa.setFitHeight(70);
        Cabezaaa.setFitWidth(70);
        Cabezaaa.setLayoutX(200);
        Cabezaaa.setLayoutY(200);
        padre.getChildren().addAll(Cabezaaa);
    }
    public void Cuerpo(){
        ImageView Cuerpo=new ImageView(new Image("sample/img/Cuerpo.png"));
        Cuerpo.setFitHeight(70);
        Cuerpo.setFitWidth(70);
        Cuerpo.setLayoutX(210);
        Cuerpo.setLayoutY(265);
        padre.getChildren().addAll(Cuerpo);
    }
    public void Pies(){
        ImageView Pies=new ImageView(new Image("sample/img/Pies.png"));
        Pies.setFitHeight(70);
        Pies.setFitWidth(70);
        Pies.setLayoutX(210);
        Pies.setLayoutY(325);
        padre.getChildren().addAll(Pies);
    }
    public void brazo(){
        ImageView brazouno=new ImageView(new Image("sample/img/brazouno.png"));
        brazouno.setFitHeight(70);
        brazouno.setFitWidth(70);
        brazouno.setLayoutX(145);
        brazouno.setLayoutY(275);
        padre.getChildren().addAll(brazouno);
    }
    public void brazo2(){
        ImageView brazoo2=new ImageView(new Image("sample/img/brazoo2.png"));
        brazoo2.setFitHeight(70);
        brazoo2.setFitWidth(70);
        brazoo2.setLayoutX(270);
        brazoo2.setLayoutY(235);
        padre.getChildren().addAll(brazoo2);
    }
}
