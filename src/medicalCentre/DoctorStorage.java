package medicalCentre;

public class DoctorStorage {
    Doctor[] doctorStorage = new Doctor[10];
    int size;

    public void add(Doctor doctor){
      if (size == doctorStorage.length){
          extend();
      }
      doctorStorage[size++] = doctor;
    }
    private void extend(){
        Doctor[] temp = new Doctor[doctorStorage.length + 10];
        System.arraycopy(doctorStorage,0,temp,0,doctorStorage.length);
        doctorStorage = temp;
    }
    private void print(){
        for (int i = 0; i < doctorStorage.length; i++) {
            System.out.println(doctorStorage[i]);

        }
    }
    public Doctor getByProfession(String doctorProfession){
        for (int i = 0; i < size; i++) {
            if(doctorStorage[i].getProfession().equals(doctorProfession))
                return doctorStorage[i];
        }
        return null;
    }

}

