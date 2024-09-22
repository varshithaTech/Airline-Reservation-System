
import java.util.*;

public class AirlineReservationSystem {

    private static Map<String, List<Flight>> flights = new HashMap<>();

    public static void main(String[] args) {
        // Initialize the flights database
        flights.put("CJB-JFK", Arrays.asList(
                new Flight("AI608", "AI119", 3225, 86642),
                new Flight("AI539", "AI575", "AI119", 2615, 90706),
                new Flight("6E2189", "VS303", "VS3", 2615, 126566)
        ));

        // Start the reservation system
        ReservationSystem reservationSystem = new ReservationSystem();

        // Get the list of available flights from Coimbatore to New York
        List<Flight> availableFlights = reservationSystem.getAvailableFlights("CJB", "JFK");

        // Create a single array of Flight objects
        Flight[] flightsArray = availableFlights.toArray(new Flight[0]);

        // Pass the array to the asList() method
        List<Flight> flightsList = Arrays.asList(flightsArray);

        // Print the list of flights
        System.out.println(flightsList);
    }

    private static class ReservationSystem {

        public List<Flight> getAvailableFlights(String fromAirport, String toAirport) {
            return flights.get(fromAirport + "-" + toAirport);
        }
    }

    private static class Flight {

        private String flightNumber;
        private String airlineCode;
        private int duration;
        private int price;
        private int availableSeats;

        public Flight(String flightNumber, String airlineCode, int duration, int price, int availableSeats) {
            this.flightNumber = flightNumber;
            this.airlineCode = airlineCode;
            this.duration = duration;
            this.price = price;
            this.availableSeats = availableSeats;
        }

        public int getAvailableSeats() {
            return availableSeats;
        }

        public void setAvailableSeats(int availableSeats) {
            this.availableSeats = availableSeats;
        }
    }
}
