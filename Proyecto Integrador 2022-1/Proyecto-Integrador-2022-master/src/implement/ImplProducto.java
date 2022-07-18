package implement;

import conexion.ConexionMysql;
import entities.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import resources.Resources;

public class ImplProducto {
    Producto prod= new Producto();
    Resources resources= new Resources();
    Statement stmt=null; 
    ResultSet rset=null;
    ConexionMysql cx= new ConexionMysql();
    ArrayList<Producto> lisProducto = new ArrayList<>();
    
    String sql="";
    
    public void AddProducto(Producto pr){
        
        try {
            sql = "insert into producto"
                    + " values ('"+pr.getProd_id()+"','"+pr.getProd_nombre()+"','"+pr.getProd_stock()+"','"+pr.getProd_precioveta()+"','"+pr.getProd_preciocompra()+"') ";            
            int i=0;
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(ImplProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
            
    
    
    public ArrayList<Producto> reporteProductos(){
    lisProducto = new ArrayList<Producto>();
    
    try {
            sql=" select * from producto";
            stmt=cx.conectaDB().createStatement();
            rset=stmt.executeQuery(sql);
            while(rset.next()){
                Producto pr = new Producto();
                pr.setProd_id(rset.getString(1));
                pr.setProd_nombre(rset.getString(2));
                pr.setProd_stock(rset.getString(3));
                pr.setProd_precioveta(rset.getDouble(4));
                pr.setProd_preciocompra(rset.getDouble(5));
                
                
                lisProducto.add(pr);            
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return lisProducto;
    
    }
    
    public void ActualizarProducto(Producto pr){        
             int i=0;  
        try {
            sql = " update producto "+
                  " set producto_nombre= '"+pr.getProd_nombre()+"' "+  
                  " , producto_stock= '"+pr.getProd_stock()+"'"+
                  " , producto_precioventa= '"+pr.getProd_precioveta()+"'"+
                  " , producto_preciocompra= '"+pr.getProd_preciocompra()+"'"+
                  " where prod_id='"+pr.getProd_id()+"' ";
                  
                  
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql);
            
            
        }catch (SQLException ex) {
            System.out.println("capturando"+ex.getMessage()); 
        }
    }
    
    public void EliminarProducto(Producto pr){
    
        int i=0;  
        try {
            sql = " delete from producto "+
                  " where prod_id='"+pr.getProd_id()+"' ";
                  
                        
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql);
            
        }catch (SQLException ex) {
            System.out.println("capturando"+ex.getMessage()); 
        }
        
        
        
    }
    
    
    
    
}
