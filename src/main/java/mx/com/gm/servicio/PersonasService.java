package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Persona;

//interface CRUD=Creat,REad  ,Update,delete 
public interface PersonasService {
    


public List<Persona> listarPersonas();

public void guardar(Persona persona);

public void eliminar (Persona persona);

public Persona enocntrarPersona(Persona persona); 



}
