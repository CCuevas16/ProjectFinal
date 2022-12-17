package application;

import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public abstract class Room extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		boolean didLose = checkIfLost();
		if(didLose) {
			goToLose(primaryStage);
			return;
			
		}
		
		if(checkShouldMoveKiller()) {
			Killer.moveToNextRoom();
			didLose = checkIfLost();
			if(didLose) {
				goToLose(primaryStage);
				return;
				}
		}
		
		
		setUpRoom(primaryStage);
		
		
		
		
		
		
	}
	
	private boolean checkIfLost() {
		boolean isKillerInRoom = Killer.checkIfKillerInRooms(new Room[] {this});
		
		if(isKillerInRoom) {
			return true;
		}
		
		return false;
	}
	
	private void goToLose(Stage primaryStage) {
		Lose lose = new Lose();
		lose.start(primaryStage);
	}
	
	private void setUpRoom(Stage primaryStage) {
		Label label = setUpLabel();
		label.setMaxWidth(Double.MAX_VALUE);
		
		ImageView imageView = setUpImage();
		
		HBox Hb1 = new HBox();
		Hb1.getChildren().addAll(imageView); 
		Hb1.setAlignment(Pos.TOP_CENTER);
		
		HBox Hb2 = new HBox();
		Hb2.getChildren().addAll(setUpButtons(primaryStage)); 
		Hb2.setSpacing(50); 
		Hb2.setAlignment(Pos.BOTTOM_CENTER);
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll(label, Hb2, Hb1);
		vbox.setSpacing(100);
		Hb2.setAlignment(Pos.CENTER);
				
		BorderPane bp = new BorderPane(vbox);
		bp.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY,Insets.EMPTY)));
				
		Scene scene = new Scene(bp,600,600);
		primaryStage.setTitle(getRoomName());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		label.setPrefWidth(vbox.widthProperty().doubleValue());
	}
	
	private Label setUpLabel() {		
		String text = getLabel();
		if(checkIfKillerIsInNextRoom()) {
			text = text + "\r\n" + "Killer is nearby";
		}
		
		Label label = new Label(text);
		label.setMaxHeight(100);
		label.setFont(new Font(14));
		label.setWrapText(true);
		label.setAlignment(Pos.CENTER);
		label.setTextAlignment(TextAlignment.LEFT);
		label.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
		
		return label;
	}
	
	private ImageView setUpImage() {
		Image image = null;
		//try {
			image = new Image(this.getClass().getResourceAsStream("319852999_661482045703840_6544732750028662541_n.png"));
			//image = new Image(new File("319852999_661482045703840_6544732750028662541_n.png").toURI().toURL().toExternalForm());
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(256);
		imageView.setFitWidth(256);
		return imageView;
	}
	
	private boolean checkIfKillerIsInNextRoom() {
		
		
		return Killer.checkIfKillerInRooms(getNextRooms());
	}
	
	protected boolean checkShouldMoveKiller() {
		return true;
	}
	
	protected boolean checkCanKillerMoveTo() {
		return true;
	}
	
	protected Button[] setUpButtons(Stage primaryStage) {
		Room[] rooms = getNextRooms();
		
		Button[] btnArr = new Button[rooms.length];
		
		for(int i = 0; i < rooms.length; i++) {
			Room r = rooms[i];
			Button btn = new Button(r.getRoomName());
			
			btn.setOnAction(new EventHandler<ActionEvent>() {
			    @Override
			    public void handle(ActionEvent actionEvent) {
			        try {
						r.start(primaryStage);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();					
					}		        		            
			    }
			});
			
			btnArr[i] = btn;
		}
		
		return btnArr;
	}

	
	protected abstract String getLabel();
	
	protected abstract String getRoomName();
	
	protected abstract Room[] getNextRooms();

}
