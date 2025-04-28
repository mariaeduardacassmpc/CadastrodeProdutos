package com.example.mariaeduardacarnauba;

import androidx.room.RoomDatabase;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import java.util.List;
import java.text.NumberFormat;
import java.util.Locale;

public class ListarProdutos extends AppCompatActivity {
    private TextView textListarProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_produto);

        textListarProdutos = findViewById(R.id.textListarProd);

        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(v -> voltarParaCadastroProd());

        ProductDatabase db = Room.databaseBuilder(getApplicationContext(),
                ProductDatabase.class, "product-database").allowMainThreadQueries().build();
        ProductDao productDao = db.productDao();

        List<Product> productList = productDao.getAllProducts();
        StringBuilder report = new StringBuilder();

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        for (Product product : productList) {
            report.append("Código: ").append(product.getCodProd()).append("\n")
                    .append("Produto: ").append(product.getNomeProd()).append("\n")
                    .append("Quantidade: ").append(product.getQtdEstoque()).append("\n")
                    .append("Preço: ").append(currencyFormat.format(product.getPreco())).append("\n\n");
        }

        if (productList.isEmpty()) {
            report.append("Nenhum produto cadastrado.");
        }

        textListarProdutos.setText(report.toString());


    }

    public void voltarParaCadastroProd() {
        Intent intent = new Intent(ListarProdutos.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}