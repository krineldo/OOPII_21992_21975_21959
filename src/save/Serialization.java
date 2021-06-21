package save;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import collections.Listing;
import hua.dit.omada20.*;

public class Serialization {
	
	
	public Serialization() {}
	
	
	public void writeJSON(Listing li) throws JsonGenerationException, JsonMappingException, IOException{
	      ObjectMapper mapper = new ObjectMapper();	
	      
	      File trav = new File("traveller.json");
	      
	      //ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
	      //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(trav, true)));// appens the existng  file
	     /* 
	      ListIterator<Traveller> listItr = travellers_clc.listIterator();
			 
			while(listItr.hasNext())
			{
				mapper.writeValue(trav, listItr.next());
			}
	      */
	      //sli.toJSON(travellers_clc);
	     mapper.enableDefaultTyping();
	      
	      //String nothing = mapper.writeValueAsString(li);
	      //System.out.println(nothing);
	      mapper.writeValue(trav, li);
	     
	      
	      
	      
	   }
	/*
	public void createTravellers() throws InterruptedException, JsonGenerationException, JsonMappingException, IOException {
		ArrayList<Traveller> arraylist_abs_travellers = new ArrayList<Traveller>();
		for (int i=20; i<30; i++) {	
			 YoungTraveller student = new YoungTraveller();
			 Traveller.setAge(i-5);
			 Traveller.setName("young_name_"+(i-20));
			 Date date = new Date();
			 student.setTimestamp(date.getTime());	         
			 arraylist_abs_travellers.add(student);
			 Thread.sleep(i);
			 
			 MiddleTraveller student2 = new MiddleTraveller();
			 student2.setAge(i+20);
			 student2.setName("middle_name_"+(i-20));
			 Date date2 = new Date();
			 student2.setTimestamp(date2.getTime());	         
			 arraylist_abs_travellers.add(student2);
			 Thread.sleep(i);
			 
			 ElderTraveller student3 = new ElderTraveller();
			 student3.setAge(i+40);
			 student3.setName("elder_name_"+(i-20));
			 Date date3 = new Date();
			 student.setTimestamp(date3.getTime());	         
			 arraylist_abs_travellers.add(student3);
			 Thread.sleep(i);
		} 
		this.writeJSON(arraylist_abs_travellers);	   
   }	
	*/
	public ArrayList<Traveller> readJSON() throws JsonParseException, JsonMappingException, IOException{
	      ObjectMapper mapper = new ObjectMapper();
	      //ArrayList<Traveller> travellers_aj = new ArrayList<Traveller>();
	      
	      File trav = new File("traveller.json");
	     /* 
	      for(int i=0;i<5;i++) {
	    
	    	  Traveller traveller = mapper.readValue(trav, Traveller.class);
	    	  travellers_aj.add(traveller);
	      }
	      */
	      mapper.enableDefaultTyping();
	      Listing list =  mapper.readValue(trav ,Listing.class);
	      return list.getTravellers_clc();
	   }
	
}
