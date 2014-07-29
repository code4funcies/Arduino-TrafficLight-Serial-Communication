package neumont.enterprise;

public enum CriterionType {
    Overall("Overall", "Criteria for the overall health of project"), Tasks("Tasks", ""), Bugs("Bugs", ""), CodeCoverage("Code Coverage", ""),
    CodeComplexity("Code Complexity", ""), TechnicalDebt("Technical Debt", ""), CodeStandards("Code Standards", "" ), CodeReviews("Code Reviews", ""), BuildStatus("Build Status","");

    CriterionType(String name, String description){
        this.name = name;
        this.description = description;
    }

    private String name, description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
