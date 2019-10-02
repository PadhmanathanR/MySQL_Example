package com.example.sys.mysqlex;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class create_fragment extends Fragment {


    public create_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_create_fragment, container, false);
        final EditText user_name=view.findViewById(R.id.user_name);
        final EditText pass_word=view.findViewById(R.id.pass_word);
        final EditText roll_no=view.findViewById(R.id.roll_no);
        Button create_submit=view.findViewById(R.id.create_submit);
        final dataBaseHelperClass dab = new dataBaseHelperClass(getActivity());
        create_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean done=dab.insert_data(user_name.getText().toString(),pass_word.getText().toString(),
                        roll_no.getText().toString());
                if(done)
                {
                    Toast.makeText(getActivity(),"Successfully inserted ",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getActivity(),"Data insertion failure ",Toast.LENGTH_SHORT).show();

            }
        });



    return  view;

    }

}
