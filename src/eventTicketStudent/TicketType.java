//Zach
/*
 * TicketType
Represents a type of ticket for an event.
Required data:
• String name (examples: "Student", "General", "VIP")
• double price (must not be negative)
Required invariants:
• name is not null or blank
• price >= 0
3
Required behavior:
• Constructor validates invariants (fail fast)
• Getters as needed
• toString() that prints the ticket type and price in a meaningful way
Design note: This is a strong candidate for an immutable class
 * */

package eventTicketStudent;

public final class TicketType {
	private String name;
	private double price;
	
	public TicketType(String name, double price) {
		
		/*
		 *  checks if name is null or is blank (if nothing is there or its 
		 *  just white space) and shuts down program with custom error message 
		 *  if either are true.
		*/
		if(name==null || name.isBlank()) {
			throw new IllegalArgumentException("Name was not declared. Please add name.");
		}
		
		
		/* 
		 * Checks if price is negative and does same as previous if statement
		 * when true
		*/
		if(price < 0) {
			throw new IllegalArgumentException("Price was declared negative. Price can only be positive or 0.");
		}
		this.name = name;
		this.price = price;
	}
	
	/*
	 * Getters, no setters as all that needs to be created is made by the
	 * constructor and after that it is immutable.
	 */
	
	public String getTicketTypeName() {
		return this.name;
	}
	
	public double getTicketTypePrice() {
		return this.price;
	}
	
	//Override of toString for custom print.
	@Override
	public String toString() {
		return "Ticket Type: " + this.name + "\nTicket Price: " + this.price;
	}
	
	
	
	

}
