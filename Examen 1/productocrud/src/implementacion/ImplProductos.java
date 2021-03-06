package implementacion;

import conexion.ConectaDBSqlite;
import entidades.Productos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.ArrayList;
import java.sql.*;
import java.util.Scanner;

public class ImplProductos {
    
    ConectaDBSqlite cc=new ConectaDBSqlite();
    ArrayList<Productos> listaProductos=new ArrayList<>();
    
    
    public void agregarProductos(Productos produ){
        
        try {
            String query="insert into productos values('"+produ.getProd_id()+"','"+produ.getProd_nombre()+"','"+produ.getProd_precio_vta()+"','"+produ.getProd_precio_compra()+"','"+produ.getProd_tipo()+"','"+produ.getProd_codigo()+"');";
            
            Statement st =cc.getConnect().createStatement();st.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(ImplProductos.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print(ex.getMessage());
        }
        
                   
    }
     public void agragarProductosPorTeclado(){
          Scanner tecl = new Scanner(System.in).useDelimiter("\n");
        Productos c=new Productos();
       
        System.out.print("Ingrese el id del producto a agregar: ");
        String PROD_ID = tecl.next();
        System.out.print("Ingrese el nombre del producto a agregar: ");
        String PROD_NOMBRE = tecl.next();
        System.out.print("Ingrese el precio de venta del producto a agregar: ");
        double PROD_PRECIO_VTA = tecl.nextDouble();
        System.out.print("Ingrese el precio de compra del producto a agregar: ");
        double PROD_PRECIO_COMPRA = tecl.nextDouble();
        System.out.print("Ingrese el tipo de producto a agregar: ");
        String PROD_TIPO = tecl.next();
        System.out.print("Ingrese el codigo del producto a agregar: ");
        String PROD_CODIGO = tecl.next();
        
        c.setProd_id(PROD_ID);
        c.setProd_nombre(PROD_NOMBRE);
        c.setProd_precio_vta(PROD_PRECIO_VTA);
        c.setProd_precio_compra(PROD_PRECIO_COMPRA);
        c.setProd_tipo(PROD_TIPO);
        c.setProd_codigo(PROD_CODIGO);
                
        agregarProductos(c);
        
        System.out.println("------Reporte de Prodcutos Actualizados------");
        reporteProductos();
        
     }
    
    
    public void reporteProductos(){
        
        System.out.println("-----Reporte de productos-----");
        
        try {
            String query="select * from productos";
            
            Statement st =cc.getConnect().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Productos produc=new Productos();
                
                produc.setProd_id(rs.getString(1));
            System.out.println("El id del Producto: "+rs.getString(1));
            
            produc.setProd_nombre(rs.getString(2));
            System.out.println("El nombre del Producto es: "+rs.getString(2));
            
            produc.setProd_precio_vta(rs.getDouble(3));
            System.out.println("El precio de venta del Producto es: "+rs.getDouble(3));
            
            produc.setProd_precio_compra(rs.getDouble(4));
            System.out.println("El precio de compra del Producto es: "+rs.getDouble(4));
            
            produc.setProd_tipo(rs.getString(5));
            System.out.println("El tipo de Producto es: "+rs.getString(5));
            
            produc.setProd_codigo(rs.getString(6));
            System.out.println("El codigo del Producto es: "+rs.getString(6)+"\n");
            listaProductos.add(produc);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ImplProductos.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print(ex.getMessage());
        }
        
        
    }
    
    public void modificarproductos(){
        
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        
        System.out.println("------Prodcutos Disponibles para Modificar------");
        reporteProductos();
        
        try{
        ConectaDBSqlite cg= new ConectaDBSqlite();
        Connection cn= cg.getConnect();
        
        PreparedStatement ps = cn.prepareStatement("UPDATE productos SET PROD_NOMBRE = ?, PROD_PRECIO_VTA = ?, PROD_PRECIO_COMPRA = ?, PROD_TIPO = ?, PROD_CODIGO = ? WHERE PROD_ID = ?;");
        
        System.out.print("Ingrese el id del producto a modificar: ");
        int PROD_ID = teclado.nextInt();
        System.out.print("Ingrese el nuevo nombre del producto a modificar: ");
        String PROD_NOMBRE = teclado.next();
        System.out.print("Ingrese el nuevo precio de venta del producto a modificar: ");
        double PROD_PRECIO_VTA = teclado.nextDouble();
        System.out.print("Ingrese el nuevo precio de compra del producto a modificar: ");
        double PROD_PRECIO_COMPRA = teclado.nextDouble();
        System.out.print("Ingrese el nuevo tipo del producto a modificar: ");
        String PROD_TIPO = teclado.next();
        System.out.print("Ingrese el nuevo codigo del producto a modificar: ");
        String PROD_CODIGO = teclado.next();
          
        ps.setString(1, PROD_NOMBRE);
        ps.setDouble(2, PROD_PRECIO_VTA);
        ps.setDouble(3, PROD_PRECIO_COMPRA);
        ps.setString(4, PROD_TIPO);
        ps.setString(5, PROD_CODIGO);
        ps.setInt(6,PROD_ID);
        
        ps.executeUpdate();
        
        }catch (SQLException ex) {
            Logger.getLogger(ImplProductos.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print(ex.getMessage());
        }
        
        
        System.out.println("------Reporte de Prodcutos Actualizados------");
        reporteProductos();
       
    }
    
    public void eliminarproductos(){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        
        System.out.println("------Productos Disponibles para Eliminar------");
        
        reporteProductos();
        
        try{
        ConectaDBSqlite cg= new ConectaDBSqlite();
        Connection cn= cg.getConnect();
        
        PreparedStatement ps = cn.prepareStatement("DELETE FROM productos WHERE PROD_ID = ?;");
        
        System.out.print("Ingrese el id del producto a eliminar: ");
        int PROD_ID = teclado.nextInt();
        
        ps.setInt(1,PROD_ID);
        ps.executeUpdate();
        
        }catch (SQLException ex) {
            Logger.getLogger(ImplProductos.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print(ex.getMessage());
        }
        
        System.out.println("------Reporte de Prodcutos Actualizados------");
        
        reporteProductos();
        
        
        
        
    }
    
    
    
}
