package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.Pet;

public class Reto1 {
	public Reto1(){

		Owner owner = new Owner();

		owner.setId(2);
		owner.setFirstName("Hector");
		owner.setLastName("Garcia");
		owner.setCity("Salamanca");
		owner.setTelephone("666667788");


		Connection conn = null;
		PreparedStatement pStmt = null;
		PreparedStatement pStmtPet = null;
		String sql = "INSERT INTO OWNER (id, first_name, last_name, address, city, telephone) VALUES (?,?,?,?,?,?)";

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/petclinic", "petclinic", "petclinic");

			System.out.println("Conexión creada");
		}
		catch (SQLException e) {
			System.err.println("Error al crear la conexión de la base de datos");
			e.printStackTrace();

		try {

			pStmt.setInt(1, owner.getId());
			pStmt.setString(2, owner.getFirstName());
			pStmt.setString(3, owner.getLastName());
			pStmt.setString(4, owner.getAddress());
			pStmt.setString(5, owner.getCity());
			pStmt.setString(6, owner.getTelephone());

			

		}catch (SQLException e1) {
			e.printStackTrace();
		}finally {
			try {
				pStmt.close();
				pStmt.close();
				conn.close();
			}catch (SQLException e2) {
				e.printStackTrace();
			}
		}

	}
	}

}
