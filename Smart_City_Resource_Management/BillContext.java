package Smart_City_Resource_Management;

class BillContext {
    private BillingStrategy strategy;

    public void setStrategy(BillingStrategy strategy) {
        this.strategy = strategy;
    }

    public double executeStrategy(double usage) {
        return strategy.calculateBill(usage);
    }
}
