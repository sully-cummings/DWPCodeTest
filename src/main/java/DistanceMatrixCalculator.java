import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicData;


public class DistanceMatrixCalculator {

    public DistanceMatrixCalculator() {
    }

    /**
     * Return true is location is same city as target. Prevent need for coord filtering.
     * @param originLocation Location of user
     * @param target city defined in inclusion criteria
     * @return isTarget true if origin and target are same city
     */
    public Boolean isTargetCity(Location originLocation, Location target) {

        boolean isTarget;

        isTarget = false;

        if (originLocation.getCity() != null)
        isTarget = originLocation.getCity().equals(target.getCity());

        return isTarget;
    }

    /**
     * Calculate distance between users location and centre of search area
     * @param originLocation users location
     * @param target centre of search area
     * @param radius size of search area
     */
    public Boolean inRangeOfTarget(Location originLocation, Location target, double radius) {

        if (this.isTargetCity(originLocation, target))
            //Origin and target cities are the same, no filtering required
                return true;

        return this.distanceBetweenTwoCoords(originLocation, target) <= radius;
    }

    /**
     * Use Geodesic Class to calulcate the distance between two pairs of coords in miles
     * @param originLocation users location
     * @param target centre of search area
     * @return distanceInMiles distance between coordinates
     */
    private double distanceBetweenTwoCoords(Location originLocation, Location target) {

        GeodesicData geoData;
        double distanceInMiles;

        geoData = Geodesic.WGS84.Inverse(target.getLatitude(), target.getLongitude(), originLocation.getLatitude(), originLocation.getLongitude());
       distanceInMiles  = geoData.s12/ 1609.34;

        return distanceInMiles;

    }

}
