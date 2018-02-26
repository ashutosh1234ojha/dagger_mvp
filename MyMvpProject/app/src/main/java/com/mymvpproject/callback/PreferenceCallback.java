package com.mymvpproject.callback;

import java.util.List;

/**
 * Created by Ashutosh Ojha on 10/31/17.
 */

public interface PreferenceCallback {

    void setPreference(List<String> preferenceName, List<String> preferenceId, int position);
}
