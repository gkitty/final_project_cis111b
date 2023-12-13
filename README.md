# CIS111B Final Project : D&D Buddy
Assist new D&D players with dice rolling when playing D&D!
Accesses the DND 5e API found here: https://www.dnd5eapi.co/docs/#overview 

# Features
- Create a DND Character and roll dice straight from it!
- Automatically calculate multiple fields of your character sheet for you!
- Accesses the DND 5e API to get the most up to date information

# Important Files
- DNDBuddyMain.java - Main file for application to be ran from
- DiceRollerController.java - Controller for the dice rolling screen along with displaying your character sheet
- CreateNewCharacterController.java - Controller for the create new character screen
- OpeningSceneController.java - Controller for opening scene where you can select to view your character or edit character
- CharacterSheet.java - Class file to store character sheet data so it can be passed along between scenes

- dicerollScreen.fxml - FXML file for DiceRollerController scene
- newcharscreen.fxml - FXML file for create new character scene
- OpeningScene.fxml - FXML file for Opening Scene

- (Race.java)[https://www.dnd5eapi.co/docs/#get-/api/races/-index-] - Top level hierarchy to accept GSON depending on character's race
- (DNDClass.java)[https://www.dnd5eapi.co/docs/#get-/api/classes/-index-] - Top level hierarchy for DNDClass GSON data
- (DNDClassLevel.java)[https://www.dnd5eapi.co/docs/#get-/api/classes/-index-/levels/-class_level-] - Top level hierarchy for GSON data pertaining to selected class AND level
- (Weapons.java)[https://www.dnd5eapi.co/docs/#get-/api/equipment/-index-] - Top level hierarchy for DND Weapon GSON data

# Notes
