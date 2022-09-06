
package mx.com.gm.dao;

import mx.com.gm.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

//JPa es interface y ponemos la clase interface 
public interface UsuarioDao extends JpaRepository<Usuario,Long> {
    Usuario findByUsername(String username); //framwork de spring security recupera un objeto de tipo usuario y lo hace en automatico 
}

