
/**

JessePayton 
Class name for GSOn

 */

import java.util.ArrayList;

public class DNDClass 
{
   private String name;
   private int hit_die;
   private ArrayList<Proficiencies> proficiencies;

   /**
      Constructor to initialize the DNDClass with an blank list of proficieneces 
    */
   public DNDClass() 
   {
      proficiencies = new ArrayList<>();
   }

   /**
      Gets the name of the D&D class
      @return The name of the class
    */
   public String getName() 
   {
      return name;
   }

   /**
      Sets the name of the D&D class
      @param name The name to be set for this class
    */
   public void setName(String name) 
   {
      this.name = name;
   }

   /**
      Gets the hit die value of the class which is used to determine the hit points used leveling up
      @return The hit die value
    */
   public int getHitDie() 
   {
      return hit_die;
   }

   /**
      Sets the hit die value for the class
      @param hitDie The hit die value to be set
    */
   public void setHitDie(int hitDie) 
   {
      this.hit_die = hit_die;
   }

   /**
      Gets the list of proficiences for the class
      @return A list of proficincies
    */
   public ArrayList<Proficiencies> getProficiencies() 
   {
      return proficiencies;
   }

   /**
      Adds a proficiency to  class
      @param proficiency The proficiency to be added
    */
   public void addProficiency(Proficiencies proficiency) 
   {
      proficiencies.add(proficiency);
   }

   /**
     Provides a string representation of the DNDClass along with name, hit die, and proficiencie  
     @return A string representation of the DNDClass
    */
   @Override
   public String toString() 
   {
      return "DNDClass{" +
             "name='" + name + '\'' +
             ", hitDie=" + hit_die +
             ", proficiencies=" + proficiencies +
             '}';
   }
}
