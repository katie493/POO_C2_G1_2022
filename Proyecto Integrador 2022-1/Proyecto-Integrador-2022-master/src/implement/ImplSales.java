package implement;

import conexion.ConexionMysql;
import entities.DetailSales;
import entities.Person;
import entities.Producto;
import entities.Sales;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImplSales {
    
       
    String sql="";
    String sql2="";
    Statement stmt=null; 
    ResultSet rset=null;
    ConexionMysql cx= new ConexionMysql();
    
    ArrayList<Producto> listnomprod = new ArrayList<>();
    
    ArrayList<DetailSales> listadetalleventas = new ArrayList<>();
    
    public int numeroVta(String serie){
        int n=0;
        try {
        
            sql=" select max(vta_numeroventa)+1 from ventas "    
               +" where vta_serie= '"+serie+"'";
               
            stmt=cx.conectaDB().createStatement();
            rset=stmt.executeQuery(sql);
            
            if(rset.next()){               
                
                n=rset.getInt(1);
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return n;
    }
    
    
    public void registrarSales(Sales sales){
    
        
        try {
            sql = " insert into ventas "+
                    " values ('"+sales.getSales_id()+"', "
                    + "  '"+sales.getSales_tipocomprobante()+"',"
                    + "  '"+sales.getSales_serie()+"',"
                    + "  '"+sales.getSales_numeroventa()+"', "
                    + "  now(), "
                    + "  '"+sales.getSales_importetotal()+"',"
                    + "  '"+sales.getSales_client().getPerson_nombres()+"',"
                    + "  'trabajador' )";
            int i=0;            
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql);
            System.out.println("implement.ImplSales.registrarSales()"+sql);                       
                        
            for(DetailSales dv : sales.getListDetailSales()){
                
                System.out.println("en el impl"+dv.getDetailsales_cantidad());
                sql2 = " insert into detalle_vtas "
                      +" values('"+dv.getDetailsales_id()+"',"
                      +" '"+dv.getDetailsales_cantidad()+"',"
                      +" '"+dv.getDetailsales_descripcion()+"',"
                      +" '"+dv.getDetailsales_preciounitario()+"',"
                      +" '"+dv.getDetailsales_precioitem()+"',"
                      +"'"+sales.getSales_id()+"')  ";
                stmt=cx.conectaDB().createStatement();
                i=stmt.executeUpdate(sql2);
                System.out.println("()"+sql2);                       
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplSales.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
                
                
                
        
        
    }
    
    
    public ArrayList<Producto> reporteProducto(){
         listnomprod = new ArrayList<Producto>();
         
        try {
            
            String sql="";
            sql=" select * from producto";
            stmt=cx.conectaDB().createStatement();
            rset=stmt.executeQuery(sql);
            while(rset.next()){
                Producto pr = new Producto();
                
                pr.setProd_nombre(rset.getString(2));
               
                
                listnomprod.add(pr);
                
                
                
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ImplSales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listnomprod;
    }
    
 
    public ArrayList<DetailSales> reporteVentaconDetalle(){
        listadetalleventas = new ArrayList<>();
        try {
            sql=" select a.*, b.* from ventas a, detalle_vtas b " 
                +" where a.vta_id=b.dvta_vta_id";
            stmt=cx.conectaDB().createStatement();
            rset=stmt.executeQuery(sql);
            while(rset.next()){
                DetailSales vdv = new DetailSales();
                
                vdv.setSales_id(rset.getString("vta_id"));
                vdv.setSales_tipocomprobante(rset.getString(2));
                vdv.setSales_serie(rset.getString(3));
                vdv.setSales_numeroventa(rset.getString(4));
                vdv.setSales_fecha(rset.getDate(5));
                vdv.setSales_importetotal(rset.getDouble(6));
                //vdv.setPerson_nombres(rset.getString(7));
                //worker.setWorker_nombres(rset.getString(8));
                vdv.setDetailsales_id(rset.getString(9));
                vdv.setDetailsales_cantidad(rset.getDouble(10));
                vdv.setDetailsales_descripcion(rset.getString(11));
                vdv.setDetailsales_preciounitario(rset.getDouble(12));
                vdv.setDetailsales_precioitem(rset.getDouble(13));
                vdv.setSales_id(rset.getString(14));
                listadetalleventas.add(vdv);            
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return listadetalleventas;
    }
    
     
    
    
}