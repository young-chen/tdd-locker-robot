package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.InvalidTicketException;
import cn.xpbootcamp.gilded_rose.exception.NoEmptyCapacityException;

import java.util.HashSet;
import java.util.Set;

public class Locker {
    public final static int CAPACITY = 19;
    private Set<Ticket> spaces = new HashSet<Ticket>();

    public int getEmptyCapacity() {
        return CAPACITY - spaces.size();
    }

    public boolean hasEmptySpace() {
        return (CAPACITY - spaces.size()) != 0;
    }

    public Ticket deposit() throws NoEmptyCapacityException {
        if (getEmptyCapacity() != 0) {
            Ticket ticket = new Ticket();
            spaces.add(ticket);
            return ticket;
        } else {
            throw new NoEmptyCapacityException();
        }
    }

    public boolean fetch(Ticket ticket) throws InvalidTicketException {
        if (spaces.remove(ticket)) {
            return true;
        } else {
            throw new InvalidTicketException();
        }
    }

    public boolean contains(Ticket ticket) {
        return spaces.contains(ticket);
    }
}
