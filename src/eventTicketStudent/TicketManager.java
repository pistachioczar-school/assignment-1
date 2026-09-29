//Oliver
/*
 * TicketManager
Coordinates the system at a higher level.
Required behavior:
• Stores a TicketBook
• Generates ticket IDs using a private counter field (do not use a static field for application
state)
• Provides high-level operations such as:
– createTicket(Event event, TicketType type, String studentName)
– cancelTicket(int id)
– admitTicket(int id)
5
• High-level operation methods should return meaningful values when appropriate so they can
be tested directly
Design requirements:
• Avoid reaching through objects to manipulate internals
• Avoid long chains like a.getB().getC().doSomething()
• Delegate behavior to the class that owns the relevant data
• Do not duplicate ticket-state rules in the manager. The Ticket class should be responsible
for its own state transitions.
 * */
package eventTicketStudent;

public class TicketManager {
    // If you read this, ticketBook should be final because what it contains can still be mutable, but it should not end up referencing another ticket book object
    private final TicketBook ticketBook;
    private int ticketNumber = 0;

    public TicketManager(TicketBook ticketBook) {
        if (ticketBook == null) {
            throw new IllegalArgumentException("Ticket book cannot be null");
        }

        this.ticketBook = ticketBook;
    }

    // There is a question over what this should return. It should either return the ticket id for later find in the book, or it should return the whole ticket
    public int createTicket(Event event, TicketType ticketType, String studentName) {
        ticketNumber++;
        // I would rather ids be strings like ticket-[number], but the requirements say they need to be ints
        int id = ticketNumber;

        // This will fail if Zach makes createTicket() return something else, so the return type here will have to match his return type
        // Final design resolved this: returns the int id
        return ticketBook.createTicket(id, event, ticketType, studentName);
    }

    // Similar question here about what to return
    // I'll just leave this one returning ticket because returning id would be a little bit redundant since we already call it with id - oliver
    public Ticket cancelTicket(int id) {
        Ticket ticket = ticketBook.findById(id);

        if (ticket == null) {
        	System.out.println("Cannot find ticket to cancel");
            return null;
        }

        try {
        	ticket.cancel();
        } catch (IllegalStateException exception) {
        	System.out.println(exception.getMessage());
        }

        return ticket;
    }

    public Ticket admitTicket(int id) {
        Ticket ticket = ticketBook.findById(id);

        if (ticket == null) {
            System.out.println("Cannot find ticket to admit");
            return null;
        }

        try {
            ticket.admit();
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
        }

        return ticket;
    }
    
	public void printForEvent(Event event) {
		ticketBook.printForEvent(event);
	}
}
