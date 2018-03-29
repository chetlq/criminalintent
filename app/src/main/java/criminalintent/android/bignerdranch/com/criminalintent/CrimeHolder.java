package criminalintent.android.bignerdranch.com.criminalintent;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by admin on 27.03.2018.
 */

public abstract class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener,Bindable<Crime>,SuperCrimeHolder<Integer> {
    protected Crime mCrime;
    protected TextView mTitleTextView;
    protected TextView mDateTextView;


    public CrimeHolder(LayoutInflater inflater, View itemView) {
        super( itemView );
        itemView.setOnClickListener(this);
        mTitleTextView = (TextView) itemView.findViewById( R.id.crime_title );
        mDateTextView = (TextView) itemView.findViewById( R.id.crime_date );
    }

    @Override
    public void bind(Crime crime) {
        mCrime = crime;
        mTitleTextView.setText( mCrime.getTitle() );
        mDateTextView.setText( mCrime.getDate().toString() );
    }

    @Override
    public void setLayout(Integer layout) {

    }

    abstract public void onClick(View view) ;


}
