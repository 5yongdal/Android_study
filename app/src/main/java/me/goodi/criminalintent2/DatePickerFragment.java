package me.goodi.criminalintent2;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by NAVER on 16. 8. 2..
 */
public class DatePickerFragment extends PickerDialogFragment {

    private DatePicker mDatePicker;
    private Button mPositiveButton;

    public static DatePickerFragment newInstance(Date date) {
        Bundle args = getArgs(date);

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);

        return fragment;
    }

    protected View initLayout() {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_date, null);

        mDatePicker = (DatePicker) v.findViewById(R.id.dialog_date_picker);
        mDatePicker.init(mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH), null);

        mPositiveButton = (Button) v.findViewById(R.id.dialog_date_picker_button);
        mPositiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date = getDate();
                sendResult(Activity.RESULT_OK, date);
            }
        });

        return v;
    }

    protected Date getDate() {
        final int year = mDatePicker.getYear();
        final int month = mDatePicker.getMonth();
        final int day = mDatePicker.getDayOfMonth();
        final int hour, minute;

        if (Build.VERSION.SDK_INT >= 23) {
            hour = mCalendar.get(Calendar.HOUR);
            minute = mCalendar.get(Calendar.MINUTE);
        } else {
            hour = mCalendar.get(Calendar.HOUR);
            minute = mCalendar.get(Calendar.MINUTE);
        }

        return new GregorianCalendar(year, month, day, hour, minute).getTime();
    }
}
