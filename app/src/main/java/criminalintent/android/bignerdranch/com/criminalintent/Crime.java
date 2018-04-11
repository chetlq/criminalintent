package criminalintent.android.bignerdranch.com.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by admin on 25.02.2018.
 */

public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Crime))
            return false;
        if (obj == null)
            return false;
        Crime entry = (Crime)obj;
        return mId.equals(entry.mId) &&
                mTitle.equals(entry.mTitle) &&
                mDate.equals(entry.mDate) &&
                mSolved == entry.mSolved ;
    }

    @Override
    public int hashCode() {
        int hash = 31;
        hash = hash*17 + mId.hashCode();
        hash = hash*17 + mTitle.hashCode();
        hash = hash*17 + mDate.hashCode();
        hash = hash*17 + (mSolved?1:0);
        return hash;
    }
}

