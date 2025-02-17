package com.example.worldskills2024.session4;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.worldskills2024.R;
import com.example.worldskills2024.session3.GeneralActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VerificationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VerificationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageButton returnButton;
    CountDownTimer timer;

    TextView timerTW;
    TextView resendOTPTW;

    EditText[] editTexts;
    boolean isFieldsFull = false;
    TextWatcher textWatcher;


    public VerificationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VerificationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VerificationFragment newInstance(String param1, String param2) {
        VerificationFragment fragment = new VerificationFragment();
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
        View rootView =  inflater.inflate(R.layout.fragment_verification, container, false);

        returnButton = rootView.findViewById(R.id.returnButtonOTP);
        returnButton.setOnClickListener(v->{
            returnButtonClick(rootView);
        });
        timerTW = rootView.findViewById(R.id.timerTW);
        setCountdownTimer();
        resendOTPTW = rootView.findViewById(R.id.resentOTPTW);
        editTexts = new EditText[] {rootView.findViewById(R.id.numberET), rootView.findViewById(R.id.numberET2), rootView.findViewById(R.id.numberET3),
        rootView.findViewById(R.id.numberET4), rootView.findViewById(R.id.numberET5), rootView.findViewById(R.id.numberET6)};
        Intent intent = new Intent(this.getContext(), GeneralActivity.class);
        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (checkFieldsFullness()) {
                    startActivity(intent);
                }
                textWatcher = null;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        initializeEditTexts();
        return rootView;
    }

    public void returnButtonClick(View view) {
        requireActivity().getSupportFragmentManager().popBackStack();
    }

    public void setCountdownTimer() {

        timer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int seconds = (int) ((millisUntilFinished / 1000) % 60);
                int minutes = (int) (millisUntilFinished / (60*1000));
                timerTW.setText(String.format("%02d:%02d", minutes, seconds));
            }

            @Override
            public void onFinish() {
                resendOTPTW.setOnClickListener(v->{
                    resendOTP();
                });
                timerTW.setText("");
                timer.cancel();
            }
        };
        timer.start();
    }

    public void resendOTP() {
        resendOTPTW.setOnClickListener(null);
        setCountdownTimer();
    }

    public boolean checkFieldsFullness() {
        isFieldsFull = true;
        for (int i = 0; i < editTexts.length; i++) {
            if (editTexts[i].getText().toString().isEmpty()) {
                isFieldsFull = false;
                break;
            }
        }
        return isFieldsFull;
    }

    public void initializeEditTexts() {
        for (int i = 0; i < editTexts.length; i++) {
            editTexts[i].addTextChangedListener(textWatcher);
        }
    }


}