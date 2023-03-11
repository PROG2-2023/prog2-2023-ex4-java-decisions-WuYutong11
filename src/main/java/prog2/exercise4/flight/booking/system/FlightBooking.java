package prog2.exercise4.flight.booking.system;

import java.time.LocalDate;

public class FlightBooking {

    private String flightCompany;

    private String flightID;

    private String passengerFullName;

    private String sourceAirport;

    private TripDestination tripDestination;

    private String destinationAirport;

    private LocalDate departureDate;

    private LocalDate returnDate;

    private int childPassengers;

    private int adultPassengers;

    private int totalPassengers;

    private double departingTicketPrice;

    private double returnTicketPrice;

    private double totalTicketPrice;

    private String ticketNumber;

    private BookingClass bookingClass;

    private TripType tripType;

    private TripSource tripSource;

    public TripSource getTripSource() {
        return this.tripSource;
    }

    public void setTripSource(String choice) {
        TripSource tripSource = TripSource.getTripSourceWithChoice(choice);
        this.tripSource = tripSource;
    }


    public TripType getTripType() {
        return tripType;
    }

    public void setTripType(String choice) {
        TripType tripType = TripType.getTripTypeWithChoice(choice);
        this.tripType = tripType;
    }

    public BookingClass getBookingClass() {
        return bookingClass;
    }

    public void setBookingClass(String choice) {
        BookingClass bookingClass = BookingClass.getBookingClassWithChoice(choice);
        this.bookingClass = bookingClass;
    }

    public FlightBooking(String passengerFullName, LocalDate departureDate, LocalDate returnDate, int childPassengers, int adultPassengers) {
        this.passengerFullName = passengerFullName;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.childPassengers = childPassengers;
        this.adultPassengers = adultPassengers;
    }

    public String getFlightCompany() {
        return flightCompany;
    }

