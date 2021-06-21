package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

public class Trskrtskrt extends JFrame {

	private JPanel contentPane;
	//public JFrame frame;
	private JPanel panel;
	
	private JLabel title;
	
	//private JLabel City_lbl;
	
	//private JTextField City_textField;
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


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Trskrtskrt frame = new Trskrtskrt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Trskrtskrt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
	
			
		/*
			frame = new JFrame();
			frame.setTitle("City recommendation");
			frame.setBounds(100, 100, 850, 485);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			panel = new JPanel();
			panel.setLayout(new FlowLayout());
			*/
			//city
			JLabel City_lbl = new JLabel("Insert a city");
			City_lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
			City_lbl.setBounds(19, 23, 21, 14);
			setContentPane(City_lbl);
			
			JTextField City_textField = new JTextField();
			City_textField.setBounds(50, 21, 150, 20);
			City_textField.setColumns(10);
			setContentPane(City_textField);
			
			btnNewButton = new JButton("Go to city");
			btnNewButton.setBounds(210, 21, 90, 20);
			//btnNewButton.addActionListener(this);
			setContentPane(btnNewButton);
			
			
			RecomendCity_lbl = new JLabel("Recomend City");
			RecomendCity_lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
			RecomendCity_lbl.setBounds(117, 130, 90, 14);
			setContentPane(RecomendCity_lbl);
			
			RecomendCity_textPanel = new JTextPane();
			RecomendCity_textPanel.setBounds(19, 155, 290, 268);
			setContentPane(RecomendCity_textPanel);
			//
			//traveller
			Traveller_lbl = new JLabel("Traveller");
			Traveller_lbl.setHorizontalAlignment(SwingConstants.CENTER);
			Traveller_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
			Traveller_lbl.setBounds(616, 14, 90, 14);
			setContentPane(Traveller_lbl);
			
			name = new JLabel("Name");
			name.setFont(new Font("Tahoma", Font.PLAIN, 13));
			name.setBounds(544, 51, 41, 14);
			setContentPane(name);
			
			tname = new JTextField();
			tname.setColumns(10);
			tname.setBounds(595, 49, 150, 20);
			setContentPane(tname);
			
			age = new JLabel("Age");
			age.setFont(new Font("Tahoma", Font.PLAIN, 13));
			age.setBounds(553, 76, 32, 20);
			setContentPane(age);
			
			 young = new JRadioButton("16-25");
		     young.setFont(new Font("Arial", Font.PLAIN, 15));
		     young.setSelected(true);
		     young.setSize(75, 20);
		     young.setLocation(175, 125);
		     setContentPane(young);
		     
		     middle = new JRadioButton("25-60");
		     middle.setFont(new Font("Arial", Font.PLAIN, 15));
		     middle.setSelected(false);
		     middle.setSize(80, 20);
		     middle.setLocation(250, 125);
		     setContentPane(middle);
		        
		     elder = new JRadioButton("60-115");
		     elder.setFont(new Font("Arial", Font.PLAIN, 15));
		     elder.setSelected(false);
		     elder.setSize(80, 20);
		     elder.setLocation(325, 125);
		     setContentPane(elder);
			
		     agegp = new ButtonGroup();
		     agegp.add(young);
		     agegp.add(middle);
		     agegp.add(elder); 
			
		     latitude = new JLabel("Latitude");
		     latitude.setFont(new Font("Arial", Font.PLAIN, 20));
		     latitude.setSize(100, 20);
		     latitude.setLocation(100, 150);
		     setContentPane(latitude);
		        
