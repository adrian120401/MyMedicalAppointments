import model.Doctor;
import model.ISchedulable;
import model.Patient;
import model.User;

import java.util.Date;

import static ui.UIMenu.showMenu;

public class Main {

    public static void main(String[] args) {
        showMenu();

        //Clase anonima
        User user=new User("Gaia","rompebolas@g.com") {
            @Override
            public void showDataUser() {
                System.out.println("Hospital de Flores");
            }
        };

    }
}
