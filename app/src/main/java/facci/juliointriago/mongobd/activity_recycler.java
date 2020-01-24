package facci.juliointriago.mongobd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import facci.juliointriago.mongobd.rest.adapter.MarketAdapter;
import facci.juliointriago.mongobd.rest.model.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class activity_recycler extends AppCompatActivity {

    ArrayList<Post> listaImagenes;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        listaImagenes = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        mostrarImagenes();

    }

    private void mostrarImagenes() {
        MarketAdapter adapter = new MarketAdapter();
        Call<List<Post>> call = adapter.getPost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> lista = response.body();
                for (Post post: lista
                ) {
                    listaImagenes.add(post);
                }
                Adaptador_imagenes adaptador_imagenes = new Adaptador_imagenes(listaImagenes);
                recyclerView.setAdapter(adaptador_imagenes);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }
}