package com.example.myapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    public static String login_a = "";
    static TextView _login_a;
    EditText _txtphone, _txtcode;
    TextView  _lblcode,_txtrecharge, _txtconsult;
    Button _btnrecharge, _btnconsult;
    String code, cmd_envoi, code_envoi;
    ImageView _infoligne;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        _login_a = findViewById(R.id.login_a);
        _txtphone = findViewById(R.id.txt_phone);
        _txtcode = findViewById(R.id.txt_code);
        _txtrecharge = findViewById(R.id.txt_recharge);
        _txtconsult = findViewById(R.id.txt_consult);
        _btnrecharge = findViewById(R.id.btn_recharge);
        _btnconsult = findViewById(R.id.btn_consult);
        _infoligne = findViewById(R.id.img_infoligne);
        _lblcode = findViewById(R.id.lbl_code);


        Intent intent = getIntent();
        _login_a.setText(intent.getStringExtra(login_a));

        _txtphone.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean b) {
                if (!b) {
                    if (Integer.parseInt(_txtphone.getText().toString()) >= 90000000 &&
                            Integer.parseInt(_txtphone.getText().toString()) <= 99999999)
                    {
                        _lblcode.setText("Entrer votre code de recharge: (13 chiffres)");
                        _txtconsult.setText("*122#");
                        _txtrecharge.setBackgroundResource(R.drawable.blue2_fill_rounded);
                        _infoligne.setBackgroundResource(R.drawable.tt_logo);
                        _txtconsult.setBackgroundResource(R.drawable.blue2_fill_rounded);
                        _txtcode.addTextChangedListener(new TextWatcher() {

                            @Override
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            }

                            @Override
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                code = _txtcode.getText().toString();
                                _txtrecharge.setText("*123*" + code + "#");
                            }

                            @Override
                            public void afterTextChanged(Editable editable) {
                            }
                        });


                    } else if (Integer.parseInt(_txtphone.getText().toString()) >= 20000000 &&
                            Integer.parseInt(_txtphone.getText().toString()) <= 29999999) {
                        _lblcode.setText("Entrer votre code de recharge: (14 chiffres)");
                        _txtconsult.setText("*100#");
                        _txtrecharge.setBackgroundResource(R.drawable.red_fill_rounded);
                        _infoligne.setBackgroundResource(R.drawable.ooredoo_logo);
                        _txtconsult.setBackgroundResource(R.drawable.red_fill_rounded);
                        _txtcode.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            }

                            @Override
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                code = _txtcode.getText().toString();
                                _txtrecharge.setText("*101*" + code + "#");
                            }

                            @Override
                            public void afterTextChanged(Editable editable) {
                            }
                        });
                    } else if (Integer.parseInt(_txtphone.getText().toString()) >= 30000000 &&
                            Integer.parseInt(_txtphone.getText().toString()) <= 59999999) {
                        _lblcode.setText("Entrer votre code de recharge: (14 chiffres)");
                        _txtconsult.setText("*101#");
                        _txtrecharge.setBackgroundResource(R.drawable.orange_fill_rounded);
                        _infoligne.setBackgroundResource(R.drawable.oo);
                        _txtconsult.setBackgroundResource(R.drawable.orange_fill_rounded);
                        _txtcode.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            }

                            @Override
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                code = _txtcode.getText().toString();
                                _txtrecharge.setText("*100*" + code + "#");
                            }

                            @Override
                            public void afterTextChanged(Editable editable) {
                            }
                        });
                    } else if (TextUtils.isEmpty(_txtphone.getText())) {
                        Toast.makeText(MainActivity2.this, "Saisir un numéro !", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity2.this, "Vérifier votre saisie !", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        _btnrecharge.setOnClickListener(view -> {
            cmd_envoi =_txtrecharge.getText().toString();
            Intent i1 = new Intent(Intent.ACTION_DIAL);
            i1.setData(Uri.parse("tel:" + Uri.encode(cmd_envoi)));
            startActivity(i1);
        });
        _btnconsult.setOnClickListener(view -> {
            code_envoi = _txtconsult.getText().toString();
            Intent i2 = new Intent(Intent.ACTION_DIAL);
            i2.setData(Uri.parse("tel:" + Uri.encode(code_envoi)));
            startActivity(i2);
        });
    }
    }


