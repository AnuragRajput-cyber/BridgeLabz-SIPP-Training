package com.gla;

import java.time.LocalTime;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class SmartCityTransportSystem {

    // ---------- Interfaces & Functional / Marker interfaces ----------

    // TransportService defines expected behaviors + default method
    interface TransportService {
        String getId();
        String getType(); // e.g., "Bus", "Metro", "Taxi"
        List<ServiceSchedule> getSchedules();

        default void printServiceDetails() {
            System.out.println("Service[" + getType() + ":" + getId() + "] Schedules: ");
            getSchedules().forEach(s -> System.out.println("  " + s));
        }

        default boolean isActive() {
            return !getSchedules().isEmpty();
        }
    }

    // GeoUtils with a static method
    interface GeoUtils {
        static double calculateDistance(Location a, Location b) {
            double dx = a.x - b.x;
            double dy = a.y - b.y;
            return Math.sqrt(dx * dx + dy * dy);
        }
    }

    // Functional interface for fare calculation
    @FunctionalInterface
    interface FareCalculator {
        double calculateFare(Location from, Location to, double baseFare);
    }

    // Marker interface for emergency-capable services
    interface EmergencyService { /* marker - no methods */ }

    // ---------- Data classes ----------

    static class Location {
        final double x, y;
        final String name;

        Location(String name, double x, double y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return name + "(" + x + "," + y + ")";
        }
    }

    static class ServiceSchedule {
        final String routeId;
        final LocalTime departure;
        final double fare;
        final Location from, to;

        ServiceSchedule(String routeId, LocalTime departure, double fare, Location from, Location to) {
            this.routeId = routeId;
            this.departure = departure;
            this.fare = fare;
            this.from = from;
            this.to = to;
        }

        boolean isPeak() {
            int h = departure.getHour();
            return (h >= 7 && h <= 10) || (h >= 17 && h <= 20);
        }

        @Override
        public String toString() {
            return String.format("[%s -> %s | route=%s time=%s fare=%.2f %s]",
                    from.name, to.name, routeId, departure, fare, isPeak() ? "PEAK" : "OFF");
        }
    }

    static class Passenger {
        final String id;
        final String name;

        Passenger(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return name + "(" + id + ")";
        }
    }

    static class TripRecord {
        final Passenger passenger;
        final String routeId;
        final LocalTime time;
        final double fare;

        TripRecord(Passenger p, String routeId, LocalTime time, double fare) {
            this.passenger = p;
            this.routeId = routeId;
            this.time = time;
            this.fare = fare;
        }

        boolean isPeak() {
            int h = time.getHour();
            return (h >= 7 && h <= 10) || (h >= 17 && h <= 20);
        }

        @Override
        public String toString() {
            return passenger + " -> " + routeId + " @" + time + " fare=" + fare;
        }
    }

    // ---------- Service Implementations ----------

    static abstract class AbstractService implements TransportService {
        final String id;
        final List<ServiceSchedule> schedules;
        final String type;

        AbstractService(String type, String id, List<ServiceSchedule> schedules) {
            this.type = type;
            this.id = id;
            this.schedules = new ArrayList<>(schedules);
        }

        public String getId() { return id; }
        public String getType() { return type; }
        public List<ServiceSchedule> getSchedules() { return schedules; }
    }

    static class BusService extends AbstractService {
        BusService(String id, List<ServiceSchedule> schedules) { super("Bus", id, schedules); }
    }

    static class MetroService extends AbstractService {
        MetroService(String id, List<ServiceSchedule> schedules) { super("Metro", id, schedules); }

        // override default printing (fix applied here)
        @Override
        public void printServiceDetails() {
            System.out.println("=== Metro " + getId() + " ===");
            getSchedules().forEach(s -> System.out.println("  " + s));
        }
    }

    static class TaxiService extends AbstractService {
        TaxiService(String id, List<ServiceSchedule> schedules) { super("Taxi", id, schedules); }
    }

    // Emergency service example
    static class AmbulanceService extends AbstractService implements EmergencyService {
        AmbulanceService(String id, List<ServiceSchedule> schedules) { super("Ambulance", id, schedules); }

        // emergency override
        @Override public boolean isActive() { return true; }
    }

    // ---------- Utility static class for fares & logging ----------

    static class FareUtils {
        public static double applySurge(double fare, double factor) {
            return fare * factor;
        }

        public static void log(String s) { System.out.println("[LOG] " + s); }
    }

    // ---------- Demo / Main: simulates real-time flow ----------

    public static void main(String[] args) {

        // Locations
        Location A = new Location("A", 0, 0);
        Location B = new Location("B", 3, 4); // distance 5 from A
        Location C = new Location("C", 6, 8);

        // Schedules for services
        List<ServiceSchedule> busSchedules = Arrays.asList(
                new ServiceSchedule("R1", LocalTime.of(8, 0), 30.0, A, B),
                new ServiceSchedule("R1", LocalTime.of(11, 0), 25.0, A, B)
        );
        List<ServiceSchedule> metroSchedules = Arrays.asList(
                new ServiceSchedule("M1", LocalTime.of(7, 30), 20.0, A, C),
                new ServiceSchedule("M2", LocalTime.of(18, 0), 22.0, B, C)
        );
        List<ServiceSchedule> taxiSchedules = Arrays.asList(
                new ServiceSchedule("T1", LocalTime.of(9, 45), 150.0, A, B)
        );
        List<ServiceSchedule> ambulanceSched = Collections.emptyList(); // on-call

        // Create services
        List<TransportService> services = Arrays.asList(
                new BusService("BUS-101", busSchedules),
                new MetroService("MET-1", metroSchedules),
                new TaxiService("TAX-9", taxiSchedules),
                new AmbulanceService("AMB-01", ambulanceSched)
        );

        // 1) Passenger books a trip -> filter & sort using lambdas
        Location passengerFrom = A, passengerTo = B;
        double maxFare = 200;
        FareCalculator fareCalc = (from, to, base) -> {
            double distance = GeoUtils.calculateDistance(from, to);
            return base + distance * 2.0;
        };

        System.out.println("\n--- Available options for passenger booking (filtered & sorted) ---");
        List<ServiceSchedule> available = services.stream()
                .flatMap(svc -> svc.getSchedules().stream()
                        .map(schedule -> new AbstractMap.SimpleEntry<>(svc, schedule)))
                .filter(entry -> fareCalc.calculateFare(entry.getValue().from, entry.getValue().to, entry.getValue().fare) <= maxFare)
                .sorted((e1, e2) -> {
                    int t = e1.getValue().departure.compareTo(e2.getValue().departure);
                    if (t != 0) return t;
                    return Double.compare(e1.getValue().fare, e2.getValue().fare);
                })
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        available.forEach(System.out::println);

        // 2) Dashboard updates live -> ForEach shows currently active services
        System.out.println("\n--- Live Dashboard: Active Services ---");
        services.stream()
                .filter(TransportService::isActive)
                .forEach(TransportService::printServiceDetails);

        // 3) Simulate trip records for revenue reporting
        List<TripRecord> trips = Arrays.asList(
                new TripRecord(new Passenger("P1", "Anu"), "R1", LocalTime.of(8, 5), 30.0),
                new TripRecord(new Passenger("P2", "Bikram"), "R1", LocalTime.of(11, 15), 25.0),
                new TripRecord(new Passenger("P3", "Chinmay"), "M1", LocalTime.of(7, 35), 20.0),
                new TripRecord(new Passenger("P4", "Deepa"), "M2", LocalTime.of(18, 10), 22.0),
                new TripRecord(new Passenger("P5", "Esha"), "T1", LocalTime.of(9, 50), 150.0),
                new TripRecord(new Passenger("P6", "Farhan"), "R1", LocalTime.of(8, 20), 30.0)
        );

        System.out.println("\n--- Revenue grouped by route ---");
        Map<String, List<TripRecord>> byRoute = trips.stream()
                .collect(Collectors.groupingBy(tr -> tr.routeId));
        byRoute.forEach((route, recs) -> {
            double total = recs.stream().mapToDouble(r -> r.fare).sum();
            System.out.printf("Route %s -> trips=%d total=%.2f avg=%.2f%n",
                    route, recs.size(), total, total / recs.size());
        });

        System.out.println("\n--- Partitioning peak vs non-peak trips ---");
        Map<Boolean, List<TripRecord>> peakPartition = trips.stream()
                .collect(Collectors.partitioningBy(TripRecord::isPeak));
        System.out.println("Peak trips:"); peakPartition.get(true).forEach(System.out::println);
        System.out.println("Off-peak trips:"); peakPartition.get(false).forEach(System.out::println);

        System.out.println("\n--- Fare summary (all trips) ---");
        DoubleSummaryStatistics stats = trips.stream()
                .collect(Collectors.summarizingDouble(r -> r.fare));
        System.out.println(stats);

        System.out.println("\n--- Applying surge using method reference ---");
        DoubleUnaryOperator surge = fare -> FareUtils.applySurge(fare, 1.2);
        trips.stream().mapToDouble(t -> surge.applyAsDouble(t.fare)).forEach(f -> FareUtils.log("Surged fare: " + f));

        System.out.println("\n--- Print computed distances using method reference ---");
        services.stream()
                .flatMap(svc -> svc.getSchedules().stream())
                .map(sch -> GeoUtils.calculateDistance(passengerFrom, sch.to))
                .forEach(d -> FareUtils.log("Distance: " + d));

        System.out.println("\n--- Emergency services (priority) ---");
        services.stream()
                .filter(s -> s instanceof EmergencyService)
                .forEach(s -> System.out.println("PRIORITY: " + s.getType() + " " + s.getId()));

        System.out.println("\nSystem ready for extension: add new services by implementing TransportService.");
    }
}
