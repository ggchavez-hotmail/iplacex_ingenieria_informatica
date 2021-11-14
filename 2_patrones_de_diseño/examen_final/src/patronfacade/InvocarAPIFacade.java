package patronfacade;

import java.util.List;

import modelo.SCex;
import modelo.Slafi;
import patroncomposite.Persona;
import patroncomposite.SCexEmpleados;
import patroncomposite.SCexFFAA;
import patroncomposite.TotalPension;
import patroniterator.AgregadoConcreto;
import patroniterator.Iterador;
import patronproxy.IUsuario;
import patronproxy.Usuario;
import patronproxy.UsuarioProxy;
import patronproxy.UsuarioValidoImpl;

public class InvocarAPIFacade {
    public String login(String nombre, String password) {
        InvocarAPI invocarAPI = new InvocarAPI();
        List<Usuario> jsonAnswer = invocarAPI.invocarAPIUsuarios("http://localhost:3000/", "Usuarios", nombre,
                password);

        return invocarAPI.validarUsuario(jsonAnswer);
    }

    public void mostrarContribucionesSlafi() {
        int contribuciones = 0;
        InvocarAPI invocarAPI = new InvocarAPI();
        List<Slafi> jsonAnswer = invocarAPI.invocarAPISlafi("http://localhost:3000/", "Slafi");

        for (Slafi item : jsonAnswer) {
            contribuciones += item.getContribucion();

        }

        System.out.println("Total Contribuciones: " + contribuciones);
    }

    public void mostrarListadoPensionadosSipen() {

        AgregadoConcreto agregado = new AgregadoConcreto();
        Iterador iterador = agregado.getIterador();

        while (iterador.hayMas() == true) {
            System.out.println(iterador.siguiente());
        }

    }

    public void mostrarSumaPensionesExcluSCex() {

        InvocarAPI invocarAPI = new InvocarAPI();
        List<SCex> jsonAnswer = invocarAPI.invocarAPISCex("http://localhost:3000/", "SCex");

        TotalPension total = new TotalPension();

        SCexEmpleados tipoEmpleados = new SCexEmpleados();
        SCexFFAA tipoFFAA = new SCexFFAA();

        total.agregar(tipoEmpleados);
        total.agregar(tipoFFAA);

        for (SCex item : jsonAnswer) {
            Persona n = new Persona(item.getNombre(), item.getApellido(), item.getEdad(), item.getPension(),
                    item.getAfp());
            if (item.getExclusion().equals("FFAA")) {
                tipoEmpleados.agregar(n);
            } else if (item.getExclusion().equals("Empleado")) {
                tipoFFAA.agregar(n);
            }
        }

        System.out.println("Suma Excluidos FFAA: " + tipoEmpleados.getPension());
        System.out.println("Suma Excluidos Empleado: " + tipoFFAA.getPension());

    }

    public boolean intentarLogin(String nombre, String password) {

        IUsuario usuProxy = new UsuarioProxy(new UsuarioValidoImpl());
        Usuario usu = usuProxy.validarLoging(nombre, password);

        if (usu.getHabilitado() != null) {
            if (usu.getHabilitado().equals("True")) {
                System.out.println("---<START>---");
                return true;
            } else {
                System.out.println("...Error: Login incorrecto.");
                System.out.println("--------------------------");
                return false;
            }
        } else {
            System.out.println("...Error: Login incorrecto.");
            System.out.println("--------------------------");
            return false;
        }
    }
}
