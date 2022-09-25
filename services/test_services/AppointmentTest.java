package test_services;

import static org.junit.jupiter.api.Assertions.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import services.Appointment;

class AppointmentTest {
	private String description = "description";
	// Testing ID requirements

	@Test
	void idWithOneChar() {
		Appointment appt = new Appointment("1", new Date(), description);
		assertEquals("1", appt.getAppointmentId());
	}

	@Test
	void idWithTenChar() {
		Appointment appt = new Appointment("5555555555", new Date(), description);
		assertEquals("5555555555", appt.getAppointmentId());
	}

	@Test
	void idLongerThanTenChar() {
		assertThrows(IllegalArgumentException.class, () -> new Appointment("55555555555", new Date(), description));
	}

	@Test
	void nullIdException() {
		assertThrows(IllegalArgumentException.class, () -> new Appointment("", new Date(), description));
	}

	// Testing Date requirements
	@Test
	void dateInPast() {
		assertThrows(IllegalArgumentException.class, () -> {
			Date past = new SimpleDateFormat("dd-mm-yyyy").parse("04-01-2022");
			new Appointment("", past, description);
		});
	}

	@Test
	void nullDateException() {
		assertThrows(IllegalArgumentException.class, () -> new Appointment("", null, description));
	}

	// Testing Description requirements

	@Test
	void descriptionWithOneChar() {
		Appointment appt = new Appointment("a", new Date(), "a");
		assertEquals("a", appt.getDescription());
	}

	@Test
	void descriptionLongerThanFiftyChar() {
		assertThrows(IllegalArgumentException.class,
				() -> new Appointment("1", new Date(), "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}

	@Test
	void descriptionNullException() {
		assertThrows(IllegalArgumentException.class, () -> new Appointment("1", new Date(), ""));
	}
}
