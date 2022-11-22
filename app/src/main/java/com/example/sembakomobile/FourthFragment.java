package com.example.sembakomobile;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sembakomobile.Activity.login;
import com.example.sembakomobile.Activity.lupa_password;
import com.example.sembakomobile.Activity.register;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FourthFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FourthFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View nullic;
    private View nulltxthead;
    private View nullbtyes;
    private View nullbtno;
    private AlertDialog alert;

    public FourthFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FourthFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FourthFragment newInstance(String param1, String param2) {
        FourthFragment fragment = new FourthFragment();
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

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fourth, container, false);
        Button btn1, btn2, btn3, btn4;

        btn1 = view.findViewById(R.id.btn_akun);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), register.class));
            }
        });

        btn2 = view.findViewById(R.id.btn_kmn);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), register.class));
            }
        });

        btn3 = view.findViewById(R.id.btn_apk);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), register.class));
            }
        });

        btn4 = view.findViewById(R.id.btn_logout);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog();
            }
        });
        return view;
    }

    SharedPreferences shared;
    @SuppressLint("MissingInflatedId")
    private void alertDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        View view = getLayoutInflater().inflate(R.layout.activity_logout, null);
        alertDialogBuilder.setView(view);
        alert = alertDialogBuilder.create();
        alert.show();

        nullic = view.findViewById(R.id.image_set);
        nulltxthead = view.findViewById(R.id.txt_logout1);
        nullbtyes = view.findViewById(R.id.btn_logout1);
        nullbtyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shared = getActivity().getSharedPreferences("myapp-data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putBoolean("status",false);
                editor.putString("idPembeli",null);
                editor.clear();
                startActivity(new Intent(getActivity(), login.class));
                getActivity().finish();
            }
        });
        nullbtno = view.findViewById(R.id.btn_logout2);
        nullbtno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.cancel();
            }
        });
    }
}