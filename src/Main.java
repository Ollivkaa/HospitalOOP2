import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Patient> patients = new ArrayList<>();
    private static final ArrayList<Appointment> appointments = new ArrayList<>();
    private static final ArrayList<MedicalStaff> staffList = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    static void main() {
        addTestData();

        boolean run = true;
        while (run) {
            showMenu();
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> viewPatients();
                case 3 -> addDoctor();
                case 4 -> viewStaff(Doctor.class);
                case 5 -> addNurse();
                case 6 -> viewStaff(Nurse.class);
                case 7 -> addAppointment();
                case 8 -> viewAppointments();
                case 9 -> addStaff();
                case 10 -> viewStaff(null); // show all
                case 11 -> staffList.forEach(MedicalStaff::work);
                case 0 -> { System.out.println("Goodbye!"); run = false; }
                default -> System.out.println("Invalid choice!");
            }
            if (run) { System.out.println("Press Enter..."); sc.nextLine(); }
        }
    }

    private static void addAppointment() {
    }

    private static void addTestData() {
        patients.add(new Patient(1001, "Aidar Bekzhan", 25, "O+"));
        appointments.add(new Appointment(3001, "Aidar Bekzhan", "Dr. Samat Aliyev", "2025-01-15"));
        staffList.add(new Doctor(5001, "Samat Aliyev", "Cardiology", 10, "Heart"));
        staffList.add(new Nurse(5002, "Aigul Bekova", "Emergency", 6, 8));
    }

    private static void showMenu() {
        System.out.println("""
            1. Add Patient
            2. View Patients
            3. Add Doctor
            4. View Doctors
            5. Add Nurse
            6. View Nurses
            7. Add Appointment
            8. View Appointments
            9. Add Staff
            10. View All Staff
            11. Make Staff Work
            0. Exit
            Enter choice:""");
    }

    private static void addPatient() {
        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
        System.out.print("Blood: "); String blood = sc.nextLine();
        patients.add(new Patient(id, name, age, blood));
        System.out.println("Patient added!");
    }

    private static void addDoctor() { addStaffHelper("Doctor"); }
    private static void addNurse() { addStaffHelper("Nurse"); }
    private static void addStaff() { addStaffHelper("General"); }

    private static void addStaffHelper(String type) {
        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Dept: "); String dept = sc.nextLine();
        System.out.print("Exp: "); int exp = sc.nextInt(); sc.nextLine();

        MedicalStaff staff = switch(type) {
            case "Doctor" -> {
                System.out.print("Specialization: "); String spec = sc.nextLine();
                yield new Doctor(id, name, dept, exp, spec);
            }
            case "Nurse" -> {
                System.out.print("Patients assigned: "); int p = sc.nextInt(); sc.nextLine();
                yield new Nurse(id, name, dept, exp, p);
            }
            default -> new MedicalStaff(id, name, dept, exp);
        };
        staffList.add(staff);
        System.out.println(type + " added!");
    }

    private static void viewPatients() {
        if (patients.isEmpty()) { System.out.println("No patients."); return; }
        patients.forEach(p -> System.out.println(p.getFullName() + ", " + p.getAge() + "y, " + p.getBloodType()));
    }

    private static void viewAppointments() {
        if (appointments.isEmpty()) { System.out.println("No appointments."); return; }
        appointments.forEach(a -> System.out.println(a.getPatientName() + " -> " + a.getDoctorName() + " on " + a.getDate()));
    }

    private static void viewStaff(Class<?> type) {
        if (staffList.isEmpty()) { System.out.println("No staff."); return; }
        int count = 1;
        for (MedicalStaff s : staffList) {
            if (type == null || type.isInstance(s)) {
                System.out.println(count++ + ". " + s);
            }
        }
    }
}
