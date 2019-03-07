package della;

import gui.*;
import javafx.application.Application;
import javafx.stage.Stage;

/*******
 * <p>
 * Title: Della
 * </p>
 * 
 * <p>
 * Description: An issue and action logging and tracking manager.
 * </p>
 * 
 * <p>
 * Copyright: Lynn Robert Carter © 2005, 2006
 * </p>
 * 
 * @author Harry Sameshima; Modified by Lynn Robert Carter
 * 
 * @version 1.00
 * 
 */

public class Main extends Application {

	public MainScreen theGUI;

	@Override
	public void start(Stage theStage) throws Exception {

		theGUI = new MainScreen(theStage);

	}

	public static void main(String[] args) {
 		launch(args);
	}

}
