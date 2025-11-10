public class GeneralPractitioner extends HealthProfessional {
    private boolean acceptsWalkIns;

    public GeneralPractitioner() {
        super();
        this.acceptsWalkIns = false;
    }

    public GeneralPractitioner(int id, String name, String clinicLocation, boolean acceptsWalkIns) {
        super(id, name, clinicLocation);
        this.acceptsWalkIns = acceptsWalkIns;
    }

    @Override
    public void printDetails() {
        System.out.println("Type: General Practitioner");
        super.printDetails();
        System.out.println("Accepts Walk-ins: " + (acceptsWalkIns ? "Yes" : "No"));
    }
}
