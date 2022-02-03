package org.launchcode.techjobs.oo.test;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.*;
import static org.junit.Assert.*;
import org.launchcode.techjobs.oo.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    Job jobsTest;
    Job jobsTestTwo;

    @Before
    public void createEntry(){
        jobsTest = new Job();
        jobsTestTwo = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertFalse(jobsTest.equals(jobsTestTwo));
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(newJob.getName().equals("Product tester"));
        assertTrue(newJob.getEmployer() instanceof Employer);
        assertTrue(newJob.getLocation() instanceof Location);
        assertTrue(newJob.getPositionType() instanceof PositionType);
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);

        assertTrue(newJob.getEmployer().getValue().equals("ACME"));
        assertTrue(newJob.getLocation().getValue().equals("Desert"));
        assertTrue(newJob.getPositionType().getValue().equals("Quality control"));
        assertTrue(newJob.getCoreCompetency().getValue().equals("Persistence"));
    }

    @Test
    public void testJobsForEquality(){
        Job newJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Job newJobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(newJobOne.equals(newJobTwo));
    }

    @Test
    public void testToString(){
        Job newJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String[] splitString = newJobOne.toString().split("\n", -1);

        assertTrue(splitString[0].isBlank());
        assertTrue(splitString[splitString.length-1].isBlank());
    }

    @Test
    public void testFields(){
        Job newJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String compareStr = "\n" +
                "ID: " + newJobOne.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";

        assertTrue(newJobOne.toString().equals((compareStr)));
    }

    @Test
    public void emptyField(){
        Job newJobOne = new Job("Product tester", new Employer(""), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String compareStr = "\n" +
                "ID: " + newJobOne.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: Data not available\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";

        assertTrue(newJobOne.toString().equals(compareStr));
    }

    @Test
    public void invalidEntry(){
        Job newJobOne = new Job("", new Employer(""), new Location(""),
                new PositionType(""), new CoreCompetency(""));

        assertTrue(newJobOne.toString().equals("OOPS! This job does not seem to exist."));
    }
}
