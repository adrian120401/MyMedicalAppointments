package ui;

import model.Doctor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {

    public static void showPatientMenu(){
        int response=0;
        do{
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome"+ UIMenu.patientLoged.getName());
            System.out.println("1. Book an Appontments");
            System.out.println("2.My Appontments");
            System.out.println("0.Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppontmentsMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;

            }
        }while(response!=0);
    }
    private static void showBookAppontmentsMenu(){
        int response=0;
        do{
            System.out.println("::Book an Appoinments");
            System.out.println("::Select date");
            //Numeracion de la lista de fechas
            //Indice de la fecha seleccionada
            Map<Integer, Map<Integer, Doctor>> doctors=new TreeMap<>();
            int k=0;
            for (int i = 0; i < DoctorMenu.doctorsAvailableAppoinments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments
                        =DoctorMenu.doctorsAvailableAppoinments.get(i).getAvailableAppointment();
                Map<Integer,Doctor> doctorAppointment=new TreeMap<>();

                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k+"."+availableAppointments.get(j).getDate());
                    doctorAppointment.put(Integer.valueOf(j),DoctorMenu.doctorsAvailableAppoinments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointment);
                }

            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());

            Map<Integer, Doctor> doctorAvailableSelected=doctors.get(responseDateSelected);
            Integer indexDate=0;
            Doctor doctorSelected=new Doctor("","","");
            for (Map.Entry<Integer, Doctor> doc:doctorAvailableSelected.entrySet()) {
                indexDate=doc.getKey();
                doctorSelected=doc.getValue();
            }

            System.out.println(doctorSelected.getName()+
                    ".Date"+doctorSelected.getAvailableAppointment()
                    .get(indexDate).getDate()
                    +".Time"+doctorSelected.getAvailableAppointment()
                    .get(indexDate).getTime());

            System.out.println("Confirm your appointment: \n1.Yes \n2.Change Date");
            response=Integer.valueOf(sc.nextLine());

            if(response ==1){
                UIMenu.patientLoged.addAppointmentDoctor(doctorSelected,doctorSelected.getAvailableAppointment()
                        .get(indexDate).getDate(null),doctorSelected.getAvailableAppointment().get(indexDate).getTime());

                showPatientMenu();
            }
        }while(response!=0);
    }

    private static void showPatientMyAppointments(){
        int response=0;
        do{
            System.out.println("::My Appointments");
            if(UIMenu.patientLoged.getAppointmentDoctor().size()==0){
                System.out.println("Don't have appointments");
                break;
            }

            for (int i = 0; i < UIMenu.patientLoged.getAppointmentDoctor().size(); i++) {
                int j=i+1;
                System.out.println(j+". "+
                        "Date: "+UIMenu.patientLoged.getAppointmentDoctor().get(i).getDate()+
                        "Time: "+UIMenu.patientLoged.getAppointmentDoctor().get(i).getTime()+
                        "\nDoctor: "+ UIMenu.patientLoged.getAppointmentDoctor().get(i).getDoctor().getName());

            }
            System.out.println("0.Return");

        }while (response!=0);
    }

}
