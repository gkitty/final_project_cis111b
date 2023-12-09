import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.application.Platform;

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
   
   public void displayResults(int result)
   {
      this.rawRoll.setText(Integer.toString(result));
      this.bonusValue.setText(Integer.toString(0));
      this.rollTotal.setText(Integer.toString(result));
   }
   
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
         
      String abilitySelected = abilityRollsList.getValue();
      int bonus = 0;
         
         //check to see if character has bonus and if so add to bonus
      displayResults(rollDie(20), bonus);
   
   }

   @FXML
    void rollSavingThrow(ActionEvent event) {
         
      String savingThrowSelected = savingThrowRollList.getValue();
      int bonus = 0;
         
         //check to see if character has bonus and if so add to bonus
      displayResults(rollDie(20), bonus);
   }
   
   
   @Override
   public void initialize(URL location, ResourceBundle resources) {
      
      //use to get prefs, set defaults, and make first call to get data from API
      
      //add choices to combo boxes
      String[] abilities = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
      abilityRollsList.setItems(FXCollections.observableArrayList(abilities));
      savingThrowRollList.setItems(FXCollections.observableArrayList(abilities));               
   }
   

}
