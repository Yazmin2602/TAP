package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {
    @FXML Canvas lienzo;
    GraphicsContext context;
    @FXML Slider slider;
    @FXML ComboBox comboOpciones;
    @FXML ColorPicker ColorPicker;
    Color colorPincel=Color.BLACK;
    @FXML protected void initialize(){
        context=lienzo.getGraphicsContext2D();
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                pintarDibujos(t1.intValue());
            }
        });
        comboOpciones.getItems().addAll("Cuadricula","Ajedrez","Estrella","Estrella doble");
//traer prixeles

      /* context.setFill(Color.BLUE);//fill relleno color a pintar
        context.fillRect(10,20,100,50);
        context.setFill(Color.RED);
        context.strokeRect(200,150,200,100);
        context.strokeRect(400,250,200,100);
        context.setFill(Color.AQUA);
        context.fillOval(375,375,50,50);
        context.strokeLine(0,0,lienzo.getWidth(),lienzo.getHeight());*/

    }
    public void pintarDibujos(int valor){
        context.setFill(Color.WHITESMOKE);
        context.fillRect(0,0,lienzo.getWidth(),lienzo.getHeight());
        context.setFill(colorPincel);
        System.out.println(valor);
        if(comboOpciones.getSelectionModel().getSelectedIndex()==0){
//cuadricula
            int divisiones=(int) lienzo.getWidth()/valor;
            for(int x=1;x<valor+1;x++){
                context.strokeLine(0,divisiones*x,lienzo.getWidth(),divisiones*x);
                context.strokeLine(divisiones*x,0,divisiones*x,lienzo.getHeight());
            }
        }else if(comboOpciones.getSelectionModel().getSelectedIndex()==1){
            int divisiones=(int) lienzo.getWidth()/valor;
            boolean a=true;
            for(int z=0;z<valor;z++){
                for(int y=0;y<valor;y++){
                    if(a==true)context.setFill(Color.WHITE);
                    else context.setFill(Color.BLACK);
                    a=!a;
                    context.fillRect(y*divisiones,z*divisiones,divisiones,divisiones);
                }
                if(valor%2==0)a=!a;
            }
//ajedrez
        }else if(comboOpciones.getSelectionModel().getSelectedIndex()==2){
            int mitadAncho=((int)lienzo.getWidth())/2;
            int mitadAlto=((int)lienzo.getHeight())/2;
            context.strokeLine(mitadAncho,0,mitadAncho,lienzo.getHeight());
            context.strokeLine(0,mitadAlto,lienzo.getWidth(),mitadAlto);
            int divisiones=mitadAncho/valor;
            for(int j=1;j<valor+1;j++){
                context.strokeLine(mitadAncho,divisiones*j,mitadAncho+(divisiones*j),mitadAlto);
                context.strokeLine(mitadAncho,divisiones*j,mitadAncho+(divisiones*-j),mitadAlto);
                context.strokeLine(divisiones*j,mitadAlto,mitadAncho,mitadAncho+(divisiones*j));
                context.strokeLine(mitadAncho+(divisiones*j),mitadAlto,mitadAncho,lienzo.getHeight()-(divisiones*j));
            }
//Estrella
        }else if(comboOpciones.getSelectionModel().getSelectedIndex()==3){
            //estrella doble
        }
    }
    public void cambiarColor(ActionEvent event){
        colorPincel=ColorPicker.getValue();
    }
    public void borrar(ActionEvent event){
        context.setFill(Color.WHITESMOKE);
        context.fillRect(0,0,lienzo.getWidth(),lienzo.getHeight());

    }
    public void arrastrar(MouseEvent event){
        context.setFill(colorPincel);
        context.fillOval(event.getX(),event.getY(),10,10);

    }
}
