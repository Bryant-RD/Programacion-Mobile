package com.example.primerparcial.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primerparcial.Entitys.Producto;
import com.example.primerparcial.R;

import org.jetbrains.annotations.NotNull;

public class RefroitAdapter extends ListAdapter<Producto, RefroitAdapter.WordViewHolder> {

    public RefroitAdapter(@NonNull DiffUtil.ItemCallback<Producto> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @NotNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return WordViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull WordViewHolder holder, int position) {
        Producto current = getItem(position);
        holder.bind(current);
    }


    public static class Diff extends DiffUtil.ItemCallback<Producto> {

        @Override
        public boolean areItemsTheSame(@NonNull Producto oldItem, @NonNull Producto newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Producto oldItem, @NonNull Producto newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }
    }

    static class WordViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView lastName;


        private WordViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            lastName  = itemView.findViewById(R.id.lastName);

        }

        public void bind(Producto producto) {

            name.setText(producto.getTitle());
            lastName.setText(producto.getDescription());
        }

        static WordViewHolder create(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_product, parent, false);
            return new WordViewHolder(view);
        }

    }
}
