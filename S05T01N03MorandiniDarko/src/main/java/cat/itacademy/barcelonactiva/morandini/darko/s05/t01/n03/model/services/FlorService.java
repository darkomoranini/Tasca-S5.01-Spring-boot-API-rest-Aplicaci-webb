package cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n03.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n03.model.dto.FlorDto;
import cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n03.model.iservices.IFlorService;

public class FlorService implements IFlorService{

	 private final String apiUrl = "http://localhost:9001/flor"; 

	    @Autowired
	    private RestTemplate restTemplate;

	    @Override
	    public FlorDto addFlor(FlorDto florDto) {
	        ResponseEntity<FlorDto> response = restTemplate.postForEntity(apiUrl + "/addFlor", florDto, FlorDto.class);
	        return response.getBody();
	    }

	    @Override
	    public FlorDto updateFlor(FlorDto florDto) {
	        restTemplate.put(apiUrl + "/updateFlor", florDto);
	        return florDto;
	    }

	    @Override
	    public void deleteFlor(Integer id) {
	        restTemplate.delete(apiUrl + "/deleteFlor/{id}", id);
	    }

	    @Override
	    public FlorDto getFlorById(Integer id) {
	        ResponseEntity<FlorDto> response = restTemplate.getForEntity(apiUrl + "/getFlorById/{id}", FlorDto.class, id);
	        return response.getBody();
	    }

	    @Override
	    public List<FlorDto> getAllFlores() {
	        ResponseEntity<List> response = restTemplate.getForEntity(apiUrl + "/getAllFlores", List.class);
	        return response.getBody();
	    
	    }
}
