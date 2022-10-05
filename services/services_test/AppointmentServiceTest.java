package services_test;

import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;

import services.AppointmentService;

/*The appointment service shall be able to add appointments with a unique appointmentId. 
The appointment service shall be able to delete appointments per appointmentId. */

class AppointmentServiceTest {
	private final String description = "a description";
	private final String id = "1";

	// Test for adding an Appointment object.
	@Test
	void addingAppointment() throws ParseException {
		AppointmentService appointment = new AppointmentService();
		Date tomorrow = new SimpleDateFormat("dd-mm-yyyy").parse("04-04-2024");
		appointment.addAppointment(tomorrow, description);
		assertEquals("1", appointment.appointments.get(id).getAppointmentId());
	}

	// Test for deleting a current Appointment object.
	@Test
	void deletingAppointment() throws ParseException {
		AppointmentService appointment = new AppointmentService();
		Date tomorrow = new SimpleDateFormat("dd-mm-yyyy").parse("04-04-2024");
		appointment.addAppointment(tomorrow, description);
		appointment.deleteAppointment(id);
		assertFalse(appointment.appointments.containsKey(id));
	}

}