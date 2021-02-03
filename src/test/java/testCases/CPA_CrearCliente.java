package testCases;

import static utils.Utils.cadenaAleatorea;
import static utils.Utils.stringEnteroAleatoreo;

public class CPA_CrearCliente extends CPA_Base{

    String nombre=cadenaAleatorea() + " " + cadenaAleatorea();
    String ID="123";
    String direccion ="calle falsa " + stringEnteroAleatoreo(1000);
    String fono = "12345678";
    String notas="sin notas";

    public void flujoFront(){
        carrusel.flujoCarrusel();
        registro.validarVistaDesplegada();
        registro.tabBtnMas();
        registro.tabBtnCrearCliente();
        crearCliente.validarVistaDesplegada();
        crearCliente.completarFormulario(nombre,ID,fono,direccion,notas);
        crearCliente.tapGuardar();
        registro.validarCliente(nombre);


    }




}
