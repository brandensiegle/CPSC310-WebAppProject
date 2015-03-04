package crimeApp.client;


import com.google.gwt.core.client.Callback;
import com.google.gwt.geolocation.client.Geolocation;
import com.google.gwt.geolocation.client.*;
import com.google.gwt.geolocation.client.Position.*;

/**
 * Created by Branden Siegle on 2/25/2015.
 */
public class CurrentLocation {
    private Geolocation currentGeoLocation;
    final Position[] position = new Position[1];
    //private LatLng<> currentLatLng;

    public CurrentLocation(){
        this.currentGeoLocation = Geolocation.getIfSupported();
        currentGeoLocation.getCurrentPosition(new Callback<Position, PositionError>() {
            @Override
            public void onFailure(PositionError reason) {

            }

            @Override
            public void onSuccess(Position result) {
                position[0] = result;
                Coordinates a = result.getCoordinates();

                int b;
            }
        });

    }

    public void updateLocation(){
        currentGeoLocation = Geolocation.getIfSupported();


        currentGeoLocation.getCurrentPosition(new Callback<Position, PositionError>() {
            @Override
            public void onFailure(PositionError reason) {

            }

            @Override
            public void onSuccess(Position result) {
                position[0] = result;
            }
        });
    }

    public Position getCurrentLocation(){
        return position[1];
    }
}
