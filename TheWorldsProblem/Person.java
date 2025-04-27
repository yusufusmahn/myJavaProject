package TheWorldsProblem;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<Problem> problems;

    public Person() {
        this.problems = new ArrayList<>();
    }

    public void addProblem(Problem problemInput) {
        problems.add(problemInput);
    }

    public void solveProblem(Problem problemInput) {
        if (problems.contains(problemInput)) {
            problemInput.setSolved(true);
        }
    }

    public List<Problem> listUnsolvedProblems() {
        List<Problem> unsolvedProblems = new ArrayList<>();
        for (Problem temp : problems) {
            if (!temp.isSolved()) {
                unsolvedProblems.add(temp);
            }
        }
        return unsolvedProblems;
    }

    public List<Problem> getAllProblems() {
        return new ArrayList<>(problems);
    }

}