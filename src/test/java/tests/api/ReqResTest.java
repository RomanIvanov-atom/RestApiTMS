package tests.api;

import adapters.ReqResAPI;
import models.qase.GetSingleUserRs;
import models.reqres.CreateSingleUserRq;
import models.reqres.CreateSingleUserRs;
import models.reqres.UpdateSingleUserRq;
import models.reqres.UpdateSingleUserRs;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReqResTest {

    @Test
    public void getSingleUserTest() {
        GetSingleUserRs rs = new ReqResAPI().getSingleUser();

        Assert.assertEquals(rs.getData().getId(), 2);
        Assert.assertEquals(rs.getData().getFirstName(), "Janet");
    }

    @Test
    public void createSingleUserTest() {
        CreateSingleUserRq rq = CreateSingleUserRq.builder()
                .name("morpheus")
                .job("leader")
                .build();

        CreateSingleUserRs rs = new ReqResAPI().createSingleUser(rq);
        Assert.assertEquals(rs.getName(), "morpheus");
        Assert.assertEquals(rs.getJob(), "leader");
    }

    @Test
    public void updateSingleUserTest() {
        UpdateSingleUserRq rq = UpdateSingleUserRq.builder()
                .name("morpheus")
                .job("zion resident")
                .build();

        UpdateSingleUserRs rs = new ReqResAPI().updateSingleUser(rq);
        Assert.assertEquals(rs.getName(), "morpheus");
        Assert.assertEquals(rs.getJob(), "zion resident");
    }

    @Test
    public void deleteSingleUserTest() {
        new ReqResAPI().deleteSingleUser();
    }
}
