package com.groupfive.InsideEdge.InsideEdge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.groupfive.InsideEdge.POJO.MatchPojo;

public class JsonGetNews {

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }

  public static void main(String[] args) throws IOException, JSONException {
  
	  try{
    JSONObject json1 = readJsonFromUrl("https://powerful-tor-13817.herokuapp.com/live");
 

   // String name1,name2;

      JSONArray jsonarray1=json1.getJSONArray("Matches");
      //System.out.println(jsonarray1);
      
      for (int index = 0, total = 5; index < total; index++) {
          final JSONObject jsonObject = jsonarray1.getJSONObject(index);
         
          /*name1 = jsonObject.getString("Team A");
          name2= jsonObject.getString("Team B");
          System.out.println(name1+" vs "+name2);*/
          MatchPojo mp=new MatchPojo(jsonObject.getString("Team A"),jsonObject.getString("Team B"), jsonObject.getString("Score A"), jsonObject.getString("Score B"));
          System.out.println(mp.toString());
      }
	  }
      catch(Exception e)
      {
    	  System.out.println("exception caught");
      }
          
  }
  
}