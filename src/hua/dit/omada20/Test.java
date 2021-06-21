package hua.dit.omada20;
import java.util.*;
import java.util.Map.Entry;

import ExceptionHandling.WikipediaNoArcticleException;
import collections.*;
import db_connection.Db;
import save.Serialization;

import java.awt.EventQueue;
import java.io.IOException;
import java.lang.String; 
import gui.*;

public class Test {

	public static void main(String[] args) throws IOException, WikipediaNoArcticleException{
		String appid ="91b51e02ca05f068a575003bddb415fc";
		//v1 v2 san temp gia na perasoun orismata
		/*Vector<Integer> c1 = new Vector<Integer>();
		Vector<Double> c2 = new Vector<Double>();

		Vector<Integer> cit1 = new Vector<Integer>();
		Vector<Double> cit2 = new Vector<Double>();
		*/
		/*
		Vector<Integer> t1 = new Vector<Integer>();
		Vector<Double> t2 = new Vector<Double>();
		
		Vector<Integer> t3 = new Vector<Integer>();
		Vector<Double> t4 = new Vector<Double>();
		
		Vector<Integer> tr1 = new Vector<Integer>();
		Vector<Double> tr2 = new Vector<Double>();
		
		
		t1.add(3);
		t1.add(9);
		t1.add(2);
		t1.add(6);
		t1.add(10);
		t1.add(3);
		//t1.add(9);
		//t1.add(2);
		//t1.add(6);
		//t1.add(10);
		t2.add(55.222);
		t2.add(62.512);
		
		t3.add(3);
		t3.add(9);
		t3.add(5);
		t3.add(3);
		t3.add(10);
		t3.add(7);
		t4.add(49.555);
		t4.add(61.558);
		
		tr1.add(1);
		tr1.add(2);
		tr1.add(2);
		tr1.add(6);
		tr1.add(5);
		tr1.add(2);
		//tr1.add(1);
		//tr1.add(1);
		//tr1.add(1);
		//tr1.add(10);
		tr2.add(3.222);
		tr2.add(69.512);
		
		/*
		c1.add(6);
		c1.add(9);
		c1.add(2);
		c1.add(6);
		c1.add(6);
		c1.add(6);
		c1.add(9);
		c1.add(2);
		c1.add(6);
		c1.add(6);
		c2.add(2.567);
		c2.add(22.231);
		
		cit1.add(4);
		cit1.add(6);
		cit1.add(9);
		cit1.add(2);
		cit1.add(6);
		cit1.add(6);
		cit1.add(6);
		cit1.add(9);
		cit1.add(2);
		cit1.add(6);
		cit2.add(89.267);
		cit2.add(33.231);
		*/
		
		//Date annoula_tmstmp = new Date();
		City Rome = new City("Rome","it",appid);
		City Athens = new City("Athens","gr",appid);
		City  Corfu = new City("Corfu","gr",appid);	
		City Berlin = new City("Berlin","de",appid);
		//evala kai name sto object city gia to compare cities
		/*City Gotham = new City(c1,c2,"Gotham");
		City Atlantida = new City(cit1,cit2,"Atlantida");
		*/
		
		//as poume oti oloi exoun idies protimiseis gia eykolia
		/*
		YoungTraveller annoula = new YoungTraveller(t1,t2,"annoula",annoula_tmstmp);
		Date anthimos_tmstmp = new Date();
		YoungTraveller anthimos = new YoungTraveller(tr1,tr2,"anthimos",anthimos_tmstmp);
		Date john_tmstmp = new Date();
		MiddleTraveller john = new MiddleTraveller(t1,t2,"john",john_tmstmp);
		Date genethleios_tmstmp = new Date();
		ElderTraveller genethleios = new ElderTraveller(t1,t2,"genethleios",genethleios_tmstmp);
		*/
		TravellerUI f = new TravellerUI();
		/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					TravUI window = new TravUI();
					Traveller annoula = window.buildTrav();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		*/
		/*
		Traveller anthimos = f.buildTrav();
		Traveller john = f.buildTrav();
		Traveller genethleios = f.buildTrav();
		
		
		Traveller travellers[] = new Traveller[4];
		travellers[0] = annoula;
		travellers[1] = anthimos;
		travellers[2] = john;
		travellers[3] = genethleios;
		//to parapano einai gia to interface
		
		
		
		
		/*
		ArrayList<City> cities = new ArrayList<City>();
		
		cities.add(Rome);
		cities.add(Athens);
		cities.add(Corfu);
		cities.add(Berlin);
		
		
		
		
		
		
		System.out.printf("YOUR CITY TERMS ARE "+Rome.getTerms()
		+Rome.getGeodesic() +"%n");
		
		System.out.printf("YOUR TRAVELLER TERMS ARE "+annoula.getTerms()
		+annoula.getGeodesic() +"%n");
		
		System.out.printf("Similarity function YoungTraveller:"
				+annoula.similarity_terms_vector(Rome.getTerms(), annoula.getTerms()) +"%n");
		
		System.out.printf("Similarity function MiddleTraveller:"
				+john.similarity_terms_vector(Rome.getTerms(), john.getTerms()) +"%n");
		
		System.out.printf("Similarity function ElderTraveller:"
				+genethleios.similarity_terms_vector(Rome.getTerms(),genethleios.getTerms()) +"%n");
		
		System.out.printf("Geodesic function check:" 
				+annoula.similarity_geodesic_vector(Rome.getGeodesic(),annoula.getGeodesic())+ "%n");
		System.out.printf("Calculate similarity:" 
				+annoula.calculate_similarity(Rome)+ "%n");
		
		
		System.out.printf("Compare Cities result:"
				+annoula.compare_cities(cities).getName() +"%n");
		
		
		
		
		//Date paul_tmstmp = new Date();
	    Traveller resultTraveller = f.buildTrav(); 
		System.out.println("GetFreeTicket selected traveller:"  
				+resultTraveller.getFreeTicket(travellers, Athens).getName());
		
		System.out.println(annoula.timestamp);
		System.out.println(john.timestamp);
		
		HashMap<String, City> cities_map = new HashMap<String,City>();
		
		Mapping woh = new Mapping();
		
		woh.hashPut(cities_map, Rome);
		woh.hashPut(cities_map, Athens);
		woh.hashPut(cities_map, Corfu);
		woh.hashPut(cities_map, Berlin);
		
		woh.setCities_map(cities_map);
		
		woh.Iter(cities_map);
		
		Db inserts = new Db();
		
		inserts.insert_data(Rome);
		inserts.insert_data(Athens);
		inserts.insert_data(Corfu);
		inserts.insert_data(Berlin);
		
		inserts.return_data();
		HashMap<String, City> new_cities_map = new HashMap<String,City>();
		new_cities_map = inserts.return_data();
		Mapping new_map = new Mapping();
		
		new_map.setCities_map(inserts.return_data());
		System.out.println("lol");
		new_map.Iter(inserts.return_data());
		*/
		/*
		ArrayList<Traveller> travellers_clc = new ArrayList<Traveller>();
		
		Listing list = new Listing();
		
		list.listAdd(travellers_clc, annoula);
		list.listAdd(travellers_clc, anthimos);
		list.listAdd(travellers_clc, genethleios);
		list.listAdd(travellers_clc, john);
		
		//Date loco_date = new Date();
		//Traveller neli = f.buildTrav();
		//list.listAdd(travellers_clc, neli);
		
		//YoungTraveller annoula = new YoungTraveller(t3,t4,"annoula");
		
		list.setTravellers_clc(travellers_clc);
		list.iter_list( travellers_clc);
		list.avoidDuplicates(travellers_clc);
		list.iter_list( travellers_clc);
		list.sorting(travellers_clc);
		
		list.iter_list( travellers_clc);
		
		Serialization sr = new Serialization();
		
		sr.writeJSON(list);
		ArrayList <Traveller> travellers_c = new ArrayList<Traveller>();
		sr.readJSON();
		travellers_c = sr.readJSON();	
        System.out.println("The data of the array list is:\n"+travellers_c);
        System.out.println("\nThe 1st object in the arraylist is: "+travellers_c.get(1));
        System.out.println("The 2st object in the arraylist is: "+travellers_c.get(2));
        System.out.println("The Name of 1st traveller is: "+((Traveller)travellers_c.get(1)).getName());
	
		
		
		
      
      
     //Traveller loco = f.buildTrav();
     //System.out.println("name"+ loco.getName() + "geodesic"+ loco.geodesic_traveller +"terms" + loco.getTerms());
		*/
	}
	


}

