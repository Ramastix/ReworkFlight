import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {
    private TicketRepository repo = new TicketRepository();
    private TicketManager manager = new TicketManager(repo);

    private Ticket ticket1 = new Ticket(1, "MSK", "IJK", 900, 400);
    private Ticket ticket2 = new Ticket(2, "Samara", "SPB", 1000, 900);
    private Ticket ticket3 = new Ticket(3, "MSK", "IJK", 800, 420);
    private Ticket ticket4 = new Ticket(4, "IJK", "Kazan", 1500, 450);
    private Ticket ticket5 = new Ticket(5, "Volgograd", "Rostov", 1200, 700);


    @Test

    public void ticketSortTest() {
        manager.save(ticket1);
        manager.save(ticket2);
        manager.save(ticket3);
        manager.save(ticket4);
        manager.save(ticket5);
        Ticket[] expected = {ticket3, ticket1};
        Ticket[] actual = manager.findAll("MSK", "IJK");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void ticketOneTest() {
        manager.save(ticket1);
        manager.save(ticket2);
        manager.save(ticket3);
        manager.save(ticket4);
        manager.save(ticket5);
        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.findAll("Volgograd", "Rostov");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void ticketTest() {
        manager.save(ticket1);
        manager.save(ticket2);
        manager.save(ticket3);
        manager.save(ticket4);
        manager.save(ticket5);
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("Vologda", "Saransk");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void ticketToTest() {
        manager.save(ticket1);
        manager.save(ticket2);
        manager.save(ticket3);
        manager.save(ticket4);
        manager.save(ticket5);
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("IJK", "MSK");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void ticketMaxPriceTest() {
        manager.save(ticket1);
        manager.save(ticket2);
        manager.save(ticket3);
        manager.save(ticket4);
        manager.save(ticket5);

        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.findAll("IJK", "Kazan");

        Assertions.assertArrayEquals(expected, actual);
    }

}