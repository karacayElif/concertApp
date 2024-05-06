import java.time.LocalDate;
public class Concerts {
    public String name, details;
    public int ticketStock;
    public LocalDate date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTicketStock() {
        return ticketStock;
    }

    public void setTicketStock(int ticketStock) {
        this.ticketStock = ticketStock;
    }
}
