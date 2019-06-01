package io.github.towyou.towyou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Locale;

public class LanguageActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        String locale = getSharedPreferences(Utils.localePrefsName, MODE_PRIVATE).getString(Utils.localeKey, "");
        if (!"".equals(locale)) {
            updateLocaleAndContinue(new Locale(locale));
        }

        ListView languagesListView = findViewById(R.id.languages_list);
        final String[] languages = getResources().getStringArray(R.array.languages);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.language_list_item, R.id.language_name, languages);

        languagesListView.setAdapter(adapter);
        languagesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] locales = getResources().getStringArray(R.array.locales);
                getSharedPreferences(Utils.localePrefsName, MODE_PRIVATE).edit().putString(Utils.localeKey, locales[position]).apply();
                updateLocaleAndContinue(new Locale(locales[position]));
            }
        });
    }

    private void updateLocaleAndContinue(Locale locale) {
        Utils.updateLocale(LanguageActivity.this, locale);
        startActivity(new Intent(LanguageActivity.this, LoginActivity.class));
        finish();
    }
}
