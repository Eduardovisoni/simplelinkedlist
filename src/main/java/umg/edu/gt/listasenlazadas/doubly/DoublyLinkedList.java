package umg.edu.gt.listasenlazadas.doubly;

/**
 * Implementacion de una lista doblemente enlazada.
 *
 * @param <T> tipo de dato almacenado
 */
public class DoublyLinkedList<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    private int size;

    public void addFirst(T value) {
        DoublyNode<T> newNode = new DoublyNode<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        size++;
    }

    public void addLast(T value) {
        DoublyNode<T> newNode = new DoublyNode<>(value);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) {
            return null;
        }
        T value = head.getValue();
        head = head.getNext();
        if (head == null) {
            tail = null;
        } else {
            head.setPrevious(null);
        }
        size--;
        return value;
    }

    public T removeLast() {
        if (tail == null) {
            return null;
        }
        T value = tail.getValue();
        tail = tail.getPrevious();
        if (tail == null) {
            head = null;
        } else {
            tail.setNext(null);
        }
        size--;
        return value;
    }

    public boolean contains(T value) {
        DoublyNode<T> current = head;
        while (current != null) {
            if (isSameValue(current.getValue(), value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public int countOccurrences(T value) {
        int count = 0;
        DoublyNode<T> current = head;
        while (current != null) {
            if (isSameValue(current.getValue(), value)) {
                count++;
            }
            current = current.getNext();
        }
        return count;
    }

    public int clean() {
        int count = 0;
        DoublyNode<T> current = head;
        while (current != null) {
            DoublyNode<T> next = current.getNext();
            current.setNext(null);
            current.setPrevious(null);
            current = next;
            count++;
        }
        head = null;
        tail = null;
        size = 0;
        return count;
    }

    public void reverseInPlace() {
        DoublyNode<T> current = head;
        DoublyNode<T> temp = null;

        while (current != null) {
            temp = current.getPrevious();
            current.setPrevious(current.getNext());
            current.setNext(temp);
            current = current.getPrevious();
        }

        temp = head;
        head = tail;
        tail = temp;
    }

    public int removeDuplicates() {
        int removed = 0;
        DoublyNode<T> current = head;

        while (current != null) {
            DoublyNode<T> runner = current;

            while (runner.getNext() != null) {
                if (isSameValue(runner.getNext().getValue(), current.getValue())) {
                    DoublyNode<T> duplicate = runner.getNext();
                    runner.setNext(duplicate.getNext());

                    if (duplicate.getNext() != null) {
                        duplicate.getNext().setPrevious(runner);
                    }

                    if (duplicate == tail) {
                        tail = runner;
                    }

                    duplicate.setNext(null);
                    duplicate.setPrevious(null);
                    size--;
                    removed++;
                } else {
                    runner = runner.getNext();
                }
            }

            current = current.getNext();
        }

        return removed;
    }

    /**
     * RETO 3 (global):
     * Retorna la posicion de un valor contando desde el tail (0 = tail).
     * Aprovecha el enlace previous para recorrer en sentido inverso.
     *
     * Ejemplo con [A, B, C, D]:
     * - indexFromTail("D") = 0
     * - indexFromTail("C") = 1
     * - indexFromTail("B") = 2
     *
     * @param value valor a buscar
     * @return indice desde el tail, o -1 si no existe
     */
    public int indexFromTail(T value) {
        int index = 0;
        DoublyNode<T> current = tail;
        while (current != null) {
            if (isSameValue(current.getValue(), value)) {
                return index;
            }
            current = current.getPrevious();
            index++;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toForwardString() {
        StringBuilder builder = new StringBuilder("[");
        DoublyNode<T> current = head;
        while (current != null) {
            builder.append(current.getValue());
            if (current.getNext() != null) {
                builder.append(", ");
            }
            current = current.getNext();
        }
        builder.append("]");
        return builder.toString();
    }

    public String toBackwardString() {
        StringBuilder builder = new StringBuilder("[");
        DoublyNode<T> current = tail;
        while (current != null) {
            builder.append(current.getValue());
            if (current.getPrevious() != null) {
                builder.append(", ");
            }
            current = current.getPrevious();
        }
        builder.append("]");
        return builder.toString();
    }

    private boolean isSameValue(T left, T right) {
        return left == right || (left != null && left.equals(right));
    }
}
