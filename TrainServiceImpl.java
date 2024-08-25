package railway_reservation_system2;

import java.util.*;

public class TrainServiceImpl implements TrainService {
	
	private static List<Model> cList = new ArrayList<>();
	private static List<Model> racList = new ArrayList<>();
	private static List<Model> wtList = new ArrayList<>();
	private static List<Model> allList = new ArrayList<>();
	
	private static int id = 1;
	
	private static int totalTickets = 3;
	private static int ub = 1;
	private static int mb = 1;
	private static int lb = 1;
	private static int rac = 1;
	private static int wt = 1;
	
	private static int ubsn = 1;
	private static int mbsn = 1;
	private static int lbsn = 1;


	@Override
	public List<Model> list() {
		return allList;
	}

	@Override
	public String viewAvailableTickets() {
		
		return "Available Tickets are: " + totalTickets;
	}

	@Override
	public String bookTicket(Model model) {
		if(wt == 0) {
			return "Sorry All tickets are sold out, Booking Full!!!";
		}
		if(model.getPrefferedBirth().equals("u") && ub != 0) {
			model.setId(id++);
			totalTickets--;
			ub--;
			model.setAllocatedBirth("upperBirth");
			model.setSeatNo(ubsn++);
			model.setTicketStatus("Booked");
			allList.add(model);
			cList.add(model);
			return "Ticked Booked Successfully \n" + 
			"Name : "+ model.getName() +" \n "+
			"Seat No : "+ model.getSeatNo() +"\n"+
			"Allocated Birth : "+model.getAllocatedBirth() + "\n" +
			"Ticket Status : "+model.getTicketStatus();
		}else if(model.getPrefferedBirth().equals("m") && mb != 0) {
			model.setId(id++);
			totalTickets--;
			mb--;
			model.setAllocatedBirth("middleBirth");
			model.setSeatNo(mbsn++);
			model.setTicketStatus("Booked");
			allList.add(model);
			cList.add(model);
			return "Ticked Booked Successfully \n" + 
			"Name : "+ model.getName() +" \n "+
			"Seat No : "+ model.getSeatNo() +"\n"+
			"Allocated Birth : "+model.getAllocatedBirth() + "\n" +
			"Ticket Status : "+model.getTicketStatus();
		}else if(model.getPrefferedBirth().equals("l") && lb != 0) {
			model.setId(id++);
			totalTickets--;
			lb--;
			model.setAllocatedBirth("lowerBirth");
			model.setSeatNo(lbsn++);
			model.setTicketStatus("Booked");
			allList.add(model);
			cList.add(model);
			return "Ticked Booked Successfully \n" + 
			"Name : "+ model.getName() +" \n "+
			"Seat No : "+ model.getSeatNo() +"\n"+
			"Allocated Birth : "+model.getAllocatedBirth() + "\n" +
			"Ticket Status : "+model.getTicketStatus();
		}else if(ub != 0) {
			model.setId(id++);
			totalTickets--;
			ub--;
			model.setAllocatedBirth("upperBirth");
			model.setSeatNo(ubsn++);
			model.setTicketStatus("Booked");
			allList.add(model);
			cList.add(model);
			return "Ticked Booked Successfully \n" + 
			"Name : "+ model.getName() +" \n "+
			"Seat No : "+ model.getSeatNo() +"\n"+
			"Allocated Birth : "+model.getAllocatedBirth() + "\n" +
			"Ticket Status : "+model.getTicketStatus();
		}else if(mb != 0) {
			model.setId(id++);
			totalTickets--;
			mb--;
			model.setAllocatedBirth("middleBirth");
			model.setSeatNo(mbsn++);
			model.setTicketStatus("Booked");
			allList.add(model);
			cList.add(model);
			return "Ticked Booked Successfully \n" + 
			"Name : "+ model.getName() +" \n "+
			"Seat No : "+ model.getSeatNo() +"\n"+
			"Allocated Birth : "+model.getAllocatedBirth() + "\n" +
			"Ticket Status : "+model.getTicketStatus();
		}else if(lb != 0) {
			model.setId(id++);
			totalTickets--;
			lb--;
			model.setAllocatedBirth("lowerBirth");
			model.setSeatNo(lbsn++);
			model.setTicketStatus("Booked");
			allList.add(model);
			cList.add(model);
			return "Ticked Booked Successfully \n" + 
			"Name : "+ model.getName() +" \n "+
			"Seat No : "+ model.getSeatNo() +"\n"+
			"Allocated Birth : "+model.getAllocatedBirth() + "\n" +
			"Ticket Status : "+model.getTicketStatus();
		}else if(rac != 0) {
			model.setId(id++);
			//totalTickets--;
			rac--;
			model.setTicketStatus("Rac");
			allList.add(model);
			racList.add(model);
			return "Booked RAC \n" + 
			"Name : "+ model.getName() +" \n "+
			"Ticket Status : "+model.getTicketStatus();
		}else{
			model.setId(id++);
		//	totalTickets--;
			wt--;
			model.setTicketStatus("WaitingList");
			allList.add(model);
			wtList.add(model);
			return "Sorry Ticket are Sold Out\n" + 
			"Name : "+ model.getName() +" \n "+
			"Seat No : "+ model.getSeatNo() +"\n"+
			"Allocated Birth : "+model.getAllocatedBirth() + "\n" +
			"Ticket Status : "+model.getTicketStatus();
		}
	}

	@Override
	public String cancelTicket(Model model) {
	    Optional<Model> dataOptional = allList.stream()
	            .filter(d -> d.getId() == model.getId())
	            .findFirst();
	    
	    if (!dataOptional.isPresent()) {
	        return "Booked Information not found";
	    }
	    
	    Model data = dataOptional.get();
	    
	    totalTickets++;
	    allList.remove(data);
	    
	    if ("Booked".equals(data.getTicketStatus())) {
	        cList.remove(data);
	        switch (data.getAllocatedBirth()) {
	            case "upperBirth":
	                ub++;
	                ubsn--;
	                break;
	            case "middleBirth":
	                mb++;
	                mbsn--;
	                break;
	            case "lowerBirth":
	                lb++;
	                lbsn--;
	                break;
	            default:
	                return "Something Went Wrong: Cannot find birth";
	        }
	    } else if ("Rac".equals(data.getAllocatedBirth())) {
	        racList.remove(data);
	        rac++;
	    } else if ("WaitingList".equals(data.getAllocatedBirth())) {
	        wtList.remove(data);
	        wt++;
	    }

	    return "Ticket Cancelled Successfully";
	}


	@Override
	public List<Model> racList() {
		return racList;
	}

	@Override
	public List<Model> wtList() {
		return wtList;
	}

	@Override
	public List<Model> cList() {
		return cList;
	}

}
