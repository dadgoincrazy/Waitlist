package com.trucs.waitlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    GuestListAdapter gAdapter;
    RecyclerView gList;
    final List<String> guestNameList = new ArrayList();
    final List<Integer> guestNumList = new ArrayList();

    EditText guestName;
    EditText guestNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guestName = (EditText) findViewById(R.id.guest_name);
        guestNum = (EditText) findViewById(R.id.num_of_guest);

        gList = (RecyclerView) findViewById(R.id.all_guest_list_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        gList.setLayoutManager(linearLayoutManager);



        gAdapter = new GuestListAdapter(getApplicationContext(), guestNameList, guestNumList);

        gList.setAdapter(gAdapter);

    }

    public void addToWaitlist(View view) {
        try {
            String gName = String.valueOf(guestName.getText());
            Integer gNum = Integer.valueOf(String.valueOf(guestNum.getText()));
            guestNameList.add(gName);
            guestNumList.add(gNum);
        } catch(Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
