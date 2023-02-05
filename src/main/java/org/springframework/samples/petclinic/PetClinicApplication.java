/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

import jakarta.transaction.Transactional;

/**
 * PetClinic Spring Boot Application.
 *
 * @author Dave Syer
 *
 */
@SpringBootApplication
@ImportRuntimeHints(PetClinicRuntimeHints.class)
public class PetClinicApplication implements CommandLineRunner {

	public static void MenuEjecutaOpcion(int opc) {

		switch (opc) {
		case 1:
			System.out.print("Ejecutando Taller 1 ...." + "\n\n");
			Taller1 t1 = new Taller1();

			break;
		case 2:
			System.out.print("Ejecutando Taller 2 ...." + "\n\n");
			Taller2 t2 = new Taller2();

			break;
		case 3:
			System.out.print("Ejecutando Taller 3 ...." + "\n\n");
			Taller3 t3 = new Taller3();

			break;
		case 4:
			System.out.print("Ejecutando Taller 4 ...." + "\n\n");
			Taller4 t4 = new Taller4();

			break;
		case 5:
			System.out.print("Ejecutando Ejercicio 5 ...." + "\n\n");
			Reto1 R1 = new Reto1();

			break;
		}
	}

	public static void MenuVisual() {
		System.out.print("**************" + "\n");
		System.out.print("1. Taller 1. Mostrar clientes." + "\n");
		System.out.print("2. Taller 2. Insertar nuevo propietario de una mascosta." + "\n");
		System.out.print("3. Taller 3. Modificar la ciudad por Salamanca." + "\n");
		System.out.print("4. Taller 4. Solicita nueva ciudad y mostrar." + "\n");
		System.out.print("5. Reto. Asignate una mascota mediante la clase Pet, después borrar los datos." + "\n");
		System.out.print("7. Salir" + "\n");
		System.out.print("**************" + "\n");
		System.out.print("Seleccione opción" + "\n");
	}

	public static int MenuSeleccion(int min, int max) {
		Scanner entrada = new Scanner(System.in);
		int seleccion = -1;
		boolean salida = false;

		while (salida == false) {
			try {
				seleccion = entrada.nextInt();
				if (seleccion >= min && seleccion <= max) {
					salida = true;
				}
				else {
					System.out.print("Debe introducir un número entre " + min + " y " + max + "\n");
				}
			}
			catch (InputMismatchException e) {
				System.out.print("¡¡¡ Debe introducir un número !!!" + "\n");
				entrada.next();
			}
		}
		return seleccion;
	}

	public static void LimpiaConsola() {

		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void main(String[] args) {
		SpringApplication.run(PetClinicApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");
		int selec = -1;
		int opMin = 1;
		int opMax = 7;

		do {
			MenuVisual();
			selec = MenuSeleccion(opMin, opMax);
			MenuEjecutaOpcion(selec);
			LimpiaConsola();
		}
		while (selec != opMax);

		System.out.print("Fin ...." + "\n");
	}

}