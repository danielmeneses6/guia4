
package in4;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class Eps {
    Queue cola=new LinkedList();
    Queue colap2=new LinkedList();
    Queue colap3=new LinkedList();
    Queue colap4=new LinkedList();
    Queue nombres=new LinkedList();
    Queue nombres2=new LinkedList();
    Queue nombres3=new LinkedList();
    Queue nombres4=new LinkedList();
    Timer tiempo=new Timer();
      int i1=1,i2=1,i3=1,i4=1,i5=1,select;
      long tiempodeespera = 5000;
    public void turnos()
    {
      Scanner escaner2=new Scanner(System.in);
      boolean a=true,c=false;
      
          System.out.println("BIENVENIDO A EPS UMNG");
          System.out.println("presione el numero 1 para asignar unn turno:");
          int b=escaner2.nextInt();
          switch(b)
          {
              case 1:
                  System.out.println("ingrese su nombre: ");
                  escaner2.nextLine();
                  String nombre=escaner2.nextLine();
                  System.out.println("ingrese su edad:");
                  int edad=escaner2.nextInt();
                  escaner2.nextLine(); 
                  System.out.println("ingrese su tipo de afiliacion: ");
                  System.out.println("1. POS 2.PC ");
                  int tipo=escaner2.nextInt();
                  System.out.println("ingrese si presenta condicion especial: ");
                  System.out.println("1. si 2. no");
                  int sit=escaner2.nextInt();
                  /*los turnos van a ser A si es un turno para una persona comun y corriente
                  B para los tercera edad o infantes, C para los afiliados, D para las embarazadas
                  o discapacitados en general, en este caso con limitacion motriz, la mas prioritaria 
                  se tomaran los D, despues los B, despues los C, y como menos prioritario se tomaran los A
                  una persona puede presentar mas de una de estas condiciones asi que se sobrepondra la asignacion
                  de cateria D a las B o C,de igual forma se sobrepondra la asignacion B a la C */
                      if(sit==1)
                      {
                          select=4;
                      }
                      else
                          if(edad<=12||edad>=84)
                          {
                              select=2;
                          }
                      else
                              if(tipo==2)
                              {
                                  select=3;
                              }
                      else
                                  select=1;
                  
                  switch(select)
                  {
                      case 1:
                  cola.offer("A"+i1);
                  nombres.offer(nombre);
                  i1++;
                  break;
              case 2:
                  colap2.offer("B"+i2);
                  nombres2.offer(nombre);
                  i2++;
                  break;
              case 3:
                  colap3.offer("C"+i3);
                  nombres3.offer(nombre);
                  i3++;
                  break;
              case 4:
                  colap4.offer("D"+i4);
                  nombres4.offer(nombre);
                  i4++;
                           break;
                  }
                  break;
                  
      }
    }
   public String llamado() {
    Scanner scanner = new Scanner(System.in);
    
    String mensaje="";
    tiempo.scheduleAtFixedRate(new TimerTask() {
        public void run() {
            if (cola.peek() != null || colap2.peek() != null || colap3.peek() != null || colap4.peek() != null) {
                if (colap4.peek() != null) {
                    System.out.println("SIGUIENTE TURNO: " + colap4.peek() + "-->" + nombres4.peek());
                    colap4.poll();
                    nombres4.poll();
                } 
                else
                    
                    if (colap3.peek()!= null) {
                    System.out.println("SIGUIENTE TURNO: " + colap3.peek() + "-->" + nombres3.peek());
                    colap3.poll();
                    nombres3.poll();
                } 
                    else
                        if (colap2.peek() != null) {
                    System.out.println("SIGUIENTE TURNO: " + colap2.peek() + "-->" + nombres2.peek());
                    colap2.poll();
                    nombres2.poll();
                } 
                        else 
                            if (cola.peek() != null) {
                    System.out.println("SIGUIENTE TURNO: " + cola.peek() + "-->" + nombres.peek());
                    cola.poll();
                    nombres.poll();
                }
            } 
            else 
            {
                System.out.println("No hay turnos en espera.");
            }   
        }
    }, 1000, tiempodeespera);
    return mensaje;
}

}
