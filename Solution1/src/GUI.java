
// Importing the necessary Java Libraries.

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * The GUI class controls the Application's Intefarce.
 * 
 */
@SuppressWarnings("serial")
public class GUI extends JFrame {
	
// Instantiating the Java Swing objects.
	
	//CHECKBOXES
	public static JCheckBox [] selectLocationCheck;
	
	//BUTTONS
	public static JButton loginButt,addDeliveryButt,generateButt,signUpButt,locationButt,deliveryButt,logoutButt,loginButton,signUpButton,addLocationButt;
	
	//COMBOBOXES
	@SuppressWarnings("rawtypes")
	public static JComboBox deliveryDestination,originCombo,destinationCombo;
	
	//TEXTS
	public static JTextField loginEmail,signUpEmail,signUpName,locationClearingCost,locationName,deliveryName;
	public static JTextField intermediateDistance [];
	
	//TEXTAREAS
	public static JTextArea routeTextArea;
	
	//PASSWORDS
	public static JPasswordField loginPassword,signUpConfirmPassword,signUpPassword;
	
	//CARDLAYOUTS
	public static CardLayout mainCard = new CardLayout();
	public static CardLayout landingCard = new CardLayout();
	public static CardLayout dashboardCard = new CardLayout();
	
	
	//PANELS
	public static JPanel mainPanel, viewLocationPanel, selectLocationPanel,selectDeliveryPanel,viewDeliveryPanel;
	public static JPanel centrePanel = new JPanel(mainCard);
	public static JPanel landingCentrePanel = new JPanel(landingCard);
	public static JPanel dashboardCentrePanel = new JPanel(dashboardCard);
	
	
	//SCROLLS
	static JScrollPane viewLocationScrol,viewDeliveryScrol,selectLocationScrol,selectDeliveryScrol;
	
	//CLASS
	static EventHandlers listener = new EventHandlers();
	static Functions func = new Functions();
	
	//GLOBAL VARIABLES
	public static String Route="";
	public static int locationIdsEdit = 0;
	public static LinkedList <String> locationNames,deliveryNames,deliveryDestinationName;
	public static LinkedList <Integer> locationIds, locationClearingCosts;
	
	//The index method.
	public void index () {
		mainPanel = new JPanel(new BorderLayout());
			
			JPanel topMainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
					topMainPanel.setBackground(Color.BLUE);
					
					JLabel geoByteDMSTitle = new JLabel("GeoByte Inc. Delivery Management System");
						geoByteDMSTitle.setFont(new Font("Arial Black", Font.BOLD, 45));//"Times New Roman"
						geoByteDMSTitle.setForeground(Color.WHITE);
						
				topMainPanel.add(geoByteDMSTitle);
				
			mainPanel.add(topMainPanel, BorderLayout.NORTH);
			mainPanel.add(centrePanel, BorderLayout.CENTER);
				centrePanel.add(landingPage(), "Landing Page");
					mainCard.show(centrePanel, "Landing Page");
				JLabel poweredBy = new JLabel("BAYODE BLESSING @ByteWork Assessment   ");
					poweredBy.setForeground(Color.BLUE);
				JPanel poweredByPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
					poweredByPanel.add(poweredBy);
			mainPanel.add(poweredByPanel, BorderLayout.SOUTH);
			mainPanel.add(new JLabel("      "), BorderLayout.EAST);
			mainPanel.add(new JLabel("      "), BorderLayout.WEST);
		add(mainPanel);
	}
	
	//This method (landingPage()) is responsible for the organization of the landing pages
	public JPanel landingPage() {
		JPanel landingPanel = new JPanel(new BorderLayout());
			
			JPanel landingLeft = new JPanel(new GridLayout(16,1,4,4));
				landingLeft.setForeground(Color.gray);
				
				landingLeft.add(new JLabel("  "));
				landingLeft.add(new JLabel("  "));
			
				landingLeft.add(loginButt = new JButton("     Sign-in     "));
				landingLeft.add(signUpButt = new JButton("Sign up"));
			
				loginButt.addActionListener(listener);
				signUpButt.addActionListener(listener);
			
				for(int i=1;i<=12;i++) {
					landingLeft.add(new JLabel("  "));
				}
				
			landingPanel.add(landingLeft, BorderLayout.WEST);
			
				landingCentrePanel.add(loginPage(), "Login Page");
				landingCentrePanel.add(signUpPage(), "SignUp Page");
				
				landingCard.show(landingCentrePanel, "Login Page");
				
				landingPanel.add(landingCentrePanel, BorderLayout.CENTER);
				
		return landingPanel;
	}
	
