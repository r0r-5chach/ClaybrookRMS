package com.mawkish.claybrookrms;

import com.mawkish.claybrookrms.animalTypes.*;
import com.mawkish.claybrookrms.tools.DBHandler;
import com.mongodb.client.FindIterable;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    private List<Amphibian> currentAmphibianSelection = new ArrayList<Amphibian>();
    private List<Bird> currentBirdSelection = new ArrayList<Bird>();
    private List<Fish> currentFishSelection = new ArrayList<Fish>();
    private List<Mammal> currentMammalSelection = new ArrayList<Mammal>();
    private List<Reptile> currentReptileSelection = new ArrayList<Reptile>();


    @FXML
    private ContextMenu filterMenu;

    @FXML
    private VBox profile;

    @FXML
    private Label filterButton;

    @FXML
    private ChoiceBox phylumSelector;

    @FXML
    private  ContextMenu phylumMenu;

    @FXML
    private MenuItem amphibians;

    @FXML
    private MenuItem birds;

    @FXML
    private MenuItem fish;

    @FXML
    private MenuItem mammals;

    @FXML
    private MenuItem reptiles;

    @FXML
    private ListView list;

    @FXML
    private TextField nameField;

    @FXML
    private TextField locationField;

    @FXML
    private TextField speciesField;

    @FXML
    private TextField sponsorField;

    @FXML
    private TextField dateReceivedField;

    @FXML
    private TextField genderField;

    @FXML
    private ImageView imageField;

    @FXML
    private TextField dobField;

    @FXML
    private TextField lifespanField;

    @FXML
    private TextField classificationField;

    @FXML
    private TextField habitatField;

    @FXML
    private TextField weightField;

    @FXML
    private TextField lengthField;

    @FXML
    private TextField diet1;

    @FXML
    private TextField diet2;

    @FXML
    private TextField diet3;

    @FXML
    private TextField diet4;

    @FXML
    private TextField diet5;

    @FXML
    private TextField diet6;

    @FXML
    private TextField diet7;

    @FXML
    private TextField diet8;

    @FXML
    private TextField diet9;

    @FXML
    private TextField diet10;

    @FXML
    private TextField diet11;

    @FXML
    private TextField diet12;

    @FXML
    private TextField diet13;

    @FXML
    private TextField diet14;


    @FXML
    protected void onFilterPress() {
        filterMenu.show(filterButton.getScene().getWindow(), filterButton.getLayoutX() + filterButton.getWidth(), filterButton.getLayoutY() - filterButton.getHeight());
    }

    @FXML
    protected void onPhylumPress() {
        phylumMenu.show(phylumSelector.getScene().getWindow(), phylumSelector.getLayoutX() + phylumSelector.getWidth(), phylumSelector.getLayoutY() - phylumSelector.getHeight());
    }

    @FXML
    protected void onExitButtonClick() {
        Platform.exit();
    }

    @FXML
    protected void onMinButtonClick() {
        Stage stage = (Stage) filterButton.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    protected void onAmphibianSelect() {
        list.getItems().clear();
        phylumSelector.setValue(amphibians.getText());
        DBHandler database = new DBHandler();
        FindIterable<Document> docList = database.getCollection("Amphibians").find();
        for (Document animal: docList) {
            if(!animal.isEmpty()) {
                currentAmphibianSelection.add(new Amphibian(animal));
                list.getItems().add(currentAmphibianSelection.get(currentAmphibianSelection.size() - 1).getName());
            }
        }
    }

    @FXML
    protected void onBirdSelect() {
        list.getItems().clear();
        phylumSelector.setValue(birds.getText());
        DBHandler database = new DBHandler();
        FindIterable<Document> docList = database.getCollection("Birds").find();
        for (Document animal: docList) {
            if(!animal.isEmpty()) {
                currentBirdSelection.add(new Bird(animal));
                list.getItems().add(currentBirdSelection.get(currentBirdSelection.size() - 1).getName());
            }
        }
    }

    @FXML
    protected void onFishSelect() {
        list.getItems().clear();
        phylumSelector.setValue(fish.getText());
        DBHandler database = new DBHandler();
        FindIterable<Document> docList = database.getCollection("Fish").find();
        for (Document animal: docList) {
            if(!animal.isEmpty()) {
                currentFishSelection.add(new Fish(animal));
                list.getItems().add(currentFishSelection.get(currentFishSelection.size() - 1).getName());
            }
        }
    }

    @FXML
    protected void onMammalSelect() {
        list.getItems().clear();
        phylumSelector.setValue(mammals.getText());
        DBHandler database = new DBHandler();
        FindIterable<Document> docList = database.getCollection("Mammals").find();
        for (Document animal: docList) {
            if(!animal.isEmpty()) {
                currentMammalSelection.add(new Mammal(animal));
                list.getItems().add(currentMammalSelection.get(currentMammalSelection.size() - 1).getName());
            }
        }
    }

    @FXML
    protected void onReptileSelect() {
        list.getItems().clear();
        phylumSelector.setValue(reptiles.getText());
        DBHandler database = new DBHandler();
        FindIterable<Document> docList = database.getCollection("Reptiles").find();
        for (Document animal: docList) {
            if(!animal.isEmpty()) {
                currentReptileSelection.add(new Reptile(animal));
                list.getItems().add(currentReptileSelection.get(currentReptileSelection.size() - 1).getName());
            }
        }
    }

    @FXML
    protected void onListSelect() {
        switch(phylumSelector.getValue().toString()) {
            case "Reptiles":
                Reptile selectedReptile = null;
                for (Reptile animal: currentReptileSelection) {
                    if(animal.getName().equals(list.getSelectionModel().getSelectedItem().toString())) {
                        selectedReptile = animal;
                        break;
                    }
                }
                Image image = new Image(selectedReptile.getImageURL());
                imageField.setImage(image);
                nameField.setText(selectedReptile.getName());
                speciesField.setText(selectedReptile.getSpecies());
                dateReceivedField.setText(selectedReptile.getDateReceived().toString());
                genderField.setText(Character.toString(selectedReptile.getGender()));
                dobField.setText(selectedReptile.getDob().toString());
                lifespanField.setText(Double.toString(selectedReptile.getLifeSpan()));
                classificationField.setText(selectedReptile.getClassification());
                habitatField.setText(selectedReptile.getHabitat());
                weightField.setText(Double.toString(selectedReptile.getWeight()));
                lengthField.setText(Double.toString(selectedReptile.getLength()));
                TextField[] dietFields = {diet1,diet2,diet3,diet4,diet5,diet6,diet7,diet8,diet9,diet10,diet11,diet12,diet13,diet14};
                for (int i = 0; i < (selectedReptile.getDiet().size() - 1); i++) {
                    dietFields[i].setText(selectedReptile.getDiet().get(i));
                }
                profile.setVisible(true);
                break;
            case "Mammals":
                Mammal selectedMammal = null;
                for (Mammal animal: currentMammalSelection) {
                    if(animal.getName().equals(list.getSelectionModel().getSelectedItem().toString())) {
                        selectedMammal = animal;
                        break;
                    }
                }
                image = new Image(selectedMammal.getImageURL());
                imageField.setImage(image);
                nameField.setText(selectedMammal.getName());
                speciesField.setText(selectedMammal.getSpecies());
                dateReceivedField.setText(selectedMammal.getDateReceived().toString());
                genderField.setText(Character.toString(selectedMammal.getGender()));
                dobField.setText(selectedMammal.getDob().toString());
                lifespanField.setText(Double.toString(selectedMammal.getLifeSpan()));
                classificationField.setText(selectedMammal.getClassification());
                habitatField.setText(selectedMammal.getHabitat());
                weightField.setText(Double.toString(selectedMammal.getWeight()));
                lengthField.setText(Double.toString(selectedMammal.getLength()));
                dietFields = new TextField[] {diet1, diet2, diet3, diet4, diet5, diet6, diet7, diet8, diet9, diet10, diet11, diet12, diet13, diet14};
                for (int i = 0; i < (selectedMammal.getDiet().size() - 1); i++) {
                    dietFields[i].setText(selectedMammal.getDiet().get(i));
                }
                profile.setVisible(true);
                break;
            case "Fish":
                Fish selectedFish = null;
                for (Fish animal: currentFishSelection) {
                    if(animal.getName().equals(list.getSelectionModel().getSelectedItem().toString())) {
                        selectedFish = animal;
                        break;
                    }
                }
                image = new Image(selectedFish.getImageURL());
                imageField.setImage(image);
                nameField.setText(selectedFish.getName());
                speciesField.setText(selectedFish.getSpecies());
                dateReceivedField.setText(selectedFish.getDateReceived().toString());
                genderField.setText(Character.toString(selectedFish.getGender()));
                dobField.setText(selectedFish.getDob().toString());
                lifespanField.setText(Double.toString(selectedFish.getLifeSpan()));
                classificationField.setText(selectedFish.getClassification());
                habitatField.setText(selectedFish.getHabitat());
                weightField.setText(Double.toString(selectedFish.getWeight()));
                lengthField.setText(Double.toString(selectedFish.getLength()));
                dietFields = new TextField[] {diet1, diet2, diet3, diet4, diet5, diet6, diet7, diet8, diet9, diet10, diet11, diet12, diet13, diet14};
                for (int i = 0; i < (selectedFish.getDiet().size() - 1); i++) {
                    dietFields[i].setText(selectedFish.getDiet().get(i));
                }
                profile.setVisible(true);
                break;
            case "Birds":
                Bird selectedBird = null;
                for (Bird animal: currentBirdSelection) {
                    if(animal.getName().equals(list.getSelectionModel().getSelectedItem().toString())) {
                        selectedBird = animal;
                        break;
                    }
                }
                image = new Image(selectedBird.getImageURL());
                imageField.setImage(image);
                nameField.setText(selectedBird.getName());
                speciesField.setText(selectedBird.getSpecies());
                dateReceivedField.setText(selectedBird.getDateReceived().toString());
                genderField.setText(Character.toString(selectedBird.getGender()));
                dobField.setText(selectedBird.getDob().toString());
                lifespanField.setText(Double.toString(selectedBird.getLifeSpan()));
                classificationField.setText(selectedBird.getClassification());
                habitatField.setText(selectedBird.getHabitat());
                weightField.setText(Double.toString(selectedBird.getWeight()));
                lengthField.setText(Double.toString(selectedBird.getLength()));
                dietFields = new TextField[] {diet1, diet2, diet3, diet4, diet5, diet6, diet7, diet8, diet9, diet10, diet11, diet12, diet13, diet14};
                for (int i = 0; i < (selectedBird.getDiet().size() - 1); i++) {
                    dietFields[i].setText(selectedBird.getDiet().get(i));
                }
                profile.setVisible(true);
                break;
            case "Amphibians":
                Amphibian selectedAmphibian = null;
                for (Amphibian animal: currentAmphibianSelection) {
                    if(animal.getName().equals(list.getSelectionModel().getSelectedItem().toString())) {
                        selectedAmphibian = animal;
                        break;
                    }
                }
                image = new Image(selectedAmphibian.getImageURL());
                imageField.setImage(image);
                nameField.setText(selectedAmphibian.getName());
                speciesField.setText(selectedAmphibian.getSpecies());
                dateReceivedField.setText(selectedAmphibian.getDateReceived().toString());
                genderField.setText(Character.toString(selectedAmphibian.getGender()));
                dobField.setText(selectedAmphibian.getDob().toString());
                lifespanField.setText(Double.toString(selectedAmphibian.getLifeSpan()));
                classificationField.setText(selectedAmphibian.getClassification());
                habitatField.setText(selectedAmphibian.getHabitat());
                weightField.setText(Double.toString(selectedAmphibian.getWeight()));
                lengthField.setText(Double.toString(selectedAmphibian.getLength()));
                dietFields = new TextField[] {diet1, diet2, diet3, diet4, diet5, diet6, diet7, diet8, diet9, diet10, diet11, diet12, diet13, diet14};
                for (int i = 0; i < (selectedAmphibian.getDiet().size() - 1); i++) {
                    dietFields[i].setText(selectedAmphibian.getDiet().get(i));
                }
                profile.setVisible(true);
                break;
            default:
                list.getItems().clear();

        }

    }
}