package sk.stuba.fei.uim.oop.entity.grant;

import sk.stuba.fei.uim.oop.entity.organization.OrganizationInterface;
import sk.stuba.fei.uim.oop.entity.people.PersonInterface;

import java.util.HashSet;
import java.util.Set;

import static sk.stuba.fei.uim.oop.utility.Constants.PROJECT_DURATION_IN_YEARS;

public class ProjectImplementation implements ProjectInterface {

    private String projectName;
    private Set<PersonInterface> participants = new HashSet<>();
    private int startYear;
    private int endYear=startYear+PROJECT_DURATION_IN_YEARS-1;

    int duration = endYear-startYear+1; // or no + 1
    OrganizationInterface applicantOrg;
    int budget;
    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public void setProjectName(String name) {
        this.projectName=name;
    }

    @Override
    public int getStartingYear() {
        return startYear;
    }

    @Override
    public void setStartingYear(int year) {
        this.startYear = year;
        endYear=startYear+PROJECT_DURATION_IN_YEARS-1;
    }

    @Override
    public int getEndingYear() {
        endYear=startYear+PROJECT_DURATION_IN_YEARS-1;
        return endYear;
    }

    @Override
    public int getBudgetForYear(int year) {
        return 0;
    }

    @Override
    public void setBudgetForYear(int year, int budget) {

    }

    @Override
    public int getTotalBudget() {
        return budget;
    }

    @Override
    public void addParticipant(PersonInterface participant) {
        this.participants.add(participant);
    }

    @Override
    public Set<PersonInterface> getAllParticipants() {
        return participants;
    }

    @Override
    public OrganizationInterface getApplicant() {
        return applicantOrg;
    }

    @Override
    public void setApplicant(OrganizationInterface applicant) {
        applicantOrg=applicant;
    }
    public ProjectImplementation(){
        budget=0;
    }
}
