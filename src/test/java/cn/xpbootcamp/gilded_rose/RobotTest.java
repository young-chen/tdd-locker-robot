package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.NoEmptyCapacityException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RobotTest {

    @Test
    void should_return_ticket_and_decrease_empty_capacity_when_use_robot_depositing_given_locker_1_has_empty_capacity() throws NoEmptyCapacityException {
        Lockers lockers = new Lockers();
        lockers.add(new Locker());
        int emptyCapacityBeforeDeposit = lockers.getEmptyCapacity();
        Robot robot = new Robot(lockers);
        Ticket ticket = robot.deposit();
        assertNotNull(ticket);
        assertThat(lockers.getEmptyCapacity()).isEqualTo(emptyCapacityBeforeDeposit - 1);
    }
}
