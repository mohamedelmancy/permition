package com.example.elmancy.permitions;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.net.URI;
import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity {
    private static final int per_id = 125;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadmessages(View view) {
        if ((int) Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED)
            {
                if (!shouldShowRequestPermissionRationale(android.Manifest.permission.READ_SMS)) {
                    requestPermissions(new String[]{android.Manifest.permission.READ_SMS}, per_id);

                }

                    return;
            }

        }
    loadinboxmessag();
}

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode)
        {
            case per_id:
                if (grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {
                    loadinboxmessag();
                }
                    else {
                    //denied;
                }
                default:
                    super.onRequestPermissionsResult(requestCode,permissions,grantResults);

        }
        throw new RuntimeException("Stub!");
    }
   void loadinboxmessag()
    {
        try {


            String sms = "";
            Uri uri = Uri.parse("content://sms/inbox");
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            cursor.moveToPosition(0);
            while (cursor.moveToNext()) {
                sms += "From" + cursor.getString(cursor.getColumnIndex("address")) + ":" + cursor.getString(cursor.getColumnIndex("body")) + "/n";
                TextView textView=(TextView)findViewById(R.id.textView);
                textView.setText(sms);

            }
        }catch (Exception e){}

    }
}
