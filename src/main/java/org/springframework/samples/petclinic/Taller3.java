package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Taller3 {

	public Taller3() {
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
			Statement stmt = null;

			try {
				stmt = conn.createStatement();
			}
			catch (SQLException e) {
				System.err.println("Error al crear el statement para la consulta");
				e.printStackTrace();
			}

			String nombreD;

			Scanner leer = new Scanner(System.in);
			;
			System.out.print("Introduzca el nombre");
			nombreD = leer.next();

			String sql = "UPDATE owners SET city='Salamanca' WHERE first_name=" + nombreD;

			try {

				if (stmt != null) {
					ResultSet res = stmt.executeQuery(sql);
					System.out.print("Ciudad modificada correctamente");
				}
			}
			catch (SQLException e) {
				System.err.println("Error al modificar los datos");
				e.printStackTrace();
			}
			finally {
				try {
					if (stmt != null)
						stmt.close();
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