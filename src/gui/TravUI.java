package gui;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import hua.dit.omada20.ElderTraveller;
import hua.dit.omada20.MiddleTraveller;
import hua.dit.omada20.Traveller;
import hua.dit.omada20.YoungTraveller;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class TravUI extends JFrame implements ActionListener{

	public JFrame frame;
	private JPanel panel;
	
	//private JLabel title;
	
	private JLabel City_lbl;
	
	private JTextField City_textField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
    
	public JButton btnNewButton;
	
	public JLabel RecomendCity_lbl;
	
	private JTextPane RecomendCity_textPanel;
	
	private JLabel Traveller_lbl;
	
	private JLabel name;
    private JTextField tname;
    
    private JLabel age;
    private JRadioButton young;
    private JRadioButton middle;
    private JRadioButton elder;
    private ButtonGroup agegp;
    
    private  JLabel TravGeodesic_lbl;
    
    private JLabel latitude;
    private JFormattedTextField tlatitude;
    private JLabel longitude;
    private JFormattedTextField tlongitude;
    
    private JLabel Terms_lbl_1;
    
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
    
    private JButton Submit_btn;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;
    
    
    public int  new_term1;
	public int  new_term2;
	public int  new_term3;
	public int  new_term4;
	public int  new_term5;
	public int  new_term6;
	
	private MaskFormatter l;

	public TravUI() {
		initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
		
	
		frame = new JFrame();
		frame.setTitle("City recommendation");
		frame.setBounds(100, 100, 850, 485);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		
		
		
		//city
		City_lbl = new JLabel("Insert a city");
		City_textField = new JTextField();
		btnNewButton = new JButton("Go to city");
		RecomendCity_lbl = new JLabel("Recomend City");
		RecomendCity_textPanel = new JTextPane();
		
		City_lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		City_lbl.setBounds(19, 23, 21, 14);
		//frame.getContentPane().add(City_lbl);
		panel.add(City_lbl);
		
		City_textField.setBounds(50, 21, 150, 20);
		frame.getContentPane().add(City_textField);
		City_textField.setColumns(10);
		panel.add(City_textField);
		
		btnNewButton.setBounds(210, 21, 90, 20);
		btnNewButton.addActionListener(this);
		//frame.getContentPane().add(btnNewButton);
		panel.add(btnNewButton);
		
		RecomendCity_lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		RecomendCity_lbl.setBounds(117, 130, 90, 14);
		//frame.getContentPane().add(RecomendCity_lbl);
		panel.add(RecomendCity_lbl);
		
		RecomendCity_textPanel.setBounds(19, 155, 290, 268);
		//frame.getContentPane().add(RecomendCity_textPanel);
		panel.add(RecomendCity_textPanel);
		
		//traveller
		Traveller_lbl = new JLabel("Traveller");
		name = new JLabel("Name");
		tname = new JTextField();
		age = new JLabel("Age");
		young = new JRadioButton("16-25");
		middle = new JRadioButton("25-60");
		elder = new JRadioButton("60-115");
		agegp = new ButtonGroup();
		latitude = new JLabel("Latitude");
		
		 try {
				l = new MaskFormatter("##.###");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        tlatitude = new JFormattedTextField(l);
	        longitude = new JLabel("Longitude");
	        tlongitude = new JFormattedTextField(l);
	        
		
		Traveller_lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		Traveller_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		Traveller_lbl.setBounds(616, 14, 90, 14);
		frame.getContentPane().add(Traveller_lbl);
		
		
		
		name.setFont(new Font("Tahoma", Font.PLAIN, 13));
		name.setBounds(544, 51, 41, 14);
		frame.getContentPane().add(name);
		
		
		tname.setColumns(10);
		tname.setBounds(595, 49, 150, 20);
		frame.getContentPane().add(tname);
		
		
		age.setFont(new Font("Tahoma", Font.PLAIN, 13));
		age.setBounds(553, 76, 32, 20);
		frame.getContentPane().add(age);
		
		 
	     young.setFont(new Font("Arial", Font.PLAIN, 15));
	     young.setSelected(true);
	     young.setSize(75, 20);
	     young.setLocation(175, 125);
	     frame.getContentPane().add(young);
	     
	     
	     middle.setFont(new Font("Arial", Font.PLAIN, 15));
	     middle.setSelected(false);
	     middle.setSize(80, 20);
	     middle.setLocation(250, 125);
	     frame.getContentPane().add(middle);
	        
	     
	     elder.setFont(new Font("Arial", Font.PLAIN, 15));
	     elder.setSelected(false);
	     elder.setSize(80, 20);
	     elder.setLocation(325, 125);
	     frame.getContentPane().add(elder);
		
	    
	     agegp.add(young);
	     agegp.add(middle);
	     agegp.add(elder); 
		
	     
	     latitude.setFont(new Font("Arial", Font.PLAIN, 20));
	     latitude.setSize(100, 20);
	     latitude.setLocation(100, 150);
	     frame.setContentPane(latitude);
	        
	       
	        tlatitude.setValue(tlatitude.getInputContext());
	        tlatitude.setFont(new Font("Arial", Font.PLAIN, 15));
	        tlatitude.setSize(190, 20);
	        tlatitude.setLocation(200, 150);
	        frame.setContentPane(tlatitude);
	        
	        
	        longitude.setFont(new Font("Arial", Font.PLAIN, 20));
	        longitude.setSize(100, 20);
	        longitude.setLocation(100, 200);
	        frame.setContentPane(longitude);
	        
	        
	        tlongitude.setValue(tlongitude.getInputContext());
	        tlongitude.setFont(new Font("Arial", Font.PLAIN, 15));
	        tlongitude.setSize(190, 20);
	        tlongitude.setLocation(200, 200);
	        frame.setContentPane(tlongitude);
		
		Terms_lbl_1 = new JLabel("Terms");
		Terms_lbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		Terms_lbl_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		Terms_lbl_1.setBounds(616, 178, 90, 14);
		frame.getContentPane().add(Terms_lbl_1);
		
		term1 = new JLabel("Term 1");
        term1.setFont(new Font("Arial", Font.PLAIN, 20));
        term1.setSize(100, 20);
        term1.setLocation(604, 200);
        frame.getContentPane().add(term1);
		
		cterm1 = new JComboBox();
        for(int i=0;i<=10;i++) {
        	cterm1.addItem(i);
        }
		cterm1.setBounds(604, 203, 30, 22);
		frame.getContentPane().add(cterm1);
		
		term2 = new JLabel("Term 2");
        term2.setFont(new Font("Arial", Font.PLAIN, 20));
        term2.setSize(100, 20);
        term2.setLocation(696, 200);
        frame.getContentPane().add(term2);
		
		cterm2 = new JComboBox();
        for(int i=0;i<=10;i++) {
        	cterm2.addItem(i);
        }
		
		cterm2.setBounds(696, 203, 30, 22);
		frame.getContentPane().add(cterm2);
		
        term3 = new JLabel("Term 3");
        term3.setFont(new Font("Arial", Font.PLAIN, 20));
        term3.setSize(100, 20);
        term3.setLocation(604, 230);
        frame.getContentPane().add(term3);
		
		cterm3 = new JComboBox();
        for(int i=0;i<=10;i++) {
        	cterm3.addItem(i);
        }
		cterm3.setBounds(604, 236, 30, 22);
		frame.getContentPane().add(cterm3);
		
		term4 = new JLabel("Term 4");
        term4.setFont(new Font("Arial", Font.PLAIN, 20));
        term4.setSize(50, 20);
        term4.setLocation(300, 250);
        frame.getContentPane().add(term4);
		
		cterm4 = new JComboBox();
        for(int i=0;i<=10;i++) {
        	cterm4.addItem(i);
        }
		
		cterm4.setBounds(696, 236, 30, 22);
		frame.getContentPane().add(cterm4);
		
		 term5 = new JLabel("Term 5");
	     term5.setFont(new Font("Arial", Font.PLAIN, 20));
	     term5.setSize(100, 20);
	     term5.setLocation(604, 280);
	     frame.getContentPane().add(term5);
		
		cterm5 = new JComboBox();
        for(int i=0;i<=10;i++) {
        	cterm5.addItem(i);
        }
		cterm5.setBounds(604, 269, 30, 22);
		frame.getContentPane().add(cterm5);
		
		term6 = new JLabel("Term 6");
        term6.setFont(new Font("Arial", Font.PLAIN, 20));
        term6.setSize(100, 20);
        term6.setLocation(696, 280);
        frame.getContentPane().add(term6);
		
		cterm6 = new JComboBox();
        for(int i=0;i<=10;i++) {
        	cterm6.addItem(i);
        }
		cterm6.setBounds(696, 269, 30, 22);
		frame.getContentPane().add(cterm6);
		
		JButton Submit_btn = new JButton("Submit");
		Submit_btn.setBounds(567, 347, 89, 23);
		frame.getContentPane().add(Submit_btn);
		
		JButton Reset_btn = new JButton("Reset");
		Reset_btn.setBounds(666, 347, 89, 23);
		frame.getContentPane().add(Reset_btn);
		
		frame.add(panel);
		//frame.pack();
		frame.setVisible(true);
		//
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		
		if (e.getSource() == Submit_btn ) {
		
			
			String data1
	        = "Name : "
	          + tname.getText() + "\n"
	          + "Latitude : "
	          + tlatitude.getText() + "\n"
	          + "Longitude : "
	          + tlongitude.getText() + "\n";
			
			
			new_term1 = (Integer)cterm1.getSelectedItem();
			new_term2 = (Integer)cterm2.getSelectedItem();
			new_term3 = (Integer)cterm3.getSelectedItem();
			new_term4 = (Integer)cterm4.getSelectedItem();
			new_term5 = (Integer)cterm5.getSelectedItem();
			new_term6 = (Integer)cterm6.getSelectedItem();
			
			
			
			String data;
			if (young.isSelected()) {
			            data = "Age : 18-25"
			                    + "\n";
			            }
			        else if(middle.isSelected()) {
			            data = "Age : 25-60"
			                    + "\n"; 
			            }
			            else{
			                data = "Age: 60-115"
			                        +"\n";
			            };
			
			
			
			String data2
	        = "Term 1 : "
	          + cterm1.getSelectedItem() + "\n"
	          + "Term 2 :" + cterm2.getSelectedItem() + "\n"
	          + "Term 3 :" + cterm3.getSelectedItem() +"\n"
	          + "Term 4 :" + cterm4.getSelectedItem() +"\n"
	          + "Term 5 :" + cterm5.getSelectedItem() +"\n"
	          + "Term 6 :" + cterm6.getSelectedItem() +"\n";
			
			
			tout.setText(data1 + data+ data2);
			
			
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
			
		
	}
		public Traveller buildTrav() throws NumberFormatException{
			if (young.isSelected()) {
	            YoungTraveller new_young = new YoungTraveller();
	            new_young.setName(tname.getText());
	            Vector<Integer> terms_gui = new Vector<Integer>();
	            Vector<Double> geodesic_gui = new Vector<Double>();
	            
	            geodesic_gui.add((Double)tlatitude.getValue() );
	            geodesic_gui.add((Double)tlongitude.getValue() );
	            
	            //cterm1 = (JComboBox)e.getSource();
	            terms_gui.add(new_term1);
	            terms_gui.add(new_term2);
	            terms_gui.add(new_term3);
	            terms_gui.add(new_term4);
	            terms_gui.add(new_term5);
	            terms_gui.add(new_term6);
	            Date new_young_date = new Date();
	            new_young.setTerms(terms_gui);
	            new_young.setGeodesic_traveller(geodesic_gui);
	            new_young.setTimestamp(new_young_date);
	            
	            return new_young;
	            }
	        else if(middle.isSelected()) {
	            MiddleTraveller new_middle = new MiddleTraveller();
	            
	            Vector<Integer> terms_gui = new Vector<Integer>();
	            Vector<Double> geodesic_gui = new Vector<Double>();
	            
	            geodesic_gui.add((Double)(tlatitude.getValue()) );
	            geodesic_gui.add((Double)(tlongitude.getValue()) );
	            
	            terms_gui.add(new_term1);
	            terms_gui.add(new_term2);
	            terms_gui.add(new_term3);
	            terms_gui.add(new_term4);
	            terms_gui.add(new_term5);
	            terms_gui.add(new_term6);
	            Date new_middle_date = new Date();
	            new_middle.setTerms(terms_gui);
	            new_middle.setGeodesic_traveller(geodesic_gui);
	            new_middle.setTimestamp(new_middle_date);
	            return new_middle;
	            }
	            else{
	               ElderTraveller new_elder = new ElderTraveller();
	               
	               Vector<Integer> terms_gui = new Vector<Integer>();
	               Vector<Double> geodesic_gui = new Vector<Double>();
	               
	               geodesic_gui.add((Double)(tlatitude.getValue()) );
	               geodesic_gui.add((Double)(tlongitude.getValue()) );
	               
	               terms_gui.add(new_term1);
	               terms_gui.add(new_term2);
	               terms_gui.add(new_term3);
	               terms_gui.add(new_term4);
	               terms_gui.add(new_term5);
	               terms_gui.add(new_term6);
	               Date new_elder_date = new Date();
	               new_elder.setTerms(terms_gui);
	               new_elder.setGeodesic_traveller(geodesic_gui);
	               new_elder.setTimestamp(new_elder_date);
	               
	               return new_elder;
	            }

			
			
			
		}

	
}