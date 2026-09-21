//Oliver
/*
 * Event
Represents one campus event.
Required data:
• String name (example: "Cybersecurity Guest Lecture")
• String location (example: "Engineering Building")
Required invariants:
• name is not null or blank
• location is not null or blank
Required behavior:
• Constructor enforces invariants (fail fast)
• Getters as needed (use intentionally)
• A toString() that prints a meaningful description, for example: Cybersecurity Guest
Lecture @ Engineering Building
Design note: Consider making Event immutable.
*/
package eventTicketStudent;

// I do not think that this class should be final
public class Event {
    private final String name;
    private final String location;

    public Event(String name, String location) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Event name cannot be null or blank");
        }

        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Event location cannot be null or blank");
        }

        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Event description: " + name + " @ " + location;
    }
}
