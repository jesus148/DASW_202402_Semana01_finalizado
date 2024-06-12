

package com.cibertec.bd;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cibertec.util.MyConnection;

public class Server {



    // EJERCISIO 1 : 
    // donde un cliente envia un archivo , usando su valores crea un objeto igual a una clase guia , lo envia al server 
    // el server lo recibe y lo inserta a la bd el objeto usando los valores , la clase guia es Imagen pero en la bd se usao es igual al archivo
    // bd_ejercisio04 se usa esa bd




    
    // PUERTO 
     private static final int PORT = 13;

    public Server(){
        System.out.println("1 >> [ini] Server constructor");
        
        // creando el socket con ese puerto si hay un error se va aal catch
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("2 >> waiting for client..."); 
            
            // siempre se mantiene ejecutandose 
            while(true){

                // escuchando un cliente 
                Socket clienSocket = serverSocket.accept();
                System.out.println("3 >> accepted client connection...");
                
                //Flujo de datos de entrada y salida    
                // data obtenida del cliente 
                ObjectInputStream entrada = new ObjectInputStream(clienSocket.getInputStream());
                
                //Recibiendo archivo
                Imagen imagen = (Imagen) entrada.readObject();

                //conectar a la base de datos
                // bd_ejercisio04 se usa esa bd > tabla archivo
                Connection conn = MyConnection.getConexion();
                System.out.println("Conectado a la base de datos");
                // un insert campos iguales a la tabla archivo 
                //  el id en la tabla es autoincrement
                PreparedStatement ps = conn.prepareStatement("INSERT INTO archivo (nombre, tamano, datos , ruta) VALUES (?, ?, ?, ?)");
                // desenvolsandom data del clientes , los valores 
                ps.setString(1, imagen.getNombre());
                ps.setInt(2, imagen.getTamano()); //tamaño en bytes es un numero 
                ps.setBytes(3, imagen.getDatos());
                ps.setString(4, imagen.getRuta());
                int insertados = ps.executeUpdate(); //ejecuta el insert
                System.out.println("Se insertaron " + insertados + " registros"); //campos registrados
                ps.close();//cierra consulta
                conn.close();//cierra la conexion
                

                System.out.println("4 >> final for client...");
                clienSocket.close(); //cierra el server  para ese cliente
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }




    // metodo donde se ejecuta , si hay varios eliminar los demas 
    // ejcuta solo 1 server 
    public static void main(String[] args) {
        new Server();   
    }
}