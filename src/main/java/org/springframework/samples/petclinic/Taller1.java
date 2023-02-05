package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Taller1 {

	public Taller1() {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/petclinic", "petclinic", "petclinic");

			System.out.println("Conexión creada");
		}
		catch (SQLException e) {
			System.err.println("Error al crear la conexión de la base de datos");
			e.printStackTrace();

		}

		ResultSet res = null;
		if (conn != null) {
			Statement stmt = null;
			try {
				stmt = conn.createStatement();
			}
			catch (SQLException e) {
				System.err.println("Error al crear el statement para la consulta");
				e.printStackTrace();
			}
			if (conn != null) {
				String sql = "SELECT * FROM owners";
				try {

					if (stmt != null) {
						res = stmt.executeQuery(sql);
					}
				}
				catch (SQLException e) {
					System.err.println("Error al crear la consulta");
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					if (res != null) {
						System.out.printf("|%10s|%10s|%25s|%15s|%15s|%n", "Nombre", "Apellido", "Direccion", "Ciudad",
								"Telefono");
						while (res.next()) {

							System.out.printf("|%10s|%10s|%25s|%15s|%15s|%n", res.getString("first_name"),
									res.getString("last_name"), res.getString("address"), res.getString("city"),
									res.getString("telephone"));

						}
					}
				}
				catch (SQLException e) {
					System.err.println("Error al obtener los datos de la consulta");
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

}