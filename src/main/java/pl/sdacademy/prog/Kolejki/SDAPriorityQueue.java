package pl.sdacademy.prog.Kolejki;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class SDAPriorityQueue<T, P extends Comparable<P>> extends AbstractQueue<T> {
    private LinkedList<SDAPriorityElements<T, P>> elements = new LinkedList<>();

    private P defaultPriority;

    public SDAPriorityQueue(final P defaultPriority) {
        this.defaultPriority = defaultPriority;
    }

    public boolean offer(final T element) {
        final P priorityToBeInserted = defaultPriority;
        final SDAPriorityElements<T, P> elementToInsert = new SDAPriorityElements<>(element, priorityToBeInserted);
        if (elements.isEmpty()) {
            elements.addFirst(elementToInsert);
            return true;
        }

        for (int idx = 0; idx <= elements.size();idx++) {
            final P actualElementPriority = elements.get(idx).getPriority();
            final int compareResult = priorityToBeInserted.compareTo(actualElementPriority);
            if (compareResult == 1) {
                elements.add(idx, elementToInsert);
                return true;
            }
        }
        elements.addLast(elementToInsert);
        return true;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return elements.stream()
                .map(elem -> elem.getValue())
                .collect(Collectors.toList()).iterator();
    }

    @Override
    public int size() {
        return 0;
    }
}
