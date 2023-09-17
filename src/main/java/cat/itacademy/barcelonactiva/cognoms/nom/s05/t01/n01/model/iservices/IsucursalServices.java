package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.iservices;

import java.util.List;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalDTO;


public interface IsucursalServices {

	public SucursalDTO addSucursal(SucursalDTO sucursalDTO);
	
	 public SucursalDTO updateSucursal(Integer id, SucursalDTO sucursalDTO);
	
	 public void deleteSucursal(Integer id);
	
	 public SucursalDTO getOneSucursal(Integer id);
	
	 public List<SucursalDTO> getAllSucursales(); 

}
