package cn.xpbootcamp.gilded_rose;

public class Locker {

    private Boolean[] boxs;

    public Locker(int capacity) {
        boxs = new Boolean[capacity];
        for (int i = 0; i < boxs.length; i++) {
            boxs[i] = true;
        }
    }

    public Ticket checkIn() {
        Ticket ticket = new Ticket();
        for (int i = 0; i < boxs.length; i++) {
            Boolean isEmpty = boxs[i];
            if (isEmpty) {
                ticket.setNumber(i + 1);
                boxs[i] = false;
                break;
            }
        }
        return ticket;
    }

    public int getEmptyBoxQuantity() {
        int titleEmpty = 0;
        for (int i = 0; i < boxs.length; i++) {
            if (boxs[i]) titleEmpty++;
        }
        return titleEmpty;
    }
}
