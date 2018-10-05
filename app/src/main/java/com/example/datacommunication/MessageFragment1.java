package com.example.datacommunication;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MessageFragment1 extends Fragment implements DataInterface {
    TextView messageId1;
    Button send2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message1,container,false);
        messageId1 = view.findViewById(R.id.messageId1);
        send2 = view.findViewById(R.id.send2);
        send2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((MainActivity) getActivity()).registerDataUpdateListener(this);
    }

    @Override
    public void onDataUpdate(String message) {
        messageId1.setText(message);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((MainActivity)getActivity()).mListeners=null;
    }


}
