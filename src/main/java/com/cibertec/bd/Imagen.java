// package com.cibertec.bd;

// // implements java.io.Serializable le agregamos eso 
// //seriable : mandar un medio fisico ya sea en un json objeto , luego llea a otra pc y debe deseralizar 
// //   pasar un objeto o cualidad  a un medio fisico , osea de una pc a otra pc
// public class Imagen implements java.io.Serializable{
    


//     // CLASE GUIA = A LA BD



//     // valores iguales a la bd de tu tabla archivo se usara como imagen  
//     private String nombre;
//     private int tamano;
//     private byte[] datos;



//     public Imagen() {
//     }
    
//     // constructor 
//     public Imagen(String nombre, int tamano, byte[] datos) {
//         this.nombre = nombre;
//         this.tamano = tamano;
//         this.datos = datos;
//     }



//     // metodo get y setter
//     public String getNombre() {
//         return this.nombre;
//     }

//     public void setNombre(String nombre) {
//         this.nombre = nombre;
//     }

//     public int getTamano() {
//         return this.tamano;
//     }

//     public void setTamano(int tamano) {
//         this.tamano = tamano;
//     }

//     public byte[] getDatos() {
//         return this.datos;
//     }

//     public void setDatos(byte[] datos) {
//         this.datos = datos;
//     }

// }













    // EJERCISIO 1 : este clase = a la de arriba pero agregamos el campo ruta
    // donde un cliente envia un archivo , usando su valores crea un objeto igual a una clase guia , lo envia al server 
    // el server lo recibe y lo inserta a la bd el objeto usando los valores , la clase guia es Imagen pero en la bd se usao es igual al archivo
    // bd_ejercisio04 se usa esa bd



    package com.cibertec.bd;

public class Imagen implements java.io.Serializable{
    
    private String nombre;
    private int tamano;
    private String ruta;  //esto le aumentampos a la tabla en la bd 
    private byte[] datos;
    

    public Imagen() {
    }

    public Imagen(String nombre, int tamano, String ruta, byte[] datos) {
        this.nombre = nombre;
        this.tamano = tamano;
        this.ruta = ruta;
        this.datos = datos;
    }

    public String getRuta() {
        return this.ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamano() {
        return this.tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public byte[] getDatos() {
        return this.datos;
    }

    public void setDatos(byte[] datos) {
        this.datos = datos;
    }
}