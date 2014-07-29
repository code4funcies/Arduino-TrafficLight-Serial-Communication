package neumont.enterprise;

public enum HealthStatus {
    Green("Green"), Red("Red"), Yellow("Yellow");

    HealthStatus(String name){
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 }
