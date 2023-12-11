/*
Giulietta M
Race class for GSON
*/

import java.util.ArrayList;

public class Race
{
   private String name;
   
   private int speed;
   
   private ArrayList<AbilityBonuses> ability_bonuses;  
   
   public Race() { }
   
   /**
   getName method
   Gets name of race
   @return name of race
   */
   public String getName()
   {
      return name;
   }
   
   /**
   getSpeed method
   Gets walking speed of race in feet per 6 seconds
   @return walking speed of race
   */
   public int getSpeed()
   {
      return speed;
   }
   
   /*
   public AbilityBonuses getAbilityBonuses()
   {
      return new AbilityBonuses(ability_bonuses);
   }
   */
   
   /**
   toString method
   @return string of important race information for specified race
   */
   public String toString()
   {
      return ("Race Name: " + name +
              "\nWalking Speed: " + speed +
              "\nAbility Bonuses: " + ability_bonuses.toString());
   }
}