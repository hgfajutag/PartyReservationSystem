package ui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import dbcon.ConnectionDB;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import object.Address;
import object.Agent;

public class Login extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Reservation System LOGIN");
		
		primaryStage.getIcons().add(new Image("/ui/icon.png"));
		
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Welcome to our Reservation System ");
		// setting id for CSS styling
		scenetitle.setId("welcome-text");
		grid.add(scenetitle, 0, 0, 2, 1);

		Label userName = new Label("Email:");
		grid.add(userName, 0, 1);

		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);

		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);

		PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 1, 2);

		Button btn = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);

		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);
		// setting id for CSS styling
		actiontarget.setId("actiontarget");

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				HashMap<String, String> users = new HashMap<String, String>();

				String usermail = userTextField.getText();
				String password = pwBox.getText();
				String usertype = "";
				try {

					Connection k = ConnectionDB.conn(); 
					Statement stmt6=k.createStatement(); 
					ResultSet p=stmt6.executeQuery("select 	typeofperson FROM person WHERE email ='"+usermail+"' and password='"+password+"'");  

					while(p.next()) {  
						usertype = p.getString(1);
						System.out.println(usertype);
					}
				}catch(SQLException r) {
					System.out.println(r);
				}

				
				
//				 keys and values (Username, Password)
//				passanger  => Email : hannap_12@gmail.com   Passwrod : 12
//				agent      => Email : ayoub_12@gmail.com	Passwrod : 12
//				admin      => Email : alba_12@gmail.com	    Passwrod : 12
// testing my branch
				
				
				
				if (usertype.equals(""))
					actiontarget.setText("Invalid Input!");
				else if (usertype.equals("ADMIN")) {
					new userInterfaceADMIN().start(new Stage());
					primaryStage.close();
				} else if (usertype.equals("PASSENGER")) {
					new userInterfacePASSENGER().start(new Stage());
					primaryStage.close();
				} else if (usertype.equals("AGENT")) {
					new userInterfaceAGENT().start(new Stage());
					primaryStage.close();
				}
				actiontarget.setText("Invalid Input!");
				
				
			}
		});

		Scene scene = new Scene(grid, 900, 300);
		primaryStage.setScene(scene);

		scene.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
		primaryStage.show();
	}
}
