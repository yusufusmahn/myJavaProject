package TestProblem;

import TheWorldsProblem.Person;
import TheWorldsProblem.Problem;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testAddProblem_singleProblemWorks() {
        Person person = new Person();
        Problem educationProblem = Problem.createProblem("Physics exam", "EDUCATION");
        person.addProblem(educationProblem);
        List<Problem> allProblems = person.getAllProblems();
        assertEquals(1, allProblems.size());
    }



    @Test
    public void testAddProblem_multipleProblemsWorks() {
        Person person = new Person();
        Problem educationProblem = Problem.createProblem("ican exam", "EDUCATION");
        Problem spiritualProblem = Problem.createProblem("whatever", "SPIRITUAL");
        Problem financialProblem = Problem.createProblem("choke", "FINANCIAL");
        person.addProblem(financialProblem);
        person.addProblem(spiritualProblem);
        person.addProblem(educationProblem);
        List<Problem> allProblems = person.getAllProblems();
        assertEquals(3, allProblems.size());

    }


    @Test
    public void testSolveProblem_works() {
        Person person = new Person();
        Problem financialProblem = Problem.createProblem("choke", "FINANCIAL");
        person.addProblem(financialProblem);
        person.solveProblem(financialProblem);
        assertTrue(financialProblem.isSolved());

    }


    @Test
    public void testListUnsolvedProblems_Works() {
        Person person = new Person();
        Problem spiritualProblem = Problem.createProblem("whatever", "SPIRITUAL");
        Problem financialProblem = Problem.createProblem("choke", "FINANCIAL");
        person.addProblem(financialProblem);
        person.addProblem(spiritualProblem);
        person.solveProblem(financialProblem);
        person.solveProblem(spiritualProblem);
        List<Problem> unsolvedProblems = person.listUnsolvedProblems();
        assertEquals(0, unsolvedProblems.size());
    }


    @Test
    public void testListUnsolvedProblems_returnCorrectSize() {
        Person person = new Person();
        List<Problem> unsolvedProblems = person.listUnsolvedProblems();
        assertEquals(0, unsolvedProblems.size());
    }


    @Test
    public void testGetAllProblems_returnCorrectSize() {
        Person person = new Person();
        List<Problem> allProblems = person.getAllProblems();
        assertEquals(0, allProblems.size());
    }

}
