package criminalintent.android.bignerdranch.com.criminalintent;

import android.content.Context;

/**
 * Created by admin on 12.03.2018.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }
    private CrimeLab(Context context) {
    }
}
