package cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n02.iflorservices;

import java.util.List;
import java.util.Optional;

import cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n02.model.dto.FlorDto;

public interface IFlorService {

	   public List<FlorDto> getAllFlores();

	    public Optional<FlorDto> getFlorById(Integer id);

	    public FlorDto addFlor(FlorDto florDto);

	    public Optional<FlorDto> updateFlor(FlorDto florDto);

	    public boolean deleteFlor(Integer id);
}

