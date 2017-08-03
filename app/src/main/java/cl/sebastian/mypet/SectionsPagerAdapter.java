package cl.sebastian.mypet;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by LUIS on 03-08-2017.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

//        @Override
//        public Fragment getItem(int position) {
//            // getItem is called to instantiate the fragment for the given page.
//            // Return a PlaceholderFragment (defined as a static inner class below).
//            return PlaceholderFragment.newInstance(position + 1);
//        }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return Register.newInstance();
            case 1:
                return Adopt.newInstance();
            case 2:
                return Complaint.newInstance();
            default:
                return Register.newInstance();
        }
    }


    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Registrar Mascota";
            case 1:
                return "Adoptar Mascota";
            case 2:
                return "Denuncia";
        }
        return null;
    }
}
