import java.sql.*;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Functions {
	
	//Staff login
	public String staffLogin(String email, String password){
		String name="";
		try {
			PreparedStatement prs = Connector.localConnector().prepareStatement("SELECT name FROM user WHERE email =? AND password=? ORDER BY id ASC");
			
			prs.setString(1, email);
			prs.setString(2, password);
			
			ResultSet rSet = prs.executeQuery();
			
			rSet.next();
			
			name = rSet.getString("name");
			
			if(!(name.equals(null))) {
				JOptionPane.showMessageDialog(null, "Welcome "+name+"!");
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid credentials");
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
		return name;
		
	}

	// User Registration method
	public void userRegistration(String name, String email, String password) {
		try {
			
			PreparedStatement prs = Connector.localConnector().prepareStatement("INSERT INTO user (name,email,password) VALUES(?,?,?)");
			
			prs.setString(1, name.toUpperCase());
			prs.setString(2,email);
			prs.setString(3, password);
			
			prs.executeUpdate();
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
	}
	
	// User Registration method
	public void locatioinRegistration(String name, int clearingCost) {
		try {
			
			PreparedStatement prs = Connector.localConnector().prepareStatement("INSERT INTO location (name,clearing_cost) VALUES(?,?)");
			
			prs.setString(1, name);
			prs.setInt(2, clearingCost);
			
			prs.executeUpdate();
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
	}
	
	// Method to get all added locations from the database.
	public void getLocations() {
		GUI.locationNames = new LinkedList<String>();
		GUI.locationIds = new LinkedList<Integer>();
		GUI.locationClearingCosts = new LinkedList<Integer>();
		
		try {
			PreparedStatement prs = Connector.localConnector().prepareStatement("SELECT * FROM location ORDER BY id ASC");
			
			ResultSet rSet = prs.executeQuery();
			
			while(rSet.next()) {
				GUI.locationNames.add(rSet.getString("name"));
				GUI.locationIds.add(rSet.getInt("id"));
				GUI.locationClearingCosts.add(rSet.getInt("clearing_cost"));
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
		
	}
	// Getting the id of the last saved location from the database
	public int getLastLocation() {
		int lastLocation = 0;
		try {
			PreparedStatement prs = Connector.localConnector().prepareStatement("SELECT * FROM location ORDER BY id ASC");
			
			ResultSet rSet = prs.executeQuery();
			
			while(rSet.next()) {
				lastLocation = rSet.getInt("id");
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
		return lastLocation;
	}
	
	//This Method helps to register all the intermediate locations to a newly registered location.
	public void intermediatesRegistration(LinkedList <Integer>intermediates, LinkedList <Integer>distance){
		int lastLocation = getLastLocation();
		
		for(int i=0;i<intermediates.size();i++) {
			try {
				
				PreparedStatement prs = Connector.localConnector().prepareStatement("INSERT INTO path (location_id,intermediate_id,distance) VALUES(?,?,?)");
				
				prs.setInt(1, lastLocation);
				prs.setInt(2, intermediates.get(i));
				prs.setInt(3, distance.get(i));
				
				prs.executeUpdate();
				
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
				e.printStackTrace();
			}
		}
	}
	
	//This Method helps to register all the intermediate locations to a newly registered location.
	public void intermediatesRegistration(int locationIdsEdit, LinkedList <Integer>intermediates, LinkedList <Integer>distance){
		
		for(int i=0;i<intermediates.size();i++) {
			try {
				
				PreparedStatement prs = Connector.localConnector().prepareStatement("INSERT INTO path (location_id,intermediate_id,distance) VALUES(?,?,?)");
				
				prs.setInt(1, locationIdsEdit);
				prs.setInt(2, intermediates.get(i));
				prs.setInt(3, distance.get(i));
				
				prs.executeUpdate();
				
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
				e.printStackTrace();
			}
		}
	}
	
	// Method to update locations in the database
	public void updateLocation(int index, String name, int clearing_cost){
		
		try {
			PreparedStatement prs = Connector.localConnector().prepareStatement("DELETE FROM path WHERE location_id=?");
			
			prs.setInt(1, index);
			prs.executeUpdate();
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
		
		
		try {
			PreparedStatement prs = Connector.localConnector().prepareStatement("UPDATE location SET name = ?, clearing_cost=? WHERE id=?");
			
			prs.setString(1, name);
			prs.setInt(2, clearing_cost);
			prs.setInt(3, index);
			prs.executeUpdate();
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
	}
	
	// Method to remove locations in the database
	public void removeLocation(int index){
		
		try {
			PreparedStatement prs = Connector.localConnector().prepareStatement("DELETE FROM path WHERE location_id=?");
			
			prs.setInt(1, index);
			prs.executeUpdate();
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
		
		try {
			PreparedStatement prs = Connector.localConnector().prepareStatement("DELETE FROM location WHERE id=?");
			
			prs.setInt(1, index);
			prs.executeUpdate();
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
	}
	
	//This method helps to get the ID of all the Locations of Package deliveries from the database.
	@SuppressWarnings("rawtypes")
	public LinkedList getDeliveryDestinationIds() {
		LinkedList <Integer> deliveryDestinationNames = new LinkedList<Integer>();
		
		try {
			PreparedStatement prs = Connector.localConnector().prepareStatement("SELECT location_id FROM delivery ORDER BY id ASC");
			
			ResultSet rSet = prs.executeQuery();
			
			while(rSet.next()) {
				deliveryDestinationNames.add(rSet.getInt("location_id"));
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
		
		return deliveryDestinationNames;
	}
	//This method helps to get all the Locations of Package deliveries from the database.
	@SuppressWarnings("rawtypes")
	public LinkedList getDeliveryNames() {
		LinkedList <String> deliveryNames = new LinkedList<String>();
		
		try {
			PreparedStatement prs = Connector.localConnector().prepareStatement("SELECT name FROM delivery ORDER BY id ASC");
			
			ResultSet rSet = prs.executeQuery();
			
			while(rSet.next()) {
				deliveryNames.add(rSet.getString("name"));
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
		
		return deliveryNames;
	}
	
	
	/**
	 * This method helps me to retrieve only the names of some locations
	 * taken:
	 * @param locationIds been a linked list as it parameter and 
	 * @return locationIds as a Linked List
	 */
	@SuppressWarnings("rawtypes")
	public LinkedList<String> getLocations(LinkedList locationIds){
		LinkedList<String> locationNames = new LinkedList<String>();
		
		for(int i=0;i<locationIds.size();i++) {
			try {
				PreparedStatement prs = Connector.localConnector().prepareStatement("SELECT name FROM location WHERE id=? ORDER BY id ASC");
				
				prs.setInt(1, (int)locationIds.get(i));
				ResultSet rSet = prs.executeQuery();
				
				rSet.next();
				locationNames.add(rSet.getString("name"));
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
				e.printStackTrace();
			}
		}
		
		return locationNames;
	}
	
	public void addNewDelivery(String name, int locationId) {
		try {
			
			PreparedStatement prs = Connector.localConnector().prepareStatement("INSERT INTO delivery (name,location_id) VALUES(?,?)");
			
			prs.setString(1, name);
			prs.setInt(2, locationId);
			
			prs.executeUpdate();
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
	}
	
	//This method retrieves and returns the list of path from the Database
	public getPath(LinkedList locationIds) {
		
		
		
	}
}
