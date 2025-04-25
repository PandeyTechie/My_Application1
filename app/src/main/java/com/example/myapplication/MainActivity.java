package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = findViewById(R.id.gridLayout);

        addButton("🌐 Open Website", () -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            startActivity(intent);
        });

        addButton("Dial Number", new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:1234567890"));
                startActivity(intent);
            }
        });


        addButton("📞 Call Number", () -> {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:1234567890"));
            startActivity(intent);
        });

        addButton("📧 Send Email", () -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:example@example.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
            intent.putExtra(Intent.EXTRA_TEXT, "Body text here...");
            startActivity(intent);
        });

        addButton("🖼️ Open Gallery", () -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivity(intent);
        });

        addButton("📷 Open Camera", () -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        });
    }

    private void addButton(String label, Runnable onClick) {
        Button button = new Button(this);
        button.setText(label);
        button.setOnClickListener(v -> onClick.run());
        gridLayout.addView(button);
    }
}
