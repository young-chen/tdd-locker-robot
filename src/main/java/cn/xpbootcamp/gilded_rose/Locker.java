package cn.xpbootcamp.gilded_rose;

import java.util.HashSet;
import java.util.Set;

public class Locker {
    public final static int CAPACITY = 19;
    private Set<Ticket> spaces = new HashSet<Ticket>();

    public int getEmptyCapacity() {
        return CAPACITY - spaces.size();
    }

    public Ticket deposit() throws NoEmptyCapacityException {
        Ticket ticket = new Ticket();
        if (getEmptyCapacity() != 0) {
            spaces.add(ticket);
        } else {
            throw new NoEmptyCapacityException();
        }
        return ticket;
    }

    public boolean fetch(Ticket ticket) throws InvalidTicketException {
        if (spaces.remove(ticket)) {
            return true;
        } else {
            throw new InvalidTicketException();
        }
    }
}
