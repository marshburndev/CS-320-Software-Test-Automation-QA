package test_services;

import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;

import services.AppointmentService;

class AppointmentServiceTest {

	//Test for adding an Appointment object. 
	@Test
	void addingAppointment() throws ParseException {
		AppointmentService appointment = new AppointmentService();
        Date tomorrow = new SimpleDateFormat("dd-mm-yyyy").parse("04-04-2024");
		appointment.addAppointment(tomorrow, "a description");
		assertEquals("1", appointment.appointments.get("1").getAppointmentId());
	}

    //Test for deleting a current Appointment object. 
	@Test
	void deletingAppointment() throws ParseException {
		AppointmentService appointment = new AppointmentService();
        Date tomorrow = new SimpleDateFormat("dd-mm-yyyy").parse("04-04-2024");
		appointment.addAppointment(tomorrow, "a description");
		appointment.deleteAppointment("1");
		assertFalse(appointment.appointments.containsKey("1"));
	}

}