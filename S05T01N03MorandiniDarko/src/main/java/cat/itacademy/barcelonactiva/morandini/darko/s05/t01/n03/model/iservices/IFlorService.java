package cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n03.model.iservices;

import java.util.List;
import cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n03.model.dto.FlorDto;

public interface IFlorService {
	 	
	FlorDto addFlor(FlorDto florDto);

    FlorDto updateFlor(FlorDto florDto);

    void deleteFlor(Integer id);

    FlorDto getFlorById(Integer id);

    List<FlorDto> getAllFlores();
}
