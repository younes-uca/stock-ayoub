package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.commun.EtatVente;
import ma.zs.easystock.infra.dao.criteria.core.commun.EtatVenteCriteria;
import ma.zs.easystock.domain.service.facade.admin.commun.EtatVenteAdminService;
import ma.zs.easystock.ws.converter.commun.EtatVenteConverter;
import ma.zs.easystock.ws.dto.commun.EtatVenteDto;
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
@RequestMapping("/api/admin/etatVente/")
public class EtatVenteRestAdmin  extends AbstractController<EtatVente, EtatVenteDto, EtatVenteCriteria, EtatVenteAdminService, EtatVenteConverter> {

    @Override
    @Operation(summary = "Finds a list of all etatVentes")
    @GetMapping("")
    public ResponseEntity<List<EtatVenteDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a etatVente by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatVenteDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  etatVente")
    @PostMapping("")
    public ResponseEntity<EtatVenteDto> save(@RequestBody EtatVenteDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  etatVente")
    @PutMapping("")
    public ResponseEntity<EtatVenteDto> update(@RequestBody EtatVenteDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified etatVente")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public EtatVenteRestAdmin (EtatVenteAdminService service, EtatVenteConverter converter) {
        super(service, converter);
    }




}
