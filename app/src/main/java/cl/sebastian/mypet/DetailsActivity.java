package cl.sebastian.mypet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import cl.sebastian.mypet.models.Pet;

public class DetailsActivity extends AppCompatActivity {

    public static final String PET_ID  = "cl.sebastian.stressless.views.main.KEY.PET_ID";

    private long pet_id;
    private Pet pet;
    TextView nameownerTv,phoneownerTv;

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

            phoneownerTv.setText(String.valueOf(phoneowner));

        }
    }


}
