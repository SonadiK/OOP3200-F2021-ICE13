/*
* Sonadi Kannangara #100778336
* ICE13
* OOP3200 - F2021
* 13 December 2021*/
package ca.durhamcollege.oop3200f2021ice12;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application
{
    public static int WIDTH = 640;
    public static int HEIGHT = 480;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Hello World!");


        // Step1: - create one or more control
        //Label helloLabel = new Label("Hello World!");
        Label imageLabel = new Label("Xbox Series X!");

//        Label goodByeLabel = new Label("Good Bye!");
//
//        Label anotherLabel = new Label("Another Label");
//
//        Label yetAnotherLabel = new Label("Yet Another Label");

        Button clickMeButton = new Button("Click me");
        clickMeButton.setStyle("-fx-font-family: Arial;");

        // Step 1 for images: Load the image
        FileInputStream imagePath = new FileInputStream("src\\main\\java\\ca\\durhamcollege\\oop3200f2021ice12\\xboxseriesx.jpg");
        //Image xboxSeriesX = new Image("file:src\\main\\java\\ca\\durhamcollege\\oop3200f2021ice12\\xboxseriesx.jpg");
        Image xboxSeriesX = new Image(imagePath);
        // Step 2 : set up an ImageView to "contain it"
        ImageView consoleImageView = new ImageView(xboxSeriesX);
        consoleImageView.setFitWidth(400);
        consoleImageView.setPreserveRatio(true);

        FileInputStream ps5Path = new FileInputStream("src\\main\\java\\ca\\durhamcollege\\oop3200f2021ice12\\ps5.jpg");
        Image ps5 = new Image(ps5Path);

        // Step 1.1 - Configure your controls
//        Font font = Font.font("Consolas", FontWeight.BOLD, 20);
//        clickMeButton.setFont(font);

        class ButtonClickHandler implements EventHandler<ActionEvent>
        {
            @Override
            public void handle(ActionEvent event)
            {
                imageLabel.setText("PS5!");
                consoleImageView.setImage(ps5);
            }
        }

        clickMeButton.setOnAction(new ButtonClickHandler());

        // Step 1.2 - For button controls (or other event-type controls) - set the event
//        clickMeButton.setOnAction(new EventHandler<ActionEvent>()
//        {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                //System.out.println("ClickMe Button Clicked!");
//
//                //helloLabel.setText("Clicked!");
//                imageLabel.setText("PS5!");
//                consoleImageView.setImage(ps5);
//            }
//        });

    // Step 2 - create a container
    // HBox hbox = new HBox(helloLabel, clickMeBUtton);

    //VBox vbox = new VBox(helloLabel, clickMeBUtton);HBox hbox = new HBox();
        HBox hbox = new HBox(10, imageLabel);
        //hbox.setAlignment(Pos.CENTER);
        hbox.setStyle("-fx-alignment: center; -fx-font-size: 20px;");

        //HBox hbox2 = new HBox(10, anotherLabel, yetAnotherLabel);
        HBox hbox2 = new HBox(10, consoleImageView);
        hbox2.setAlignment(Pos.CENTER);

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(6,8);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        gridPane.add(hbox, 0, 0);
        gridPane.add(hbox2, 0, 1);
        gridPane.add(consoleImageView, 0,2);
        gridPane.add(clickMeButton, 2, 2);

        //gridPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        gridPane.setStyle("-fx-border-color: black; -fx-font-size: 20px; -fx-font-family: Consolas;" +
                " -fx-font-weight: bold;");
        // Step 3 - add layout container to scene
        Scene scene = new Scene(gridPane, WIDTH, HEIGHT);

        // Step 4 - add scene to stage
            primaryStage.setScene(scene);

            primaryStage.show();
}


    public static void main(String[] args) {
        launch(args);
    }
}