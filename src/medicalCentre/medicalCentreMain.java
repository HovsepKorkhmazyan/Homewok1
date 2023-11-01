package medicalCentre;

import java.sql.SQLOutput;
import java.util.Scanner;

public class medicalCentreMain {
    private static Scanner scanner = new Scanner(System.in);
    private static DoctorStorage doctorStorage = new DoctorStorage();

    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            print();
            String input = scanner.nextLine();
            switch (input) {
                case "0":
                    isRun = false;
                    break;
                case "1":
                    addDoctor();


            }

        }

    }

    private static void print() {
        System.out.println("0 to EXIT");
        System.out.println("1 to ADD DOCTOR");
        System.out.println("2 to SEARCH DOCTOR BY PROFESSION");
        System.out.println("3 to DELETE DOCTOR BY ID");
        System.out.println("4 to CHANGE DOCTOR BY ID");
        System.out.println("5 to ADD PATIENT");
        System.out.println("6 to PRINT ALL PATIENDS BY DOCTOR");
        System.out.println("7 to PRINT ALL PATIENTS");
    }

    private static void addDoctor() {
        System.out.println("Enter Doctor Name");
        String doctorName = scanner.nextLine();
        System.out.println("Enter Doctor Surname");
        String doctorSurname = scanner.nextLine();
        System.out.println("Enter Doctor ID");
        String doctorId = scanner.nextLine();
        System.out.println("Enter Doctor Phone Number");
        String doctorPhoneNumber = scanner.nextLine();
        System.out.println("Enter Doctor Profession");
        String doctorProfession = scanner.nextLine();
        System.out.println("Enter Doctor Email");
        String doctorEmail = scanner.nextLine();
        Doctor doctor = new Doctor(doctorName, doctorSurname, doctorId, doctorPhoneNumber, doctorProfession, doctorEmail);
        doctorStorage.add(doctor);
    }
    private static void searchDoctorByProfession(){
        System.out.println("Please,Enter Doctor Profession");
        String doctorProfession = scanner.nextLine();
        Doctor doctorPro = doctorStorage.getByProfession(doctorProfession);
        System.out.println(doctorPro);
    }
}
