package Smart_City_Resource_Management;

class PublicTransport extends Resource {
    public PublicTransport() { super("Public Transport"); }

    @Override
    public void allocate(double amount) {
        Usage += amount;
        System.out.println("Allocated " + amount + " rides of public transport.");
    }

    @Override
    public void release(double amount) {
        Usage -= amount;
        System.out.println("Released " + amount + " rides of public transport.");
    }
}
