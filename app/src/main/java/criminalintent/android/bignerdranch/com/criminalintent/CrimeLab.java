package criminalintent.android.bignerdranch.com.criminalintent;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by admin on 12.03.2018.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;
    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }
    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0); // Для каждого второго объекта
            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Crime> getCloneCrimes() {
        List<Crime> myCrimes;

        myCrimes = new ArrayList<Crime>(  );
        mCrimes.forEach( (value) -> {
            try {
                myCrimes.add( value.clone() );
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        } );
        return myCrimes;

    };

    public Crime getCrime(UUID id) {
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }
}
