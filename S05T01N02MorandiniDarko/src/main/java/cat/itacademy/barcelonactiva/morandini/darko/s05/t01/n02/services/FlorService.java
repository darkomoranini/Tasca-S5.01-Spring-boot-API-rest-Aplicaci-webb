package cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n02.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n02.iflorservices.IFlorService;
import cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n02.model.dto.FlorDto;
import cat.itacademy.barcelonactiva.morandini.darko.s05.t01.n02.model.repository.FlorRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlorService implements IFlorService {
	private final FlorRepository florRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FlorService(FlorRepository florRepository, ModelMapper modelMapper) {
        this.florRepository = florRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FlorDto> getAllFlores() {
        List<FlorEntity> flores = florRepository.findAll();
        return flores.stream()
                .map(entity -> modelMapper.map(entity, FlorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FlorDto> getFlorById(Integer id) {
        Optional<FlorEntity> florOptional = florRepository.findById(id);
        return florOptional.map(entity -> modelMapper.map(entity, FlorDto.class));
    }

    @Override
    public FlorDto addFlor(FlorDto florDTO) {
        FlorEntity florEntity = modelMapper.map(florDTO, FlorEntity.class);
        florRepository.save(florEntity);
        return modelMapper.map(florEntity, FlorDto.class);
    }

    @Override
    public Optional<FlorDto> updateFlor(FlorDto florDto) {
        Optional<FlorEntity> florOptional = florRepository.findById(florDto.getPk_FlorID());
        if (florOptional.isPresent()) {
            FlorEntity updatedFlorEntity = florRepository.save(modelMapper.map(florDto, FlorEntity.class));
            return Optional.of(modelMapper.map(updatedFlorEntity, FlorDto.class));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteFlor(Integer id) {
        Optional<FlorEntity> florOptional = florRepository.findById(id);
        if (florOptional.isPresent()) {
            florRepository.delete(florOptional.get());
            return true;
        }
        return false;
    }

}
