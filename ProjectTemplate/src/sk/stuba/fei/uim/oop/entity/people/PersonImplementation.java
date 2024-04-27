package sk.stuba.fei.uim.oop.entity.people;

import sk.stuba.fei.uim.oop.entity.organization.OrganizationInterface;

import java.util.HashSet;
import java.util.Set;

import static sk.stuba.fei.uim.oop.utility.Constants.MAX_EMPLOYMENT_PER_AGENCY;

public class PersonImplementation implements PersonInterface {
    String name;
    String address;
    Set<OrganizationInterface> employers = new HashSet<>();
    int jobType; //uvazok - can have 1-5 values
    int maxEmployment = MAX_EMPLOYMENT_PER_AGENCY;
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(String address) {
        this.address=address;
    }

    @Override
    public void addEmployer(OrganizationInterface organization) {
        employers.add(organization);
    }

    @Override
    public Set<OrganizationInterface> getEmployers() {
        return employers;
    }
}
