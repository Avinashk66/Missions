import java.util.Scanner;

public class RailwayBookingSystem {
    static String[] passengerNames = new String[10];
    static int[] passengerAges = new int[10];
    static String[] sourceStations = new String[10];
    static String[] destinationStations = new String[10];
    static int bookedTickets = 0;

    public static void bookTicket() {
        if (bookedTickets >= passengerNames.length) {
            System.out.println("All tickets are booked.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter passenger name: ");
        passengerNames[bookedTickets] = sc.nextLine();
        System.out.print("Enter passenger age: ");
        passengerAges[bookedTickets] = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter source station: ");
        sourceStations[bookedTickets] = sc.nextLine();
        System.out.print("Enter destination station: ");
        destinationStations[bookedTickets] = sc.nextLine();
        bookedTickets++;
        System.out.println("Ticket booked successfully.");
    }

    public static void viewTickets() {
        if (bookedTickets == 0) {
            System.out.println("No tickets booked.");
            return;
        }
        System.out.println("\nBooked Tickets:");
        for (int i = 0; i < bookedTickets; i++) {
            System.out.println((i + 1) + ". Name: " + passengerNames[i] + ", Age: " + passengerAges[i] +
                               ", From: " + sourceStations[i] + ", To: " + destinationStations[i]);
        }
    }

    public static void cancelTicket() {
        if (bookedTickets == 0) {
            System.out.println("No tickets to cancel.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ticket number to cancel: ");
        int ticketNo = sc.nextInt();
        if (ticketNo < 1 || ticketNo > bookedTickets) {
            System.out.println("Invalid ticket number.");
            return;
        }
        for (int i = ticketNo - 1; i < bookedTickets - 1; i++) {
            passengerNames[i] = passengerNames[i + 1];
            passengerAges[i] = passengerAges[i + 1];
            sourceStations[i] = sourceStations[i + 1];
            destinationStations[i] = destinationStations[i + 1];
        }
        bookedTickets--;
        System.out.println("Ticket cancelled successfully.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Railway Booking System ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. View Tickets");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    bookTicket();
                    break;
                case 2:
                    viewTickets();
                    break;
                case 3:
                    cancelTicket();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
