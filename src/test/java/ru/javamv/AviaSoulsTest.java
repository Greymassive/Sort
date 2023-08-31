package ru.javamv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Норильск", "Караганда", 12000, 12, 17);
    Ticket ticket2 = new Ticket("Владимир", "Москва", 8000, 10, 13);
    Ticket ticket3 = new Ticket("Москва", "Санкт-Петербург", 5000, 8, 10);
    Ticket ticket4 = new Ticket("Москва", "Санкт-Петербург", 8000, 8, 11);
    Ticket ticket5 = new Ticket("Москва", "Санкт-Петербург", 4000, 8, 12);



    @Test
    public void shouldCompareTo() {
        int expected = 1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldSearchIfOneTicket() {
        AviaSouls as = new AviaSouls();
        as.add(ticket1);
        as.add(ticket2);
        as.add(ticket3);
        as.add(ticket4);
        as.add(ticket5);

        Ticket[] expected = { ticket1 };
        Ticket[] actual = as.search("Норильск", "Караганда");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchIfThereAreNoTickets() {
        AviaSouls as = new AviaSouls();
        as.add(ticket1);
        as.add(ticket2);
        as.add(ticket3);
        as.add(ticket4);
        as.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = as.search("Бишкек", "Кушкек");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchAndSort() {
        AviaSouls as = new AviaSouls();
        as.add(ticket1);
        as.add(ticket2);
        as.add(ticket3);
        as.add(ticket4);
        as.add(ticket5);

        Ticket[] expected = { ticket5, ticket3, ticket4 };
        Ticket[] actual = as.search("Москва", "Санкт-Петербург");
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldUseComparator() {
        TicketTimeComparator tc = new TicketTimeComparator();

        int expected = 1;
        int actual = tc.compare(ticket1, ticket4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchWithComparator() {
        AviaSouls as = new AviaSouls();
        as.add(ticket1);
        as.add(ticket2);
        as.add(ticket3);
        as.add(ticket4);
        as.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket3, ticket4, ticket5};
        Ticket[] actual = as.searchAndSortBy("Москва", "Санкт-Петербург", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWithComparatorIfOneTicket() {
        AviaSouls as = new AviaSouls();
        as.add(ticket1);
        as.add(ticket2);
        as.add(ticket3);
        as.add(ticket4);
        as.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = { ticket1 };
        Ticket[] actual = as.searchAndSortBy("Норильск", "Караганда", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWithComparatorIfNoTickets() {
        AviaSouls as = new AviaSouls();
        as.add(ticket1);
        as.add(ticket2);
        as.add(ticket3);
        as.add(ticket4);
        as.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = as.searchAndSortBy("Чебаркуль", "Нижние Пупки", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
