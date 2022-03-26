package com.websolverpro.bookmanagerandroid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class BooksRecyclerViewAdapter extends RecyclerView.Adapter<BooksRecyclerViewAdapter.ViewHolder> {

//    Generate log property bt typing "logt"
    private static final String TAG = "BooksRecyclerViewAdapte";

    private ArrayList<Book> books = new ArrayList<>();

    private Context context;

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public BooksRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Log.d(TAG, "onBindViewHolder: Called");
        holder.bookName.setText(books.get(position).getName());
        holder.authorName.setText(books.get(position).getAuthor());
        holder.shortDescription.setText(books.get(position).getShortDesc());

        Glide.with(context)
                .load(books.get(position).getImageUrl())
                .into(holder.bookImg);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, books.get(position).getName() + ": Selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, BookActivity.class);

                System.out.println(books.get(position));
                intent.putExtra("TheBook", (Serializable) books.get(position));
                context.startActivity(intent);
            }
        });

        if(books.get(position).getExpanded()){
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedCard.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);
        } else {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedCard.setVisibility(View.GONE);
            holder.upArrow.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CardView parent;
        private ImageView bookImg;
        private TextView bookName;

        private ImageView downArrow, upArrow;
        private RelativeLayout nonExpandedCard, expandedCard;
        private TextView authorName, shortDescription, txtButtonDeleteRecyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parent = itemView.findViewById(R.id.bookListLayoutParent);
            bookImg = itemView.findViewById(R.id.bookImg);
            bookName = itemView.findViewById(R.id.bookName);

            downArrow = itemView.findViewById(R.id.iconDownArrow);
            upArrow = itemView.findViewById(R.id.iconUpArrow);

            nonExpandedCard = itemView.findViewById(R.id.nonExpandedCard);
            expandedCard = itemView.findViewById(R.id.expandedCard);

            authorName = itemView.findViewById(R.id.authorName);
            shortDescription = itemView.findViewById(R.id.shortDesc);

            txtButtonDeleteRecyclerView = itemView.findViewById(R.id.buttonDeleteRecyclerView);

            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Expanding Request", Toast.LENGTH_SHORT).show();

                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.getExpanded());

                    notifyItemChanged(getAdapterPosition());
                }
            });

            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.getExpanded());

                    notifyItemChanged(getAdapterPosition());
                }
            });

            /**
             * Delete Functionality
             */

            txtButtonDeleteRecyclerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Deleting", Toast.LENGTH_SHORT).show();
                    Book book = books.get(getAdapterPosition());
                    Utils.deleteBook(book);
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
