package kea.springstart.controller;

import kea.springstart.model.ModelDeveloper;
import kea.springstart.modelRepo.RepositoryDeveloper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    RepositoryDeveloper repositoryDeveloper;

    // Endpoint for at returnere alle udviklere som JSON-data
    @GetMapping("/developers")
    public List<ModelDeveloper> getAllDevelopers() {
        return repositoryDeveloper.findAll();
    }

    // Returner en specifik udvikler baseret på navn
    @GetMapping("/developer/{name}")
    public Optional<ModelDeveloper> getModelByName(@PathVariable String name) {
        return repositoryDeveloper.findByName(name);
    }

    // Endpoint til at tilføje en ny udvikler med navn, alder og billede
    @PostMapping("/developer/add")
    public ModelDeveloper addDeveloper(@RequestParam String name,
                                       @RequestParam int age,
                                       @RequestParam("image") MultipartFile imageFile) {
        ModelDeveloper modelDeveloper = new ModelDeveloper();
        modelDeveloper.setName(name);
        modelDeveloper.setAge(age);

        try {
            // Konverter billedfilen til byte-array og gem i modellen
            modelDeveloper.setImage(imageFile.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        repositoryDeveloper.save(modelDeveloper);
        return modelDeveloper;
    }
}
