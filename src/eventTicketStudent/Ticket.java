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


}
