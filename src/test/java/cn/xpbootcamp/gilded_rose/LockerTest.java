package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LockerTest {

    @Test
    void should_return_right_number_ticket_when_check_in_given_free_box_quantity_between_1_and_19() {
        Locker locker = new Locker(19);
        Ticket ticket = locker.checkIn();
        assertThat(ticket.getNumber()).isBetween(1, 19);
    }

    @Test
    void should_return_right_empty_quantity_when_check_in_given_free_box_quantity_between_1_and_19() {
        Locker locker = new Locker(19);
        int oldFreeBoxQuantity = locker.getEmptyBoxQuantity();
        locker.checkIn();
        assertThat(oldFreeBoxQuantity - 1).isEqualTo(locker.getEmptyBoxQuantity());
    }
}
