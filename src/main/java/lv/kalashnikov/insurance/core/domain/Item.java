package lv.kalashnikov.insurance.core.domain;

public class Item {

    private String name;
    private double insuranceAmount;
    private RiskType type;

    public Item() {}

    public Item(String name, double insuranceAmount, RiskType type) {
        this.name = name;
        this.insuranceAmount = insuranceAmount;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(double insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public RiskType getType() {
        return type;
    }

    public void setType(RiskType type) {
        this.type = type;
    }

}