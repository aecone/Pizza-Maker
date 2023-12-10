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
    private Context context;
    private ArrayList<PizzaModel> pizzaModels;
    private int selectedItem = RecyclerView.NO_POSITION;

    public PizzaRecyclerViewAdapter(Context context, ArrayList<PizzaModel> pizzaModels) {
        this.context = context;
        this.pizzaModels = pizzaModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PizzaModel pizza = pizzaModels.get(position);

        holder.tvName.setText(pizza.getPizzaType());
        holder.tvToppings.setText(pizza.getToppings());
        holder.tvSauce.setText(pizza.getSauce());
        holder.imageView.setImageResource(pizza.getImage());

        // Set the background color based on the selected state
        holder.itemView.setSelected(selectedItem == position);
    }

    @Override
    public int getItemCount() {
        return pizzaModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView tvName, tvToppings, tvSauce;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.pizzaImage);
            tvName = itemView.findViewById(R.id.pizzaType);
            tvToppings = itemView.findViewById(R.id.toppings);
            tvSauce = itemView.findViewById(R.id.sauce);

            // Set click listener for the item view
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Get the clicked item position
            int position = getAdapterPosition();

            // Update the selected item position
            selectedItem = position;

            // Notify the adapter that the data set has changed
            notifyDataSetChanged();

            // Perform any additional actions on item click if needed
            // For example, you can open a new activity or show details.

        }
    }
}

