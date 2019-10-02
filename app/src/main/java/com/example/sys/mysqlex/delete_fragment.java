package com.example.sys.mysqlex;


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



public class delete_fragment extends Fragment {


    public delete_fragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_delete_fragment, container, false);
        final EditText del_text=view.findViewById(R.id.del_text);
        final Button del_btn=view.findViewById(R.id.del_btn);
        del_btn.setEnabled(false);
        del_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            del_btn.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBaseHelperClass db=new dataBaseHelperClass(getActivity());
                boolean res=db.del_data(del_text.getText().toString());
                if(res)
                {
                    Toast.makeText(getActivity(),"Data Deleted Succesfully",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getActivity(),"Deta not available to delete",Toast.LENGTH_SHORT).show();

            }
        });

        return view;

    }

}
