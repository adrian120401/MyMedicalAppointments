package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    //Atributos
    private String speciality;
    private ArrayList<AvailableAppointment> availableAppointment=new ArrayList<>();

    //Constructores
    public Doctor(String name,String email,String speciality){
        super(name,email);
        this.speciality=speciality;
    }
    //Get y Set
    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    //Comportamientos
    @Override
    public String toString(){
        return super.toString()+" Speciality:"+getSpeciality()+" Available: "+availableAppointment.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: Cruz Roja");
    }


    public void addAvailableAppointment(String date,String time){

        availableAppointment.add(new AvailableAppointment(date,time));
    }
    public ArrayList<AvailableAppointment> getAvailableAppointment(){
        return availableAppointment;
    }

    //CLASE ANIDADA
    //AvailableAppointment
    public static class AvailableAppointment{
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");

        //Constructores
        public AvailableAppointment(String date,String time) {
            try {
                this.date=format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time=time;
        }

        //Get y Set
        public int getId() {
            return id;
        }
        public void setId_availableAppointment(int id) {
            this.id = id;
        }


        public Date getDate(String DATE) {
            return date;
        }
        public String getDate(){
            return format.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }


        public String getTime() {
            return time;
        }
        public void setTime(String time) {
            this.time = time;
        }
        @Override
        public String toString(){
           return "Available Appointemnts \nDate: "+date+" Time:"+time;
        }
    }
}
