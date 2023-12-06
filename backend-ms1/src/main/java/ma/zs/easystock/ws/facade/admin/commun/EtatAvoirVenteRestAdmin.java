package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.commun.EtatAvoirVente;
import ma.zs.easystock.infra.dao.criteria.core.commun.EtatAvoirVenteCriteria;
import ma.zs.easystock.domain.service.facade.admin.commun.EtatAvoirVenteAdminService;
import ma.zs.easystock.ws.converter.commun.EtatAvoirVenteConverter;
import ma.zs.easystock.ws.dto.commun.EtatAvoirVenteDto;
import ma.zs.easystock.zynerator.controller.AbstractController;
import ma.zs.easystock.zynerator.dto.AuditEntityDto;
import ma.zs.easystock.zynerator.helper.PaginatedList;



import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.easystock.zynerator.process.Result;

import org.springframework.http.HttpEntity;


@RestController
@RequestMapping("/api/admin/etatAvoirVente/")
public class EtatAvoirVenteRestAdmin  extends AbstractController<EtatAvoirVente, EtatAvoirVenteDto, EtatAvoirVenteCriteria, EtatAvoirVenteAdminService, EtatAvoirVenteConverter> {

    @Override
    @Operation(summary = "Finds a list of all etatAvoirVentes")
    @GetMapping("")
    public ResponseEntity<List<EtatAvoirVenteDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a etatAvoirVente by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatAvoirVenteDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  etatAvoirVente")
    @PostMapping("")
    public ResponseEntity<EtatAvoirVenteDto> save(@RequestBody EtatAvoirVenteDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  etatAvoirVente")
    @PutMapping("")
    public ResponseEntity<EtatAvoirVenteDto> update(@RequestBody EtatAvoirVenteDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified etatAvoirVente")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public EtatAvoirVenteRestAdmin (EtatAvoirVenteAdminService service, EtatAvoirVenteConverter converter) {
        super(service, converter);
    }




}
