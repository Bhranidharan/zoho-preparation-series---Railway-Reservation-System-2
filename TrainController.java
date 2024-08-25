package railway_reservation_system2;

import java.io.*;

public class TrainController {
	
	PrintWriter p = new PrintWriter(System.out, true);
	
	private TrainService trainService;
	
	TrainController(TrainService trainService){
		this.trainService = trainService;
	}
	
	public void allTicket() {
		p.println(trainService.list());
	}
	
	public void clist() {
		p.println(trainService.cList());
	}
	
	public void raclist() {
		p.println(trainService.racList());
	}
	
	public void wtlist() {
		p.println(trainService.wtList());
	}
	
	public void availableTicket() {
		p.println(trainService.viewAvailableTickets());
	}

	public void bookTicket(Model model) {
		p.println(trainService.bookTicket(model));
	}
	
	public void cancelTicket(Model model) {
		p.println(trainService.cancelTicket(model));
	}
}
