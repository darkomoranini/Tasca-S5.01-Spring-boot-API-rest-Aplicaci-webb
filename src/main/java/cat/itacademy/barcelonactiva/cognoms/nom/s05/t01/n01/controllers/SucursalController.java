package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.iservices.IsucursalServices;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/sucursal")
public class SucursalController {
    @Autowired
    private IsucursalServices iSucursalServices;

    @GetMapping("/add")
    public String addSucursalForm(Model model) {
        model.addAttribute("sucursalDTO", new SucursalDTO());
        return "add_sucursal";
    }

    @PostMapping("/add")
    public String addSucursal(@ModelAttribute SucursalDTO sucursalDTO) {
    	iSucursalServices.addSucursal(sucursalDTO);
        return "redirect:/sucursal/getAll";
    }

    @GetMapping("/update/{id}")
    public String updateSucursalForm(@PathVariable Integer id, Model model) {
        SucursalDTO sucursalDTO = iSucursalServices.getOneSucursal(id);
        if (sucursalDTO != null) {
            model.addAttribute("sucursalDTO", sucursalDTO);
            return "update_sucursal";
        }
        return "redirect:/sucursal/getAll";
    }

    @PostMapping("/update/{id}")
    public String updateSucursal(@PathVariable Integer id, @ModelAttribute SucursalDTO sucursalDTO) {
        SucursalDTO updatedSucursalDTO = iSucursalServices.updateSucursal(id, sucursalDTO);
        if (updatedSucursalDTO != null) {
            return "redirect:/sucursal/getAll";
        }
        return "redirect:/sucursal/getAll";
    }

    @GetMapping("/delete/{id}")
    public String deleteSucursal(@PathVariable Integer id) {
    	iSucursalServices.deleteSucursal(id);
        return "redirect:/sucursal/getAll";
    }

    @GetMapping("/getOne/{id}")
    public String getOneSucursal(@PathVariable Integer id, Model model) {
        SucursalDTO sucursalDTO = iSucursalServices.getOneSucursal(id);
        model.addAttribute("sucursalDTO", sucursalDTO);
        return "get_one_sucursal";
    }

    @GetMapping("/getAll")
    public String getAllSucursales(Model model) {
        List<SucursalDTO> sucursalDTOList = iSucursalServices.getAllSucursales();
        model.addAttribute("sucursalDTOList", sucursalDTOList);
        return "get_all_sucursales";
    }
}
