package criminalintent.android.bignerdranch.com.criminalintent;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 16.03.2018.
 */

public class CrimeListFragment extends Fragment {
    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;
    private int position;
    private static final String TAG = "MyActivity";
    private static List<Crime> mCrimesCopy;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container,
                false);
        mCrimeRecyclerView = (RecyclerView) view
                .findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager
                (getActivity()));
        updateUI();
        Log.i(TAG, "start" );
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "index=" + 1);

//            Log.i(TAG, "index=" + 2);
            CrimeLab crimeLab = CrimeLab.get(getActivity());
            List<Crime> crimes = crimeLab.getCrimes();
            //mAdapter.notifyItemChanged( 0 );
            mAdapter.updateList( crimes );


    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateUI( ) {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCloneCrimes();
        if (mAdapter == null) {
        mAdapter = new CrimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mAdapter);
        } else {
                mAdapter.notifyDataSetChanged();
        }
    }

//    private void updateUI2(int position ) {
//        //CrimeDiffutilCallback crimeDiffutilCallback = new CrimeDiffutilCallback(mAdapter. )
//
//        mAdapter.notifyItemChanged(position);
//    }

    private class CrimeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private final List<Crime> mCrimes;
        public CrimeAdapter(List<Crime> crimes) {mCrimes = new ArrayList<Crime>(crimes  ) ;}

        private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            private Crime mCrime;
            private TextView mTitleTextView;
            private TextView mDateTextView;
            private ImageView mSolvedImageView;
            public CrimeHolder( LayoutInflater inflater, ViewGroup parent ) {
                super( inflater.inflate( R.layout.list_item_crime, parent, false ) );
                itemView.setOnClickListener(this);
                mTitleTextView = (TextView) itemView.findViewById( R.id.crime_title );
                mDateTextView = (TextView) itemView.findViewById( R.id.crime_date );
                mSolvedImageView = (ImageView) itemView.findViewById(R.id.crime_solved);
            }

            public void bind(Crime crime) {
                mCrime = crime;
                mTitleTextView.setText( mCrime.getTitle() );
                mDateTextView.setText( mCrime.getDate().toString() );
                mSolvedImageView.setVisibility((crime.isSolved() ? View.VISIBLE :
                        View.GONE));
            }
            @Override
            public void onClick(View view) {
//                if (mCrimesCopy == null) {
//                    CrimeLab crimeLab3 = CrimeLab.get(getActivity());
//                    mCrimesCopy = new ArrayList <Crime>(crimeLab3.getCrimes2());
//
//
//                }
//                boolean bool = mCrimesCopy.equals( mCrimes );

                Intent intent = CrimeActivity.newIntent(getActivity(), mCrime.getId());
                startActivity(intent);
            }

        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from( getActivity() );

            switch (viewType) {

                default: return new CrimeHolder( layoutInflater, parent );
            }

        }


        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
            Crime crime = mCrimes.get(position);
            switch (holder.getItemViewType()) {
                default:
                    CrimeHolder viewHolder1 = (CrimeHolder)holder;
                    viewHolder1.bind( crime );
                    break;
            }

        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }

        @Override
        public int getItemViewType(int position) {
            return position % 2;
        }


        public void updateList(final List<Crime> newCrimes) {
            final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new CrimeDiffutilCallback(mCrimes, newCrimes));
            diffResult.dispatchUpdatesTo(this  );
        }
    }
}
