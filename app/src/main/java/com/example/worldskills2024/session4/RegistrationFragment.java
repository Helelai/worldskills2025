package com.example.worldskills2024.session4;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.worldskills2024.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistrationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView haveAccout;
    ImageButton returnButton;
    EditText inputedEmail;
    String userEmail;
    Button regB;
    boolean isPasswordVisible = false;
    ImageButton hideShowPassReg;
    EditText userPasswordInput;
    EditText userNameInput;
    CheckBox personalDataCheckbox;


    public RegistrationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistrationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistrationFragment newInstance(String param1, String param2) {
        RegistrationFragment fragment = new RegistrationFragment();
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
        View rootview = inflater.inflate(R.layout.fragment_registration, container, false);
        haveAccout = rootview.findViewById(R.id.haveAccTW);
        haveAccout.setOnClickListener(v -> {
            HaveAccoutClick(rootview);
        });

        returnButton = rootview.findViewById(R.id.returnButton2);
        returnButton.setOnClickListener(v -> {
            returnButtonClick2(rootview);
        });

        inputedEmail = rootview.findViewById(R.id.EmailRegET);
        userEmail = inputedEmail.getText().toString();
        regB = rootview.findViewById(R.id.RegB);
        regB.setOnClickListener(v -> {
            RegBClick(rootview);
        });

        hideShowPassReg = rootview.findViewById(R.id.HideShowPassReg);
        hideShowPassReg.setOnClickListener(v-> {
            showHidePass(rootview);
        });

        userPasswordInput = rootview.findViewById(R.id.ETPassReg);
        userNameInput = rootview.findViewById(R.id.nameET);

        personalDataCheckbox = rootview.findViewById(R.id.personal_dataCHBX);
        return rootview;

    }

    public void HaveAccoutClick(View view) {
        requireActivity().getSupportFragmentManager().popBackStack();
    }

    public void returnButtonClick2(View view) {
        requireActivity().getSupportFragmentManager().popBackStack();
    }

    public boolean isEmailValide(String userEmail) {
        if (userEmail != null && Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            return true;
        }
        else {
            return false;
        }
    }

    public void RegBClick(View view) {
        if (!userPasswordInput.getText().toString().isEmpty()
                && !inputedEmail.getText().toString().isEmpty()
                && !userNameInput.getText().toString().isEmpty() &&
                isEmailValide(inputedEmail.getText().toString()) && personalDataCheckbox.isChecked()) {
            Toast toast = Toast.makeText(this.getContext(),
                    "Регистрация прошла успешно. Теперь вы можете войти.",
                    Toast.LENGTH_SHORT);
            toast.show();

            requireActivity().getSupportFragmentManager().popBackStack();

        }
        else if (!personalDataCheckbox.isChecked()) {
            Toast toast = Toast.makeText(this.getContext(),
                    "Пожалуйста, подтвердите согласие на обработку персональных данных",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            Toast toast = Toast.makeText(this.getContext(),
                    "Проверьте заполненность полей или корректность введенного адреса почты.",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void showHidePass(View view) {
        if (!isPasswordVisible) {
            //Показывает пароль
            userPasswordInput.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
        else {
            userPasswordInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        isPasswordVisible = !isPasswordVisible;
    }

}