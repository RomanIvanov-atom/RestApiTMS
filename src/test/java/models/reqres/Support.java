package models.reqres;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Support {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("text")
    @Expose
    private String text;
}
