package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Taller4 {

	public Taller4() {
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

			String nombre;
			String apellidos;

			Scanner leer = new Scanner(System.in);

			System.out.print("Introduzca el nombre");
			nombre = leer.next();
			System.out.print("Introduzca el apellido");
			apellidos = leer.next();

			String sql = "SELECT * from owners WHERE first_name = ? AND last_name = ?";

			try {
				pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, nombre);
				pStmt.setString(2, apellidos);

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