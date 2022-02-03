package org.launchcode.techjobs.oo.test;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.*;
import static org.junit.Assert.*;
import org.launchcode.techjobs.oo.*;
import java.util.*;

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
        Job jobTestOne = new Job();
        Job jobTestTwo = new Job();

        assertEquals(jobTestOne.getId(), jobTestTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(newJob.getName().equals("Product tester"));
        assertTrue(newJob.getEmployer() instanceof Employer);
        assertTrue(newJob.getLocation() instanceof Location);
        assertTrue(newJob.getPositionType() instanceof PositionType);
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", newJob.getName());
        assertEquals("ACME", newJob.getEmployer().getValue());
        assertEquals("Desert", newJob.getEmployer().getValue());
        assertEquals("Quality control", newJob.getEmployer().getValue());
        assertEquals("Persistence", newJob.getEmployer().getValue());
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
    public void testToStringStartsAndEndsWithNewLine(){
        Job newJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        int toStrLen = newJobOne.toString().length();
        String toStr = newJobOne.toString();

        assertEquals('\n', toStr.charAt(0));
        assertEquals('\n', toStr.charAt(toStrLen-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
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
        assertEquals(compareStr, newJobOne.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
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
        assertEquals(compareStr, newJobOne.toString());
    }

    @Test
    public void invalidEntry(){
        Job newJobOne = new Job("", new Employer(""), new Location(""),
                new PositionType(""), new CoreCompetency(""));

        assertTrue(newJobOne.toString().equals("OOPS! This job does not seem to exist."));
    }
}
