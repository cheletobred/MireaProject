package ru.mirea.vorobevavi.mireaproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profile extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Profile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Profile newInstance(String param1, String param2) {
        Profile fragment = new Profile();
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
        View view=inflater.inflate(R.layout.fragment_profile, container, false);
        SharedPreferences sharedPref = getActivity().getSharedPreferences("mirea_settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        EditText name= (EditText) view.findViewById(R.id.name);
        EditText age= (EditText) view.findViewById(R.id.age);
        EditText city= (EditText) view.findViewById(R.id.city);
        EditText group= (EditText) view.findViewById(R.id.group);
        Button send=(Button)view.findViewById(R.id.send);
        name.setText(sharedPref.getString("name", "NAME"));
        age.setText(sharedPref.getString("age", "AGE"));
        city.setText(sharedPref.getString("city", "CITY"));
        group.setText(sharedPref.getString("group", "GROUP"));
        send.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("name", String.valueOf(name.getText()));
                editor.putString("age", String.valueOf(age.getText()));
                editor.putString("city",String.valueOf(city.getText()));
                editor.putString("group",String.valueOf(group.getText()));
                editor.apply();
            }
        });
        return view;
    }
}