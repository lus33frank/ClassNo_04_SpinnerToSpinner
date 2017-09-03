package tw.com.frankchang.houli.classno_04_spinnertospinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner sp1, sp2;
    TextView tvShow;
    String strCitys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviewer();
        //setSpinner();
        setSpinner(sp1, getResources().getStringArray(R.array.Citys));
    }

    void setSpinner(Spinner sp, String[] data){
        //使用：系統內建樣式
        /*ArrayAdapter<String> adt = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_spinner_item, data);
        adt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);*/

        //使用：使用者自訂樣式
        ArrayAdapter<String> adt = new ArrayAdapter<String>(
                MainActivity.this, R.layout.spinner_style, data);
        adt.setDropDownViewResource(R.layout.spinner_style);
        sp.setAdapter(adt);
    }

    /* 範例
    void setSpinner(){
        ArrayAdapter<String> adt = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.SubCity1));
        adt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adt);
    }
     */

    void findviewer(){
        sp1 = (Spinner)findViewById(R.id.spinner);
        sp1.setOnItemSelectedListener(SpinnerListener);

        sp2 = (Spinner)findViewById(R.id.spinner2);
        sp2.setOnItemSelectedListener(SpinnerListener);

        tvShow = (TextView)findViewById(R.id.textView);
    }

    AdapterView.OnItemSelectedListener SpinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //取選取的內容文字 方法一
            //String SelectText = ((TextView)view).getText().toString();

            //取選取的內容文字 方法二
            //String SelectText = parent.getItemAtPosition(position).toString();
            //Toast.makeText(MainActivity.this, SelectText, Toast.LENGTH_SHORT).show();

            if (parent.getId() == sp1.getId()){
                strCitys = parent.getItemAtPosition(position).toString();
                switch (position){
                    case 0:
                        setSpinner(sp2, getResources().getStringArray(R.array.SubCity1));
                        break;
                    case 1:
                        setSpinner(sp2, getResources().getStringArray(R.array.SubCity2));
                        break;
                    case 2:
                        setSpinner(sp2, getResources().getStringArray(R.array.SubCity3));
                        break;
                }
            }
            else{
                String strSubCitys = parent.getItemAtPosition(position).toString();
                tvShow.setText(strCitys + "-" + strSubCitys);
            }


        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}
