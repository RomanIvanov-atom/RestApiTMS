package models.qase;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import models.reqres.Support;
import models.reqres.Data;

@lombok.Data
public class GetSingleUserRs {

    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("support")
    @Expose
    private Support support;
}
