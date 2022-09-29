package services;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;

/*The appointment service shall be able to add appointments with a unique appointmentId. 
The appointment service shall be able to delete appointments per appointmentId. */

public class AppointmentService {
	public Map<String, Appointment> appointments = new HashMap<>();// Creating HashMap to hold Appointment objects.
	int appointmentId = 0;// Is incremented in addApointment method to give a unique ID.

	// Add appointment method that constructs an appointment object.
	public void addAppointment(Date appointmentDate, String description) {
		appointmentId++;
		String newId = Integer.toString(appointmentId);
		Appointment newAppt = new Appointment(newId, appointmentDate, description);
		appointments.put(newAppt.getAppointmentId(), newAppt);
	}

	// Deletes appointment object.
	public void deleteAppointment(String appointmentId) {
		if (appointments.containsKey(appointmentId)) {
			appointments.remove(appointmentId);
		}
	}
}