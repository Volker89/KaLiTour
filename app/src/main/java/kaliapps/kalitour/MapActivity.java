package kaliapps.kalitour;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.annotations.PolylineOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.services.commons.ServicesException;
import com.mapbox.services.commons.geojson.LineString;
import com.mapbox.services.commons.models.Position;
import com.mapbox.services.directions.v5.DirectionsCriteria;
import com.mapbox.services.directions.v5.MapboxDirections;
import com.mapbox.services.directions.v5.models.DirectionsResponse;
import com.mapbox.services.directions.v5.models.DirectionsRoute;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.mapbox.services.Constants.OSRM_PRECISION_V5;

public class MapActivity extends AppCompatActivity {

    private final static String TAG = "MapActivity";

    private MapView mapView;
    private MapboxMap map;
    private DirectionsRoute currentRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        final Position origin = Position.fromCoordinates(6.552112, 51.499963);
        final Position waypoint1 = Position.fromCoordinates(6.552338, 51.497979);
        final Position waypoint2 = Position.fromCoordinates(6.553681, 51.496354);
        final Position kneipe = Position.fromCoordinates(6.557562, 51.496057);
        final Position kiosk = Position.fromCoordinates(6.556641, 51.495273);
        final Position marktplatz = Position.fromCoordinates(6.556457, 51.494237);
        final Position bergmann = Position.fromCoordinates(6.557404, 51.492596);
        final Position kirche = Position.fromCoordinates(6.552929, 51.490398);
        final Position bruecke = Position.fromCoordinates(6.550942, 51.491801);
        final Position destination = Position.fromCoordinates(6.551540, 51.499484);

        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                map = mapboxMap;

                map.setMyLocationEnabled(true);

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(origin.getLatitude(), origin.getLongitude()))
                        .title("Start"));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(kneipe.getLatitude(), kneipe.getLongitude()))
                        .title("Kneipe"));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(kiosk.getLatitude(), kiosk.getLongitude()))
                        .title("Kiosk"));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(marktplatz.getLatitude(), marktplatz.getLongitude()))
                        .title("Marktplatz"));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(bergmann.getLatitude(), bergmann.getLongitude()))
                        .title("Bergmann"));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(kirche.getLatitude(), kirche.getLongitude()))
                        .title("Kirche"));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(bruecke.getLatitude(), bruecke.getLongitude()))
                        .title("Brücke"));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(destination.getLatitude(), destination.getLongitude()))
                        .title("Ziel"));

                mapboxMap.setOnMarkerClickListener(new MapboxMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(@NonNull Marker marker) {

                        if ((marker.getTitle())=="Start"){
                            Intent i = new Intent(MapActivity.this, InfoActivity.class);
                            i.putExtra("FROM_ACTIVITY","Start");
                            startActivity(i);
                            return true;
                        }

                        else if ((marker.getTitle())=="Kneipe"){
                            Intent i = new Intent(MapActivity.this, InfoActivity.class);
                            i.putExtra("FROM_ACTIVITY","Kneipe");
                            startActivity(i);
                            return true;
                        }

                        else if ((marker.getTitle())=="Kiosk"){
                            Intent i = new Intent(MapActivity.this, InfoActivity.class);
                            i.putExtra("FROM_ACTIVITY","Kiosk");
                            startActivity(i);
                            return true;
                        }

                        else if ((marker.getTitle())=="Marktplatz"){
                            Intent i = new Intent(MapActivity.this, InfoActivity.class);
                            i.putExtra("FROM_ACTIVITY","Marktplatz");
                            startActivity(i);
                            return true;
                        }

                        else if ((marker.getTitle())=="Bergmann"){
                            Intent i = new Intent(MapActivity.this, InfoActivity.class);
                            i.putExtra("FROM_ACTIVITY","Bergmann");
                            startActivity(i);
                            return true;
                        }

                        else if ((marker.getTitle())=="Kirche"){
                            Intent i = new Intent(MapActivity.this, InfoActivity.class);
                            i.putExtra("FROM_ACTIVITY","Kirche");
                            startActivity(i);
                            return true;
                        }

                        else if ((marker.getTitle())=="Brücke"){
                            Intent i = new Intent(MapActivity.this, InfoActivity.class);
                            i.putExtra("FROM_ACTIVITY","Brücke");
                            startActivity(i);
                            return true;
                        }

                        else if ((marker.getTitle())=="Ziel"){
                            Intent i = new Intent(MapActivity.this, InfoActivity.class);
                            i.putExtra("FROM_ACTIVITY","Ziel");
                            startActivity(i);
                            return true;
                        }

                        else{
                            return true;
                        }
                    }
                });

                try {
                    getRoute(origin, waypoint1);
                    getRoute(waypoint1, waypoint2);
                    getRoute(waypoint2, kneipe);
                    getRoute(kneipe, kiosk);
                    getRoute(kiosk, marktplatz);
                    getRoute(marktplatz, bergmann);
                    getRoute(bergmann, kirche);
                    getRoute(kirche, bruecke);
                    getRoute(bruecke, destination);
                } catch (ServicesException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void getRoute(Position origin, Position destination) throws ServicesException {

        MapboxDirections client = new MapboxDirections.Builder()
                .setOrigin(origin)
                .setDestination(destination)
                .setProfile(DirectionsCriteria.PROFILE_WALKING)
                .setAccessToken("pk.eyJ1Ijoidm9sa2VyODkiLCJhIjoiY2lvd3ZzOWhxMDBhMXc5bHcwMG8zZWd4ZiJ9.JqMxU3sOqKHUJ7aTHt1JhQ")
                .build();

        client.enqueueCall(new Callback<DirectionsResponse>() {
            @Override
            public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
                Log.d(TAG, "Response code: " + response.code());
                if (response.body() == null) {
                    Log.e(TAG, "No routes found, make sure you set the right user and access token.");
                    return;
                }

                currentRoute = response.body().getRoutes().get(0);
                drawRoute(currentRoute);
            }

            @Override
            public void onFailure(Call<DirectionsResponse> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
                Toast.makeText(MapActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void drawRoute(DirectionsRoute route) {
        LineString lineString = LineString.fromPolyline(String.valueOf(route.getGeometry()), OSRM_PRECISION_V5);
        List<Position> coordinates = lineString.getCoordinates();
        LatLng[] points = new LatLng[coordinates.size()];
        for (int i = 0; i < coordinates.size(); i++) {
            points[i] = new LatLng(
                    coordinates.get(i).getLatitude(),
                    coordinates.get(i).getLongitude());
        }

        map.addPolyline(new PolylineOptions()
                .add(points)
                .color(Color.parseColor("#009688"))
                .width(5));
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionsmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                return true;
            case R.id.item2:
                return true;
            case R.id.item3:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
