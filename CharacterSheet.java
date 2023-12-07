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
   private String name;
   private String race;
   private String dndClass;
   private int classLevel;
   
   private int[] abilityScores = new int[6];
   /*
   private int strengthScore;
   private int dexterityScore;
   private int constitutionScore;
   private int intelligenceScore;
   private int wisdomScore;
   private int charismaScore;
   */
   public CharacterSheet()
   {
   }
   
   public CharacterSheet(String name, String race, String dndClass, int classLevel)
   {
      this.name = name;
      this.race = race;
      this.dndClass = dndClass;
      this.classLevel = classLevel;
   }
   
   public CharacterSheet(CharacterSheet characterSheet)
   {
      this.name = characterSheet.name;
      this.race = characterSheet.race;
      this.dndClass = characterSheet.dndClass;
      this.classLevel = characterSheet.classLevel;
   }
   
   public void setName(String name)
   {
      this.name = name;
   }
   
   public void setRace(String race)
   {
      this.race = race;
   }
   
   public void setClass(String dndClass)
   {
      this.dndClass = dndClass;
   }
   
   public void setClassLevel(int classLevel)
   {
      this.classLevel = classLevel;
   }
   
   //Ability Score setter methods, have to make sure to include race bonus into score before setting ability score
   public void setStrength(int score)
   {
      this.abilityScores[0] = score;
   }
   
   public void setDexterity(int score)
   {
      this.abilityScores[1] = score;
   }
   
   public void setConstitution(int score)
   {
      this.abilityScores[2] = score;
   }
   
   public void setIntelligence(int score)
   {
      this.abilityScores[3] = score;
   }
   
   public void setWisdom(int score)
   {
      this.abilityScores[4] = score;
   }
   
   public void setCharisma(int score)
   {
      this.abilityScores[5] = score;
   }
   
   public String getName()
   {
      return name;
   }
   
   public String getRace()
   {
      return race;
   }
   
   public String getDNDClass()
   {
      return dndClass;
   }
   
   public int getClassLevel()
   {
      return classLevel;
   }
   
   public int getStrengthScore()
   {
      return abilityScores[0];
   }
   
   public int getDexterityScore()
   {
      return abilityScores[1];
   }
   
   public int getConstitutionScore()
   {
      return abilityScores[2];
   }
   
   public int getIntelligenceScore()
   {
      return abilityScores[3];
   }
   
   public int getWisdomScore()
   {
      return abilityScores[4];
   }
   
   public int getCharismaScore()
   {
      return abilityScores[5];
   }
   
   
   public static int scoreToModifier(int score)
   {
      //switch statement from table ability scores and modifiers
      return 0;
   }
   
   public int getAbilityModifier(String ability)
   {
      int abilityModifier;
      
      switch(ability)
      {
         case "str" -> abilityModifier = scoreToModifier(getStrengthScore());
         case "dex" -> abilityModifier = scoreToModifier(getDexterityScore());
         case "con" -> abilityModifier = scoreToModifier(getConstitutionScore());
         case "int" -> abilityModifier = scoreToModifier(getIntelligenceScore());
         case "wis" -> abilityModifier = scoreToModifier(getWisdomScore());
         case "cha" -> abilityModifier = scoreToModifier(getCharismaScore());
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
   
         
}