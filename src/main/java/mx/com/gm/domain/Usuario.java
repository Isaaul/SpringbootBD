
package mx.com.gm.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
//import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Usuario") // nombre exacto de la tabla de datos 
public class Usuario implements Serializable {
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idUsuario;

@NotEmpty
private String username;

@NotEmpty
private String password;


@OneToMany
@JoinColumn(name="id_usuario")
private List<Rol> roles;


}
