package com.project.mad.fincheck;


import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

public class IndWeakFragment extends Fragment {


        public static final String ARG_PAGE = "ARG_PAGE";

        private int mPage;

        public static IndWeakFragment newInstance(int page) {
            Bundle args = new Bundle();
            args.putInt(ARG_PAGE, page);
            IndWeakFragment fragment = new IndWeakFragment();
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
            ArrayList<BarEntry> BARENTRY ;
            ArrayList<String> BarEntryLabels ;
            BarDataSet Bardataset ;
            BarData BARDATA ;
            View view = inflater.inflate(R.layout.activity_ind_weak_fragment, container, false);


            HorizontalBarChart chart = (HorizontalBarChart) view.findViewById(R.id.barchart1);

            BARENTRY = new ArrayList<>();

            BarEntryLabels = new ArrayList<String>();


            BARENTRY.add(new BarEntry(2f, 0));
            BARENTRY.add(new BarEntry(4f, 1));
            BARENTRY.add(new BarEntry(6f, 2));
            BARENTRY.add(new BarEntry(8f, 3));
            BARENTRY.add(new BarEntry(7f, 4));
            BARENTRY.add(new BarEntry(7f, 5));
            BARENTRY.add(new BarEntry(3f, 6));


            BarEntryLabels.add("Sun");
            BarEntryLabels.add("Mon");
            BarEntryLabels.add("Tue");
            BarEntryLabels.add("Wed");
            BarEntryLabels.add("Thu");
            BarEntryLabels.add("Fri");
            BarEntryLabels.add("sun");

            Bardataset = new BarDataSet(BARENTRY, "");
            BARDATA = new BarData(BarEntryLabels, Bardataset);


            Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);

            chart.setData(BARDATA);

            chart.animateY(3000);

            final FoldingCell fc = (FoldingCell) view.findViewById(R.id.folding_cell);
            // set custom parameters
            fc.initialize(1000, Color.DKGRAY, 4);
            // attach click listener to folding cell
            fc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fc.toggle(false);
                }
            });


            return view;
        }
    }


