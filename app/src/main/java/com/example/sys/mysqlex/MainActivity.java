package com.example.sys.mysqlex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    dataBaseHelperClass mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new dataBaseHelperClass(this);
        if(findViewById(R.id.fragment_container)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }
            home hme=new home();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,hme,null).commit();
        }
    }
}
