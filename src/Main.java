import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();

        // Polymorphism: different objects in the same list
        list.add(new Person(1, "Aliya", 200000, 3));
        list.add(new Doctor(2, "Aisha", 500000, 10, "surgeon"));
        list.add(new Nurse(3, "Nurai", 150000, 2, 12));

        System.out.println("--- All employees ---");
        for (Person p : list) {
            System.out.println(p);
            p.work(); // Полиморфизм

            // Downcasting:
            if (p instanceof Doctor) {
                ((Doctor) p).surgery();
            }
            System.out.println("-------------------------");
        }
    }
}