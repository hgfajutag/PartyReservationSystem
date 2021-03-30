package ui;

import java.time.LocalDate;
import java.util.List;

import object.Party;
import object.Place;
import object.PartyInstance;
import object.Guest;
import object.Reservation;
import object.Pass;
import service.ReservationSystemFacade;
import service.ReservationSystemFacadeImpl;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class userInterfaceHOST extends Application {
	ReservationSystemFacade dataSource = new ReservationSystemFacadeImpl();
	
	
	RadioButton host = new RadioButton("Host");
	RadioButton requestReservation = new RadioButton("Request Reservation");

	TextField id = new TextField();
	TextField idPass = new TextField();
	TextField deparAiro = new TextField();
	TextField arrivAiro = new TextField();
	TextField date = new TextField();
	TextField reservationCode = new TextField();
	TextField city = new TextField();
	TextField flightNumber = new TextField();

	/////////////////////////// For scene Make
	/////////////////////////// reservation//////////////////////////////////

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) {

		stage.setTitle("Reservation System For HOST");
		stage.getIcons().add(new Image("/ui/icon.png"));

		
/////////////////////////////////////
		Button btShowPlace = new Button("Places");
		Button btViewlistparties = new Button("Parties by Places");
		Button btViewlistlocations = new Button("locations");
		Button btmyreservations = new Button("Reservations");
		Button btRequestReservation = new Button("Make a reservation");
		Button btCancelReservation = new Button("Cancel a Reservation");
		Button btmyguest = new Button("Guests ");
		Button btConfirmeReservation = new Button("Confirm Reservation");

		final ToggleGroup group = new ToggleGroup();
		host.setToggleGroup(group);
///////////////////////////////////////
		BorderPane bPane = new BorderPane();
		FlowPane flowpane1 = new FlowPane();
		FlowPane flowpane2 = new FlowPane();
		flowpane1.setAlignment(Pos.CENTER);
		flowpane2.setAlignment(Pos.CENTER);
////////////////////////////////////////
		GridPane gridP = new GridPane();
		gridP.setPadding(new Insets(7, 7, 7, 7));
		gridP.setAlignment(Pos.CENTER);
		gridP.setHgap(10);
		gridP.setVgap(10);
		gridP.setPadding(new Insets(25, 25, 25, 25));
		gridP.add(host, 0, 0);
		gridP.add(requestReservation, 0, 1);

/////////////////////////////////////////
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(7, 7, 7, 7));
		grid.add(new Text("ID"), 0, 0);
		grid.add(id, 0, 1);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
/////////////////////////////////////////
		GridPane grid0 = new GridPane();
		grid0.setPadding(new Insets(7, 7, 7, 7));
		grid0.add(new Text("ID Passenger"), 0, 0);
		grid0.add(idPass, 0, 1);
		grid0.setAlignment(Pos.CENTER);
		grid0.setHgap(10);
		grid0.setVgap(10);
		grid0.setPadding(new Insets(25, 25, 25, 25));
/////////////////////////////////////////
		GridPane grid1 = new GridPane();
		grid1.setPadding(new Insets(7, 7, 7, 7));
		grid1.add(new Text("Departure"), 0, 0);
		grid1.add(deparAiro, 0, 1);
		grid1.setAlignment(Pos.CENTER);
		grid1.setHgap(10);
		grid1.setVgap(10);
		grid1.setPadding(new Insets(25, 25, 25, 25));
////////////////////////////////////////
		GridPane grid2 = new GridPane();
		grid2.setPadding(new Insets(7, 7, 7, 7));
		grid2.add(new Text("Arrival"), 0, 0);
		grid2.add(arrivAiro, 0, 1);
		grid2.setAlignment(Pos.CENTER);
		grid2.setHgap(10);
		grid2.setVgap(10);
		grid2.setPadding(new Insets(25, 25, 25, 25));
////////////////////////////////////////
		GridPane grid3 = new GridPane();
		grid3.setPadding(new Insets(7, 7, 7, 7));
		grid3.add(new Text("Date (YYYY-MM-DD)"), 0, 0);
		grid3.add(date, 0, 1);
		grid3.setAlignment(Pos.CENTER);
		grid3.setHgap(10);
		grid3.setVgap(10);
		grid3.setPadding(new Insets(25, 25, 25, 25));
