package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();
        System.out.print("Check-in date(dd/mm/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-in date(dd/mm/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        //testa se a data da var checkOut não é maior que a do checkIn
        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }else{
            Reservation reservation = new Reservation(roomNumber,checkIn,checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date(dd/mm/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-in date(dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());

            //ALTERAÇÃO: validação delegada para classe Reservation
            String error = reservation.uptadeDates(checkIn,checkOut);
            if(error != null){
                System.out.println("Error in reservation: " + error);
            }else{
                System.out.println("Reservation: " + reservation);
            }


        }
        sc.close();
    }
}
