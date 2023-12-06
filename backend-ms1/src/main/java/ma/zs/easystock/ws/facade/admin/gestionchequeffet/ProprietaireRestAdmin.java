package  ma.zs.easystock.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.gestionchequeffet.Proprietaire;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.ProprietaireCriteria;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.ProprietaireAdminService;
import ma.zs.easystock.ws.converter.gestionchequeffet.ProprietaireConverter;
import ma.zs.easystock.ws.dto.gestionchequeffet.ProprietaireDto;
import ma.zs.easystock.zynerator.controller.AbstractController;
import ma.zs.easystock.zynerator.dto.AuditEntityDto;
import ma.zs.easystock.zynerator.helper.PaginatedList;



import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.easystock.zynerator.process.Result;



@RestController
@RequestMapping("/api/admin/proprietaire/")
public class ProprietaireRestAdmin  extends AbstractController<Proprietaire, ProprietaireDto, ProprietaireCriteria, ProprietaireAdminService, ProprietaireConverter> {

    @Override
    @Operation(summary = "Finds a list of all proprietaires")
    @GetMapping("")
    public ResponseEntity<List<ProprietaireDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a proprietaire by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ProprietaireDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  proprietaire")
    @PostMapping("")
    public ResponseEntity<ProprietaireDto> save(@RequestBody ProprietaireDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  proprietaire")
    @PutMapping("")
    public ResponseEntity<ProprietaireDto> update(@RequestBody ProprietaireDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified proprietaire")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by personne id")
    @GetMapping("personne/id/{id}")
    public ResponseEntity<List<ProprietaireDto>> findByPersonneId(@PathVariable Long id){
        return getResponse(service.findByPersonneId(id));
    }
    @Operation(summary = "delete by personne id")
    @DeleteMapping("personne/id/{id}")
    public ResponseEntity<Integer> deleteByPersonneId(@PathVariable Long id){
        return getResponse(service.deleteByPersonneId(id));
    }



    public ProprietaireRestAdmin (ProprietaireAdminService service, ProprietaireConverter converter) {
        super(service, converter);
    }




}
