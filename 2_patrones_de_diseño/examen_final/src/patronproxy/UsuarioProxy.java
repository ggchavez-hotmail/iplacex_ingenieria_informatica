package patronproxy;

import java.util.logging.Logger;

public class UsuarioProxy implements IUsuario {
    private IUsuario usuarioPerfil;
    private final static Logger LOGGER = Logger.getLogger(UsuarioProxy.class.getName());

    public UsuarioProxy(IUsuario usuarioPerfil) {
        this.usuarioPerfil = usuarioPerfil;
    }

    @Override
    public Usuario validarLoging(String nombre, String password) {
        LOGGER.info("---Intento logeo usuario: " + nombre);
        usuarioPerfil = new UsuarioValidoImpl();
        return usuarioPerfil.validarLoging(nombre, password);
    }
}
