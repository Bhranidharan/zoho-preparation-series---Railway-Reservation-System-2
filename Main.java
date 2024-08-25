package railway_reservation_system2;

import java.util.*;

import hotel_reservation_system.HotelController;
import hotel_reservation_system.HotelModel;
import hotel_reservation_system.HotelService;
import hotel_reservation_system.HotelServiceImpl;

public class Main {

	public static void main(String[] args) {
		Scanner an = new Scanner(System.in);
		
		TrainService service = new TrainServiceImpl();
        TrainController controller = new TrainController(service);

        boolean b = true;

        while (b) {
            System.out.println("1. View available Tickets \n" +
                    "2. Book Ticket \n" +
                    "3. Cancel Ticket \n" +
                    "4. All Ticket Info \n" +
                    "5. Confirmed Ticket Info \n" +
                    "6. Rac Ticket Info \n" +
                    "7. WT Ticket Info \n" +
                    "8. Enter 8 to quit");
            
            int option = an.nextInt();

            switch (option) {
                case 1: {
                    controller.availableTicket();
                    break;
                }
                case 2: {
                    System.out.print("Enter Your Name: ");
                    String name = an.next();
                    System.out.print("Enter Your Preffered Birth : ");
                    String pf = an.next();
                    
                    // Create a new instance of HotelModel for each booking
                    Model model = new Model();
                    model.setName(name);
                    model.setPrefferedBirth(pf);
                    controller.bookTicket(model);
                    System.out.println();
                    break;
                }
                case 3: {
                    System.out.print("Enter Booking ID: ");
                    int i = an.nextInt();
                    
                    // Create a new instance of HotelModel for checkout
                    Model model = new Model();
                    model.setId(i);
                    controller.cancelTicket(model);
                    System.out.println();
                    break;
                }
                case 4: {
                    controller.allTicket();
                    break;
                }
                case 5: {
                    controller.clist();
                    break;
                }
                case 6: {
                    controller.raclist();
                    break;
                }
                case 7: {
                    controller.wtlist();
                    break;
                }
                case 8: {
                    b = false;
                    break;
                }
                default: {
                    System.out.println("Try Again");
                    break;
                }
            }
        }
        an.close();

	}

}
