package Exemplo.application;

import Exemplo.model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Chek-in date (dd/mm/yyyy): ");
        Date chekIn = sdf.parse(sc.next());
        System.out.print("Chek-out date (dd/mm/yyyy): ");
        Date chekOut = sdf.parse(sc.next());

        if (!chekOut.after(chekIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, chekIn, chekOut);
            System.out.println("Reservation: "+reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Chek-in date (dd/mm/yyyy): ");
            chekIn = sdf.parse(sc.next());
            System.out.print("Chek-out date (dd/mm/yyyy): ");
            chekOut = sdf.parse(sc.next());

            Date now = new Date();
            if (chekIn.before(now) || chekOut.before(now)){
                System.out.println("Error in reservation: Reservation dates for update must be future date");
            } else if (!chekOut.after(chekIn)){
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else {
                reservation.updateDates(chekIn, chekOut);
                System.out.println("Reservation: "+reservation);
            }
        }
        sc.close();
    }
}
