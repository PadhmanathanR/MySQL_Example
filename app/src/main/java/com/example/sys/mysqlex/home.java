package com.example.sys.mysqlex;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class home extends Fragment implements View.OnClickListener{


    public home() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view= inflater.inflate(R.layout.fragment_home, container, false);
        Button view_btn=view.findViewById(R.id.view_btn);
        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View_fragment view_fragment = new View_fragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager()
                        .beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, view_fragment).addToBackStack("third").commit();

            }

        });
        Button alter_btn = view.findViewById(R.id.alter_btn);
        alter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alter_fragment alter_fragment=new Alter_fragment();
                FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,alter_fragment).addToBackStack("Fourth");
                fragmentTransaction.commit();
            }
        });
        Button button = view.findViewById(R.id.create);
                button.setOnClickListener(this) ;



          Button delete_btn=view.findViewById(R.id.delete_btn);
          delete_btn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  delete_fragment del_frag=new delete_fragment();
                  FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
                  fragmentTransaction.replace(R.id.fragment_container,del_frag);
                  fragmentTransaction.addToBackStack("fifth");
                  fragmentTransaction.commit();
              }
          });


        return  view;





    }

       public void onClick(View view) {


           create_fragment create_frag=new create_fragment();
           home homee=new home();
           FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
           fragmentTransaction.replace(R.id.fragment_container,create_frag).addToBackStack("second").commit();
           fragmentTransaction.remove(homee);

       }

   }
