package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Taller2 {

	public Taller2() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/petclinic", "petclinic", "petclinic");

			System.out.println("Conexión creada");
		}
		catch (SQLException e) {
			System.err.println("Error al crear la conexión de la base de datos");
			e.printStackTrace();

		}
		if (conn != null) {
			PreparedStatement pStmt = null;

			Integer id_aBuscar;
			String nombre;
			String apellido;
			String direccion;
			String ciudad;
			String telefono;

			Scanner leer = new Scanner(System.in);

			System.out.print("Introduzca el Id: ");
			id_aBuscar = leer.nextInt();
			System.out.print("Introduzca el nombre: ");
			nombre = leer.next();
			System.out.print("Introduzca el apellido: ");
			apellido = leer.next();
			System.out.print("Introduzca la dirección: ");
			direccion = leer.next();
			System.out.print("Introduzca la ciudad: ");
			ciudad = leer.next();
			System.out.print("Introduzca el telefóno: ");
			telefono = leer.next();

			String sql = "INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES(?,?,?,?,?)";

			try {
				pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, nombre);
				pStmt.setString(2, apellido);
				pStmt.setString(3, direccion);
				pStmt.setString(4, ciudad);
				pStmt.setString(5, telefono);
			}
			catch (SQLException e) {
				System.err.println("Error al crear el statement para la consulta");
				e.printStackTrace();
			}
			finally {
				try {
					if (pStmt != null)
						pStmt.close();
				}
				catch (SQLException e) {
					System.err.println("Error al cerrar el statement");
					e.printStackTrace();
				}
				finally {
					try {
						if (conn != null)
							conn.close();
					}
					catch (SQLException e) {
						System.err.println("Error al cerrar la conexión de la base de datos");
					}
				}
			}
		}
	}

}