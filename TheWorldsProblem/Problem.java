package TheWorldsProblem;

import Account.Prototype;

public class Problem {
    private String name;
    private ProblemType type;
    private boolean isSolved;

    private Problem(String name, ProblemType type) {
        this.name = name;
        this.type = type;
        this.isSolved = false;
    }

    public static  Problem createProblem(String name, String userInput) {
        ProblemType userType;
        try{
            userType = ProblemType.valueOf(userInput.toUpperCase());

        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("Invalid problem type: " + userInput + " problem type should be one of: FINANCIAL, SPIRITUAL, EDUCATION, BUSINESS, TECHNICAL");
        }

        return new Problem(name, userType);
    }

    public String getName() {
        return name;
    }

    public ProblemType getType() {
        return type;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        this.isSolved = solved;
    }


}

