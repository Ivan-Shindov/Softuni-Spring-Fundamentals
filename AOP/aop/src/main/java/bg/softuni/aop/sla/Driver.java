package bg.softuni.aop.sla;

public class Driver {
    private String name;
    private String license;

    public String getName() {
        return name;
    }

    public Driver setName(String name) {
        this.name = name;
        return this;
    }

    public String getLicense() {
        return license;
    }

    public Driver setLicense(String license) {
        this.license = license;
        return this;
    }
}
