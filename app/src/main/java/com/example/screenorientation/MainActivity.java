package com.example.screenorientation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    String name ="неопределено";
    final static String nameVariableKey = "NAME_VAR";
    final static String textViewTexKey = "TEXT_VIEW";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSave = (Button) findViewById(R.id.buttonSave);
        Button buttonSet = (Button) findViewById(R.id.buttonSet);

        buttonSave.setOnClickListener(v -> {
            TextView nameBox = (TextView) findViewById(R.id.editTextTextMultiLine);
            name = nameBox.getText().toString();
        });

        buttonSet.setOnClickListener(v -> {
            TextView nameView = (TextView) findViewById(R.id.saveTextView);
            nameView.setText(name);
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        outState.putString(nameVariableKey, name);
        TextView nameView = (TextView) findViewById(R.id.saveTextView);
        outState.putString(textViewTexKey, nameView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        name = savedInstanceState.getString(nameVariableKey);
        String textViewText= savedInstanceState.getString(textViewTexKey);
        TextView nameView = (TextView) findViewById(R.id.saveTextView);
        nameView.setText(textViewText);
    }
}
