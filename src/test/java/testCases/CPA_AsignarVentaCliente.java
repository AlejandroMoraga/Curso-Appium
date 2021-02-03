package testCases;

public class CPA_AsignarVentaCliente extends CPA_Base{


    String cantidad= "10";
    String precio="";

    public void flujoFront(){
        carrusel.flujoCarrusel();
        registro.validarVistaDesplegada();
        registro.seleccionarCliente();
        detalleCliente.validarVistaDetalleCliente();
        detalleCliente.agregarVenta();
        seleccionarProducto.validarVistaSeleccionProducto();
        seleccionarProducto.seleccionDeProducto();
        precio=compraIndividual.getPrecio();
        compraIndividual.agregarCantidad(cantidad);
        compraIndividual.validarVistaCompraIndividual();
        detalleVenta.pagarContado();
        detalleCliente.validarVistaDetalleCliente();
        detalleCliente.validarTotalUltimaVenta(cantidad,precio);

    }

}
