import Entities.CarRental;
import Entities.Vehicle;
import Services.BrazilTaxService;
import Services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


        System.out.println("Enter the rental details: ");
        System.out.print("Model car: ");
        String carModel = sc.nextLine();
        System.out.print("withdrawal: ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), dtf);
        System.out.print("return: ");
        LocalDateTime end = LocalDateTime.parse(sc.nextLine(), dtf);

        CarRental car = new CarRental(start,end,new Vehicle(carModel));

        System.out.print("Enter the price per hour:");
        Double pricePerHour = sc.nextDouble();
        System.out.print("Enter the price per day:");
        Double pricePerDay = sc.nextDouble();
        RentalService rentalService = new RentalService(pricePerHour,pricePerDay,new BrazilTaxService());
        rentalService.processInvoice(car);

        System.out.println("INVOICE:");
        System.out.println("Basic payment:" + String.format("%.2f",car.getInvoice().getBasicPayment()));
        System.out.println("Tax:" + String.format("%.2f",car.getInvoice().getBasicPayment()));
        System.out.println("Total payment:" + String.format("%.2f",car.getInvoice().getBasicPayment()));
        sc.close();
    }
}