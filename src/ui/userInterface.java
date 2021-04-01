package ui;
import java.time.LocalDate;
import java.util.List;


import object.Place;
import object.Location;
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

public class userInterface extends Application {
	ReservationSystemFacade dataSource = new ReservationSystemFacadeImpl();
	RadioButton host = new RadioButton("Host");
	RadioButton guest = new RadioButton("Guest");
	RadioButton makeReservation = new RadioButton("Make Reservation");

	TextField id = new TextField();
	TextField idPass = new TextField();
	TextField deparAiro = new TextField();
	TextField arrivAiro = new TextField();
	TextField date = new TextField();
	TextField reservationCode = new TextField();
	TextField city = new TextField();
	TextField partyNumber = new TextField();

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
		Button btShowLocation = new Button("Locations");
		Button btViewlistplaces = new Button("Places by Locations");
		Button btViewlistpartys = new Button("Partys");
		Button btmyreservations = new Button("Reservations");
		Button btMakeReservation = new Button("Make a reservation");
		Button btCancelReservation = new Button("Cancel a Reservation");
		Button btmyguest = new Button("Guests ");
		Button btConfirmeReservation = new Button("Confirm Reservation");

		final ToggleGroup group = new ToggleGroup();
		host.setToggleGroup(group);
		guest.setToggleGroup(group);
///////////////////////////////////////
		BorderPane bPane = new BorderPane();
		FlowPane flowpane1 = new FlowPane();
		FlowPane flowpane2 = new FlowPane();
		flowpane1.setAlignment(Pos.CENTER);
		flowpane2.setAlignment(Pos.CENTER);
////////////////////////////////////////
		GridPane gridP = new GridPane();
		gridP.setPadding(new Insets(7, 7, 7, 7));
		gridP.add(host, 0, 0);
		gridP.add(guest, 0, 1);
		gridP.add(makeReservation, 0, 2);

/////////////////////////////////////////
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(7, 7, 7, 7));
		grid.add(new Text("ID"), 0, 0);
		grid.add(id, 0, 1);
/////////////////////////////////////////
		GridPane grid0 = new GridPane();
		grid0.setPadding(new Insets(7, 7, 7,7));
		grid0.add(new Text("ID Guest"), 0, 0);
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
		 * grid5.add(new Text("Party Number"), 0, 0); grid5.add(partyNumber,0,1 );
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
		guest.setSelected(true);
		btMakeReservation.setVisible(false);

////////////////////////////////////////
		flowpane2.getChildren().add(btShowLocation);
		flowpane2.getChildren().add(btViewlistplaces);
		flowpane2.getChildren().add(btViewlistpartys);
		flowpane2.getChildren().add(btmyreservations);
		flowpane2.getChildren().add(btmyguest);
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
					btViewlistplaces.setVisible(false);
					btShowLocation.setVisible(false);
					btViewlistpartys.setVisible(false);
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
					btMakeReservation.setVisible(false);
					btViewlistplaces.setVisible(true);
					btShowLocation.setVisible(true);
					btViewlistpartys.setVisible(true);
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
					if (makeReservation.isSelected())
						grid0.setVisible(true);
				}
			}
		});
////////////////////////////////////////////////
		guest.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (guest.isSelected()) {
					grid0.setVisible(false);
				}
			}
		});
////////////////////////////////////////////////
		btShowLocation.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!city.getText().trim().equals("") && deparAiro.getText().trim().equals("")) {
					for (Location airoport : dataSource.findLocationsByCity(city.getText()))
						System.out.println(airoport);
					System.out.println("##############################################################################");

					return;
				}

				if (deparAiro.getText().trim().equals("")) {
					for (Location airoport : dataSource.findAllLocations())
						System.out.println(airoport);
					System.out.println("##############################################################################");

				}

				else {
					System.out.println(dataSource.findLocationByLocationCode(deparAiro.getText()));
					System.out.println("##############################################################################");
				}

			}
		});
///////////////////////////////////////////////////
		btViewlistplaces.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!deparAiro.getText().trim().equals("")) {
					for (Place place : dataSource.findPlacesByLocationCode(deparAiro.getText()))
						System.out.println(place);
					System.out.println("##############################################################################");

				}
			}
		});
///////////////////////////////////////////////////
		btViewlistpartys.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!deparAiro.getText().trim().equals("") && !arrivAiro.getText().trim().equals("")
						&& !date.getText().trim().equals("")) {

					String date1 = date.getText();
					LocalDate localDate = LocalDate.parse(date1);

					List<PartyInstance> partyInstances = dataSource.findPartysFromTo(deparAiro.getText(), localDate);

					for (PartyInstance party : partyInstances) {
						System.out.println(party);
					}

					if (partyInstances.size() == 0) {
						String msg = String.format("There is no any party from %s to %s at %s ", deparAiro.getText(),
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

				if (guest.isSelected() && !id.getText().trim().equals("")) {
					for (Reservation reservation : dataSource.findReservationsByGuestId(id.getText()))
						System.out.println(reservation);
					System.out.println("##############################################################################");
				}

				if (host.isSelected() && !id.getText().trim().equals("")) {
					for (Reservation reservation : dataSource.findReservationsByHostId(id.getText()))
						System.out.println(reservation);
					System.out.println("##############################################################################");
				}

			}
		});
///////////////////////////////////////////////////
		btmyguest.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (host.isSelected() && !id.getText().trim().equals("")) {
					for (Guest guest : dataSource.findGuestsByHostCode(id.getText()))
						System.out.println(guest);
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

					List<PartyInstance> partyInstances = dataSource.findPartysFromTo(departure, localDate);

					if (partyInstances.size() == 0) {
						String msg = String.format("Can not make find party from %s to %s at %s ", departure, arrival,
								localDate);
						System.out.println(msg);
						return;
					}

					if (host.isSelected() && !id.getText().trim().equals("") && !idPass.getText().trim().equals("")) {
						Reservation reservation = dataSource.createReservation(id.getText(), idPass.getText(),
								partyInstances);
						System.out.println(reservation);
					}
					if (guest.isSelected() && !id.getText().trim().equals("")) {
						Reservation reservation = dataSource.createReservation(id.getText(), partyInstances);
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
					System.out.println("##############################################################################");
				}
			}
		});

//////////////////////////////////////////////////
		stage.setScene(new Scene(bPane, 1000, 300));
		bPane.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());stage.show();

	}

}