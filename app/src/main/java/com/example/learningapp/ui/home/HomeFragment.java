package com.example.learningapp.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.learningapp.R;
import com.example.learningapp.chaptertopics.TopicActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {

    }
CardView konu1,konu2,konu3,konu4,konu5,konu6,konu7;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        konu1 = view.findViewById(R.id.konu1); //konu kategorilerinin eklenmesi
        konu2 = view.findViewById(R.id.konu2);
        konu3 = view.findViewById(R.id.konu3);
        konu4 = view.findViewById(R.id.konu4);
        konu5=view.findViewById(R.id.konu5);
        konu6=view.findViewById(R.id.konu6);
        konu7=view.findViewById(R.id.konu7);

        konu1.setOnClickListener(this);
        konu2.setOnClickListener(this);
        konu3.setOnClickListener(this);
        konu4.setOnClickListener(this);
        konu5.setOnClickListener(this);
        konu6.setOnClickListener(this);
        konu7.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View view) { //tıkladığında yeni aktivitenin syafanın açılması
        Intent intent= new Intent(getContext(),TopicActivity.class);//konu başlıklarından sonra alt konu başlıklarının çıkması
switch (view.getId()){
    case R.id.konu1:
        intent.putExtra("chapterName", "konu1");
        startActivity(intent);
    break;
    case R.id.konu2:

        intent.putExtra("chapterName", "konu2");
        startActivity(intent);
        break;
    case R.id.konu3:
        intent.putExtra("chapterName", "konu3");
        startActivity(intent);
        break;
    case R.id.konu4:
        intent.putExtra("chapterName", "konu4");
        startActivity(intent);
        break;
    case R.id.konu5:
        intent.putExtra("chapterName", "konu5");
        startActivity(intent);
        break;
    case R.id.konu6:
        intent.putExtra("chapterName", "konu6");
        startActivity(intent);
        break;
    case R.id.konu7:
        intent.putExtra("chapterName", "konu7");
        startActivity(intent);
        break;
    }
}
}