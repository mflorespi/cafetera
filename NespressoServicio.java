/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

import java.util.Scanner;

public class NespressoServicio {

    public void imprimirMenu() {

        System.out.println("¿Qué desea hacer?");
        System.out.println("Menú");
        System.out.println("1. Llenar cafetera");
        System.out.println("2. Servir una taza de café");
        System.out.println("3. Vaciar cafetera");
        System.out.println("4. Agregar de café");
        System.out.println("5. Apagar");

    }

    public void llenarCafetera(Nespresso nespresso) {

        nespresso.setCapacidadActual(nespresso.getCapacidadMaxima());

        System.out.println("La capacidad es de: " + nespresso.getCapacidadActual());

    }

    public void servirTaza(Nespresso nespresso) {

        Scanner scan = new Scanner(System.in);

        System.out.println(" Ingrese el tamaño de la taza que desea llenar");

        double tamanioTaza = scan.nextDouble();

        double totalCafe = nespresso.getCapacidadActual();

        if (totalCafe < tamanioTaza) {

            System.out.println("No se ha podido rellenar la taza completa. Se ha llenado hasta: " + (totalCafe));

        } else {

            System.out.println("La taza se ha llenado por completo");

            nespresso.setCapacidadActual(totalCafe - tamanioTaza);

            System.out.println("Queda " + nespresso.getCapacidadActual() + " litros de café");

        }

    }

    public void vaciarCafetera(Nespresso nespresso) {

        nespresso.setCapacidadActual(0);

        System.out.println("La cafetera se ha vaciado: " + nespresso.getCapacidadActual());

    }

    public void agregarCafe(Nespresso nespresso) {

        Scanner scan = new Scanner(System.in);

        if (nespresso.getCapacidadActual() < nespresso.getCapacidadMaxima()) {

            System.out.println("Ingrese la cantidad que desea de café. La capacidad máxima es de: " + nespresso.getCapacidadMaxima());

            System.out.println("Su cafetera tiene: " + nespresso.getCapacidadActual() + " litros de café");

            double ingresoCafe = scan.nextDouble();

            double nuevaCapacidadActual = nespresso.getCapacidadActual() + ingresoCafe;

            while (nuevaCapacidadActual > nespresso.getCapacidadMaxima()) {

                System.out.println("Ingrese una cantidad menor de café");

                ingresoCafe = scan.nextDouble();

                nuevaCapacidadActual = nespresso.getCapacidadActual() + ingresoCafe;

            }

            nespresso.setCapacidadActual(nuevaCapacidadActual);

            System.out.println(" SU cafetera se ha llenado. Ahora tiene: " + nuevaCapacidadActual + " litros de cafe.");

        } else {

            System.out.println("Su cafetera está llena, no es necesario rellenarla. Muchas gracias ;)" + nespresso.getCapacidadActual());

        }
    }

    public void ejecutarOperaciones(Nespresso nespresso) {

        Scanner scan = new Scanner(System.in);

        this.imprimirMenu();

        int operacion = scan.nextInt();

        while (operacion >= 1 && operacion <= 4) {

            switch (operacion) {

                case 1:

                    llenarCafetera(nespresso);

                    break;

                case 2:

                    servirTaza(nespresso);

                    break;

                case 3:

                    vaciarCafetera(nespresso);

                    break;

                case 4:

                    agregarCafe(nespresso);

                    break;

            }

            imprimirMenu();

            operacion = scan.nextInt();

            if (operacion == 5) {

                System.out.println("Adios =)");
            }

        }
    }

}
