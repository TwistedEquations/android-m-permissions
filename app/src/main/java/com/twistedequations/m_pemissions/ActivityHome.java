package com.twistedequations.m_pemissions;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ActivityHome extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViewById(R.id.home_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_button:
                createFile();
                break;
        }
    }

    private void createFile() {
        File dir = Environment.getExternalStorageDirectory();
        File file = new File(dir, "test.txt");
        byte[] data = "writing to text file.txt".getBytes();
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bufferedOutputStream.write(data);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            Toast.makeText(this, "File wrote", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "File failed to write - " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
