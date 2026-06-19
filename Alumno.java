public class Alumno {
    private int legajo;
    private String nombre;
    private int edad;
    private double notaFinal;
    public Alumno(){
    }
    public Alumno(int legajo,String nombre,int edad){
        this.legajo=legajo;
        this.nombre=nombre;
        this.edad=edad;
    }
    public int getLegajo(){
        return this.legajo;
    }
    public String getNombre(){
        return this.nombre;
    }
    public int getEdad(){
        return this.edad;
    }
    public double getNotaFinal(){
        return this.notaFinal;
    }

    public void setLegajo(int nroLegajo){
       legajo=nroLegajo;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setEdad(int edad){
        this.edad=edad;
    }
    public void setNotaFinal(double notaFinal){
        this.notaFinal=notaFinal;
    }
    public String toString(){
        return "Nro Legajo: "+this.getLegajo()+"\nNombre: "+this.getNombre()+"\nEdad: "+this.getEdad()+
        "\nNota Final: "+this.getNotaFinal();
    }
}
