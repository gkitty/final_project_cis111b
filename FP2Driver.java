/*
Giulietta M
FP2 JSON to GSON
Driver
*/

import java.util.Scanner;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FP2Driver
{
   public static void main(String[] args) throws Exception
   {
      //create gson
      Gson gson = new Gson();
      System.out.println("Getting data from API...");
      URL url = new URL("https://www.dnd5eapi.co/api/races/human");  //replace human with other DND races to get their stats
      
      //raw data
      Scanner s = new Scanner(url.openStream());
      String rawData = s.nextLine();
      System.out.println(rawData);
         
         //create Race object to store API data in
      Race human = gson.fromJson(rawData, Race.class);
         
      System.out.println(human.toString());
   
   }
}