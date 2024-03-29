package pl.sdacademy.prog.Kolejki;

public class SDAPriorityElements<T ,P extends Comparable<P>> {
    private T value;
    private P priority;

    public SDAPriorityElements(final T value, final P priority) {
        this.value = value;
        this.priority = priority;
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public P getPriority() {
        return priority;
    }

    public void setPriority(final P priority) {
        this.priority = priority;
    }
}
