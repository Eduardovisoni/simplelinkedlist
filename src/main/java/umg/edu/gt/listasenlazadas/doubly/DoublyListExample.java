package umg.edu.gt.listasenlazadas.doubly;

/**
 * Ejemplo didactico de operaciones con lista doblemente enlazada.
 */
public final class DoublyListExample {

    private DoublyListExample() {
    }

    public static void run() {
        DoublyLinkedList<String> historial = new DoublyLinkedList<>();
        historial.addLast("Inicio");
        historial.addLast("Productos");
        historial.addLast("Detalle");
        historial.addLast("Carrito");

        System.out.println("--- Lista Doble ---");
        System.out.println("Historial forward: " + historial.toForwardString());
        System.out.println("Historial backward: " + historial.toBackwardString());
        System.out.println("Volver (removeLast): " + historial.removeLast());
        System.out.println("Estado actual: " + historial.toForwardString());

        historial.addLast("Pago");
        System.out.println("Navegar a Pago: " + historial.toForwardString());

        int indice = historial.indexFromTail("Productos");
        System.out.println("'Productos' esta a " + indice + " pasos del final");

        DoublyLinkedList<String> duplicados = new DoublyLinkedList<>();
        duplicados.addLast("X");
        duplicados.addLast("Y");
        duplicados.addLast("X");
        duplicados.addLast("Z");
        duplicados.addLast("Y");

        System.out.println("Lista con duplicados: " + duplicados.toForwardString());
        int removidos = duplicados.removeDuplicates();
        System.out.println("Duplicados eliminados: " + removidos);
        System.out.println("Sin duplicados: " + duplicados.toForwardString());

        duplicados.reverseInPlace();
        System.out.println("Invertida: " + duplicados.toForwardString());

        int eliminados = duplicados.clean();
        System.out.println("Nodos eliminados con clean(): " + eliminados);
        System.out.println("Tras clean(): " + duplicados.toForwardString());

        System.out.println();
    }
}
