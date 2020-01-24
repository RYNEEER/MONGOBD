package facci.juliointriago.mongobd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import facci.juliointriago.mongobd.rest.adapter.MarketAdapter;
import facci.juliointriago.mongobd.rest.model.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText editTexttitulo, editTextDescriptcion;
    Button buttonPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTexttitulo = findViewById(R.id.TextTitle);
        editTextDescriptcion = findViewById(R.id.TextDescription);
        buttonPost = findViewById(R.id.ButtonPost);

        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostPosts();
                Intent i = new Intent(MainActivity.this, activity_recycler.class);
                startActivity(i);
            }
        });
    }


    private void PostPosts() {
        MarketAdapter adapter = new MarketAdapter();
        Call<Post> call = adapter.InsertPost(new Post(editTexttitulo.getText().toString(), editTextDescriptcion.getText().toString(),
                        "http://www.edvill.com/wp-content/uploads/2012/10/Angus-Young-EdVill.png"
                )
        );
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Log.e("response", response.body().toString());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }
}