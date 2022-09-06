package mx.com.gm.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
//Clase para encriptar el password solamente lo corremos y nos genera una clave en la salida
// o log copiamos y pegamos en la base de datos en password


    public static void main(String[] args) {

        String password = "123";
        System.out.println("password: "+ password);
        System.out.println("password encriptado:  "+encriptarPassword(password));
    }

    public static String encriptarPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);

    }

}
