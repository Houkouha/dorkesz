package sk.stuba.fei.uim.oop.entity.organization;

import sk.stuba.fei.uim.oop.entity.grant.ProjectInterface;
import sk.stuba.fei.uim.oop.entity.people.PersonInterface;

import java.util.*;

import static sk.stuba.fei.uim.oop.utility.Constants.COMPANY_INIT_OWN_RESOURCES;

public class CompanyImplementation implements OrganizationInterface {
    public Set<PersonInterface> employees = new HashSet<>();
    public Map<PersonInterface, Integer> employments = new LinkedHashMap<>();
    private Set<ProjectInterface> projects = new HashSet<>();
    private String name;
    int maxFinances;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public void addEmployee(PersonInterface p, int employment) {
        this.employees.add(p);
        this.employments.put(p,employment);
    }

    @Override
    public Set<PersonInterface> getEmployees() {
        return employees;
    }

    @Override
    public int getEmploymentForEmployee(PersonInterface p) {
        int employmentYears=0;
        List<Integer> grantsOfYear = new ArrayList<>();
        for (Map.Entry<PersonInterface, Integer> entry : employments.entrySet()) {
            if (entry.getKey() == p) {
                employmentYears= entry.getValue();
            }
        }
        return employmentYears;
    }

    @Override
    public Set<ProjectInterface> getAllProjects() {
        return null;
    }

    @Override
    public Set<ProjectInterface> getRunningProjects(int year) {
        return null;
    }

    @Override
    public void registerProjectInOrganization(ProjectInterface project) {
        projects.add(project);
    }
    @Override
    public int getProjectBudget(ProjectInterface pi) {
        return 0;
    }

    @Override
    public int getBudgetForAllProjects() {
        return 0;
    }

    @Override
    public void projectBudgetUpdateNotification(ProjectInterface pi, int year, int budgetForYear) {

    }

    public CompanyImplementation(){
        maxFinances=COMPANY_INIT_OWN_RESOURCES;
    }
}
