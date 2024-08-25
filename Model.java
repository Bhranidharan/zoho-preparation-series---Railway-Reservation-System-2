package railway_reservation_system2;

public class Model {
	
	private int id;
	private String name;
	private int seatNo;
	private String allocatedBirth;
	private String prefferedBirth;
	private String ticketStatus;
	
	
	
	public Model(int id, String name, int seatNo, String allocatedBirth, String prefferedBirth, String ticketStatus) {
		//super();
		this.id = id;
		this.name = name;
		this.seatNo = seatNo;
		this.allocatedBirth = allocatedBirth;
		this.prefferedBirth = prefferedBirth;
		this.ticketStatus = ticketStatus;
	}
	
	Model(){}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public String getAllocatedBirth() {
		return allocatedBirth;
	}
	public void setAllocatedBirth(String allocatedBirth) {
		this.allocatedBirth = allocatedBirth;
	}
	public String getPrefferedBirth() {
		return prefferedBirth;
	}
	public void setPrefferedBirth(String prefferedBirth) {
		this.prefferedBirth = prefferedBirth;
	}
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	
	@Override
	public String toString() {
		return "Model [id=" + id + ", name=" + name + ", seatNo=" + seatNo + ", allocatedBirth=" + allocatedBirth
				+ ", prefferedBirth=" + prefferedBirth + ", ticketStatus=" + ticketStatus + "]";
	}
	
	

}
