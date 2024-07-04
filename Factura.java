class Factura {
    private Compra compra;

    public Factura(Compra compra) {
        this.compra = compra;
    }

    public void imprimirFactura() {
        System.out.println("Factura:");
        System.out.println("Cliente: " + compra.getCliente().getNombre());
        System.out.println("Dirección: " + compra.getCliente().getDireccion());
        System.out.println("Productos:");
        for (Producto producto : compra.getProductos()) {
            System.out.println(producto);
        }
        System.out.println("Total: " + compra.calcularTotal());
    }
}