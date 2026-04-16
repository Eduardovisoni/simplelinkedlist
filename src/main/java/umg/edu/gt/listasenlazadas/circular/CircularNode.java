package umg.edu.gt.listasenlazadas.circular;

/**
 * Nodo para lista circularmente enlazada.
 *
 * @param <T> tipo de dato almacenado
 */
final class CircularNode<T> {
    private final T value;
    private CircularNode<T> next;

    CircularNode(T value) {
        this.value = value;
    }

    T getValue() {
        return value;
    }

    CircularNode<T> getNext() {
        return next;
    }

    void setNext(CircularNode<T> next) {
        this.next = next;
    }
}
