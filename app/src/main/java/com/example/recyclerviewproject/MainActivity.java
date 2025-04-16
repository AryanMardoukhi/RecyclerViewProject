package com.example.recyclerviewproject;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity  implements ContactsAdapter.ItemEventListener {
private ContactsAdapter adapter;
private int editingItemPosition = -1;
private EditText fullnameEt;
private ImageView addNewContactBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        adapter=new ContactsAdapter(this);
        recyclerView.setAdapter(adapter);

        fullnameEt = findViewById(R.id.et_main_contactFullname);
        addNewContactBtn=findViewById(R.id.iv_main_addNewContact);
        addNewContactBtn.setOnClickListener(v -> {
            if(fullnameEt.length()>0) {
                if(editingItemPosition>-1) {
                    adapter.updateContact(fullnameEt.getText().toString(),editingItemPosition);
                    editingItemPosition=-1;
                    addNewContactBtn.setImageResource(R.drawable.ic_add_white_24dp);

                }else {
                    adapter.addNewContact(fullnameEt.getText().toString());
                    recyclerView.smoothScrollToPosition(0);

                }
                fullnameEt.setText("");

            }
        });
    }

    @Override
    public void onItemClick(String fullname, int position) {
        editingItemPosition=position;
        fullnameEt.setText(fullname);
        addNewContactBtn.setImageResource(R.drawable.ic_done_white_24dp);

    }
}