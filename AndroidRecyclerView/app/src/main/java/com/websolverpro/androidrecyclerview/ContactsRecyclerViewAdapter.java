package com.websolverpro.androidrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import androidrecyclerview.R;

public class ContactsRecyclerViewAdapter extends RecyclerView.Adapter<ContactsRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Contact> contacts = new ArrayList<>();

    public ContactsRecyclerViewAdapter() {
    }

    /**
     * Inner class is used here for extending the parent class
     * also accessing the private TextView txtName from the parent class's onBindViewHolder method to inject data
     */

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
        }
    }

    /**
     * create the view holder from instantiating the inner class ViewHolder
     * to create the view we need LayoutInflater from inflate method
     * RecyclerView and RelativeLayout are all extending from ViewGroup so LayoutInflater.from can get the ViewGroup parent as parent.getContext()
     * inflate method is self explanatory. finally return the new instance of the innerclass containing the view.
     */

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contacts_list_item, parent, false);

        return new ViewHolder(view);
    }

    /**
     * This is the most functionally important class for our own ViewHolder Adapter as we bind that here
     *
     */

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(contacts.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
//        to refresh data inside recyclerview
        notifyDataSetChanged();
    }

}
