package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //indicamos que es una clase servicio para poder inyectarlo.
public class PersonasServiceImpl implements PersonasService {
    

//metodos transaccionales en caso de Error tiene que hacer un roll back y no guardar ninguna informacion 
//y si exitoso tiene que hacer un comit y guardar la transaccion 


    @Autowired
    private PersonaDao personaDao;
    
    @Override
    @Transactional (readOnly = true) //paquete de spring , y read only 
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();
    }
    
    @Override
    @Transactional // hace comit y rolback
    public void guardar(Persona persona) {
        personaDao.save(persona);
        
    }
    
    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
        
    }
    
    @Override
    @Transactional (readOnly = true)
    public Persona enocntrarPersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
    
}
