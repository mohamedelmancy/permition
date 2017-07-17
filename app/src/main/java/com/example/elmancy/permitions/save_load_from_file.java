package com.example.elmancy.permitions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class save_load_from_file extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_load_from_file);
        final EditText text=(EditText)findViewById(R.id.editText);
        Button btn1=(Button)findViewById(R.id.button9);
        Button btn2=(Button)findViewById(R.id.button8);
btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        try {
            FileOutputStream outputStream = save_load_from_file.this.openFileOutput("mancy.txt",save_load_from_file.this.MODE_PRIVATE);
            String yourtext = text.getText().toString();
            byte m[] = yourtext.getBytes();
            outputStream.write(m);
            outputStream.close();
            text.setText("Sucess :D :D ");
        }catch (Exception e){}

    }
});
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream inputStream = save_load_from_file.this.openFileInput("mancy.txt");
                    String yourtext = text.getText().toString();
                    int index=0;
                    String field="";
                    while ((index=inputStream.read())!=-1) {
                        field+=String.valueOf((char)index);

                    }
                    inputStream.close();
                    text.setText(field);
                }catch (Exception e){}

            }
        });
    }

}
