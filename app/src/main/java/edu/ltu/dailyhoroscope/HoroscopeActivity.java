//updated to add a fragment at the bottom of this activity
package edu.ltu.dailyhoroscope;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;

public class HoroscopeActivity extends AppCompatActivity {

    public static final String EXTRA_HOROSCOPENO = "horoscopeNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscope);

        //Get the horoscope from the intent
        int horoscopeNo = (Integer)getIntent().getExtras().get(EXTRA_HOROSCOPENO);
        Horoscope horoscope = Horoscope.horoscopes[horoscopeNo];
        HoroscopeText detailhoroscope = HoroscopeText.horoscopesummary[horoscopeNo];

        //Populate the horoscope name
        TextView name = (TextView)findViewById(R.id.name);
        name.setText(horoscope.getName());

        //Populate the horoscope description
        TextView description = (TextView)findViewById(R.id.description);
        description.setText(horoscope.getDescription());

        //Populate the horoscope symbol
        TextView symbol = (TextView)findViewById(R.id.symbol);
        symbol.setText(horoscope.getSymbol());

        //Populate the horoscope month
        TextView month = (TextView)findViewById(R.id.month);
        month.setText(horoscope.getMonth());

        BottomHoroscopeFragment bottomFragment = (BottomHoroscopeFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        bottomFragment.setSummaryText(detailhoroscope.getHoroscope());
     }
}