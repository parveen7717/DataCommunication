package com.example.datacommunication;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button buttonId;
    AppNavigationController navigation;
    public DataInterface mListeners;
    public MessageFragment fragmentA;
    public MessageFragment1 fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = new AppNavigationController(this);
        buttonId = findViewById(R.id.buttonId);
        buttonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataUpdated();
            }
        });
        fragment(R.id.frame,new MessageFragment());
        fragment(R.id.frame1,new MessageFragment1());
        fragmentA = (MessageFragment)navigation.fragmentManager.findFragmentById(R.id.frame);
        fragmentB = (MessageFragment1) navigation.fragmentManager.findFragmentById(R.id.frame1);
        /*fragmentA.onDataUpdate("Hi! What's Up?");
        fragmentB.onDataUpdate("Doing Good... What About You?");*/
    }

    public void fragment(int id, Fragment fragment){
        navigation.fragment(id,fragment);
    }



    public synchronized void registerDataUpdateListener(DataInterface listener) {
        mListeners=listener;
    }


    public synchronized void dataUpdated() {
        if(mListeners!=null)
        mListeners.onDataUpdate("Yippee Message Sent");
    }

}
