import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.*;

@SuppressWarnings("serial")
public class EventHandlers extends GUI implements ActionListener {
	
	//Global variables
	//private LinkedList<Integer>deliveryDestinationId;
	
	
	static Functions func = new Functions();
	
	
	@SuppressWarnings({"deprecation", "unchecked" })
	public void actionPerformed (ActionEvent event) {
		
		if(event.getSource()==loginButt) {
			landingCard.show(landingCentrePanel, "Login Page");
		}
		else if(event.getSource()==signUpButt) {
			landingCard.show(landingCentrePanel, "SignUp Page");
		}
		else if(event.getSource()==loginButton) {
			String staffName = func.staffLogin(loginEmail.getText(), loginPassword.getText());
			if(staffName !=null && !(staffName.equals(""))){
				func.getLocations();
				locationPage();
				centrePanel.add(dashboard(staffName), "Dashboard");
					mainCard.show(centrePanel, "Dashboard");
			}
			loginEmail.setText("");
			loginPassword.setText("");
		}
		else if(event.getSource()==signUpButton) {
			if(!(signUpName.getText().equals("")) && !(signUpEmail.getText().equals("")) && !(signUpPassword.getText().equals("")) && !(signUpConfirmPassword.getText().equals(""))) {
				
				if(signUpPassword.getText().equals(signUpConfirmPassword.getText())) {
					
					func.userRegistration(signUpName.getText(),signUpEmail.getText(),signUpPassword.getText());
					
					signUpName.setText("");
					signUpEmail.setText("");
					signUpPassword.setText("");
					signUpConfirmPassword.setText("");
					
					landingCard.show(landingCentrePanel, "Login Page");
					JOptionPane.showMessageDialog(null, "Successful!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Passwords not the same!");
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Please fill the required information!");
			}
			
		}
		else if(event.getSource()==logoutButt) {
			mainCard.show(centrePanel, "Landing Page");
		}
		else if(event.getSource()==locationButt) {
			locationPage();
		}
		else if(event.getSource()==deliveryButt) {
			deliveryNames = func.getDeliveryNames();
			
			deliveryDestinationName = func.getLocations(func.getDeliveryDestinationIds());
			
			deliveryPage();
		}
		else if(event.getSource()==addLocationButt) {
			if(!(locationName.getText().equals("")) && !(locationClearingCost.getText().equals(""))) {
				
				try {
					if(Integer.parseInt(locationClearingCost.getText()) >= 0) {
						
						if(addLocationButt.getText().equals("Add location")) {
							func.locatioinRegistration(locationName.getText(),Integer.parseInt(locationClearingCost.getText()));
							
							LinkedList <Integer> intermediates = new LinkedList<>();
							LinkedList <Integer> distance = new LinkedList<>();
							
							for(int i=0;i<locationNames.size();i++) {
								if(selectLocationCheck[i].isSelected()) {
									intermediates.add(locationIds.get(i));
									distance.add(Integer.parseInt(intermediateDistance[i].getText()));
								}
							}
							
							func.intermediatesRegistration(intermediates,distance);
							
							locationName.setText("");
							locationClearingCost.setText("");
							
							JOptionPane.showMessageDialog(null,"Location saved");
						}
						else {
							func.updateLocation(locationIdsEdit,locationName.getText(),Integer.parseInt(locationClearingCost.getText()));
							
							LinkedList <Integer> intermediates = new LinkedList<>();
							LinkedList <Integer> distance = new LinkedList<>();
							
							for(int i=0;i<locationNames.size();i++) {
								if(selectLocationCheck[i].isSelected()) {
									intermediates.add(locationIds.get(i));
									distance.add(Integer.parseInt(intermediateDistance[i].getText()));
								}
							}
							func.intermediatesRegistration(locationIdsEdit,intermediates,distance);
							JOptionPane.showMessageDialog(null,"Location updated");
						}
						
						
						func.getLocations();
						locationPage();
					}
					else {
						JOptionPane.showMessageDialog(null, "Only numbers are allowed in the Clearing Cost!");
					}
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Only numbers are allowed in the Clearing Cost!");
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Please fill the required information!");
			}
		}
		else if(event.getSource()==addDeliveryButt) {
			if(!(deliveryName.getText().equals("")) && (deliveryDestination.getSelectedIndex()!= 0)) {
				
				func.addNewDelivery(deliveryName.getText(),locationIds.get((deliveryDestination.getSelectedIndex()-1)));
				
				deliveryPage();
			}
			else {
				JOptionPane.showMessageDialog(null, "Please fill the required information!");
			}
				
		}
		else if(event.getSource()==generateButt) {
			if(originCombo.getSelectedIndex()!=0 && destinationCombo.getSelectedIndex()!=0) {
				ArrayList<LinkedList<Integer>> target = func.getTarget(locationIds);
				ArrayList<LinkedList<Integer>> distances = func.getDistances(locationIds);
				LinkedList<Integer> clearingCost = func.getClearingCost(locationIds);
				
				WeightedGraph graph = func.convertToGraph(clearingCost, distances, target);
				LinkedList<Integer> route = Dijkstra.route(graph, originCombo.getSelectedIndex()-1, destinationCombo.getSelectedIndex()-1);
				
				routeTextArea.setText(locationNames.get(locationIds.indexOf(route.get(0))));
				
				for(int i=1;i<route.size();i++) {
					routeTextArea.setText(routeTextArea.getText()+" ---> " + locationNames.get(route.get(0)));
				}
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Please fill the required information!");
			}
		}
	}

}
