/*
Giulietta M
FP2 JSON to GSON
Driver
*/

import java.util.Scanner;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FP2Driver
{
   public static void main(String[] args) throws Exception
   {
   
      getAPIData(); 
         
      
   }
   
   public static void getAPIData()
   {
      /*
      Scanner stdin = new Scanner(System.in);
      System.out.println("Enter race: ");
      String raceInput = stdin.nextLine();
      
      String extendedURL = "/" + raceInput;
      System.out.println(extendedURL);
      
      URI dndAPI = new URI("https://www.dnd5eapi.co/api/races");  //replace human with other DND races to get their stats
      dndAPI.resolve(extendedURL);
      */
      
      URI dndAPI = new URI("https://www.dnd5eapi.co/api/races/human");
      
      System.out.println("Getting data from API...");
      
      //create HttpClient
      HttpClient client = HttpClient.newHttpClient(); //only create once
      
      
      try {
      //create httprequest with URI
         HttpRequest request = HttpRequest.newBuilder()
                                       .uri(dndAPI + System.getenv)
                                       .GET()
                                       .build();
                                       
         client.sendAsync(request, BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(System.out::println);
            
      } catch(URISyntaxException e) {
         System.out.println("API Error");
      }
   
      HttpRequest request = HttpRequest.newBuilder()
                                       .uri(dndAPI)
                                       .GET()
                                       .build();
                                       
      client.sendAsync(request, BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(System.out::println);
   
   
   }
   
   public void processAPIData(String data)
   {
      System.out.println(data);
      
      //create gson
      Gson gson = new Gson();
      
      /*
      try {
         Race selectedRace = gson.fromJson(data, Race.class);
      } catch (exception e) {
         System.out.println("GSON Parsing failed");
      }*/
      
      Race selectedRace = gson.fromJson(data, Race.class);
      
      System.out.println(selectedRace.toString());
   
   }
}