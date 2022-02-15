package lv.kalashnikov.insurance.core.domain;

import java.util.List;

public class Policy {

    private String policyNumber;
    private boolean isApproved;
    private List<Entity> entities;

    public Policy() {}

    public Policy(String policyNumber, boolean isApproved, List<Entity> entities) {
        this.policyNumber = policyNumber;
        this.isApproved = isApproved;
        this.entities = entities;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

}