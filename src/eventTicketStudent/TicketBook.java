//Zach
/*
 * TicketBook
This class stores tickets and owns them. It should not coordinate the whole application. Its
responsibility is ticket storage, creation, and basic queries.
Constraints: You must store tickets using a plain Java array, for example:
• private Ticket[] tickets;
• private int count;
Required behavior:
• Constructor creates an empty book with a fixed maximum capacity (must be positive)
• A method such as createTicket(int id, Event event, TicketType type, String studentName)
creates the Ticket object internally and stores it if space exists; otherwise it throws an ex-
ception
• findById(int id) returns the matching ticket or null if not found
• printAll() prints all stored tickets (one per line)
• printForEvent(Event event) prints tickets for that event
Design requirements:
• Fields must be private
• Do not expose the internal array directly
• TicketBook should create the Ticket objects it owns. Do not create a Ticket in Main and
pass it into the book.
• Keep methods focused. Avoid turning this into a god class.
Open design choice: Decide how printForEvent determines whether a ticket belongs to
the requested event without implementing equals. You may compare references or use another
approach that stays within the topics covered. Document your choice in a short comment.
 * */
package eventTicketStudent;

public class TicketBook {

	private Ticket[] tickets;
	private int count;
	
	public TicketBook(int size) {
		
		if(size < 1) {
			throw new IllegalArgumentException("Invalid book size. Please insert a positive integer for book size.");
		}
		this.tickets = new Ticket[size];
		this.count = 0;
		
	}
	
	public int createTicket(int id, Event event, TicketType type, String studentName){
		
		for(int i = 0; i < this.count; i++) {
			if(this.tickets[i].getId() == id) {
				throw new IllegalArgumentException("Ticket ID is already in ticket book. Please input a unique id.");
			}
		}
		
		if(this.count >= this.tickets.length) {
			throw new IllegalArgumentException("Ticketbook is full, cannot implement any new tickets.");
		}
		
		Ticket newTicket = new Ticket(id, event, type, studentName);
		this.tickets[this.count] = newTicket;
		this.count += 1;
		return newTicket.getId();
		
	}
	
	public Ticket findById(int id) {
		
		for(int i=0; i < this.count; i++) {
			if(this.tickets[i].getId() == id) {
				return this.tickets[i];
			}
		}
		
		return null;
	}
	
	public void printAll() {
		for(int i=0; i < this.count; i++) {
			System.out.println(this.tickets[i].toString());
		}
	}
	
	public void printForEvent(Event event) {
		for(int i=0; i < this.count; i++) {
			if(this.tickets[i].getEvent().getName() == event.getName() && this.tickets[i].getEvent().getLocation() == event.getLocation()) {
				System.out.println(this.tickets[i].toString() + "\n");
				return;
			}
		}
		
		System.out.println("Event was not found.");
	}
	
	
}