    public void setFlightCompany(String flightCompany) {
        this.flightCompany = flightCompany;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getPassengerFullName() {
        return passengerFullName;
    }

    public void setPassengerFullName(String passengerFullName) {
        this.passengerFullName = passengerFullName;
    }

    public String getSourceAirport() {
        return sourceAirport;
    }

    public void setSourceAirport(String sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    public TripDestination getTripDestination() {
        return this.tripDestination;
    }

    public void setTripDestination(String tripSource, String tripDestination) {
        this.tripSource = TripSource.getTripSourceWithChoice(tripSource);
        this.tripDestination = TripDestination.getTripDestinationWithChoice(tripDestination);
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        if (returnDate.isBefore(departureDate.plusDays(2))) {
            returnDate = departureDate.plusDays(2);
        }
        this.returnDate = returnDate;
    }

    public int getChildPassengers() {
        return childPassengers;
    }

    public void setChildPassengers(int childPassengers) {
        this.childPassengers = childPassengers;
    }

    public int getAdultPassengers() {
        return adultPassengers;
    }

    public void setAdultPassengers(int adultPassengers) {
        this.adultPassengers = adultPassengers;
    }

    public int getTotalPassengers() {
        this.totalPassengers = this.childPassengers + this.adultPassengers;
        return this.totalPassengers;
    }

    public void setTotalPassengers(int childPassengers, int adultPassengers) {
        this.childPassengers = childPassengers;
        this.adultPassengers = adultPassengers;
        this.totalPassengers = childPassengers + adultPassengers;
    }

    public double getDepartingTicketPrice() {
        return departingTicketPrice;
    }

    public void setDepartingTicketPrice(double departingTicketPrice) {
        this.departingTicketPrice = departingTicketPrice;
    }

    public double getReturnTicketPrice() {
        return returnTicketPrice;
    }

    //    public void setReturnTicketPrice(double returnTicketPrice) {
//        this.returnTicketPrice = returnTicketPrice;
//    }
    public void setReturnTicketPrice() {
        this.returnTicketPrice = this.departingTicketPrice;
    }

    public double getTotalTicketPrice() {
        this.totalTicketPrice = this.departingTicketPrice + this.returnTicketPrice;
        return this.totalTicketPrice;
    }

    public void setTotalTicketPrice() {
//        this.departingTicketPrice = departingTicketPrice;
//        this.returnTicketPrice = returnTicketPrice;
        double totalTicketPrice = this.departingTicketPrice + this.returnTicketPrice;
    }

    public void setDepartingTicketPrice(int child, int adults) {
        double ticketPrice = 0;
        if (isDOM()) {
            ticketPrice += (child + adults) * (300 + (0.1 * 300) + (0.05 * 300));
        } else {
            ticketPrice += (child + adults) * (300 + (0.1 * 300) + (0.05 * 300));
        }
        if (this.bookingClass == BookingClass.FIRST) {
            ticketPrice += 250;
        } else if (this.bookingClass == BookingClass.BUSINESS) {
            ticketPrice += 150;
        } else {
            ticketPrice += 50;
        }
        this.departingTicketPrice = ticketPrice;
    }

    public String getTicketNumber() {
        StringBuilder sb = new StringBuilder();
        if (this.tripType == TripType.ONE_WAY) {
            sb.append("11");
        } else {
            sb.append("22");
        }
        if (this.bookingClass == BookingClass.FIRST) {
            sb.append("F");
        } else if (this.bookingClass == BookingClass.BUSINESS) {
            sb.append("B");
        } else {
            sb.append("E");
        }
        if (isDOM()) {
            sb.append("####DOM");
        } else {
            sb.append("####INT");
        }
        this.ticketNumber = sb.toString();
        return this.ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    /**
     * is domestic or international
     *
     * @return true is demestic,false is international
     */
    private boolean isDOM() {
        if ((this.tripSource == TripSource.BEIJING && this.tripDestination == TripDestination.NANJING)
                || (this.tripDestination == TripDestination.BEIJING && this.tripSource == TripSource.NANJING)
                || (this.tripSource == TripSource.OULU && this.tripDestination == TripDestination.HELSINKI)
                || (this.tripDestination == TripDestination.OULU && this.tripSource == TripSource.HELSINKI)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Dear " + passengerFullName + ". Thank you for booking your flight with " + flightCompany + "." + "\n" + "Following are the details of your booking and the trip:" + "\n" + "Ticket Number: " + ticketNumber + "\n" + "From " + tripSource + " to " + tripDestination + "\n" + "Date of departure: " + departureDate + "\n" + "Date of return: " + returnDate + "\n" + "Total passengers: " + (this.childPassengers + this.adultPassengers) + "\n" + "Total ticket price in Euros: " + totalTicketPrice;
    }

    public enum BookingClass {
        FIRST("1"), BUSINESS("2"), ECONOMY("3");
        private String choice;

        BookingClass(String choice) {
            this.choice = choice;
        }

        public static BookingClass getBookingClassWithChoice(String choice) {
            final BookingClass[] values = BookingClass.values();
            for (BookingClass value : values) {
                if (value.choice == choice) {
                    return value;
                }
            }
            return null;
        }
    }

    public enum TripType {
        ONE_WAY("1"), RETURN("2");

        private String choice;

        TripType(String choice) {
            this.choice = choice;
        }

        public static TripType getTripTypeWithChoice(String choice) {
            final TripType[] values = TripType.values();
            for (TripType value : values) {
                if (value.choice == choice) {
                    return value;
                }
            }
            return null;
        }
    }

    public enum TripSource {
        NANJING("1"), BEIJING("2"), OULU("3"), HELSINKI("4");

        private String choice;

        TripSource(String choice) {
            this.choice = choice;
        }

        public static TripSource getTripSourceWithChoice(String choice) {
            final TripSource[] values = TripSource.values();
            for (TripSource value : values) {
                if (value.choice == choice) {
                    return value;
                }
            }
            return null;
        }
    }

    public enum TripDestination {
        NANJING("1"), BEIJING("2"), OULU("3"), HELSINKI("4");
        private String choice;

        TripDestination(String choice) {
            this.choice = choice;
        }

        public static TripDestination getTripDestinationWithChoice(String choice) {
            final TripDestination[] values = TripDestination.values();
            for (TripDestination value : values) {
                if (value.choice == choice) {
                    return value;
                }
            }
            return null;
        }
    }
}
