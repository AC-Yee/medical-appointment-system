// src/HealthProfessional.java
/**
 * Base class representing a health professional.
 * Demonstrates encapsulation and inheritance.
 */
public class HealthProfessional {
    private int id;
    private String name;
    private String clinicLocation;

    // Default constructor
    public HealthProfessional() {
        this.id = 0;
        this.name = "Unknown";
        this.clinicLocation = "Not specified";
    }

    // Parameterized constructor
    public HealthProfessional(int id, String name, String clinicLocation) {
        this.id = id;
        this.name = name;
        this.clinicLocation = clinicLocation;
    }

    // Method to print details
    public void printDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Clinic Location: " + clinicLocation);
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getClinicLocation() { return clinicLocation; }
}
