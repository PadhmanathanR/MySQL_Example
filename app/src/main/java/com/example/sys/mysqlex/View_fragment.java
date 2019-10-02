package com.example.sys.mysqlex;


import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class View_fragment extends Fragment {


    public View_fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_view_fragment, container, false);
        Button foralldata=view.findViewById(R.id.foralldata);


        final dataBaseHelperClass db = new dataBaseHelperClass(getActivity());


        final Button forspecificdata=view.findViewById(R.id.forspecificdata);
        final EditText specific_text = view.findViewById(R.id.specific_text);
        specific_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            if(specific_text.getText().toString().length()>0)
            {
                forspecificdata.setEnabled(true);
            }
            else
            {
                forspecificdata.setEnabled(false);
            }
            }
        });
        foralldata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=db.showalldatas();
                if(res.getCount()==0)
                {
                    dispmsg("OOPS!!","No Data Available");
                    return;
                }
                else
                {
                    StringBuffer buffer=new StringBuffer();
                    while(res.moveToNext())
                    {
                        buffer.append(dataBaseHelperClass.STUDENTS_NAME +" : "+res.getString(0)+"\n");
                        buffer.append(dataBaseHelperClass.STUDENTS_PASSWORD +" : "+res.getString(1)+"\n");
                        buffer.append(dataBaseHelperClass.STUDENTS_ROLLNUMBER +" : "+res.getString(2)+"\n\n");
                    }
                    dispmsg("Data :",buffer.toString());
                }
            }
        });
        forspecificdata.setEnabled(false);

        forspecificdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=db.showspecificdatas(specific_text.getText().toString());
                if(res.getCount()==0)
                {
                    dispmsg("OOPS!!","No Data Available");
                    return;
                }
                else
                {
                    StringBuffer buffer=new StringBuffer();
                    while(res.moveToNext())
                    {
                        buffer.append(dataBaseHelperClass.STUDENTS_NAME +" : "+res.getString(0)+"\n");
                        buffer.append(dataBaseHelperClass.STUDENTS_PASSWORD +" : "+res.getString(1)+"\n");
                        buffer.append(dataBaseHelperClass.STUDENTS_ROLLNUMBER +" : "+res.getString(2)+"\n\n");
                    }
                    dispmsg("Data :",buffer.toString());
                }
            }
        });
        return  view;
    }

    public void dispmsg(String title,String msg)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }

}