	//The design of the login page is from this method.
	public JPanel loginPage() {
		JPanel logingPage = new JPanel(new BorderLayout());
			logingPage.setBackground(Color.white);
		
			JPanel loginPageCentre = new JPanel(new GridLayout(16,1,2,2));
				loginPageCentre.setBackground(Color.white);
				
				JPanel loginTitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
					loginTitlePanel.setBackground(Color.white);
					
					JLabel loginTitle = new JLabel("Login");
						loginTitle.setFont(new Font("Calibril", Font.BOLD, 25));
						
					loginTitlePanel.add(loginTitle);
					
				for(int i=1;i<=3;i++) {
					loginPageCentre.add(new JLabel(" "));
				}
				
				loginPageCentre.add(loginTitlePanel);
				loginPageCentre.add(new JLabel("Email:"));
				loginPageCentre.add(loginEmail = new JTextField(""));
				loginPageCentre.add(new JLabel("Password:"));
				loginPageCentre.add(loginPassword = new JPasswordField(""));
				loginPageCentre.add(new JLabel(" "));
				loginPageCentre.add(loginButton = new JButton("Login"));
				
				for(int i=1;i<=6;i++) {
					loginPageCentre.add(new JLabel(" "));
				}
				
					loginEmail.setFont(new Font("Calibril", Font.BOLD, 17));
					loginPassword.setFont(new Font("Calibril", Font.BOLD, 17));
					loginButton.setFont(new Font("Calibril", Font.BOLD, 17));
					loginButton.addActionListener(listener);
				
			logingPage.add(loginPageCentre, BorderLayout.CENTER);
			logingPage.add(new JLabel("                                                                                                                             "), BorderLayout.WEST);
			logingPage.add(new JLabel("                                                                                                                             "), BorderLayout.EAST);
			logingPage.add(new JLabel("               "), BorderLayout.NORTH);
			
		return logingPage;
	}

	//The design of the sign-up page is from this method.
	public JPanel signUpPage() {
		JPanel signUpPage = new JPanel(new BorderLayout());
			
			signUpPage.setBackground(Color.white);
			
			JPanel signUpPageCentre = new JPanel(new GridLayout(16,1,2,2));
				signUpPageCentre.setBackground(Color.white);
				
				JPanel signUpTitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
					signUpTitlePanel.setBackground(Color.white);
					
					JLabel signUpTitle = new JLabel("Create account");
						signUpTitle.setFont(new Font("Calibril", Font.BOLD, 25));
						
					signUpTitlePanel.add(signUpTitle);
				
				signUpPageCentre.add(new JLabel(" "));
				signUpPageCentre.add(signUpTitlePanel);
				signUpPageCentre.add(new JLabel("Please enter your details correctly..."));
				signUpPageCentre.add(new JLabel("Fullname:"));
				signUpPageCentre.add(signUpName = new JTextField(""));
				signUpPageCentre.add(new JLabel("Email:"));
				signUpPageCentre.add(signUpEmail = new JTextField(""));
				signUpPageCentre.add(new JLabel("Password:"));
				signUpPageCentre.add(signUpPassword = new JPasswordField(""));
				signUpPageCentre.add(new JLabel("Confirm password:"));
				signUpPageCentre.add(signUpConfirmPassword = new JPasswordField(""));
				signUpPageCentre.add(new JLabel(" "));
				signUpPageCentre.add(signUpButton = new JButton("Sign up"));
				
				for(int i=1;i<=3;i++) {
					signUpPageCentre.add(new JLabel(" "));
				}
				
					signUpName.setFont(new Font("Calibril", Font.BOLD, 17));
					signUpEmail.setFont(new Font("Calibril", Font.BOLD, 17));
					signUpPassword.setFont(new Font("Calibril", Font.BOLD, 17));
					signUpConfirmPassword.setFont(new Font("Calibril", Font.BOLD, 17));
					signUpButton.setFont(new Font("Calibril", Font.BOLD, 17));
					signUpButton.addActionListener(listener);
				
			signUpPage.add(signUpPageCentre, BorderLayout.CENTER);
			signUpPage.add(new JLabel("                                                                                                                             "), BorderLayout.WEST);
			signUpPage.add(new JLabel("                                                                                                                             "), BorderLayout.EAST);
			signUpPage.add(new JLabel("               "), BorderLayout.NORTH);
			
		
		return signUpPage; 
	}
	
