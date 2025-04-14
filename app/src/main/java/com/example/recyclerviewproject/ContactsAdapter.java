package com.example.recyclerviewproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {
    private  String[] contacts=new String[20];

    public  ContactsAdapter() {
        contacts[0]="Ruthann Trustrie";
        contacts[1]="Peadar Dawtrey";
        contacts[2]="Felipe Bradtke";
        contacts[3]="Claude Crissil";
        contacts[4]="Jacky Girardeau";
        contacts[5]="Rubia Dominguez";
        contacts[6]="Michaela Churchley";
        contacts[7]="Harvey Pentelow";
        contacts[8]="Neilla Langton";
        contacts[9]="Marco Greaves";
        contacts[10]="Liz Batchley";
        contacts[11]="Lamond Littlepage";
        contacts[12]="Malina Weir";
        contacts[13]="Tomlin Lenchenko";
        contacts[14]="Hy Pavelin";
        contacts[15]="Jenelle Palin";
        contacts[16]="Damon Knewstubb";
        contacts[17]="Alex Ivanusyev";
        contacts[18]="Hamil Callery";
        contacts[19]="Karol Syer";

    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact,parent,false);
        return new ContactsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {
         holder.bindContact(contacts[position]);
    }

    @Override
    public int getItemCount() {
        return contacts.length;
    }

    public  class ContactsViewHolder extends RecyclerView.ViewHolder {
    private  TextView firstCharactertv;
    private  TextView fullnametv;

        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            firstCharactertv=itemView.findViewById(R.id.tv_contact_firstCharacter);
            fullnametv=itemView.findViewById(R.id.tv_contact_firstCharacter);
        }

        public void bindContact (String fullname) {
            fullnametv.setText(fullname);
            firstCharactertv.setText(fullname.substring(0,1));
        }
    }
}
