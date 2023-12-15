/*
Giulietta & Margaret
DND Character Sheet Class 
CIS111B Final Project : D&D Buddy
*/


/**
A class for recording the stats of the entered DND characters
*/
public final class CharacterSheet
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
   /** Character's Max HP */
   private int maxHP;
   
   /** Character Ability Score Array */
   //private int[] abilityScores = new int[6];
   private int strScore;
   private int dexScore;
   private int conScore;
   private int intScore;
   private int wisScore;
   private int chaScore;
   
   /** Constant of same type as class and initalized, for passing data between scenes */
   private final static CharacterSheet instance = new CharacterSheet();

      /** No Argument Constructor */
   private CharacterSheet()
   {
      name = "Bart";
      race = "Dwarf";
      dndClass = "Bard";
      classLevel = 2;
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
   returnInstance
   Returns CharacterSheet instance, for passing data between scenes
   @return CharacterSheet instance
   */
   public static CharacterSheet getInstance()
   {
      return instance;
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
   setStrength
   Sets strength score 
   @param score Strength score of Character
   */
   public void setStrength(int score)
   {
      strScore = score;
   }
   
   /**
   setDexterity
   Sets dexterity score 
   @param score dexterity score of Character
   */
   public void setDexterity(int score)
   {
      dexScore = score;
   }
   
   /**
   setConstitution
   Sets constitution score 
   @param score constitution score of Character
   */
   public void setConstitution(int score)
   {
      conScore = score;
   }
   
   /**
   setIntelligence
   Sets intelligence score
   @param score Intelligence score of Character
   */
   public void setIntelligence(int score)
   {
      intScore = score;
   }
   
   /**
   setWisdom
   Sets wisdom score
   @param score wisdom score of Character
   */
   public void setWisdom(int score)
   {
      wisScore = score;
   }
   
   /**
   setCharisma
   Sets charisma score 
   @param score Charisma score of Character
   */
   public void setCharisma(int score)
   {
      chaScore = score;
   }
   
   /**
   setMaxHP
   Sets max HP for Character
   @param maxHP for character
   */
   public void setMaxHP(int maxHP)
   {
      this.maxHP = maxHP;
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
      return strScore;
   }
   
   /**
   getDexterityScore
   @return Dexterity Score
   */
   public int getDexterityScore()
   {
      return dexScore;
   }
   
   /**
   getConstitutionScore
   @return Consitution Score
   */
   public int getConstitutionScore()
   {
      return conScore;
   }
   
   /**
   getIntelligenceScore
   @return Intelligence Score
   */
   public int getIntelligenceScore()
   {
      return intScore;
   }
   
   /**
   getWisdomScore
   @return Wisdom Score
   */
   public int getWisdomScore()
   {
      return wisScore;
   }
   
   /**
   getCharismaScore
   @return Charisma Score
   */
   public int getCharismaScore()
   {
      return chaScore;
   }
   
   /**
   getMaxHP
   @return maxHP
   */
   public int getMaxHP()
   {
      return maxHP;
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
      int calculatedModifier = 0;
      switch(score)
      {
         case 1 -> calculatedModifier = -5;
         case 2,3 -> calculatedModifier = -4;
         case 4,5 -> calculatedModifier = -3;
         case 6,7 -> calculatedModifier = -2;
         case 8,9 -> calculatedModifier = -1;
         case 10,11 -> calculatedModifier = 0;
         case 12,13 -> calculatedModifier = 1;
         case 14,15 -> calculatedModifier = 2;
         case 16,17 -> calculatedModifier = 3;
         case 18,19 -> calculatedModifier = 4;
         case 20,21 -> calculatedModifier = 5;
         case 22,23 -> calculatedModifier = 6;
         case 24,25 -> calculatedModifier = 7;
         case 26,27 -> calculatedModifier = 8;
         case 28,29 -> calculatedModifier = 9;
         case 30 -> calculatedModifier = 10;
         default -> calculatedModifier = 0;
      }
   
      return calculatedModifier;
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
 
   /**
   getRaceBonus method
   @param Ability one of the six the user has
   @return raceBonus modifier
   */   
   public int getRaceBonus(String ability)
   {
      int raceBonus = 0;
      //API call to /api/races/ *getRace()*
         //check to see what ability_score it has, if it matches with ability then add bonus
      return raceBonus;
   }

   /**
   getArmorClass method calculates armor class based on dexterity
   @return ac armor class score
   */   
   public int getArmorClass()
   {
      int ac;
      ac = getAbilityModifier("DEX") + 10;
      return ac;
   }
   
   /**
   getInitiativeBonus method gets initiative from the dexterity modifier
   @return ib initiative bonus
   */   
   public int getInitiativeBonus()
   {
      int ib = getAbilityModifier("DEX");
      return ib;
   }

   /**
   getDamageDie method calls API to find weapon's damage die
   @return 
   */      
   public int getDamageDie()
   {  
      //API call to weapon to get its damage die
      return 0;
   }

   /**
   getProficiencyBonus method calls API to find proficiency based on dndClass
   @return pBonus proficiency bonus
   */      
   public int getProficiencyBonus()
   {
      //API call to Proficiencies using the dndclass
      return 0;
   }
         
}