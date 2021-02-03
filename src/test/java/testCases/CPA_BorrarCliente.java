package testCases;

public class CPA_BorrarCliente extends CPA_Base{

    String nombreClienteParaBorrar="";

    public void flujo(){

        carrusel.flujoCarrusel();
        registro.validar("Se visualiza pantalla de 'Registro' antes de eliminar un cliente");
        nombreClienteParaBorrar=registro.getNombreClienteParaBorrar();
        registro.seleccionarCliente();
        detalleCliente.borrarCliente();
        registro.validar("Se visualiza pantalla de 'Registro' despues de eliminar a " + nombreClienteParaBorrar);
        registro.validarClienteBorrado(nombreClienteParaBorrar);
    }
}
