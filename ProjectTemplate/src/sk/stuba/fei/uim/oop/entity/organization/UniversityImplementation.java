package sk.stuba.fei.uim.oop.entity.organization;

import sk.stuba.fei.uim.oop.entity.grant.ProjectInterface;
import sk.stuba.fei.uim.oop.entity.people.PersonInterface;

import java.util.*;

public class UniversityImplementation implements OrganizationInterface {
    public Set<PersonInterface> employees = new HashSet<>();
    public Map<PersonInterface, Integer> employments = new HashMap<>();
    public Map<ProjectInterface, Integer> yearOfProject = new HashMap<>();

    private Set<ProjectInterface> projects = new HashSet<>();
    private String name;

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
        return projects; //projects are never added to ORG, solve that!
    }

    @Override
    public Set<ProjectInterface> getRunningProjects(int year) {
        Set<ProjectInterface> projectsOfYear = new HashSet<>();
        for (Map.Entry<ProjectInterface, Integer> entry : yearOfProject.entrySet()) {
            int startYear = entry.getKey().getStartingYear();
            int endYear = entry.getKey().getEndingYear();
            if((startYear < year) && (endYear > year)) {
                projectsOfYear.add(entry.getKey());
            }
        }
        return projectsOfYear;
    }

    @Override
    public void registerProjectInOrganization(ProjectInterface project) {
        projects.add(project);
        yearOfProject.put(project,project.getStartingYear());
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
}
