package customer_services;

import java.util.HashMap;
import java.util.Date;

public class AppointmentService {
	public HashMap<String, Appointment> appointments = new HashMap<String, Appointment>();//Creating HashMap to hold Appointment objects. 
	int ID = 0;//Is incremented in addApointment method to give a unique ID. 
	
	//Add appointment method that constructs an appointment object.  
	public void addAppointment(Date appointmentDate, String description) {
		ID++;
		String newID = Integer.toString(ID);
		Appointment newAppt = new Appointment(newID, appointmentDate, description);
		appointments.put(newAppt.getAppointmentId(), newAppt);
	}
	
	//Deletes appointment object. 
	public void deleteAppointment(String ID) {
		if(appointments.containsKey(ID)) {
			appointments.remove(ID);
		}
	}
}