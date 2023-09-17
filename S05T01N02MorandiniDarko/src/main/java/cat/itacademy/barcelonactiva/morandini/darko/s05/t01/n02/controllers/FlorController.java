package cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n02.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n02.model.dto.FlorDto;
import cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n02.services.FlorService;

@RestController
@RequestMapping("/flor")
public class FlorController {

    private final FlorService florService;

    @Autowired
    public FlorController(FlorService florService) {
        this.florService = florService;
    }

    @PostMapping("/add")
    public ResponseEntity<FlorDto> addFlor(@RequestBody FlorDto florDto) {
    	FlorDto savedFlor = florService.addFlor(florDto);
        return ResponseEntity.ok(savedFlor);
    }

    @PutMapping("/update")
    public ResponseEntity<Optional<FlorDto>> updateFlor(@RequestBody FlorDto florDto) {
        Optional<FlorDto> updatedFlor = florService.updateFlor(florDto);
        return ResponseEntity.ok(updatedFlor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFlor(@PathVariable Integer id) {
        florService.deleteFlor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Optional<FlorDto>> getFlorById(@PathVariable Integer id) {
        Optional<FlorDto> flor = florService.getFlorById(id);
        return ResponseEntity.ok(flor);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FlorDto>> getAllFlores() {
        List<FlorDto> flores = florService.getAllFlores();
        return ResponseEntity.ok(flores);
    }
}
