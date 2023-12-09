package com.pizza.RUPizza;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PizzaRecyclerViewAdapter extends RecyclerView.Adapter<PizzaRecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<PizzaModel> pizzaModels;
    public PizzaRecyclerViewAdapter(Context context, ArrayList<PizzaModel> pizzaModels){
        this.context=context;
        this.pizzaModels = pizzaModels;
    }
    @NonNull
    @Override
    public PizzaRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new PizzaRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(pizzaModels.get(position).getPizzaType());
        holder.tvToppings.setText(pizzaModels.get(position).getToppings());
        holder.tvSauce.setText(pizzaModels.get(position).getSauce());
        holder.imageView.setImageResource(pizzaModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return pizzaModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvName, tvToppings, tvSauce;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.pizzaImage);
            tvName = itemView.findViewById(R.id.pizzaType);
            tvToppings = itemView.findViewById(R.id.toppings);
            tvSauce = itemView.findViewById(R.id.sauce);

        }
    }
}
