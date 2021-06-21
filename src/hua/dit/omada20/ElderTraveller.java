package hua.dit.omada20;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class ElderTraveller extends Traveller {

	public ElderTraveller(Vector<Integer> terms_traveller
			, Vector<Double> geodesic_traveller,String name,Date tmstmp) {
		super(terms_traveller, geodesic_traveller, name, tmstmp);
	}
	public ElderTraveller() {}
	
	public double similarity_terms_vector(Vector <Integer> terms_vector,
			Vector <Integer> terms_traveller)
	{
		String a = terms_vector.toString();
        String b = terms_traveller.toString();
        
         Set<Character> s1 = new HashSet<>();
        Set<Character> s2 = new HashSet<>();
        
        for(int i=1;i<a.length(); i++) {
            s1.add(a.charAt(i));
        }
        
        for(int j=1;j<b.length(); j++) {
            s2.add(b.charAt(j));
        }
        
         float mergeNum = 0;//Number of union elements
         float commonNum = 0;//Number of same elements (intersection)
         
            for(Character ch1:s1) {
                for(Character ch2:s2) {
                    if(ch1.equals(ch2)) {
                        commonNum++;
                    }
                }
            }
            
            mergeNum = s1.size()+s2.size()-commonNum;
            
            return commonNum/mergeNum;
    }
	public double calculate_similarity(City myCity) {
		//p = equaliser
		double p = 0.05;
		double result = p * similarity_terms_vector(myCity.getTerms(),terms_traveller)
				+ (1-p) * similarity_geodesic_vector(myCity.getGeodesic(),geodesic_traveller);
		return result;
	}
	
public City compare_cities(ArrayList <City> cities) {
		
		double max = calculate_similarity(cities.get(0));
		int k=0;
		for(int i =1; i<cities.size();i++) {
			double temp = calculate_similarity(cities.get(i));
			
			if(temp>max) {
				max=temp;
				 k=i;
			}
		}
		
		return cities.get(k);
	}

public City compare_cities(ArrayList <City> cities, int e) {
	
	int n= cities.size();
	for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < n-i-1; j++) {
        	double jv = calculate_similarity(cities.get(j));
        	double jvplus=calculate_similarity(cities.get(j+1));
        	if(jv>jvplus) {
        		double temp=jv;
        		jv= jvplus;
        		jvplus=temp;
        	}
        	
        }
	}    
	return cities.get(e);
}

public Traveller getFreeTicket(Traveller travellers[],City definedCity)
{
	double max = calculate_similarity(definedCity);
	int i,pos=-1;
	for(i=0;i<travellers.length;i++) {
		
		if(calculate_similarity(definedCity) > max )
		max = calculate_similarity(definedCity);
		pos = i;
	}
	
	return travellers[pos];
}
}

