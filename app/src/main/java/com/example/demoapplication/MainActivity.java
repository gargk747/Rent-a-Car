package com.example.demoapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CardData[] cardData= new CardData[]{
                new CardData("Swift Dzire","Available",R.drawable.swift4,R.drawable.swift5,R.drawable.swift6,R.drawable.swift7,"Petrol","$100/day","4 Person","JAI Airport","25km/L","Black,White","The Maruti Suzuki Dzire is currently offered with a single 90PS 1.2-litre Dualjet petrol engine. It comes mated to either a 5-speed manual or an AMT."),
                new CardData("Audi A4","Available",R.drawable.audia42,R.drawable.audia43,R.drawable.audia44,R.drawable.audia45,"Petrol","$500/day","4 Person","JAI Airport","15km/L","Black,White,Red","Audi introduced the A4 Quick Lift in India on November 4, 2019, with a mild facelift and new all-weather headlamp units."),
                new CardData("BMW X5","Available",R.drawable.bmwx51,R.drawable.bmwx52,R.drawable.bmwx53,R.drawable.bmwx54,"Diesel","$700/day","6 Person","Patrika Gate","20km/L","Blue,Black,White","BMW has launched the fourth generation X5 in India. The SUV is available in three variants - 30d Sport, 30d xLine and the 40i M Sport."),
                new CardData("Mercedes B-SLK","Available",R.drawable.mercedesbenzslk1,R.drawable.mercedesbenzslk2,R.drawable.mercedesbenzslk3,R.drawable.mercedesbenzslk4,"Petrol","$1000/day","2 Person","Malaviya Nagar","10km/L","Black,White","Mercedes-Benz India has finally launched the SLK 55 AMG roadster in the country for Rs. 1.26 crore (ex-showroom, Delhi)."),

        };

        CardAdapter adapter= new CardAdapter(cardData,MainActivity.this);
        recyclerView.setAdapter(adapter);
    }
}
