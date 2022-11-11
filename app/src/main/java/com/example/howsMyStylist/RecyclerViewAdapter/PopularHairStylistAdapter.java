package com.example.howsMyStylist.RecyclerViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.howsMyStylist.HairStylistProfile;
import com.example.howsMyStylist.HomePage;
import com.example.howsMyStylist.R;

import java.util.ArrayList;

public class PopularHairStylistAdapter extends RecyclerView.Adapter<PopularHairStylistAdapter.MyViewHolder> {




    Context context;
    ArrayList<HairStylistModel> hairStylistModels;
    private HairInterface hairInterface;

    public PopularHairStylistAdapter(Context context, ArrayList<HairStylistModel> hairStylistModels,
                                     HairInterface hairInterface
    ) {
        this.context = context;
      this.hairStylistModels = hairStylistModels;
      this.hairInterface = hairInterface;
    }

    @NonNull
    @Override
    public PopularHairStylistAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)

    {

        LayoutInflater inflator =LayoutInflater.from(context);
        View view = inflator.inflate(R.layout.hair_stylist_card_recycler_view, parent ,
                false);
        return new PopularHairStylistAdapter.MyViewHolder(view , hairInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularHairStylistAdapter.MyViewHolder holder, int position) {
        holder.hairStylistName.setText(hairStylistModels.get(position).getHairStylistName());
        holder.ratings.setText(hairStylistModels.get(position).getHairStylistRatings());
        holder.imageView.setImageResource(hairStylistModels.get(position).getImage());

//        holder.  itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Toast.makeText(context, " vbfgb  " + position ,  Toast.LENGTH_LONG).show();
//
//                Intent intent = new Intent(context, HairStylistProfile.class);
//                intent.putExtra("NAME", hairStylistModels.get(position).getHairStylistName());
//                intent.putExtra("RATING", hairStylistModels.get(position).getHairStylistRatings());
//                intent.putExtra("IMAGE", hairStylistModels.get(position).getImage());
//                context.startActivity(intent);
//
//
//
//                }
//
//        });



    }

    @Override
    public int getItemCount() {
        return hairStylistModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView hairStylistName, ratings;
        HairInterface hairInterface;
        public MyViewHolder(@NonNull View itemView, HairInterface hairInterface ) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            hairStylistName = itemView.findViewById(R.id.hairStylistName);
            ratings = itemView.findViewById(R.id.ratingBar1);
            this.hairInterface = hairInterface;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
           hairInterface.onClickHair(getAdapterPosition());
        }
    }

    public interface HairInterface{

        void onClickHair(int position1);
    }
}
