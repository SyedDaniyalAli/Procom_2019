package com.sda.syeddaniyalali.procom_2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class SocialTab extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapter viewAdapter;
    ArrayList<SocialData> data = new ArrayList<SocialData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_tab);
        recyclerView= findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        data.add(new SocialData("Karachi Trafic Police","@Kamraan","I m a police Officer, want to get a criminal",R.drawable.man));
        data.add(new SocialData("Karachi Trafic Police","@Kamraan","There are a variety of fauna that inhabit the Palala River including fish, Nile crocodile, African Rock Python and hippopotamus. In a 2004 study of the river's health, specimens of the North African catfish, Clarias gariepinus, were captured within reaches of the Lapalala Wilderness.[4] A healthy population of male and female fish was found in the river's upper reaches within the Lapalala Wilderness",R.drawable.man));
        data.add(new SocialData("Karachi Trafic Police","@Kamraan","These sites are very difficult to access, since there are no paved roads for access; in fact, even after a four-wheeled drive over deeply mudded and rutted bushveld roads",R.drawable.man));
        data.add(new SocialData("Karachi Trafic Police","@Kamraan","I m a police Officer, want to get a criminal",R.drawable.man));
        data.add(new SocialData("Karachi Trafic Police","@Kamraan","The underlying rock formation of the Palala River basin derives from the Kaapvaal craton, formed as a precursor island roughly 2.7 billion years ago. This crustal formation became the base of the Waterberg",R.drawable.man));
        data.add(new SocialData("Karachi Trafic Police","@Kamraan","I m a police Officer, want to get a criminal",R.drawable.man));

        viewAdapter=new RecyclerViewAdapter(this,data);
        recyclerView.setAdapter(viewAdapter);


    }
}
