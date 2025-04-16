package com.example.recyclerviewproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {
    private static final ArrayList<String> contacts = new ArrayList<>();
private static ItemEventListener itemEventListener;
    public  ContactsAdapter(ItemEventListener itemEventListener) {
        ContactsAdapter.itemEventListener =itemEventListener;
        contacts.add("Ruthann Trustrie");
        contacts.add("Peadar Dawtrey");
        contacts.add("Felipe Bradtke");
        contacts.add("Claude Crissil");
        contacts.add("Jacky Girardeau");
        contacts.add("Rubia Dominguez");
        contacts.add("Michaela Churchley");
        contacts.add("Harvey Pentelow");
        contacts.add("Neilla Langton");
        contacts.add("Marco Greaves");
        contacts.add("Liz Batchley");
        contacts.add("Lamond Littlepage");
        contacts.add("Malina Weir");
        contacts.add("Tomlin Lenchenko");
        contacts.add("Hy Pavelin");
        contacts.add("Jenelle Palin");
        contacts.add("Damon Knewstubb");
        contacts.add("Alex Ivanusyev");
        contacts.add("Hamil Callery");
        contacts.add("Karol Syer");

    }

    public void addNewContact (String fullname) {
        contacts.add(0,fullname);
        notifyItemInserted(0);
    }

    public void updateContact (String fullname , int position) {
        contacts.set(position,fullname);
        notifyItemChanged(position);
    }


    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact,parent,false);
        return new ContactsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {
        holder.bindContact(contacts.get(position));
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder {
        private final TextView firstCharactertv;
        private final TextView fullnametv;


        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            firstCharactertv=itemView.findViewById(R.id.tv_contact_firstCharacter);
            fullnametv=itemView.findViewById(R.id.tv_contact_fullname);
        }

        public void bindContact (String fullname) {
            fullnametv.setText(fullname);
            firstCharactertv.setText(fullname.substring(0,1));
            itemView.setOnClickListener(v -> itemEventListener.onItemClick(fullname,getAbsoluteAdapterPosition()));

            itemView.setOnLongClickListener(v -> {
                contacts.remove(getAbsoluteAdapterPosition());
                notifyItemRemoved (getAbsoluteAdapterPosition());
                return false;
            });
        }
    }
    public  interface ItemEventListener {
        void onItemClick(String fullname , int position);
    }
}
