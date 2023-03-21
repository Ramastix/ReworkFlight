import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.FileAlreadyExistsException;

public class TicketRepositoryTest {
    private TicketRepository repo = new TicketRepository();
    private Ticket ticket1 = new Ticket(1, "MSK", "IJK", 900, 400);
    private Ticket ticket2 = new Ticket(2, "Samara", "SPB", 1000, 900);
    private Ticket ticket3 = new Ticket(3, "MSK", "IJK", 800, 420);
    private Ticket ticket4 = new Ticket(4, "IJK", "Kazan", 1500, 450);
    private Ticket ticket5 = new Ticket(5, "Volgograd", "Rostov", 1200, 700);


    @Test

    public void shouldRemoveId() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.removeById(ticket2.getId());

        Ticket[] expected = new Ticket[]{ticket1, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.getTickets();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveNotExistedId() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(10);
        });
    }

    @Test

    public void shouldAddNewTicket() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);

        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.getTickets();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllTicket() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);

        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldLongestDuration() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.findById(ticket2.getDuration());

        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


}