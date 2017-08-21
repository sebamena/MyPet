package cl.sebastian.mypet.views.details;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import cl.sebastian.mypet.R;
import cl.sebastian.mypet.data.Queries;
import cl.sebastian.mypet.models.Pet;

public class DetailsActivity extends AppCompatActivity {

    public static final String PET_ID = "cl.sebastian.stressless.views.main.KEY.PET_ID";

    private long pet_id;
    private Pet pet;
    TextView nameownerTv, phoneownerTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pet_id = getIntent().getLongExtra(PET_ID, 0);

        pet = new Queries().byId(pet_id);

        getSupportActionBar().setTitle(pet.getName());

        nameownerTv = (TextView) findViewById(R.id.nameownerTv);
        phoneownerTv = (TextView) findViewById(R.id.phoneownerTv);


        phoneownerTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + phoneownerTv.getText().toString()));
                if (ActivityCompat.checkSelfPermission(DetailsActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        String nameowner = pet.getNameowner();
        Integer phoneowner = pet.getPhoneowner();

        if(nameowner!=null){

            nameownerTv.setText(nameowner);

        }

        if(phoneowner!=null){

            phoneownerTv.setText("+569" + String.valueOf(phoneowner));

        }
    }


}
