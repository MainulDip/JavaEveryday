package com.websolverpro.androidrecyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.zip.Inflater;

import androidrecyclerview.R;

public class ContactsRecyclerViewAdapter extends RecyclerView.Adapter<ContactsRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Contact> contacts = new ArrayList<>();

    private Context context;

    public ContactsRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    /**
     * Inner class is used here for extending the parent class
     * also accessing the private TextView txtName from the parent class's onBindViewHolder method to inject data
     */

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName;
        private CardView parentOfTxtName;
        private TextView txtEmail;
        private ImageView elementImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            set the view holder from layout xml and access it from other methods
            txtName = itemView.findViewById(R.id.txtName);
            parentOfTxtName = itemView.findViewById(R.id.parentOfElements);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            elementImg = itemView.findViewById(R.id.elementImg);
        }
    }

    /**
     * create the view holder from instantiating the inner class ViewHolder
     * to create the view we need LayoutInflater from inflate method
     * RecyclerView, LinearLayout, RelativeLayout, etc (Views that can contain other views) are all extending from ViewGroup so LayoutInflater.from can get the ViewGroup parent as parent.getContext()
     * inflate method is self explanatory. it receives the specific layout id, parent container of that layout and attachRoot boolean as
     * finally return the new instance of the innerclass containing the view.
     */

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contacts_list_item, parent.findViewById(R.id.parentOfElements), false);

        return new ViewHolder(view);
    }

    /**
     * This is the most functionally important class for our own ViewHolder Adapter as we bind that here
     *  Dock logics/eventListeners here
     */

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(contacts.get(position).getName());
        holder.txtEmail.setText(contacts.get(position).getEmail());
//        holder.elementImg.setImageURI(contacts.get(position).getImgUrl());

        Glide.with(context)
                .asBitmap()
                .load(contacts.get(position).getImgUrl())
                .into(holder.elementImg);

        if(position == contacts.size() - 1) {
            Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();
        }

//        set event listener
        holder.parentOfTxtName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("hello");
                Toast.makeText(context, "Hello" + holder.txtName.getText(), Toast.LENGTH_SHORT).show();
            }
        });
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
