/*
Giulietta M
Race class for GSON
*/

public class AbilityBonuses
{
   private AbilityScore ability_score;
   private int bonus;
   
   public AbilityBonuses() { }
   
   /**
   Copy Constructor
   */
   public AbilityBonuses(AbilityBonuses ability_bonuses)
   {
      this.ability_score = ability_bonuses.ability_score;
      this.bonus = ability_bonuses.bonus;
   }
   
   /*
   public AbilityScore getAbilityScore()
   {
   
   }
   */
   
   /**
   getBonus Method
   Gets specified ability bonus from specified race
   @return racial bonus of specified ability
   */
   public int getBonus()
   {
      return bonus;
   }
   
   /**
   toString method
   */
   public String toString()
   {
      return (ability_score.toString() +
              "\nBonus: " + bonus);
   }
}