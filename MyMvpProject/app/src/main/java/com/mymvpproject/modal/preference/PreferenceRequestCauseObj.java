package com.mymvpproject.modal.preference;

/**
 * Created by mcgreen on 10/7/17.
 */

public class PreferenceRequestCauseObj {
    private int id;
    private String name;
    private boolean isChecked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(final boolean checked) {
        isChecked = checked;
    }
    public boolean getChecked() {
        return isChecked;
    }
}
