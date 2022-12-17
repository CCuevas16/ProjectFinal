package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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


public class MainMenu extends Application{
	
	@Override
	public void start(Stage primaryStage) {	
		Label label = setUpLabel();
		
		HBox Hb1 = new HBox();
		Hb1.getChildren().addAll(label); 
		Hb1.setAlignment(Pos.TOP_CENTER);
		
		Button btn = setUpButton(primaryStage);
		
		HBox Hb2 = new HBox();
		Hb2.getChildren().addAll(btn); 
		Hb2.setSpacing(50); 
		Hb2.setAlignment(Pos.BOTTOM_CENTER);
		HBox.setMargin(btn, new Insets(0,0,50,0));
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll(Hb1, Hb2);
		HBox.setHgrow(label, Priority.ALWAYS);
		vbox.setSpacing(100);
		Hb2.setAlignment(Pos.CENTER);
				
		BorderPane bp = new BorderPane(vbox);
		bp.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY,Insets.EMPTY)));
				
		Scene scene = new Scene(bp,400,400);
		primaryStage.setTitle("Main Menu");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		label.setPrefWidth(vbox.widthProperty().doubleValue());		
	}
	
	private Label setUpLabel() {	
		Label label = new Label("Night Bringer");
		label.setMaxHeight(50);
		label.setTextFill(Color.RED);
		label.setFont(new Font(32));
		label.setAlignment(Pos.CENTER);
		label.setTextAlignment(TextAlignment.CENTER);
		
		return label;
	}
	
	private Button setUpButton(Stage primaryStage) {		
		Button btn1 = new Button("Start");
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent actionEvent) {
		    	Killer.startGame();
		        BedroomStart bedroomStart = new BedroomStart();
		        
		        try {
					bedroomStart.start(primaryStage);
				} catch (Exception e) {
					e.printStackTrace();					
				}		        		            
		    }
		});
		
		return btn1;
	}
	
	public static void main(String[] args) {
		launch();
	}

}
