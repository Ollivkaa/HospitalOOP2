public class Patient {
    private int patientId;
    private String fullName;
    private int age;
    private String bloodType;

    public Patient(int patientId, String fullName, int age, String bloodType) {
        setPatientId(patientId);
        setFullName(fullName);
        setAge(age);
        setBloodType(bloodType);
    }

    // Getters
    public int getPatientId() { return patientId; }
    public String getFullName() { return fullName; }
    public int getAge() { return age; }
    public String getBloodType() { return bloodType; }

    // Setters with validation
    public void setPatientId(int patientId) {
        this.patientId = patientId > 0 ? patientId : 0;
    }

    public void setFullName(String fullName) {
        if (fullName != null && !fullName.trim().isEmpty()) {
            this.fullName = fullName;
        }
    }

    public void setAge(int age) {
        this.age = (age >= 0 && age <= 150) ? age : 0;
    }

    public void setBloodType(String bloodType) {
        if (bloodType != null && (
                bloodType.equals("A+") || bloodType.equals("A-") ||
                        bloodType.equals("B+") || bloodType.equals("B-") ||
                        bloodType.equals("AB+") || bloodType.equals("AB-") ||
                        bloodType.equals("O+") || bloodType.equals("O-")
        )) {
            this.bloodType = bloodType;
        } else {
            this.bloodType = "Unknown";
        }
    }

    // Additional methods
    public boolean isMinor() {
        return age < 18;
    }

    public String getAgeCategory() {
        if (age < 18) return "Child";
        else if (age < 65) return "Adult";
        else return "Senior";
    }

    @Override
    public String toString() {
        return fullName + " (ID:" + patientId + ", Age:" + age + ", Blood:" + bloodType + ")";
    }
}

