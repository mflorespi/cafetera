package ejercicio6;

public class NespressoApp {
    
    public static void main(String[] args) {
        
        Nespresso cafetera = new Nespresso();
        
        NespressoServicio servicio = new NespressoServicio();
               
        servicio.ejecutarOperaciones(cafetera);
    }
    
}
