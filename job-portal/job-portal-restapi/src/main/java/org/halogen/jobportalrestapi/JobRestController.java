package org.halogen.jobportalrestapi;

import org.halogen.jobportalrestapi.Model.JobPost;
import org.halogen.jobportalrestapi.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
    @Autowired
    JobService jobService;

    @GetMapping({"/", "home"})
    public String home() {
        return "home";
    }

    @GetMapping("/jobposts")
    public List<JobPost> getJobPosts(){
        return jobService.getJobPosts();
    }

    @GetMapping("/jobpost/{id}")
    public JobPost getJobPost(@PathVariable("id") int id){
        return jobService.getJobPost(id);
    }

    @PostMapping("/jobposts")
    public JobPost createJobPost(@RequestBody JobPost jobPost){
        jobService.addJobPost(jobPost);
        return jobService.getJobPost(jobPost.getPostId());
    }

     @PutMapping("/jobpost/edit/{id}")
     public JobPost updatejobPost(@RequestBody JobPost jobPost, @PathVariable("id") int id){
         jobService.editJobPost(jobPost);
        return jobService.getJobPost(id);
     }

    @DeleteMapping("/deletejobpost/{id}")
    public void deleteJobPost(@PathVariable("id") int id){
        jobService.deleteJobPost(id);
    }

    @GetMapping("/load")
    public String load(){
        jobService.load();
        return "success";
    }

    @GetMapping("/jobposts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword) {
        return jobService.search(keyword);
    }
}
