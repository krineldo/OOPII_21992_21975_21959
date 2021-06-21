package gui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import hua.dit.omada20.*;

public class TravFromGUI {
	
	public TravFromGUI() {}
	
	public Traveller create_young(String name,Vector<Integer> terms_gui,Vector<Double> geodesic_gui) {
		YoungTraveller new_young = new YoungTraveller();
		 Date new_young_date = new Date();
		 new_young.setName(name);
         new_young.setTerms(terms_gui);
         new_young.setGeodesic_traveller(geodesic_gui);
         new_young.setTimestamp(new_young_date);
         
         return new_young;
	}
	
	public Traveller create_middle(String name,Vector<Integer> terms_gui,Vector<Double> geodesic_gui) {
		MiddleTraveller new_middle = new MiddleTraveller();
		 Date new_middle_date = new Date();
		 new_middle.setName(name);
         new_middle.setTerms(terms_gui);
         new_middle.setGeodesic_traveller(geodesic_gui);
         new_middle.setTimestamp(new_middle_date);
         
         return new_middle;
         
	}

	public Traveller create_elder(String name,Vector<Integer> terms_gui,Vector<Double> geodesic_gui) {
		ElderTraveller new_elder = new ElderTraveller();
		 Date new_elder_date = new Date();
		 new_elder.setName(name);
         new_elder.setTerms(terms_gui);
         new_elder.setGeodesic_traveller(geodesic_gui);
         new_elder.setTimestamp(new_elder_date);
         
         return new_elder;
         
	}
	
	public ArrayList<City> hashtoar (HashMap<String,City> city_hash ) {
		Collection<City> values = city_hash.values();
		ArrayList<City> listOfValues = new ArrayList<>(values);
		
		return listOfValues;
		
	}
	/*
	public String str1ng(City city) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(city.getName());
		sb.append(city.getTerms());
		
		
		return null;
	}
	*/

	
}
