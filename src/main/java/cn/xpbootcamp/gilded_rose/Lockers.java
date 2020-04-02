package cn.xpbootcamp.gilded_rose;

import java.util.ArrayList;
import java.util.List;

public class Lockers {
    private List<Locker> members = new ArrayList<>();

    public void add(Locker locker) {
        members.add(locker);
    }

    public int getEmptyCapacity() {
        int emptyCapacity = 0;
        for (Locker locker : members) {
            emptyCapacity += locker.getEmptyCapacity();
        }
        return emptyCapacity;
    }

    public int size() {
        return members.size();
    }

    public Locker get(int number) {
        return members.get(number);
    }
}
