import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Node; 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;

import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

   /**
   Class to control CreateNewCharacterSheet Scene
   */

public class CreateNewCharacterController implements Initializable {

   @FXML
   private Label armorClass; //declaring armor class label

   @FXML
   private Button backButton; //declaring backButton to go to the Opening screen

   @FXML
   private ComboBox<String> classDropDown; //declaring the combo box for the DND class selection

   @FXML
   private Label initiativeBonus; //declaring the initative bonus label

   @FXML
   private Label maxHP; //declaring the maxHP label

   @FXML
   private TextField nameInput; //declaring the name input textfield

   @FXML
   private ComboBox<String> raceDropDown; //declaring the combo box for the DND race selection

   @FXML
   private TextField rawCHAScoreInput; //declaring the charisma score text field

   @FXML
   private TextField rawCONScoreInput; //declaring the constitution score text field

   @FXML
   private TextField rawDEXScoreInput; //declaring the dexterity score text field

   @FXML
   private TextField rawINTScoreInput; //declaring the intelligence score text field

   @FXML
   private TextField rawSTRScoreInput; //declaring the strength score text field

   @FXML
   private TextField rawWISScoreInput; //declaring the wisdom score text field

   @FXML
   private Button saveButton; //declaring the save button for the character's data

   @FXML
   private ComboBox<String> weaponsDropDown; //declaring the combo box for weapon selection
   
   @FXML
   private Button abScoreButton; //declaring the ability score button to randomly generate scores for the user
   
   @FXML
   private TextField classLevelInput; //declaring level of class for character
   
   private HttpClient client; //used to retrieve data from the API
   
   //top levels for GSON
   public Race selectedRace;
   public DNDClass selectedClassGSON; 
   //public Weapons selectedWeapon;
   
   //storage for when user saves and creates a new CharacterSheet
   public CharacterSheet characterSheet;

   /** 
   saveCharacter method
   stores the information inputted by the user
   @param event clicking the "Save" button */
   @FXML
   void saveCharacter(ActionEvent event) {
      //create CharacterSheet object
      CharacterSheet characterSheet = CharacterSheet.getInstance();
      
      //set CharacterSheet object to all fields user entered
      characterSheet.setName(nameInput.getText());
      characterSheet.setRace(raceDropDown.getValue());
      characterSheet.setDNDClass(classDropDown.getValue());
      //characterSheet.classLevel();
      characterSheet.setWeapon(weaponsDropDown.getValue());
      
      //set ability scores
      characterSheet.setStrength(Integer.parseInt(rawSTRScoreInput.getText()) + 0); //replace 0 with race bonus
      characterSheet.setDexterity(Integer.parseInt(rawDEXScoreInput.getText()) + 0);
      characterSheet.setConstitution(Integer.parseInt(rawCONScoreInput.getText()) + 0);
      characterSheet.setIntelligence(Integer.parseInt(rawINTScoreInput.getText()) + 0);
      characterSheet.setWisdom(Integer.parseInt(rawWISScoreInput.getText()) + 0);
      characterSheet.setCharisma(Integer.parseInt(rawCHAScoreInput.getText()) + 0);
      
   }

   /**
   goToHomeScreen method
   enables the user to switch to the welcome  screen
   @param event clicking the back button
   */   
   @FXML
   void goToHomeScreen(ActionEvent event) throws IOException {
   
      Parent root = FXMLLoader.load(getClass().getResource("OpeningScene.fxml"));
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      Scene charListScene = new Scene(root);
      stage.setScene(charListScene);
      stage.show();   
   }
   
   /**
   goToDiceRoller method
   enables the user to switch to the dice rolling/character viewing screen
   @param event clicking the "Roll!" button
   */     
   @FXML
   void goToRoller(ActionEvent event) throws IOException {
      
      Parent root = FXMLLoader.load(getClass().getResource("dicerollScreen.fxml"));
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      Scene diceRollerScene = new Scene(root);
      stage.setScene(diceRollerScene);
      stage.show();
   } 
   
