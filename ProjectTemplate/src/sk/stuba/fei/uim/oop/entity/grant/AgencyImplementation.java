package sk.stuba.fei.uim.oop.entity.grant;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AgencyImplementation implements AgencyInterface {
    public String agencyName;
    public Map<GrantInterface, Integer> yearsOfGrants = new HashMap<>();
    public Set<GrantInterface> grants = new HashSet<>();

    @Override
    public String getName() {
        return agencyName;
    }

    @Override
    public void setName(String name) {
        this.agencyName=name;

    }
    @Override
    public void addGrant(GrantInterface gi, int year) {
        yearsOfGrants.put(gi, year);
        grants.add(gi);
    }

    @Override
    public Set<GrantInterface> getAllGrants() {
        return grants;
    }

    @Override
    public Set<GrantInterface> getGrantsIssuedInYear(int year) {
        Set<GrantInterface> grantsOfYear = new HashSet<>();
        for (Map.Entry<GrantInterface, Integer> entry : yearsOfGrants.entrySet()) {
            if (entry.getValue() == year) {
                GrantInterface grant = entry.getKey();
                grantsOfYear.add(grant);
            }
        }
        return grantsOfYear;
    }
    public AgencyImplementation() {
        grants = new HashSet<>();
        yearsOfGrants = new HashMap<>();
    }
    public AgencyImplementation(String name) {
        agencyName = name;
    }
}
