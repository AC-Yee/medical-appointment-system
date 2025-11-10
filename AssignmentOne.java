/*
--------------------------------------------
Declaration of Generative AI Use
--------------------------------------------
This assessment was completed by [Your Full Name].
No Generative AI tools (such as ChatGPT, Copilot, or others)
were used to generate or modify any code or written responses
in this submission.

All work is my own.
--------------------------------------------
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class AssignmentOne {

    private static final ArrayList<Appointment> appointmentList = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Today is November 10, 2025\n");


        ArrayList<HealthProfessional> doctors = new ArrayList<>();
        doctors.add(new GeneralPractitioner(1, "Dr. Alice Smith", "Gold Coast", true));
        doctors.add(new GeneralPractitioner(2, "Dr. Bob Lee", "Brisbane", false));
        doctors.add(new Cardiologist(3, "Dr. Clara Zhao", "Sydney", "Heart Rhythm"));
        doctors.add(new Cardiologist(4, "Dr. David Green", "Melbourne", "Pediatric Cardiology"));

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("===== Simple Appointment System =====");
            System.out.println("1. Make an appointment");
            System.out.println("2. View all appointments");
            System.out.println("3. Cancel appointment by mobile");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            String choice = sc.nextLine().trim();
            System.out.println();

            switch (choice) {
                case "1":
                    makeAppointment(sc, doctors);
                    break;
                case "2":
                    viewAppointments();
                    break;
                case "3":
                    cancelAppointment(sc);
                    break;
                case "4":
                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please enter 1–4.\n");
            }
        }
        sc.close();
    }

    private static void makeAppointment(Scanner sc, ArrayList<HealthProfessional> doctors) {
        System.out.println("Available Doctors:");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". ");
            doctors.get(i).printDetails();
            System.out.println();
        }

        System.out.print("Select doctor by number: ");
        String input = sc.nextLine().trim();
        int choice;
        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Returning to menu.\n");
            return;
        }

        if (choice < 1 || choice > doctors.size()) {
            System.out.println("Invalid selection. Returning to menu.\n");
            return;
        }

        HealthProfessional selectedDoctor = doctors.get(choice - 1);

        System.out.print("Enter patient name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty.\n");
            return;
        }

        System.out.print("Enter 10-digit mobile number: ");
        String mobile = sc.nextLine().trim();
        if (!mobile.matches("\\d{10}")) {
            System.out.println("Error: Mobile number must be 10 digits.\n");
            return;
        }

        System.out.print("Enter time slot (HH:MM): ");
        String time = sc.nextLine().trim();
        if (!time.matches("\\d{2}:\\d{2}")) {
            System.out.println("Error: Time must be in HH:MM format.\n");
            return;
        }

        Appointment newAppt = new Appointment(name, mobile, time, selectedDoctor);
        appointmentList.add(newAppt);
        System.out.println("Appointment successfully created!\n");
    }

    private static void viewAppointments() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments scheduled.\n");
        } else {
            System.out.println("=== Existing Appointments ===");
            for (Appointment appt : appointmentList) {
                appt.printAppointment();
            }
        }
    }

    private static void cancelAppointment(Scanner sc) {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments to cancel.\n");
            return;
        }

        System.out.print("Enter mobile number to cancel: ");
        String mobile = sc.nextLine().trim();
        boolean found = false;

        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).getPatientMobile().equals(mobile)) {
                appointmentList.remove(i);
                System.out.println("Appointment with mobile " + mobile + " has been cancelled.\n");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No appointment found for mobile " + mobile + ".\n");
        }
    }
}
