package ui;
import java.time.LocalDate;
import java.util.List;


import object.Airline;
import object.Airport;
import object.FlightInstance;
import object.Passenger;
import object.Reservation;
import object.Ticket;
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

public class userInterface extends Application {
	ReservationSystemFacade dataSource = new ReservationSystemFacadeImpl();
	RadioButton host = new RadioButton("Host");
	RadioButton guest = new RadioButton("Guest");
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

		stage.setTitle("Address Form");
		stage.getIcons().add(new Image("/ui/icon.png"));
/////////////////////////////////////
		Button btShowAirPort = new Button("Airports");
		Button btViewlistairlines = new Button("Airlines by Airports");
		Button btViewlistflights = new Button("Flights");
		Button btmyreservations = new Button("Reservations");
		Button btMakeReservation = new Button("Make a reservation");
		Button btCancelReservation = new Button("Cancel a Reservation");
		Button btmypassenger = new Button("Passengers ");
		Button btConfirmeReservation = new Button("Confirm Reservation");

		final ToggleGroup group = new ToggleGroup();
		agent.setToggleGroup(group);
		passenger.setToggleGroup(group);
///////////////////////////////////////
		BorderPane bPane = new BorderPane();
		FlowPane flowpane1 = new FlowPane();
		FlowPane flowpane2 = new FlowPane();
		flowpane1.setAlignment(Pos.CENTER);
		flowpane2.setAlignment(Pos.CENTER);
////////////////////////////////////////
		GridPane gridP = new GridPane();
		gridP.setPadding(new Insets(7, 7, 7, 7));
		gridP.add(agent, 0, 0);
		gridP.add(passenger, 0, 1);
		gridP.add(makeReservation, 0, 2);

/////////////////////////////////////////
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(7, 7, 7, 7));
		grid.add(new Text("ID"), 0, 0);
		grid.add(id, 0, 1);
/////////////////////////////////////////
		GridPane grid0 = new GridPane();
		grid0.setPadding(new Insets(7, 7, 7,7));
		grid0.add(new Text("ID Passenger"), 0, 0);
		grid0.add(idPass, 0, 1);
/////////////////////////////////////////
		GridPane grid1 = new GridPane();
		grid1.setPadding(new Insets(7, 7, 7, 7));
		grid1.add(new Text("Departure"), 0, 0);
		grid1.add(deparAiro, 0, 1);
////////////////////////////////////////
		GridPane grid2 = new GridPane();
		grid2.setPadding(new Insets(7, 7, 7, 7));
		grid2.add(new Text("Arrival"), 0, 0);
		grid2.add(arrivAiro, 0, 1);
////////////////////////////////////////
		GridPane grid3 = new GridPane();
		grid3.setPadding(new Insets(7, 7, 7, 7));
		grid3.add(new Text("Date (YYYY-MM-DD)"), 0, 0);
		grid3.add(date, 0, 1);
////////////////////////////////////////
		GridPane grid4 = new GridPane();
		grid4.setPadding(new Insets(7, 7, 7, 7));
		grid4.add(new Text("reservation Code"), 0, 0);
		grid4.add(reservationCode, 0, 1);
		GridPane gridC = new GridPane();
		gridC.setPadding(new Insets(7, 7, 7, 7));
		gridC.add(new Text("City"), 0, 0);
		gridC.add(city, 0, 1);
