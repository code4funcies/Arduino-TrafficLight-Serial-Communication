package neumont.enterprise;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class HealthCalculator {

    private Config config;

    public HealthCalculator() {
        this.config = getConfig();
    }

    private Config getConfig(){
        Config config = new Config(1,1.0,1.0,1.0,1.0,1.0);
        Set<Criterion> criteria = new HashSet<Criterion>();
        Criterion overall = new Criterion(1, CriterionType.Overall,1,.80,.50);
        criteria.add(overall);
        Criterion codeComplexity = new Criterion(2, CriterionType.CodeComplexity,.05,7,12);
        criteria.add(codeComplexity);
        Criterion codeCoverage = new Criterion(3, CriterionType.CodeCoverage,.15,.80,.50);
        criteria.add(codeCoverage);
        Criterion tasks = new Criterion(4, CriterionType.Tasks,.45,.80,.60);
        criteria.add(tasks);
        Criterion bugs = new Criterion(1, CriterionType.Bugs,.25,.75,.50);
        criteria.add(bugs);
        Criterion codeReview = new Criterion(1, CriterionType.CodeReviews,.10,.75,.50);
        criteria.add(codeReview);
        config.setCriteria(criteria);
        return  config;
    }

    public HealthItem calculate(ProjectStats stats) {

        Set<HealthItem> healthItems = new HashSet<HealthItem>();
        Config config = getConfig();

        double value;

        value = (stats.getTasksTotal() == 0) ? 1 : stats.getTasksComplete() / (stats.getTimeModifier()*stats.getTasksTotal());
        System.out.println("Task Value: " + value);
        HealthItem taskHealthStatus = config.evaluate(CriterionType.Tasks, value);
        taskHealthStatus.setTarget(stats.getTasksTotal());
        taskHealthStatus.setActual(stats.getTasksComplete());
        taskHealthStatus.setValue(value);
        healthItems.add(taskHealthStatus);
        value = (stats.getBugsTotal() == 0) ? 1 : stats.getBugsComplete()/(stats.getBugsTotal());
        HealthItem bugsHealthStatus = config.evaluate(CriterionType.Bugs, value);
        bugsHealthStatus.setValue(value);
        bugsHealthStatus.setTarget(stats.getBugsTotal());
        bugsHealthStatus.setActual(stats.getBugsComplete());
        healthItems.add(bugsHealthStatus);
        value = (stats.getCodeReviewTotal() == 0) ? 1 : stats.getCodeReviewComplete()/stats.getCodeReviewTotal();
        HealthItem codeReviewsHealthStatus = config.evaluate(CriterionType.CodeReviews, value);
        codeReviewsHealthStatus.setValue(value);
        codeReviewsHealthStatus.setTarget(stats.getCodeReviewTotal());
        codeReviewsHealthStatus.setActual(stats.getCodeReviewComplete());
        healthItems.add(codeReviewsHealthStatus);

        HealthItem codeComplexityHealthStatus = config.evaluate(CriterionType.CodeComplexity, stats.getCodeComplexity());
        healthItems.add(codeComplexityHealthStatus);
        HealthItem codeCoverageHealthStatus = config.evaluate(CriterionType.CodeCoverage, stats.getCodeCoverage());


        healthItems.add(codeCoverageHealthStatus);
//        ProjectBuildInfo buildInfo = getProjectBuildInformation(project.getId()).get(0);

        //HealthItem buildHealthStatus = config.evaluate(CriterionType.BuildStatus, buildInfo.getProjectStatus());

        HealthItem[] healths = {taskHealthStatus, bugsHealthStatus,codeCoverageHealthStatus, codeComplexityHealthStatus,codeReviewsHealthStatus};
        HealthItem overallHealthStatus = config.evaluate(CriterionType.Overall,healths);
        healthItems.add(overallHealthStatus);
        return overallHealthStatus;
    }
}
