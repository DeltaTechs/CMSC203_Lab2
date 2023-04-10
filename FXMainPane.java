import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button b, bu, but, butt, butto;
	Label labilly;
	TextField fieldDeLaTexta;
	//  declare two HBoxes
	HBox h1, h2;
	//student Task #4:
	//  declare an instance of DataManager
	DataManager michaelScoot;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		b = new Button("Hello");
		bu = new Button("Howdy");
		but = new Button("Chinese");
		butt = new Button("Clear");
		butto = new Button("Exit");
		
		labilly = new Label("Feedback:");
		fieldDeLaTexta = new TextField();
		//  instantiate the HBoxes
		h1 = new HBox();
		h2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		michaelScoot = new DataManager();
		//  set margins and set alignment of the components
		h1.setMargin(labilly, new Insets(25, 25, 25, 25));
		h2.setMargin(b, new Insets(21, 21, 21, 21));
		h2.setMargin(but, new Insets(21, 21, 21, 21));
		h2.setMargin(butto, new Insets(21, 21, 21, 21));
		
		h1.setAlignment(Pos.CENTER);
		h2.setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		h1.getChildren().addAll(labilly, fieldDeLaTexta);
		//  add the buttons to the other HBox
		h2.getChildren().addAll(b, bu, but, butt, butto);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(h1, h2);
		
		b.setOnAction(new ButtonHandler());
		bu.setOnAction(new ButtonHandler());
		but.setOnAction(new ButtonHandler());
		butt.setOnAction(new ButtonHandler());
		butto.setOnAction(new ButtonHandler());
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			if(event.getTarget() == b)
				fieldDeLaTexta.setText(michaelScoot.getHello());
			else if(event.getTarget() == bu)
				fieldDeLaTexta.setText(michaelScoot.getHowdy());
			else if (event.getTarget() == but)
				fieldDeLaTexta.setText(michaelScoot.getChinese());
			else if (event.getTarget() == butt)
				fieldDeLaTexta.setText("");
			else if (event.getTarget() == butto)
			{
				Platform.exit();
				System.exit(0);
			}
				
			
		}
		
	}
}