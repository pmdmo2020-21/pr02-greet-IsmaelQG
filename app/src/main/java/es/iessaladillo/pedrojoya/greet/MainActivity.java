package es.iessaladillo.pedrojoya.greet;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import es.iessaladillo.pedrojoya.greet.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity {

    private MainActivityBinding binding;
    private boolean premium;
    private String pronoun = "Mr. ";
    private boolean polite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        image();
        isPremium();
        isPolite();
        show();
    }

    private void isPremium(){
        binding.swtPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((CompoundButton)view).isChecked()){
                    premium=true;
                    visibility(8);
                }
                else{
                    premium=false;
                    visibility(0);
                }
            }
        });
    }

    private void visibility(int visibility){
        if(visibility == 8){
            binding.pgbCounter.setVisibility(View.GONE);
            binding.lblCounter.setVisibility(View.GONE);
        }
        else if(visibility == 0){
            binding.pgbCounter.setVisibility(View.VISIBLE);
            binding.lblCounter.setVisibility(View.VISIBLE);
        }
    }

    private void isPolite(){
        binding.chkPolitely.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((CompoundButton)view).isChecked()){
                    polite=true;
                }
                else{
                    polite=false;
                }
            }
        });

    }

    private void show(){
        binding.btnGreet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.txtName.getText().toString();
                String surname = binding.txtSurname.getText().toString();
                if(!name.isEmpty() && !surname.isEmpty()){
                    if (polite) {
                        binding.lblMessage.setText("Good morning " + pronoun + name + " " + surname + ". Pleased to meet you");
                    }
                    else{
                        binding.lblMessage.setText("Hello " + name + " " + surname + ". What's up?");
                    }
                }
            }
        });
    }


    private void image(){
        binding.rdbTreatmentMr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.imgTreatment.setImageResource(R.drawable.ic_mr);
                pronoun = "Mr. ";
            }
        });

        binding.rdbTreatmentMrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.imgTreatment.setImageResource(R.drawable.ic_mrs);
                pronoun = "Mrs. ";
            }
        });

        binding.rdbTreatmentMs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.imgTreatment.setImageResource(R.drawable.ic_ms);
                pronoun = "Ms. ";
            }
        });

    }

}