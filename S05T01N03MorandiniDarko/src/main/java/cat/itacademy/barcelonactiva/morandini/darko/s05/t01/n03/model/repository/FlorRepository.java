package cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n03.model.repository;

import org.springframework.stereotype.Repository;
import java.util.*;
import cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n03.model.dto.FlorDto;

@Repository
public class FlorRepository {

    private ArrayList<FlorDto> florList = new ArrayList<>();

    public FlorDto addFlor(FlorDto florDto) {
        florList.add(florDto);
        return florDto;
    }

    public FlorDto updateFlor(FlorDto florDto) {
        for (FlorDto existingFlor : florList) {
            if (existingFlor.getPk_FlorID().equals(florDto.getPk_FlorID())) {
                existingFlor.setNombreFlor(florDto.getNombreFlor());
                existingFlor.setPaisFlor(florDto.getPaisFlor());
                existingFlor.setTipoFlor(florDto.getTipoFlor());
                return existingFlor;
            }
        }
        return null; 
    }

    public void deleteFlor(Integer id) {
        florList.removeIf(flor -> flor.getPk_FlorID().equals(id));
    }

    public FlorDto getFlorById(Integer id) {
        for (FlorDto flor : florList) {
            if (flor.getPk_FlorID().equals(id)) {
                return flor;
            }
        }
        return null; 
    }

    public ArrayList<FlorDto> getAllFlores() {
        return florList;
    }
}
