
public class Proficiencies 
{
    private String name;

    /**
    Constructs a Proficiencies object with a specified name 
    @param name The name of the proficiency
    */
    public Proficiencies(String name) 
    {
        this.name = name;
    }

    /**
    @return The name of the proficiency
    */
    public String getName() 
    {
        return name;
    }

    /**
    Sets the name 
    @param name The new name of the proficiency
    */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
    Brings a string  of the proficiency
    @return The name of the proficienc
    */
    @Override
    public String toString() 
    {
        return name;
    }
}
