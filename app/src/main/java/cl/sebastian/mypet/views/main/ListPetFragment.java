package cl.sebastian.mypet.views.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.sebastian.mypet.R;
import cl.sebastian.mypet.adapters.PetAdapter;
import cl.sebastian.mypet.views.add.AddPetinterface;
import cl.sebastian.mypet.views.details.DetailsActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListPetFragment extends Fragment implements AddPetinterface {

    private PetAdapter adapter;

    public static final String PET_ID  = "cl.sebastian.stressless.views.main.KEY.PET_ID";

    public ListPetFragment() {
        // Required empty public constructor
    }

    public static ListPetFragment newInstance(){

        return new ListPetFragment();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_pet, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.petRecyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PetAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void clickedID(long id) {

        Intent myIntent = new Intent(getActivity(), DetailsActivity.class);
        myIntent.putExtra(PET_ID, id);
        startActivity(myIntent);

    }

    @Override
    public void onResume()
    {
        super.onResume();
        adapter.updateAll();
    }


}
