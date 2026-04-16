package umg.edu.gt.listasenlazadas.circular;

/**
 * Implementacion de una lista circularmente enlazada.
 *
 * @param <T> tipo de dato almacenado
 */
public class CircularLinkedList<T> {
    private CircularNode<T> head;
    private CircularNode<T> tail;
    private int size;

    public void addLast(T value) {
        CircularNode<T> newNode = new CircularNode<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.setNext(head);
        } else {
            tail.setNext(newNode);
            tail = newNode;
            tail.setNext(head);
        }
        size++;
    }

    public void addFirst(T value) {
        CircularNode<T> newNode = new CircularNode<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.setNext(head);
        } else {
            newNode.setNext(head);
            tail.setNext(newNode);
            head = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) {
            return null;
        }
        T value = head.getValue();
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            tail.setNext(head);
        }
        size--;
        return value;
    }

    public boolean remove(T value) {
        if (head == null) {
            return false;
        }

        if (isSameValue(head.getValue(), value)) {
            removeFirst();
            return true;
        }

        CircularNode<T> previous = head;
        CircularNode<T> current = head.getNext();

        do {
            if (isSameValue(current.getValue(), value)) {
                previous.setNext(current.getNext());
                if (current == tail) {
                    tail = previous;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.getNext();
        } while (current != head);

        return false;
    }

    public boolean contains(T value) {
        if (head == null) {
            return false;
        }
        CircularNode<T> current = head;
        do {
            if (isSameValue(current.getValue(), value)) {
                return true;
            }
            current = current.getNext();
        } while (current != head);
        return false;
    }

    /**
     * RETO 2:
     * Cuenta cuantos saltos (pasos) son necesarios para llegar
     * al primer nodo con el valor dado, comenzando desde head.
     *
     * Reglas sugeridas:
     * - No usar estructuras auxiliares.
     * - Aprovechar la naturaleza circular: detenerse al volver a head.
     * - Si el valor no existe, retornar -1.
     * - Complejidad esperada: O(n).
     *
     * Ejemplo con [A, B, C, D]:
     * - jumpsToValue("A") = 0  (ya estamos ahi)
     * - jumpsToValue("C") = 2
     * - jumpsToValue("Z") = -1
     *
     * @param value valor a buscar
     * @return cantidad de saltos desde head hasta el valor, o -1 si no existe
     */
    public int jumpsToValue(T value) {
        if (head == null) {
            return -1;
        }
        int jumps = 0;
        CircularNode<T> current = head;
        do {
            if (isSameValue(current.getValue(), value)) {
                return jumps;
            }
            current = current.getNext();
            jumps++;
        } while (current != head);
        return -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[] (circular)";
        }
        StringBuilder builder = new StringBuilder("[");
        CircularNode<T> current = head;
        do {
            builder.append(current.getValue());
            current = current.getNext();
            if (current != head) {
                builder.append(", ");
            }
        } while (current != head);
        builder.append("] (circular)");
        return builder.toString();
    }

    private boolean isSameValue(T left, T right) {
        return left == right || (left != null && left.equals(right));
    }
}
