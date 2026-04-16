package umg.edu.gt.listasenlazadas.retos;

import umg.edu.gt.listasenlazadas.circular.CircularLinkedList;
import umg.edu.gt.listasenlazadas.doubly.DoublyLinkedList;
import umg.edu.gt.listasenlazadas.simple.SinglyLinkedList;

/**
 * Laboratorio de retos para obligar a extender el codigo base de las estructuras.
 *
 * Cada reto depende de un metodo nuevo que debe implementarse directamente
 * en la clase de estructura correspondiente.
 */
public final class LinkedListChallenges {

    private LinkedListChallenges() {
    }

    public static void run() {
        System.out.println("=== RETOS DE IMPLEMENTACION ===");
        challenge1CountOccurrences();
        challenge2JumpsToValue();
        challenge3IndexFromTail();
        System.out.println();
    }

    private static void challenge1CountOccurrences() {
        SinglyLinkedList<String> eventos = new SinglyLinkedList<>();
        eventos.addLast("LOGIN");
        eventos.addLast("CLICK");
        eventos.addLast("LOGIN");
        eventos.addLast("SCROLL");
        eventos.addLast("LOGIN");

        System.out.println("Reto 1 - Analitica de eventos (lista simple)");
        System.out.println("Eventos: " + eventos);
        try {
            int totalLogins = eventos.countOccurrences("LOGIN");
            System.out.println("Resultado esperado para LOGIN: 3");
            System.out.println("Resultado obtenido: " + totalLogins);
        } catch (UnsupportedOperationException ex) {
            System.out.println(ex.getMessage());
        }

        eventos.clean();
        System.out.println("Eventos: " + eventos + " size: " + eventos.size());

        System.out.println();
    }

    private static void challenge2JumpsToValue() {
        CircularLinkedList<String> ronda = new CircularLinkedList<>();
        ronda.addLast("Jugador 1");
        ronda.addLast("Jugador 2");
        ronda.addLast("Jugador 3");
        ronda.addLast("Jugador 4");

        System.out.println("Reto 2 - Juego de ronda (lista circular)");
        System.out.println("Participantes: " + ronda);
        try {
            int saltos = ronda.jumpsToValue("Jugador 3");
            System.out.println("Resultado esperado para 'Jugador 3': 2");
            System.out.println("Resultado obtenido: " + saltos);
        } catch (UnsupportedOperationException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();
    }

    private static void challenge3IndexFromTail() {
        DoublyLinkedList<String> historial = new DoublyLinkedList<>();
        historial.addLast("Pagina A");
        historial.addLast("Pagina B");
        historial.addLast("Pagina C");
        historial.addLast("Pagina D");

        System.out.println("Reto 3 - Historial de navegacion (lista doble)");
        System.out.println("Historial: " + historial.toForwardString());
        try {
            int indice = historial.indexFromTail("Pagina B");
            System.out.println("Resultado esperado para 'Pagina B' desde el final: 2");
            System.out.println("Resultado obtenido: " + indice);
        } catch (UnsupportedOperationException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();
    }

}
