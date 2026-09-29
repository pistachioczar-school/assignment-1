//Oliver
/*
 * Ticket
Represents one ticket issued to one student for one event.
Required data:
• int id (must be positive)
• Event event
• TicketType ticketType
• String studentName (not null or blank)
• boolean canceled
• boolean admitted
Required invariants:
• id > 0
• event and ticketType are not null
• studentName is not null or blank
• A ticket cannot be both canceled and admitted at the same time
Required behavior:
• Constructor validates invariants (fail fast)
• cancel() attempts to cancel the ticket according to your state rules
• admit() attempts to admit the ticket holder according to your state rules
• Methods that answer questions such as isCanceled(), isAdmitted(), or isActive() are
encouraged
• toString() prints a useful line including id, student, event, ticket type, and status
Testing/design requirement: Avoid unnecessary void methods. If an operation can return a
meaningful result that makes the behavior easier to test, return that result. For example, cancel()
or admit() may return boolean to indicate success or failure. Printing methods may be void.
Open design choice: Decide what should happen if someone tries to admit a canceled ticket,
cancel an admitted ticket, admit a ticket twice, or cancel a ticket twice. Pick clear rules and enforce
them consistently.
*/
package eventTicketStudent;

public class Ticket {
    private final int id;
    private final Event event;
    private final TicketType ticketType;
    private final String studentName;
    private boolean canceled; // I spelled canceled like in the assignemtnt to be safe
    private boolean admitted;

    public Ticket(int id, Event event, TicketType ticketType, String studentName) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id cannot be less than or equal to 0");
        }

        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }

        if (ticketType == null) {
            throw new IllegalArgumentException("Ticket type cannot be null");
        }

        if (studentName == null || studentName.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be null or blank");
        }

        /*
        Legacy code
        if (canceled && admitted) {

            throw new IllegalArgumentException("Ticket cannot be cancelled and admitted at the same time");
        }
         */

        this.id = id;
        this.event = event;
        this.ticketType = ticketType;
        this.studentName = studentName;
        this.canceled = false;
        this.admitted = false;
    }

    // This method's behavior could definitely be different depending on how you want things to behave
    // I am using a boolean right now where basically it returns false if the ticket is admitted and returns true otherwise after setting cancelled to true
    // You could alternatively throw if admitted and then catch it in the caller, but that would require coordination between us
    public synchronized boolean cancel() {
        if (admitted) {
        	//Zach adding a throw statement and will add try catch statement to ticket manager just to show that we know how to handle error handling for assignment.
            // oliver added changed IllegalArgument to IllegalState
        	throw new IllegalStateException("Cannot cancel an admitted ticket");
        } else {
            if (canceled) {
                // I am choosing to make cancel idempotent for now so I will still return true instead of throwing or returning false
                return true;
            }

            canceled = true;

            return true;
        }
    }

    // Same thing as cancel() but with the variables swapped
    public synchronized boolean admit() {
        if (canceled) {
            // oliver added made admit() throw an error like cancel()
            throw new IllegalStateException("Cannot admit a canceled ticket");
        } else {
            if (admitted) {
                // admit is also idempotent for now
                return true;
            }

            admitted = true;

            return true;
        }
    }

    public synchronized boolean isCanceled() {
        return canceled;
    }

    public synchronized boolean isAdmitted() {
        return admitted;
    }

    @Override
    public synchronized String toString() {
        return "Ticket description: (id) '" + id + "'; (event) '" + event + "'; (ticket type) '" + ticketType + "'; (student name) '" + studentName + "'; (status) '" + getStatusString() + "'";
    }

    private String getStatusString() {
        if (canceled) {
            return "canceled";
        } else if (admitted) {
            return "admitted";
        } else {
            return "neither canceled nor admitted";
        }
    }
    
    //Zach addition so you can check for repeating ids
    
    public int getId() {
    	return this.id;
    }
    
    //Zach addition that lets you get the tickets event ID
    
    public Event getEvent() {
    	return this.event;
    }
}
