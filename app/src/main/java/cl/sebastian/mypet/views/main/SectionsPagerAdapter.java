package cl.sebastian.mypet.views.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import cl.sebastian.mypet.ComplaintFragment;
import cl.sebastian.mypet.RegisterFragment;

/**
 * Created by Sebastián Mena on 03-08-2017.
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
                //return AdoptFragment.newInstance();
                return ListPetFragment.newInstance();
            case 1:
                return RegisterFragment.newInstance();
            case 2:
                return ComplaintFragment.newInstance();
            default:
                return RegisterFragment.newInstance();
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
                return "Mascotas en Adopción";
            case 1:
                return "Inscribir Mascota";
            case 2:
                return "Denuncia";
        }
        return null;
    }
}
