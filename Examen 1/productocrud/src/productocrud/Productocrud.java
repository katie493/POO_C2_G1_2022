package productocrud;
import implementacion.ImplProductos;

public class Productocrud {

    public static void main(String[] args) {
        
        //CRUD sin Menú De Opciones
        ImplProductos ip =new ImplProductos();
        
        //ip.agragarProductosPorTeclado();
        //ip.reporteProductos();
        //ip.eliminarproductos();
        //ip.modificarproductos();
        
        //CRUD con Menú de opciones
        MenuDeOpcionesCRUD mn = new MenuDeOpcionesCRUD();
        mn.menuOpciones();
    }
    
}
