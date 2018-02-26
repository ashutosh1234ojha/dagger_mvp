package com.mymvpproject.requestcause;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.mymvpproject.R;
import com.mymvpproject.callback.PreferenceCallback;
import com.mymvpproject.modal.preference.PreferenceRequestCauseObj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashutosh Ojha on 10/30/17.
 */

public class RequestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<PreferenceRequestCauseObj> list;
    private PreferenceCallback preferenceCallback;
    private List<String> preferenceNameList, preferenceIdList;

    public RequestAdapter(final PreferenceCallback preferenceCallback) {
        this.preferenceCallback = preferenceCallback;
        preferenceNameList = new ArrayList<>();
        preferenceIdList = new ArrayList<>();


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {

        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list_request, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {


        MyViewHolder myViewHolder = (MyViewHolder) holder;
        final int adapterPosition = myViewHolder.getAdapterPosition();

        myViewHolder.cbRequestCause.setText(list.get(adapterPosition).getName());

        if (list.get(adapterPosition).getChecked()) {
            myViewHolder.cbRequestCause.setChecked(true);
        } else {
            myViewHolder.cbRequestCause.setChecked(false);
        }


        myViewHolder.cbRequestCause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final boolean isChecked = list.get(adapterPosition).getChecked();
                final String name = list.get(adapterPosition).getName();
                final int id = list.get(adapterPosition).getId();

                if (isChecked) {
                    list.get(adapterPosition).setChecked(false);
                    preferenceNameList.remove(name);
                    preferenceIdList.remove(id + "");


                } else {
                    list.get(adapterPosition).setChecked(true);
                    preferenceNameList.add(name);
                    preferenceIdList.add(id + "");
                }
                preferenceCallback.setPreference(preferenceNameList, preferenceIdList, adapterPosition);
            }
        });
    }

    public void setData(List<PreferenceRequestCauseObj> preferenceDatas) {

        if (list != null) {
            list.clear();
        }
        list = preferenceDatas;
        preferenceNameList.clear();
        preferenceIdList.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements ItemView {

        private CheckBox cbRequestCause;

        public MyViewHolder(final View itemView) {
            super(itemView);

            cbRequestCause = itemView.findViewById(R.id.cbRequestCause);
        }

        @Override
        public void setPreferenceName(final String preferenceName) {
            cbRequestCause.setText(preferenceName);
        }
    }
}
