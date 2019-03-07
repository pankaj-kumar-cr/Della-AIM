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
 * Title: MemberScreen
 * </p>
 *
 * <p>
 * Description: The Della Member Screen code
 * </p>
 *
 * <p>
 * Copyright: Copyright © 2007
 * </p>
 *
 * @author Lynn Robert Carter
 * @version 1.07 
 * Many thanks to Harry Sameshima for his original work.
 */

public class MemberScreen extends Pane {

	// ---------------------------------------------------------------------------------------------------------------------
	// Member Screen constants

	private static final int noItemSelected = -1; // Added for Della04

	// ---------------------------------------------------------------------------------------------------------------------
	// Member Screen attributes

	// Added for Della04
	private Boolean updatingGUI = false;

	private Controller theController = null;
	private ActionItemManager aiM = null;

	// ---------------------------------------------------------------------------------------------------------------------
	// Member Screen GUI elements
	Label membersLabel = new Label();

	// Added for Della04 (start)
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

	Button addMemberButton = new Button();
	Button removeMemberButton = new Button();

	Label memberListLabel = new Label();
	ListView<String> memberSelectList = new ListView<String>();
	ScrollPane scrollableMemberListPane = new ScrollPane();
	// Added for Della04 (end)

	// Added for Della07 (start)
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

	Label unaffiliatedTeamsListLabel = new Label();
	Label unaffiliatedTeamsMemberNameLabel = new Label();
	ListView<String> unaffiliatedTeamsSelectList = new ListView<String>();
	ScrollPane scrollableUnaffiliatedTeamsListPane = new ScrollPane();

	Button addTeamAffiliationButton = new Button();
	Button removeTeamAffiliationButton = new Button();

	Label affiliatedTeamsListLabel = new Label();
	Label affiliatedTeamsMemberNameLabel = new Label();
	ListView<String> affiliatedTeamsSelectList = new ListView<String>();
	ScrollPane scrollableAffiliatedTeamsListPane = new ScrollPane();
	// Added for Della07 (end)

	// ---------------------------------------------------------------------------------------------------------------------

	/**
	 * The MemberScreen class constructor.
	 * 
	 */
	public MemberScreen() {
		// Use a modified singleton pattern to access the application's state; Added for
		// Della04
		theController = Controller.getInstance();
		aiM = theController.getActionItemManager();

		// Set up all of the Graphical User Interface elements and place them on the
		// screen
		guiInit();

		// Initialize the screen; Added for Della04
		loadScreen();
	}

