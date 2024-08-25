package railway_reservation_system2;

import java.util.*;

public interface TrainService {
	
	public List<Model> list();
	
	public String viewAvailableTickets();
	
	public String bookTicket(Model model);
	
	public String cancelTicket(Model model);
	
	public List<Model> racList();
	
	public List<Model> wtList();
	
	public List<Model> cList();

}
