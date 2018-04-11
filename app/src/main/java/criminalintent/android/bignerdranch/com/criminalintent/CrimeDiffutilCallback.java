package criminalintent.android.bignerdranch.com.criminalintent;


import android.support.v7.util.DiffUtil;

import java.util.List;

/**
 * Created by admin on 11.04.2018.
 */

public class CrimeDiffutilCallback extends DiffUtil.Callback {
    private final List<Crime> oldCrimes;
    private final List<Crime> newCrimes;

    public CrimeDiffutilCallback(List<Crime> oldCrimes, List<Crime> newCrimes) {
        this.oldCrimes = oldCrimes;
        this.newCrimes = newCrimes;
    }

    @Override
    public int getOldListSize() {
        return oldCrimes.size();
    }

    @Override
    public int getNewListSize() {
        return newCrimes.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Crime oldCrime = oldCrimes.get(oldItemPosition);
        Crime newCrime = newCrimes.get(newItemPosition);
        return oldCrime.getId() == newCrime.getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Crime oldCrime = oldCrimes.get(oldItemPosition);
        Crime newCrime = newCrimes.get(newItemPosition);
        return oldCrime.equals( newCrime ) ;
    }
}
