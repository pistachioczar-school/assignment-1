//Zach
/*
 * Main
Your Main must demonstrate functionality with hardcoded data.
Minimum demo requirements:
• Create at least 2 events
• Create at least 2 ticket types
• Create at least 5 tickets across different events and ticket types
• Cancel at least 1 ticket
• Admit at least 1 ticket
• Demonstrate at least 1 invalid operation and show how your design handles it (for example,
trying to admit a canceled ticket)
• Print all tickets
• Print tickets for one specific event
 * */
package eventTicketStudent;


public class Main {
	
	public static void main(String[] args) {
		
		//Making events and a ticket book for the ticket manager
		TicketType vip = new TicketType("VIP", 25.00);
		TicketType basic = new TicketType("Basic", 12.00);
		Event concert = new Event("Concert", "Columbia, MO");
		Event play = new Event("Play", "New York, NY");
		TicketBook ticketBook = new TicketBook(10);
		TicketManager ticketManager = new TicketManager(ticketBook);
		
		ticketManager.createTicket(play, basic, "Zach");
		ticketManager.createTicket(play, vip, "Zach");
		ticketManager.createTicket(concert, basic, "Oliver");
		ticketManager.createTicket(play, vip, "Oliver");
		ticketManager.createTicket(concert, basic, "Zach");
		
		System.out.println("After creation ticket manager:\n");
		ticketBook.printAll();
		
		ticketManager.cancelTicket(1);
		
		System.out.println("\nAfter cancellation ticket manager [Cancled Ticket 1]:\n ");
		ticketBook.printAll();
		
		ticketManager.admitTicket(2);
		
		System.out.println("\nAfter admitting ticket manager [Admitted Ticket 2]:\n ");
		ticketBook.printAll();


		System.out.println("\nError test, cancelling admitted ticket.\n");
		
		ticketManager.cancelTicket(2);
		
		System.out.println("\nPrinting tickets for \"Concert\":\n");
		ticketManager.printForEvent(concert);

		System.out.println("\nPrinting all tickets:\n");
		ticketBook.printAll();
		

		
		
		
		
		
	}
}

