package patronproxy;

import patronfacade.InvocarAPIFacade;

public class UsuarioValidoImpl implements IUsuario {

    @Override
    public Usuario validarLoging(String nombre, String password) {
        Usuario usu = new Usuario();// nombre, password, "False");
        usu.setNombre(nombre);
        usu.setPassword(password);

        InvocarAPIFacade invocarAPIFacade = new InvocarAPIFacade();
        usu.setHabilitado(invocarAPIFacade.login(nombre, password));

        return usu;
    }

}
