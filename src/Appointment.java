public class Appointment {
    private int appointmentId;
    private String patientName;
    private String doctorName;
    private String date;

    public Appointment(int appointmentId, String patientName, String doctorName, String date) {
        setAppointmentId(appointmentId);
        setPatientName(patientName);
        setDoctorName(doctorName);
        setDate(date);
    }

    // Getters
    public int getAppointmentId() { return appointmentId; }
    public String getPatientName() { return patientName; }
    public String getDoctorName() { return doctorName; }
    public String getDate() { return date; }

    // Setters with validation
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId > 0 ? appointmentId : 0;
    }

    public void setPatientName(String patientName) {
        if (patientName != null && !patientName.trim().isEmpty()) this.patientName = patientName;
    }

    public void setDoctorName(String doctorName) {
        if (doctorName != null && !doctorName.trim().isEmpty()) this.doctorName = doctorName;
    }

    public void setDate(String date) {
        if (date != null && !date.trim().isEmpty()) this.date = date;
    }

    // Additional methods
    public boolean isCancelled() {
        return date != null && date.equals("CANCELLED");
    }

    @Override
    public String toString() {
        return patientName + " -> " + doctorName + " on " + date +
                (isCancelled() ? " [CANCELLED]" : "");
    }
}
