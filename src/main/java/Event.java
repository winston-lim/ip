public class Event extends Task {
    private final String duration;

    Event(String description, int id, String duration) {
        super(description, id);
        this.duration = duration;
    }

    public String getDuration() {
        return this.duration;
    }

    @Override
    public String getDescription() {
        return this.title + " (at: " + this.duration + ")";
    }

    @Override
    public final String getStatusDescription() {
        return "[E] " + this.getStatusIcon() + " " + this.getDescription();
    }
}