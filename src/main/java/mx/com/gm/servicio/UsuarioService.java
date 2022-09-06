package mx.com.gm.servicio;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import mx.com.gm.dao.UsuarioDao;
import mx.com.gm.domain.Rol;
import mx.com.gm.domain.Usuario;
import static org.apache.tomcat.jni.User.username;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//indicamos que estaclase es un bean de spring de tipò de servicio
@Service("userDetailsService")//el nombre tiene que ser igual si, cambiamos el nombre tenemmos que agregar mas config 
@Slf4j //la importamos de lombok para el manejo de logs
public class UsuarioService implements UserDetailsService {
//Usuario DAo injectamos
//instancia de tipo usuario dao , interactuamos comn la table de usuario y roles 

    @Autowired
    private UsuarioDao usuarioDao;

//metodo abstracto loadUserByUsername obtiene el ususario el objeto de usuario filtrado por username 
 @Override
@Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
//security en array list implementa 
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol rol : usuario.getRoles()) {
//envolvemos los roles en un nuevo objeto simplegrantAut
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));

        }
//nuevo objeto de tipo User pero es de tipo user de spring Userdetail regresa 
        return new User(usuario.getUsername(), usuario.getPassword(), roles);

    }

}
