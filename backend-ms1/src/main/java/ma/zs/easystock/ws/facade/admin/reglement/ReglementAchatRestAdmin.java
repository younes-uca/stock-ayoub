package  ma.zs.easystock.ws.facade.admin.reglement;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.reglement.ReglementAchat;
import ma.zs.easystock.infra.dao.criteria.core.reglement.ReglementAchatCriteria;
import ma.zs.easystock.domain.service.facade.admin.reglement.ReglementAchatAdminService;
import ma.zs.easystock.ws.converter.reglement.ReglementAchatConverter;
import ma.zs.easystock.ws.dto.reglement.ReglementAchatDto;
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
@RequestMapping("/api/admin/reglementAchat/")
public class ReglementAchatRestAdmin  extends AbstractController<ReglementAchat, ReglementAchatDto, ReglementAchatCriteria, ReglementAchatAdminService, ReglementAchatConverter> {

    @Override
    @Operation(summary = "Finds a list of all reglementAchats")
    @GetMapping("")
    public ResponseEntity<List<ReglementAchatDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all reglementAchats")
    @GetMapping("optimized")
    public ResponseEntity<List<ReglementAchatDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a reglementAchat by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ReglementAchatDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a reglementAchat by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<ReglementAchatDto> findByReference(@PathVariable String reference){
        return getResponse(service.findByReference(reference));
    }

    @Operation(summary = "Deletes a reglementAchat by reference")
    @DeleteMapping("reference/{reference}")
    public ResponseEntity<Integer> deleteByReference(@PathVariable String reference){
        return getResponse(service.deleteByReference(reference));
    }

    @Override
    @Operation(summary = "Saves the specified  reglementAchat")
    @PostMapping("")
    public ResponseEntity<ReglementAchatDto> save(@RequestBody ReglementAchatDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  reglementAchat")
    @PutMapping("")
    public ResponseEntity<ReglementAchatDto> update(@RequestBody ReglementAchatDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified reglementAchat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by achat id")
    @GetMapping("achat/id/{id}")
    public ResponseEntity<List<ReglementAchatDto>> findByAchatId(@PathVariable Long id){
        return getResponse(service.findByAchatId(id));
    }
    @Operation(summary = "delete by achat id")
    @DeleteMapping("achat/id/{id}")
    public ResponseEntity<Integer> deleteByAchatId(@PathVariable Long id){
        return getResponse(service.deleteByAchatId(id));
    }
    @Operation(summary = "find by modeReglement id")
    @GetMapping("modeReglement/id/{id}")
    public ResponseEntity<List<ReglementAchatDto>> findByModeReglementId(@PathVariable Long id){
        return getResponse(service.findByModeReglementId(id));
    }
    @Operation(summary = "delete by modeReglement id")
    @DeleteMapping("modeReglement/id/{id}")
    public ResponseEntity<Integer> deleteByModeReglementId(@PathVariable Long id){
        return getResponse(service.deleteByModeReglementId(id));
    }



    public ReglementAchatRestAdmin (ReglementAchatAdminService service, ReglementAchatConverter converter) {
        super(service, converter);
    }




}
