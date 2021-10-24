package proxy;

public class App {
    public static void main(String[] args) {
        IUsuario usuProxy = new UsuarioProxy( new UsuarioAImpl());
        
        Usuario usu = usuProxy.validarLoging("Roberto", "12345");
        
        if (usu != null) {
            System.out.println("Bienvenido estimado " + usu.getPerfil());
        } else {
            System.out.println("Correo Electronico/Contrasena invalida");
        }
    }
}
