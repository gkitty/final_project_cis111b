/*
Giulietta M
Race class for GSON
*/

public class AbilityScore
{
   private String name;
   
   public AbilityScore() { }
   
   /**
   Copy Constructor
   */
   public AbilityScore(AbilityScore abilityscore)
   {
      this.name = abilityscore.name;
   }
   
   /**
   getName method
   Gets name of ability that has a bonus
   @return name of ability selected race has a bonus in
   */
   public String getName()
   {
      return name;
   }
   
   /**
   toString method
   */
   public String toString()
   {
      return ("\nAbility Score Name: " + name);
   }
}