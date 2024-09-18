package kea.springstart.controller;

import kea.springstart.model.Model;
import kea.springstart.modelRepo.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    ModelRepository modelRepository;

    @GetMapping("/model/{name}")
    public Optional <Model>  getModelByName(@PathVariable String name) {
        return modelRepository.findByName(name);
    }

}
