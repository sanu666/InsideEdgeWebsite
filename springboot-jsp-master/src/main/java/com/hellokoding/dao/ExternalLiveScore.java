package com.hellokoding.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.hellokoding.Pojo.Matches;


public class ExternalLiveScore {
	
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
		  
		  public static ArrayList<Matches> getAllScore() throws IOException, JSONException  {
			  ArrayList<Matches> list=new ArrayList();
			  String teama,teamb,scorea,scoreb;
			int id;
			    //JSONObject json = readJsonFromUrl("https://powerful-tor-13817.herokuapp.com/live");
				  try{
			    JSONObject json1 = readJsonFromUrl("https://powerful-tor-13817.herokuapp.com/live");
			    //JSONObject json2= new JSONObject(json1.getJSONArray("Latest News"));
			    //System.out.println(json2.getJSONObject(0).);
				  
				  
			    //String a=json1.toString();
			    //Object obj=parser.parse(a);
			    
			    //System.out.println(json.getString("ID"));
			      JSONArray jsonarray1=json1.getJSONArray("Matches");
			      //System.out.println(jsonarray1);
			      
			      for (int index = 0, total = 5; index < total; index++) {
			          final JSONObject jsonObject = jsonarray1.getJSONObject(index);
			         
			          teama = jsonObject.getString("Team A");
			          teamb= jsonObject.getString("Team B");
			          scorea=jsonObject.getString("Score A");
			          scoreb=jsonObject.getString("Score B");
			          id=index;
			          
			          Matches ob=new Matches(id,scorea,scoreb,teama,teamb);
			          list.add(ob);
			          System.out.println(ob);
			          
			      }
				  }
				  catch(Exception e)
			      {
			    	  System.out.println("exception caught");
			    	  System.out.println("printing past scores");
			    	 
			    	  
			    	  String contents = new String(Files.readAllBytes(Paths.get("live.json"))); 
			    	  /*System.out.println("Contents (Java 7) : " + contents);*/

			    	  JSONObject jsonObj = new JSONObject(contents);
			    	  JSONArray jsonarray1=jsonObj.getJSONArray("Matches");
			    	  String name1,name2;
			    	  for (int index = 0, total = 5; index < total; index++) {
			              final JSONObject jsonObject = jsonarray1.getJSONObject(index);
			             
			              teama = jsonObject.getString("Team A");
				          teamb= jsonObject.getString("Team B");
				          scorea=jsonObject.getString("Score A");
				          scoreb=jsonObject.getString("Score B");
				          id=index;
				          
				          Matches ob=new Matches(id,scorea,scoreb,teama,teamb);
				          list.add(ob);
				          System.out.println(ob);
			              
			          }
		  }
return list;

}
}
