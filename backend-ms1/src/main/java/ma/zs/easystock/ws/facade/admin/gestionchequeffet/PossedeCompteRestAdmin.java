package  ma.zs.easystock.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.gestionchequeffet.PossedeCompte;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.PossedeCompteCriteria;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.PossedeCompteAdminService;
import ma.zs.easystock.ws.converter.gestionchequeffet.PossedeCompteConverter;
import ma.zs.easystock.ws.dto.gestionchequeffet.PossedeCompteDto;
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
@RequestMapping("/api/admin/possedeCompte/")
public class PossedeCompteRestAdmin  extends AbstractController<PossedeCompte, PossedeCompteDto, PossedeCompteCriteria, PossedeCompteAdminService, PossedeCompteConverter> {

    @Override
    @Operation(summary = "Finds a list of all possedeComptes")
    @GetMapping("")
    public ResponseEntity<List<PossedeCompteDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a possedeCompte by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PossedeCompteDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  possedeCompte")
    @PostMapping("")
    public ResponseEntity<PossedeCompteDto> save(@RequestBody PossedeCompteDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  possedeCompte")
    @PutMapping("")
    public ResponseEntity<PossedeCompteDto> update(@RequestBody PossedeCompteDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified possedeCompte")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by proprietaire id")
    @GetMapping("proprietaire/id/{id}")
    public ResponseEntity<List<PossedeCompteDto>> findByProprietaireId(@PathVariable Long id){
        return getResponse(service.findByProprietaireId(id));
    }
    @Operation(summary = "delete by proprietaire id")
    @DeleteMapping("proprietaire/id/{id}")
    public ResponseEntity<Integer> deleteByProprietaireId(@PathVariable Long id){
        return getResponse(service.deleteByProprietaireId(id));
    }
    @Operation(summary = "find by banque id")
    @GetMapping("banque/id/{id}")
    public ResponseEntity<List<PossedeCompteDto>> findByBanqueId(@PathVariable Long id){
        return getResponse(service.findByBanqueId(id));
    }
    @Operation(summary = "delete by banque id")
    @DeleteMapping("banque/id/{id}")
    public ResponseEntity<Integer> deleteByBanqueId(@PathVariable Long id){
        return getResponse(service.deleteByBanqueId(id));
    }
    @Operation(summary = "find by compte id")
    @GetMapping("compte/id/{id}")
    public ResponseEntity<List<PossedeCompteDto>> findByCompteId(@PathVariable Long id){
        return getResponse(service.findByCompteId(id));
    }
    @Operation(summary = "delete by compte id")
    @DeleteMapping("compte/id/{id}")
    public ResponseEntity<Integer> deleteByCompteId(@PathVariable Long id){
        return getResponse(service.deleteByCompteId(id));
    }



    public PossedeCompteRestAdmin (PossedeCompteAdminService service, PossedeCompteConverter converter) {
        super(service, converter);
    }




}
