package io.github.towyou.towyou;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void attachBaseContext(Context newBase) {
        String locale = newBase.getSharedPreferences(Utils.localePrefsName, MODE_PRIVATE).getString(Utils.localeKey, "");
        Log.v("TAG", "Prefs: " + locale);
        //Utils.updateLocale(newBase.getApplicationContext(), new Locale(locale));
        super.attachBaseContext(Utils.updateLocale(newBase, new Locale(locale)));
    }
}
