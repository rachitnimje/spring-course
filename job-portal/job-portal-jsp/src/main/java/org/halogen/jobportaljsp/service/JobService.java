package org.halogen.jobportaljsp.service;

import org.halogen.jobportaljsp.model.JobPost;
import org.halogen.jobportaljsp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepo repo;

    public void addJobPost(JobPost jobPost) {
        repo.addJobPost(jobPost);
    }

    public List<JobPost> getJobPosts() {
        return repo.getJobPosts();
    }
}
