package org.halogen.jobportalrestapi.Service;

import org.halogen.jobportalrestapi.Model.JobPost;

import org.halogen.jobportalrestapi.Repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    JobRepo jobRepo;

//    public List<JobPost> getJobPosts() {
//        return jobRepo.getJobPosts();
//    }
//
//    public void addJobPost(JobPost jobPost) {
//        jobRepo.addJobPost(jobPost);
//    }
//
//    public JobPost getJobPost(int id) {
//        return jobRepo.getJobPost(id);
//    }
//
//    public JobPost deleteJobPost(int id) {
//        return jobRepo.deleteJobPost(id);
//    }
//
//    public void editJobPost(JobPost jobPost, int id) {
//        jobRepo.editJobPost(jobPost, id);
//    }

    public List<JobPost> getJobPosts(){
        return jobRepo.findAll();
    }

    public JobPost getJobPost(int id){
        Optional<JobPost> jobPost = jobRepo.findById(id);
        return jobPost.orElse(null);
    }

    public void addJobPost(JobPost jobPost){
        jobRepo.save(jobPost);
    }

    public void editJobPost(JobPost jobPost){
        jobRepo.save(jobPost);
    }

    public void deleteJobPost(int id){
        jobRepo.deleteById(id);
    }

    public void load() {
        List<JobPost> jobs =
                new ArrayList<>(List.of(
                        new JobPost(1, "Software Engineer", "Exciting opportunity for a skilled software engineer.", 3, List.of("Java", "Spring", "SQL")),
                        new JobPost(2, "Data Scientist", "Join our data science team and work on cutting-edge projects.", 5, List.of("Python", "Machine Learning", "TensorFlow")),
                        new JobPost(3, "Frontend Developer", "Create amazing user interfaces with our talented frontend team.", 2, List.of("JavaScript", "React", "CSS")),
                        new JobPost(4, "Network Engineer", "Design and maintain our robust network infrastructure.", 4, List.of("Cisco", "Routing", "Firewalls")),
                        new JobPost(5, "UX Designer", "Shape the user experience with your creative design skills.", 3, List.of("UI/UX Design", "Adobe XD", "Prototyping"))

                ));

        jobRepo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return jobRepo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
