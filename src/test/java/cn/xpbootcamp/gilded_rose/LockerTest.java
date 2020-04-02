package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LockerTest {

    @Test
    void should_return_ticket_and_empty_capacity_decrease_when_depositing_given_locker_has_empty_capacity() throws NoEmptyCapacityException {
        Locker locker = new Locker();
        int emptyCapacityBeforeDeposit = locker.getEmptyCapacity();
        Ticket ticket = locker.deposit();
        assertNotNull(ticket);
        assertThat(locker.getEmptyCapacity()).isEqualTo(emptyCapacityBeforeDeposit - 1);
    }

    @Test
    void should_return_no_empty_capacity_when_depositing_given_free_box_quantity_between_1_and_19() throws NoEmptyCapacityException {
        Locker locker = new Locker();
        for (int i = 0; i < Locker.CAPACITY; i++) {
            locker.deposit();
        }
        System.out.println(locker.getEmptyCapacity());
        assertThrows(NoEmptyCapacityException.class, () -> locker.deposit());
    }
}
