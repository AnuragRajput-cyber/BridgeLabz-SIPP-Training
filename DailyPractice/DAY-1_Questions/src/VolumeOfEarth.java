public class VolumeOfEarth {
    public static void main(String[] args) {
        double radius = 6378.0;
        double volumeKm = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        double volumeMiles = volumeKm * Math.pow(0.621371, 3); // Convert km³ to mi³
        System.out.println("The volume of Earth in cubic kilometers is " + volumeKm +
                " and in cubic miles is " + volumeMiles);
    }
}
