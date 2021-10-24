package proxy;

import java.util.logging.Logger;

public class UsuarioProxy implements IUsuario {
    private IUsuario usuarioPerfil;
    private final static Logger LOGGER = Logger.getLogger(UsuarioProxy.class.getName());

    public UsuarioProxy(IUsuario usuarioPerfil) {
        this.usuarioPerfil = usuarioPerfil;
    }

    @Override
    public Usuario validarLoging(String correoElectronico, String contrasenia) {
        LOGGER.info("---Intento logeo usuario: " + correoElectronico);
        usuarioPerfil = new UsuarioAImpl();
        return usuarioPerfil.validarLoging(correoElectronico, contrasenia);
    }
}
