package cl.sebastian.mypet;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Register.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Register#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Register extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private EditText txtname, txtedad, txttipo, txtpeso;
    private RadioButton macho,hembra;
    private Button guardar;

    public Register() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Register.
     */
    // TODO: Rename and change types and number of parameters
    public static Register newInstance(String param1, String param2) {
        Register fragment = new Register();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
