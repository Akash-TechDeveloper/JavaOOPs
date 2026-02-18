package Smart_City_Resource_Management;

public class SmartCity {
    public static void main(String[] args) {
        Resource electricity = new Electricity();
        Resource water = new Water();
        Resource transport = new PublicTransport();

        electricity.allocate(100);
        water.allocate(250);
        transport.allocate(75);

        BillContext billing = new BillContext();

        billing.setStrategy(new ResidentBilling());
        System.out.println("Residential Bill (Electricity): $" + billing.executeStrategy(electricity.getUsage()));

        billing.setStrategy(new IndustrialBilling());
        System.out.println("Industrial Bill (Water): $" + billing.executeStrategy(water.getUsage()));

        billing.setStrategy(new ResidentBilling());
        System.out.println("Residential Bill (Transport): $" + billing.executeStrategy(transport.getUsage()));
    }
}
