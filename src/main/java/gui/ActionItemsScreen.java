package gui;

import utility.*;
import java.text.SimpleDateFormat;
import control.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.ActionItem;
import model.ActionItemManager;
import model.ElementList;

/**
 * <p>
 * Title: ActionItemScreen
 * </p>
 * 
 * <p>
 * Description: A manually generated Action Item Screen for Della
 * </p>
 * 
 * <p>
 * Copyright: Copyright © 2007
 * </p>
 * 
 * @author Lynn Robert Carter
 * @version 1.10 Many thanks to Harry Sameshima for his original work.
 */

public class ActionItemsScreen extends Pane {
	// --------------------------------------------------------------------------------------------------------
	// Action Item Screen Constants

	public static final int noItemSelected = -1;

	// -------------------------------------------------------------------------------------------------------
	// Action Item Screen Attributes

	private boolean updatingGUI = false;
	private Controller theController = null;
	private ActionItemManager aiM = null;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	// Added for Della05
	private String selectedMember = "";

	// Added for Della09
	private String selectedTeam = "";

	// ---------------------------------------------------------------------------------------------------------------------
	// Action Item Screen GUI elements

	Label actionItemsLabel = new Label();

	// Added for Della01 (start)
	Label comboBoxLabel = new Label();
	ComboBox<String> aiListComboBox = new ComboBox<String>();
	Label selectGuidanceLabel = new Label();
	// Added for Della01 (end)

	// Added for Della10 (start)
	Label inclusionFactorLabel = new Label();
	ObservableList<String> inclusion_factor_options = FXCollections
			.observableArrayList(ActionItemManager.inclusionFactorStrings);
	ComboBox<String> inclusionFactorComboBox = new ComboBox<String>(inclusion_factor_options);
	// Added for Della10 (end)

	// Added for Della02 (start)
	ObservableList<String> sort_direction_options = FXCollections
			.observableArrayList(ActionItemManager.sortDirectionStrings);
	ComboBox<String> sortDirectionComboBox = new ComboBox<String>(sort_direction_options);
	ObservableList<String> sort_factor1_options = FXCollections
			.observableArrayList(ActionItemManager.sortingFactorStrings);
	ComboBox<String> sortFactor1ComboBox = new ComboBox<String>(sort_factor1_options);
	ObservableList<String> sort_factor2_options = FXCollections
			.observableArrayList(ActionItemManager.sortingFactorStrings);
	ComboBox<String> sortFactor2ComboBox = new ComboBox<String>(sort_factor2_options);
	Label sortFactor1Label = new Label();
	Label sortFactor2Label = new Label();
	Label sortDirectionLabel = new Label();
	// Added for Della02 (end)

	Label selectedLabel = new Label();
	Label nameLabel = new Label();
	TextField nameTextField = new TextField();
	Label descriptionLabel = new Label();
	ScrollPane descriptionScrollPane = new ScrollPane();
	TextArea descriptionTextArea = new TextArea();
	Label resolutionLabel = new Label();
	ScrollPane resolutionScrollPane = new ScrollPane();
	TextArea resolutionTextArea = new TextArea();

	Label unsavedChangesLabel = new Label();

	Label datesLabel = new Label();
	Label creationLabel = new Label();
	Label creationValueLabel = new Label();
	Label dueDateLabel = new Label();
	TextField dueDateTextField = new TextField();
	Label formatLabel = new Label();
	Label actionItemLabel2 = new Label();
	Label statusLabel = new Label();

	ObservableList<String> options = FXCollections.observableArrayList(ActionItemManager.statusStrings);
	ComboBox<String> statusComboBox = new ComboBox<String>(options);

	// Added for Della05 (start)
	Label selectMemberComboBoxLabel = new Label();
	ComboBox<String> selectMemberComboBox = new ComboBox<String>();
	// Added for Della05 (end)

	// Added for Della09 (start)
	Label selectTeamComboBoxLabel = new Label();
	ComboBox<String> selectTeamComboBox = new ComboBox<String>();
	// Added for Della09 (end)

	// Action Buttons
	Button updateButton = new Button();
	Button clearButton = new Button();

	// Added for Della01
	Button createButton = new Button();

	// Added for Della10 (start)
	Button deleteButton = new Button();
	// Added for Della10 (end)
	// ---------------------------------------------------------------------------------------------------------------------

	/**
	 * The ActionItemScreen class constructor.
	 */
	public ActionItemsScreen() {
		// Use a modified singleton pattern to access the application's state
		theController = Controller.getInstance();
		aiM = theController.getActionItemManager();

		// Set up all of the Graphical User Interface elements and place them on the
		// screen
		guiInit();

		// Initialize the screen with current action item
		loadScreen();
	}

	/**
	 * Initialize each graphic element, position it on the screen, and add it to the
	 * layout
	 */

