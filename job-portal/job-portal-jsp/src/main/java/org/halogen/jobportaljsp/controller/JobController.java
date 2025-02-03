package org.halogen.jobportaljsp.controller;

import org.halogen.jobportaljsp.model.JobPost;
import org.halogen.jobportaljsp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping("/addjob")
    public String addJob() {
        return "addJob";
    }

    @GetMapping("/viewalljobs")
    public String viewAllJobs(Model model) {
        // take the list of jobs from service and add to the model
        List<JobPost> jobPosts = jobService.getJobPosts();
        model.addAttribute("jobPosts", jobPosts);
        return "viewAllJobs";
    }

    @PostMapping("/handleForm")
    public String handleAddJobForm(@ModelAttribute JobPost jobPost, Model model) {
        model.addAttribute("jobPost", jobPost);
        jobService.addJobPost(jobPost);
        return "success";
    }
}
