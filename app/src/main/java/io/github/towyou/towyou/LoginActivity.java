package io.github.towyou.towyou;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

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
                // TODO: Check if the email is verified or not
                boolean isEmailVerified = true;
                if (!isEmailVerified) {
                    Toast.makeText(LoginActivity.this, "Please verify your email address before proceeding", Toast.LENGTH_LONG).show();
                } else {
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                }

            }
        });
        findViewById(R.id.google_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // once google login is done, no verification will be needed
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }
        });
    }
}
