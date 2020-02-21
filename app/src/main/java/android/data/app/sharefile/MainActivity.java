package android.data.app.sharefile;

import android.content.BroadcastReceiver;
import android.data.app.sharefile.adaptors.CurrentAdaptor;
import android.data.app.sharefile.viewmodels.MainViewModel;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_current, rv_old;
    CurrentAdaptor currentAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rv_current = findViewById(R.id._available_recycler);
        rv_old = findViewById(R.id._old_recycler);
        currentAdaptor = new CurrentAdaptor(this);
        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        rv_current.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        rv_current.setHasFixedSize(true);
        rv_current.setAdapter(currentAdaptor);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}
