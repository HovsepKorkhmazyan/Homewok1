package medicalCentre;

public class Doctor extends Person {
    private String profession;
    private String email;

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public String getEmail() {
        return email;
    }

    public Doctor(String name, String surname, String id, String phoneNumber, String profession, String email) {
        super(name, surname, id, phoneNumber);
        this.profession = profession;
        this.email = email;
    }
}

