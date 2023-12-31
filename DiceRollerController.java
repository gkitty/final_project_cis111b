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

import java.util.Random;

/** This is a controller for the dice rolling scene of our DND Buddy */

public class DiceRollerController implements Initializable {

   @FXML
   private ComboBox<String> abilityRollsList; //declaring the abilityRollsList
        
   @FXML
   private Label bonusValue; //declaring the bonusvalue added to the roll

   @FXML
   private Label rawRoll; //declaring the rawRoll total without bonuses

   @FXML
   private Label rollTotal; //declaring the rollTotal that will be shown to the user
   
   @FXML
   private Button editCharButton; //declaring the button to edit the user's character
   
   @FXML
   private Label characterName; //declaring the name label
   
   @FXML 
   private Label raceLabel; //declaring the race label
   
   @FXML
   private Label dndClass; //declaring the class label
   
   @FXML
   private Label classLevel; //declaring the level label
     
   @FXML
   private Label armorClass; //declaring the armor class label
   
   @FXML
   private Label initiativeBonus; //declaring the initiative bonus label
   
   @FXML
   private Label weaponName; //declaring the weapons label
      
   @FXML
   private TextField maxHPLabel; //maxHP
   
   @FXML
   private Label strModifierL; //displays strength modifier for character

   @FXML
   private Label dexModifierL; //displays dexterity modifier for character
   
   @FXML
   private Label conModifierL; //displays constitution modifier for character

   @FXML
   private Label wisModifierL; //displays wisdom modifier for character

   @FXML
   private Label intModifierL; //displays intelligence modifier for character

   @FXML
   private Label chaModifierL; //displays strength modifier for character


   public CharacterSheet characterSheet; //declaring the CharacterSheet the user wants to use
   
   /**
   rollDie Method
   Returns a random value 1 - number of sides
   @param numSides number of sides on the die
   @return integer result from roll
   */
   public int rollDie(int numSides)
   {
      Random die = new Random();
      int dieResult = die.nextInt(numSides) + 1;
      return dieResult;
   }
   
   /**
   displayResults Method
   Displays results for regular dice rolls with no added bonuses
   @param result Result from rolling the selected die
   */
   public void displayResults(int result)
   {
      this.rawRoll.setText(Integer.toString(result));
      this.bonusValue.setText(Integer.toString(0));
      this.rollTotal.setText(Integer.toString(result));
   }
   
   /**
   displayResults Method
   Displays results for ability and saving throws and adds bonus
   @param result Result from rolling the selected die
   @param bonus Bonus for the roll
   */
   public void displayResults(int result, int bonus)
   {
      this.rawRoll.setText(Integer.toString(result));
      this.bonusValue.setText(Integer.toString(bonus));
      this.rollTotal.setText(Integer.toString(result + bonus));
   }

   /**
   getRollBonus Method
   Evaluates whether the user has a bonus for the chosen ability
   @param ability the ability chosen by the user
   */
   public int getRollBonus(String ability)
   {
      return 0;
   }
   
   /**
   rolld4 Method
   Allows user to roll 4-sided die and displays the result of the RNG 
   @param event clicking on the d4 button
   */
   @FXML
    void rolld4(ActionEvent event) {
   
      displayResults(rollDie(4));
   
   }

   /**
   rolld6 Method
   Allows user to roll 6-sided die and displays the result of the RNG 
   @param event clicking on the d6 button
   */
   @FXML
    void rolld6(ActionEvent event) {
   
      displayResults(rollDie(6));
   
   }

   /**
   rolld8 Method
   Allows user to roll 8-sided die and displays the result of the RNG 
   @param event clicking on the d8 button
   */
   @FXML
    void rolld8(ActionEvent event) {
   
      displayResults(rollDie(8));
      
   }

   /**
   rolld10 Method
   Allows user to roll 10-sided die and displays the result of the RNG 
   @param event clicking on the d10 button
   */
   @FXML
    void rolld10(ActionEvent event) {
   
      displayResults(rollDie(10));
   
   }

   /**
   rolld12 Method
   Allows user to roll 12-sided die and displays the result of the RNG 
   @param event clicking on the d12 button
   */
   @FXML
    void rolld12(ActionEvent event) {
   
      displayResults(rollDie(12));
   
   }

   /**
   rolld20 Method
   Allows user to roll 20-sided die and displays the result of the RNG 
   @param event clicking on the d20 button
   */
   @FXML
    void rolld20(ActionEvent event) {
   
      displayResults(rollDie(20));
   
   }
   /**
   rollAbility Method
   User chooses the ability they want to roll for and bonuses are added on
   @param event clicking an ability from the list
   */
   @FXML
    void rollAbility(ActionEvent event) {
      String abilityRollSelected = abilityRollsList.getValue();
      String abilitySelected = abilityRollSelected.substring(0,3).toUpperCase();
      System.out.println(abilitySelected);
      int bonus = characterSheet.getAbilityModifier(abilitySelected);
      //bonus += getRollBonus(abilitySelected);  
      displayResults(rollDie(20), bonus);
   }
   
   /**
   switchToNewCharacter Method
   enables the user to navigate to the character editing screen
   @param event clicking the "Edit Character" button
   */
   public void switchToNewCharacter(ActionEvent event) throws IOException  {
         
      Parent root = FXMLLoader.load(getClass().getResource("newcharscreen.fxml"));
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      Scene newCharScene = new Scene(root);
      stage.setScene(newCharScene);
      stage.show();
     
   }
   
      
   /** 
   initialize Method
   initializes the lists with the ability options listed
   @param location
   @param resources */
   @Override
   public void initialize(URL location, ResourceBundle resources) {
      
      //use to get prefs, set defaults, and make first call to get data from API
      //load API using characterSheet fields to get what saving throws and weapon character has proficiency in
      
      //Recieve characterSheet (CharacterSheet object) from CreateNewCharacterSheetController
      characterSheet = CharacterSheet.getInstance();
      
      //and set character info to fields
      characterName.setText(characterSheet.getName());
      raceLabel.setText(characterSheet.getRace());
      dndClass.setText(characterSheet.getDNDClass());
      classLevel.setText(Integer.toString(characterSheet.getClassLevel()));
      armorClass.setText(Integer.toString(characterSheet.getArmorClass()));
      initiativeBonus.setText(Integer.toString(characterSheet.getInitiativeBonus()));
      weaponName.setText(characterSheet.getWeapon());
      maxHPLabel.setPromptText(Integer.toString(characterSheet.getMaxHP()));
      
      //setting modifier labels
      
      strModifierL.setText(Integer.toString(characterSheet.getAbilityModifier("STR")));
      dexModifierL.setText(Integer.toString(characterSheet.getAbilityModifier("DEX")));
      conModifierL.setText(Integer.toString(characterSheet.getAbilityModifier("CON")));
      intModifierL.setText(Integer.toString(characterSheet.getAbilityModifier("INT")));
      wisModifierL.setText(Integer.toString(characterSheet.getAbilityModifier("WIS")));
      chaModifierL.setText(Integer.toString(characterSheet.getAbilityModifier("CHA")));
      
      //add Max HP to this
      //maxHPLabel.setText(Integer.toString(characterSheetView.getMaxHP()));
      
      //Preferences class for saving info idk?
      
      //add choices to combo boxes
      String[] abilities = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
      abilityRollsList.setItems(FXCollections.observableArrayList(abilities));
   }
   


}
