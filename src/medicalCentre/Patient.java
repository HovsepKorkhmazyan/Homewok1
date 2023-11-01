package medicalCentre;

public class Patient extends Person {
    public Doctor getDoctor() {
        return doctor;
    }

    private Doctor doctor;

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient(String name, String surname, String id, String phoneNumber, Doctor doctor) {
        super(name, surname, id, phoneNumber);
        this.doctor = doctor;
    }
}
