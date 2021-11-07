package factorymethod;

public class ConexionFabrica {
    public IConector getConector(String opcion) {
        switch (opcion) {
        case "Sucursal1":
            return new ConexionSucursal1();
        case "Sucursal2":
            return new ConexionSucursal2();
        case "Sucursal3":
            return new ConexionSucursal3();
        case "Sucursal4":
            return new ConexionSucursal4();
        case "Sucursal5":
            return new ConexionSucursal5();
        case "Sucursal6":
            return new ConexionSucursal6();
        case "Sucursal7":
            return new ConexionSucursal7();
        case "Sucursal8":
            return new ConexionSucursal8();
        default:
            return null;
        }
    }
}
