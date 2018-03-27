package com.project.mad.fincheck;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class InsertFragment extends Fragment {


        public static final String ARG_PAGE = "ARG_PAGE";

        private int mPage;

        public static InsertFragment newInstance(int page) {
            Bundle args = new Bundle();
            args.putInt(ARG_PAGE, page);
            InsertFragment fragment = new InsertFragment();
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mPage = getArguments().getInt(ARG_PAGE);
        }

        // Inflate the fragment layout we defined above for this fragment
        // Set the associated text for the title
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final View view = inflater.inflate(R.layout.activity_insert_fragment, container, false);
            
            Button button=(Button) view.findViewById(R.id.button);
            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Spinner spinnerc = (Spinner) view.findViewById(R.id.spinner);
                    spinnerc.setOnItemSelectedListener(new CustomOnItemSelectedListener());
                    String s= String.valueOf(spinnerc.getSelectedItem());
                    EditText numc=(EditText) view.findViewById(R.id.editText);
                    Integer n=Integer.valueOf(numc.getText().toString());
                    numc.setText("");
                }
            });

            return view;
        }
    }