	//This method (dashboard()) is responsible for the organization of the Staff Dashboard pages
	public JPanel dashboard(String name) {
		JPanel dashboardPanel = new JPanel(new BorderLayout());
		
			JPanel dashboardLeft = new JPanel(new GridLayout(16,1,4,4));
				dashboardLeft.setForeground(Color.gray);
				
				dashboardLeft.add(new JLabel("Hi "+name+"!"));
				dashboardLeft.add(new JLabel("  "));
			
				dashboardLeft.add(locationButt = new JButton("     Locations     "));
				dashboardLeft.add(deliveryButt = new JButton("Deliveries"));
				dashboardLeft.add(logoutButt = new JButton("Logout"));
			
				locationButt.addActionListener(listener);
				deliveryButt.addActionListener(listener);
				logoutButt.addActionListener(listener);
			
				for(int i=1;i<=11;i++) {
					dashboardLeft.add(new JLabel("  "));
				}
				
			dashboardPanel.add(dashboardLeft, BorderLayout.WEST);
			
			locationPage();
			
			dashboardCentrePanel.setBorder(LineBorder.createBlackLineBorder());
			
			
			dashboardPanel.add(dashboardCentrePanel, BorderLayout.CENTER);
				
		return dashboardPanel;
	}
	
	//The below method (locationPage()) also controls the design of the location page.
	public void locationPage() {
		JPanel locationPanel = new JPanel(new GridLayout(1,2,2,2));
			
			JPanel locationLeft = new JPanel(new BorderLayout());
				locationLeft.add(new JLabel("             "), BorderLayout.WEST);
				locationLeft.add(new JLabel("             "), BorderLayout.EAST);
				
					JPanel locationLeftCentreTop = new JPanel(new GridLayout(8,1,2,2));
						
						JPanel locationTitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
							JLabel locationTitle = new JLabel("Add Location");
								locationTitle.setFont(new Font("Calibril", Font.BOLD, 25));
								
							locationTitlePanel.add(locationTitle);
						
						locationLeftCentreTop.add(new JLabel(" "));
						locationLeftCentreTop.add(locationTitlePanel);
						locationLeftCentreTop.add(new JLabel("Location name:"));
						locationLeftCentreTop.add(locationName = new JTextField());
						locationLeftCentreTop.add(new JLabel("Location clearing cost:"));
						locationLeftCentreTop.add(locationClearingCost = new JTextField());
						locationLeftCentreTop.add(new JLabel("Select itermediates:"));
						
						JPanel locationLeftCentreDown = new JPanel(new BorderLayout());
							selectLocationPanel = new JPanel(new GridLayout((locationNames.size()+2),1));
							selectLocationScrol = new JScrollPane(selectLocationPanel);
						
							JPanel locationLeftCentreDown2 = new JPanel(new GridLayout(1,1,4,4));
								locationLeftCentreDown2.add(selectLocationScrol);
							locationLeftCentreDown.add(locationLeftCentreDown2, BorderLayout.CENTER);
							locationLeftCentreDown.add(addLocationButt = new JButton("Add location"), BorderLayout.SOUTH);
							
						locationName.setFont(new Font("Calibril", Font.BOLD, 17));
						locationClearingCost.setFont(new Font("Calibril", Font.BOLD, 17));
						addLocationButt.setFont(new Font("Calibril", Font.BOLD, 17));
						addLocationButt.addActionListener(listener);
						
					JPanel locationLeftCentre = new JPanel(new GridLayout(2,1));
					
					locationLeftCentre.add(locationLeftCentreTop);
					locationLeftCentre.add(locationLeftCentreDown);
					
				locationLeft.add(locationLeftCentre, BorderLayout.CENTER);
				
			JPanel locationRight = new JPanel(new BorderLayout());
				locationRight.add(new JLabel("             "), BorderLayout.WEST);
				locationRight.add(new JLabel("             "), BorderLayout.EAST);
				
				
				viewLocationPanel = new JPanel(new GridLayout((locationNames.size()+7),1));
				viewLocationScrol = new JScrollPane(viewLocationPanel);
				
				viewLocation();
				selectLocation();
				
				JPanel viewsLocation = new JPanel(new BorderLayout());
					JPanel views = new JPanel(new FlowLayout(FlowLayout.CENTER));
						JLabel tit = new JLabel("Registered Locations");
							tit.setFont(new Font("Calibril", Font.BOLD, 17));
						views.add(tit);
					viewsLocation.add(views, BorderLayout.NORTH);
					viewsLocation.add(viewLocationScrol, BorderLayout.CENTER);
							
				locationRight.add(viewsLocation, BorderLayout.CENTER);
				
			locationPanel.add(locationLeft);
			locationPanel.add(locationRight);
			
		dashboardCentrePanel.add(locationPanel, "Location Page");
		dashboardCard.show(dashboardCentrePanel, "Location Page");
	}
	public void selectLocation() {
		selectLocationCheck = new JCheckBox[locationNames.size()];
		intermediateDistance = new JTextField[locationNames.size()];
		
		for(int i=0;i<locationNames.size();i++) {
			
			JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
				
				p1.add(selectLocationCheck[i] = new JCheckBox("  "+locationNames.get(i)));
				p1.add( new JLabel("  enter distance: "));
				p1.add(intermediateDistance[i] = new JTextField("",8));
					intermediateDistance[i].setFont(new Font("Calibril", Font.BOLD, 14));
				if(i%2!=0) {
					p1.setBackground(Color.white);
					selectLocationCheck[i].setBackground(Color.white);
				}
				
			selectLocationPanel.add(p1);
		}
		
	}
	
