package kaliapps.kalitour;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
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

        final Position origin = Position.fromCoordinates(6.552291, 51.500007);
        final Position johannstrasse = Position.fromCoordinates(6.553049, 51.498814);
        final Position alfredstrasse = Position.fromCoordinates(6.554024, 51.496045);
        final Position georgstrasse = Position.fromCoordinates(6.557750, 51.496070);
        final Position zwischen1 = Position.fromCoordinates(6.557972, 51.494804);
        final Position markt = Position.fromCoordinates(6.556149, 51.494772);
        final Position antonstrasse = Position.fromCoordinates(6.557285, 51.492454);
        final Position lotharstrasse = Position.fromCoordinates(6.556266, 51.491963);
        final Position barbarastrasse = Position.fromCoordinates(6.556684, 51.490622);
        final Position vinnstraße = Position.fromCoordinates(6.554801, 51.489328);
        final Position zwischen2 = Position.fromCoordinates(6.550873, 51.491418);
        final Position destination = Position.fromCoordinates(6.551518, 51.499479);

        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                map = mapboxMap;

                map.setMyLocationEnabled(true);

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(origin.getLatitude(), origin.getLongitude()))
                        .title("Altes Rathaus"));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(johannstrasse.getLatitude(), johannstrasse.getLongitude()))
                        .title("Johannstrasse"));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(alfredstrasse.getLatitude(), alfredstrasse.getLongitude()))
                        .title("Alfredstrasse"));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(georgstrasse.getLatitude(), georgstrasse.getLongitude()))
                        .title("Georgstrasse"));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(markt.getLatitude(), markt.getLongitude()))
                        .title("Markt"));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(antonstrasse.getLatitude(), antonstrasse.getLongitude()))
                        .title("Antonstrasse"));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(lotharstrasse.getLatitude(), lotharstrasse.getLongitude()))
                        .title("Lotharstrasse"));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(barbarastrasse.getLatitude(), barbarastrasse.getLongitude()))
                        .title("Barbarastrasse"));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(vinnstraße.getLatitude(), vinnstraße.getLongitude()))
                        .title("Vinnstrasse"));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(destination.getLatitude(), destination.getLongitude()))
                        .title("Maxstrasse"));

                mapboxMap.setOnMarkerClickListener(new MapboxMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(@NonNull Marker marker) {

                        if ((marker.getTitle())=="Altes Rathaus"){
                            Intent i = new Intent(MapActivity.this, InfoActivity.class);
                            i.putExtra("FROM_ACTIVITY","Altes Rathaus");
                            startActivity(i);
                            return true;
                        }

                        else if ((marker.getTitle())=="Johannstrasse"){
                            Intent i = new Intent(MapActivity.this, InfoActivity.class);
                            i.putExtra("FROM_ACTIVITY","Johannstrasse");
                            startActivity(i);
                            return true;
                        }

                        else if ((marker.getTitle())=="Alfredstrasse"){
                            Intent i = new Intent(MapActivity.this, InfoActivity.class);
                            i.putExtra("FROM_ACTIVITY","Alfredstrasse");
                            startActivity(i);
                            return true;
                        }

                        else if ((marker.getTitle())=="Georgstrasse"){
                            Intent i = new Intent(MapActivity.this, InfoActivity.class);
                            i.putExtra("FROM_ACTIVITY","Georgstrasse");
                            startActivity(i);
                            return true;
                        }

                        else if ((marker.getTitle())=="Markt"){
                            Intent i = new Intent(MapActivity.this, InfoActivity.class);
                            i.putExtra("FROM_ACTIVITY","Markt");
                            startActivity(i);
                            return true;
                        }

                        else if ((marker.getTitle())=="Antonstrasse"){
                            Intent i = new Intent(MapActivity.this, InfoActivity.class);
                            i.putExtra("FROM_ACTIVITY","Antonstrasse");
                            startActivity(i);
                            return true;
                        }

                        else if ((marker.getTitle())=="Lotharstrasse"){
                            Intent i = new Intent(MapActivity.this, InfoActivity.class);
                            i.putExtra("FROM_ACTIVITY","Lotharstrasse");
                            startActivity(i);
                            return true;
                        }

                        else if ((marker.getTitle())=="Barbarastrasse"){
                            Intent i = new Intent(MapActivity.this, InfoActivity.class);
                            i.putExtra("FROM_ACTIVITY","Barbarastrasse");
                            startActivity(i);
                            return true;
                        }

                        else if ((marker.getTitle())=="Vinnstrasse"){
                            Intent i = new Intent(MapActivity.this, InfoActivity.class);
                            i.putExtra("FROM_ACTIVITY","Vinnstrasse");
                            startActivity(i);
                            return true;
                        }

                        else if ((marker.getTitle())=="Maxstrasse"){
                            Intent i = new Intent(MapActivity.this, InfoActivity.class);
                            i.putExtra("FROM_ACTIVITY","Maxstrasse");
                            startActivity(i);
                            return true;
                        }

                        else{
                            return true;
                        }
                    }
                });

                try {
                    getRoute(origin, johannstrasse);
                    getRoute(johannstrasse, alfredstrasse);
                    getRoute(alfredstrasse, georgstrasse);
                    getRoute(georgstrasse, zwischen1);
                    getRoute(zwischen1, markt);
                    getRoute(markt, antonstrasse);
                    getRoute(antonstrasse, lotharstrasse);
                    getRoute(lotharstrasse, barbarastrasse);
                    getRoute(barbarastrasse, vinnstraße);
                    getRoute(vinnstraße, zwischen2);
                    getRoute(zwischen2, destination);
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
                Intent i = new Intent(MapActivity.this, InstructActivity.class);
                startActivity(i);
                return true;
            case R.id.item2:
                return true;
            case R.id.item3:
                return true;
            case R.id.item2_1:
                Intent i1 = new Intent(MapActivity.this, InfoActivity.class);
                i1.putExtra("FROM_ACTIVITY","Altes Rathaus");
                startActivity(i1);
                return true;
            case R.id.item2_2:
                Intent i2 = new Intent(MapActivity.this, InfoActivity.class);
                i2.putExtra("FROM_ACTIVITY","Johannstrasse");
                startActivity(i2);
                return true;
            case R.id.item2_3:
                Intent i3 = new Intent(MapActivity.this, InfoActivity.class);
                i3.putExtra("FROM_ACTIVITY","Alfredstrasse");
                startActivity(i3);
                return true;
            case R.id.item2_4:
                Intent i4 = new Intent(MapActivity.this, InfoActivity.class);
                i4.putExtra("FROM_ACTIVITY","Georgstrasse");
                startActivity(i4);
                return true;
            case R.id.item2_5:
                Intent i5 = new Intent(MapActivity.this, InfoActivity.class);
                i5.putExtra("FROM_ACTIVITY","Markt");
                startActivity(i5);
                return true;
            case R.id.item2_6:
                Intent i6 = new Intent(MapActivity.this, InfoActivity.class);
                i6.putExtra("FROM_ACTIVITY","Antonstrasse");
                startActivity(i6);
                return true;
            case R.id.item2_7:
                Intent i7 = new Intent(MapActivity.this, InfoActivity.class);
                i7.putExtra("FROM_ACTIVITY","Lotharstrasse");
                startActivity(i7);
                return true;
            case R.id.item2_8:
                Intent i8 = new Intent(MapActivity.this, InfoActivity.class);
                i8.putExtra("FROM_ACTIVITY","Barbarastrasse");
                startActivity(i8);
                return true;
            case R.id.item2_9:
                Intent i9 = new Intent(MapActivity.this, InfoActivity.class);
                i9.putExtra("FROM_ACTIVITY","Vinnstrasse");
                startActivity(i9);
                return true;
            case R.id.item2_10:
                Intent i10 = new Intent(MapActivity.this, InfoActivity.class);
                i10.putExtra("FROM_ACTIVITY","Maxstrasse");
                startActivity(i10);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
