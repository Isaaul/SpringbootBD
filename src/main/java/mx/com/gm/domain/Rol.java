package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
//import javax.persistence.Table;
import lombok.Data;
//mapeo de la tabla rol 

@Entity
@Data
@Table(name="Rol")
public class Rol implements Serializable {
private static final long serialVersionUID = 1L;

@Id //indicamos que es la llave primaria
@GeneratedValue(strategy = GenerationType.IDENTITY) //indicamos como se genera
private Long idRol;

@NotEmpty // no puede estar vacio 
private String nombre;    
}
