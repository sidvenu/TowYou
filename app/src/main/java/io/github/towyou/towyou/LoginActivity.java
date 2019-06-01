package io.github.towyou.towyou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.google.android.gms.common.SignInButton;

public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SignInButton signInButton = findViewById(R.id.google_login);
        signInButton.setSize(SignInButton.SIZE_WIDE);

        findViewById(R.id.login_card_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Check if it is a phone number or an email, and go to the respective screen
                startActivity(new Intent(LoginActivity.this, OTPActivity.class));
            }
        });
        findViewById(R.id.facebook_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.google_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.twitter_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
