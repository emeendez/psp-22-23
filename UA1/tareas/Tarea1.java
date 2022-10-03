
/*
    CFGS Desarrollo Aplicaciones Multiplataforma
    Programación Servicios y Procesos
    CES Lope de Vega - Córdoba (Spain)
    Curso 2022/2023
*/

/*
    Tarea 1 - Programación de Procesos en C
    Criterios a), f), g), h)
    Crea un programa en C que cree un proceso (existirán en realidad dos procesos, uno padre y el otro hijo). 
    El programa principal pedirá al usuario una variable y el proceso padre restará 5 a dicha variable, mientras que el proceso hijo le sumará 4. 
    Muestra todos los valores por pantalla.
*/
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
int main() {
  pid_t pid, Hijo_pid;
  int num;
  printf("Introduzca un numero entero: ");
    scanf("%d", &num);
   // 
  pid = fork();

//Control de errores
  if (pid == -1 ) //Ha ocurrido un error 
  {
    printf("No se ha podido crear el proceso hijo...");
    exit(-1);       
  }
  if (pid == 0 )  //Nos encontramos en Proceso hijo 
  {        
    printf("Soy el proceso hijo \n\t Mi PID es %d, El PID de mi padre es: %d.\n",  
            getpid(), getppid() );
            //Sumamos 4 al numero introducido
            num += 4;	
  }
  else    //Nos encontramos en Proceso padre 
  { 
   Hijo_pid = wait(NULL); //espera la finalización del proceso hijo
   printf("\n Soy el proceso padre:\n\t Mi PID es %d, El PID de mi padre es: %d.\n\t Mi hijo: %d terminó.\n",  getpid(), getppid(), pid);
   //Restamos 5 al numero introducido
   num -= 5;          
   }
   printf("%d",num);
   exit(0);
}
