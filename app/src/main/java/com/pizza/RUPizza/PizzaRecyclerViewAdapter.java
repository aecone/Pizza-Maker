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

/**
 * This class represents the adapter for the pizza recycler view
 * @author Eric Cheung, Andrea Kim
 */
public class PizzaRecyclerViewAdapter extends RecyclerView.Adapter<PizzaRecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<PizzaModel> pizzaModels;
    private final RecyclerViewInterface recyclerViewInterface;
    public PizzaRecyclerViewAdapter(Context context, ArrayList<PizzaModel> pizzaModels, RecyclerViewInterface recyclerViewInterface){
        this.context=context;
        this.pizzaModels = pizzaModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    /**
     * This method creates the view holder for items in the recycler view
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return the view holder
     */
    @NonNull
    @Override
    public PizzaRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new PizzaRecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    /**
     * This method binds the items together in the recycler view
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull PizzaRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(pizzaModels.get(position).getPizzaType());
        holder.tvToppings.setText(pizzaModels.get(position).getToppings());
        holder.tvSauce.setText(pizzaModels.get(position).getSauce());
        holder.imageView.setImageResource(pizzaModels.get(position).getImage());
        holder.basePrice.setText(pizzaModels.get(position).getPrice());
    }

    /**
     * This method gets the number of items in the recycler view
     * @return the number of items in the recycler view
     */
    @Override
    public int getItemCount() {
        return pizzaModels.size();
    }

    /**
     * The MyViewHolder class to get the views from the xml file
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvName, tvToppings, tvSauce, basePrice;

        /**
         * MyViewHolder constructor
         * @param itemView view to get items from
         * @param recyclerViewInterface recyclerViewInterface to handle on click functionality
         */
        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageView = itemView.findViewById(R.id.pizzaImage);
            tvName = itemView.findViewById(R.id.pizzaType);
            tvToppings = itemView.findViewById(R.id.toppings);
            tvSauce = itemView.findViewById(R.id.sauce);
            basePrice = itemView.findViewById(R.id.basePrice);

            /**
             * OnClick listener for recycler view
             */
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null){
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });



        }
    }
}
