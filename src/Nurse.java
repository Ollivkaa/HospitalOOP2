public class Nurse extends Person {
    private int hours;

    public Nurse(int id, String name, double salary, int exp, int hours) {
        super(id, name, salary, exp);
        this.hours = hours;
    }

    @Override
    public void work() {
        System.out.println("Nurse " + name + " giving an ingection");
    }

    @Override
    public String toString() {
        return super.toString() + " |duty: " + hours + "hour";
    }
}