package utility;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Dictionary {
	
	public ArrayList<String> lookFor(String word_id) {
        final String app_id = "90e9addf"; // Application ID from Oxford dictionary API
        final String app_key = "260e8efd3a25398a016e13bec7cd1927"; // Application Key from Oxford dictionary API
        String dictionaryURL = "https://od-api.oxforddictionaries.com/api/v2/entries/en-us/" + word_id + "?fields=definitions";
        StringBuilder result = new StringBuilder();
        try
        {
            URL url = new URL(dictionaryURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Accept","application/json");
            conn.setRequestProperty("app_id", app_id);
            conn.setRequestProperty("app_key", app_key);
            conn.setRequestProperty("fields", "definitions");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;
            while( (line = rd.readLine()) != null)
            {
                result.append(line);
            }
            rd.close();
            
            ArrayList<String> definitions = parseJson(result.toString());
//            System.out.print("The definition of the word " + word_id + " is: ");
//            System.out.println(definition + ".");
            return definitions;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    } // end of webRequest function
	
	 private ArrayList<String> parseJson(String json){
		 ArrayList<String> definitions = new ArrayList<String>();
	      try
	      {
	    	  JSONObject main = new JSONObject(json);
	          JSONArray results = main.getJSONArray("results");
	          JSONObject lexical = results.getJSONObject(0);
	          JSONArray la = lexical.getJSONArray("lexicalEntries");
	          int noEntries = la.length();
	          for(int i = 0; i < noEntries; i++) {
	        	  JSONObject entries = la.getJSONObject(i);
		          JSONArray e = entries.getJSONArray("entries");
		          JSONObject senses = e.getJSONObject(0);
		          JSONArray s = senses.getJSONArray("senses");
		          int noDefinitions = s.length();
		          
		          for(int j = 0; j < noDefinitions; j++) {
		        	  JSONObject d = s.getJSONObject(j);
			          JSONArray de = d.getJSONArray("definitions");
			          definitions.add(de.getString(0));
		          }
	          }
	          return definitions;
	      }
	      catch (Exception e)
	      {
	          e.printStackTrace();
	          return null;
	      }
	     
	 }  
}