	public void viewLocation() {
		
		for(int i=0;i<locationNames.size();i++) {
			
			JPanel p1 = new JPanel(new BorderLayout());
				if(i%2!=0) p1.setBackground(Color.white);
				
				p1.add(new JLabel("  "+locationNames.get(i).toString()), BorderLayout.CENTER);
					JPanel p2 = new JPanel(new GridLayout(1,2,2,2));
						if(i%2==0) p2.setBackground(Color.white);
						JButton updateLocation = new JButton("Update ");
						JButton removeLocation = new JButton("Remove ");
							removeLocation.setBackground(Color.red);
							removeLocation.setForeground(Color.white);
							final int i_ = i;
							updateLocation.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent event) {
									locationIdsEdit = locationIds.get(i_);
									
									locationName.setText(locationNames.get(i_).toString());
									locationClearingCost.setText(locationClearingCosts.get(i_).toString());
									addLocationButt.setText("Update location");
								}
							});
							removeLocation.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent event) {
									func.removeLocation(locationIds.get(i_));
									func.getLocations();
									locationPage();
								}
							});
						
						p2.add(updateLocation);
						p2.add(removeLocation);
				p1.add(p2, BorderLayout.EAST);
			
			viewLocationPanel.add(p1);
		}
		
	}
	
	//The below method (deliveryPage()) also controls the design of the delivery page.
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void deliveryPage() {
		JPanel deliveryPanel = new JPanel(new GridLayout(1,2,2,2));
			
			JPanel deliveryLeft = new JPanel(new BorderLayout());
			deliveryLeft.add(new JLabel("             "), BorderLayout.WEST);
			deliveryLeft.add(new JLabel("             "), BorderLayout.EAST);
			
				JPanel deliveryLeftCentreTop = new JPanel(new GridLayout(8,1,2,2));
					deliveryLeftCentreTop.setBorder(LineBorder.createBlackLineBorder());
					
					JPanel deliveryTitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
						JLabel deliveryTitle = new JLabel("Add Delivery");
							deliveryTitle.setFont(new Font("Calibril", Font.BOLD, 25));
							
						deliveryTitlePanel.add(deliveryTitle);
					
					deliveryLeftCentreTop.add(new JLabel(" "));
					deliveryLeftCentreTop.add(deliveryTitlePanel);
					deliveryLeftCentreTop.add(new JLabel("Delivery name:"));
					deliveryLeftCentreTop.add(deliveryName = new JTextField());
					deliveryLeftCentreTop.add(new JLabel("Delivery destination:"));
					deliveryLeftCentreTop.add(deliveryDestination = new JComboBox(new Object[] {"Select destination"}));
					deliveryLeftCentreTop.add(addDeliveryButt = new JButton("Add Delivery"));
					
					JPanel deliveryLeftCentreDown = new JPanel(new BorderLayout());
						deliveryLeftCentreDown.setBorder(LineBorder.createBlackLineBorder());
					
						JPanel deliveryLCDTop = new JPanel(new FlowLayout(FlowLayout.CENTER));
							JLabel deliveryLCDTitle = new JLabel("Generate Optimum Route");
								deliveryLCDTitle.setFont(new Font("Calibril", Font.BOLD, 20));
								
							deliveryLCDTop.add(deliveryLCDTitle);
							
						deliveryLeftCentreDown.add(deliveryLCDTop, BorderLayout.NORTH);
							JPanel DLCDCenter = new JPanel(new BorderLayout());
								JPanel DLCDCenterTop = new JPanel(new GridLayout(2,3,2,2));
									DLCDCenterTop.add(originCombo = new JComboBox(new Object[] {"select origin"}));
									DLCDCenterTop.add(destinationCombo = new JComboBox(new Object[] {"select destination"}));
									DLCDCenterTop.add(generateButt = new JButton("Generate"));
									DLCDCenterTop.add(new JLabel(" "));
									DLCDCenterTop.add(new JLabel(" "));
									DLCDCenterTop.add(new JLabel(" "));
										generateButt.addActionListener(listener);
										
										for(int i=0;i<locationNames.size();i++) {
											deliveryDestination.addItem(locationNames.get(i).toString());
											originCombo.addItem(locationNames.get(i).toString());
											destinationCombo.addItem(locationNames.get(i).toString());
										}
								DLCDCenter.add(DLCDCenterTop, BorderLayout.NORTH);
								
									JPanel DLCDCenterCenter = new JPanel(new GridLayout(1,1));
									
									DLCDCenterCenter.add(routeTextArea = new JTextArea(Route,5,1));
									
										Route="";
										routeTextArea.setEditable(false);
										routeTextArea.setFont(new Font("Calibril", Font.BOLD, 20));
									
								DLCDCenter.add(DLCDCenterCenter, BorderLayout.CENTER);
						deliveryLeftCentreDown.add(DLCDCenter, BorderLayout.CENTER);
						
						selectDeliveryPanel = new JPanel(new GridLayout((deliveryNames.size()+2),1));
						selectDeliveryScrol = new JScrollPane(selectDeliveryPanel);
						
						
					deliveryName.setFont(new Font("Calibril", Font.BOLD, 17));
					deliveryDestination.setFont(new Font("Calibril", Font.BOLD, 17));
					addDeliveryButt.setFont(new Font("Calibril", Font.BOLD, 17));
					addDeliveryButt.addActionListener(listener);
					
				JPanel deliveryLeftCentre = new JPanel(new GridLayout(2,1));
				
				deliveryLeftCentre.add(deliveryLeftCentreTop);
				deliveryLeftCentre.add(deliveryLeftCentreDown);
				
				deliveryLeft.add(deliveryLeftCentre, BorderLayout.CENTER);
				
			JPanel deliveryRight = new JPanel(new BorderLayout());
				deliveryRight.add(new JLabel("             "), BorderLayout.WEST);
				deliveryRight.add(new JLabel("             "), BorderLayout.EAST);
				
				viewDeliveryPanel = new JPanel(new GridLayout((deliveryNames.size()+7),1));
				viewDeliveryScrol = new JScrollPane(viewDeliveryPanel);
				
				viewDelivery();
				
				
				JPanel viewsdelivery = new JPanel(new BorderLayout());
					JPanel views = new JPanel(new FlowLayout(FlowLayout.CENTER));
						JLabel tit = new JLabel("Available Deliveries");
							tit.setFont(new Font("Calibril", Font.BOLD, 17));
						views.add(tit);
					viewsdelivery.add(views, BorderLayout.NORTH);
					viewsdelivery.add(viewDeliveryScrol, BorderLayout.CENTER);
							
				deliveryRight.add(viewsdelivery, BorderLayout.CENTER);
				
			deliveryPanel.add(deliveryLeft);
			deliveryPanel.add(deliveryRight);
			
		dashboardCentrePanel.add(deliveryPanel, "Delivery Page");
		dashboardCard.show(dashboardCentrePanel, "Delivery Page");
	}
	
	public void viewDelivery() {
		
		for(int i=0;i<deliveryNames.size();i++) {
			JPanel p1 = new JPanel(new BorderLayout());
				if(i%2!=0) p1.setBackground(Color.white);
				
				p1.add(new JLabel("  "+deliveryNames.get(i).toString()+"       ("+deliveryDestinationName.get(i).toString()+")"), BorderLayout.CENTER);
					/*
					JPanel p2 = new JPanel(new GridLayout(1,2,2,2));
						if(i%2==0) p2.setBackground(Color.white);
						JButton updateLocation = new JButton("Update ");
						JButton removeLocation = new JButton("Remove ");
							removeLocation.setBackground(Color.red);
							removeLocation.setForeground(Color.white);
							final int i_ = i;
							updateLocation.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent event) {
									locationIdsEdit = locationIds.get(i_);
									
									locationName.setText(locationNames.get(i_).toString());
									locationClearingCost.setText(locationClearingCosts.get(i_).toString());
									addLocationButt.setText("Update location");
								}
							});
							removeLocation.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent event) {
									func.removeLocation(locationIds.get(i_));
									func.getLocations();
									locationPage();
								}
							});
						
						p2.add(updateLocation);
						p2.add(removeLocation);
				p1.add(p2, BorderLayout.EAST);
				*/
			
			viewDeliveryPanel.add(p1);
		}
		
	}
}
