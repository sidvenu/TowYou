package io.github.towyou.towyou;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;

import java.util.Locale;

final class Utils {
    final static String localeKey = "LOCALE";
    final static String localePrefsName = "LOCALE_PREFS";

    static Context updateLocale(Context context, Locale locale) {
        Locale.setDefault(locale);

        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return updateResourcesLocale(context, locale);
        }*/

        return updateResourcesLocaleLegacy(context, locale);
    }

    @TargetApi(Build.VERSION_CODES.N)
    private static Context updateResourcesLocale(Context context, Locale locale) {
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        return context.createConfigurationContext(configuration);
    }


    private static Context updateResourcesLocaleLegacy(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }
}
