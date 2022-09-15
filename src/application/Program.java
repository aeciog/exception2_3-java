package application;

import model.entities.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Número quarto: ");
        int numero = sc.nextInt();
        System.out.print("Data Check-in (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Data Check-out (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)){
            System.out.println("Erro na reserva: Check-out data must be after check-in date");
        }else {
            Reserva reserva = new Reserva(numero, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();

            System.out.println("Digite a data de atualição da reserva: ");
            System.out.print("Data check-in (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Data check-out (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Error em reserva: Reservation dates for updates mus be future.");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("Error em reserva: Check-out data must be after check-in date");
            } else {
                reserva.atualizacaoDatas(checkIn, checkOut);
                System.out.println("Reserva: " + reserva);
            }

            reserva.atualizacaoDatas(checkIn, checkOut);
            System.out.println("Reserva: " + reserva);
        }
        sc.close();
    }
}
