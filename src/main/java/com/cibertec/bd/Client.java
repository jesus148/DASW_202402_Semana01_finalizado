
package com.cibertec.bd;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class Client {


    

    // EJERCISIO 1 : 
    // donde un cliente envia un archivo , usando su valores crea un objeto igual a una clase guia , lo envia al server 
    // el server lo recibe y lo inserta a la bd el objeto usando los valores , la clase guia es Imagen pero en la bd se usao es igual al archivo
    // bd_ejercisio04 se usa esa bd


    
     
    private static final String HOST = "localhost";
    private static final int PORT = 13;
    
    public Client(){
        System.out.println("1 >> [ini] Client constructor");
        try {
            System.out.println("2 >> connecting to server...");
            Socket socket = new Socket(HOST, PORT);
            System.out.println("3 >> connected to server...");


            // Primero obtener el file
            // SACANDO LA DATA DE ESA RUTA osea los img , usamos los random
            // enviara solo 1 file 
            File[] files = new File("D:\\client").listFiles();
            Random random = new Random();
            int index = random.nextInt(files.length);
            File file = files[index];
            System.out.println("Enviando archivo: " + file.getAbsolutePath()); //ruta del archivo

            //Flujo de datos de entrada y salida
            // enviar cualquier tipo de objeto
            ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
            
            //Se obtiene los bytes del archivo osea la info de ese archivo
            FileInputStream fis = new FileInputStream(file);
            byte[] datos = new byte[(int) file.length()];
            fis.read(datos);  //enviar 

            //se crea el objeto imagen lo que se enviara
            //osea la img es un file , sacamos toda la info y lo convertimos en un objeto con la info de la img 
            // y eso se inserta en la bd , usar la clase guia Imagen(en la bd es igual a la clase archivo)
            Imagen imagen = new Imagen();
            imagen.setNombre(file.getName());//nombre del archivo
            imagen.setTamano((int) file.length());//tamaño en bytes
            imagen.setDatos(datos);//datos se agrega la imagen pero en formato bytes , ver en la bd 
            imagen.setRuta(file.getAbsolutePath());//la ruta de ese archivo

            //se envia el objeto imagen al socket o el server 
            salida.writeObject(imagen);

            //se cierra el flujo de datos
            fis.close();
            
            System.out.println("Archivo enviado: " + file.getAbsolutePath()); //ruta del archivo
            System.out.println("4 >> final for client...");
        //   cerrando el socket pa este cliente 
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // metodo ap ejecutar, puede ejecutar varios clintes
    public static void main(String[] args) {
        new Client();
    }
}