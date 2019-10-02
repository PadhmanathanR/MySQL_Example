package com.example.sys.mysqlex;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Alter_fragment extends Fragment {


    public Alter_fragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_alter_fragment, container, false);
        final EditText rollno_edit = view.findViewById(R.id.rollno_edit);
        final Button rollno_edit_btn=view.findViewById(R.id.rollno_edit_btn);
        rollno_edit_btn.setEnabled(false);
        final EditText edit_name=view.findViewById(R.id.edit_name);
        edit_name.setEnabled(false);
        final EditText edit_password=view.findViewById(R.id.edit_password);
        edit_password.setEnabled(false);
        final EditText edit_rollnumber=view.findViewById(R.id.edit_rollnumber);
        edit_rollnumber.setEnabled(false);
       final Button save_edit=view.findViewById(R.id.save_edit);
       save_edit.setEnabled(false);
        rollno_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            if(rollno_edit.getText().toString().length()>0)
                rollno_edit_btn.setEnabled(true);
            else
                rollno_edit_btn.setEnabled(false);
            }
        });
        final dataBaseHelperClass db=new dataBaseHelperClass(getActivity());
        rollno_edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Cursor res=db.findmealone(rollno_edit.getText().toString());
            if(res.getCount()==0)
            {
                Toast.makeText(getActivity(),"No Data Available ",Toast.LENGTH_SHORT).show();
            }
            else
            {
                res.moveToFirst();
            edit_name.setText(res.getString(0));
            edit_name.setEnabled(true);
            edit_name.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    save_edit.setEnabled(true);
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

                edit_password.setText(res.getString(1));
                edit_password.setEnabled(true);
                edit_password.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        save_edit.setEnabled(true);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                edit_rollnumber.setText(res.getString(2));
                edit_rollnumber.setEnabled(true);
                edit_rollnumber.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        save_edit.setEnabled(true);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
            }
            }

        });
        save_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            boolean res=db.edit_data(edit_name.getText().toString(),edit_name.getText().toString()
                    ,edit_rollnumber.getText().toString(),rollno_edit.getText().toString());
            if(res)
            {
                Toast.makeText(getActivity(),"Succesfully edited",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(getActivity(),"Fails to update data",Toast.LENGTH_SHORT).show();
            }
            }
        });

        return view;
    }

}
