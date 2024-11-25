package com.example.plazitapp;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        webView = findViewById(R.id.webviewd);

        // Configuración básica del WebView
        webView.setWebViewClient(new WebViewClient()); // Evita abrir navegador externo
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Habilita JavaScript si es necesario

        // Carga una URL
        webView.loadUrl("https://rsz1vwh6-443.use2.devtunnels.ms/plazitApp/user-login.php");
    }

    @Override
    public void onBackPressed() {
        // Si el WebView puede retroceder, ve hacia atrás
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            // Si no puede retroceder, cierra la actividad normalmente
            super.onBackPressed();
        }
    }
}
