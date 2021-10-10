public class Location {

    private String city;
    private double latitude;
    private double longitude;

    public Location (double lat, double lon) {
        this.latitude = lat;
        this.longitude = lon;
    }

    public Location ( double lat, double lon,String city) {
        this.city = city;
        this.latitude = lat;
        this.longitude = lon;
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

    /**
     * Override equals method to ensure latitude and longitude data members are used to determine equality
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == this)
            return true;

        // Check if obj is an instance of Location
        if (!(obj instanceof Location l))
            return false;

        // No need to check city, matching coordinates mean same Location obj
        return latitude == l.getLatitude() && longitude == l.getLongitude();
    }
}