	/**
	 * Initialize each graphic element, position it on the screen, and add it to the
	 * layout.
	 * 
	 */
	private void guiInit() {
		membersLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 14));
		membersLabel.setStyle("-fx-border-color: black");
		membersLabel.setText("Members");
		membersLabel.setPadding(new Insets(3, 290, 3, 296));

		// Added for Della04 (start)
		nameLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		nameLabel.setText("Name of someone new (Last, First Middle)");
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

		addMemberButton.setFont(Font.font("Dialog", FontWeight.BOLD, 12));
		addMemberButton.setText("Add to List ->");
		addMemberButton.setLayoutX(243);
		addMemberButton.setLayoutY(35);
		addMemberButton.setMinWidth(170);
		addMemberButton.setMaxWidth(170);
		addMemberButton.setMinHeight(35);
		addMemberButton.setMaxHeight(35);
		addMemberButton.setOnAction(e -> addMember());

		removeMemberButton.setFont(Font.font("Dialog", FontWeight.BOLD, 12));
		removeMemberButton.setText("<- Remove from List");
		removeMemberButton.setLayoutX(243);
		removeMemberButton.setLayoutY(95);
		removeMemberButton.setMinWidth(170);
		removeMemberButton.setMaxWidth(170);
		removeMemberButton.setMinHeight(35);
		removeMemberButton.setMaxHeight(35);
		removeMemberButton.setOnAction(e -> removeMember());

		memberListLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		memberListLabel.setText("Individuals known by Della");
		memberListLabel.setLayoutX(460);
		memberListLabel.setLayoutY(23);
		memberListLabel.setMinWidth(200);
		memberListLabel.setMaxWidth(200);
		memberListLabel.setMinHeight(15);
		memberListLabel.setMaxHeight(15);
		memberSelectList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			selectMember();
		});
		scrollableMemberListPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		scrollableMemberListPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		scrollableMemberListPane.setContent(memberSelectList);
		scrollableMemberListPane.setLayoutX(460);
		scrollableMemberListPane.setLayoutY(40);
		scrollableMemberListPane.setMinWidth(180);
		scrollableMemberListPane.setMaxWidth(180);
		scrollableMemberListPane.setMinHeight(155);
		scrollableMemberListPane.setMaxHeight(155);
		// Added for Della04 (end)

		// Added for Della07 (start)
		guidanceR8Label.setFont(Font.font("Dialog", FontWeight.BOLD, 10));
		guidanceR8Label.setText("To add a team affiliation for an individual:");
		guidanceR8Label.setLayoutX(5);
		guidanceR8Label.setLayoutY(205);
		guidanceR8Label.setMinWidth(240);
		guidanceR8Label.setMaxWidth(240);
		guidanceR8Label.setMinHeight(15);
		guidanceR8Label.setMaxHeight(15);

		guidanceR9Label.setFont(Font.font("Dialog", FontWeight.NORMAL, 10));
		guidanceR9Label.setText("1. Click on the name of the individual above right.");
		guidanceR9Label.setLayoutX(5);
		guidanceR9Label.setLayoutY(220);
		guidanceR9Label.setMinWidth(240);
		guidanceR9Label.setMaxWidth(240);
		guidanceR9Label.setMinHeight(15);
		guidanceR9Label.setMaxHeight(15);

		guidanceR10Label.setFont(Font.font("Dialog", FontWeight.NORMAL, 10));
		guidanceR10Label.setText("2. Click on a team name in the list below.");
		guidanceR10Label.setLayoutX(5);
		guidanceR10Label.setLayoutY(235);
		guidanceR10Label.setMinWidth(240);
		guidanceR10Label.setMaxWidth(240);
		guidanceR10Label.setMinHeight(15);
		guidanceR10Label.setMaxHeight(15);

		guidanceR11Label.setFont(Font.font("Dialog", FontWeight.NORMAL, 10));
		guidanceR11Label.setText("3. Click on \"Add affiliation\" button.");
		guidanceR11Label.setLayoutX(5);
		guidanceR11Label.setLayoutY(250);
		guidanceR11Label.setMinWidth(240);
		guidanceR11Label.setMaxWidth(240);
		guidanceR11Label.setMinHeight(15);
		guidanceR11Label.setMaxHeight(15);

		guidanceR12Label.setFont(Font.font("Dialog", FontWeight.BOLD, 10));
		guidanceR12Label.setText("To remove a team affiliation for an individual:");
		guidanceR12Label.setLayoutX(400);
		guidanceR12Label.setLayoutY(205);
		guidanceR12Label.setMinWidth(240);
		guidanceR12Label.setMaxWidth(240);
		guidanceR12Label.setMinHeight(15);
		guidanceR12Label.setMaxHeight(15);

		guidanceR13Label.setFont(Font.font("Dialog", FontWeight.NORMAL, 10));
		guidanceR13Label.setText("1. Click on the name of the individual above.");
		guidanceR13Label.setLayoutX(400);
		guidanceR13Label.setLayoutY(220);
		guidanceR13Label.setMinWidth(240);
		guidanceR13Label.setMaxWidth(240);
		guidanceR13Label.setMinHeight(15);
		guidanceR13Label.setMaxHeight(15);

		guidanceR14Label.setFont(Font.font("Dialog", FontWeight.NORMAL, 10));
		guidanceR14Label.setText("2. Click on a team name in the list below.");
		guidanceR14Label.setLayoutX(400);
		guidanceR14Label.setLayoutY(235);
		guidanceR14Label.setMinWidth(240);
		guidanceR14Label.setMaxWidth(240);
		guidanceR14Label.setMinHeight(15);
		guidanceR14Label.setMaxHeight(15);

		guidanceR15Label.setFont(Font.font("Dialog", FontWeight.NORMAL, 10));
		guidanceR15Label.setText("3. Click on \"Remove affiliation\" button.");
		guidanceR15Label.setLayoutX(400);
		guidanceR15Label.setLayoutY(250);
		guidanceR15Label.setMinWidth(240);
		guidanceR15Label.setMaxWidth(240);
		guidanceR15Label.setMinHeight(15);
		guidanceR15Label.setMaxHeight(15);

		guidanceR16Label.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		guidanceR16Label.setText("Click on an individual\'s name");
		guidanceR16Label.setLayoutX(255);
		guidanceR16Label.setLayoutY(150);
		guidanceR16Label.setMinWidth(240);
		guidanceR16Label.setMaxWidth(240);
		guidanceR16Label.setMinHeight(15);
		guidanceR16Label.setMaxHeight(15);

		guidanceR17Label.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		guidanceR17Label.setText("to see team affiliations.");
		guidanceR17Label.setLayoutX(255);
		guidanceR17Label.setLayoutY(165);
		guidanceR17Label.setMinWidth(240);
		guidanceR17Label.setMaxWidth(240);
		guidanceR17Label.setMinHeight(15);
		guidanceR17Label.setMaxHeight(15);

		unaffiliatedTeamsListLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		unaffiliatedTeamsListLabel.setText("Available teams for");
		unaffiliatedTeamsListLabel.setLayoutX(10);
		unaffiliatedTeamsListLabel.setLayoutY(275);
		unaffiliatedTeamsListLabel.setMinWidth(200);
		unaffiliatedTeamsListLabel.setMaxWidth(200);
		unaffiliatedTeamsListLabel.setMinHeight(15);
		unaffiliatedTeamsListLabel.setMaxHeight(15);
		unaffiliatedTeamsMemberNameLabel.setFont(Font.font("Dialog", FontWeight.NORMAL, 10));
		unaffiliatedTeamsMemberNameLabel.setText("");
		unaffiliatedTeamsMemberNameLabel.setLayoutX(10);
		unaffiliatedTeamsMemberNameLabel.setLayoutY(290);
		unaffiliatedTeamsMemberNameLabel.setMinWidth(200);
		unaffiliatedTeamsMemberNameLabel.setMaxWidth(200);
		unaffiliatedTeamsMemberNameLabel.setMinHeight(15);
		unaffiliatedTeamsMemberNameLabel.setMaxHeight(15);
		unaffiliatedTeamsSelectList.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> {
					selectUnaffiliatedTeam();
				});
		// unaffiliatedTeamsSelectList.setMinWidth(50); //enable if required
		scrollableUnaffiliatedTeamsListPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		scrollableUnaffiliatedTeamsListPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		scrollableUnaffiliatedTeamsListPane.setContent(unaffiliatedTeamsSelectList);
		scrollableUnaffiliatedTeamsListPane.setLayoutX(10);
		scrollableUnaffiliatedTeamsListPane.setLayoutY(305);
		scrollableUnaffiliatedTeamsListPane.setMinWidth(180);
		scrollableUnaffiliatedTeamsListPane.setMaxWidth(180);
		scrollableUnaffiliatedTeamsListPane.setMinHeight(140);
		scrollableUnaffiliatedTeamsListPane.setMaxHeight(140);

		addTeamAffiliationButton.setFont(Font.font("Dialog", FontWeight.BOLD, 12));
		addTeamAffiliationButton.setText("Add affiliation ->");
		addTeamAffiliationButton.setLayoutX(240);
		addTeamAffiliationButton.setLayoutY(330);
		addTeamAffiliationButton.setMinWidth(176);
		addTeamAffiliationButton.setMaxWidth(176);
		addTeamAffiliationButton.setMinHeight(35);
		addTeamAffiliationButton.setMaxHeight(35);
		addTeamAffiliationButton.setOnAction(e -> addTeamAffiliation());

		removeTeamAffiliationButton.setFont(Font.font("Dialog", FontWeight.BOLD, 12));
		removeTeamAffiliationButton.setText("<- Remove affiliation");
		removeTeamAffiliationButton.setLayoutX(240);
		removeTeamAffiliationButton.setLayoutY(385);
		removeTeamAffiliationButton.setMinWidth(176);
		removeTeamAffiliationButton.setMaxWidth(176);
		removeTeamAffiliationButton.setMinHeight(35);
		removeTeamAffiliationButton.setMaxHeight(35);
		removeTeamAffiliationButton.setOnAction(e -> removeTeamAffiliation());

		affiliatedTeamsListLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		affiliatedTeamsListLabel.setText("Current teams for");
		affiliatedTeamsListLabel.setLayoutX(460);
		affiliatedTeamsListLabel.setLayoutY(275);
		affiliatedTeamsListLabel.setMinWidth(200);
		affiliatedTeamsListLabel.setMaxWidth(200);
		affiliatedTeamsListLabel.setMinHeight(15);
		affiliatedTeamsListLabel.setMaxHeight(15);
		affiliatedTeamsMemberNameLabel.setFont(Font.font("Dialog", FontWeight.NORMAL, 10));
		affiliatedTeamsMemberNameLabel.setText("");
		affiliatedTeamsMemberNameLabel.setLayoutX(460);
		affiliatedTeamsMemberNameLabel.setLayoutY(290);
		affiliatedTeamsMemberNameLabel.setMinWidth(200);
		affiliatedTeamsMemberNameLabel.setMaxWidth(200);
		affiliatedTeamsMemberNameLabel.setMinHeight(15);
		affiliatedTeamsMemberNameLabel.setMaxHeight(15);
		affiliatedTeamsSelectList.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> {
					selectAffiliatedTeam();
				});
		// affiliatedTeamsSelectList.setMinWidth(50); //enable if required
		scrollableAffiliatedTeamsListPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		scrollableAffiliatedTeamsListPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		scrollableAffiliatedTeamsListPane.setContent(affiliatedTeamsSelectList);
		scrollableAffiliatedTeamsListPane.setLayoutX(460);
		scrollableAffiliatedTeamsListPane.setLayoutY(305);
		scrollableAffiliatedTeamsListPane.setMinWidth(180);
		scrollableAffiliatedTeamsListPane.setMaxWidth(180);
		scrollableAffiliatedTeamsListPane.setMinHeight(140);
		scrollableAffiliatedTeamsListPane.setMaxHeight(140);
		// Added for Della07 (end)

		// ----------------------------------------------------------------------------
		// Add the objects to the layout
		this.getChildren().add(membersLabel);

		// Added for Della04 (start)
		this.getChildren().addAll(nameLabel, nameTextField, guidanceR1Label, guidanceR2Label, guidanceR3Label,
				guidanceR4Label, guidanceR5Label, guidanceR6Label, guidanceR7Label, trashCanLabel, addMemberButton,
				removeMemberButton, memberListLabel, scrollableMemberListPane);
		// Added for Della04 (end)

		// Added for Della07 (start)
		this.getChildren().addAll(guidanceR8Label, guidanceR9Label, guidanceR10Label, guidanceR11Label,
				guidanceR12Label, guidanceR13Label, guidanceR14Label, guidanceR15Label, guidanceR16Label,
				guidanceR17Label, unaffiliatedTeamsListLabel, unaffiliatedTeamsMemberNameLabel,
				scrollableUnaffiliatedTeamsListPane, addTeamAffiliationButton, removeTeamAffiliationButton,
				affiliatedTeamsListLabel, affiliatedTeamsMemberNameLabel, scrollableAffiliatedTeamsListPane);
		// Added for Della07 (end)

	}

	/**
	 * Process a "Add to List" button click request Add the new name, if valid, to
	 * the member list
	 * 
	 * Added for Della04
	 */
	private void addMember() {
		ElementList memberList = aiM.getMemberList();

		try {
			String newName = nameTextField.getText();
			loadScreenAndLists(memberList.addElement(newName));
			nameTextField.setText(""); // If name was accepted, blank out the input field
			memberList.setUnaddedName(""); // and reset the persistent input field copy
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
	 * Added for Della04
	 */
	private void removeMember() {
		int selectedIndex = memberSelectList.getSelectionModel().getSelectedIndex();
		if (selectedIndex == noItemSelected) {
			MessageBox.show("No member was selected!", "Error");
			return;
		} else {
			String memberName = aiM.getMemberList().getName(selectedIndex);
			aiM.removeAssignedMember(memberName);
			aiM.getTeamList().removeAssociatedName(memberName); // Added for Della07
			nameTextField.setText(memberName);
			loadScreenAndLists(noItemSelected);
			theController.setDirtyFlag(true);
		}
	}

	/**
	 * Process a member select list selection action
	 * 
	 * Added for Della04
	 */
	private void selectMember() {
		if (updatingGUI == false) {
			ElementList memberList = aiM.getMemberList();
			int selectedIndex = memberSelectList.getSelectionModel().getSelectedIndex();
			memberList.setCurrentSelectedElementIndex(selectedIndex);
			establishUnaffiliatedTeamSelectList(memberList.getName(selectedIndex)); // Added for Della07
			establishAffiliatedTeamSelectList(memberList.getName(selectedIndex)); // Added for Della07
			theController.setDirtyFlag(true);
		}
	}

	/**
	 * When a shut down occurs or transfer to some other screen occurs, this routine
	 * is called to cause the UI state of the text input to be saved to the
	 * persistent store
	 * 
	 * Added for Della04
	 */
	public void saveScreenState() {
		ElementList memberList = aiM.getMemberList();
		memberList.setUnaddedName(nameTextField.getText());
	}

	/**
	 * When a navigation button click requires this screen to be activated, this
	 * routine is called to load the screen and re-establish the perishable fields
	 * 
	 * Added for Della04
	 */
	public void loadScreen() {
		ElementList memberList = aiM.getMemberList();
		loadScreenAndLists(memberList.getCurrentSelectedElementIndex());
		nameTextField.setText(memberList.getUnaddedName());
	}

	/**
	 * This shared private routine does the heavy lifting of actually setting up the
	 * GUI for this screen
	 * 
	 * Added for Della04
	 */
	private void loadScreenAndLists(int selectedIndex) {
		updatingGUI = true;
		// Set the flag so that no select events are processed by these actions
		ElementList memberList = aiM.getMemberList();
		// Fetch the list of members to populate the select list
		memberSelectList.getItems().clear();
		// Reset the select list so it contains no elements
		int listSize = memberList.getListSize();
		// Fetch the size of the list of members and use this to iterate over all
		// members
		for (int i = 0; i < listSize; i++)
			memberSelectList.getItems().add(memberList.getName(i));
		// Add each member to the select list
		if (selectedIndex == noItemSelected) { // See if a member is selected
			// If not, make sure the member list has no element selected
			memberSelectList.getSelectionModel().clearSelection();
			// If no member is selected the unaffiliated list must be empty; Added for
			// Della07
			establishUnaffiliatedTeamSelectList("");
			// Same thing for the affiliated list; Added for Della07
			establishAffiliatedTeamSelectList("");
		} else { // A member was selected
			// Select that member
			memberSelectList.getSelectionModel().select(selectedIndex);
			// Use that member to establish the unaffiliated list of teams; Added for
			// Della07
			establishUnaffiliatedTeamSelectList(memberList.getName(selectedIndex));
			// Same thing for the affiliated list; Added for Della07
			establishAffiliatedTeamSelectList(memberList.getName(selectedIndex));
		}
		memberList.setCurrentSelectedElementIndex(selectedIndex);
		updatingGUI = false;
	}

	/**
	 * When the "Add affiliation" button is clicked, this routine is called to
	 * process it
	 * 
	 * Added for Della07
	 */
	private void addTeamAffiliation() {
		if (unaffiliatedTeamsSelectList.getSelectionModel().getSelectedIndex() > noItemSelected) {
			String selectedTeam = (String) unaffiliatedTeamsSelectList.getSelectionModel().getSelectedItem();
			String selectedMember = (String) memberSelectList.getSelectionModel().getSelectedItem();
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
			establishAffiliatedTeamSelectList(selectedMember);
			// Rebuild the unaffiliated team list for this member and display it
			establishUnaffiliatedTeamSelectList(selectedMember);
			theController.setDirtyFlag(true);
		} else
			MessageBox.show("No team was selected!", "Error");
	}

	/**
	 * When the "Remove affiliation" button is clicked, this routine is called to
	 * process it
	 * 
	 * Added for Della07
	 */
	private void removeTeamAffiliation() {
		if (affiliatedTeamsSelectList.getSelectionModel().getSelectedIndex() > noItemSelected) {
			String selectedTeam = (String) affiliatedTeamsSelectList.getSelectionModel().getSelectedItem();
			String selectedMember = (String) memberSelectList.getSelectionModel().getSelectedItem();
			aiM.removeTeamAffiliation(selectedMember, selectedTeam);
			// Remove this team from this member's list of teams
			aiM.removeMemberAssociation(selectedTeam, selectedMember);
			// Remove this member from this team's list of members
			aiM.setSelectedUnassociatedMember(selectedTeam, selectedMember);
			// Have this member be selected in the list of unassociated members for this
			// team
			aiM.setSelectedAssociatedMember(selectedTeam, "");
			// Have no member be selected in the list of associated members for this team
			aiM.setSelectedUnaffiliatedTeam(selectedMember, selectedTeam);
			// Have this team be selected in the list of unaffiliated teams for this member
			aiM.setSelectedAffiliatedTeam(selectedMember, "");
			// Have no team be selected in the list of affiliated teams for this member
			establishAffiliatedTeamSelectList(selectedMember);
			// Rebuild the list of affiliated teams for this member and display it
			establishUnaffiliatedTeamSelectList(selectedMember);
			// Rebuild the list of unaffiliated teams for this member and display it
			theController.setDirtyFlag(true);
		} else
			MessageBox.show("No team was selected!", "Error");
	}

	/**
	 * When an affiliated team is clicked, this routine is called to process it
	 * 
	 * Added for Della07
	 */
	private void selectAffiliatedTeam() {
		if (updatingGUI != true) {
			String selectedTeam = (String) affiliatedTeamsSelectList.getSelectionModel().getSelectedItem();
			String selectedMember = (String) memberSelectList.getSelectionModel().getSelectedItem();
			aiM.setSelectedAffiliatedTeam(selectedMember, selectedTeam);
			// Select the affiliated team that was clicked
			aiM.setSelectedUnaffiliatedTeam(selectedMember, "");
			// Clear the unafffiliated team select list... both cannot have selected items
			establishUnaffiliatedTeamSelectList(selectedMember);
			// Cause the unaffiliated select list to be repainted incase a deselect has
			// occurred
			theController.setDirtyFlag(true);
		}
	}
	
	/**
	 * When an unaffiliated team is clicked, this routine is called to process it
	 * 
	 * Added for Della07
	 */
	private void selectUnaffiliatedTeam(){
		if (updatingGUI != true) {
			String selectedTeam = (String)unaffiliatedTeamsSelectList.getSelectionModel().getSelectedItem();
			String selectedMember = (String)memberSelectList.getSelectionModel().getSelectedItem();
			aiM.setSelectedUnaffiliatedTeam(selectedMember, selectedTeam);
			// Select the unaffiliated team that was clicked
			aiM.setSelectedAffiliatedTeam(selectedMember, "");
			// Clear the affiliated team select list... both cannot have a selected items
			establishAffiliatedTeamSelectList(selectedMember);
			// Cause the affiliated select list to be repainted incase a deselect has occurred
			theController.setDirtyFlag(true); 
		}
	}

	/**
	 * This routine establishes a select list of all of the unaffiliated teams for a
	 * specific member and finds the selected one
	 * 
	 * Added for Della07
	 */
	private void establishUnaffiliatedTeamSelectList(String memberName) {
		updatingGUI = true;
		unaffiliatedTeamsMemberNameLabel.setText(memberName);
		unaffiliatedTeamsSelectList.getItems().clear();
		if (memberName.length() > 0) { // If the member name is not empty, then use that member's unaffiliated team
										// names
			String[] UnaffiliatedTeam = aiM.getUnaffiliatedTeams(memberName);
			int numUnaffiliatedTeams = UnaffiliatedTeam.length;
			String selectedUnaffiliatedTeam = aiM.getSelectedUnaffiliatedTeam(memberName);
			if (selectedUnaffiliatedTeam == null)
				selectedUnaffiliatedTeam = "";
			int selectedIndex = noItemSelected;
			for (int ndx = 0; ndx < numUnaffiliatedTeams; ndx++) { // Add all the names to the select list
				unaffiliatedTeamsSelectList.getItems().add(UnaffiliatedTeam[ndx]);
				if (selectedUnaffiliatedTeam.compareToIgnoreCase(UnaffiliatedTeam[ndx]) == 0)
					selectedIndex = ndx;
				// After adding each name, see if that name is the selected one. If so, remember
				// its index
			}
			unaffiliatedTeamsSelectList.getSelectionModel().select(selectedIndex);
			// After the select list is build, specify which one was the selected element
		}
		updatingGUI = false;
	}
	
	/**
	 * This routine establishes a select list of all of the affiliated teams for a specific member and finds the selected one
	 * 
	 * Added for Della07
	 */
	private void establishAffiliatedTeamSelectList(String memberName){
		updatingGUI = true;
		affiliatedTeamsMemberNameLabel.setText(memberName);
		affiliatedTeamsSelectList.getItems().clear();
		if (memberName.length()>0){	// If the member name is not empty, then use that mamber's affiliated team names
			String[] AffiliatedTeam = aiM.getAffiliatedTeams(memberName);
			int numAffiliatedTeams = AffiliatedTeam.length;
			String selectedAffiliatedTeam = aiM.getSelectedAffiliatedTeam(memberName);
			if (selectedAffiliatedTeam == null) selectedAffiliatedTeam = "";
			int selectedIndex = noItemSelected;
			for (int ndx=0; ndx < numAffiliatedTeams; ndx++) {	// Add all the names to the select list
				affiliatedTeamsSelectList.getItems().add(AffiliatedTeam[ndx]);
				if (selectedAffiliatedTeam.compareToIgnoreCase(AffiliatedTeam[ndx]) == 0) selectedIndex = ndx;
				// After adding each name, see if that name is the selected one.  If so, remember its index
			}
			affiliatedTeamsSelectList.getSelectionModel().select(selectedIndex);
			// After the select list is build, specify which one was the selected element
		}
		updatingGUI = false;
	}

}
