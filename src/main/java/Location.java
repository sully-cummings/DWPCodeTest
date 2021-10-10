public class Location {

    private String city;
    private double latitude;
    private double longitude;

    public Location (String city, double lat, double lon) {
        this.city = city;
        this.latitude = lat;
        this.longitude = lon;
    }

    public String getLocation(double longitude, double latitude) {

        String location;

        location = this.city;
        //TODO get coordinates

        return location;
    }

    public String getCity() {
        return city;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
