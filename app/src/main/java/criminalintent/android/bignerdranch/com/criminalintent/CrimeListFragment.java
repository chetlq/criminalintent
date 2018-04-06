package criminalintent.android.bignerdranch.com.criminalintent;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by admin on 16.03.2018.
 */

public class CrimeListFragment extends Fragment {
    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;
    private int position;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container,
                false);
        mCrimeRecyclerView = (RecyclerView) view
                .findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager
                (getActivity()));
        updateUI(null);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI(null);
    }

    private void updateUI(int position) {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();
        if (mAdapter == null) {
        mAdapter = new CrimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mAdapter);
        } else {

//            if(null == position){
//                mAdapter.notifyDataSetChanged();
//            }
//            //
//            else {
                mAdapter.notifyItemChanged(position);
//            }
        }
    }



    private class CrimeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private class CrimeHolder1 extends RecyclerView.ViewHolder implements View.OnClickListener{
            private Crime mCrime;
            private TextView mTitleTextView;
            private TextView mDateTextView;
            private ImageView mSolvedImageView;
            public CrimeHolder1( LayoutInflater inflater, ViewGroup parent ) {
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
                Intent intent = CrimeActivity.newIntent(getActivity(), mCrime.getId());
                startActivity(intent);
            }

        }


//        private class CrimeHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener{
//            private Crime mCrime;
//            private TextView mTitleTextView;
//            private TextView mDateTextView;
//            private ImageView mSolvedImageView;
//            public CrimeHolder2( LayoutInflater inflater, ViewGroup parent ) {
//                super( inflater.inflate( R.layout.list_item_crime, parent, false ) );
//                itemView.setOnClickListener(this);
//                mTitleTextView = (TextView) itemView.findViewById( R.id.crime_title );
//                mDateTextView = (TextView) itemView.findViewById( R.id.crime_date );
//                mSolvedImageView = (ImageView) itemView.findViewById(R.id.crime_solved);
//            }
//
//            public void bind(Crime crime) {
//                mCrime = crime;
//                mTitleTextView.setText( mCrime.getTitle() );
//                mDateTextView.setText( mCrime.getDate().toString() );
//                mSolvedImageView.setVisibility(View.GONE);//(crime.isSolved() ? View.VISIBLE :
//                       // View.INVISIBLE);
//
//            }
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(),
//                        mCrime.getTitle() + " clicked1!", Toast.LENGTH_SHORT)
//                        .show();
//            }
//
//        }

//        private class CrimeHolder1 extends  CrimeHolder{
//
//
//            public CrimeHolder1(LayoutInflater inflater, ViewGroup parent ) {
//                super( inflater, parent);
//            }
//
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(),
//                        mCrime.getTitle() + " clicked1!", Toast.LENGTH_SHORT)
//                        .show();
//            }
//
//        }
//        private class CrimeHolder2 extends RecyclerView.ViewHolder {
//            private Crime mCrime;
//            private TextView mTitleTextView;
//            private TextView mDateTextView;
//
//            public CrimeHolder2(View itemView) {
//                super( itemView );
//
//            }
//            public void bind(Crime crime) {
//                mCrime = crime;
//                mTitleTextView.setText( mCrime.getTitle() );
//                mDateTextView.setText( mCrime.getDate().toString() );
//            }
//
//        }

        private List<Crime> mCrimes;
        public CrimeAdapter(List<Crime> crimes) {
            mCrimes = crimes;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from( getActivity() );
            View inflate = layoutInflater.inflate( R.layout.list_item_crime, parent, false );
            switch (viewType) {
//            case 0:
//            return new CrimeHolder1( layoutInflater, parent );
//            case 2:
//            return new CrimeHolder2( inflate );
//            default:return null;
                default: return new CrimeHolder1( layoutInflater, parent );
        }


        }


        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
            Crime crime = mCrimes.get(position);
            switch (holder.getItemViewType()) {
                default:
                    CrimeHolder1 viewHolder1 = (CrimeHolder1)holder;

                    viewHolder1.bind( crime );

                    break;
//
//                case 2:
//                    CrimeHolder2 viewHolder2 = (CrimeHolder2)holder;
//
//                    viewHolder2.bind( crime );
//                    break;
            }
//            Crime crime = mCrimes.get(position);
//            holder.bind(crime);

        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }

        @Override
        public int getItemViewType(int position) {
            return position % 2;
        }
    }
}
