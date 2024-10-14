package com.mansur.docker_manager.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.mansur.docker_manager.services.DockerService;
import com.github.dockerjava.api.model.Container;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/containers")
public class DockerContainersController {
    private final DockerService dockerService;

    public DockerContainersController(DockerService dockerService) {
        this.dockerService = dockerService;
    }
    
    @GetMapping("")
    // public List<Container> listContainers(@RequestParam(required = false, defaultValue = "true") boolean showALL) {
    //     return dockerService.listContainers(showALL);
    // }

    public List<Container> listContainers(@RequestParam(required = false, defaultValue = "true") boolean showAll) {
        System.out.println("showAll: " + showAll);
        List<Container> containers = dockerService.listContainers(showAll);
        //System.out.println("Containers: " + containers);
        return containers;
    }

    @PostMapping("/{id}/start")
    public void stopContainer(@PathVariable String id) {
        //TODO: process POST request
        
        dockerService.startContainer(id);
    }

    @DeleteMapping("/{id}")
    public void deleteContainer(@PathVariable String id) {
        //TODO: process DELETE request

        dockerService.deleteContainer(id);
    }

    @PostMapping("")
    public void createContainer(@RequestParam String imageName) {
        //TODO: process POST request
        
        dockerService.createContainer(imageName);
    }
    
    

}
