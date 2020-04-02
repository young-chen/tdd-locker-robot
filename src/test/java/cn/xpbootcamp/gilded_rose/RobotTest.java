package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.InvalidTicketException;
import cn.xpbootcamp.gilded_rose.exception.NoEmptyCapacityException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RobotTest {

    @Test
    void should_return_ticket_and_decrease_empty_capacity_when_use_robot_depositing_given_locker_has_empty_capacity() throws NoEmptyCapacityException {
        Lockers lockers = new Lockers();
        lockers.add(new Locker());
        int emptyCapacityBeforeDeposit = lockers.getEmptyCapacity();
        Robot robot = new Robot(lockers);
        Ticket ticket = robot.deposit();
        assertNotNull(ticket);
        assertThat(lockers.getEmptyCapacity()).isEqualTo(emptyCapacityBeforeDeposit - 1);
    }

    @Test
    void should_return_ticket_and_decrease_empty_capacity_when_use_robot_depositing_given_locker_1_is_full_and_locker_2_has_empty_capacity() throws NoEmptyCapacityException {
        Lockers lockers = new Lockers();
        Locker locker1 = new Locker();
        Locker locker2 = new Locker();
        for (int i = 0; i < Locker.CAPACITY; i++) {
            locker1.deposit();
        }
        lockers.add(locker1);
        lockers.add(locker2);
        int emptyCapacityBeforeDeposit = lockers.getEmptyCapacity();
        Robot robot = new Robot(lockers);
        Ticket ticket = robot.deposit();
        assertNotNull(ticket);
        assertThat(lockers.getEmptyCapacity()).isEqualTo(emptyCapacityBeforeDeposit - 1);
    }

    @Test
    void should_release_used_space_and_increase_empty_capacity_when_use_robot_fetch_given_no_used_ticket_and_one_locker() throws NoEmptyCapacityException, InvalidTicketException {
        Lockers lockers = new Lockers();
        lockers.add(new Locker());
        Robot robot = new Robot(lockers);
        Ticket ticket = robot.deposit();
        int emptyCapacityBeforeFetch = lockers.getEmptyCapacity();
        assertThat(robot.fetch(ticket)).isTrue();
        assertThat(lockers.getEmptyCapacity()).isEqualTo(emptyCapacityBeforeFetch + 1);
    }

    @Test
    void should_release_locker_2_used_space_and_increase_empty_capacity_when_use_robot_fetching_given_locker_2_no_used_ticket_and_two_locker() throws NoEmptyCapacityException, InvalidTicketException {
        Lockers lockers = new Lockers();
        Locker locker1 = new Locker();
        Locker locker2 = new Locker();
        for (int i = 0; i < Locker.CAPACITY; i++) {
            locker1.deposit();
        }
        lockers.add(locker1);
        lockers.add(locker2);
        Robot robot = new Robot(lockers);
        Ticket ticket = robot.deposit();
        int titleEmptyCapacityBeforeFetch = lockers.getEmptyCapacity();
        int locker2EmptyCapacityBeforeFetch = locker2.getEmptyCapacity();
        assertThat(robot.fetch(ticket)).isTrue();
        assertThat(lockers.getEmptyCapacity()).isEqualTo(titleEmptyCapacityBeforeFetch + 1);
        assertThat(locker2.getEmptyCapacity()).isEqualTo(locker2EmptyCapacityBeforeFetch + 1);
    }
}
