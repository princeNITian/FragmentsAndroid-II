package example.com.prince.fragment1;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected{

    TextView tvDescription;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = findViewById(R.id.tvDescripton);

        descriptions = getResources().getStringArray(R.array.descriptions);
//        descriptions.add("Description for item 1.");
//        descriptions.add("Description for item 2.");
//        descriptions.add("Description for item 3.");
      // The phone is in portrait mode.
        if(findViewById(R.id.layout_portrait)!=null)
        {
            FragmentManager  manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }
        // The phone is in landscape mode.
        if(findViewById(R.id.layout_land)!=null)
        {
            FragmentManager  manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }
    }

    @Override
    public void onItemSelected(int index) {
        tvDescription.setText(descriptions[index]);
        //the phone is in portrait mode.
        if(findViewById(R.id.layout_portrait) != null)
        {
            FragmentManager  manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.listFrag))
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .addToBackStack(null)
                    .commit();
        }
        //the phone is in landscape mode.
        if(findViewById(R.id.layout_land) != null)
        {
            FragmentManager  manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.listFrag))
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
