package collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import hua.dit.omada20.*;

public class Mapping {
	private HashMap<String, City> cities_map = new HashMap<String, City>();
	public Mapping() {
		//setCities_map(cities_map);
	}
	public void hashPut(HashMap<String, City> cities_map, City city) {
		
		cities_map.put(city.getName(), city);
		
	}
	public HashMap<String, City> getCities_map() {
		return cities_map;
		
	}
	public void setCities_map(HashMap<String, City> cities_map) {
		this.cities_map = cities_map;
		System.out.println("done");
	}
	
	public String   Iter(HashMap<String, City> cities_map) {
		Iterator<Entry<String, City>> it = cities_map.entrySet().iterator();
		City city_iter;
		StringBuilder str = new StringBuilder();
		while (it.hasNext()) {
			
	        Map.Entry entry = (Map.Entry) it.next();
	        
	        str.append("City: ");
	        str.append(entry.getKey() );
	        str.append(" Terms : ");
	       city_iter = (City) entry.getValue();
	        str.append(city_iter.getTerms());
	        str.append(" ");
	        str.append(city_iter.getGeodesic());    
	        str.append("\n");
	        //System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
		}
		String stringify = str.toString();
		return stringify;
    }
}
