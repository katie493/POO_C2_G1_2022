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
    ArrayList<Client> listaClient = new ArrayList<>();
 
    
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
        
        
        
        try {
            sql = " insert into person ( person_id, person_nombres, person_paterno, person_materno, person_nro_di, person_usuario, person_password) "+
                  " values ('"+c.getPerson_id()+"','"+c.getPerson_nombres()+"','"+c.getPerson_paterno()+"','"+c.getPerson_materno()+"','"+c.getPerson_nro_di()+"','"+c.getPerson_usuario()+"','"+c.getPerson_password()+"' ) ";   
            int i=0;
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql);
                
            
            
            sql2 = " insert into client ( client_id, client_codigocliente, client_tipo, client_person_id  ) "+
                   " values ('"+c.getClient_id()+"','"+c.getClient_codigocliente() +"','"+c.getClient_tipo()+"','"+c.getPerson_id()+"' ) ";
            
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
              ps.setPerson_nombres(rset.getString("person_nombres"));
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
            sql=" select a.*, b.* from person a, worker b " 
                +" where a.person_id=b.worker_person_id";
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
                ps.setWorker_id(rset.getString(8));
                ps.setWorker_salario(rset.getDouble(9));
                ps.setWorker_codigotrabajador(rset.getString(10));
                ps.setWorker_person_id(rset.getString(11));
                listaworkers.add(ps);            
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return listaworkers;
    }
    
    
    
        public ArrayList<Client> reporteClients(){
        listaClient = new ArrayList<>();
        try {
            //consultar esto
            //sql=" select * from person where person_id in ( select client_person_id from client   ) ";
            
              //" select a.*, b.client_id, b.client_codigocliente, b.client_tipo, b.client_person_id from person a, client b "
            sql=" select a.*, b.* from person a, client b " 
                +" where a.person_id=b.client_person_id";    
            stmt=cx.conectaDB().createStatement();
            rset=stmt.executeQuery(sql);
            while(rset.next()){
                Client ps = new Client();
                ps.setPerson_id(rset.getString(1));
                ps.setPerson_nombres(rset.getString(2));
                ps.setPerson_paterno(rset.getString(3));
                ps.setPerson_materno(rset.getString(4));
                ps.setPerson_nro_di(rset.getString(5));
                //ps.setPerson_usuario(rset.getString(6));
                //ps.setPerson_password(rset.getString(7));
                ps.setClient_id(rset.getString(8));
                ps.setClient_codigocliente(rset.getString(9));
                ps.setClient_tipo(rset.getString(10));
                ps.setClient_person_id(rset.getString(11));
                listaClient.add(ps);  
                
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return listaClient;
    }
    
    
    public void ActualizarPerson(Worker w){        
            int i=0;  
        try {
            sql = " update person "+
                  " set person_nombres= '"+w.getPerson_nombres()+"' "+  
                  " , person_paterno= '"+w.getPerson_paterno()+"'"+
                  " , person_materno= '"+w.getPerson_materno()+"'"+
                  " , person_nro_di= '"+w.getPerson_nro_di()+"'"+
                  " , person_usuario= '"+w.getPerson_usuario()+"'"+
                  " , person_password= '"+w.getPerson_password()+"'"+
                  " where person_id='"+w.getPerson_id()+"' ";
                  
                  
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql);
            
                sql2 = " update worker "+
                  " set worker_codigotrabajador= '"+w.getWorker_codigotrabajador()+"' "+
                  " , worker_salario= '"+w.getWorker_salario()+"'"+
                  " where worker_person_id='"+w.getPerson_id()+"' ";
                  System.out.print(sql2); 
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql2);
            
           
            
            
            
        }catch (SQLException ex) {
            System.out.println("capturando"+ex.getMessage()); 
        }
    }
    
    
    
    public void ActualizarPerson(Client c){        
            int i=0;  
        try {
            sql = " update person "+
                  " set person_nombres= '"+c.getPerson_nombres()+"' "+  
                  " , person_paterno= '"+c.getPerson_paterno()+"'"+
                  " , person_materno= '"+c.getPerson_materno()+"'"+
                  " , person_nro_di= '"+c.getPerson_nro_di()+"'"+
                  " , person_usuario= '"+c.getPerson_usuario()+"'"+
                  " , person_password= '"+c.getPerson_password()+"'"+
                  " where person_id='"+c.getPerson_id()+"' ";
                  
                  
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql);
            
            
                sql2 = " update client "+
                  " set client_codigocliente= '"+c.getClient_codigocliente()+"', client_tipo='"+c.getClient_tipo()+"' "+  
                  " where client_person_id='"+c.getPerson_id()+"' ";
                  System.out.print(sql2); 
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql2);
            
           
            
            
            
        }catch (SQLException ex) {
            System.out.println("capturando"+ex.getMessage()); 
        }
    }
    public void EliminarPerson(Worker w){
      int i=0;  
        try {
            sql = " delete from person "+
                  " where person_id='"+w.getPerson_id()+"' ";
                  
                        
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql);
            
            sql2 = " delete from worker "+
                  " where worker_person_id='"+w.getPerson_id()+"' ";
                  
                       
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql2);
            
        }catch (SQLException ex) {
            System.out.println("capturando"+ex.getMessage()); 
        }
        
    }
    
    public void EliminarPerson(Client c){
    int i=0; 
        try {
            sql = " delete from person "+
                  " where person_id='"+c.getPerson_id()+"' ";
                  
                       
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql);
            
            
            sql2 = " delete from client "+
                  " where client_person_id='"+c.getPerson_id()+"' ";
                  
                       
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql2);
            
            
        }catch (SQLException ex) {
            System.out.println("capturando"+ex.getMessage()); 
        }
    }
    
}