   /** 
   generateAbScores method
   randomly generates scores for the character's abilities and sets them as text
   @param event clicking "Generate Ability Scores" button */
   @FXML
   void generateAbScores(ActionEvent event) {
      
      //Recieve characterSheet (CharacterSheet object) from CreateNewCharacterSheetController
      CharacterSheet characterSheet  = CharacterSheet.getInstance();
      
      //generating strength and saving it to the character sheet object
      rawSTRScoreInput.setText(Integer.toString(rollAbilityScore()));
      characterSheet.setStrength(Integer.parseInt(rawSTRScoreInput.getText()));
      
      //generating and saving dexterity
      rawDEXScoreInput.setText(Integer.toString(rollAbilityScore()));
      characterSheet.setDexterity(Integer.parseInt(rawDEXScoreInput.getText()));
     
      //generating and saving constitution
      rawCONScoreInput.setText(Integer.toString(rollAbilityScore()));
      characterSheet.setConstitution(Integer.parseInt(rawCONScoreInput.getText()));
   
      //generating and saving intelligence         
      rawINTScoreInput.setText(Integer.toString(rollAbilityScore()));
      characterSheet.setIntelligence(Integer.parseInt(rawINTScoreInput.getText()));
      
      //generating and saving wisdom   
      rawWISScoreInput.setText(Integer.toString(rollAbilityScore()));
      characterSheet.setWisdom(Integer.parseInt(rawWISScoreInput.getText()));
      
      //generating and saving charisma
      rawCHAScoreInput.setText(Integer.toString(rollAbilityScore()));
      characterSheet.setCharisma(Integer.parseInt(rawCHAScoreInput.getText()));
         
      //calling the calculateArmorClass method    
      calculateArmorClass();
      
      //calling the calculateInitiativeBonus method
      calculateInitiativeBonus();
      
      //calling updateMaxHP
      updateMaxHP();
   }
   
   @FXML
   void handleClassLevelInput(ActionEvent event)
   {
      
   }
   
   @FXML
   void handleRaceInput(ActionEvent event)
   {
      
   }
   
   /**
   handleDNDClassInput
   Handles when the DNDClass combobox is changed
   @param event ActionEvent on DNDClassInput combo box
   */
   @FXML
   void handleDNDClassInput(ActionEvent event)
   {
      if((rawCONScoreInput.getText() != null) && (classDropDown.getValue() != null))
         getAPIData();
   }
   
   /**
   updateMaxHP
   Updates the UI to display the character's max HP based on their class and consitution score
   */
   public void updateMaxHP()
   {
      boolean maxHPDependenciesFilled = (this.selectedClassGSON != null) && (Integer.valueOf(rawCONScoreInput.getText()) != null);
      if(maxHPDependenciesFilled) {
         int classHitDie = this.selectedClassGSON.hit_die;
         int calculatedMaxHP = classHitDie
                            + Integer.valueOf(rawCONScoreInput.getText())
                            + (classHitDie * Integer.valueOf(classLevelInput.getText())); 
                              
         maxHP.setText(Integer.toString(calculatedMaxHP));
      }
   }
   
   /**
   rollAbilityScore
   Rolls 4 6 sided die, and sums the 3 greatest rolls. This is a common practice when setting ability scores
   @return sum of greatest 3 rolls
   */
   public int rollAbilityScore()
   {
      Random die1 = new Random();
      Random die2 = new Random();
      Random die3 = new Random();
      Random die4 = new Random();
      
      int[] dieRolls = {die1.nextInt(6) + 1,
                        die2.nextInt(6) + 1,
                        die3.nextInt(6) + 1,
                        die4.nextInt(6) + 1};
                        
      Arrays.sort(dieRolls);  //least to greatest
      
      int sum = dieRolls[3] + dieRolls[2] + dieRolls[1]; //takes 3 greatest rolls
      
      return sum;
      
   }
   
   /**
   calculateArmorClass
   Armor class is the character's dex modifier + 10, this assumes character is not wearing armor
   This also updates the armorClass label to show to the user
   */
   public void calculateArmorClass() {
      //DEX mod + 10
      int dexScore = Integer.parseInt(rawDEXScoreInput.getText());
      int dexMod = CharacterSheet.scoreToModifier(dexScore);
      String armorClassStr = Integer.toString(dexMod + 10); 
      armorClass.setText(armorClassStr);
   }
   
