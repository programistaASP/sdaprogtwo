package pl.sdacademy.prog.Kolejki;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;

public class SdaQueue <T>extends AbstractQueue<T> {
    private LinkedList<T> elements = new LinkedList<>();

    public boolean offer(final T elem) {
        elements.addLast(elem);
        return true;
    }
    public T peek() {
        return elements.getLast();
    }

    public T poll() {
        return elements.removeFirst();
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }

    @Override
    public int size() {
        return 0;
    }
}
