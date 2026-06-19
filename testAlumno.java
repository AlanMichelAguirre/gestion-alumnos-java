package GestorAlumnos;
import java.util.Scanner;
public class testAlumno{
public static void main(String[]args){
	Alumno[] alumno= new Alumno[1];
   Scanner leer= new Scanner(System.in);
   String nombre;
   int edad,legajo,usuario;
   double promedioGral,notaF;
   do {   
	   if(alumno[0]==null) {
		   System.out.println("-------Menu-------\n" + "1 - Agregar alumno\r\n");
	   }else {
		   System.out.println("-------Menu-------\n"
			   		+ "1 - Agregar alumno\r\n"
			   		+ "2 - Listar alumnos\r\n"
			   		+ "3 - Buscar alumno por legajo\r\n"
			   		+ "4 - Mostrar promedio general\r\n"
			   		+ "5 - Mostrar alumno con mejor nota\r\n"
			   		+ "0 - Salir");
	   }  
		   usuario=leer.nextInt();
		   switch(usuario) {
		   	case 1:
		   	System.out.println("Ingrese los siguientes datos: Nro legajo - nombre - edad - Nota Final");
		   	legajo=leer.nextInt();
		   	leer.nextLine();
		   	nombre=leer.nextLine();
		   	edad=leer.nextInt();
		   	notaF=leer.nextDouble();
		   	alumno=agregarAlumno(alumno,nombre,edad,legajo,notaF);break;
		   	case 2:
		   		listarAlumnos(alumno);break;
		   	case 3:
		   		System.out.println("Ingrese Nro legajo:");
		   		legajo=leer.nextInt();
		   		buscarAlumno(alumno,legajo);break;
		   	case 4:
		   		promedioGral=promedioGral(alumno);
		   		System.out.println("Promedio General: "+promedioGral);break;
		   	case 5:
		   		legajo=mejorPromedio(alumno);
		   		buscarAlumno(alumno,legajo);break;
		   	case 0:
		   		System.out.println("Finaliza el programa.");break;
		   		default:
		   			System.out.println("Opcion incorrecta");
		   }
   }while(usuario!=0);
   
  
}
public static Alumno[] agregarAlumno(Alumno[] alumno,String nombre,int edad,int legajo, double notaFinal){
	Alumno alumnoN=new Alumno(legajo,nombre,edad);
	alumnoN.setNotaFinal(notaFinal);
    int i=0;
    boolean seAgrego=false;
    do { 
    	if(alumno.length-1==i && alumno[i]!=null) {
    		alumno=agrandarLista(alumno);
    		alumno[i+1]=alumnoN;
    		seAgrego=true;
    		System.out.println("Se agrego en la lista");
    	}else {
    		if(alumno[i]==null){
                alumno[i]=alumnoN;
                seAgrego=true;
            }else {
            	i++;
            }
    	}
        
    } while (alumno.length>=i && !seAgrego);
    return alumno;
}
public static Alumno[] agrandarLista(Alumno[] alumno) {
	Alumno[] alumnoGenerico=new Alumno[alumno.length+1];
	for(int i=0;i<alumno.length;i++) {
		alumnoGenerico[i]=alumno[i];
	}
	return alumnoGenerico;
}
public static void listarAlumnos(Alumno[] alumno){
    for(int i=0;i<alumno.length;i++){
        if(alumno[i]!=null){
            System.out.println(alumno[i].toString());
        }
    }
}
public static void buscarAlumno(Alumno[] alumno,int leg){
    boolean encontrado=false;
    int i=0;
    do {
    	if(alumno[i].getLegajo()==leg){
            System.out.println(alumno[i].toString());
             encontrado=true;
         }else {
        	 i++;
         }
    }while(!encontrado && alumno.length<i);
        if(!encontrado) {
        	System.out.println("No existe alumno con ese legajo.");
        }
}
public static double promedioGral(Alumno[] alumno){
    double promGral=0;
    for(int i=0;i<alumno.length;i++){
        promGral+=alumno[i].getNotaFinal();
    }
    promGral=promGral/alumno.length;
    return promGral;
}
public static int mejorPromedio(Alumno[] alumno) {
	double mayorProm=0.0;
	int nroLegajo=0;
	for(int i=0;i<alumno.length;i++) {
		if(alumno[i].getNotaFinal()>=mayorProm) {
			mayorProm=alumno[i].getNotaFinal();
			nroLegajo=alumno[i].getLegajo();
		}
	}
	return nroLegajo;
}

}
