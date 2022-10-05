package services_test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;
import services.Appointment;

/* The appointment object shall have a required unique appointment ID String that cannot be longer than 10 characters. 
The appointment ID shall not be null and shall not be updatable.
The appointment object shall have a required appointment Date field. 
The appointmentDate field cannot be in the past. 
The appointmentDate field shall not be null. 
The appointment object shall have a required description String field that cannot be longer than 50 characters. 
The description field shall not be null. */

class AppointmentTest {

  private final String id = "1";
  private final String longerThanSpecifications =
    "idLongerThanTenCharsAndIdLongerThanFiftyCharsThisIsALongDescription";
  private final String empty = "";
  private String description = "description";

  // Testing ID requirements

  @Test
  void idWithinSpecifications() {
    Appointment appt = new Appointment(id, new Date(), description);
    assertEquals(id, appt.getAppointmentId());
  }

  @Test
  void idLongerThanTenChar() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Appointment(longerThanSpecifications, new Date(), description)
    );
  }

  @Test
  void nullIdException() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Appointment(empty, new Date(), description)
    );
  }

  // Testing Date requirements
  @Test
  void dateInPast() {
    assertThrows(
      IllegalArgumentException.class,
      () -> {
        Date past = new SimpleDateFormat("dd-mm-yyyy").parse("04-01-2022");
        new Appointment(empty, past, description);
      }
    );
  }

  @Test
  void nullDateException() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Appointment(empty, null, description)
    );
  }

  // Testing Description requirements

  @Test
  void descriptionWithinSpecifications() {
    Appointment appt = new Appointment(id, new Date(), description);
    assertEquals(description, appt.getDescription());
  }

  @Test
  void descriptionLongerThanTenChar() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Appointment(id, new Date(), longerThanSpecifications)
    );
  }

  @Test
  void descriptionNullException() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Appointment(id, new Date(), empty)
    );
  }
}
