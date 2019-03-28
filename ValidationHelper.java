package com.usepace.android.rider.utils;

import android.widget.EditText;

import com.usepace.android.rider.R;
import com.usepace.android.rider.application.RiderApplication;

public class ValidationHelper {


    public static boolean isEmailValid(EditText emailEdt, String error) {
        String email = emailEdt.getText().toString();
        if (!email.isEmpty() && RegexComparison.isValidEmail(email)) {
            return true;
        } else {
            if (error.isEmpty())
                emailEdt.setError(RiderApplication.getAppContext().getString(R.string.invalid_email));
            else emailEdt.setError(error);
            return false;
        }
    }

    public static boolean isPasswordValid(EditText editTextPass, String error, String minLengthError) {
        String password = editTextPass.getText().toString();
        if (password.isEmpty()) {
            if (error.isEmpty())
                editTextPass.setError(RiderApplication.getAppContext().getString(R.string.invalid_password));
            else editTextPass.setError(error);
            return false;
        } else if (password.length() < 3) {
            if (minLengthError.isEmpty())
                editTextPass.setError(RiderApplication.getAppContext().getString(R.string.min_length_error));
            else editTextPass.setError(minLengthError);
            return false;
        } else
            return true;
    }

    public static boolean isUserNameValid(EditText pUserNameEdt) {
        String userName = pUserNameEdt.getText().toString();
        if (userName.isEmpty() || userName.length() < 3) {
            pUserNameEdt.setError(RiderApplication.getAppContext().getString(R.string.invalid_name));
            return false;
        } else
            return true;
    }

    public static boolean isFullNameValid(EditText pFullNameEdt) {
        String fullName = pFullNameEdt.getText().toString();
        if (fullName.isEmpty() || fullName.length() < 3) {
            pFullNameEdt.setError(RiderApplication.getAppContext().getString(R.string.invalid_name));
            return false;
        } else
            return true;
    }

    public static boolean isContactValid(EditText pContactEdt) {
        String contact = pContactEdt.getText().toString();
        if (contact.isEmpty() || contact.length() < 10) {
            pContactEdt.setError(RiderApplication.getAppContext().getString(R.string.invalid_number));
            return false;
        } else
            return true;
    }


}