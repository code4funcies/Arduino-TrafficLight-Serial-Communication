package neumont.enterprise;

import java.util.Date;



public class HealthItem {
    private int id;
    private CriterionType criterionType;
    private HealthStatus health;
    private Date date;
    private double actual;
    private double target;
    private double value;
    private double weight;

    public HealthItem(){}

 
   

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

 

    public CriterionType getCriterionType() {
        return criterionType;
    }

    public void setCriterionType(CriterionType criterionType) {
        this.criterionType = criterionType;
    }

  
    public HealthStatus getHealth() {
        return health;
    }

    public void setHealth(HealthStatus health) {
        this.health = health;
    }
 
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public double getActual() {
        return actual;
    }

    public void setActual(double actual) {
        this.actual = actual;
    }

    
    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HealthItem that = (HealthItem) o;

        if (criterionType != that.criterionType) return false;

        if (!health.equals(that.health)) return false;

        if(value != that.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = criterionType != null ? criterionType.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
