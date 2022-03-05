package com.example.unithon.Home;

import static com.example.unithon.DummyData.currentUser;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.unithon.Model;
import com.example.unithon.R;

public class CustomDialog extends Dialog {
    private Context context;
    private EditText editText;
    private Button button;
    private Model.User user;
    private TextView mbtiTv;
    public CustomDialog(@NonNull Context context, TextView mbtiTv) {
        super(context);
        this.context = context;
        this.user = user;
        this.mbtiTv = mbtiTv;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);

        editText = findViewById(R.id.mbtiEditText);
        button = findViewById(R.id.mbtiCompleteBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newMBTI = String.valueOf(editText.getText());
                currentUser.setMbti(Enum.valueOf(Model.MBTI.class, newMBTI));
                System.out.println(currentUser.getMbti());
                mbtiTv.setText(currentUser.getMbti());
                dismiss();
            }
        });
    }
}
