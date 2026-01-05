public class Doctor extends Person {
    private String spec;

    public Doctor(int id, String name, double salary, int exp, String spec) {
        super(id, name, salary, exp);
        this.spec = spec;
    }

    @Override
    public void work() {
        System.out.println("Doctor " + name + " is seeing patients");
    }

    public void surgery() {
        System.out.println(name + " having surgery");
    }

    @Override
    public String toString() {
        return super.toString() + " |Specialty: " + spec;
    }
}