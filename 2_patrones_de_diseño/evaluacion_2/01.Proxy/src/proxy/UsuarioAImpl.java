package proxy;

public class UsuarioAImpl implements IUsuario {

    @Override
    public Usuario validarLoging(String correoElectronico, String contrasenia) {
        Usuario usu = new Usuario("Roberto", "1234", "Cliente");

        if (correoElectronico == usu.getUsuario() && contrasenia == usu.getPassword()) {
            return usu;
        } else {
            usu = null;
            return usu;
        }
    }

}
