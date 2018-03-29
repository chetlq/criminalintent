package criminalintent.android.bignerdranch.com.criminalintent;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by admin on 16.03.2018.
 */

public class CrimeListFragment extends Fragment {
    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;
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
        return view;
    }

    private void updateUI() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();
        mAdapter = new CrimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mAdapter);
    }



    private class CrimeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

//        private class CrimeHolder1 extends RecyclerView.ViewHolder implements View.OnClickListener{
//            private Crime mCrime;
//            private TextView mTitleTextView;
//            private TextView mDateTextView;
//            public CrimeHolder1( LayoutInflater inflater, ViewGroup parent ) {
//                super( inflater.inflate( R.layout.list_item_crime, parent, false ) );
//                itemView.setOnClickListener(this);
//                mTitleTextView = (TextView) itemView.findViewById( R.id.crime_title );
//                mDateTextView = (TextView) itemView.findViewById( R.id.crime_date );
//            }
//
//            public void bind(Crime crime) {
//                mCrime = crime;
//                mTitleTextView.setText( mCrime.getTitle() );
//                mDateTextView.setText( mCrime.getDate().toString() );
//            }
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(),
//                        mCrime.getTitle() + " clicked1!", Toast.LENGTH_SHORT)
//                        .show();
//            }
//
//        }


        private class CrimeHolder1 extends  CrimeHolder{


            public CrimeHolder1(LayoutInflater inflater, ViewGroup parent ) {
                super( inflater, parent);
            }

            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),
                        mCrime.getTitle() + " clicked1!", Toast.LENGTH_SHORT)
                        .show();
            }

        }
        private class CrimeHolder2 extends  CrimeHolder{


            public CrimeHolder2(LayoutInflater inflater, ViewGroup parent ) {
                super( inflater, parent);
            }

            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),
                        mCrime.getTitle() + " clicked2!", Toast.LENGTH_SHORT)
                        .show();
            }

        }

        private List<Crime> mCrimes;
        public CrimeAdapter(List<Crime> crimes) {
            mCrimes = crimes;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from( getActivity() );
            layoutInflater.inflate( R.layout.list_item_crime, parent, false  );
            switch (viewType) {
            case 0:
            return new CrimeHolder1( layoutInflater, parent );
            case 2:
            return new CrimeHolder2( layoutInflater, parent );
            default:return null;
        }
//            return new CrimeHolder(layoutInflater, parent);

        }


        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
            Crime crime = mCrimes.get(position);
            switch (holder.getItemViewType()) {
                case 0:
                    CrimeHolder1 viewHolder1 = (CrimeHolder1)holder;

                    viewHolder1.bind( crime );

                    break;

                case 2:
                    CrimeHolder2 viewHolder2 = (CrimeHolder2)holder;

                    viewHolder2.bind( crime );
                    break;
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
            return position % 2 * 2;
        }
    }
}
