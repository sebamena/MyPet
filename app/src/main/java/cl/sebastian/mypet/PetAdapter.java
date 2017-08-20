package cl.sebastian.mypet;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cl.sebastian.mypet.models.Pet;

/**
 * Created by Sebastián Mena on 19/08/2017.
 */

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.ViewHolder> {

    private List<Pet> pets = new Queries().listall();

    private AddPetinterface listener;

    public PetAdapter(AddPetinterface listener) {
        this.listener = listener;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pets, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        Pet listpets = pets.get(position);
        holder.txtname.setText(listpets.getName());
        holder.txttype.setText(listpets.getType());
        holder.txtbreed.setText(listpets.getBreed());
        holder.txtage.setText(String.valueOf(listpets.getAge()));
        holder.txtgenre.setText(listpets.getGenre());

        holder.txtname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Pet auxPending = pets.get(holder.getAdapterPosition());
                listener.clickedID(auxPending.getId());

            }
        });

    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public void update(Pet pet) {
        pets.add(pet);
        notifyDataSetChanged();
    }

    public void updateAll(){

        List<Pet> listpets = new Queries().listall();
        pets.clear();
        pets.addAll(listpets);
        notifyDataSetChanged();


    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtname,txttype,txtbreed,txtage,txtgenre;


        public ViewHolder(View itemView) {
            super(itemView);


            txtname = (TextView) itemView.findViewById(R.id.nameTv);
            txttype = (TextView) itemView.findViewById(R.id.typeTv);
            txtbreed = (TextView) itemView.findViewById(R.id.breedTv);
            txtage = (TextView) itemView.findViewById(R.id.agegTv);
            txtgenre = (TextView) itemView.findViewById(R.id.genreTv);


        }
    }

}