	private void guiInit() {
		// Updating the GUI
		updatingGUI = true;

		// Action Items Label
		actionItemsLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 14));
		actionItemsLabel.setStyle("-fx-border-color: black");
		actionItemsLabel.setText("Action Items");
		actionItemsLabel.setPadding(new Insets(3, 267, 3, 296));

		// Added for Della01 (start)
		comboBoxLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		comboBoxLabel.setText("Action Items:");
		comboBoxLabel.setLayoutX(7);
		comboBoxLabel.setLayoutY(27);
		comboBoxLabel.setMinWidth(100);
		comboBoxLabel.setMaxWidth(100);
		comboBoxLabel.setMinHeight(15);
		comboBoxLabel.setMaxHeight(15);

		aiListComboBox.setLayoutX(5);
		aiListComboBox.setLayoutY(42);
		aiListComboBox.setMinWidth(640);
		aiListComboBox.setMaxWidth(640);
		aiListComboBox.setMinHeight(25);
		aiListComboBox.setMaxHeight(25);
		aiListComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			selectActionItem();
		});

		selectGuidanceLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 10));
		selectGuidanceLabel.setText("Select an Action Item from the pull-down list above to examine and update it.");
		selectGuidanceLabel.setLayoutX(15);
		selectGuidanceLabel.setLayoutY(67);
		selectGuidanceLabel.setMinWidth(500);
		selectGuidanceLabel.setMaxWidth(500);
		selectGuidanceLabel.setMinHeight(15);
		selectGuidanceLabel.setMaxHeight(15);
		// Added for Della01 (end)

		// Added for Della10 (start)
		inclusionFactorLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		inclusionFactorLabel.setText("Inclusion Factor:");
		inclusionFactorLabel.setLayoutX(15);
		inclusionFactorLabel.setLayoutY(90);

		inclusionFactorComboBox.setLayoutX(15);
		inclusionFactorComboBox.setLayoutY(105);
		inclusionFactorComboBox.setMinWidth(175);
		inclusionFactorComboBox.setMaxWidth(175);
		inclusionFactorComboBox.setMinHeight(25);
		inclusionFactorComboBox.setMaxHeight(25);
		inclusionFactorComboBox.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> {
					listInclusionAction();
				});
		// Added for Della10 (end)

		// Added for Della02 (start)
		sortDirectionLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		sortDirectionLabel.setText("Sorting Direction:");
		sortDirectionLabel.setLayoutX(195);
		sortDirectionLabel.setLayoutY(90);

		sortDirectionComboBox.setLayoutX(195);
		sortDirectionComboBox.setLayoutY(105);
		sortDirectionComboBox.setMinWidth(140);
		sortDirectionComboBox.setMaxWidth(140);
		sortDirectionComboBox.setMinHeight(25);
		sortDirectionComboBox.setMaxHeight(25);
		sortDirectionComboBox.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> {
					sortDirection();
				});

		sortFactor1Label.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		sortFactor1Label.setText("First Sorting Factor:");
		sortFactor1Label.setLayoutX(335);
		sortFactor1Label.setLayoutY(90);

		sortFactor1ComboBox.setLayoutX(340);
		sortFactor1ComboBox.setLayoutY(105);
		sortFactor1ComboBox.setMinWidth(150);
		sortFactor1ComboBox.setMaxWidth(150);
		sortFactor1ComboBox.setMinHeight(25);
		sortFactor1ComboBox.setMaxHeight(25);
		sortFactor1ComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			sortingFactor1();
		});

		sortFactor2Label.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		sortFactor2Label.setText("Second Sorting Factor:");
		sortFactor2Label.setLayoutX(495);
		sortFactor2Label.setLayoutY(90);

		sortFactor2ComboBox.setLayoutX(495);
		sortFactor2ComboBox.setLayoutY(105);
		sortFactor2ComboBox.setMinWidth(150);
		sortFactor2ComboBox.setMaxWidth(150);
		sortFactor2ComboBox.setMinHeight(25);
		sortFactor2ComboBox.setMaxHeight(25);
		sortFactor2ComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			sortingFactor2();
		});
		// Added for Della02 (end)

		selectedLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		selectedLabel.setText("Selected Action Item:");
		selectedLabel.setAlignment(Pos.BASELINE_LEFT);
		selectedLabel.setLayoutX(7);
		selectedLabel.setLayoutY(145);

		nameLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		nameLabel.setText("Name:");
		nameLabel.setLayoutX(7);
		nameLabel.setLayoutY(165);

		nameTextField.setText("");
		nameTextField.setAlignment(Pos.BASELINE_LEFT);
		nameTextField.setMinWidth(390);
		nameTextField.setMaxWidth(390);
		nameTextField.setLayoutX(46);
		nameTextField.setLayoutY(165);
		nameTextField.setEditable(true);
		nameTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			checkForUnsavedUpdates();
		});

		descriptionLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		descriptionLabel.setText("Description:");
		descriptionLabel.setLayoutX(6);
		descriptionLabel.setLayoutY(190);
		descriptionScrollPane.setContent(descriptionTextArea);
		descriptionScrollPane.setLayoutX(7);
		descriptionScrollPane.setLayoutY(210);
		descriptionScrollPane.setMinWidth(430);
		descriptionScrollPane.setMaxWidth(430);
		descriptionScrollPane.setMinHeight(75);
		descriptionScrollPane.setMaxHeight(75);
		descriptionTextArea.setText("");
		descriptionTextArea.textProperty().addListener((observable, oldValue, newValue) -> {
			checkForUnsavedUpdates();
		});

		resolutionLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		resolutionLabel.setText("Resolution:");
		resolutionLabel.setLayoutX(6);
		resolutionLabel.setLayoutY(295);
		resolutionScrollPane.setContent(resolutionTextArea);
		resolutionScrollPane.setLayoutX(7);
		resolutionScrollPane.setLayoutY(315);
		resolutionScrollPane.setMinWidth(430);
		resolutionScrollPane.setMaxWidth(430);
		resolutionScrollPane.setMinHeight(75);
		resolutionScrollPane.setMaxHeight(75);
		resolutionTextArea.setText("");
		resolutionTextArea.textProperty().addListener((observable, oldValue, newValue) -> {
			checkForUnsavedUpdates();
		});

		datesLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		datesLabel.setText("Dates");
		datesLabel.setLayoutX(450);
		datesLabel.setLayoutY(175);

		creationLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		creationLabel.setText("Creation:");
		creationLabel.setAlignment(Pos.BASELINE_RIGHT);
		creationLabel.setLayoutX(469);
		creationLabel.setLayoutY(195);
		creationValueLabel.setText("");
		creationValueLabel.setLayoutX(528);
		creationValueLabel.setLayoutY(195);

		dueDateLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		dueDateLabel.setText("Due:");
		dueDateLabel.setAlignment(Pos.BASELINE_RIGHT);
		dueDateLabel.setLayoutX(469);
		dueDateLabel.setLayoutY(217);
		dueDateLabel.setMinWidth(51);
		dueDateLabel.setMaxWidth(51);
		dueDateLabel.setMinHeight(16);
		dueDateLabel.setMaxHeight(16);
		dueDateTextField.setLayoutX(524);
		dueDateTextField.setLayoutY(215);
		dueDateTextField.setMinWidth(90);
		dueDateTextField.setMaxWidth(90);
		dueDateTextField.setMinHeight(20);
		dueDateTextField.setMaxHeight(20);
		dueDateTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			checkForUnsavedUpdates();
		});

		formatLabel.setFont(Font.font("Dialog", FontWeight.NORMAL, 10));
		formatLabel.setText("Use yyyy-mm-dd format");
		formatLabel.setLayoutX(495);
		formatLabel.setLayoutY(238);
		formatLabel.setMinWidth(125);
		formatLabel.setMaxWidth(125);
		formatLabel.setMinHeight(11);
		formatLabel.setMaxHeight(11);

		actionItemLabel2.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		actionItemLabel2.setText("Action Item");
		actionItemLabel2.setLayoutX(450);
		actionItemLabel2.setLayoutY(260);
		actionItemLabel2.setMinWidth(67);
		actionItemLabel2.setMaxWidth(67);
		actionItemLabel2.setMinHeight(15);
		actionItemLabel2.setMaxHeight(15);

		statusLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		statusLabel.setText("Status:");
		statusLabel.setAlignment(Pos.BASELINE_RIGHT);
		statusLabel.setLayoutX(469);
		statusLabel.setLayoutY(277);
		statusLabel.setMinWidth(51);
		statusLabel.setMaxWidth(51);
		statusLabel.setMinHeight(16);
		statusLabel.setMaxHeight(16);

		statusComboBox.getSelectionModel().select(ActionItemManager.statusOpen);
		statusComboBox.setLayoutX(524);
		statusComboBox.setLayoutY(275);
		statusComboBox.setMinWidth(100);
		statusComboBox.setMaxWidth(100);
		statusComboBox.setMinHeight(25);
		statusComboBox.setMaxHeight(25);

		// Added for Della05 (start)
		selectMemberComboBoxLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		selectMemberComboBoxLabel.setText("Assigned to Member:");
		selectMemberComboBoxLabel.setLayoutX(450);
		selectMemberComboBoxLabel.setLayoutY(310);
		selectMemberComboBoxLabel.setMinWidth(150);
		selectMemberComboBoxLabel.setMaxWidth(150);
		selectMemberComboBoxLabel.setMinHeight(16);
		selectMemberComboBoxLabel.setMaxHeight(16);

		selectMemberComboBox.setLayoutX(450);
		selectMemberComboBox.setLayoutY(326);
		selectMemberComboBox.setMinWidth(195);
		selectMemberComboBox.setMaxWidth(195);
		selectMemberComboBox.setMinHeight(25);
		selectMemberComboBox.setMaxHeight(25);
		selectMemberComboBox.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> {
					selectMember();
				});
		// Added for Della05 (end)

		// Added for Della09 (start)
		selectTeamComboBoxLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		selectTeamComboBoxLabel.setText("Assigned to Team:");
		selectTeamComboBoxLabel.setLayoutX(450);
		selectTeamComboBoxLabel.setLayoutY(350);
		selectTeamComboBoxLabel.setMinWidth(150);
		selectTeamComboBoxLabel.setMaxWidth(150);
		selectTeamComboBoxLabel.setMinHeight(16);
		selectTeamComboBoxLabel.setMaxHeight(16);

		selectTeamComboBox.setLayoutX(450);
		selectTeamComboBox.setLayoutY(366);
		selectTeamComboBox.setMinWidth(195);
		selectTeamComboBox.setMaxWidth(195);
		selectTeamComboBox.setMinHeight(25);
		selectTeamComboBox.setMaxHeight(25);
		selectTeamComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			selectTeam();
		});
		// Added for Della09 (end)

		updateButton.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		updateButton.setText("Update This Action Item");
		updateButton.setLayoutX(3);
		updateButton.setLayoutY(395);
		updateButton.setMinWidth(170);
		updateButton.setMaxWidth(170);
		updateButton.setMinHeight(30);
		updateButton.setMaxHeight(30);
		updateButton.setOnAction(e -> updateActionItem());

		clearButton.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		clearButton.setText("Clear This Form");
		clearButton.setLayoutX(173);
		clearButton.setLayoutY(395);
		clearButton.setMinWidth(126);
		clearButton.setMaxWidth(126);
		clearButton.setMinHeight(30);
		clearButton.setMaxHeight(30);
		clearButton.setOnAction(e -> clearActionItemForm());

		// Added for Della01(start)
		createButton.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		createButton.setText("Create a new Action Item");
		createButton.setLayoutX(299);
		createButton.setLayoutY(395);
		createButton.setMinWidth(180);
		createButton.setMaxWidth(180);
		createButton.setMinHeight(30);
		createButton.setMaxHeight(30);
		createButton.setOnAction(e -> createActionItem());
		// Added for Della01(end)

		// Added for Della10 (start)
		deleteButton.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		deleteButton.setText("Delete This Action Item");
		deleteButton.setLayoutX(479);
		deleteButton.setLayoutY(395);
		deleteButton.setMinWidth(168);
		deleteButton.setMaxWidth(168);
		deleteButton.setMinHeight(30);
		deleteButton.setMaxHeight(30);
		deleteButton.setOnAction(e -> deleteActionItem());
		// Added for Della10 (end)

		unsavedChangesLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 11));
		unsavedChangesLabel.setText("");
		unsavedChangesLabel.setTextFill(Color.RED);
		unsavedChangesLabel.setLayoutX(250);
		unsavedChangesLabel.setLayoutY(430);
		unsavedChangesLabel.setMinWidth(200);
		unsavedChangesLabel.setMaxWidth(200);
		unsavedChangesLabel.setMinHeight(15);
		unsavedChangesLabel.setMaxHeight(15);

		// Add the objects to the Pane
		this.getChildren().addAll(actionItemsLabel, comboBoxLabel, aiListComboBox, selectGuidanceLabel,
				inclusionFactorLabel, inclusionFactorComboBox, sortDirectionLabel, sortDirectionComboBox,
				sortFactor1Label, sortFactor1ComboBox, sortFactor2Label, sortFactor2ComboBox, selectedLabel, nameLabel,
				nameTextField, descriptionLabel, descriptionScrollPane, resolutionLabel, resolutionScrollPane,
				datesLabel, creationLabel, creationValueLabel, dueDateLabel, dueDateTextField, formatLabel,
				actionItemLabel2, statusLabel, statusComboBox, selectMemberComboBoxLabel, selectMemberComboBox,
				selectTeamComboBoxLabel, selectTeamComboBox, updateButton, clearButton, createButton, deleteButton,
				unsavedChangesLabel);
		// Added for Della01 (comboBoxLabel, aiListComboBox, selectGuidanceLabel,
		// createButton)
		// Added for Della02 (sortDirectionLabel, sortDirectionComboBox,
		// sortFactor1Label, sortFactor2Label, sortFactor2ComboBox
		// Added for Della05(selectMemberComboBoxLabel, selectMemberComboBox)
		// Added for Della09(selectTeamComboBoxLabel, selectTeamComboBox)
		// Added for Della10(inclusionFactorLabel, inclusionFactorComboBox,
		// deleteButton)

		// Done updating the GUI
		updatingGUI = false;
	}

	/**
	 * Clear the current action item and the attribute related combo boxes
	 */

	private void clearAI() {
		updatingGUI = true;
		aiM.clearCurrentActionItem();
		nameTextField.setText("");
		descriptionTextArea.setText("");
		resolutionTextArea.setText("");
		creationValueLabel.setText("");
		dueDateTextField.setText("");

		// Select the Open Status
		statusComboBox.getSelectionModel().select(ActionItemManager.statusOpen);

		// Reset the Action Item ComboBox so no item is selected Added for Della01
		aiListComboBox.getSelectionModel().select(noItemSelected);

		// No member is selected - Added for Della05
		selectMemberComboBox.getSelectionModel().select(noItemSelected);

		// No team is selected - Added for Della09
		selectTeamComboBox.getSelectionModel().select(noItemSelected);

		updatingGUI = false;
	}

	/**
	 * Process a "Clear This Form" button click request Clear out the current action
	 * item and inform the user if this results in unsaved changes
	 */

	private void clearActionItemForm() {
		// Reset the current Action Item Fields
		clearAI();
		theController.setDirtyFlag(true);
		checkForUnsavedUpdates();
	}

	/**
	 * Create a new action item
	 * 
	 * Added for Della01
	 */
	private void createActionItem() {
		ActionItem ai = null;
		try {
			ai = aiM.createActionItem(nameTextField.getText(), descriptionTextArea.getText(),
					resolutionTextArea.getText(), statusComboBox.getSelectionModel().getSelectedItem().toString(),
					dueDateTextField.getText(),
					// Added for Della05
					selectedMember,
					// Added for Della09
					selectedTeam);
		} catch (Exception ex) {
			MessageBox.show(ex.getMessage(), "Error");
			return;
		}

		// Update the creation date for the action item
		creationValueLabel.setText(dateFormat.format(ai.getCreatedDate()));
		updatingGUI = true;
		loadComboBoxData(aiM.getActionItemNames(), aiM.getActionItemIndex(aiM.getCurrentActionItemName())); // Modified
																											// for
																											// Della02
		updatingGUI = false;

		theController.setDirtyFlag(true);
		checkForUnsavedUpdates();
	}

	/**
	 * Update the current action item in memory
	 * 
	 */
	private void updateActionItem() {
		// Tell the ActionItemManager to save the update
		try {
			aiM.updateActionItem(nameTextField.getText(), descriptionTextArea.getText(), resolutionTextArea.getText(),
					statusComboBox.getSelectionModel().getSelectedItem().toString(), dueDateTextField.getText(),
					// Added for Della01
					aiListComboBox.getSelectionModel().getSelectedIndex(),
					// Added for Della05
					selectedMember,
					// Added for Della09
					selectedTeam);
		} catch (Exception ex) {
			MessageBox.show(ex.getMessage(), "Error");
			return;
		}

		// It is possible that the Action Item name has been changed
		// so we must re-sort the Action Items and re-establish the
		// ComboBox select list. - Added for Della01
		updatingGUI = true;
		loadComboBoxData(aiM.getActionItemNames(), aiM.getActionItemIndex(aiM.getCurrentActionItemName())); // Modified
																											// for
		// Della02
		updatingGUI = false;

		// Since the update action could change the state of the current action item's
		// status to "Closed"
		// and the inclusion factor could cause the current action item to no longer be
		// visible, we must
		// check to see if the form should be cleared. - Added for Della10
		if (aiListComboBox.getSelectionModel().getSelectedIndex() == noItemSelected) {
			clearAI();
			loadScreen();
		}

		theController.setDirtyFlag(true);
		checkForUnsavedUpdates();
	}

	/**
	 * Fill the screen with the values of the current action item, if we have one,
	 * and display it.
	 */
	public void loadScreen() {
		updatingGUI = true;

		// If the changes pending flag is false, clear the message... this could have
		// been reset
		// by others and not properly updated here. Added for Della10
		if (aiM.getEditChangesPending() == false)
			unsavedChangesLabel.setText("");

		// Fetch the current action item. If there isn't one, leave now
		ActionItem ai = aiM.getCurrentActionItem();
		if (ai == null) {
			clearAI();
			updatingGUI = true;
			statusComboBox.getSelectionModel().select(ActionItemManager.statusOpen);
			creationValueLabel.setText("");
			dueDateTextField.setText("");

			// Modified for Della09
			// The member and team lists are related. If there is a current selected member,
			// the list of teams
			// shown must be limited to those to which the member belongs. Similarly, if
			// there is a current selected
			// team, only the members of that team can be shown as possible members. If no
			// member is selected, all
			// teams are shown and if no team is selected, all members are shown.
			selectedTeam = "";
			selectedMember = "";
		} else {
			// Define the text fields
			updatingGUI = true;
			nameTextField.setText(ai.getActionItemName());
			descriptionTextArea.setText(ai.getDescription());
			descriptionTextArea.positionCaret(0);
			resolutionTextArea.setText(ai.getResolution());
			resolutionTextArea.positionCaret(0);

			// Define the status comboBox value
			for (int i = 0; i < ActionItemManager.statusStrings.length; ++i)
				if (ai.getStatus().compareTo(ActionItemManager.statusStrings[i]) == 0) {
					statusComboBox.getSelectionModel().select(i);
					break;
				}

			// Define the creation and due dates
			if (ai.getCreatedDate() != null)
				creationValueLabel.setText(dateFormat.format(ai.getCreatedDate()));
			else
				creationValueLabel.setText("");
			if (ai.getDueDate() != null)
				dueDateTextField.setText(dateFormat.format(ai.getDueDate()));
			else
				dueDateTextField.setText("");

			// Set up the selection Combo Boxes - Modified for Della02 and then for Della10
			selectMemberComboBox.getSelectionModel().select(noItemSelected);
			selectTeamComboBox.getSelectionModel().select(noItemSelected);
			inclusionFactorComboBox.getSelectionModel().select(aiM.getInclusionFactor());
			sortDirectionComboBox.getSelectionModel().select(aiM.getSortDirection());
			sortFactor1ComboBox.getSelectionModel().select(aiM.getSortFactor1());
			sortFactor2ComboBox.getSelectionModel().select(aiM.getSortFactor2());

			// Set up the selection ComboBox - Modified for Della02
			loadComboBoxData(aiM.getActionItemNames(), aiM.getActionItemIndex(aiM.getCurrentActionItemName()));

			selectedTeam = ai.getAssignedTeam();
			selectedMember = ai.getAssignedMember();
		}
		buildMemberList(selectedTeam, selectedMember);
		buildTeamList(selectedMember, selectedTeam);

		updatingGUI = false;
	}

	/**
	 * Based on a combo box selection, establish the screen's fields
	 * 
	 * Added for Della01
	 */
	private void selectActionItem() {
		if (updatingGUI == false) {
			updatingGUI = true;
			try {
				// The comboBox return an index. Use that to find the corresponding action item
				ActionItem selectedAI = new ActionItem();
				selectedAI = aiM.getActionItem(aiListComboBox.getSelectionModel().getSelectedIndex());

				// Establish the current action item fields
				aiM.setCurrentActionItem(selectedAI);

				if (selectedAI == null)
					clearAI();
				else {
					// Establish the screen editing fields
					nameTextField.setText(selectedAI.getActionItemName());
					descriptionTextArea.setText(selectedAI.getDescription());
					descriptionTextArea.positionCaret(0);
					resolutionTextArea.setText(selectedAI.getResolution());
					resolutionTextArea.positionCaret(0);
					if (selectedAI.getCreatedDate() != null)
						creationValueLabel.setText(dateFormat.format(selectedAI.getCreatedDate()));
					else
						creationValueLabel.setText("");
					if (selectedAI.getDueDate() != null)
						dueDateTextField.setText(dateFormat.format(selectedAI.getDueDate()));
					else
						dueDateTextField.setText("");

					// Establish the status combo box
					if (selectedAI.getStatus() == "Closed")
						statusComboBox.getSelectionModel().select(ActionItemManager.statusClosed);
					else
						statusComboBox.getSelectionModel().select(ActionItemManager.statusOpen);

					// Define the assigned member selection - Added for Della05; Modified for
					// Della09
					selectedMember = aiM.getCurrentAssignedMember();
					selectedTeam = aiM.getCurrentAssignedTeam();
					buildMemberList(selectedTeam, selectedMember);
					int memberNameIndex = selectMemberComboBox.getSelectionModel().getSelectedIndex();
					aiM.getMemberList().setCurrentSelectedElementIndex(memberNameIndex);

					// Define the assigned team selection - Modified for Della09
					buildTeamList(selectedMember, selectedTeam);
					int teamNameIndex = selectTeamComboBox.getSelectionModel().getSelectedIndex();
					aiM.getTeamList().setCurrentSelectedElementIndex(teamNameIndex);
				}
				// The selected action item has changed so the state has changed
				theController.setDirtyFlag(true);

			} catch (Exception e) {
				e.printStackTrace();
			}
			updatingGUI = false;
		}
	}

	/**
	 * Based on a combobox selection, establish the sorting direction
	 * 
	 * Added for Della02
	 */
	private void sortDirection() {
		if (updatingGUI == false) {
			aiM.setSortDirection(sortDirectionComboBox.getSelectionModel().getSelectedIndex());
			loadComboBoxData(aiM.getActionItemNames(), aiM.getActionItemIndex(aiM.getCurrentActionItemName()));

			// The sorting direction has changed so the state has changed
			theController.setDirtyFlag(true);
		}
	}

	/**
	 * Based on a combobox selection, establish the first sorting factor
	 * 
	 * Added for Della02
	 */
	private void sortingFactor1() {
		if (updatingGUI == false) {
			aiM.setSortFactor1(sortFactor1ComboBox.getSelectionModel().getSelectedIndex());
			loadComboBoxData(aiM.getActionItemNames(), aiM.getActionItemIndex(aiM.getCurrentActionItemName()));

			// The first sorting factor has changed so the state has changed
			theController.setDirtyFlag(true);
		}
	}

	/**
	 * Based on a combo box selection, establish the second sorting factor
	 * 
	 * Added for Della02
	 */
	private void sortingFactor2() {
		if (updatingGUI == false) {
			aiM.setSortFactor2(sortFactor2ComboBox.getSelectionModel().getSelectedIndex());
			loadComboBoxData(aiM.getActionItemNames(), aiM.getActionItemIndex(aiM.getCurrentActionItemName()));

			// The second sorting factor has changed so the state has changed
			theController.setDirtyFlag(true);
		}
	}

	/**
	 * The action item selection combo box is dynamic. What is displayed there comes
	 * from the current names for each of the action items and since the user can
	 * change those at will, the combo box select list must change as well.
	 * 
	 * This routine assumes that the order of the action items in the vector is
	 * precisely the correct order for display in the combo box. Sorting must be
	 * done elsewhere.
	 * 
	 * @param names String[] - This is the sorted array of names for the select list
	 * 
	 *              Added for Della01 updated for Della02
	 */
	private void loadComboBoxData(String[] names, int newIndex) {
		// Define the combo box select list
		aiListComboBox.getItems().clear();
		if ((names != null) && (names.length > 0)) {
			// If names is null or the length is zero, there are no action items
			for (int i = 0; i < names.length; i++)
				aiListComboBox.getItems().add(names[i]);

			// Set the current selected item; updated for Della02
			aiListComboBox.getSelectionModel().select(newIndex);
		}
	}

	/**
	 * Build the list of members given the current selected team and member
	 * 
	 * Added for Della09
	 */
	private void buildMemberList(String teamName, String memberName) {
		// Build the member list combo box
		int assignedMemberIndex = noItemSelected;
		selectMemberComboBox.getItems().clear();
		int memberListSize = aiM.getMemberListSize();
		if (teamName == "")
			for (int i = 0; i < memberListSize; i++) {
				String newMember = aiM.getMember(i);
				selectMemberComboBox.getItems().add(newMember);
				if (memberName.compareTo(newMember) == 0)
					assignedMemberIndex = i;
			}
		else {
			String[] possibleMembers = aiM.getAssociatedMembers(teamName);
			for (int i = 0; i < possibleMembers.length; i++) {
				selectMemberComboBox.getItems().add(possibleMembers[i]);
				if (memberName.compareTo(possibleMembers[i]) == 0)
					assignedMemberIndex = i;
			}
		}
		selectMemberComboBox.getItems().add("- no member selected -");

		// Select the current member
		aiM.getMemberList().setCurrentSelectedElementIndex(assignedMemberIndex);
		selectMemberComboBox.getSelectionModel().select(assignedMemberIndex);
	}

	/**
	 * Build the list of teams given the current selected member and team
	 * 
	 * Added for Della09
	 */
	private void buildTeamList(String memberName, String teamName) {
		// Build the team list combo box
		int assignedTeamIndex = noItemSelected;
		selectTeamComboBox.getItems().clear();
		int teamListSize = aiM.getTeamListSize();

		if (memberName == "")
			for (int i = 0; i < teamListSize; i++) {
				String newTeam = aiM.getTeam(i);
				selectTeamComboBox.getItems().add(newTeam);
				if (teamName.compareTo(newTeam) == 0)
					assignedTeamIndex = i;
			}
		else {
			String[] possibleTeams = aiM.getAffiliatedTeams(memberName);
			for (int i = 0; i < possibleTeams.length; i++) {
				selectTeamComboBox.getItems().add(possibleTeams[i]);
				if (teamName.compareTo(possibleTeams[i]) == 0)
					assignedTeamIndex = i;
			}
		}

		selectTeamComboBox.getItems().add("- no team selected -");

		// Select the current team
		aiM.getTeamList().setCurrentSelectedElementIndex(assignedTeamIndex);
		selectTeamComboBox.getSelectionModel().select(assignedTeamIndex);
	}

	/**
	 * Given a "select a member" combo box event, process it
	 * 
	 * Added for Della05 and updated for Della09
	 */
	private void selectMember() {
		if (updatingGUI == false) {
			updatingGUI = true;
			if (selectedTeam == null)
				selectedTeam = "";
			ElementList memberList = aiM.getMemberList();
			int memberListSize = selectMemberComboBox.getItems().size();
			int assignedMemberIndex = selectMemberComboBox.getSelectionModel().getSelectedIndex();
			if (assignedMemberIndex > noItemSelected && assignedMemberIndex < memberListSize - 1) {
				selectedMember = (String) selectMemberComboBox.getSelectionModel().getSelectedItem();
				memberList.setCurrentSelectedElementIndex(assignedMemberIndex);
			} else {
				memberList.setCurrentSelectedElementIndex(noItemSelected);
				selectMemberComboBox.getSelectionModel().clearSelection(noItemSelected);
				selectedMember = "";
			}
			buildTeamList(selectedMember, selectedTeam);

			theController.setDirtyFlag(true);
			updatingGUI = false;
			checkForUnsavedUpdates();
		}
	}

	/**
	 * Given a "select a team" combo box event, process it
	 * 
	 * Added for Della09
	 */
	private void selectTeam() {
		if (updatingGUI == false) {
			updatingGUI = true;
			if (selectedMember == null)
				selectedMember = "";
			ElementList teamList = aiM.getTeamList();
			int teamListSize = selectTeamComboBox.getItems().size();
			int assignedTeamIndex = selectTeamComboBox.getSelectionModel().getSelectedIndex();
			if (assignedTeamIndex > noItemSelected && assignedTeamIndex < teamListSize - 1) {
				selectedTeam = (String) selectTeamComboBox.getSelectionModel().getSelectedItem();
				teamList.setCurrentSelectedElementIndex(assignedTeamIndex);
			} else {
				teamList.setCurrentSelectedElementIndex(noItemSelected);
				selectTeamComboBox.getSelectionModel().clearSelection(noItemSelected);
				selectedTeam = "";
			}
			buildMemberList(selectedTeam, selectedMember);

			theController.setDirtyFlag(true);
			updatingGUI = false;
			checkForUnsavedUpdates();
		}
	}

	/**
	 * Given a "select an inclusion factor" event is being processed, see if it is
	 * okay to process it based on whether or not there are outstanding edits that
	 * could be lost
	 * 
	 * Added for Della10
	 */
	private boolean okayToChangeInclusion() {
		// Check to see if the event will narrow the list of possible action items
		// displayed. If the select index is greater than zero, the selection is a
		// narrowing one, so the user must specify if the operation should continue or
		// not.
		if (inclusionFactorComboBox.getSelectionModel().getSelectedIndex() > ActionItemManager.inclusionFactorAll) {
			if (aiM.getEditChangesPending()) {
				boolean discardChanges = ConfirmationBox.show(
						"You have edited this Action Items without updating it and\n"
								+ "the command you have requested may discard these changes!\n"
								+ "Do you want to risk losing these edits?\n\n"
								+ "Click \"Yes\" to proceed and possibly lose these edits.\n"
								+ "Click \"No\" to set the inclusion factor to \"All action items\".",
						"Inclusion Factor Change Requests While Action Item Edits Pending!", "Yes", "No");
				if (discardChanges) {
					aiM.setEditChangesPending(false);
					return true;
				} else
					return false;
			} else
				return true;
		} else
			return true;
	}

	/**
	 * Given a "select an inclusion factor" combo box event, this method processes
	 * the event
	 * 
	 * Added for Della10
	 */
	private void listInclusionAction() {
		if (updatingGUI == false) {
			updatingGUI = true;
			if (okayToChangeInclusion()) {
				aiM.setInclusionFactor(inclusionFactorComboBox.getSelectionModel().getSelectedIndex());
				theController.setDirtyFlag(true);
			} else {
				inclusionFactorComboBox.getSelectionModel().select(ActionItemManager.inclusionFactorAll);
				aiM.setInclusionFactor(ActionItemManager.inclusionFactorAll);
			}
			loadComboBoxData(aiM.getActionItemNames(), aiM.getActionItemIndex(aiM.getCurrentActionItemName()));
			if (aiListComboBox.getSelectionModel().getSelectedIndex() == noItemSelected) {
				clearAI();
				loadScreen();
			}
			updatingGUI = false;
		}
	}

	/**
	 * A "Delete an Action Item" button event has occurred. Process it.
	 * 
	 * Added for Della10
	 */
	private void deleteActionItem() {

		boolean reallyDelete = ConfirmationBox.show("Click \"Yes\" to delete the action item,\n\"No\" to retain it.",
				"Delete the Current Action Item?", "Yes", "No");
		if (reallyDelete) {
			aiM.deleteCurrentActionItem();
			clearAI();
			loadScreen();
		}
	}

	/**
	 * In Della, an empty item is actual the same as no item selected, so this
	 * private routine supports this fact.
	 * 
	 * Added for Della05
	 */
	private String deNull(String str) {
		if (str == null)
			return "";
		return str;
	}

	/**
	 * Any number of events has occurred that could change the display. See if the
	 * current edit values still match the current action item. If so, then no
	 * warning is needed. If not, then given a warning (red text) that informs the
	 * user that there are edits to the action item that have not been saved.
	 * 
	 */
	private void checkForUnsavedUpdates() {
		if (updatingGUI)
			return;
		if (nameTextField.getText().equals(aiM.getCurrentActionItem().getActionItemName())
				&& descriptionTextArea.getText().equals(aiM.getCurrentActionItem().getDescription())
				&& resolutionTextArea.getText().equals(aiM.getCurrentActionItem().getResolution())
				&& dueDateTextField.getText()
						.equals(aiM.getCurrentActionItem().getDueDate() != null
								? dateFormat.format(aiM.getCurrentActionItem().getDueDate())
								: "")
				&& ((statusComboBox.getSelectionModel().getSelectedIndex() == 0
						&& aiM.getCurrentActionItem().getStatus().equals(""))
						|| (statusComboBox.getSelectionModel().getSelectedIndex() == 0
								&& aiM.getCurrentActionItem().getStatus().equals("Open"))
						|| (statusComboBox.getSelectionModel().getSelectedIndex() == 1
								&& aiM.getCurrentActionItem().getStatus().equals("Closed")))
				&& // Added for Della05
				aiM.getCurrentAssignedMember()
						.equals(deNull((String) selectMemberComboBox.getSelectionModel().getSelectedItem()))
				&& aiM.getCurrentAssignedTeam()
						.equals(deNull((String) selectTeamComboBox.getSelectionModel().getSelectedItem())) // Added
		// for
		// Della09
		) {
			unsavedChangesLabel.setText("");
			aiM.setEditChangesPending(false);
		} else {
			unsavedChangesLabel.setText("There are unsaved changes!");
			aiM.setEditChangesPending(true);
		}
	}

}
