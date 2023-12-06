package  ma.zs.easystock.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.gestionchequeffet.ProprietaireBanque;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.ProprietaireBanqueCriteria;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.ProprietaireBanqueAdminService;
import ma.zs.easystock.ws.converter.gestionchequeffet.ProprietaireBanqueConverter;
import ma.zs.easystock.ws.dto.gestionchequeffet.ProprietaireBanqueDto;
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
@RequestMapping("/api/admin/proprietaireBanque/")
public class ProprietaireBanqueRestAdmin  extends AbstractController<ProprietaireBanque, ProprietaireBanqueDto, ProprietaireBanqueCriteria, ProprietaireBanqueAdminService, ProprietaireBanqueConverter> {

    @Override
    @Operation(summary = "Finds a list of all proprietaireBanques")
    @GetMapping("")
    public ResponseEntity<List<ProprietaireBanqueDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a proprietaireBanque by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ProprietaireBanqueDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  proprietaireBanque")
    @PostMapping("")
    public ResponseEntity<ProprietaireBanqueDto> save(@RequestBody ProprietaireBanqueDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  proprietaireBanque")
    @PutMapping("")
    public ResponseEntity<ProprietaireBanqueDto> update(@RequestBody ProprietaireBanqueDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified proprietaireBanque")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by proprietaire id")
    @GetMapping("proprietaire/id/{id}")
    public ResponseEntity<List<ProprietaireBanqueDto>> findByProprietaireId(@PathVariable Long id){
        return getResponse(service.findByProprietaireId(id));
    }
    @Operation(summary = "delete by proprietaire id")
    @DeleteMapping("proprietaire/id/{id}")
    public ResponseEntity<Integer> deleteByProprietaireId(@PathVariable Long id){
        return getResponse(service.deleteByProprietaireId(id));
    }
    @Operation(summary = "find by banque id")
    @GetMapping("banque/id/{id}")
    public ResponseEntity<List<ProprietaireBanqueDto>> findByBanqueId(@PathVariable Long id){
        return getResponse(service.findByBanqueId(id));
    }
    @Operation(summary = "delete by banque id")
    @DeleteMapping("banque/id/{id}")
    public ResponseEntity<Integer> deleteByBanqueId(@PathVariable Long id){
        return getResponse(service.deleteByBanqueId(id));
    }
    @Operation(summary = "find by compte id")
    @GetMapping("compte/id/{id}")
    public ResponseEntity<List<ProprietaireBanqueDto>> findByCompteId(@PathVariable Long id){
        return getResponse(service.findByCompteId(id));
    }
    @Operation(summary = "delete by compte id")
    @DeleteMapping("compte/id/{id}")
    public ResponseEntity<Integer> deleteByCompteId(@PathVariable Long id){
        return getResponse(service.deleteByCompteId(id));
    }



    public ProprietaireBanqueRestAdmin (ProprietaireBanqueAdminService service, ProprietaireBanqueConverter converter) {
        super(service, converter);
    }




}
