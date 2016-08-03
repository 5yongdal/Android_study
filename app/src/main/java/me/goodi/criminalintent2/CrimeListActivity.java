package me.goodi.criminalintent2;

import android.support.v4.app.Fragment;

/**
 * Created by NAVER on 16. 7. 19..
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
