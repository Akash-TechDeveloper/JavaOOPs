package Smart_City_Resource_Management;

interface BillingStrategy {
    double calculateBill (double Usage);
}
class IndustrialBilling implements BillingStrategy {
    public double calculateBill(double usage) {
        return usage * 1.5;
    }
}
class ResidentBilling implements BillingStrategy{
    public double calculateBill(double usage) {
        return usage * 2;
    }

}
