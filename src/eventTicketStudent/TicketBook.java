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

}
