package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.commun.EtatCommande;
import ma.zs.easystock.infra.dao.criteria.core.commun.EtatCommandeCriteria;
import ma.zs.easystock.domain.service.facade.admin.commun.EtatCommandeAdminService;
import ma.zs.easystock.ws.converter.commun.EtatCommandeConverter;
import ma.zs.easystock.ws.dto.commun.EtatCommandeDto;
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
@RequestMapping("/api/admin/etatCommande/")
public class EtatCommandeRestAdmin  extends AbstractController<EtatCommande, EtatCommandeDto, EtatCommandeCriteria, EtatCommandeAdminService, EtatCommandeConverter> {

    @Override
    @Operation(summary = "Finds a list of all etatCommandes")
    @GetMapping("")
    public ResponseEntity<List<EtatCommandeDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a etatCommande by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatCommandeDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  etatCommande")
    @PostMapping("")
    public ResponseEntity<EtatCommandeDto> save(@RequestBody EtatCommandeDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  etatCommande")
    @PutMapping("")
    public ResponseEntity<EtatCommandeDto> update(@RequestBody EtatCommandeDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified etatCommande")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public EtatCommandeRestAdmin (EtatCommandeAdminService service, EtatCommandeConverter converter) {
        super(service, converter);
    }




}
