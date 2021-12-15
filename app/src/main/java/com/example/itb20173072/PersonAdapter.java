package com.example.itb20173072;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itb20173072.R;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>{
    ArrayList<com.example.itb20173072.Person> items = new ArrayList<com.example.itb20173072.Person>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.person_item, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewholder, int position) {
        com.example.itb20173072.Person item = items.get(position);
        viewholder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView){
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
        }

        public void setItem(com.example.itb20173072.Person item){
            textView.setText(item.getName());
            textView2.setText(item.getMobile());
        }
    }
    public void addItem(com.example.itb20173072.Person item)
    {
        items.add(item);
    }
    public void setItems(ArrayList<com.example.itb20173072.Person> items)
    {
        this.items = items;
    }
    public com.example.itb20173072.Person getItem(int position)
    {
        return items.get(position);
    }
    public void setItem(int position, com.example.itb20173072.Person item)
    {
        items.set(position,item);
    }
}
