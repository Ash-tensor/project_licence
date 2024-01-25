package com.example.projectlicence;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link getUserDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class getUserDataFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public getUserDataFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static getUserDataFragment newInstance(String param1, String param2) {
        getUserDataFragment fragment = new getUserDataFragment();
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
        View view = inflater.inflate(R.layout.get_user_data_fragment, container, false);



        Button confirmButton = (Button) view.findViewById(R.id.confirmButton);
        TextView adventurerName = (TextView) view.findViewById(R.id.adventurerName);
        Spinner adventurerGradeSpinner = (Spinner) view.findViewById(R.id.Spinner_Grade);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adventurerGradeSpinner.setAdapter(adapter);
        adventurerGradeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                ContentValues values = new ContentValues();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("adventurerGrade", adventurerGradeSpinner.getSelectedItem().toString());
                editor.putString("adventurerName", adventurerName.getText().toString());

                editor.commit();
                getFragmentManager().beginTransaction().replace(R.id.FragmentContainer, new fragment1()).commit();
            }
        });

        return view;
    }
}