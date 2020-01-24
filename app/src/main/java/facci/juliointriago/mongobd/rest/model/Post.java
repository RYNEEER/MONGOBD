package facci.juliointriago.mongobd.rest.model;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("title")
    private String Title;

    @SerializedName("description")
    private String Description;

    @SerializedName("url_image")
    private String UrlImage;

    public Post(String title, String description, String urlImage) {
        Title = title;
        Description = description;
        UrlImage = urlImage;
    }

    public String getTitle() {return Title;}

    public String getDescription() {return Description;}

    public String getUrlImage() {return UrlImage;}

}


