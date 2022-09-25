package services;

import java.util.Date;

public class Appointment {
	private String appointmentId;
	private Date appointmentDate;
	private String description;

	// Validating fields per requirements.
	public boolean idValidation(String id) {
		if (id.isEmpty()) {
			return false;
		} else if (id.length() > 10) {
			return false;
		} else {
			return true;
		}
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
		if (description.isEmpty()) {
			return false;
		} else if (description.length() > 50) {
			return false;
		} else {
			return true;
		}
	}

	// Constructor that utilizes validation methods to ensure requirements are met.
	public Appointment(String appointmentId, Date appointmentDate, String description) throws IllegalArgumentException {
		if (this.idValidation(appointmentId)) {
			this.appointmentId = appointmentId;
		} else {
			throw new IllegalArgumentException("Invalid ID, too long.");
		}

		if (this.checkDate(appointmentDate)) {
			this.appointmentDate = appointmentDate;
		} else {
			throw new IllegalArgumentException("Invalid Date.");
		}

		if (this.descriptionValidation(description)) {
			this.description = description;
		} else {
			throw new IllegalArgumentException("Invalid description, too long.");
		}
	}

	// Getters.
	public String getAppointmentId() {
		return appointmentId;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public String getDescription() {
		return description;
	}
}