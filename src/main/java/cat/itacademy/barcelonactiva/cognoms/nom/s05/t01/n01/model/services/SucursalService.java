package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.iservices.IsucursalServices;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.repository.IsucursalRepository;

@Service
public class SucursalService implements IsucursalServices{
    @Autowired
    private IsucursalRepository iSucursalRepository;
    
    @Override
    public SucursalDTO addSucursal(SucursalDTO sucursalDTO) {
        Sucursal sucursal = convertToEntity(sucursalDTO);
        sucursal = iSucursalRepository.save(sucursal);
        return convertToDTO(sucursal);
    }
    
    @Override
    public SucursalDTO updateSucursal(Integer id, SucursalDTO sucursalDTO) {
        Optional<Sucursal> existingSucursalOptional = iSucursalRepository.findById(id);
       
        if (existingSucursalOptional.isPresent()) {
            Sucursal existingSucursal = existingSucursalOptional.get();
            existingSucursal.setNombreSucursal(sucursalDTO.getNombreSucursal());
            existingSucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
            Sucursal updatedSucursal = iSucursalRepository.save(existingSucursal);
            
            return convertToDTO(updatedSucursal);
        }
        return null;
    }

    @Override
    public void deleteSucursal(Integer id) {
    	iSucursalRepository.deleteById(id);
    }

    @Override
    public SucursalDTO getOneSucursal(Integer id) {
        Optional<Sucursal> sucursalOptional = iSucursalRepository.findById(id);
        return sucursalOptional.map(this::convertToDTO).orElse(null);
    }

    @Override
    public List<SucursalDTO> getAllSucursales() {
        List<Sucursal> sucursales = iSucursalRepository.findAll();
        return sucursales.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
   
    private SucursalDTO convertToDTO(Sucursal sucursal) {
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setSucursalId(sucursal.getSucursalId());
        sucursalDTO.setNombreSucursal(sucursal.getNombreSucursal());
        sucursalDTO.setPaisSucursal(sucursal.getPaisSucursal());
        
        String pais = sucursal.getPaisSucursal();
        List<String> paisesUE = Arrays.asList("España", "Francia", "Alemania", "Italia", "Portugal"); 

        if (paisesUE.contains(pais)) {
            sucursalDTO.setTipoSucursal("UE");
        } else {
            sucursalDTO.setTipoSucursal("Fora UE");
        }

        return sucursalDTO;
    }

    private Sucursal convertToEntity(SucursalDTO sucursalDTO) {
        Sucursal sucursal = new Sucursal();
        sucursal.setNombreSucursal(sucursalDTO.getNombreSucursal());
        sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
        return sucursal;
    }




}