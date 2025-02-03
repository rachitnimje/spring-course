package org.halogen.jobportalrestapi.Repository;

import org.halogen.jobportalrestapi.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepo extends JpaRepository<JobPost, Integer> {
    List<JobPost> findByPostProfileContainingOrPostDescContaining(String keyword, String keyword1);
}
