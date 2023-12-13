/*
Giulietta M
DND Character Sheet Class 
CIS111B Final Project : D&D Buddy
*/


/**
A class for recording the stats of the entered DND characters
*/
public class CharacterSheet
{
   /** Character Name */
   private String name;
   /** Character Race */
   private String race;
   /** Character DND Class */
   private String dndClass;
   /** Character DND Class Level */
   private int classLevel;
   /** Character's Weapon */
   private String weapon;
   
   /** Character Ability Score Array */
   private int[] abilityScores = new int[6];

      /** No Argument Constructor */
   public CharacterSheet()
   {
   name = "Bart";
   }
   
   /** Constructor */
   public CharacterSheet(String name, String race, String dndClass, int classLevel)
   {
      this.name = name;
      this.race = race;
      this.dndClass = dndClass;
      this.classLevel = classLevel;
   }
  
   /** Copy Constructor */
   public CharacterSheet(CharacterSheet characterSheet)
   {
      this.name = characterSheet.name;
      this.race = characterSheet.race;
      this.dndClass = characterSheet.dndClass;
      this.classLevel = characterSheet.classLevel;
   }
   
   /**
   setName 
   Sets Character's name
   @param name Name of Character
   */
   public void setName(String name)
   {
      this.name = name;
   }
   
   /**
   setRace
   Sets Race of Character
   @param race Race of Character
   */
   public void setRace(String race)
   {
      this.race = race;
   }
   
   /**
   setDNDClass
   Sets dndClass of Character
   @param dndClass Class of character
   */
   public void setDNDClass(String dndClass)
   {
      this.dndClass = dndClass;
   }
   
   /**
   setClassLevel
   Sets classLevel of Character
   @param classLevel Level of class Character has
   */
   public void setClassLevel(int classLevel)
   {
      this.classLevel = classLevel;
   }
   
   /**
   setWeapon
   Sets weapon of Character
   @param weapon Weapon Character has
   */
   public void setWeapon(String weapon)
   {
      this.weapon = weapon;
   }
   
   //Ability Score setter methods, have to make sure to include race bonus into score before setting ability score//
   
   /**
   setAbilityScores
   Sets abilityScore array for Character
   @param abilityScores array of ability scores
   */
   public void setAbilityScores(int[] abilityScores)
   {
   
   }
   
   /**
   setStrength
   Sets strength score within abilityScore array
   @param score Strength score of Character
   */
   public void setStrength(int score)
   {
      this.abilityScores[0] = score;
   }
   
   /**
   setDexterity
   Sets dexterity score within abilityScore array
   @param score dexterity score of Character
   */
   public void setDexterity(int score)
   {
      this.abilityScores[1] = score;
   }
   
   /**
   setConstitution
   Sets constitution score within abilityScore array
   @param score constitution score of Character
   */
   public void setConstitution(int score)
   {
      this.abilityScores[2] = score;
   }
   
   /**
   setIntelligence
   Sets intelligence score within abilityScore array
   @param score Intelligence score of Character
   */
   public void setIntelligence(int score)
   {
      this.abilityScores[3] = score;
   }
   
   /**
   setWisdom
   Sets wisdom score within abilityScore array
   @param score wisdom score of Character
   */
   public void setWisdom(int score)
   {
      this.abilityScores[4] = score;
   }
   
   /**
   setCharisma
   Sets charisma score within abilityScore array
   @param score Charisma score of Character
   */
   public void setCharisma(int score)
   {
      this.abilityScores[5] = score;
   }
   
   /**
   getName
   @return name of Character
   */
   public String getName()
   {
      return name;
   }
   
   /**
   getRace
   @return race of Character
   */
   public String getRace()
   {
      return race;
   }
   
   /**
   getDNDClass
   @return DNDClass of Character
   */
   public String getDNDClass()
   {
      return dndClass;
   }
   
   /**
   getClassLevel
   @return classLevel of Character
   */
   public int getClassLevel()
   {
      return classLevel;
   }

   /**
   getWeapon
   @return weapon of Character
   */      
   public String getWeapon()
   {
      return weapon;
   }
   
   /**
   getAbilityScore
   @param Ability
   @return AbilityScore
   */
   public int getAbilityScore(String ability)
   {
      int abilityScore; 
      switch(ability)
      {
         case "STR" -> abilityScore = getStrengthScore();
         case "DEX" -> abilityScore = getDexterityScore();
         case "CON" -> abilityScore = getConstitutionScore();
         case "INT" -> abilityScore = getIntelligenceScore();
         case "WIS" -> abilityScore = getWisdomScore();
         case "CHA" -> abilityScore = getCharismaScore();
         default -> abilityScore = 0; //when error occurs
      }
      return abilityScore;
   }
   
   /**
   getStrengthScore
   @return Strength Score
   */
   public int getStrengthScore()
   {
      return abilityScores[0];
   }
   
   /**
   getDexterityScore
   @return Dexterity Score
   */
   public int getDexterityScore()
   {
      return abilityScores[1];
   }
   
   /**
   getConstitutionScore
   @return Consitution Score
   */
   public int getConstitutionScore()
   {
      return abilityScores[2];
   }
   
   /**
   getIntelligenceScore
   @return Intelligence Score
   */
   public int getIntelligenceScore()
   {
      return abilityScores[3];
   }
   
   /**
   getWisdomScore
   @return Wisdom Score
   */
   public int getWisdomScore()
   {
      return abilityScores[4];
   }
   
   /**
   getCharismaScore
   @return Charisma Score
   */
   public int getCharismaScore()
   {
      return abilityScores[5];
   }
   
   /**
   scoreToModifier
   Uses DND 5e table to convert ability scores to their modifiers
   @param score Ability score
   @return Ability Modifier
   */
   public static int scoreToModifier(int score)
   {
      //switch statement from table ability scores and modifiers
      return 0;
   }
   
   /**
   getAbilityModifier
   @param Ability
   @return Ability modifier
   */
   public int getAbilityModifier(String ability)
   {
      int abilityModifier;
      
      switch(ability)
      {
         case "STR" -> abilityModifier = scoreToModifier(getStrengthScore());
         case "DEX" -> abilityModifier = scoreToModifier(getDexterityScore());
         case "CON" -> abilityModifier = scoreToModifier(getConstitutionScore());
         case "INT" -> abilityModifier = scoreToModifier(getIntelligenceScore());
         case "WIS" -> abilityModifier = scoreToModifier(getWisdomScore());
         case "CHA" -> abilityModifier = scoreToModifier(getCharismaScore());
         default -> abilityModifier = 0; //when error occurs
      }
      
      return abilityModifier;
   }
   
   public int getRaceBonus(String ability)
   {
      int raceBonus = 0;
      //API call to /api/races/ *getRace()*
         //check to see what ability_score it has, if it matches with ability then add bonus
      return raceBonus;
   }
   
   public int getMaxHP()
   {
      //API call to class to get hit_die
      //Calculate maximum 
      return 0;
   }
   
   public int getArmorClass()
   {
      //Dex modifier + 10
      return 0;
   }
   
   public int getInitiativeBonus()
   {
      //Same as dex modifier
      return 0;
   }
   
   public int getDamageDie()
   {  
      //API call to weapon to get its damage die
      return 0;
   }
   
   public int getProficiencyBonus()
   {
      //API call to Proficiencies using the dndclass
      return 0;
   }
         
}