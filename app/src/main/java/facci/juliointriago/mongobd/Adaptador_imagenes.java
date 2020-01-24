package facci.juliointriago.mongobd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import facci.juliointriago.mongobd.rest.model.Post;

public class Adaptador_imagenes extends RecyclerView.Adapter<Adaptador_imagenes.ViewHolderImagenes> {
    ArrayList<Post> listaImagenes;

    public Adaptador_imagenes(ArrayList<Post> listaImagenes) {
        this.listaImagenes = listaImagenes;
    }

    @NonNull
    @Override
    public Adaptador_imagenes.ViewHolderImagenes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        return new ViewHolderImagenes(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador_imagenes.ViewHolderImagenes holder, int position) {

        Picasso.get().load(listaImagenes.get(position).getUrlImage()).into(holder.imgLista);

        holder.descripcionLista.setText(listaImagenes.get(position).getDescription());


    }

    @Override
    public int getItemCount() {
        return listaImagenes.size();
    }

    public class ViewHolderImagenes extends RecyclerView.ViewHolder {

        ImageView imgLista;
        TextView descripcionLista;

        public ViewHolderImagenes(@NonNull View itemView) {
            super(itemView);

            imgLista = (ImageView)itemView.findViewById(R.id.imgLista);
            descripcionLista = (TextView)itemView.findViewById(R.id.descripcionLista);
        }
    }
}


