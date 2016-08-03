package me.goodi.criminalintent2;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by NAVER on 16. 7. 29..
 */
public class TimePickerFragment extends PickerDialogFragment {

    private TimePicker mTimePicker;
    private Button mPositiveButton;

    public static TimePickerFragment newInstance(Date date) {
        Bundle args = getArgs(date);
        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);

        return fragment;
    }

    protected View initLayout() {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_time, null);

        mTimePicker = (TimePicker) v.findViewById(R.id.dialog_time_picker);
        if (Build.VERSION.SDK_INT >= 23) {
            mTimePicker.setHour(mCalendar.get(Calendar.HOUR));
            mTimePicker.setHour(mCalendar.get(Calendar.MINUTE));
        } else {
            mTimePicker.setCurrentHour(mCalendar.get(Calendar.HOUR));
            mTimePicker.setCurrentMinute(mCalendar.get(Calendar.MINUTE));
        }

        mPositiveButton = (Button) v.findViewById(R.id.dialog_time_picker_button);
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
        int year = mCalendar.get(Calendar.YEAR);
        int month = mCalendar.get(Calendar.MONTH);
        int day = mCalendar.get(Calendar.DAY_OF_MONTH);
        int hour, minute;

        if (Build.VERSION.SDK_INT >= 23) {
            hour = mTimePicker.getHour();
            minute = mTimePicker.getMinute();
        } else {
            hour = mTimePicker.getCurrentHour();
            minute = mTimePicker.getCurrentMinute();
        }

        return new GregorianCalendar(year, month, day, hour, minute).getTime();
    }
}
