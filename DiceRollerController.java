package application;

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

public class DiceRollerController implements Initializable {

   @FXML
   private ComboBox<String> abilityRollsList;
    
   @FXML
   private ComboBox<String> savingThrowRollList;
    
   @FXML
   private Label bonusValue;

   @FXML
   private Label rawRoll;

   @FXML
   private Label rollTotal;
   
   @FXML
   private Button editCharButton;   
   
   private Scene newCharScene;
  
   
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
      this.rollTotal.setText(Integer.toString(result));
   }
   
   public int getRollBonus(String ability)
   {
      return 0;
   }

   @FXML
    void rolld4(ActionEvent event) {
   
      displayResults(rollDie(4));
   
   }

   @FXML
    void rolld6(ActionEvent event) {
   
      displayResults(rollDie(6));
   
   }

   @FXML
    void rolld8(ActionEvent event) {
   
      displayResults(rollDie(8));
      
   }

   @FXML
    void rolld10(ActionEvent event) {
   
      displayResults(rollDie(10));
   
   }

   @FXML
    void rolld12(ActionEvent event) {
   
      displayResults(rollDie(12));
   
   }

   @FXML
    void rolld20(ActionEvent event) {
   
      displayResults(rollDie(20));
   
   }
   
   @FXML
    void rollAbility(ActionEvent event) {
      String abilityRollSelected = abilityRollsList.getValue();
      String abilitySelected = abilityRollSelected.substring(0,2).toUpperCase();
      //int bonus = characterSheet.getAbilityModifier(abilitySelected);
      int bonus = 0;
      bonus += getRollBonus(abilitySelected);  
      displayResults(rollDie(20), bonus);
   }

   @FXML
    void rollSavingThrow(ActionEvent event) {
         
      String savingThrowRollSelected = savingThrowRollList.getValue();
      String savingThrowSelected = savingThrowRollSelected.substring(0,2).toUpperCase();
      //does characterSheet.getDNDClass have a proficiency in the selected saving throw? 
      //int bonus = characterSheet.getAbilityModifier(abilitySelected) + characterSheet.getProficiencyBonus();
      //else it is only the ability modifier
      int bonus = 0;
      displayResults(rollDie(20), bonus);
   }
   
   public void switchToNewCharacter(ActionEvent event) throws IOException  {
         
     Parent root = FXMLLoader.load(getClass().getResource("newcharscreen.fxml"));
     Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
     newCharScene = new Scene(root);
     stage.setScene(newCharScene);
     stage.show();
     
   }
      
   
   @Override
   public void initialize(URL location, ResourceBundle resources) {
      
      //use to get prefs, set defaults, and make first call to get data from API
      //load API using characterSheet fields to get what saving throws and weapon character has proficiency in
      
      //add choices to combo boxes
      String[] abilities = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
      abilityRollsList.setItems(FXCollections.observableArrayList(abilities));
      savingThrowRollList.setItems(FXCollections.observableArrayList(abilities));               
   }
   


}
