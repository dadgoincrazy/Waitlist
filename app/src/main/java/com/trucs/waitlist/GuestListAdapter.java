package com.trucs.waitlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Cody on 1/17/2018.
 */

public class GuestListAdapter extends RecyclerView.Adapter<GuestListAdapter.GuestHolder> {
    private List<String> mGuestNames;
    private List<Integer> mGuestNum;
    private Context mContext;

    public GuestListAdapter(Context context, List<String> listNames, List<Integer> listNum) {
        this.mContext = context;
        this.mGuestNames = listNames;
        this.mGuestNum = listNum;
    }

    @Override
    public GuestHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.guest_item_list, parent, false);
        return new GuestHolder(view);
    }

    @Override
    public void onBindViewHolder(GuestHolder holder, int position){
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mGuestNames.size();
    }

    private void addItem(String name, Integer num){
        mGuestNames.add(name);
        mGuestNum.add(num);
    }

    private static final String TAG = GuestListAdapter.class.getSimpleName();

    class GuestHolder extends RecyclerView.ViewHolder {
        TextView guestName;
        TextView guestNum;

        public GuestHolder(View itemView) {
            super(itemView);
            this.guestName = (TextView) itemView.findViewById(R.id.name_text_view);
            this.guestNum = (TextView) itemView.findViewById(R.id.party_size_text_view);
        }

        public void bind(int listIndex) {
            guestName.setText(String.valueOf(mGuestNames.get(listIndex)));
            guestNum.setText(String.valueOf(mGuestNum.get(listIndex)));
        }
    }
}