////////////////////////////////////////
		GridPane grid4 = new GridPane();
		grid4.setPadding(new Insets(7, 7, 7, 7));
		grid4.add(new Text("reservation Code"), 0, 0);
		grid4.add(reservationCode, 0, 1);
		grid4.setAlignment(Pos.CENTER);
		grid4.setHgap(10);
		grid4.setVgap(10);
		grid4.setPadding(new Insets(25, 25, 25, 25));
		GridPane gridC = new GridPane();
		gridC.setPadding(new Insets(7, 7, 7, 7));
		gridC.add(new Text("City"), 0, 0);
		gridC.add(city, 0, 1);
		gridC.setAlignment(Pos.CENTER);
		gridC.setHgap(10);
		gridC.setVgap(10);
		gridC.setPadding(new Insets(25, 25, 25, 25));
////////////////////////////////////////
		/*
		 * GridPane grid5 = new GridPane(); grid5.setPadding(new Insets(7, 7, 7, 7));
		 * grid5.add(new Text("location Number"), 0, 0); grid5.add(locationNumber,0,1 );
		 */
////////////////////////////////////////
		flowpane1.getChildren().add(gridP);
		flowpane1.getChildren().add(grid);
		flowpane1.getChildren().add(grid0);
		flowpane1.getChildren().add(grid1);
		flowpane1.getChildren().add(grid2);
		flowpane1.getChildren().add(grid3);
		flowpane1.getChildren().add(grid4);
		flowpane1.getChildren().add(gridC);
		flowpane1.setHgap(10);
		flowpane1.setVgap(5);
		grid0.setVisible(false);
		host.setSelected(true);
		btRequestReservation.setVisible(false);

////////////////////////////////////////
		flowpane2.getChildren().add(btShowPlace);
		flowpane2.getChildren().add(btViewlistparties);
		flowpane2.getChildren().add(btViewlistlocations);
		flowpane2.getChildren().add(btmyreservations);
		flowpane2.getChildren().add(btmyguest);
		flowpane2.getChildren().add(btConfirmeReservation);
		flowpane2.getChildren().add(btRequestReservation);
		flowpane2.getChildren().add(btCancelReservation);
		flowpane2.setAlignment(Pos.CENTER);
		flowpane2.setHgap(10);
		flowpane2.setVgap(10);
		flowpane2.setPadding(new Insets(10, 10, 10, 10));
//////////////////////////////////////////////////
		bPane.setTop(flowpane1);
		bPane.setBottom(flowpane2);
		flowpane2.setPadding(new Insets(7, 7, 7, 7));
//////////////////////////////////////////////////
		requestReservation.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (requestReservation.isSelected()) {
					btRequestReservation.setVisible(true);
					btViewlistparties.setVisible(false);
					btShowPlace.setVisible(false);
					btViewlistlocations.setVisible(false);
					btmyreservations.setVisible(false);
					btmyguest.setVisible(false);
					btConfirmeReservation.setVisible(false);
					btCancelReservation.setVisible(false);
					grid3.setVisible(true);
					grid4.setVisible(false);
					gridC.setVisible(false);
					if (host.isSelected()) {
						grid0.setVisible(true);
					}
				} else {
					btRequestReservation.setVisible(false);
					btViewlistparties.setVisible(true);
					btShowPlace.setVisible(true);
					btViewlistlocations.setVisible(true);
					btmyreservations.setVisible(true);
					btmyguest.setVisible(true);
					btConfirmeReservation.setVisible(true);
					btCancelReservation.setVisible(true);
					grid0.setVisible(false);
					grid3.setVisible(true);
					grid4.setVisible(true);
					gridC.setVisible(true);

				}

			}
		});
////////////////////////////////////////////////
		host.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (host.isSelected()) {
					if (requestReservation.isSelected())
						grid0.setVisible(true);
				}
			}
		});
////////////////////////////////////////////////
		
