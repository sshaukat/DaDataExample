package com.example.sshaukat.dadataexample.dadata.api.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.sshaukat.dadataexample.R;
import com.example.sshaukat.dadataexample.dadata.api.DaDataApiService;
import com.example.sshaukat.dadataexample.dadata.api.DaDataRestClient;
import com.example.sshaukat.dadataexample.dadata.api.address.DaDataAddressRes;
import com.example.sshaukat.dadataexample.dadata.api.address.DaDataBodyReq;
import com.example.sshaukat.dadataexample.dadata.api.address.base.DaDataAddressSuggestion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class DaDataAutoCompleteAdapter extends BaseAdapter implements Filterable {

    private static final int MAX_RESULTS = 10;
    private Context context;
    private List<String> resultList = new ArrayList<>();

    public DaDataAutoCompleteAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return resultList == null ? 0 : resultList.size();
    }

    @Override
    public String getItem(int index) {
        if (resultList == null || resultList.size() <= index) {
            return "";
        }
        return resultList.get(index);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.simple_dropdown_item_one_line, parent, false);
        }
        ((TextView) convertView.findViewById(R.id.text)).setText(getItem(position));
        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                    List<String> list = findAddress(constraint.toString());

                    filterResults.values = list;
                    filterResults.count = list.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                //notifyDataSetChanged();
                if (results != null && results.count > 0) {
                    resultList = (List<String>) results.values;
                    notifyDataSetChanged();
                }
                else {
                    notifyDataSetInvalidated();
                }
            }
        };

        return filter;
    }

    private List<String> findAddress(String address) {
        List<String> result = new ArrayList<>();

        DaDataBodyReq req = new DaDataBodyReq(address, MAX_RESULTS);

        Call<DaDataAddressRes> call = DaDataRestClient.createService(DaDataApiService.class).getAddressSync(req);
        try {
            DaDataAddressRes res = call.clone().execute().body();
            if (res != null) {
                for (DaDataAddressSuggestion a : res.getSuggestions()) {
                    result.add(a.getValue());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
