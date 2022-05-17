package calificaciones;

public class Calificaciones {
    
    static int[] calif=new int[10];
    
    public static void calificacionesAlumnos(){
        
    calif[0]= 11;
    calif[1]= 14;    
    calif[2]= 7;
    calif[3]= 16;
    calif[4]= 13;
    calif[5]= 9;
    calif[6]= 18;
    calif[7]= 18;
    calif[8]= 16;
    calif[9]= 20;
        
        int r=0;
        for(int i=0; i<calif.length; i++){
        
            r= r+calif[i];
            
        }
        
        System.out.println("|||----------------Calificaciones----------------|||");
        System.out.println("El promedio de calificaciones es: "+r/calif.length);
        System.out.println("La MAYOR calificacion es: "+calif[9]);
        System.out.println("La MENOR calificacion es: "+calif[2]);
        
        
    
    }


    public static void main(String[] args) {
        
        calificacionesAlumnos();
        
    }
    
}
