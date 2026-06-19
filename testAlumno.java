public static void main(String[]args){
        /*
        1 - Agregar alumno
2 - Listar alumnos
3 - Buscar alumno por legajo
4 - Mostrar promedio general
5 - Mostrar alumno con mejor nota
0 - Salir
        */
       String nombre;
       int edad,legajo;

    }
    public static boolean agregarAlumno(Alumno[] alumno,String nombre,int edad,int legajo){
        int i=0;
        boolean seAgrego=false;
        do { 
            if(alumno[i]==null){
                alumno[i].setEdad(edad);
                alumno[i].setNombre(nombre);
                alumno[i].setLegajo(legajo);
                seAgrego=true;
            }
        } while (alumno.length>i || !seAgrego);
        return seAgrego;
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
        do { 
            for(int i=0;i<alumno.length;i++){
                if(alumno[i].getLegajo()==leg){
                    System.out.println(alumno[i].toString());
                    encontrado=true;
                }
            }
        } while (!encontrado);
    }
    public static double promedioGral(Alumno[] alumno){
        double promGral=0;
        for(int i=0;i<alumno.length;i++){
            promGral+=alumno[i].getNotaFinal();
        }
        promGral=promGral/alumno.length;
        return promGral;
    }
}
