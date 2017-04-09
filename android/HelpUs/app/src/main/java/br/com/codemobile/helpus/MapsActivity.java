package br.com.codemobile.helpus;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import br.com.codemobile.helpus.activity.NewPinActivity;
import br.com.codemobile.helpus.activity.SettingsActivity;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener {

    private GoogleMap mMap;
    private LatLng mMyLatLng;
    private Location mMyLocation;
    private DrawerLayout mDrawerLayout;
    private View mButtonMenu;
    private int countTeste = 0;

    private View mMenuItemSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mButtonMenu = findViewById(R.id.view_button_menu);
        mMenuItemSettings = findViewById(R.id.menu_view_settings);


        mButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDrawerLayout.isDrawerOpen(GravityCompat.END)) {
                    mDrawerLayout.closeDrawer(GravityCompat.END);
                } else {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
        mMenuItemSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MapsActivity.this, SettingsActivity.class));
            }
        });


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);


//            LatLng cord = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
//            mMap.addMarker(new MarkerOptions().position(cord).title("It's Me!"));
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(cord));

            LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
            boolean enabled = service
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);

            if (!enabled) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }

            mMyLocation = service.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            mMyLatLng = new LatLng(mMyLocation.getLatitude(), mMyLocation.getLongitude());

//            Bitmap bit = BitmapFactory.decodeResource(getResources(), R.drawable.felipus);

            MarkerOptions opt = new MarkerOptions();
//            opt.position(mMyLatLng).title("Yeahhh Code mobile, I'm FelipUs");
//            opt.icon(BitmapDescriptorFactory.fromBitmap(Bitmap.createBitmap(bit)));

//            mMap.addMarker(opt).showInfoWindow();
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mMyLatLng, 17));
            mMap.setOnMapLongClickListener(this);

        } else {

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {

        super.onStop();
    }

    protected void onResume() {
        super.onResume();
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
    }

    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
    }


//    public double CalculationByDistance(LatLng StartP, LatLng EndP) {
//        int Radius = 6371;//radius of earth in Km
//        double lat1 = StartP.latitude;
//        double lat2 = EndP.latitude;
//        double lon1 = StartP.longitude;
//        double lon2 = EndP.longitude;
//        double dLat = Math.toRadians(lat2 - lat1);
//        double dLon = Math.toRadians(lon2 - lon1);
//        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
//                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
//                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
//        double c = 2 * Math.asin(Math.sqrt(a));
//        double valueResult = Radius * c;
//        double km = valueResult / 1;
//        DecimalFormat newFormat = new DecimalFormat("####");
//        int kmInDec = Integer.valueOf(newFormat.format(km));
//        double meter = valueResult % 1000;
//        int meterInDec = Integer.valueOf(newFormat.format(meter));
//        Log.i("Radius Value", "" + valueResult + "   KM  " + kmInDec + " Meter   " + meterInDec);
//
//        Toast.makeText(this, "" + valueResult + "   KM  " + kmInDec + " Meter   " + meterInDec, Toast.LENGTH_SHORT).show();
//
//        return Radius * c;
//    }

    public String getDistance(LatLng my_latlong, LatLng frnd_latlong) {
        Location l1 = new Location("One");
        l1.setLatitude(my_latlong.latitude);
        l1.setLongitude(my_latlong.longitude);

        Location l2 = new Location("Two");
        l2.setLatitude(frnd_latlong.latitude);
        l2.setLongitude(frnd_latlong.longitude);

        float distance = l1.distanceTo(l2);
        String dist = distance + " M";

        if (distance > 1000.0f) {
            distance = distance / 1000.0f;
            dist = distance + " KM";
        }
        Toast.makeText(this, "" + dist, Toast.LENGTH_SHORT).show();
        return dist;
    }


    @Override
    public void onMapLongClick(LatLng latLng) {
//        Bitmap bit = BitmapFactory.decodeResource(getResources(), R.drawable.ic_drop);

//        CalculationByDistance(mMyLatLng,latLng);
        getDistance(mMyLatLng, latLng);

        Bitmap bitmap = null;
        if (countTeste == 0) {
            bitmap = getBitmap(this, R.drawable.ic_pin_success);
            countTeste++;
        } else if (countTeste == 1) {
            bitmap = getBitmap(this, R.drawable.ic_pin_warning);
            countTeste++;
        } else if (countTeste == 2) {
            bitmap = getBitmap(this, R.drawable.ic_pin_alert);
            countTeste++;
        } else if (countTeste == 3) {
            bitmap = getBitmap(this, R.drawable.ic_pin_normal);
            countTeste++;
        }
        if (countTeste == 4) {
            countTeste = 0;
        }


        String claim = "{" +
                "\"claim\": {" +
                "\"claimTypeId\": 1," +
                "\"registerDate\": \"2017-04-10T00:00:00-03:00\"," +
                "\"status\": \"android\"," +
                "\"subjectId\": 1," +
                "\"latitude\": \"" + String.valueOf(latLng.latitude) + "\"," +
                "\"longitude\": \"" + String.valueOf(latLng.longitude) + "\"" +
                "}" +
                "}";

        final RequestQueue queue = Volley.newRequestQueue(this);


        JsonObjectRequest jsonObjReq = null;
        try {
            jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    "http://env-7102451.jelasticlw.com.br/RestEasyMaven/rest/claim/post", new JSONObject(claim),
                    new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("NEWUSER", response.toString());
//                            try {
//                                Log.d("NEWUSER", response.toString());
////                                pb.setVisibility(View.INVISIBLE);
////                                Beneficiary beneficiary = new Gson().fromJson(response.getJSONObject("beneficiary").toString(), Beneficiary.class);
////                                SharedBeneficiaryLogin.getInstance(root.getContext()).save(beneficiary);
////
////                                root.getContext().startActivity(new Intent(root.getContext(), MainActivity.class));
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("NEWUSER", "REQUEST ERROR");
                }
            }) {

                /**
                 * Passing some request headers
                 * */
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("Content-Type", "application/json; charset=utf-8");
                    return headers;
                }
            };
            queue.add(jsonObjReq);
        } catch (JSONException e) {
            e.printStackTrace();
        }







        // Instantiate the RequestQueue.
//        final RequestQueue queue = Volley.newRequestQueue(this);
//        String url = "http://env-7102451.jelasticlw.com.br/RestEasyMaven/rest/claim/";
//
//// Request a string response from the provided URL.
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        // Display the first 500 characters of the response string.
//                        Toast.makeText(MapsActivity.this, "Response is: " + response.substring(0, 500), Toast.LENGTH_SHORT).show();
//
//                    }
//                }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(MapsActivity.this, "Error ", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        queue.add(stringRequest);


// Add the request to the RequestQueue.


//        MarkerOptions opt = new MarkerOptions();
//        opt.position(latLng).title("Yeahhh Code mobile, I'm BunUs");
//        opt.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
//        mMap.addMarker(opt).showInfoWindow();

                startActivity(new Intent(MapsActivity.this, NewPinActivity.class));
    }

    private Bitmap getBitmap(VectorDrawable vectorDrawable) {
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        vectorDrawable.draw(canvas);
        Log.e("IMAGE", "getBitmap: 1");
        return bitmap;
    }

    private Bitmap getBitmap(Context context, int drawableId) {
        Log.e("IMAGE", "getBitmap: 2");
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (drawable instanceof BitmapDrawable) {
            return BitmapFactory.decodeResource(context.getResources(), drawableId);
        } else if (drawable instanceof VectorDrawable) {
            return getBitmap((VectorDrawable) drawable);
        } else {
            throw new IllegalArgumentException("unsupported drawable type");
        }
    }


}
