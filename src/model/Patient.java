package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {
    //Atributos
    private String birthday;
    private double weight;
    private double height;
    private String blood;

    private ArrayList<AppointmentDoctor> appointmentDoctors= new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentNurse= new ArrayList<>();

    public ArrayList<AppointmentDoctor> getAppointmentDoctor() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctor(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointmentDoctor=new AppointmentDoctor(this, doctor);
        appointmentDoctor.schedule(date,time);
        appointmentDoctors.add(appointmentDoctor);

    }

    public ArrayList<AppointmentNurse> getAppointmentNurse() {
        return appointmentNurse;
    }

    public void setAppointmentNurse(ArrayList<AppointmentNurse> appointmentNurse) {
        this.appointmentNurse = appointmentNurse;
    }

    //Constructores
    public Patient(String name,String email){
        super(name,email);
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente");
    }

    ;

    //Get y Set
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public String getWeight() {
        return this.weight+" Kg";
    }


    public void setHeight(double height) {
        if(height>3.0){
            System.out.println("Debes ingresar una cantidad correcta en metros");
        }else {
            this.height = height;
        }
    }

    public String getHeight() {
        return this.height+" mts";
    }
}
