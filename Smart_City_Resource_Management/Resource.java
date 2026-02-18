package Smart_City_Resource_Management;

abstract class Resource {
    protected String Name;
    protected double Usage;
    public Resource(String Name){
        this.Name=Name;
    }
    public abstract void allocate(double amount);
    public abstract void release(double amount);

    public String getName() {return Name;}
    public double getUsage() {return Usage;}

}
