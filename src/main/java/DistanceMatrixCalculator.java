import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicData;


public class DistanceMatrixCalculator {

public void DistanceMatrix() {

}

    public Boolean isTargetCity(Location originLocation, Location target) {
        boolean isTarget;
        isTarget = originLocation.getCity().equals(target.getCity());
        return isTarget;
    }

    public Boolean inRangeOfTarget(Location originLocation, Location target, double radius) {

         if (this.distanceBetweenTwoCoords(originLocation,target) <= radius)
                return true;

         return false;
    }

    private double distanceBetweenTwoCoords(Location originLocation, Location target) {

        GeodesicData geoData;

        geoData = Geodesic.WGS84.Inverse(target.getLatitude(), target.getLongitude(), originLocation.getLatitude(), originLocation.getLongitude());
        double distanceInMiles = geoData.s12/ 1609.34;

        return distanceInMiles;

    }

}
