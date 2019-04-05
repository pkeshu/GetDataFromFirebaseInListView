package com.example.keshar.getdataintolistviewfromfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
//    private Firebase firebaseUrl;
//    private ArrayList<String> arrayList=new ArrayList<>();
//    private ArrayAdapter<String> adapter;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView=findViewById(R.id.list_view);
        Firebase.setAndroidContext(this);

//        firebaseUrl=new Firebase("https://applicationdemo-eff34.firebaseio.com/list/");
//
//        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
//
//        mListView.setAdapter(adapter);
//
//        firebaseUrl.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                String value=dataSnapshot.getValue(String.class);
//                arrayList.add(value);
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });

        myRef=FirebaseDatabase.getInstance().getReferenceFromUrl("https://applicationdemo-eff34.firebaseio.com/list/");

        FirebaseListAdapter<String> listAdapter=new FirebaseListAdapter<String>(this,
                String.class,
                android.R.layout.simple_list_item_1,
                myRef) {
            @Override
            protected void populateView(View v, String model, int position) {
                TextView textView=v.findViewById(android.R.id.text1);
                textView.setText(model);

            }
        };
        mListView.setAdapter(listAdapter);
    }
}
