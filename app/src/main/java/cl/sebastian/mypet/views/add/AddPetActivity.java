package cl.sebastian.mypet.views.add;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import cl.sebastian.mypet.R;
import cl.sebastian.mypet.adapters.PetAdapter;
import cl.sebastian.mypet.models.Pet;

public class AddPetActivity extends AppCompatActivity implements AddPetinterface {


    private EditText name,type,breed,genre,nameowner,age,phoneowner;
    private Button enviar;
    private Spinner spinner;

    private PetAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adapter = new PetAdapter(this);

        name = (EditText) findViewById(R.id.nameownerTv);
        type = (EditText) findViewById(R.id.phoneownerTv);
        breed = (EditText) findViewById(R.id.breedEt);
        //genre = (EditText) findViewById(R.id.genreEt);
        spinner = (Spinner)findViewById(R.id.genre_spinner);

        ArrayAdapter<CharSequence> adapter_spinner = ArrayAdapter.createFromResource(this,
                R.array.genre_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter_spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter_spinner);


        nameowner = (EditText) findViewById(R.id.nameownerEt);
        age = (EditText) findViewById(R.id.ageEt);
        phoneowner = (EditText) findViewById(R.id.phoneownerEt);
        enviar = (Button) findViewById(R.id.enviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(name.getText().toString().isEmpty()){

                    Toast.makeText(AddPetActivity.this,"Escriba el nombre de la mascota",Toast.LENGTH_SHORT).show();


                }else if (type.getText().toString().isEmpty()){

                    Toast.makeText(AddPetActivity.this,"Escriba el tipo de mascota",Toast.LENGTH_SHORT).show();


                }else if (breed.getText().toString().isEmpty()){

                    Toast.makeText(AddPetActivity.this,"Indique la raza de la mascota",Toast.LENGTH_SHORT).show();

                }
                else if (spinner.getSelectedItem().toString().isEmpty()){

                    Toast.makeText(AddPetActivity.this,"Indique el género de su mascota",Toast.LENGTH_SHORT).show();

                }
                else if (age.getText().toString().isEmpty()){

                    Toast.makeText(AddPetActivity.this,"Indique la edad en meses de su mascota",Toast.LENGTH_SHORT).show();

                }
                else if (nameowner.getText().toString().isEmpty()){

                    Toast.makeText(AddPetActivity.this,"Escriba el nombre del dueño de la mascota",Toast.LENGTH_SHORT).show();

                }
                else if (phoneowner.getText().toString().isEmpty()){

                    Toast.makeText(AddPetActivity.this,"Indique el número telefónico del dueño de la mascota",Toast.LENGTH_SHORT).show();

                }

                else{


                    Pet pet = new Pet();
                    pet.setName(name.getText().toString());
                    pet.setType(type.getText().toString());
                    pet.setBreed(breed.getText().toString());
                    pet.setGenre(spinner.getSelectedItem().toString());
                    pet.setAge(Long.parseLong(age.getText().toString()));
                    pet.setNameowner(nameowner.getText().toString());
                    pet.setPhoneowner(Integer.parseInt(phoneowner.getText().toString()));
                    pet.save();
                    adapter.updateAll();


                    name.setText("");
                    type.setText("");
                    breed.setText("");
                    age.setText("");
                    nameowner.setText("");
                    phoneowner.setText("");


                    Toast.makeText(getBaseContext(),"Registro Exitoso",Toast.LENGTH_SHORT).show();

                    finish();


                }



            }});


    }


    @Override
    public void clickedID(long id) {

    }
}
