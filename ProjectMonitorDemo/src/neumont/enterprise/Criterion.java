package neumont.enterprise;



import java.util.ArrayList;
import java.util.List;



public class Criterion {
    private CriterionType criterionType;
    private int id;
    private double weight;
    private double greenThreshold;
    private double redThreshold;

    public Criterion(int id,CriterionType criterionType, double weight, double greenThreshold, double redThreshold) {
        this.id = id;
        this.criterionType = criterionType;
        this.weight = weight;
        this.greenThreshold = greenThreshold;
        this.redThreshold = redThreshold;
    }

    public Criterion(){}

    public HealthItem evaluate(double value){
        HealthItem health = new HealthItem();
        HealthStatus status;
        health.setWeight(weight);
        health.setValue(value);
        health.setActual(value);
        health.setTarget(greenThreshold);
        health.setCriterionType(criterionType);
        if(criterionType == CriterionType.CodeComplexity){
            status = lowerIsBetter(value);
            switch (status){
                case Green:
                    health.setValue(1);
                    break;
                case Yellow:
                    health.setValue(.5);
                case Red:
                    health.setValue(0);
            }
        }
        else if(criterionType == CriterionType.TechnicalDebt){
            status = lowerIsBetter(value);
        }
        else if(criterionType == CriterionType.CodeStandards){
            status = lowerIsBetter(value);
        }
        else{
            if(criterionType == CriterionType.CodeCoverage){
                value = value/100;
                health.setValue(value);
            }
            status = higherIsBetter(value);
        }

        health.setHealth(status);
        return health;
    }

    public HealthItem evaluate(HealthItem[] statuses){
        HealthItem overall;
        double value = 0;
        for(HealthItem status : statuses){
            value += status.getValue() * status.getWeight();
        }
        overall = evaluate(value);
        return overall;
    }


    private HealthStatus higherIsBetter(double value){
        HealthStatus status;
        if(value >= greenThreshold){
            status = HealthStatus.Green;
        }
        else if(value <= redThreshold){
            status = HealthStatus.Red;
        }
        else{
            status = HealthStatus.Yellow;
        }
        return status;
    }

    private HealthStatus lowerIsBetter(double value){
        HealthStatus status;

        if(value <= greenThreshold){
            status = HealthStatus.Green;
        }
        else if(value >= redThreshold){
            status = HealthStatus.Red;
        }
        else{
            status = HealthStatus.Yellow;
        }
        return status;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  
    public double getGreenThreshold() {
        return greenThreshold;
    }

    public void setGreenThreshold(double greenThreshold) {
        this.greenThreshold = greenThreshold;
    }

   
    public double getRedThreshold() {
        return redThreshold;
    }

    public void setRedThreshold(double redThreshold) {
        this.redThreshold = redThreshold;
    }

  
    public CriterionType getCriterionType() {
        return criterionType;
    }

    public void setCriterionType(CriterionType criterionType) {
        this.criterionType = criterionType;
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
