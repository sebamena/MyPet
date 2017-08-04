package cl.sebastian.mypet;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SuggestActivity extends AppCompatActivity {


    private EditText nombre, mensaje, email, numerotel;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nombre = (EditText) findViewById(R.id.nombre);
        mensaje = (EditText) findViewById(R.id.mensaje);
        email = (EditText) findViewById(R.id.email);
        numerotel = (EditText) findViewById(R.id.cel);
        enviar = (Button) findViewById(R.id.enviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(nombre.getText().toString().isEmpty()){

                    Toast.makeText(SuggestActivity.this,"Escriba un nombre",Toast.LENGTH_SHORT).show();


                }else if (mensaje.getText().toString().isEmpty()){

                    Toast.makeText(SuggestActivity.this,"Escriba un mensaje",Toast.LENGTH_SHORT).show();


                }else if (!isValidEmail(email.getText().toString())){

                    Toast.makeText(SuggestActivity.this,"Escriba un email válido",Toast.LENGTH_SHORT).show();

                }else if (numerotel.getText().toString().isEmpty()){

                    Toast.makeText(SuggestActivity.this,"Indique su número telefónico",Toast.LENGTH_SHORT).show();

                }

                else{
                    //Toast.makeText(getContext(),"Denuncia Enviada",Toast.LENGTH_SHORT).show();



                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setType("*/*");
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]
                            {"smenap@gmail.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Mensaje desde APP MyPet");
                    intent.putExtra(Intent.EXTRA_TEXT,"Nombre: "+ nombre.getText().toString() + "\n\n" + "Denuncia: "+mensaje.getText().toString() +"\n\n" + "Número Telefónico: " + numerotel.getText().toString());

                    startActivity(intent);


                    nombre.setText("");
                    mensaje.setText("");
                    email.setText("");
                    numerotel.setText("");

                }



            }});


    }

    private boolean isValidEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

}
