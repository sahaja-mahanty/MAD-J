package com.project.mad.fincheck;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class PieCharty extends Fragment {


    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static PieCharty newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PieCharty fragment = new PieCharty();
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

        PieChart pieChart ;
        ArrayList<Entry> entries ;
        ArrayList<String> PieEntryLabels ;
        PieDataSet pieDataSet ;
        PieData pieData ;

        View view = inflater.inflate(R.layout.activity_pie_charty, container, false);
        pieChart = (PieChart) view.findViewById(R.id.chart1);

        entries = new ArrayList<>();

        PieEntryLabels = new ArrayList<String>();

        entries.add(new BarEntry(2f, 0));
        entries.add(new BarEntry(4f, 1));
        entries.add(new BarEntry(6f, 2));
        entries.add(new BarEntry(8f, 3));
        entries.add(new BarEntry(7f, 4));
        entries.add(new BarEntry(4f, 5));


        PieEntryLabels.add("Food");
        PieEntryLabels.add("Health");
        PieEntryLabels.add("Education");
        PieEntryLabels.add("Shopping");
        PieEntryLabels.add("Travel");
        PieEntryLabels.add("Miscellaneous");


        pieDataSet = new PieDataSet(entries, "");

        pieData = new PieData(PieEntryLabels, pieDataSet);
        final int[] MY_COLORS = {Color.rgb(192,0,0), Color.rgb(255,0,0), Color.rgb(255,192,0),
                Color.rgb(127,127,127), Color.rgb(146,208,80), Color.rgb(0,176,80), Color.rgb(79,129,189)};
        ArrayList<Integer> colors = new ArrayList<Integer>();

        for(int c: MY_COLORS) colors.add(c);
        pieDataSet.setColors(colors);

        pieChart.setData(pieData);
        pieChart.setDescription("Expenses Today");
        pieChart.animateY(3000);
        return view;
    }

}
