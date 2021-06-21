package gui;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import ExceptionHandling.WikipediaNoArcticleException;
import hua.dit.omada20.*;
import save.Serialization;
import collections.*;
import db_connection.Db;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;



public class TravellerUI extends JFrame implements ActionListener{
	
	private JLabel title;
	private Container c;
    //city
	
	private JLabel city_title;
	private JLabel city_name;
	private JTextField city_tfield;
	private JLabel country;
	private JTextField country_tfield;
	private JButton city_btn;
	private JTextArea city_tout;
	private JLabel recom_city;
	private JTextArea recom_out;
	private JButton view;
	
	//traveller
	private JLabel name;
    private JTextField tname;
    private JLabel age;
    private JRadioButton young;
    private JRadioButton middle;
    private JRadioButton elder;
    private ButtonGroup agegp;
    private JLabel latitude;
    private JFormattedTextField tlatitude;
    private JLabel longitude;
    private JFormattedTextField tlongitude;
    private JLabel term1;
    private JComboBox cterm1;
    private JLabel term2;
    private JComboBox cterm2;
    private JLabel term3;
    private JComboBox cterm3;
    private JLabel term4;
    private JComboBox cterm4;
    private JLabel term5;
    private JComboBox cterm5;
    private JLabel term6;
    private JComboBox cterm6;
    
    
    

    private JButton sub;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;
    
    
    private JButton trav_btn_view;
    
    private JLabel get_free_ticket;
    private JTextArea free_tarea;

	//private String values[]
	//        = {" 0","1","2"," 3"," 4"," 5",
	//            "6", "7", "8", "9", "10"};
	
	MaskFormatter l =null;

	
	public int  new_term1;
	public int  new_term2;
	public int  new_term3;
	public int  new_term4;
	public int  new_term5;
	public int  new_term6;
	
	
	//constructor
	public TravellerUI() {
		setTitle("City recommendation");
        setBounds(0, 0, 1920, 1050);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        c = getContentPane();
        c.setLayout(null);
        
        //city
        
        city_title = new JLabel("City");
        city_title.setFont(new Font("Arial", Font.PLAIN, 30));
        city_title.setSize(500, 40);
        city_title.setLocation(300, 30);
        c.add(city_title);
        
        city_name = new JLabel("Insert city:");
        city_name.setFont(new Font("Arial", Font.PLAIN, 20));
        city_name.setSize(200,100);
        city_name.setLocation(100,100);
        c.add(city_name);
        
        city_tfield = new JTextField();
        city_tfield.setFont(new Font("Arial", Font.PLAIN, 15));
        city_tfield.setSize(225,20);
        city_tfield.setLocation(250,143);
        c.add(city_tfield);
        
        country = new JLabel("insert country:");
        country.setFont(new Font("Arial", Font.PLAIN, 20));
        country.setSize(200,100);
        country.setLocation(100,130);
        c.add(country);
        
        country_tfield = new JTextField();
        country_tfield.setFont(new Font("Arial", Font.PLAIN, 15));
        country_tfield.setSize(225,20);
        country_tfield.setLocation(250,173);
        c.add(country_tfield);
        
        city_btn = new JButton("Add");
        city_btn.setFont(new Font("Arial", Font.PLAIN, 15));
        city_btn.setSize(80, 50);
        city_btn.setLocation(500, 143);
        city_btn.addActionListener(this);
        c.add(city_btn);
        
        city_tout = new JTextArea();
        city_tout.setFont(new Font("Arial", Font.PLAIN, 15));
        city_tout.setSize(480, 300);
        city_tout.setLocation(100, 200);
        city_tout.setLineWrap(true);
        city_tout.setEditable(false);
        c.add(city_tout);

        
        
        recom_city = new JLabel("Recommended city:");
        recom_city.setFont(new Font("Arial", Font.PLAIN, 20));
        recom_city.setSize(210,110);
        recom_city.setLocation(1000,600);
        c.add(recom_city);
        
        
        recom_out = new JTextArea();
        recom_out.setFont(new Font("Arial", Font.PLAIN, 15));
        recom_out.setSize(225,20);
        recom_out.setLocation(1200,645);
        recom_out.setLineWrap(true);
        recom_out.setEditable(false);
        c.add(recom_out);
        
        view = new JButton("View all cities");
        view.setFont(new Font("Arial", Font.PLAIN, 15));
        view.setSize(300, 100);
        view.setLocation(180, 800);
        view.addActionListener(this);
        c.add(view);

        
        //traveller
        title = new JLabel("Traveller Registration");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(500, 40);
        title.setLocation(1200, 30);
        c.add(title);
        
        
        
        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 25);
        name.setLocation(1000, 100);
        c.add(name);
        
        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(225, 20);
        tname.setLocation(1100, 100);
        c.add(tname);
        
