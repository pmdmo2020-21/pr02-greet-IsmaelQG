package es.iessaladillo.pedrojoya.greet;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import es.iessaladillo.pedrojoya.greet.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity {

    private MainActivityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        image();
    }

    private void image(){
        binding.rdbTreatmentMr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.imgTreatment.setImageResource(R.drawable.ic_mr);
            }
        });

        binding.rdbTreatmentMrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.imgTreatment.setImageResource(R.drawable.ic_mrs);
            }
        });

        binding.rdbTreatmentMs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.imgTreatment.setImageResource(R.drawable.ic_ms);
            }
        });

    }

}