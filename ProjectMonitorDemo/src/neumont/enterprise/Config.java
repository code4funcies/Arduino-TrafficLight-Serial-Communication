package neumont.enterprise;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Config {

    private int id;
    private Set<Criterion> criteria;
    private double majorWeight ;
    private double minorWeight ;
    private double trivialWeight ;
    private double  criticalWeight ;
    private double tagWeight;
  

    public Config(){}

    public Config(int id, double majorWeight, double minorWeight, double trivialWeight, double tagWeight, double criticalWeight) {
        this.id = id;
        this.majorWeight = majorWeight;
        this.minorWeight = minorWeight;
        this.trivialWeight = trivialWeight;
        this.tagWeight = tagWeight;
        this.criticalWeight = criticalWeight;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public Set<Criterion> getCriteria() {
        return criteria;
    }

    public void setCriteria(Set<Criterion> criteria) {
        this.criteria = criteria;
    }
    public double getMajorWeight() {
        return majorWeight;
    }

    public void setMajorWeight(double majorWeight) {
        this.majorWeight = majorWeight;
    }
    
    public double getMinorWeight() {
        return minorWeight;
    }

    public void setMinorWeight(double minorWeight) {
        this.minorWeight = minorWeight;
    }
 
    public double getTrivialWeight() {
        return trivialWeight;
    }

    public void setTrivialWeight(double trivialWeight) {
        this.trivialWeight = trivialWeight;
    }
   
    public double getCriticalWeight() {
        return criticalWeight;
    }

    public void setCriticalWeight(double criticalWeight) {
        this.criticalWeight = criticalWeight;
    }
  
    public double getTagWeight() {
        return tagWeight;
    }

    public void setTagWeight(double tagWeight) {
        this.tagWeight = tagWeight;
    }

    public Criterion getCriterion(CriterionType criterionType){
        Iterator<Criterion> criteriaIterator = criteria.iterator();
        Criterion result = null;
        while(criteriaIterator.hasNext() && result == null){
            Criterion criterion = criteriaIterator.next();
            if(criterionType.equals(criterion.getCriterionType())){
                result = criterion;
            }
        }
        return result;
    }

    public HealthItem evaluate(CriterionType criterionType, double value){
        Criterion criterion = getCriterion(criterionType);
        return criterion.evaluate(value);
    }

    public HealthItem evaluate(CriterionType criterionType, HealthItem[] status){
        HealthItem overall = null;
        if(criterionType == CriterionType.Overall){
            Criterion criterion = getCriterion(criterionType);
            overall = criterion.evaluate(status);
        }
        return overall;
    }
}
