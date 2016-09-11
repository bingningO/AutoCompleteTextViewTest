package com.example.zhubingning.autocompletetextviewtest.View;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhubingning on 16/09/11.
 */
public class AutoCompleteAdapter<T> extends ArrayAdapter<T> implements Filterable {
    private List<T> listObjects;
    List<T> suggestions = new ArrayList<>();

    private Filter mFilter = new Filter(){
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();

            if(constraint != null) {
                suggestions.clear();
                for(T object : listObjects){
                    if(object.toString().toLowerCase().contains(constraint.toString().toLowerCase())){
                        suggestions.add(object);
                    }
                }

                filterResults.values = suggestions;
                filterResults.count = suggestions.size();
            }

            return filterResults;
        }

        @SuppressWarnings( "unchecked" )
        @Override
        protected void publishResults(CharSequence contraint, FilterResults results) {
            if(results == null){
                notifyDataSetInvalidated();
                return;
            }

            List<T> filteredList = (List<T>) results.values;
            if(results.count > 0) {
                clear();
                for (T filteredObject : filteredList) {
                    add(filteredObject);
                }
                notifyDataSetChanged();
            }
        }
    };

    public AutoCompleteAdapter(Context context, int resource, List<T> listObjects) {
        super(context, resource, listObjects);
        this.listObjects =new ArrayList<>( listObjects );
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }
}