package cl.sebastian.mypet;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class Complaint extends Fragment {



    private EditText nombre, denuncia, email, numerotel;
    private Button enviar;


    public Complaint() {
        // Required empty public constructor
    }

    public static Complaint newInstance(){

        return new Complaint();

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_complaint, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // save views as variables in this method
        // "view" is the one returned from onCreateView
        nombre = (EditText) view.findViewById(R.id.nombre);
        denuncia = (EditText) view.findViewById(R.id.denuncia);
        email = (EditText) view.findViewById(R.id.email);
        numerotel = (EditText) view.findViewById(R.id.cel);
        enviar = (Button) view.findViewById(R.id.enviar);


        enviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(nombre.getText().toString().isEmpty()){

                    Toast.makeText(getContext(),"Escriba un nombre",Toast.LENGTH_SHORT).show();


                }else if (denuncia.getText().toString().isEmpty()){

                    Toast.makeText(getContext(),"Escriba su denuncia",Toast.LENGTH_SHORT).show();


                }else if (email.getText().toString().isEmpty()){

                    Toast.makeText(getContext(),"Indique su email",Toast.LENGTH_SHORT).show();

                }else if (numerotel.getText().toString().isEmpty()){

                    Toast.makeText(getContext(),"Indique su número telefónico",Toast.LENGTH_SHORT).show();

                }

                else{
                    //Toast.makeText(getContext(),"Denuncia Enviada",Toast.LENGTH_SHORT).show();



                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setType("*/*");
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]
                            {"smenap@gmail.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Denuncia desde APP MyPet");
                    intent.putExtra(Intent.EXTRA_TEXT, denuncia.getText().toString());
                    startActivity(intent);


                    nombre.setText("");
                    denuncia.setText("");
                    email.setText("");
                    numerotel.setText("");

                }



            }});

    }

}
