
 
package in4;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class consola {

  
    public static void main(String[] args) {
        Scanner escaner=new Scanner(System.in);
        Eps objeto=new Eps();
        System.out.println("===MENU DE OPCIONES===");
        System.out.println("1. turno de eps");
        System.out.println("2.vehiculos"); 
        System.out.println("0.salir");
        int a=escaner.nextInt();
        switch(a)
        {
            case 1:
                 int i=0;
                boolean f=false;
                do {
              
               objeto.turnos();
               
               if(f==false)
                    {
               objeto.llamado();
               f=true;
               }
               i++;
                } while (i!=10);
                    break;
            case 2:
                
                
                break;
        }
}
}
