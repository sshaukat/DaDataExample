package com.example.sshaukat.dadataexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.sshaukat.dadataexample.dadata.api.adapter.DaDataAutoCompleteAdapter;
import com.example.sshaukat.dadataexample.dadata.api.widgets.DelayAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAutoCompleteTextView();
    }

    public void initAutoCompleteTextView() {
        final DelayAutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView.setThreshold(3);
        autoCompleteTextView.setLoadingIndicator(
                (android.widget.ProgressBar) findViewById(R.id.pb_loading_indicator)
        );
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String addressString = (String) adapterView.getItemAtPosition(position);
                autoCompleteTextView.setText(addressString);
            }
        });
        autoCompleteTextView.setAdapter(
                new DaDataAutoCompleteAdapter(this)
        );
    }
}
