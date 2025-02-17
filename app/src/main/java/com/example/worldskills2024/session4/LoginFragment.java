package com.example.worldskills2024.session4;

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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.worldskills2024.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters

    ImageButton ShowHidePassB;
    EditText ETPass;
    EditText ETEmail;
    Button LoginB;

    ImageButton returnButton;
    TextView createUserTW;
    boolean isPassVisible = false;
    TextView restoreTW;
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
         View rootView = inflater.inflate(R.layout.fragment_login, container, false);

         returnButton = rootView.findViewById(R.id.returnButton1);
         createUserTW = rootView.findViewById(R.id.CreateUserTW);
         ShowHidePassB = rootView.findViewById(R.id.HideShowPassLogin);
         ETPass = rootView.findViewById(R.id.ETPassLogin);
         ETEmail = rootView.findViewById(R.id.ETEmailLogin);
         LoginB = rootView.findViewById(R.id.LoginB);
         LoginB.setOnClickListener(v -> {
             if (ETPass.getText().toString().isEmpty() || ETEmail.getText().toString().isEmpty()) {
                 Toast toast = Toast.makeText(this.getContext(), "Проверьте заполненность полей", Toast.LENGTH_SHORT);
                 toast.show();
             }

         });
         returnButton.setOnClickListener(v-> {
             returnButtonClick(rootView);
         });

         createUserTW.setOnClickListener(v -> {
             CreateUserClick(rootView);
         });

         HideShowPass(ShowHidePassB, ETPass);

         restoreTW = rootView.findViewById(R.id.restoreTW);
         restoreTW.setOnClickListener(v-> {
                restoreClick(rootView);
         });

         return rootView;
    }

    public void HideShowPass(ImageButton HideShowPassB, EditText ETPass) {
        HideShowPassB.setOnClickListener(v -> {
            //Если пароль не видно
            if (!isPassVisible) {
                ETPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            else {
                ETPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            isPassVisible = !isPassVisible;
        });
    }

    public String isValidEmail(String email) {
        String result = "";
        if (email != null) {
            //Если введенный емаил совпадает с паттерном
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                return result;
            }
            else {
                result = "Введенный адрес почты некорректен";
                return result;
            }
        }
        else {
            result = "Проверьте заполненность поля почты";
            return result;
        }
    }

    public void returnButtonClick(View view) {
        FragmentManager fm = getActivity().getSupportFragmentManager();

        Fragment fragment = fm.findFragmentById(R.id.fragmentContainerLogin);
        if (fragment != null) {
            fm.beginTransaction()
            .remove(fragment)
            .commit();

        }
    }

    public void CreateUserClick(View view) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        RegistrationFragment registrationFragment = new RegistrationFragment();

        fm.beginTransaction()
                .add(R.id.fragmentContainerLogin, registrationFragment)
                .addToBackStack(null)
                .commit();
    }

    public void restoreClick(View view) {
        FragmentManager fm = getActivity().getSupportFragmentManager();

        ForgotPasswordFragment forgotPasswordFragment = new ForgotPasswordFragment();
        fm.beginTransaction()
                .add(R.id.fragmentContainerLogin, forgotPasswordFragment)
                .addToBackStack(null)
                .commit();
    }
}