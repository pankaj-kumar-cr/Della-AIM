package gui;

import control.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.ActionItemManager;
import model.ElementList;
import utility.MessageBox;

/**
 * <p>
 * Title: TeamScreen
 * </p>
 *
 * <p>
 * Description: The Della Team Screen code
 * </p>
 *
 * <p>
 * Copyright: Copyright © 2007
 * </p>
 *
 * @author Lynn Robert Carter
 * @version 1.06 Many thanks to Harry Sameshima for his original work.
 */

public class TeamsScreen extends Pane {

	// ---------------------------------------------------------------------------------------------------------------------
	// Team Screen constants

	public static final int noItemSelected = -1; // Added for Della06

	// ---------------------------------------------------------------------------------------------------------------------
	// Team Screen attributes

	// Added for Della06 (start)
	Boolean updatingGUI = false;

	private Controller theController = null;
	private ActionItemManager aiM = null;
	// Added for Della06 (end)

	// ---------------------------------------------------------------------------------------------------------------------
	// Team Screen GUI elements
	Label teamsLabel = new Label();

	// Added for Della06 (start)
	Label nameLabel = new Label();
	TextField nameTextField = new TextField();

	Label guidanceR1Label = new Label();
	Label guidanceR2Label = new Label();
	Label guidanceR3Label = new Label();
	Label guidanceR4Label = new Label();
	Label guidanceR5Label = new Label();
	Label guidanceR6Label = new Label();
	Label guidanceR7Label = new Label();

	// Get current classloader
	ClassLoader cl = this.getClass().getClassLoader();
	// Create icons
	Image image = new Image(cl.getResourceAsStream("TrashCan.gif"));
	Label trashCanLabel = new Label();

	Button addTeamButton = new Button();
	Button removeTeamButton = new Button();

	Label teamListLabel = new Label();
	ListView<String> teamSelectList = new ListView<String>();
	ScrollPane scrollableTeamListPane = new ScrollPane();
	// Added for Della06 (end)

	// Added for Della08
	Label guidanceR8Label = new Label();
	Label guidanceR9Label = new Label();
	Label guidanceR10Label = new Label();
	Label guidanceR11Label = new Label();
	Label guidanceR12Label = new Label();
	Label guidanceR13Label = new Label();
	Label guidanceR14Label = new Label();
	Label guidanceR15Label = new Label();
	Label guidanceR16Label = new Label();
	Label guidanceR17Label = new Label();

	Label unassociatedMembersListLabel = new Label();
	Label unassociatedMembersTeamNameLabel = new Label();
	ListView<String> unassociatedMembersSelectList = new ListView<String>();
	ScrollPane scrollableUnassociatedMembersListPane = new ScrollPane();

	Button addMemberAssociationButton = new Button();
	Button removeMemberAssociationButton = new Button();

	Label associatedMembersListLabel = new Label();
	Label associatedMembersTeamNameLabel = new Label();
	ListView<String> associatedMembersSelectList = new ListView<String>();
	ScrollPane scrollableAssociatedMembersListPane = new ScrollPane();
	// Added for Della08 (end)

	// ---------------------------------------------------------------------------------------------------------------------
	public TeamsScreen() {
		// Use a modified singleton pattern to access the application's state; Added for
		// Della06
		theController = Controller.getInstance();
		aiM = theController.getActionItemManager();

		// Set up all of the Graphical User Interface elements and place them on the
		// screen
		guiInit();

		// Initialize the screen; Added for Della06
		loadScreen();
	}

