package com.example.worldskills2024.session4;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.worldskills2024.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ForgotPasswordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForgotPasswordFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageButton returnButton;
    EditText inputedEmail;
    Button sendB;

    public ForgotPasswordFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForgotPasswordActivity.
     */
    // TODO: Rename and change types and number of parameters
    public static ForgotPasswordFragment newInstance(String param1, String param2) {
        ForgotPasswordFragment fragment = new ForgotPasswordFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_forgot_password_activity, container, false);

        returnButton = rootView.findViewById(R.id.returnButtonRestorePass);
        returnButton.setOnClickListener(v-> {
            returnButtonClick(rootView);
        });

        inputedEmail = rootView.findViewById(R.id.EmailRestorePassET);

        sendB = rootView.findViewById(R.id.SendRestorePass);
        sendB.setOnClickListener(v -> {
            sendRestoreClick(rootView);
        });
        return rootView;
    }

    public void returnButtonClick(View view) {
        requireActivity().getSupportFragmentManager().popBackStack();
    }

    public boolean isEmailValide() {
        if (!inputedEmail.getText().toString().isEmpty() && Patterns.EMAIL_ADDRESS.matcher(inputedEmail.getText().toString()).matches()) {
            return true;
        }
        else {
            return false;
        }
    }

    public void sendRestoreClick(View view) {
        if (isEmailValide()) {
            Dialog dialog = new Dialog(this.getContext());
            dialog.setContentView(R.layout.custom_dialog_email);
            dialog.show();

            FragmentManager fm = getActivity().getSupportFragmentManager();
            VerificationFragment verificationFragment = new VerificationFragment();
            fm.beginTransaction()
                    .add(R.id.fragmentContainerLogin, verificationFragment)
                    .commit();
        }
        else {
            Toast toast = Toast.makeText(this.getContext(), "Проверьте корректность введеной почты.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}