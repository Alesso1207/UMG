import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona {
    private List<Tarea> tareasAsignadas;

    public Usuario(String nombre, String id) {
        super(nombre, id);
        this.tareasAsignadas = new ArrayList<>();
    }

    public void asignarTarea(Tarea tarea) {
        this.tareasAsignadas.add(tarea);
    }

    public List<Tarea> getTareasAsignadas() {
        return tareasAsignadas;
    }
}
