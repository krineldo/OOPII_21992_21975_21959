package collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import hua.dit.omada20.*;

public class Listing {
	private ArrayList<Traveller> travellers_clc ;
	public Listing() {
		
	}
	
	public ArrayList<Traveller> getTravellers_clc() {
		return travellers_clc;
	}

	public void setTravellers_clc(ArrayList<Traveller> travellers_clc) {
		this.travellers_clc = travellers_clc;
	}
	
	public void listAdd(ArrayList<Traveller> travellers_clc,Traveller traveller) {
		travellers_clc.add(traveller);
	}
	
	public void sorting(ArrayList<Traveller> travellers_clc) {
		Collections.sort(travellers_clc);
	}

	public String iter_list(ArrayList<Traveller> travellers_clc) {
		ListIterator<Traveller> listItr = travellers_clc.listIterator();
		Traveller tr;
		 StringBuilder strbl = new StringBuilder(); 
		while(listItr.hasNext())
		{
			tr = listItr.next();
			strbl.append(tr.getName());
			strbl.append(tr.getTerms());
			strbl.append(tr.getGeodesic());
			strbl.append("\n");
		    //System.out.println(listItr.next());
		}
		String tostring = strbl.toString();
		return tostring;
	}
	
	public List<Traveller> avoidDuplicates(ArrayList<Traveller> travellers_clc) {
		List<Traveller> new_listWithStreams = travellers_clc.stream().distinct().collect(Collectors.toList());
	    return new_listWithStreams;
	}
	/*
	  public String toString(ArrayList<Traveller> travellers_clc) {
	      String temp = "";
	      for (Traveller traveller : travellers_clc) {
	         temp += traveller.to_String() + "\n";
	      }
	      return temp;
	   }
	   */
	/*
	public String toJSON(ArrayList<Traveller> travellers_clc) {
	      String temp = "{\n";
	      temp += " \"travellers_clc\" : [\n";
	      for (int i = 0; i < travellers_clc.size(); i++) {
	         temp += travellers_clc.get(i).to_JSON();
	         if (i <travellers_clc.size() - 1) {
	            temp += ",";
	         }
	         temp += "\n";
	      }
	      temp += " ]\n}";
	      return temp;
	   }
	*/
}
