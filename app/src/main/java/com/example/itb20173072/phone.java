package com.example.itb20173072;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class phone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        com.example.itb20173072.PersonAdapter adapter = new com.example.itb20173072.PersonAdapter();

        adapter.addItem(new com.example.itb20173072.Person("추신수", "010-1717-0713"));
        adapter.addItem(new com.example.itb20173072.Person("최 정", "010-1414-0228"));
        adapter.addItem(new com.example.itb20173072.Person("김광현", "010-2933-0722"));
        adapter.addItem(new com.example.itb20173072.Person("김강민", "010-0000-0913"));
        adapter.addItem(new com.example.itb20173072.Person("박경완", "010-2626-0711"));
        adapter.addItem(new com.example.itb20173072.Person("김원형", "010-7016-0705"));

        recyclerView.setAdapter(adapter);

    }
}
