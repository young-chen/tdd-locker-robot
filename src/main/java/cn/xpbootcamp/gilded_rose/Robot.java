package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.NoEmptyCapacityException;

public class Robot {
    private Lockers lockers;

    public Robot(Lockers lockers) {
        this.lockers = lockers;
    }

    public Ticket deposit() throws NoEmptyCapacityException {
        for (int i = 0; i < lockers.size(); i++) {
            if (lockers.get(i).getEmptyCapacity() != 0) {
                return lockers.get(i).deposit();
            }
        }
        throw new NoEmptyCapacityException();
    }
}
