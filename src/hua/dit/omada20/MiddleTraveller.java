package hua.dit.omada20;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class MiddleTraveller extends Traveller {

	public MiddleTraveller(Vector<Integer> terms_traveller
			, Vector<Double> geodesic_traveller,String name,Date tmstmp) {
		super(terms_traveller, geodesic_traveller, name, tmstmp);
	}
	public MiddleTraveller() {}
	
	
	public double similarity_terms_vector(Vector <Integer> terms_vector,
			Vector <Integer> terms_traveller)
	{
		double result = 0;
        double noA = 0;
        double noB = 0;

        Integer[] temp1= new Integer[6];
        Integer[] temp2= new Integer[6];

        terms_vector.toArray(temp1);
        terms_traveller.toArray(temp2);

        for(int i = 0; i < temp1.length; i++) {
            if(temp1[i] != 0.0 && temp2[i] != 0.0) {
                result += temp1[i] * temp2[i];
                noA += Math.pow(temp1[i], 2);
                noB += Math.pow(temp2[i], 2);
            }
        }

        return result / (Math.sqrt(noA) * Math.sqrt(noB));
	}
	
	public double calculate_similarity(City myCity ) {
		//p = equaliser
	
		double p = 0.5;
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


