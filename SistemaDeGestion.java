import java.util.HashMap;
import java.util.Map;

public class SistemaDeGestion {
    private Map<String, Proyecto> proyectos;
    private Map<String, Usuario> usuarios;

    public SistemaDeGestion() {
        this.proyectos = new HashMap<>();
        this.usuarios = new HashMap<>();
    }

    public void registrarProyecto(Proyecto proyecto) {
        proyectos.put(proyecto.getNombre(), proyecto);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }

    public void asignarTareaAProyecto(String nombreProyecto, Tarea tarea) throws ProyectoNoEncontradoException {
        Proyecto proyecto = proyectos.get(nombreProyecto);
        if (proyecto == null) {
            throw new ProyectoNoEncontradoException("Proyecto no encontrado.");
        }
        proyecto.agregarTarea(tarea);
    }

    public void asignarTareaAUsuario(String idUsuario, Tarea tarea) throws UsuarioNoEncontradoException {
        Usuario usuario = usuarios.get(idUsuario);
        if (usuario == null) {
            throw new UsuarioNoEncontradoException("Usuario no encontrado.");
        }
        usuario.asignarTarea(tarea);
    }

    public Proyecto consultarProyecto(String nombreProyecto) throws ProyectoNoEncontradoException {
        Proyecto proyecto = proyectos.get(nombreProyecto);
        if (proyecto == null) {
            throw new ProyectoNoEncontradoException("Proyecto no encontrado.");
        }
        return proyecto;
    }

    public Usuario consultarUsuario(String idUsuario) throws UsuarioNoEncontradoException {
        Usuario usuario = usuarios.get(idUsuario);
        if (usuario == null) {
            throw new UsuarioNoEncontradoException("Usuario no encontrado.");
        }
        return usuario;
    }
}
