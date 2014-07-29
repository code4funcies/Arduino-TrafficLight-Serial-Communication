package neumont.enterprise;

public class ProjectStats {

    private double tasksComplete;
    private double tasksTotal;
    private double bugsComplete;
    private double bugsTotal;
    private double codeReviewComplete;
    private double codeReviewTotal;
    private double codeComplexity;
    private double codeCoverage;
    private double timeModifier;


    public double getTimeModifier() {
        return timeModifier;
    }

    public void setTimeModifier(double timeModifier) {
        this.timeModifier = timeModifier;
    }

    public double getTasksComplete() {
        return tasksComplete;
    }

    public void setTasksComplete(double tasksComplete) {
        this.tasksComplete = tasksComplete;
    }

    public double getTasksTotal() {
        return tasksTotal;
    }

    public void setTasksTotal(double tasksTotal) {
        this.tasksTotal = tasksTotal;
    }

    public double getBugsComplete() {
        return bugsComplete;
    }

    public void setBugsComplete(double bugsComplete) {
        this.bugsComplete = bugsComplete;
    }

    public double getBugsTotal() {
        return bugsTotal;
    }

    public void setBugsTotal(double bugsTotal) {
        this.bugsTotal = bugsTotal;
    }

    public double getCodeReviewComplete() {
        return codeReviewComplete;
    }

    public void setCodeReviewComplete(double codeReviewComplete) {
        this.codeReviewComplete = codeReviewComplete;
    }

    public double getCodeReviewTotal() {
        return codeReviewTotal;
    }

    public void setCodeReviewTotal(double codeReviewTotal) {
        this.codeReviewTotal = codeReviewTotal;
    }

    public double getCodeComplexity() {
        return codeComplexity;
    }

    public void setCodeComplexity(double codeComplexity) {
        this.codeComplexity = codeComplexity;
    }

    public double getCodeCoverage() {
        return codeCoverage;
    }

    public void setCodeCoverage(double codeCoverage) {
        this.codeCoverage = codeCoverage;
    }
}
