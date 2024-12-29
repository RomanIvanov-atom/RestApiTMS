package tests.api;

import adapters.ProjectAPI;
import models.qase.CreateProjectRq;
import models.qase.CreateProjectRs;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectTest {

    @Test
    public void checkCreateProject() {
        CreateProjectRq rq = CreateProjectRq.builder()
                .title("QA Test")
                .code("QA")
                .description("Test description")
                .build();

        CreateProjectRs rs = new ProjectAPI().createProject(rq);
        Assert.assertEquals(rs.getStatus(), true);
        Assert.assertEquals(rs.getResult().getCode(), "QA");

        new ProjectAPI().getProject(rs.getResult().getCode());

        new ProjectAPI().deleteProject("QA");
    }
}
