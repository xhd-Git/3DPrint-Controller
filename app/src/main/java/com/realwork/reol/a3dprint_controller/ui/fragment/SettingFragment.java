package com.realwork.reol.a3dprint_controller.ui.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.realwork.reol.a3dprint_controller.R;
import com.realwork.reol.a3dprint_controller.ui.VersionInfoAct;

/** 设置页内容
 * Created by reol on 2017/4/12.
 */

public class SettingFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener, Preference.OnPreferenceClickListener {
    private static final String ONLY_WIFI = "only_wifi";
    private static final String AUTO_LOAD = "auto_load";
    private static final String DOWNLOAD_NO_WIFI = "download_no_wifi";
    private static final String CACHE_MAX = "cache_max";
    private static final String CLEAR_CACHE = "clear_cache";
    private static final String AUTO_CLEAR_CACHE = "auto_clear_cache";
    private static final String CHECK_UPDATE = "check_update";
    private static final String VERSION_INFO = "version_info";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        PreferenceManager manager = getPreferenceManager();

        Preference versionInfo = findPreference(VERSION_INFO);
        Preference clearCache = findPreference(CLEAR_CACHE);
        Preference checkUpdate = findPreference(CHECK_UPDATE);
        versionInfo.setOnPreferenceClickListener(this);
        clearCache.setOnPreferenceClickListener(this);
        checkUpdate.setOnPreferenceClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    //改变-处理
    @Override
    public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
        switch (key) {
            case ONLY_WIFI:
                Toast.makeText(getActivity(), String.valueOf(prefs.getBoolean(ONLY_WIFI,true)), Toast.LENGTH_SHORT).show();
                break;
            case AUTO_LOAD:
                Toast.makeText(getActivity(), String.valueOf(prefs.getBoolean(AUTO_LOAD,true)), Toast.LENGTH_SHORT).show();
                break;
            case DOWNLOAD_NO_WIFI:
                Toast.makeText(getActivity(), String.valueOf(prefs.getBoolean(DOWNLOAD_NO_WIFI,true)), Toast.LENGTH_SHORT).show();
                break;
            case CACHE_MAX:
                String str = prefs.getString(CACHE_MAX,"256");
                findPreference(CACHE_MAX).setSummary(str);
                break;
            case AUTO_CLEAR_CACHE:
                Toast.makeText(getActivity(), String.valueOf(prefs.getBoolean(AUTO_CLEAR_CACHE,true)), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //点击-处理
    @Override
    public boolean onPreferenceClick(Preference preference) {
        switch (preference.getKey()) {

            case CACHE_MAX:
                break;
            case CLEAR_CACHE:
                Toast.makeText(getActivity(), "clear cache", Toast.LENGTH_SHORT).show();
                break;
            case CHECK_UPDATE:
                Toast.makeText(getActivity(), "check update", Toast.LENGTH_SHORT).show();
                break;
            case VERSION_INFO:
                startActivity(new Intent(getActivity(), VersionInfoAct.class));
                break;

            default:
                return false;
        }
        return true;
    }
}
