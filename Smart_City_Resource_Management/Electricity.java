package Smart_City_Resource_Management;

class Electricity extends Resource {
    public Electricity() { super("Electricity"); }

    @Override
    public void allocate(double amount) {
        Usage += amount;
        System.out.println("Allocated " + amount + " units of electricity.");
    }

    @Override
    public void release(double amount) {
        Usage -= amount;
        System.out.println("Released " + amount + " units of electricity.");
    }
}
