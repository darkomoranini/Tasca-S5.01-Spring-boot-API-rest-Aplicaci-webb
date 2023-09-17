package cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n03.controllers;

import java.util.List;

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
import org.springframework.web.client.RestTemplate;

import cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n03.model.dto.FlorDto;

@RestController
@RequestMapping("/flor")
public class FlorController {

    private final String apiUrl = "http://localhost:9001/flor"; // URL de la API del nivel 2

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/addFlor")
    public ResponseEntity<FlorDto> addFlor(@RequestBody FlorDto florDto) {
        ResponseEntity<FlorDto> response = restTemplate.postForEntity(apiUrl + "/addFlor", florDto, FlorDto.class);
        return ResponseEntity.ok(response.getBody());
    }

    @PutMapping("/updateFlor")
    public ResponseEntity<FlorDto> updateFlor(@RequestBody FlorDto florDto) {
        restTemplate.put(apiUrl + "/updateFlor", florDto);
        return ResponseEntity.ok(florDto);
    }

    @DeleteMapping("/deleteFlor/{id}")
    public ResponseEntity<Void> deleteFlor(@PathVariable Integer id) {
        restTemplate.delete(apiUrl + "/deleteFlor/{id}", id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getFlorById/{id}")
    public ResponseEntity<FlorDto> getFlorById(@PathVariable Integer id) {
        ResponseEntity<FlorDto> response = restTemplate.getForEntity(apiUrl + "/getFlorById/{id}", FlorDto.class, id);
        return ResponseEntity.ok(response.getBody());
    }

    @GetMapping("/getAllFlores")
    public ResponseEntity<List<FlorDto>> getAllFlores() {
        ResponseEntity<List> response = restTemplate.getForEntity(apiUrl + "/getAllFlores", List.class);
        return ResponseEntity.ok(response.getBody());
    }
}
