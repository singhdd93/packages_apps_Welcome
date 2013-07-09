/*
 * Copyright (C) 2013 Team Bridge
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pac.welcome;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class AboutActivity extends Activity {
    public static Context appContext;

    public static final String PREFS_NAME = "Welcome";
    public static final String ROM_VERSION = "rom_version";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        appContext = getApplicationContext();

        //ActionBar
        ActionBar actionbar = getActionBar();
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        ActionBar.Tab AboutTab = actionbar.newTab().setText(R.string.about_tab_title);
        ActionBar.Tab ChangelogTab = actionbar.newTab().setText(R.string.changelog_tab_title);
        ActionBar.Tab ContactTab = actionbar.newTab().setText(R.string.contact_tab_title);
        
        Fragment AboutFragment = new AboutFragment();
        Fragment ChangelogFragment = new ChangelogFragment();
        Fragment ContactFragment = new ContactFragment();

        AboutTab.setTabListener(new MyTabsListener(AboutFragment));
        ChangelogTab.setTabListener(new MyTabsListener(ChangelogFragment));
        ContactTab.setTabListener(new MyTabsListener(ContactFragment));

        actionbar.addTab(AboutTab);
        actionbar.addTab(ChangelogTab);
        actionbar.addTab(ContactTab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menuitem_exit:
                String romVersion = Utils.getRomVersion();

                SharedPreferences prefs = this.getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor prefEditor = prefs.edit();
                prefEditor.putString(ROM_VERSION, romVersion);
                prefEditor.commit();

                finish();
                return true;
        }
        return false;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("tab", getActionBar().getSelectedNavigationIndex());
    }
}

class MyTabsListener implements ActionBar.TabListener {
    public Fragment fragment;

    public MyTabsListener(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        // nothing
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        ft.replace(R.id.fragment_container, fragment);
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        ft.remove(fragment);
    }

}
