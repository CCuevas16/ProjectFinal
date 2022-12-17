package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Outside extends Room{

	@Override
	protected String getLabel() {
		// TODO Auto-generated method stub
		return "You Escaped You Win";
	}

	@Override
	protected String getRoomName() {
		// TODO Auto-generated method stub
		return "Outside";
	}

	@Override
	protected Room[] getNextRooms() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected boolean checkShouldMoveKiller() {
		return false;
	}
	
	@Override
	protected boolean checkCanKillerMoveTo() {
		return false;
	}

	@Override
	protected Button[] setUpButtons(Stage primaryStage) {
		Button btn1 = new Button("Play again");
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent actionEvent) {
		    	MainMenu mainMenu = new MainMenu ();
		        
		        try {
					mainMenu.start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();					
				}		        		            
		    }
		});
		
		Button btn2 = new Button("Exit");
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent actionEvent) {
		       System.exit(0);		        		            
		    }
		});
		return new Button[] {btn1, btn2};
	}

}