	/**
	 * Initialize each graphic element, position it on the screen, and add it to the
	 * layout.
	 * 
	 */
	private void guiInit() {
		// Set all of the graphical elements in this screen by adding them to the layout
		teamsLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 14));
		teamsLabel.setStyle("-fx-border-color: black");
		teamsLabel.setText("Teams");
		teamsLabel.setPadding(new Insets(3, 301, 3, 302));

		// Added for Della06 (start)
		nameLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		nameLabel.setText("Name of a new Team");
		nameLabel.setLayoutX(5);
		nameLabel.setLayoutY(23);
		nameLabel.setMinWidth(240);
		nameLabel.setMaxWidth(240);
		nameLabel.setMinHeight(15);
		nameLabel.setMaxHeight(15);

		nameTextField.setText("");
		nameTextField.setLayoutX(5);
		nameTextField.setLayoutY(40);
		nameTextField.setMinWidth(190);
		nameTextField.setMaxWidth(190);

		guidanceR1Label.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		guidanceR1Label.setText("To add a name to the list:");
		guidanceR1Label.setLayoutX(5);
		guidanceR1Label.setLayoutY(70);
		guidanceR1Label.setMinWidth(240);
		guidanceR1Label.setMaxWidth(240);
		guidanceR1Label.setMinHeight(15);
		guidanceR1Label.setMaxHeight(15);

		guidanceR2Label.setFont(Font.font("Dialog", FontWeight.NORMAL, 11));
		guidanceR2Label.setText("1. Click on the box above.");
		guidanceR2Label.setLayoutX(5);
		guidanceR2Label.setLayoutY(85);
		guidanceR2Label.setMinWidth(240);
		guidanceR2Label.setMaxWidth(240);
		guidanceR2Label.setMinHeight(15);
		guidanceR2Label.setMaxHeight(15);

		guidanceR3Label.setFont(Font.font("Dialog", FontWeight.NORMAL, 11));
		guidanceR3Label.setText("2. Type the name.");
		guidanceR3Label.setLayoutX(5);
		guidanceR3Label.setLayoutY(100);
		guidanceR3Label.setMinWidth(240);
		guidanceR3Label.setMaxWidth(240);
		guidanceR3Label.setMinHeight(15);
		guidanceR3Label.setMaxHeight(15);

		guidanceR4Label.setFont(Font.font("Dialog", FontWeight.NORMAL, 11));
		guidanceR4Label.setText("3. Click the \"Add to List\" button.");
		guidanceR4Label.setLayoutX(5);
		guidanceR4Label.setLayoutY(115);
		guidanceR4Label.setMinWidth(240);
		guidanceR4Label.setMaxWidth(240);
		guidanceR4Label.setMinHeight(15);
		guidanceR4Label.setMaxHeight(15);

		guidanceR5Label.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		guidanceR5Label.setText("To remove a name from the list:");
		guidanceR5Label.setLayoutX(5);
		guidanceR5Label.setLayoutY(150);
		guidanceR5Label.setMinWidth(240);
		guidanceR5Label.setMaxWidth(240);
		guidanceR5Label.setMinHeight(15);
		guidanceR5Label.setMaxHeight(15);

		guidanceR6Label.setFont(Font.font("Dialog", FontWeight.NORMAL, 11));
		guidanceR6Label.setText("1. Click on the name to remove.");
		guidanceR6Label.setLayoutX(5);
		guidanceR6Label.setLayoutY(165);
		guidanceR6Label.setMinWidth(240);
		guidanceR6Label.setMaxWidth(240);
		guidanceR6Label.setMinHeight(15);
		guidanceR6Label.setMaxHeight(15);

		guidanceR7Label.setFont(Font.font("Dialog", FontWeight.NORMAL, 11));
		guidanceR7Label.setText("2. Click on \"Remove from List\" button.");
		guidanceR7Label.setLayoutX(5);
		guidanceR7Label.setLayoutY(180);
		guidanceR7Label.setMinWidth(240);
		guidanceR7Label.setMaxWidth(240);
		guidanceR7Label.setMinHeight(15);
		guidanceR7Label.setMaxHeight(15);

		trashCanLabel.setGraphic(new ImageView(image));
		trashCanLabel.setLayoutX(185);
		trashCanLabel.setLayoutY(70);
		trashCanLabel.setMinWidth(50);
		trashCanLabel.setMaxWidth(50);
		trashCanLabel.setMinHeight(83);
		trashCanLabel.setMaxHeight(83);

		addTeamButton.setFont(Font.font("Dialog", FontWeight.BOLD, 12));
		addTeamButton.setText("Add to List ->");
		addTeamButton.setLayoutX(243);
		addTeamButton.setLayoutY(35);
		addTeamButton.setMinWidth(170);
		addTeamButton.setMaxWidth(170);
		addTeamButton.setMinHeight(35);
		addTeamButton.setMaxHeight(35);
		addTeamButton.setOnAction(e -> addTeam());

		removeTeamButton.setFont(Font.font("Dialog", FontWeight.BOLD, 12));
		removeTeamButton.setText("<- Remove from List");
		removeTeamButton.setLayoutX(243);
		removeTeamButton.setLayoutY(95);
		removeTeamButton.setMinWidth(170);
		removeTeamButton.setMaxWidth(170);
		removeTeamButton.setMinHeight(35);
		removeTeamButton.setMaxHeight(35);
		removeTeamButton.setOnAction(e -> removeTeam());

		teamListLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		teamListLabel.setText("Teams known by Della");
		teamListLabel.setLayoutX(460);
		teamListLabel.setLayoutY(23);
		teamListLabel.setMinWidth(200);
		teamListLabel.setMaxWidth(200);
		teamListLabel.setMinHeight(15);
		teamListLabel.setMaxHeight(15);
		teamSelectList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			selectTeam();
		});
		// teamSelectList.setMinWidth(50); //enable if required
		scrollableTeamListPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		scrollableTeamListPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		scrollableTeamListPane.setContent(teamSelectList);
		scrollableTeamListPane.setLayoutX(460);
		scrollableTeamListPane.setLayoutY(40);
		scrollableTeamListPane.setMinWidth(180);
		scrollableTeamListPane.setMaxWidth(180);
		scrollableTeamListPane.setMinHeight(155);
		scrollableTeamListPane.setMaxHeight(155);
		// Added for Della06 (end)

		// Added for Della08 (start)
		guidanceR8Label.setFont(Font.font("Dialog", FontWeight.BOLD, 10));
		guidanceR8Label.setText("To add a member association for a team:");
		guidanceR8Label.setLayoutX(5);
		guidanceR8Label.setLayoutY(205);
		guidanceR8Label.setMinWidth(240);
		guidanceR8Label.setMaxWidth(240);
		guidanceR8Label.setMinHeight(15);
		guidanceR8Label.setMaxHeight(15);

		guidanceR9Label.setFont(Font.font("Dialog", FontWeight.NORMAL, 10));
		guidanceR9Label.setText("1. Click on the name of the team above right.");
		guidanceR9Label.setLayoutX(5);
		guidanceR9Label.setLayoutY(220);
		guidanceR9Label.setMinWidth(240);
		guidanceR9Label.setMaxWidth(240);
		guidanceR9Label.setMinHeight(15);
		guidanceR9Label.setMaxHeight(15);

		guidanceR10Label.setFont(Font.font("Dialog", FontWeight.NORMAL, 10));
		guidanceR10Label.setText("2. Click on a member name in the list below.");
		guidanceR10Label.setLayoutX(5);
		guidanceR10Label.setLayoutY(235);
		guidanceR10Label.setMinWidth(240);
		guidanceR10Label.setMaxWidth(240);
		guidanceR10Label.setMinHeight(15);
		guidanceR10Label.setMaxHeight(15);

		guidanceR11Label.setFont(Font.font("Dialog", FontWeight.NORMAL, 10));
		guidanceR11Label.setText("3. Click on \"Add association\" button.");
		guidanceR11Label.setLayoutX(5);
		guidanceR11Label.setLayoutY(250);
		guidanceR11Label.setMinWidth(240);
		guidanceR11Label.setMaxWidth(240);
		guidanceR11Label.setMinHeight(15);
		guidanceR11Label.setMaxHeight(15);

		guidanceR12Label.setFont(Font.font("Dialog", FontWeight.BOLD, 10));
		guidanceR12Label.setText("To remove a member association for a team:");
		guidanceR12Label.setLayoutX(400);
		guidanceR12Label.setLayoutY(205);
		guidanceR12Label.setMinWidth(240);
		guidanceR12Label.setMaxWidth(240);
		guidanceR12Label.setMinHeight(15);
		guidanceR12Label.setMaxHeight(15);

		guidanceR13Label.setFont(Font.font("Dialog", FontWeight.NORMAL, 10));
		guidanceR13Label.setText("1. Click on the name of the team above.");
		guidanceR13Label.setLayoutX(400);
		guidanceR13Label.setLayoutY(220);
		guidanceR13Label.setMinWidth(240);
		guidanceR13Label.setMaxWidth(240);
		guidanceR13Label.setMinHeight(15);
		guidanceR13Label.setMaxHeight(15);

		guidanceR14Label.setFont(Font.font("Dialog", FontWeight.NORMAL, 10));
		guidanceR14Label.setText("2. Click on a member name in the list below.");
		guidanceR14Label.setLayoutX(400);
		guidanceR14Label.setLayoutY(235);
		guidanceR14Label.setMinWidth(240);
		guidanceR14Label.setMaxWidth(240);
		guidanceR14Label.setMinHeight(15);
		guidanceR14Label.setMaxHeight(15);

		guidanceR15Label.setFont(Font.font("Dialog", FontWeight.NORMAL, 10));
		guidanceR15Label.setText("3. Click on \"Remove association\" button.");
		guidanceR15Label.setLayoutX(400);
		guidanceR15Label.setLayoutY(250);
		guidanceR15Label.setMinWidth(240);
		guidanceR15Label.setMaxWidth(240);
		guidanceR15Label.setMinHeight(15);
		guidanceR15Label.setMaxHeight(15);

		guidanceR16Label.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		guidanceR16Label.setText("Click on an team\'s name");
		guidanceR16Label.setLayoutX(255);
		guidanceR16Label.setLayoutY(150);
		guidanceR16Label.setMinWidth(240);
		guidanceR16Label.setMaxWidth(240);
		guidanceR16Label.setMinHeight(15);
		guidanceR16Label.setMaxHeight(15);

		guidanceR17Label.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		guidanceR17Label.setText("to see member associations.");
		guidanceR17Label.setLayoutX(255);
		guidanceR17Label.setLayoutY(165);
		guidanceR17Label.setMinWidth(240);
		guidanceR17Label.setMaxWidth(240);
		guidanceR17Label.setMinHeight(15);
		guidanceR17Label.setMaxHeight(15);

		unassociatedMembersListLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		unassociatedMembersListLabel.setText("Available members for team");
		unassociatedMembersListLabel.setLayoutX(10);
		unassociatedMembersListLabel.setLayoutY(275);
		unassociatedMembersListLabel.setMinWidth(200);
		unassociatedMembersListLabel.setMaxWidth(200);
		unassociatedMembersListLabel.setMinHeight(15);
		unassociatedMembersListLabel.setMaxHeight(15);
		unassociatedMembersTeamNameLabel.setFont(Font.font("Dialog", FontWeight.NORMAL, 10));
		unassociatedMembersTeamNameLabel.setText("");
		unassociatedMembersTeamNameLabel.setLayoutX(10);
		unassociatedMembersTeamNameLabel.setLayoutY(290);
		unassociatedMembersTeamNameLabel.setMinWidth(200);
		unassociatedMembersTeamNameLabel.setMaxWidth(200);
		unassociatedMembersTeamNameLabel.setMinHeight(15);
		unassociatedMembersTeamNameLabel.setMaxHeight(15);
		unassociatedMembersSelectList.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> {
					selectUnassociatedMember();
				});
		// unassociatedMembersSelectList.setMinWidth(50); //enable if required
		scrollableUnassociatedMembersListPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		scrollableUnassociatedMembersListPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		scrollableUnassociatedMembersListPane.setContent(unassociatedMembersSelectList);
		scrollableUnassociatedMembersListPane.setLayoutX(10);
		scrollableUnassociatedMembersListPane.setLayoutY(305);
		scrollableUnassociatedMembersListPane.setMinWidth(180);
		scrollableUnassociatedMembersListPane.setMaxWidth(180);
		scrollableUnassociatedMembersListPane.setMinHeight(140);
		scrollableUnassociatedMembersListPane.setMaxHeight(140);

		addMemberAssociationButton.setFont(Font.font("Dialog", FontWeight.BOLD, 12));
		addMemberAssociationButton.setText("Add association ->");
		addMemberAssociationButton.setLayoutX(240);
		addMemberAssociationButton.setLayoutY(330);
		addMemberAssociationButton.setMinWidth(176);
		addMemberAssociationButton.setMaxWidth(176);
		addMemberAssociationButton.setMinHeight(35);
		addMemberAssociationButton.setMaxHeight(35);
		addMemberAssociationButton.setOnAction(e -> addMemberAssociation());

		removeMemberAssociationButton.setFont(Font.font("Dialog", FontWeight.BOLD, 12));
		removeMemberAssociationButton.setText("<- Remove association");
		removeMemberAssociationButton.setLayoutX(240);
		removeMemberAssociationButton.setLayoutY(385);
		removeMemberAssociationButton.setMinWidth(176);
		removeMemberAssociationButton.setMaxWidth(176);
		removeMemberAssociationButton.setMinHeight(35);
		removeMemberAssociationButton.setMaxHeight(35);
		removeMemberAssociationButton.setOnAction(e -> removeMemberAssociation());

		associatedMembersListLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		associatedMembersListLabel.setText("Current members for team");
		associatedMembersListLabel.setLayoutX(460);
		associatedMembersListLabel.setLayoutY(275);
		associatedMembersListLabel.setMinWidth(200);
		associatedMembersListLabel.setMaxWidth(200);
		associatedMembersListLabel.setMinHeight(15);
		associatedMembersListLabel.setMaxHeight(15);
		associatedMembersTeamNameLabel.setFont(Font.font("Dialog", FontWeight.NORMAL, 10));
		associatedMembersTeamNameLabel.setText("");
		associatedMembersTeamNameLabel.setLayoutX(460);
		associatedMembersTeamNameLabel.setLayoutY(290);
		associatedMembersTeamNameLabel.setMinWidth(200);
		associatedMembersTeamNameLabel.setMaxWidth(200);
		associatedMembersTeamNameLabel.setMinHeight(15);
		associatedMembersTeamNameLabel.setMaxHeight(15);
		associatedMembersSelectList.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> {
					selectAssociatedMember();
				});
		// associatedMembersSelectList.setMinWidth(50); //enable if required
		scrollableAssociatedMembersListPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		scrollableAssociatedMembersListPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		scrollableAssociatedMembersListPane.setContent(associatedMembersSelectList);
		scrollableAssociatedMembersListPane.setLayoutX(460);
		scrollableAssociatedMembersListPane.setLayoutY(305);
		scrollableAssociatedMembersListPane.setMinWidth(180);
		scrollableAssociatedMembersListPane.setMaxWidth(180);
		scrollableAssociatedMembersListPane.setMinHeight(140);
		scrollableAssociatedMembersListPane.setMaxHeight(140);
		// Added for Della08 (end)

		// ----------------------------------------------------------------------------
		// Add the objects to the layout
		this.getChildren().add(teamsLabel);

		// Added for Della06 (start)
		this.getChildren().addAll(nameLabel, nameTextField, guidanceR1Label, guidanceR2Label, guidanceR3Label,
				guidanceR4Label, guidanceR5Label, guidanceR6Label, guidanceR7Label, trashCanLabel, addTeamButton,
				removeTeamButton, teamListLabel, scrollableTeamListPane);
		// Added for Della06 (end)

		// Added for Della08 (start)
		this.getChildren().addAll(guidanceR8Label, guidanceR9Label, guidanceR10Label, guidanceR11Label,
				guidanceR12Label, guidanceR13Label, guidanceR14Label, guidanceR15Label, guidanceR16Label,
				guidanceR17Label, unassociatedMembersListLabel, unassociatedMembersTeamNameLabel,
				scrollableUnassociatedMembersListPane, addMemberAssociationButton, removeMemberAssociationButton,
				associatedMembersListLabel, associatedMembersTeamNameLabel, scrollableAssociatedMembersListPane);
		// Added for Della08 (end)
	}

	/**
	 * Process a "Add to List" button click request Add the new name, if valid, to
	 * the team list
	 * 
	 * Added for Della06
	 */
	private void addTeam() {
		ElementList teamList = aiM.getTeamList();

		try {
			String newName = nameTextField.getText();
			loadScreenAndLists(teamList.addElement(newName));
			nameTextField.setText(""); // If name was accepted, blank our the input field
			teamList.setUnaddedName(""); // and reset the persistent input field copy
		} catch (Exception ex) {
			MessageBox.show(ex.getMessage(), "Error");
			return;
		}
		theController.setDirtyFlag(true);
	}

	/**
	 * Process a "Remove from List" button click request Remove the selected name
	 * from the member list
	 * 
	 * Added for Della06
	 */
	private void removeTeam() {
		int selectedIndex = teamSelectList.getSelectionModel().getSelectedIndex();
		if (selectedIndex == noItemSelected) {
			MessageBox.show("No team was selected!", "Error");
			return;
		} else {
			String teamName = aiM.getTeamList().getName(selectedIndex);
			aiM.removeAssignedTeam(teamName);
			aiM.getMemberList().removeAssociatedName(teamName); // Added for Della08
			nameTextField.setText(teamName);
			loadScreenAndLists(noItemSelected);
			theController.setDirtyFlag(true);
		}
	}

	/**
	 * Process a team select list selection action
	 * 
	 * Added for Della06
	 */
	private void selectTeam() {
		if (updatingGUI == false) {
			ElementList teamList = aiM.getTeamList();
			int selectedIndex = teamSelectList.getSelectionModel().getSelectedIndex();
			teamList.setCurrentSelectedElementIndex(selectedIndex);
			establishUnassociatedMemberSelectList(teamList.getName(selectedIndex)); // Added for Della08
			establishAssociatedMemberSelectList(teamList.getName(selectedIndex)); // Added for Della08
			theController.setDirtyFlag(true);
		}
	}

	/**
	 * When a shut down occurs, this routine is called to cause the UI state of the
	 * text input box to be saved to the persistent store
	 * 
	 * Added for Della06
	 */
	public void saveScreenState() {
		ElementList teamList = aiM.getTeamList();
		teamList.setUnaddedName(nameTextField.getText());
	}

	/**
	 * When a navigation button click requires this screen to be activated, this
	 * routine is called to load the screen and re-establish the perishable fields
	 * 
	 * Added for Della06
	 */
	public void loadScreen() {
		ElementList teamList = aiM.getTeamList();
		loadScreenAndLists(teamList.getCurrentSelectedElementIndex());
		nameTextField.setText(teamList.getUnaddedName());
	}

	/**
	 * Shared routine to load the screen and the various select lists
	 * 
	 * Added for Della06
	 */
	private void loadScreenAndLists(int selectedIndex) {
		updatingGUI = true;
		// Set the flag so that no select events are processed by these actions
		ElementList teamList = aiM.getTeamList();
		// Fetch the list of teams to populate the select list
		teamSelectList.getItems().clear();
		;
		// Reset the select list so it contains no elements
		int listSize = teamList.getListSize();
		// Fetch the size of the list of teams and use this to iterate over all members
		for (int i = 0; i < listSize; i++)
			teamSelectList.getItems().add(teamList.getName(i));
		// Add each team to the select list
		if (selectedIndex == noItemSelected) { // See if a team is selected
			// If not, make sure the team list has no element selected
			teamSelectList.getSelectionModel().clearSelection();
			// If no team is selected the unassociated list must be empty; Added for Della08
			establishUnassociatedMemberSelectList("");
			// Same thing for the associated list; Added for Della08
			establishAssociatedMemberSelectList("");
		} else { // A team was selected
			teamSelectList.getSelectionModel().select(selectedIndex); // Select that team
			// Use that team to establish the unassociated list of members; Added for
			// Della08
			establishUnassociatedMemberSelectList(teamList.getName(selectedIndex));
			// Same thing for the associated list; Added for Della08
			establishAssociatedMemberSelectList(teamList.getName(selectedIndex));
		}
		teamList.setCurrentSelectedElementIndex(selectedIndex);
		updatingGUI = false;
	}

	/**
	 * When the "Add association" button is clicked, this routine is called to
	 * process it
	 * 
	 * Added for Della08
	 */
	private void addMemberAssociation() {
		if (unassociatedMembersSelectList.getSelectionModel().getSelectedIndex() > noItemSelected) {
			String selectedMember = (String) unassociatedMembersSelectList.getSelectionModel().getSelectedItem();
			String selectedTeam = (String) teamSelectList.getSelectionModel().getSelectedItem();
			int numMemberTeams = aiM.getNumTeamAffiliations(selectedMember);
			int numTeamMembers = aiM.getNumMemberAssociations(selectedTeam);
			// Verify that there is is room for this addition!
			if ((numMemberTeams < 10) && (numTeamMembers < 10)) {
				// Add a team affiliation to this member
				aiM.addTeamAffiliation(selectedMember, selectedTeam);
				// Add a member association to this team
				aiM.addMemberAssociation(selectedTeam, selectedMember);
				// Set the newly added member as selected in the list of members for this team
				aiM.setSelectedAssociatedMember(selectedTeam, selectedMember);
				// Have no team in the unassociated list selected
				aiM.setSelectedUnassociatedMember(selectedTeam, "");
				// Set the newly added team as selected in the list of teams for this member
				aiM.setSelectedAffiliatedTeam(selectedMember, selectedTeam);
				// Have no team in the unaffiliated list selected
				aiM.setSelectedUnaffiliatedTeam(selectedMember, "");
			} else {
				if (numMemberTeams > 9)
					MessageBox.show("A member may not be on more than 10 teams!", "Error");
				else
					MessageBox.show("A team may not have more than 10 members!", "Error");
				return;
			}
			// Rebuild the affiliated team list for this member and display it
			establishAssociatedMemberSelectList(selectedTeam);
			// Rebuild the unaffiliated team list for this member and display it
			establishUnassociatedMemberSelectList(selectedTeam);
			theController.setDirtyFlag(true);
		} else
			MessageBox.show("No member was selected!", "Error");
	}

	/**
	 * When the "Remove association" button is clicked, this routine is called to
	 * process it
	 * 
	 * Added for Della08
	 */
	private void removeMemberAssociation() {
		if (associatedMembersSelectList.getSelectionModel().getSelectedIndex() > noItemSelected) {
			String selectedMember = (String) associatedMembersSelectList.getSelectionModel().getSelectedItem();
			String selectedTeam = (String) teamSelectList.getSelectionModel().getSelectedItem();
			aiM.removeMemberAssociation(selectedTeam, selectedMember);
			// Remove this member from this team's list of members
			aiM.removeTeamAffiliation(selectedMember, selectedTeam);
			// Remove this team from this member's list of teams
			aiM.setSelectedUnassociatedMember(selectedTeam, selectedMember);
			// Have this member be selected in the list of unassociated members for this
			// team
			aiM.setSelectedAssociatedMember(selectedTeam, "");
			// Have no member be selected in the list of associated members for this team
			aiM.setSelectedUnaffiliatedTeam(selectedMember, selectedTeam);
			// Have this team be selected in the list of unaffiliated teams for this member
			aiM.setSelectedAffiliatedTeam(selectedMember, "");
			// Have no team be selected in the list of affiliated teams for this member
			establishAssociatedMemberSelectList(selectedTeam);
			// Rebuild the list of associated members for this team and display it
			establishUnassociatedMemberSelectList(selectedTeam);
			// Rebuild the list of unassociated members for this team and display it
			theController.setDirtyFlag(true);
		} else
			MessageBox.show("No member was selected!", "Error");
	}
	
	/**
	 * When an associated member is clicked, this routine is called to process it
	 * 
	 * Added for Della08
	 */
	private void selectAssociatedMember(){
		if (updatingGUI != true) {
			String selectedMember = (String)associatedMembersSelectList.getSelectionModel().getSelectedItem();
			String selectedTeam = (String)teamSelectList.getSelectionModel().getSelectedItem();
			aiM.setSelectedAssociatedMember(selectedTeam, selectedMember);
			// Select the associated member that was clicked
			aiM.setSelectedUnassociatedMember(selectedTeam, "");
			// Clear the unassociated member select list... both cannot have selected items
			establishUnassociatedMemberSelectList(selectedTeam);
			// Cause the unassociated select list to be repainted incase a deselect has occurred
			theController.setDirtyFlag(true); 
		}
	}
	
	/**
	 * When an unassociated member is clicked, this routine is called to process it
	 * 
	 * Added for Della08
	 */
	private void selectUnassociatedMember(){
		if (updatingGUI != true) {
			String selectedMember = (String)unassociatedMembersSelectList.getSelectionModel().getSelectedItem();
			String selectedTeam = (String)teamSelectList.getSelectionModel().getSelectedItem();
			aiM.setSelectedUnassociatedMember(selectedTeam, selectedMember);
			// Select the unasscoaited member that was clicked
			aiM.setSelectedAssociatedMember(selectedTeam, "");
			// Clear the associated mdember select list... both cannot have a selected items
			establishAssociatedMemberSelectList(selectedTeam);
			// Cause the associated select list to be repainted incase a deselect has occurred
			theController.setDirtyFlag(true); 
		}
	}
	
	/**
	 * This routine establishes a select list of all of the unassocuated members for a specific team and finds the selected one
	 * 
	 * Added for Della08
	 */
	private void establishUnassociatedMemberSelectList(String teamName){
		updatingGUI = true;
		unassociatedMembersTeamNameLabel.setText(teamName);
		unassociatedMembersSelectList.getItems().clear();
		if (teamName.length()>0){	// If the team name is not empty, then use that team's unassociated member names
			String[] UnassociatedMember = aiM.getUnassociatedMembers(teamName);
			int numUnassociatedMembers = UnassociatedMember.length;
			String selectedUnassociatedMember = aiM.getSelectedUnassociatedMember(teamName);
			if (selectedUnassociatedMember == null) selectedUnassociatedMember = "";
			int selectedIndex = noItemSelected;
			for (int ndx=0; ndx < numUnassociatedMembers; ndx++) {	// Add all the names to the select list
				unassociatedMembersSelectList.getItems().add(UnassociatedMember[ndx]);
				if (selectedUnassociatedMember.compareToIgnoreCase(UnassociatedMember[ndx]) == 0) selectedIndex = ndx;
				// After adding each name, see if that name is the selected one.  If so, remember its index
			}
			unassociatedMembersSelectList.getSelectionModel().select(selectedIndex);
			// After the select list is build, specify which one was the selected element
		}
		updatingGUI = false;
	}

	/**
	 * This routine establishes a select list of all of the associated members for a specific team and finds the selected one
	 * 
	 * Added for Della08
	 */
	private void establishAssociatedMemberSelectList(String teamName){
		updatingGUI = true;
		associatedMembersTeamNameLabel.setText(teamName);
		associatedMembersSelectList.getItems().clear();
		if (teamName.length()>0){	// If the team name is not empty, then use that team's associated member names
			String[] AssociatedMember = aiM.getAssociatedMembers(teamName);
			int numAssociatedMembers = AssociatedMember.length;
			String selectedAssociatedMember = aiM.getSelectedAssociatedMember(teamName);
			if (selectedAssociatedMember == null) selectedAssociatedMember = "";
			int selectedIndex = noItemSelected;
			for (int ndx=0; ndx < numAssociatedMembers; ndx++) {	// Add all the names to the select list
				associatedMembersSelectList.getItems().add(AssociatedMember[ndx]);
				if (selectedAssociatedMember.compareToIgnoreCase(AssociatedMember[ndx]) == 0) selectedIndex = ndx;
				// After adding each name, see if that name is the selected one.  If so, remember its index
			}
			associatedMembersSelectList.getSelectionModel().select(selectedIndex);
			// After the select list is build, specify which one was the selected element
		}
		updatingGUI = false;
	}


}
