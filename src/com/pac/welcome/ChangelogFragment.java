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

public class ChangelogFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View changelogView = inflater.inflate(R.layout.changelog_fragment, container, false);

        TextView changelogVersion = (TextView) changelogView.findViewById(R.id.changelog_version);
        String version = Utils.getRomVersion();
        changelogVersion.append(" " + version);

        TextView changelogText = (TextView) changelogView.findViewById(R.id.changelog);
        changelogText.setText(Utils.readRawFile(AboutActivity.appContext, R.raw.changelog));

        // Inflate the layout for this fragment
        return changelogView;
    }
}
