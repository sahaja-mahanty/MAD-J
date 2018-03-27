package com.project.mad.fincheck;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class RepCharty extends Fragment {


    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static RepCharty newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        RepCharty fragment = new RepCharty();
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
         final String TAG = "CardListActivity";
         CardArrayAdapter cardArrayAdapter;
         ListView listView;
        View view = inflater.inflate(R.layout.activity_rep_charty, container, false);
        listView = (ListView) view.findViewById(R.id.card_listView);

        listView.addHeaderView(new View(getActivity()));
        listView.addFooterView(new View(getActivity()));

        cardArrayAdapter = new CardArrayAdapter(getActivity(), R.layout.list_item_card);


        Card card0 = new Card("Food","200",R.drawable.food);
        cardArrayAdapter.add(card0);
        Card card1 = new Card("Health","200",R.drawable.health);
        cardArrayAdapter.add(card1);
        Card card2 = new Card("Education","200",R.drawable.edu);
        cardArrayAdapter.add(card2);
        Card card3 = new Card("Shopping","200",R.drawable.shop);
        cardArrayAdapter.add(card3);
        Card card4 = new Card("Travel","200",R.drawable.travel);
        cardArrayAdapter.add(card4);
        Card card5 = new Card("Miscellenous","200",R.drawable.miscyy);
        cardArrayAdapter.add(card5);

        listView.setAdapter(cardArrayAdapter);
        return view;
    }
}

