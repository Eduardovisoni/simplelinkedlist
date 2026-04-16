package umg.edu.gt.listasenlazadas.applications;

import umg.edu.gt.listasenlazadas.doubly.DoublyLinkedList;

/**
 * Caso real: historial de acciones de un editor con deshacer y rehacer.
 */
public final class UndoRedoEditorApp {

    private UndoRedoEditorApp() {
    }

    public static void run() {
        DoublyLinkedList<String> historial = new DoublyLinkedList<>();

        System.out.println("3) UndoRedoEditorApp");
        historial.addLast("Escribir: Hola");
        historial.addLast("Escribir: mundo");
        historial.addLast("Negrita: mundo");
        System.out.println("Acciones realizadas: " + historial.toForwardString());

        System.out.println("Deshacer: " + historial.removeLast());
        System.out.println("Deshacer: " + historial.removeLast());
        System.out.println("Estado actual: " + historial.toForwardString());

        historial.addLast("Escribir: Java");
        System.out.println("Nueva accion: " + historial.toForwardString());
        System.out.println("Recorrido inverso: " + historial.toBackwardString());
    }
}
