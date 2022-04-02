package appointment_service;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class AppointmentTest {
	
	//Testing ID requirements

	@Test
	void IdWithOneChar() {
		Appointment appt = new Appointment("1", new Date(), "a description");
		assertEquals("1", appt.getAppointmentId());
	}
	
	@Test
	void IdWithTenChar() {
		Appointment appt = new Appointment("5555555555", new Date(), "a description");
		assertEquals("5555555555", appt.getAppointmentId());
	}
	
	@Test
	void IdLongerThanTenChar() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("55555555555", new Date(), "a description");
		});
	}
	
	@Test
	void NullIDException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("", new Date(), "a description");
		});
	}
	
	//Testing Date requirements
	@Test
	void DateInPast() {
		assertThrows(IllegalArgumentException.class, () -> {
			Date past = new SimpleDateFormat("dd-mm-yyyy").parse("04-01-2022");
			new Appointment("", past, "a description");
		});
	}
	
	@Test
	void NullDateException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("", null, "a description");
		});
	}
	
	//Testing Description requirements
	
	@Test
	void DescriptionWithOneChar() {
		Appointment appt = new Appointment("a", new Date(), "a");
		assertEquals("a", appt.getDescription());
	}
	
	
	@Test
	void DescriptionLongerThanFiftyChar() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1", new Date(), "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		});
	}
	
	@Test
	void DescriptionNullException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1", new Date(), "");
		});
	}
}
