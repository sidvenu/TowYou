package io.github.towyou.towyou;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mukesh.OnOtpCompletionListener;
import com.mukesh.OtpView;

public class OTPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        OtpView otpView = findViewById(R.id.otp_input);
        otpView.setOtpCompletionListener(new OnOtpCompletionListener() {
            @Override
            public void onOtpCompleted(String otp) {
                hideKeyboard();
            }
        });

        TextView verificationHelper = findViewById(R.id.verification_helper_text_view);
        verificationHelper.setText(getString(R.string.verification_helper_text, "+91 90000 00000"));

        findViewById(R.id.otp_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check if OTP is correct and login
            }
        });
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
