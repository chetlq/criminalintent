package criminalintent.android.bignerdranch.com.criminalintent;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by admin on 27.03.2018.
 */

public abstract class DataBinder <T extends RecyclerView.ViewHolder> {

    private DataBindAdapter mDataBindAdapter;

    public DataBinder(DataBindAdapter dataBindAdapter) {
        mDataBindAdapter = dataBindAdapter;
    }

    abstract public T newViewHolder(ViewGroup parent);

    abstract public void bindViewHolder(T holder, int position);

    abstract public int getItemCount();



}