        age = new JLabel("Age");
        age.setFont(new Font("Arial", Font.PLAIN, 20));
        age.setSize(100, 25);
        age.setLocation(1000, 125);
        c.add(age);
  
        young = new JRadioButton("16-25");
        young.setFont(new Font("Arial", Font.PLAIN, 15));
        young.setSelected(true);
        young.setSize(75, 20);
        young.setLocation(1100, 125);
        c.add(young);
  
        middle = new JRadioButton("25-60");
        middle.setFont(new Font("Arial", Font.PLAIN, 15));
        middle.setSelected(false);
        middle.setSize(80, 20);
        middle.setLocation(1175, 125);
        c.add(middle);
        
        elder = new JRadioButton("60-115");
        elder.setFont(new Font("Arial", Font.PLAIN, 15));
        elder.setSelected(false);
        elder.setSize(80, 20);
        elder.setLocation(1250, 125);
        c.add(elder);
  
        agegp = new ButtonGroup();
        agegp.add(young);
        agegp.add(middle);
        agegp.add(elder); 
        
        latitude = new JLabel("Latitude");
        latitude.setFont(new Font("Arial", Font.PLAIN, 20));
        latitude.setSize(100, 25);
        latitude.setLocation(1000, 150);
        c.add(latitude);
        
        try {
			l = new MaskFormatter("##.###");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        tlatitude = new JFormattedTextField(l);
        tlatitude.setValue(tlatitude.getInputContext());
        tlatitude.setFont(new Font("Arial", Font.PLAIN, 15));
        tlatitude.setSize(225, 20);
        tlatitude.setLocation(1100, 150);
        c.add(tlatitude);
        
        longitude = new JLabel("Longitude");
        longitude.setFont(new Font("Arial", Font.PLAIN, 20));
        longitude.setSize(150, 25);
        longitude.setLocation(1000, 200);
        c.add(longitude);
        
        tlongitude = new JFormattedTextField(l);
        tlongitude.setValue(tlongitude.getInputContext());
        tlongitude.setFont(new Font("Arial", Font.PLAIN, 15));
        tlongitude.setSize(225, 20);
        tlongitude.setLocation(1100, 200);
        c.add(tlongitude);
        
        term1 = new JLabel("Term 1");
        term1.setFont(new Font("Arial", Font.PLAIN, 20));
        term1.setSize(100, 20);
        term1.setLocation(1000, 250);
        c.add(term1);
        
        cterm1 = new JComboBox();
        for(int i=0;i<=10;i++) {
        	cterm1.addItem(i);
        }
        cterm1.setFont(new Font("Arial", Font.PLAIN, 15));
        cterm1.setSize(50, 20);
        cterm1.setLocation(1100, 250);
        c.add(cterm1);
        
        //term 2
        term2 = new JLabel("Term 2");
        term2.setFont(new Font("Arial", Font.PLAIN, 20));
        term2.setSize(100, 20);
        term2.setLocation(1000, 300);
        c.add(term2);
        
        cterm2 = new JComboBox();
        for(int i=0;i<=10;i++) {
        	cterm2.addItem(i);
        }
        
        cterm2.setFont(new Font("Arial", Font.PLAIN, 15));
        cterm2.setSize(50, 20);
        cterm2.setLocation(1100, 300);
        c.add(cterm2);
        
        //term 3
        term3 = new JLabel("Term 3");
        term3.setFont(new Font("Arial", Font.PLAIN, 20));
        term3.setSize(100, 20);
        term3.setLocation(1000, 350);
        c.add(term3);
        
        cterm3 = new JComboBox();
        for(int i=0;i<=10;i++) {
        	cterm3.addItem(i);
        }
        
        cterm3.setFont(new Font("Arial", Font.PLAIN, 15));
        cterm3.setSize(50, 20);
        cterm3.setLocation(1100, 350);
        c.add(cterm3);
        
        //term4
        
        term4 = new JLabel("Term 4");
        term4.setFont(new Font("Arial", Font.PLAIN, 20));
        term4.setSize(100, 20);
        term4.setLocation(1200, 250);
        c.add(term4);
        
        cterm4 = new JComboBox();
        for(int i=0;i<=10;i++) {
        	cterm4.addItem(i);
        }
        
        cterm4.setFont(new Font("Arial", Font.PLAIN, 15));
        cterm4.setSize(50, 20);
        cterm4.setLocation(1300, 250);
        c.add(cterm4);
        
        //term5
        term5 = new JLabel("Term 5");
        term5.setFont(new Font("Arial", Font.PLAIN, 20));
        term5.setSize(100, 20);
        term5.setLocation(1200, 300);
        c.add(term5);
        
        cterm5 = new JComboBox();
        for(int i=0;i<=10;i++) {
        	cterm5.addItem(i);
        }
        
        cterm5.setFont(new Font("Arial", Font.PLAIN, 15));
        cterm5.setSize(50, 20);
        cterm5.setLocation(1300, 300);
        c.add(cterm5);
        
        //term6
        term6 = new JLabel("Term 6");
        term6.setFont(new Font("Arial", Font.PLAIN, 20));
        term6.setSize(100, 20);
        term6.setLocation(1200, 350);
        c.add(term6);
        
        cterm6 = new JComboBox();
        for(int i=0;i<=10;i++) {
        	cterm6.addItem(i);
        }
        
        cterm6.setFont(new Font("Arial", Font.PLAIN, 15));
        cterm6.setSize(50, 20);
        cterm6.setLocation(1300, 350);
        c.add(cterm6);
        
        //submit
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(1050, 450);
        sub.addActionListener(this);
        c.add(sub);
  
        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(1200, 450);
        reset.addActionListener(this);
        c.add(reset);
  
        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(450, 400);
        tout.setLocation(1400, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);
  
        
        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(1100, 500);
        c.add(res);
  
        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(1580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);
        
        trav_btn_view = new JButton("View all travellers");
        trav_btn_view.setFont(new Font("Arial", Font.PLAIN, 15));
        trav_btn_view.setSize(200, 100);
        trav_btn_view.setLocation(1500, 600);
        trav_btn_view.addActionListener(this);
        c.add(trav_btn_view);

        
        get_free_ticket = new JLabel("Get Free Ticket:");
        get_free_ticket.setFont(new Font("Arial", Font.PLAIN, 15));
        get_free_ticket.setSize(200, 60);
        get_free_ticket.setLocation(1300, 800);
        c.add(get_free_ticket);
        
        free_tarea = new JTextArea();
        free_tarea.setFont(new Font("Arial", Font.PLAIN, 15));
        free_tarea.setSize(225,60);
        free_tarea.setLocation(1530,800);
        free_tarea.setLineWrap(true);
        free_tarea.setEditable(false);
        c.add(free_tarea);
        
     
        
        setVisible(true);
	}

//actionhandler
public void actionPerformed(ActionEvent e) throws NumberFormatException
{
	
	Traveller trav_gui = null;
	HashMap<String, City> cities_map = new HashMap<String,City>();
	
	Mapping woh = new Mapping();
	
	Db inserts = new Db();
	ArrayList <Traveller> traveller_list = new ArrayList<Traveller>();
	
	
	
	Serialization ser = new Serialization();
	City city_gui = new City();
	
	try {
		traveller_list = ser.readJSON();
	} catch (JsonParseException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	} catch (JsonMappingException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	} catch (IOException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	//city
	if(e.getSource()==city_btn) {
		String appid ="91b51e02ca05f068a575003bddb415fc";
		try {
			 city_gui = new City(city_tfield.getText(),country_tfield.getText(),appid);
			
			woh.hashPut(cities_map, city_gui);
			
			woh.setCities_map(cities_map);
			
			
			
			inserts.insert_data(city_gui);
			
			
			//city_tout.setText(woh.Iter(cities_map));
			//city_tout.setText(city_gui.getName() + city_gui.getTerms() + city_gui.getGeodesic());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (WikipediaNoArcticleException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	if(e.getSource()== view) {
		try {
			cities_map = inserts.return_data();
			city_tout.setText(woh.Iter(cities_map));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (WikipediaNoArcticleException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	//traveller
	if (e.getSource() == sub) {
		
		TravFromGUI loco = new TravFromGUI();
		
		ArrayList<City> am = new ArrayList<City>(); 
		
		
		
		Vector<Integer> terms_gui = new Vector<Integer>();
        Vector<Double> geodesic_gui = new Vector<Double>();
		
        String name_gui = tname.getText();
        
        
		terms_gui.add( new_term1 = (Integer)cterm1.getSelectedItem());
		terms_gui.add(new_term2 = (Integer)cterm2.getSelectedItem());
		terms_gui.add(new_term3 = (Integer)cterm3.getSelectedItem());
		terms_gui.add(new_term4 = (Integer)cterm4.getSelectedItem());
		terms_gui.add(new_term5 = (Integer)cterm5.getSelectedItem());
		terms_gui.add(new_term6 = (Integer)cterm6.getSelectedItem());
		
		 geodesic_gui.add(Double.valueOf(tlatitude.getText()) );
         geodesic_gui.add(Double.valueOf(tlongitude.getText()) );
		
		
		if (young.isSelected()) {
		          trav_gui = loco.create_young(name_gui, terms_gui, geodesic_gui);
		}else if(middle.isSelected()) {
		           trav_gui = loco.create_middle(name_gui, terms_gui, geodesic_gui);
		            }
		            else{
		               trav_gui =  loco.create_elder(name_gui, terms_gui, geodesic_gui);
		            };
		            
		            try {
		            	
						cities_map = inserts.return_data();
						am =loco.hashtoar(cities_map); 
						
						City returned = trav_gui.compare_cities(am);
						
						recom_out.setText(returned.getName());
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (WikipediaNoArcticleException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
		            
		            
		            ArrayList<Traveller> travellers_clc = new ArrayList<Traveller>();
		    		
		    		Listing list = new Listing();
		    		
		    		list.listAdd(travellers_clc, trav_gui);
		    		list.setTravellers_clc(travellers_clc);
		    		list.avoidDuplicates(travellers_clc);
		    		list.sorting(travellers_clc);
		
		    		/*
		    		Traveller travel;
					try {
						traveller_list = ser.readJSON();
					} catch (JsonParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (JsonMappingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
					Traveller [] arr = new Traveller[traveller_list.size()];
					for(int i=0; i <traveller_list.size();i++) {
						arr[i]= traveller_list.get(i);
					}
					travel = trav_gui.getFreeTicket(arr, city_gui);
					free_tarea.setText(travel.getName());
					*/
					try {
						ser.writeJSON(list);
					} catch (JsonGenerationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (JsonMappingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            
		   
		
        tout.setEditable(false);
        res.setText("Registered successfully");
    }else if (e.getSource() == reset) {
    	String def = "";
        tname.setText(def);
        tlatitude.setValue(null);;
        tlongitude.setValue(null);
        cterm1.setSelectedIndex(0);
        cterm2.setSelectedIndex(0);
        cterm3.setSelectedIndex(0);
        cterm4.setSelectedIndex(0);
        cterm5.setSelectedIndex(0);
        cterm6.setSelectedIndex(0);
        res.setText(def);
        tout.setText(def);
        resadd.setText(def);
    }
	
	if(e.getSource()==trav_btn_view) {
		Listing lst = new Listing();
		String lol = lst.iter_list(traveller_list);
		tout.setText(lol);
		
	}
	/*
	if(e.getSource()==get_free_ticket) {
		 arr= (Traveller[]) traveller_list.toArray();
		//City tofree;
		trav_gui.getFreeTicket( arr, city_gui);
	}
	*/
		
	
}

   
    
   
}