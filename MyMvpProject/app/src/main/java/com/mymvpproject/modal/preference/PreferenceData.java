package com.mymvpproject.modal.preference;

import java.util.List;

/**
 * Created by mcgreen on 10/7/17.
 */

public class PreferenceData {

    private List<PreferenceRequestCauseObj> reqCausePref = null;

    public List<PreferenceRequestCauseObj> getReqCausePref() {
        return reqCausePref;
    }

    public void setReqCausePref(List<PreferenceRequestCauseObj> reqCausePref) {
        this.reqCausePref = reqCausePref;
    }
}
