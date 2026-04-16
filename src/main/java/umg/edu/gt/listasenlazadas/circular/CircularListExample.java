package umg.edu.gt.listasenlazadas.circular;

/**
 * Ejemplo didactico de operaciones con lista circularmente enlazada.
 */
public final class CircularListExample {

    private CircularListExample() {
    }

    public static void run() {
        CircularLinkedList<String> turno = new CircularLinkedList<>();
        turno.addLast("Jugador 1");
        turno.addLast("Jugador 2");
        turno.addLast("Jugador 3");
        turno.addLast("Jugador 4");

        System.out.println("--- Lista Circular ---");
        System.out.println("Participantes: " + turno);
        System.out.println("Contiene 'Jugador 3': " + turno.contains("Jugador 3"));
        System.out.println("Saltos para llegar a 'Jugador 3': " + turno.jumpsToValue("Jugador 3"));
        System.out.println("Saltos para llegar a 'Jugador 1': " + turno.jumpsToValue("Jugador 1"));

        System.out.println("Eliminado (removeFirst): " + turno.removeFirst());
        System.out.println("Estado tras eliminacion: " + turno);

        turno.remove("Jugador 3");
        System.out.println("Tras remove('Jugador 3'): " + turno);

        System.out.println();
    }
}
