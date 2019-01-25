package example.com.prince.fragment1;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFrag extends ListFragment {

    ItemSelected activity;

    public interface ItemSelected
    {
        void onItemSelected(int index);
    }

    public ListFrag() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activity = (ItemSelected) context;//context will refer to MainActivity
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String [] data = getResources().getStringArray(R.array.pieces);
//        data.add("1. This is item 1");
//        data.add("2. This is item 2");
//        data.add("3. This is item 3");

        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data));
       // activity.onItemSelected(0);
        //phone is landscape in mode.
        if(this.getActivity().findViewById(R.id.layout_portrait) == null){
            activity.onItemSelected(0);
        }

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
       // super.onListItemClick(l, v, position, id);
        activity.onItemSelected(position);
    }
}
