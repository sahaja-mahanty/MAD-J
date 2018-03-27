package com.project.mad.fincheck;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class BarCharty extends Fragment {


    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static BarCharty newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        BarCharty fragment = new BarCharty();
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
        BarChart chart ;
        ArrayList<BarEntry> BARENTRY ;
        ArrayList<String> BarEntryLabels ;
        BarDataSet Bardataset ;
        BarData BARDATA ;

        View view = inflater.inflate(R.layout.activity_bar_charty, container, false);
        chart = (BarChart) view.findViewById(R.id.chart1);

        BARENTRY = new ArrayList<>();

        BarEntryLabels = new ArrayList<String>();


        BARENTRY.add(new BarEntry(2f, 0));
        BARENTRY.add(new BarEntry(4f, 1));
        BARENTRY.add(new BarEntry(6f, 2));
        BARENTRY.add(new BarEntry(8f, 3));
        BARENTRY.add(new BarEntry(7f, 4));
        BARENTRY.add(new BarEntry(7f, 5));


        BarEntryLabels.add("F");
        BarEntryLabels.add("H");
        BarEntryLabels.add("E");
        BarEntryLabels.add("S");
        BarEntryLabels.add("T");
        BarEntryLabels.add("M");

        Bardataset = new BarDataSet(BARENTRY, "Expenses Today");

        BARDATA = new BarData(BarEntryLabels, Bardataset);


        Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);

        chart.setData(BARDATA);

        chart.animateY(3000);

        return view;
    }
}