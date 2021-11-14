package principal;

import java.util.Scanner;

import patronfacade.InvocarAPIFacade;

public class App {
    public final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("-----------------------------------------");
        System.out.println("B i e n v e n i d o  a  P R E O N L I N E");
        System.out.println("-----------------------------------------");

        if (Login()) {
            Menu();
        } else {
            System.out.println("...Error: Maximo de intentos superado.");
        }

        System.out.println("-----------------------------");
        System.out.println(". . . h a s t a  P r o n t o ");
        System.out.println("-----------------------------");

    }

    public static boolean Login() {
        String user = "";
        String pass = "";
        boolean login = false;
        int intentos = 4;
        while (login == false && intentos > 0) {
            intentos--;
            System.out.println("Introduce usuario: ");
            user = scanner.nextLine();
            System.out.println("Introduce password: ");
            pass = scanner.nextLine();

            InvocarAPIFacade invocarAPIFacade = new InvocarAPIFacade();
            login = invocarAPIFacade.intentarLogin(user, pass);
            if (login == false) {
                System.out.println("Intentos restantes: " + intentos);
                System.out.println("--------------------------");
            }
        }
        return login;
    }

    public static void Menu() {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println(".                               ");
            System.out.println("--------------------------------");
            System.out.println("E l i g e  o p c i o n  M e n u ");
            System.out.println("--------------------------------");
            System.out.println("       1. Afiliado              ");
            System.out.println("       2. Pensionado            ");
            System.out.println("       3. Excluido              ");
            System.out.println("       4. Salir                 ");
            opcion = scanner.nextInt();
            try {
                switch (opcion) {
                case 1:
                    System.out.println("-----------------------------------------");
                    System.out.println("...Afiliado");
                    System.out.println("-----------------------------------------");
                    Afiliado();
                    break;
                case 2:
                    System.out.println("-----------------------------------------");
                    System.out.println("...Pensionado");
                    System.out.println("-----------------------------------------");
                    Pensionado();
                    break;
                case 3:
                    System.out.println("-----------------------------------------");
                    System.out.println("...Excluido");
                    System.out.println("-----------------------------------------");
                    Excluido();
                    break;
                case 4:
                    System.out.println("-----------------------------------------");
                    System.out.println("...Saliendo");
                    System.out.println("-----------------------------------------");
                    break;
                default:
                    System.out.println("-----------------------------------------");
                    System.out.println("...Opcion no valida");
                    System.out.println("-----------------------------------------");
                    break;
                }
            } catch (Exception e) {
                System.out.println("-----------------------------------------");
                System.out.println("...Opcion no valida");
                System.out.println("-----------------------------------------");
            }
        }
    }

    public static void Afiliado() {
        InvocarAPIFacade invocarAPIFacade = new InvocarAPIFacade();
        invocarAPIFacade.mostrarContribucionesSlafi();
    }

    public static void Pensionado() {
        InvocarAPIFacade invocarAPIFacade = new InvocarAPIFacade();
        invocarAPIFacade.mostrarListadoPensionadosSipen();
    }

    public static void Excluido() {
        InvocarAPIFacade invocarAPIFacade = new InvocarAPIFacade();
        invocarAPIFacade.mostrarSumaPensionesExcluSCex();
    }
}