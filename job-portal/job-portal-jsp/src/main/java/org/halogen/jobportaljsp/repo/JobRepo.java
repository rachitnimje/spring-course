package org.halogen.jobportaljsp.repo;

import org.halogen.jobportaljsp.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JobRepo {
    List<JobPost> jobPosts = new ArrayList<>();

    public List<JobPost> getJobPosts() {
        return jobPosts;
    }

    public void addJobPost(JobPost jobPost){
        jobPosts.add(jobPost);
    }
}
