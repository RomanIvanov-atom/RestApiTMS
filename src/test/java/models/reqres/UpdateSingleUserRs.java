package models.reqres;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class UpdateSingleUserRs {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("job")
    @Expose
    private String job;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
}
