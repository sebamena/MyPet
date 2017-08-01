package cl.sebastian.mypet;

import android.content.Context;
import android.content.Intent;
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

import static cl.sebastian.mypet.R.id.enviar;
import static cl.sebastian.mypet.R.id.guardar;
import static cl.sebastian.mypet.R.id.hembra;
import static cl.sebastian.mypet.R.id.macho;
import static cl.sebastian.mypet.R.id.txtedad;
import static cl.sebastian.mypet.R.id.txtname;
import static cl.sebastian.mypet.R.id.txtpeso;
import static cl.sebastian.mypet.R.id.txttipo;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Complaint.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Complaint#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Complaint extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText nombre, denuncia, email, numerotel;
    private Button enviar;
    private OnFragmentInteractionListener mListener;

    public Complaint() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Complaint.
     */
    // TODO: Rename and change types and number of parameters
    public static Complaint newInstance(String param1, String param2) {
        Complaint fragment = new Complaint();
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
