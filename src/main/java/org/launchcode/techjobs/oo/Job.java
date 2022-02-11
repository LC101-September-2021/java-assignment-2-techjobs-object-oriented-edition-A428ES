package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;
    private int emptyFields;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job(){
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employerVar, Location locationVar, PositionType positionVar, CoreCompetency coreVar){
        this();

        this.name = name;
        employer = employerVar;
        location = locationVar;
        positionType = positionVar;
        coreCompetency = coreVar;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public String checkEmpty(String chk){
        if(chk.isBlank()){
            this.emptyFields++;
            return "Data not available";
        } else {
            return chk;
        }
    }
    @Override
    public String toString() {
        String returnStr = "\n" +
                "ID: " + id + "\n" +
                "Name: " + checkEmpty(name) + "\n" +
                "Employer: " + checkEmpty(employer.getValue()) + "\n" +
                "Location: " + checkEmpty(location.getValue()) + "\n" +
                "Position Type: " + checkEmpty(positionType.getValue()) + "\n" +
                "Core Competency: " + checkEmpty(coreCompetency.getValue()) + "\n";

        if(this.emptyFields == 5){
            return "OOPS! This job does not seem to exist.";
        } else {
            return returnStr;
        }
    }
}
