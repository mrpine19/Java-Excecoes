package Exemplo.application;

import Exemplo.model.entities.Reservation;
import Exemplo.model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Chek-in date (dd/mm/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Chek-out date (dd/mm/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Chek-in date (dd/mm/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Chek-out date (dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

        } catch (ParseException e){
            //ERRO PARA DATAS INVÁLIDAS
            System.out.println("Invaled date format");
        } catch (DomainException e){
            //ERRO PARA INCONSISTÊNCIAS NAS DATAS
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException e){
            //PARA QUALQUER OUTRO TIPO DE ERRO QUE POSSA ACONTECER
            //ERROS GENÉRICOS
            System.out.println("Unexpected error");
        }

        sc.close();
    }
}
