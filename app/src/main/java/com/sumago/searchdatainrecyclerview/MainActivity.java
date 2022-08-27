package com.sumago.searchdatainrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    SampleAdapter adapter;
    ArrayList<Model> List = new ArrayList<Model>();
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();

        rv = findViewById(R.id.rv);

        LoadData();

        ShowData();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                filterList(newText);


                return true;
            }
        });


    }

    private void filterList(String text) {

        ArrayList<Model> filteredList = new ArrayList<Model>();
        for (Model item: List){
            Log.e("item", "item is: " +item.getName() +"  \n\n");
            if (item.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        if (filteredList.isEmpty()){
            Toast.makeText(MainActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
        }
        else {
            adapter.setFilteredList(filteredList);
        }


    }

    private void ShowData() {
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        adapter = new SampleAdapter(MainActivity.this, List);
        rv.setAdapter(adapter);

    }

    private void LoadData() {



        List.add(new Model("Salman Khan", "abc", "Mumbai", "9856231456"));
        List.add(new Model("Hritik Roshan", "abc@84938", "pune", "98562341635465"));
        List.add(new Model("Sharukh Khan", "jfoiaspdoif", "Gujrat", "9856245456"));
        List.add(new Model("Amir Khan", "kjhoisd", "Virar", "985623255556"));
        List.add(new Model("Ranveer Singh", "kljuds", "Thane", "9845463531456"));
        List.add(new Model("Amitabh Bachhan", "mkohhs", "Delhi", "98246561456"));

    }
}