
package com.cibertec.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {



//    CONEXION A LA BD 



    static{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		//Metodo para crear conexiones
		public static Connection  getConexion(){
			Connection salida = null;
			try {
				salida = DriverManager.getConnection(
                    //   RUTA DE LA BD Y LA TABLA 
						"jdbc:mysql://localhost:3306/bd_ejercisio04?serverTimezone=America/Lima",
						"root",  //USUARIO 
						"1977");  //PASSWORD
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return salida;	
		}

}