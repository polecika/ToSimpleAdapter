package com.example.tosimpleadapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String KEY1 = "key1";
    private static final String KEY2 = "key2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        ListView list = findViewById(R.id.list);

        List<Map<String, String>> values = prepareContent();

        ListAdapter listContentAdapter = createAdapter(values);

        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private BaseAdapter createAdapter(List<Map<String, String>> values) {
        return new SimpleAdapter(this, values, R.layout.texts_1_2, new String[]{KEY1,KEY2}, new int[]{R.id.text1, R.id.text2});
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {
        List<Map<String, String>> result = new ArrayList<>();
        String[] words;
        words = getString(R.string.large_text).split("\n\n");
        for (int i = 0; i < words.length; i++){
            Map<String,String> map = new HashMap<>();
            map.put(KEY1, words[i]);
            map.put(KEY2, words[i].length() + "");
            result.add(map);
        }
        return result;
    }
}