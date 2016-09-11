package com.example.zhubingning.autocompletetextviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zhubingning.autocompletetextviewtest.View.AutoCompleteAdapter;
import com.example.zhubingning.autocompletetextviewtest.View.InstantAutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private InstantAutoCompleteTextView autoTextView;
    private ArrayList<String> listArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

    }

    private void initialize(){
        listArray=new ArrayList<>();
        listArray.add("test 1");
        listArray.add("test 2");
        listArray.add("test 3");
        listArray.add("default 9");
        listArray.add("beautiful");
        listArray.add("hello world");
        listArray.add("boring sunday");
        listArray.add("list test");
        autoTextView=(InstantAutoCompleteTextView) findViewById(R.id.autoCompleteText);

        AutoCompleteAdapter autocompleteAdapter = new AutoCompleteAdapter(this,android.R.layout.simple_list_item_1,listArray);
        autoTextView.setAdapter(autocompleteAdapter);
    }
}
