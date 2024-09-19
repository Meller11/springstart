package kea.springstart.controller;

import kea.springstart.model.ModelDeveloper;
import kea.springstart.modelRepo.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    ModelRepository modelRepository;

    @GetMapping("/developer/{name}")
    public Optional <ModelDeveloper>  getModelByName(@PathVariable String name) {
        return modelRepository.findByName(name);
    }

    @GetMapping("/developers")
    public List<ModelDeveloper> findAllModels() {
        return modelRepository.findAll();
    }

    @GetMapping("/developer/add")
    public ModelDeveloper addDeveloper(@RequestParam String name, @RequestParam int age) {
        ModelDeveloper modelDeveloper = new ModelDeveloper();
        modelDeveloper.setName(name);
        modelDeveloper.setAge(age);
        modelRepository.save(modelDeveloper);

        return modelDeveloper;
    }


}
