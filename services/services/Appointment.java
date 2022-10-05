package services;

import java.util.Date;

/* The appointment object shall have a required unique appointment ID String that cannot be longer than 10 characters. 
The appointment ID shall not be null and shall not be updatable.
The appointment object shall have a required appointment Date field. 
The appointmentDate field cannot be in the past. 
The appointmentDate field shall not be null. 
The appointment object shall have a required description String field that cannot be longer than 50 characters. 
The description field shall not be null. */

public class Appointment {
	private final String appointmentId;
	private final Date appointmentDate;
	private final String description;

	// Validating fields per requirements.
	public boolean idValidation(String id) {
		//Id length can be no longer than 10 characters
		int idLength = 10;
		return !id.isEmpty() && id.length() <= idLength;
	}

	public boolean checkDate(Date appointmentDate) {
		if (appointmentDate == null) {
			return false;
		} else if (appointmentDate.before(new Date())) {
			return false;
		} else {
			return true;
		}
	}

	public boolean descriptionValidation(String description) {
		//Description can be no longer than 50 characters.
		int descriptionLength = 50;
		return !description.isEmpty() && description.length() <= descriptionLength;
	}

	// Constructor that utilizes validation methods to ensure requirements are met.
	public Appointment(String appointmentId, Date appointmentDate, String description) throws IllegalArgumentException {
		if (this.idValidation(appointmentId)) {
			this.appointmentId = appointmentId;
		} else {
			throw new IllegalArgumentException("Invalid ID, too long.");
		}

		if (!this.checkDate(appointmentDate)) {
			throw new IllegalArgumentException("Invalid Date.");
		} else {
			this.appointmentDate = appointmentDate;
		}

		if (this.descriptionValidation(description)) {
			this.description = description;
		} else {
			throw new IllegalArgumentException("Invalid description, too long.");
		}
	}

	// Getters.
	public String getAppointmentId() {
		return this.appointmentId;
	}

	public Date getAppointmentDate() {
		return this.appointmentDate;
	}

	public String getDescription() {
		return this.description;
	}
}
