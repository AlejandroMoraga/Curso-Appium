package testCases;

import static utils.Utils.cadenaAleatorea;
import static utils.Utils.stringEnteroAleatoreo;

public class CPA_CrearProducto extends CPA_Base{

    String nombreProducto = "a"+cadenaAleatorea();
    String precioProducto = stringEnteroAleatoreo(100000);


        public void flujoFront(){

        carrusel.flujoCarrusel();
        registro.validarVistaDesplegada();
        registro.tabBtnMas();
        registro.tabBtnCrearProducto();
        crearProducto.validarVistaDesplegada("Se visualiza pantalla de 'Crear Producto'");
        crearProducto.completarFormulario(nombreProducto,precioProducto);
        crearProducto.tapConfirmar();

        registro.validarVistaDesplegada();

        registro.tapTabProductos();

        registro.validar("Se visualiza pantalla de 'Productos'");

        registro.validarProducto(nombreProducto,precioProducto);
    }


}


