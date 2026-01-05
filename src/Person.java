public class Person {
    protected int id;
    protected String name;
    protected double salary;
    protected int exp;

    public Person(int id, String name, double salary, int exp) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.exp = exp;
    }

    public void work() {
        System.out.println(name + " working ");
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ", experience: " + exp + " years)";
    }
}

