public class HealthProfessional {
    private int id;
    private String name;
    private String clinicLocation;

    public HealthProfessional() {
        this.id = 0;
        this.name = "Unknown";
        this.clinicLocation = "Not specified";
    }

    public HealthProfessional(int id, String name, String clinicLocation) {
        this.id = id;
        this.name = name;
        this.clinicLocation = clinicLocation;
    }

    public void printDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Clinic Location: " + clinicLocation);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getClinicLocation() { return clinicLocation; }
}
