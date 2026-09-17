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

}
