package mesesdelaño;

public class MesesDelAño {
    
    static String[] meses =new String[12];
    
    public static void mesesDelAñoArreglo (){
         
    meses[0]= "Enero";
    meses[1]= "Febrero";    
    meses[2]= "Marzo";
    meses[3]= "Abril";
    meses[4]= "Mayo";
    meses[5]= "Junio";
    meses[6]= "Julio";
    meses[7]= "Agosto";
    meses[8]= "Septiembre";
    meses[9]= "Octubre";
    meses[10]= "Noviembre";
    meses[11]= "Diciembre";
    
    System.out.println("|||----------Meses del año----------|||");
    
    for(int i=0, j=1; i<meses.length; i++,j++){
        
    System.out.println("Mes numero "+j+": "+meses[i]+"\n");    
    
    
    }
    
    } 

    
    public static void main(String[] args) {
       
        mesesDelAñoArreglo();
    }
    
}
