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

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import android.content.res.Resources.NotFoundException;

public class AboutFragment extends Fragment {
    BufferedReader inputStream;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View aboutView = inflater.inflate(R.layout.about_fragment, container, false);

        TextView aboutText = (TextView) aboutView.findViewById(R.id.about);
        aboutText.setText(Utils.readRawFile(AboutActivity.appContext, R.raw.about_pac));

        // Inflate the layout for this fragment
        return aboutView;
    }
}