////////////////////////////////////////
		/*
		 * GridPane grid5 = new GridPane(); grid5.setPadding(new Insets(7, 7, 7, 7));
		 * grid5.add(new Text("Flight Number"), 0, 0); grid5.add(flightNumber,0,1 );
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
		passenger.setSelected(true);
		btMakeReservation.setVisible(false);

////////////////////////////////////////
		flowpane2.getChildren().add(btShowAirPort);
		flowpane2.getChildren().add(btViewlistairlines);
		flowpane2.getChildren().add(btViewlistflights);
		flowpane2.getChildren().add(btmyreservations);
		flowpane2.getChildren().add(btmypassenger);
		flowpane2.getChildren().add(btConfirmeReservation);
		flowpane2.getChildren().add(btMakeReservation);
		flowpane2.getChildren().add(btCancelReservation);

//////////////////////////////////////////////////
		bPane.setTop(flowpane1);
		bPane.setBottom(flowpane2);
		flowpane2.setPadding(new Insets(7, 7, 7, 7));
//////////////////////////////////////////////////
		makeReservation.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (makeReservation.isSelected()) {
					btMakeReservation.setVisible(true);
					btViewlistairlines.setVisible(false);
					btShowAirPort.setVisible(false);
					btViewlistflights.setVisible(false);
					btmyreservations.setVisible(false);
					btmypassenger.setVisible(false);
					btConfirmeReservation.setVisible(false);
					btCancelReservation.setVisible(false);
					grid3.setVisible(true);
					grid4.setVisible(false);
					gridC.setVisible(false);
					if (agent.isSelected()) {
						grid0.setVisible(true);
					}
				} else {
					btMakeReservation.setVisible(false);
					btViewlistairlines.setVisible(true);
					btShowAirPort.setVisible(true);
					btViewlistflights.setVisible(true);
					btmyreservations.setVisible(true);
					btmypassenger.setVisible(true);
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
		agent.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (agent.isSelected()) {
					if (makeReservation.isSelected())
						grid0.setVisible(true);
				}
			}
		});
////////////////////////////////////////////////
		passenger.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (passenger.isSelected()) {
					grid0.setVisible(false);
				}
			}
		});
////////////////////////////////////////////////
		btShowAirPort.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!city.getText().trim().equals("") && deparAiro.getText().trim().equals("")) {
					for (Airport airoport : dataSource.findAirportsByCity(city.getText()))
						System.out.println(airoport);
					System.out.println("##############################################################################");

					return;
				}

				if (deparAiro.getText().trim().equals("")) {
					for (Airport airoport : dataSource.findAllAirports())
						System.out.println(airoport);
					System.out.println("##############################################################################");

				}

				else {
					System.out.println(dataSource.findAirportByAirportCode(deparAiro.getText()));
					System.out.println("##############################################################################");
				}

			}
		});
///////////////////////////////////////////////////
		btViewlistairlines.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!deparAiro.getText().trim().equals("")) {
					for (Airline airline : dataSource.findAirlinesByAirportCode(deparAiro.getText()))
						System.out.println(airline);
					System.out.println("##############################################################################");

				}
			}
		});
///////////////////////////////////////////////////
		btViewlistflights.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!deparAiro.getText().trim().equals("") && !arrivAiro.getText().trim().equals("")
						&& !date.getText().trim().equals("")) {

					String date1 = date.getText();
					LocalDate localDate = LocalDate.parse(date1);

					List<FlightInstance> flightInstances = dataSource.findFlightsFromTo(deparAiro.getText(),
							arrivAiro.getText(), localDate);

					for (FlightInstance flight : flightInstances) {
						System.out.println(flight);
					}

					if (flightInstances.size() == 0) {
						String msg = String.format("There is no any flight from %s to %s at %s ", deparAiro.getText(),
								arrivAiro.getText(), localDate);
						System.out.println(msg);
					}

					System.out.println("##############################################################################");

				}
			}
		});
///////////////////////////////////////////////////
		btmyreservations.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				if (passenger.isSelected() && !id.getText().trim().equals("")) {
					for (Reservation reservation : dataSource.findReservationsByPassengerId(id.getText()))
						System.out.println(reservation);
					System.out.println("##############################################################################");
				}

				if (agent.isSelected() && !id.getText().trim().equals("")) {
					for (Reservation reservation : dataSource.findReservationsByAgentId(id.getText()))
						System.out.println(reservation);
					System.out.println("##############################################################################");
				}

			}
		});
///////////////////////////////////////////////////
		btmypassenger.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (agent.isSelected() && !id.getText().trim().equals("")) {
					for (Passenger passenger : dataSource.findPassengersByAgentCode(id.getText()))
						System.out.println(passenger);
					System.out.println("##############################################################################");
				}
			}
		});
		///////////////////////////////////////////////////
		btMakeReservation.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!deparAiro.getText().trim().equals("") && !arrivAiro.getText().trim().equals("")
						&& !date.getText().trim().equals("")) {

					String departure = deparAiro.getText();
					String arrival = arrivAiro.getText();
					String date1 = date.getText();
					LocalDate localDate = LocalDate.parse(date1);

					List<FlightInstance> flightInstances = dataSource.findFlightsFromTo(departure, arrival, localDate);

					if (flightInstances.size() == 0) {
						String msg = String.format("Can not make find flight from %s to %s at %s ", departure, arrival,
								localDate);
						System.out.println(msg);
						return;
					}

					if (agent.isSelected() && !id.getText().trim().equals("") && !idPass.getText().trim().equals("")) {
						Reservation reservation = dataSource.createReservation(id.getText(), idPass.getText(),
								flightInstances);
						System.out.println(reservation);
					}
					if (passenger.isSelected() && !id.getText().trim().equals("")) {
						Reservation reservation = dataSource.createReservation(id.getText(), flightInstances);
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
					List<Ticket> var = dataSource.confirmReservation(reservationCode.getText());
					if (var.size() == 0)
						System.out.println("the reservation not Found");
					else
						for (Ticket ticket : var)
							System.out.println(ticket);
					System.out.println("##############################################################################");
				}
			}
		});

//////////////////////////////////////////////////
		stage.setScene(new Scene(bPane, 1000, 300));
		bPane.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());stage.show();

	}

}