////////////////////////////////////////////////
		btShowPlace.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!city.getText().trim().equals("") && deparAiro.getText().trim().equals("")) {
					for (Place airoport : dataSource.findPlacesByCity(city.getText()))
						System.out.println(airoport);
					System.out
							.println("##############################################################################");

					return;
				}

				if (deparAiro.getText().trim().equals("")) {
					for (Place airoport : dataSource.findAllPlaces())
						System.out.println(airoport);
					System.out
							.println("##############################################################################");

				}

				else {
					System.out.println(dataSource.findPlaceByPlaceCode(deparAiro.getText()));
					System.out
							.println("##############################################################################");
				}

			}
		});
///////////////////////////////////////////////////
		btViewlistparties.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!deparAiro.getText().trim().equals("")) {
					for (Party party : dataSource.findPartiesByPlaceCode(deparAiro.getText()))
						System.out.println(party);
					System.out
							.println("##############################################################################");

				}
			}
		});
///////////////////////////////////////////////////
		btViewlistlocations.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!deparAiro.getText().trim().equals("") && !arrivAiro.getText().trim().equals("")
						&& !date.getText().trim().equals("")) {

					String date1 = date.getText();
					LocalDate localDate = LocalDate.parse(date1);

					List<PartyInstance> partyInstances = dataSource.findlocationsFromTo(deparAiro.getText(),
							arrivAiro.getText(), localDate);

					for (PartyInstance party : partyInstances) {
						System.out.println(party);
					}

					if (partyInstances.size() == 0) {
						String msg = String.format("There is no any party from %s to %s at %s ", deparAiro.getText(),
								arrivAiro.getText(), localDate);
						System.out.println(msg);
					}

					System.out
							.println("##############################################################################");

				}
			}
		});
///////////////////////////////////////////////////
		btmyreservations.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

			

				if (host.isSelected() && !id.getText().trim().equals("")) {
					for (Reservation reservation : dataSource.findReservationsByhostId(id.getText()))
						System.out.println(reservation);
					System.out
							.println("##############################################################################");
				}

			}
		});
///////////////////////////////////////////////////
		btmyguest.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (host.isSelected() && !id.getText().trim().equals("")) {
					for (Guest guest : dataSource.findGuestsByhostCode(id.getText()))
						System.out.println(guest);
					System.out
							.println("##############################################################################");
				}
			}
		});
		///////////////////////////////////////////////////
		btRequestReservation.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!deparAiro.getText().trim().equals("") && !arrivAiro.getText().trim().equals("")
						&& !date.getText().trim().equals("")) {

					String departure = deparAiro.getText();
					String arrival = arrivAiro.getText();
					String date1 = date.getText();
					LocalDate localDate = LocalDate.parse(date1);

					List<PartyInstance> partyInstances = dataSource.findLocationsFromTo(departure, arrival, localDate);

					if (partyInstances.size() == 0) {
						String msg = String.format("Can not make find Location from %s to %s at %s ", departure, arrival,
								localDate);
						System.out.println(msg);
						return;
					}

					if (host.isSelected() && !id.getText().trim().equals("") && !idPass.getText().trim().equals("")) {
						Reservation reservation = dataSource.createReservation(id.getText(), idPass.getText(),
								partyInstances);
						System.out.println(reservation);
					}
			

				}
			}
		});
///////////////////////////////////////////////////
		btCancelReservation.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!reservationCode.getText().trim().equals("")) {
					boolean var = dataSource.cancelReservation(reservationCode.getText());
					if (var)
						System.out.println("the reservation is successfully removed");
					else
						System.out.println("the reservation not Found");

				}
			}
		});
///////////////////////////////////////////////////

		btConfirmeReservation.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!reservationCode.getText().trim().equals("")) {
					List<Pass> var = dataSource.confirmReservation(reservationCode.getText());
					if (var.size() == 0)
						System.out.println("the reservation not Found");
					else
						for (Pass pass : var)
							System.out.println(pass);
					System.out
							.println("##############################################################################");
				}
			}
		});

//////////////////////////////////////////////////
		stage.setScene(new Scene(bPane, 1000,300));
		bPane.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
		stage.show();

	}

}