		        try {
					l = new MaskFormatter("##.###");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        tlatitude = new JFormattedTextField(l);
		        tlatitude.setValue(tlatitude.getInputContext());
		        tlatitude.setFont(new Font("Arial", Font.PLAIN, 15));
		        tlatitude.setSize(190, 20);
		        tlatitude.setLocation(200, 150);
		        setContentPane(tlatitude);
		        
		        longitude = new JLabel("Longitude");
		        longitude.setFont(new Font("Arial", Font.PLAIN, 20));
		        longitude.setSize(100, 20);
		        longitude.setLocation(100, 200);
		        setContentPane(longitude);
		        
		        tlongitude = new JFormattedTextField(l);
		        tlongitude.setValue(tlongitude.getInputContext());
		        tlongitude.setFont(new Font("Arial", Font.PLAIN, 15));
		        tlongitude.setSize(190, 20);
		        tlongitude.setLocation(200, 200);
		        setContentPane(tlongitude);
			
			Terms_lbl_1 = new JLabel("Terms");
			Terms_lbl_1.setHorizontalAlignment(SwingConstants.CENTER);
			Terms_lbl_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			Terms_lbl_1.setBounds(616, 178, 90, 14);
			setContentPane(Terms_lbl_1);
			
			term1 = new JLabel("Term 1");
	        term1.setFont(new Font("Arial", Font.PLAIN, 20));
	        term1.setSize(100, 20);
	        term1.setLocation(604, 200);
	        setContentPane(term1);
			
			cterm1 = new JComboBox();
	        for(int i=0;i<=10;i++) {
	        	cterm1.addItem(i);
	        }
			cterm1.setBounds(604, 203, 30, 22);
			setContentPane(cterm1);
			
			term2 = new JLabel("Term 2");
	        term2.setFont(new Font("Arial", Font.PLAIN, 20));
	        term2.setSize(100, 20);
	        term2.setLocation(696, 200);
	        setContentPane(term2);
			
			cterm2 = new JComboBox();
	        for(int i=0;i<=10;i++) {
	        	cterm2.addItem(i);
	        }
			
			cterm2.setBounds(696, 203, 30, 22);
			setContentPane(cterm2);
			
	        term3 = new JLabel("Term 3");
	        term3.setFont(new Font("Arial", Font.PLAIN, 20));
	        term3.setSize(100, 20);
	        term3.setLocation(604, 230);
	        setContentPane(term3);
			
			cterm3 = new JComboBox();
	        for(int i=0;i<=10;i++) {
	        	cterm3.addItem(i);
	        }
			cterm3.setBounds(604, 236, 30, 22);
			setContentPane(cterm3);
			
			term4 = new JLabel("Term 4");
	        term4.setFont(new Font("Arial", Font.PLAIN, 20));
	        term4.setSize(50, 20);
	        term4.setLocation(300, 250);
	        setContentPane(term4);
			
			cterm4 = new JComboBox();
	        for(int i=0;i<=10;i++) {
	        	cterm4.addItem(i);
	        }
			
			cterm4.setBounds(696, 236, 30, 22);
			setContentPane(cterm4);
			
			 term5 = new JLabel("Term 5");
		     term5.setFont(new Font("Arial", Font.PLAIN, 20));
		     term5.setSize(100, 20);
		     term5.setLocation(604, 280);
		     setContentPane(term5);
			
			cterm5 = new JComboBox();
	        for(int i=0;i<=10;i++) {
	        	cterm5.addItem(i);
	        }
			cterm5.setBounds(604, 269, 30, 22);
			setContentPane(cterm5);
			
			term6 = new JLabel("Term 6");
	        term6.setFont(new Font("Arial", Font.PLAIN, 20));
	        term6.setSize(100, 20);
	        term6.setLocation(696, 280);
	        setContentPane(term6);
			
			cterm6 = new JComboBox();
	        for(int i=0;i<=10;i++) {
	        	cterm6.addItem(i);
	        }
			cterm6.setBounds(696, 269, 30, 22);
			setContentPane(cterm6);
			
			JButton Submit_btn = new JButton("Submit");
			Submit_btn.setBounds(567, 347, 89, 23);
			setContentPane(Submit_btn);
			
			JButton Reset_btn = new JButton("Reset");
			Reset_btn.setBounds(666, 347, 89, 23);
			setContentPane(Reset_btn);
		}
	}


