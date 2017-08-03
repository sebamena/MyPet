package cl.sebastian.mypet;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class Register extends Fragment {


    private EditText txtname, txtedad, txttipo, txtpeso;
    private RadioButton macho,hembra;
    private Button guardar;

    public Register() {
        // Required empty public constructor
    }

    public static Register newInstance(){

        return new Register();

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // save views as variables in this method
        // "view" is the one returned from onCreateView
        txtname = (EditText) view.findViewById(R.id.name);
        txtedad = (EditText) view.findViewById(R.id.edad);
        txttipo = (EditText) view.findViewById(R.id.tipo);
        txtpeso = (EditText) view.findViewById(R.id.peso);
        macho = (RadioButton) view.findViewById(R.id.macho);
        hembra = (RadioButton) view.findViewById(R.id.hembra);
        guardar = (Button) view.findViewById(R.id.guardar);


        guardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(txtname.getText().toString().isEmpty()){

                    Toast.makeText(getContext(),"Escriba un nombre",Toast.LENGTH_SHORT).show();


                }else if (txtedad.getText().toString().isEmpty()){

                    Toast.makeText(getContext(),"Indique una edad",Toast.LENGTH_SHORT).show();


                }else if (txttipo.getText().toString().isEmpty()){

                    Toast.makeText(getContext(),"Indique tipo de mascota",Toast.LENGTH_SHORT).show();

                }else if (txtpeso.getText().toString().isEmpty()){

                    Toast.makeText(getContext(),"Indique peso",Toast.LENGTH_SHORT).show();

                }else if (!macho.isChecked() && !hembra.isChecked()){

                    Toast.makeText(getContext(),"Seleccione el sexo",Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(getContext(),"Registro Completado",Toast.LENGTH_SHORT).show();
                    txtname.setText("");
                    txtedad.setText("");
                    txttipo.setText("");
                    txtpeso.setText("");
                    macho.setChecked(false);
                    hembra.setChecked(false);
                }



            }});

    }


}
