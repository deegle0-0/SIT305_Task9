package com.example.task9.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task9.Activities.ItemDetailsActivity;
import com.example.task9.R;
import com.example.task9.database.Advert;

public class AdvertListAdapter extends ListAdapter<Advert, AdvertListAdapter.MyViewHolder> {


    Context context;

    AdvertViewModel advertViewModel;

    public AdvertListAdapter(@NonNull DiffUtil.ItemCallback<Advert> diffCallback,
                             Context context, AdvertViewModel advertViewModel) {
        super(diffCallback);
        this.context = context;
        this.advertViewModel= advertViewModel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Advert current = getItem(position);
        holder.name.setText(current.getName());
        holder.description.setText(current.getDescription());
        holder.location = current.getLocation();
        holder.phoneNo = current.getPhoneNo();

    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name, description;

        String location,phoneNo;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textViewName);
            description = itemView.findViewById(R.id.textViewDescription);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION)
                    {
                        Intent intent = new Intent(v.getContext(), ItemDetailsActivity.class);

                        intent.putExtra("name",name.getText().toString());
                        intent.putExtra("desc",description.getText().toString());
                        intent.putExtra("location",location);
                        intent.putExtra("phoneNo",phoneNo);

                        v.getContext().startActivity(intent);
                    }
                }
            });

        }
    }
    public static class AdvertDiff extends DiffUtil.ItemCallback<Advert>{

        @Override
        public boolean areItemsTheSame(@NonNull Advert oldItem, @NonNull Advert newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Advert oldItem, @NonNull Advert newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }
}
