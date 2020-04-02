package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.NoEmptyCapacityException;

public class Robot {
    private Lockers lockers;

    public Robot(Lockers lockers) {
        this.lockers = lockers;
    }

    public Ticket deposit() throws NoEmptyCapacityException {
        Ticket ticket = null;
        for (int i = 0; i < lockers.size(); i++) {
            if (lockers.get(i).getEmptyCapacity() != 0) {
                ticket = lockers.get(i).deposit();
            }
        }
        return ticket;
    }
}
