# Лабораторная №6 - Реакция на изменение ориентации экрана

В лабораторной реализована возможность ввода, сохранения и вывода сохраненного текста.

Методы кнопок:

```java
       buttonSave.setOnClickListener(v -> {
            TextView nameBox = (TextView) findViewById(R.id.editTextTextMultiLine);
            name = nameBox.getText().toString();
        });

        buttonSet.setOnClickListener(v -> {
            TextView nameView = (TextView) findViewById(R.id.saveTextView);
            nameView.setText(name);
        });
```

Методы реакции на изменение ориентации экрана:

```java
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
```

Скриншоты приложения и apk-файл включены.
