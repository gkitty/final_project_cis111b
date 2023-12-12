/**
Jesse payton
Includes both the Weapon and Damage class
*/
public class WeaponS
{

    /**
    Represents the damage dealt by a weapon i
    */
    public static class Damage 
    {
        private String damageDice;

        /**        
        @param damageDice The damage dice role
        */
        public Damage(String damageDice) 
        {
            this.damageDice = damageDice;
        }

        /**
        Retrieves the damage dice of weapon
        @return The damage dice notation
        */
        public String getDamageDice() 
        {
            return damageDice;
        }

        /**
        @param damageDice The new damage dice
        */
        public void setDamageDice(String damageDice)
         {
            this.damageDice = damageDice;
        }
    }

    /**
    Represents a weapon includes name and damage 
    */
    public static class Weapon 
    {
        private String name;
        private Damage damage;

        /**
        Constructs a Weapon object with a specified name and damage
        @param name The name of the weapon
        @param damage The damage object representing the weapon's damage
        */
        public Weapon(String name, Damage damage) 
        {
            this.name = name;
            this.damage = damage;
        }

        /**
        Retrieves the name of the weapon  
        @return The name of the weapon
        */
        public String getName() 
        {
            return name;
        }

        /**
        Sets the name of the weapon
        @param name The new name of the weapon to set
        */
        public void setName(String name) 
        {
            this.name = name;
        }

        /**
        Retrieves the damage object of the weapon
        @return The Damage object
        */
        public Damage getDamage() 
        {
            return damage;
        }

        /**
        Sets the damage for the weapon
        @param damage The new Damage object to set for the weapon
        */
        public void setDamage(Damage damage)
         {
            this.damage = damage;
        }
    }
}
