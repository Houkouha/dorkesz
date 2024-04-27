package sk.stuba.fei.uim.oop.entity.grant;

import sk.stuba.fei.uim.oop.entity.organization.OrganizationInterface;
import sk.stuba.fei.uim.oop.entity.people.PersonInterface;

import java.util.HashSet;
import java.util.Set;

public class GrantImplementation implements GrantInterface {
    String ID;
    int year;
    AgencyInterface agency;
    GrantState state;
    int budget;
    Set<ProjectInterface> registeredProjects = new HashSet<ProjectInterface>();

    @Override
    public String getIdentifier() {
        return this.ID;
    }

    @Override
    public void setIdentifier(String identifier) {
        this.ID=identifier;
    }

    @Override
    public int getYear() {
        return this.year;
    }

    @Override
    public void setYear(int year) {
        this.year=year;
    }

    @Override
    public AgencyInterface getAgency() {
        return this.agency;
    }

    @Override
    public void setAgency(AgencyInterface agency) {
        this.agency=agency;
    }

    @Override
    public int getBudget() {
        return this.budget;
    }

    @Override
    public void setBudget(int budget) {
        this.budget=budget;
    }

    @Override
    public int getRemainingBudget() {
        return 0;
    }

    @Override
    public int getBudgetForProject(ProjectInterface project) {
        return project.getTotalBudget();
    }

    @Override
    public boolean registerProject(ProjectInterface project) {
        if(state==GrantState.STARTED) {
            if(project.getApplicant()==null && !((project.getAllParticipants()).isEmpty()) && (project.getStartingYear()==this.year)){
//                System.out.println(project.getApplicant());
                Set<PersonInterface> applicants = project.getAllParticipants();
                // Iterator<PersonInterface> applicant = applicants.iterator();
                for(PersonInterface a : applicants) {
                    Set<OrganizationInterface> employers = a.getEmployers();
                    if (!(employers.contains(project.getApplicant()))) {
                        System.out.println("Not all participants are employed by the applicant.");
                        return false;
                    }
                }
                if(!registeredProjects.add(project))
                {
                    System.out.println("Project has been already added to grant.");
                }
//                for (ProjectInterface p : registeredProjects) {
//                    String name = p.getProjectName();
//                    System.out.println(name);}f
                return true;
            }
            System.out.println("There is either no applicant or participants or the start years do not match.");
        }
        System.out.println("Grant is not open for the registration of projects.");
        return false;
    }

    @Override
    public Set<ProjectInterface> getRegisteredProjects() {
        return registeredProjects;
    }

    @Override
    public GrantState getState() {
        return this.state;
    }

    @Override
    public void callForProjects() {
        this.state=GrantState.STARTED;

    }

    @Override
    public void evaluateProjects() {
        this.state=GrantState.EVALUATING;
        //checkNumOfParticipants();


    }

    @Override
    public void closeGrant() {

    }
    public GrantImplementation() {

    }
    public GrantImplementation(String ID, int year, AgencyInterface agency, int budget){
        this.ID= ID;
        this.year= year;
        this.agency= agency;
        this.budget= budget;
    }
}
