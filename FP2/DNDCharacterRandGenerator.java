/*
Jesse Payton
used to generate random chacrter values

*/


import com.google.gson.Gson;

public class DNDCharacterRandGenerator 
{

   public static void main(String[] args) 
   {
      //  JSON responses for races, classes, class levels, and weapons
      String raceData = "{\"name\":\"Elf\",\"speed\":30}";
      String classData = "{\"name\":\"Wizard\",\"hitDie\":6}";
      String classLevelData = "{\"profBonus\":2}";
      String weaponData = "{\"name\":\"Longsword\",\"damage\":{\"damageDice\":\"1d8\"}}";
   
      // Gson object for parsing JSON
      Gson gson = new Gson();
   
      // Parse JSON to Java objects
      Race race = gson.fromJson(raceData, Race.class);
      DNDClass dndClass = gson.fromJson(classData, DNDClass.class);
      DNDClassLevel classLevel = gson.fromJson(classLevelData, DNDClassLevel.class);
      WeaponS weapon = gson.fromJson(weaponData, WeaponS.class);
   
      // Use the parsed data
      System.out.println("Race:" + race.getName());
      System.out.println("Class:" + dndClass.getName());
      System.out.println("Class Level Proficiencys:" + classLevel.getProfBonus());
      System.out.println("Weapon:" + weapon.getName() + " (" + weapon.getDamage().getDamageDice() + ")");
   }

   
}
