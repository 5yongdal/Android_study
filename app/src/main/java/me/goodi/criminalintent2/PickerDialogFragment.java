package me.goodi.criminalintent2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by NAVER on 16. 8. 1..
 */
public abstract class PickerDialogFragment extends DialogFragment {
    private static final String ARG_DATE = "date";
    public static final String EXTRA_DATE = "me.goodi.criminalintent.date";

    protected Calendar mCalendar;

    protected abstract View initLayout();
    protected abstract Date getDate();

    protected static Bundle getArgs(Date date) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_DATE, date);

        return args;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Date date = (Date) getArguments().getSerializable(ARG_DATE);
        mCalendar = Calendar.getInstance();
        mCalendar.setTime(date);

        View v = initLayout();

        return v;
    }

    protected void sendResult(int resultCode, Date date) {
        if (getTargetFragment() == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(EXTRA_DATE, date);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
        getActivity().finish();
    }
}
