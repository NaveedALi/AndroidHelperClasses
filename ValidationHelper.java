package com.naveed.samples;

import android.widget.EditText;

import com.naveed.samples.R;
import com.naveed.samples.application.AppClass;

public class ValidationHelper {


    public static boolean isEmailValid(EditText emailEdt, String error) {
        String email = emailEdt.getText().toString();
        if (!email.isEmpty() && RegexComparison.isValidEmail(email)) {
            return true;
        } else {
            if (error.isEmpty())
                emailEdt.setError(AppClass.getAppContext().getString(R.string.invalid_email));
            else emailEdt.setError(error);
            return false;
        }
    }

    public static boolean isPasswordValid(EditText editTextPass, String error, String minLengthError) {
        String password = editTextPass.getText().toString();
        if (password.isEmpty()) {
            if (error.isEmpty())
                editTextPass.setError(AppClass.getAppContext().getString(R.string.invalid_password));
            else editTextPass.setError(error);
            return false;
        } else if (password.length() < 3) {
            if (minLengthError.isEmpty())
                editTextPass.setError(AppClass.getAppContext().getString(R.string.min_length_error));
            else editTextPass.setError(minLengthError);
            return false;
        } else
            return true;
    }

    public static boolean isUserNameValid(EditText pUserNameEdt) {
        String userName = pUserNameEdt.getText().toString();
        if (userName.isEmpty() || userName.length() < 3) {
            pUserNameEdt.setError(AppClass.getAppContext().getString(R.string.invalid_name));
            return false;
        } else
            return true;
    }

    public static boolean isFullNameValid(EditText pFullNameEdt, int minlength) {
        String fullName = pFullNameEdt.getText().toString();
        if (fullName.isEmpty() || fullName.length() < minLength) {
            pFullNameEdt.setError(AppClass.getAppContext().getString(R.string.invalid_name));
            return false;
        } else
            return true;
    }

    public static boolean isContactValid(EditText pContactEdt) {
        String contact = pContactEdt.getText().toString();
        if (contact.isEmpty() || contact.length() < 10) {
            pContactEdt.setError(AppClass.getAppContext().getString(R.string.invalid_number));
            return false;
        } else
            return true;
    }


}
