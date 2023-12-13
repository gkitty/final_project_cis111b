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
   private Label armorClass;

   @FXML
   private Button backButton;

   @FXML
   private ComboBox<String> classDropDown;

   @FXML
   private Label initiativeBonus;

   @FXML
   private Label maxHP;

   @FXML
   private TextField nameInput;

   @FXML
   private ComboBox<String> raceDropDown;

   @FXML
   private TextField rawCHAScoreInput;

   @FXML
   private TextField rawCONScoreInput;

   @FXML
   private TextField rawDEXScoreInput;

   @FXML
   private TextField rawINTScoreInput;

   @FXML
   private TextField rawSTRScoreInput;

   @FXML
   private TextField rawWISScoreInput;

   @FXML
   private Button saveButton;

   @FXML
   private ComboBox<String> weaponsDropDown;
   
   @FXML
   private Button rollerButton;
   
   @FXML
   private Button abScoreButton;
   
   //top level for race storage
   public Race selectedRace;

   @FXML
   void saveCharacter(ActionEvent event) {
      //create CharacterSheet object
      CharacterSheet characterSheet = new CharacterSheet();
      
      //set CharacterSheet object to all fields user entered
      characterSheet.setName(nameInput.getText());
      characterSheet.setRace(raceDropDown.getValue());
      characterSheet.setDNDClass(classDropDown.getValue());
      //characterSheet.classLevel();
      characterSheet.setWeapon(weaponsDropDown.getValue());
   }
   
   @FXML
   void goToHomeScreen(ActionEvent event) throws IOException {
   
      Parent root = FXMLLoader.load(getClass().getResource("OpeningScene.fxml"));
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      Scene charListScene = new Scene(root);
      stage.setScene(charListScene);
      stage.show();   
   }
   
   
   @FXML
   void goToRoller(ActionEvent event) throws IOException {
      
      Parent root = FXMLLoader.load(getClass().getResource("dicerollScreen.fxml"));
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      Scene diceRollerScene = new Scene(root);
      stage.setScene(diceRollerScene);
      stage.show();
   }
   
   @FXML
   void generateAbScores(ActionEvent event) {
      
      rawSTRScoreInput.setText(Integer.toString(rollAbilityScore()));
      rawDEXScoreInput.setText(Integer.toString(rollAbilityScore()));
      rawCONScoreInput.setText(Integer.toString(rollAbilityScore()));
      rawINTScoreInput.setText(Integer.toString(rollAbilityScore()));
      rawWISScoreInput.setText(Integer.toString(rollAbilityScore()));
      rawCHAScoreInput.setText(Integer.toString(rollAbilityScore()));
      
      calculateArmorClass();
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
      String armorClassStr = Integer.toString(dexMod);
      String armorClassSigned;
      if(dexMod > 0)
         armorClassSigned = "+" + armorClassStr;
      else
         armorClassSigned = armorClassStr;   
         
      armorClass.setText(armorClassSigned);
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
      
   }
   
   public void getAPIData()
   {
      URI dndAPI = new URI("https://www.dnd5eapi.co/api/races/human");
      
      System.out.println("Getting data from API...");
      
      //create HttpClient
      HttpClient client = HttpClient.newHttpClient(); //only create once
      
      try {
      //create httprequest with URI
         HttpRequest request = HttpRequest.newBuilder()
                                       .uri(dndAPI)
                                       .GET()
                                       .build();
                                       
         client.sendAsync(request, BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(this::processAPIData);
            
      } catch(URISyntaxException e) {
         System.out.println("API Error");
         return;
      }
   }
   
   
   public void processAPIData(String data)
   {
      System.out.println(data);
      
      //create gson
      Gson gson = new Gson();
      
      
      try {
         this.selectedRace = gson.fromJson(data, Race.class);
      } catch (exception e) {
         System.out.println("GSON Parsing failed");
         return;
      }
      
      Race selectedRace = gson.fromJson(data, Race.class);
      
      System.out.println(selectedRace.toString());
      
      Platform.runLater(
         new Runnable() {
            public void run() {
               updateUI();
            }
         });
   
   }*/

   
   //Method for updating ArmorClass when class and CON ability score is changed
   
   @Override
   public void initialize(URL location, ResourceBundle resources) {
    //use to set the character's race/class/weapon selection
    
     //adding races to combobox
      String[] races = {"Dragonborn", "Dwarf", "Elf", "Gnome", "Half-Elf", "Halfling", "Half-Orc", "Human", "Tiefling"};
      raceDropDown.setItems(FXCollections.observableArrayList(races));
     
     //adding classes to combo box
      String[] dndClasses = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"};
      classDropDown.setItems(FXCollections.observableArrayList(dndClasses));
     
     //adding weapons to combo box
      String[] weapons = {"Shortsword", "Longsword", "Shortbow", "Crossbow", "Dagger", "Club", "Waraxe", "Mace"};
      weaponsDropDown.setItems(FXCollections.observableArrayList(weapons));
   }

}
