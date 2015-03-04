package crimeApp.client;

import crimeApp.Web.Crime;
//import crimeApp.server.DataParser;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.*;
import com.google.gwt.maps.client.control.LargeMapControl;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.maps.client.*;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.dom.client.Style.Unit;

/**
 * Created by Branden Siegle on 2/25/2015.
 */
public class CS310CrimeApp implements EntryPoint{
    private FlexTable container = new FlexTable();
    private RootPanel mainElement = RootPanel.get("mainElement");
    private SimplePanel mapPanel = new SimplePanel();
    private CurrentLocation currentLocation = new CurrentLocation();
    private String url = URL.encode("ftp://webftp.vancouver.ca/opendata/csv/crime_2014.csv");


    public void display(){
        
        

        LatLng cawkerCity = LatLng.newInstance(39.509, -98.434);

        
        final MapWidget map = new MapWidget(cawkerCity, 2);

        map.setSize("100%", "100%");
        // Add some controls for the zoom level
        map.addControl(new LargeMapControl());

        // Add a marker
        map.addOverlay(new Marker(cawkerCity));

        // Add an info window to highlight a point of interest
        map.getInfoWindow().open(map.getCenter(),
                new InfoWindowContent("World's Largest Ball of Sisal Twine"));

        final DockLayoutPanel dock = new DockLayoutPanel(Unit.PX);
        dock.addNorth(map, 500);




        mapPanel.setWidth("500px");
        mapPanel.setHeight("650px");



        //MapWidget gMap = new MapWidget();
        //mapPanel.add(gMap);



        

        
        mainElement.add(dock);
        mapPanel.setVisible(true);



    }

    private void storeCrime(Crime crime){

    }

    @Override
    public void onModuleLoad() {


        Maps.loadMapsApi("", "2", false, new Runnable() {
                    public void run() {
                        display();
                    }
                });
    }

    public class ExampleHandler extends Composite implements ClickHandler{
        public void onClick(ClickEvent event){

            Widget sender = (Widget) event.getSource();
            
        }
    }


}

