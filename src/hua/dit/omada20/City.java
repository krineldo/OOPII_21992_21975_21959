package hua.dit.omada20;
import java.io.IOException;
import java.net.URL;
import java.util.Vector;
import com.fasterxml.jackson.databind.ObjectMapper;

import ExceptionHandling.WikipediaNoArcticleException;
import weather.OpenWeatherMap;
import wikipedia.MediaWiki;


public class City {
	
	 private Vector<Integer> terms_vector = new Vector<Integer>();
	 
	 private Vector<Double> geodesic_vector = new Vector<Double>();
	 
	 private String name;
	 
	 public City() {
		 
	 }
	 
	 public City(String city, String country, String appid) throws IOException, WikipediaNoArcticleException
	 {
		 RetrieveData(city, country,  appid);
	 }
	 
	 public Vector<Integer> getTerms()
	 {
		 return terms_vector;
	 }
	 public Vector<Double> getGeodesic()
	 {
		 return geodesic_vector;
	 }
	 public String getName()
	 {
		 return name;
	 }
	 public void setTerms(Vector<Integer> new_terms_vector) 
     {
         this.terms_vector = new_terms_vector;
     }
     
     public void setGeodesic(Vector<Double> new_geodesic_vector)
     {
         this.geodesic_vector = new_geodesic_vector;
     }
     
     public void setName(String new_name) 
     {
         this.name = new_name;
     }
     
     public  int countCriterionfCity(String cityArticle, String criterion) {
 		cityArticle=cityArticle.toLowerCase();
 		int index = cityArticle.indexOf(criterion);
 		int count = 0;
 		while (index != -1) {
 		    count++;
 		    cityArticle = cityArticle.substring(index + 1);
 		    index = cityArticle.indexOf(criterion);
 		}
 		return count;
 	}
     
     String article;
     String[] criterions = {"cafe","sea", "museum","restaurant","stadium","square"};
     
	 
     public   void RetrieveData(String city, String country, String appid) throws  IOException, WikipediaNoArcticleException{
    	 ObjectMapper mapper = new ObjectMapper(); 
    	 
       	 
       	while (true) {		
    		OpenWeatherMap weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+""), OpenWeatherMap.class);
			 
			 double lat = weather_obj.getCoord().getLat();
			 
			 geodesic_vector.add(lat);
			 
			 geodesic_vector.add(weather_obj.getCoord().getLon());
			 setGeodesic(geodesic_vector);
			
			MediaWiki mediaWiki_obj =  mapper.readValue(new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles="+city+"&format=json&formatversion=2"),MediaWiki.class);
			article = mediaWiki_obj.getQuery().getPages().get(0).getExtract();	
			break;
			
    		
    	}
    	 
       	 
    	
    	for(int i=0;i<criterions.length;i++) {
    		terms_vector.add(countCriterionfCity(article, criterions[i]));
    	}
    	setTerms(terms_vector);
    	
    	setName(city);
    }
	 
	 
	 
}

