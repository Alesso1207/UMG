import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            SistemaDeGestion sistema = new SistemaDeGestion();

            Usuario usuario1 = new Usuario("Juan Pérez", "U001");
            Usuario usuario2 = new Usuario("María Gómez", "U002");

            sistema.registrarUsuario(usuario1);
            sistema.registrarUsuario(usuario2);

            Proyecto proyecto1 = new Proyecto("Proyecto A", "Descripción del Proyecto A",
                    sdf.parse("01-08-2024"), sdf.parse("31-12-2024"));

            Proyecto proyecto2 = new Proyecto("Proyecto B", "Descripción del Proyecto B",
                    sdf.parse("01-09-2024"), sdf.parse("31-12-2024"));

            sistema.registrarProyecto(proyecto1);
            sistema.registrarProyecto(proyecto2);

            Tarea tarea1 = new Tarea("Tarea 1", "Descripción de Tarea 1",
                    sdf.parse("15-08-2024"), "Alta", "Pendiente");

            Tarea tarea2 = new Tarea("Tarea 2", "Descripción de Tarea 2",
                    sdf.parse("20-08-2024"), "Media", "Pendiente");

            Tarea tarea3 = new Tarea("Tarea 3", "Descripción de Tarea 3",
                    sdf.parse("25-08-2024"), "Baja", "Pendiente");

            sistema.asignarTareaAProyecto("Proyecto A", tarea1);
            sistema.asignarTareaAProyecto("Proyecto A", tarea2);
            sistema.asignarTareaAProyecto("Proyecto B", tarea3);

            sistema.asignarTareaAUsuario("U001", tarea1);
            sistema.asignarTareaAUsuario("U002", tarea2);
            sistema.asignarTareaAUsuario("U002", tarea3);

            System.out.println("Tareas del Proyecto A:");
            for (Tarea tarea : sistema.consultarProyecto("Proyecto A").getTareas()) {
                System.out.println(tarea.getTitulo() + " - " + tarea.getEstado());
            }

            tarea1.cambiarEstado("En Progreso");

            System.out.println("\nTareas asignadas a María Gómez:");
            for (Tarea tarea : sistema.consultarUsuario("U002").getTareasAsignadas()) {
                System.out.println(tarea.getTitulo() + " - " + tarea.getEstado());
            }

        } catch (ProyectoNoEncontradoException | UsuarioNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
