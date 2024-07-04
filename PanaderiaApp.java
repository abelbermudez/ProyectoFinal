import java.util.ArrayList;
import java.util.Scanner;

public class PanaderiaApp {
    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        PanaderiaApp app = new PanaderiaApp();
        app.Menu();
    }

    public void Menu() {
        boolean salir = false;

        while (!salir) {
            System.out.println("Ingrese una opción:");
            System.out.println("1-Agregar productos");
            System.out.println("2-Mostrar Catálogo");
            System.out.println("3-Agregar Cliente");
            System.out.println("4-Realizar Compra");
            System.out.println("5-Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    mostrarCatalogo();
                    break;
                case 3:
                    agregarCliente();
                    break;
                case 4:
                    realizarCompra();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public void agregarProducto() {
        System.out.println("Ingrese los datos del producto:");
        System.out.print("Código: ");
        String codProducto = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Costo: ");
        double costo = scanner.nextDouble();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();

        Producto producto = new Producto(codProducto, nombre, costo, precio);
        productos.add(producto);
    }

    public void mostrarCatalogo() {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public void realizarCompra() {
        System.out.println("Ingrese los datos del cliente:");
        System.out.print("Nombre: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccionCliente = scanner.nextLine();

        Cliente cliente = new Cliente(nombreCliente, direccionCliente);
        Compra compra = new Compra(cliente);

        boolean agregarProductos = true;

        while (agregarProductos) {
            System.out.print("Ingrese el código del producto (o 'fin' para terminar): ");
            String codProducto = scanner.nextLine();

            if (codProducto.equals("fin")) {
                agregarProductos = false;
            } else {
                Producto producto = buscarProducto(codProducto);
                if (producto != null) {
                    compra.agregarProducto(producto);
                } else {
                    System.out.println("Producto no encontrado.");
                }
            }
        }

        Factura factura = new Factura(compra);
        factura.imprimirFactura();
    }

    public void agregarCliente() {
        System.out.println("Ingrese los datos del cliente:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, direccion);
        clientes.add(cliente);
        System.out.println("Cliente agregado exitosamente.");
    }

    public Producto buscarProducto(String codProducto) {
        for (Producto producto : productos) {
            if (producto.getCodProducto().equals(codProducto)) {
                return producto;
            }
        }
        return null;
    }
}
