package br.com.next.dataexplorer.controller;

import br.com.next.dataexplorer.modeldto.ModelDto;
import br.com.next.dataexplorer.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/main")
public class MainController {

    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @PostMapping("/savedata")
    public ResponseEntity save(@RequestBody ModelDto modelDto) {
        mainService.saveModel(modelDto);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/findall")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(mainService.findAll());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity findAll(@PathVariable("id") Long id) {

        Optional<ModelDto> modelDto = Optional.ofNullable(mainService.find(id));

        if (modelDto.isPresent()) {
            return ResponseEntity.ok(modelDto.get());
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping("/deletedata/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {

        boolean deleted = mainService.delete(id);

        if (deleted) {
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.notFound().build();

    }

}
