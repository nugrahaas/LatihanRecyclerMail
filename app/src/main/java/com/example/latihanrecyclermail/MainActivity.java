package com.example.latihanrecyclermail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Mail> mailList;
    private MailAdapter mailAdapter;

    String[] names= {
            "Sam", "Facebook", "Google+", "Twitter", "Pinterest Weekly",
            "Josh", "Ikhwan", "Emir"
    };
    String[] profName= {
            "S", "F", "G", "T", "P",
            "J", "I", "E"
    };
    String[] subjects= {
            "Weekend Adventure", "James, You Have 1 Notification", "Top Suggested Google+ pages for you", "Follow T-Mobile", "Pins You'll Love",
            "Going Lunch", "Homework", "Laptop Charger"
    };
    String[] contents= {
            "Lets go fishing with John and others. We will do..", "A lot has happened on Facebook since...", "Top Suggested Google+ pages for you", "James, some people you may know", "Have you seen this pins yet? Pinterest",
            "Dont forget our lunch at 2 pm in Saung Karedok", "Bro, i need your help to do my homework", "Yo, i have problems with my charger. Can i borrow yours?"
    };
    String[] jams= {
            "10:42am", "16:04pm", "18:44pm", "20:04pm", "09:08am",
            "01:04am", "12.00pm", "01.24am"
    };

    int[] pics = {
            R.drawable.rounded_drawable,
            R.drawable.rounded_drawable_pastel_orange,
            R.drawable.rounded_drawable_green_grass,
            R.drawable.rounded_drawable_green,
            R.drawable.rounded_drawable_purple,
            R.drawable.rounded_drawable_pink,
            R.drawable.rounded_drawable_i,
            R.drawable.rounded_drawable_e,



    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);
        if (mRecyclerView != null){
            mRecyclerView.setHasFixedSize(true);

        }

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mailList = new ArrayList<>();

        for (int i = 0; i < names.length; i++){
            Mail mail = new Mail(names[i], subjects[i], profName[i] , contents[i], jams[i], pics[i]);
            mailList.add(mail);

        }

        mailAdapter = new MailAdapter(mailList);

        mRecyclerView.setAdapter(mailAdapter);
        mailAdapter.notifyDataSetChanged();

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Toast.makeText(MainActivity.this, "Mail from " + names[position] + " is clicked", Toast.LENGTH_SHORT).show();
            }
        }));




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_grid:
                mLayoutManager = new GridLayoutManager(this, 2);
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
            case R.id.item_staggered_grid:
                mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
            case R.id.item_horizontal:
                mLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL,false);
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
            case R.id.item_vertical:
                mLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL,false);
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
