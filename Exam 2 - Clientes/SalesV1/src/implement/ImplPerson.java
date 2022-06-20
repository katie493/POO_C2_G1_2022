package implement;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import conexion.ConexionMysql;
import entities.Client;
import entities.Person;
import entities.Worker;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import resources.Resources;



public class ImplPerson {
    
    ArrayList<Worker> lista= new ArrayList<>();
    String sql="";
    String sql2="";
    Statement stmt=null; 
    ResultSet rset=null;
    ConexionMysql cx= new ConexionMysql();
    Resources resource= new Resources();
    ArrayList<Worker> listaworkers = new ArrayList<>();
    
    ArrayList<Client> listaclientesPer = new ArrayList<>();
 
    
    public void registrarPerson(Worker w){
        
        
        
        try {
            sql = " insert into person ( person_id, person_nombres, person_paterno, person_materno, person_nro_di, person_usuario, person_password) "+
                  " values ('"+w.getPerson_id()+"','"+w.getPerson_nombres()+"','"+w.getPerson_paterno()+"','"+w.getPerson_materno()+"','"+w.getPerson_nro_di()+"','"+w.getPerson_usuario()+"','"+w.getPerson_password()+"' ) ";
            int i=0;            
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql);
            
            
            
            sql2 = " insert into worker ( worker_id, worker_salario, worker_codigotrabajador, worker_person_id  ) "+
                   " values ('"+w.getWorker_id()+"','"+w.getWorker_salario()+"','"+w.getWorker_codigotrabajador()+"','"+w.getPerson_id()+"' ) ";
            
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql2);
    
            
        }catch (SQLException ex) {
            System.out.println("capturando"+ex.getMessage()); 
        }
    }
    
    
    public void registrarPerson(Client c){
        
        String idPerson = "";
               idPerson = resource.generaID();
        try {
            sql = " insert into person ( person_id, person_nombres, person_paterno, person_materno, person_nro_di, person_usuario, person_password) "+
                  " values ('"+idPerson+"','"+c.getPerson_nombres()+"','"+c.getPerson_paterno()+"','"+c.getPerson_materno()+"','"+c.getPerson_nro_di()+"','"+c.getPerson_usuario()+"','"+c.getPerson_password()+"' ) ";
            int i=0;            
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql);
            
            
            String idClient = "";
                   idClient = resource.generaID();
            sql2 = " insert into client ( client_id, client_codigocliente, client_tipo, client_person_id  ) "+
                   " values ('"+idClient+"','"+c.getClient_codigocliente()+"','"+c.getClient_tipo()+"','"+idPerson+"' ) ";
            
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql2);
            
            
    
            
        }catch (SQLException ex) {
            System.out.println("capturando"+ex.getMessage()); 
        }   
    }
    
    public Person validateLogin(Person p){
                
        Person ps = null;
        try{
            sql=" select * from person "+
                " where person_usuario='"+p.getPerson_usuario()+"'   "+
                " and  person_password='"+p.getPerson_password()+"'  ";
            
            stmt=cx.conectaDB().createStatement();
            rset= stmt.executeQuery(sql);
            if(rset.next()){
              ps = new Person();
              ps.setPerson_usuario(rset.getString("person_usuario"));
              ps.setPerson_password(rset.getString("person_password"));              
            }else {
              ps= null;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
        return ps;
    }
    
    public ArrayList<Worker> reporteWorkers(){
        listaworkers = new ArrayList<>();
        try {
            sql=" select * from person ";
            stmt=cx.conectaDB().createStatement();
            rset=stmt.executeQuery(sql);
            while(rset.next()){
                Worker ps = new Worker();
                ps.setPerson_id(rset.getString("person_id"));
                ps.setPerson_nombres(rset.getString(2));
                ps.setPerson_paterno(rset.getString(3));
                ps.setPerson_materno(rset.getString(4));
                ps.setPerson_nro_di(rset.getString(5));
                ps.setPerson_usuario(rset.getString(6));
                ps.setPerson_password(rset.getString(7));
                listaworkers.add(ps);            
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return listaworkers;
    }
    
    
    public void ActualizarWorker(Worker w){        
        
        try {
            sql = " update person "+
                  " set person_nombres= '"+w.getPerson_nombres()+"' "+  
                  " , person_paterno= '"+w.getPerson_paterno()+"'"+
                  " , person_materno= '"+w.getPerson_materno()+"'"+
                  " , person_nro_di= '"+w.getPerson_nro_di()+"'"+
                  " , person_usuario= '"+w.getPerson_usuario()+"'"+
                  " , person_password= '"+w.getPerson_password()+"'"+
                  " where person_id='"+w.getPerson_id()+"' ";
                  
            int i=0;            
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql);
            
        }catch (SQLException ex) {
            System.out.println("capturando"+ex.getMessage()); 
        }
    }
    public void EliminarWorker(String id){
        
        try {
            sql = " delete from person "+
                  " where person_id='"+id+"' ";
                  
            int i=0;            
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql);
            
        }catch (SQLException ex) {
            System.out.println("capturando"+ex.getMessage()); 
        }
    }
    //--------------------------------------------------------
    
      public ArrayList<Client> reporteCliPerDB(){
    
        try {
            Statement st =cx.conectaDB().createStatement();
            String query = "select * from person";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
            Client perC = new Client();
                
            perC.setPerson_id(rs.getString("person_id"));
            perC.setPerson_nombres(rs.getString(2));
            perC.setPerson_paterno(rs.getString(3));
            perC.setPerson_materno(rs.getString(4));
            perC.setPerson_nro_di(rs.getString(5));
            perC.setPerson_usuario(rs.getString(6));
            perC.setPerson_password(rs.getString(7));
            listaclientesPer.add(perC);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ImplPerson.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaclientesPer;
    }
      
      public void ActualizarClient(Client cl){        
        
        try {
            sql = " update person "+
                  " set person_nombres= '"+cl.getPerson_nombres()+"' "+  
                  " , person_paterno= '"+cl.getPerson_paterno()+"'"+
                  " , person_materno= '"+cl.getPerson_materno()+"'"+
                  " , person_nro_di= '"+cl.getPerson_nro_di()+"'"+
                  " , person_usuario= '"+cl.getPerson_usuario()+"'"+
                  " , person_password= '"+cl.getPerson_password()+"'"+
                  " where person_id='"+cl.getPerson_id()+"' ";
                  
            int i=0;            
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql);
            
        }catch (SQLException ex) {
            System.out.println("capturando"+ex.getMessage()); 
        }
    }
      
      public void EliminarClient(String id){
        
        try {
            sql = " delete from person "+
                  " where person_id='"+id+"' ";
                  
            int i=0;            
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql);
            
        }catch (SQLException ex) {
            System.out.println("capturando"+ex.getMessage()); 
        }
    }
    
}
