public class Cardiologist extends HealthProfessional {
    private String specialization;

    public Cardiologist() {
        super();
        this.specialization = "General Cardiology";
    }

    public Cardiologist(int id, String name, String clinicLocation, String specialization) {
        super(id, name, clinicLocation);
        this.specialization = specialization;
    }

    @Override
    public void printDetails() {
        System.out.println("Type: Cardiologist");
        super.printDetails();
        System.out.println("Specialization: " + specialization);
    }
}