   /**
   calculateInitiativeBonus
   Initiative bonus is the character's dex modifier only
   Also updates initiativeBonus field
   */
   public void calculateInitiativeBonus()
   {
      //DEX mod only
      int dexScore = Integer.parseInt(rawDEXScoreInput.getText());
      int dexMod = CharacterSheet.scoreToModifier(dexScore);
      String initiativeBonusStr = Integer.toString(dexMod);
      String initiativeBonusSigned;
      if(dexMod > 0)
         initiativeBonusSigned = "+" + initiativeBonusStr;
      else
         initiativeBonusSigned = initiativeBonusStr;
      
      initiativeBonus.setText(initiativeBonusSigned);
      
   }
   
   /**
   getAPIData
   Gets API data for DNDClass
   */      
   public void getAPIData()
   {
      //URI dndAPI = new URI("https://www.dnd5eapi.co/api/classes/bard");
      
      //create HttpClient
      if(this.client == null)
         this.client = HttpClient.newHttpClient(); //only create once
      
      try {
      //create httprequest with URI
         
         HttpRequest request = HttpRequest.newBuilder()
                                       .uri(new URI("https://www.dnd5eapi.co/api/classes/"
                                                    + classDropDown.getValue().toLowerCase()))
                                       .GET()
                                       .build();
                                       
         client.sendAsync(request, BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(this::processAPIData);
            
      } catch(URISyntaxException e) {
         System.out.println("API Error");
         return;
      }
      
      System.out.println("Getting data from API...");
   }
   
   /**
   processAPIData
   Processes returned JSON into GSON
   @param data String of JSON data
   */
   public void processAPIData(String data)
   {
      System.out.println(data);
      
      //create gson
      Gson gson = new Gson();
      
      try {
         this.selectedClassGSON = gson.fromJson(data, DNDClass.class);
      } catch (Exception e) {
         System.out.println("GSON Parsing failed");
         return;
      }
      
      //DNDClass selectedClassGSON = gson.fromJson(data, DNDClass.class);
      
      System.out.println(selectedClassGSON.toString());
      
      Platform.runLater(
         new Runnable() {
            public void run() {
               updateMaxHP();
            }
         });
   
   }
   
    /**
    Initialize
    initializes the combo box items
    @param location
    @param resources
    */
   @Override
   public void initialize(URL location, ResourceBundle resources) {
    //use to set the character's race/class/weapon selection
    
     //adding races to combo box
      String[] races = {"Dragonborn", "Dwarf", "Elf", "Gnome", "Half-Elf", "Halfling", "Half-Orc", "Human", "Tiefling"};
      raceDropDown.setItems(FXCollections.observableArrayList(races));
     
     //adding classes to combo box
      String[] dndClasses = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"};
      classDropDown.setItems(FXCollections.observableArrayList(dndClasses));
     
     //adding weapons to combo box
      String[] weapons = {"Shortsword", "Longsword", "Shortbow", "Crossbow", "Dagger", "Club", "Waraxe", "Mace"};
      weaponsDropDown.setItems(FXCollections.observableArrayList(weapons));
   }
   
   /*
   //Method for when race is edited, it shows the new racial bonus under the ability
   //@FXML
   void displayRaceBonus(ActionEvent event) {
      String raceSelectedInput = raceDropDown.getValue();
      String raceSelected = raceSelectedInput.substring(0,2).toUpperCase();
      
      getAPIData();
               
      //get ability name(s) that has bonus
      ArrayList<AbilityBonuses> abilityBonusesList = this.selectedRace.ability_bonuses;
      
      ArrayList<String> abilitiesWithBonus = new ArrayList<>();
      
      for(AbilityBonuses i : abilityBonusesList)
      {
         abilitiesWithBonus.addItem(i.ability_score.name);
      }
      
      
      //highlight box with bonus
      for (String ability : abilitiesWithBonus)
      {
         switch(ability)
         {
            case "STR" -> rawSTRScoreInput.setStyle("-fx-border-color: red;");
            case "DEX" -> rawDEXScoreInput.setStyle("-fx-border-color: red;");
            case "CON" -> rawCONScoreInput.setStyle("-fx-border-color: red;");
            case "INT" -> rawINTScoreInput.setStyle("-fx-border-color: red;");
            case "WIS" -> rawWISScoreInput.setStyle("-fx-border-color: red;");
            case "CHA" -> rawCHAScoreInput.setStyle("-fx-border-color: red;");
            default -> System.out.println("No bonuses"); //when error occurs
         }
      
      }
      
   }*/


}
