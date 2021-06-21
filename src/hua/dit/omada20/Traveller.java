package hua.dit.omada20;
import java.util.*;
import java.lang.Math;
//import java.time.*;
public abstract class Traveller implements ticket, Comparable<Traveller> {
	private String name;
	//public static final double maxdist = 1000.0;
	private int age;
	public Vector<Integer> terms_traveller;
	public Vector<Double> geodesic_traveller;
	

	Date timestamp ;
	private String visit;
	
	Traveller(){}
	Traveller(Vector<Integer> terms_traveller
			,Vector<Double> geodesic_traveller,String name, Date tmstmp)
	{
		setTerms(terms_traveller);
		this.geodesic_traveller = geodesic_traveller;
		this.name = name;
		this.timestamp = tmstmp;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	
	public String getVisit() {
		return visit;
	}

	public void setVisit(String visit) {
		this.visit = visit;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public Vector<Double> getGeodesic_traveller() {
		return geodesic_traveller;
	}
	public void setGeodesic_traveller(Vector<Double> geodesic_traveller) {
		this.geodesic_traveller = geodesic_traveller;
	}


	/*Traveller(Vector<Integer> terms_traveller
			,Vector<Double> geodesic_traveller,String name,Date timestamp)
	{
		this.terms_traveller = terms_traveller;
		this.geodesic_traveller = geodesic_traveller;
		this.name = name;
		this.timestamp= new Date();
	}
	*/
	public void setTerms(Vector<Integer> new_terms_traveller){
		this.terms_traveller = new_terms_traveller;
	}
	
	public Vector<Integer> getTerms()
	 {
		 return terms_traveller;
	 }
	
	public Vector<Double> getGeodesic()
	 {
		 return geodesic_traveller;
	 }
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String new_name) {
		this.name= new_name;
	}
	/*
	public void setRecomCity(String new_visit ) {
		this.visit=new_visit;
	}
	
	public String getRecomCity() {
		return visit;
	}
	*/
	public abstract double calculate_similarity(City myCity);
	public abstract double similarity_terms_vector(Vector<Integer> terms_vector
			,Vector<Integer> terms_traveller);
	public abstract City compare_cities(ArrayList <City> cities);
	
	public double similarity_geodesic_vector (Vector<Double> geodesic_vector,
			Vector<Double> geodesic_traveller){
		//maxdist = athens-tokio distance 
		double maxdist = 9499.32;
		Double[] g1 = new Double[2];
		Double[] g2 = new Double[2];
		geodesic_vector.toArray(g1);
	    geodesic_traveller.toArray(g2);
	    //g1[0]==lat1
	    //g2[0]==lat2
	    //g1[1]==lon1
	    //g2[1]==lon2
	    double dist = distance(g1[0],g1[1],g2[0],g2[1]);
	    double result =  dist / maxdist;
	    result  = 2 - result;
	    result = 2 / result;
	    result = Math.log(result) / Math.log(2);
	    return result;
	    		
	}
	
	
	private double distance(double lat1, double lon1, double lat2, double lon2)
	{
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) 
					+ Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) 
					* Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			//xiliometra exo valei mono
			dist = dist * 1.609344;
			return (dist);
		}
	}
	
	public int compareTo(Traveller traveller) {
		return getTimestamp().compareTo(traveller.getTimestamp());
	}
	/*
	public String to_JSON() {
	      String temp = " {\n";
	      temp += " \"terms_traveller\" : \"" + terms_traveller + "\",\n";
	      temp += " \"geodesic_traveller\" : \"" + geodesic_traveller + "\",\n";
	      temp += " \"name\" : " + name+ "\n";
	      temp += " }";
	      return temp;
	   }
	*/
	/*
	public String to_String() {
		return "Traveller  [ name: "+name+", age: "+ age+ " , terms:"+ terms_traveller + ",geodesic_terms:"+ geodesic_traveller + ",timestamp:"+timestamp + "]";
	}
	*/
}
