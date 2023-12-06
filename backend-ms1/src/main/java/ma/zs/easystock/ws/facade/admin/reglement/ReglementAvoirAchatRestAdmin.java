package  ma.zs.easystock.ws.facade.admin.reglement;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.reglement.ReglementAvoirAchat;
import ma.zs.easystock.infra.dao.criteria.core.reglement.ReglementAvoirAchatCriteria;
import ma.zs.easystock.domain.service.facade.admin.reglement.ReglementAvoirAchatAdminService;
import ma.zs.easystock.ws.converter.reglement.ReglementAvoirAchatConverter;
import ma.zs.easystock.ws.dto.reglement.ReglementAvoirAchatDto;
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
@RequestMapping("/api/admin/reglementAvoirAchat/")
public class ReglementAvoirAchatRestAdmin  extends AbstractController<ReglementAvoirAchat, ReglementAvoirAchatDto, ReglementAvoirAchatCriteria, ReglementAvoirAchatAdminService, ReglementAvoirAchatConverter> {

    @Override
    @Operation(summary = "Finds a list of all reglementAvoirAchats")
    @GetMapping("")
    public ResponseEntity<List<ReglementAvoirAchatDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all reglementAvoirAchats")
    @GetMapping("optimized")
    public ResponseEntity<List<ReglementAvoirAchatDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a reglementAvoirAchat by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ReglementAvoirAchatDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a reglementAvoirAchat by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<ReglementAvoirAchatDto> findByReference(@PathVariable String reference){
        return getResponse(service.findByReference(reference));
    }

    @Operation(summary = "Deletes a reglementAvoirAchat by reference")
    @DeleteMapping("reference/{reference}")
    public ResponseEntity<Integer> deleteByReference(@PathVariable String reference){
        return getResponse(service.deleteByReference(reference));
    }

    @Override
    @Operation(summary = "Saves the specified  reglementAvoirAchat")
    @PostMapping("")
    public ResponseEntity<ReglementAvoirAchatDto> save(@RequestBody ReglementAvoirAchatDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  reglementAvoirAchat")
    @PutMapping("")
    public ResponseEntity<ReglementAvoirAchatDto> update(@RequestBody ReglementAvoirAchatDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified reglementAvoirAchat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by achat id")
    @GetMapping("achat/id/{id}")
    public ResponseEntity<List<ReglementAvoirAchatDto>> findByAchatId(@PathVariable Long id){
        return getResponse(service.findByAchatId(id));
    }
    @Operation(summary = "delete by achat id")
    @DeleteMapping("achat/id/{id}")
    public ResponseEntity<Integer> deleteByAchatId(@PathVariable Long id){
        return getResponse(service.deleteByAchatId(id));
    }
    @Operation(summary = "find by modeReglement id")
    @GetMapping("modeReglement/id/{id}")
    public ResponseEntity<List<ReglementAvoirAchatDto>> findByModeReglementId(@PathVariable Long id){
        return getResponse(service.findByModeReglementId(id));
    }
    @Operation(summary = "delete by modeReglement id")
    @DeleteMapping("modeReglement/id/{id}")
    public ResponseEntity<Integer> deleteByModeReglementId(@PathVariable Long id){
        return getResponse(service.deleteByModeReglementId(id));
    }
    @Operation(summary = "find by avoirAchat id")
    @GetMapping("avoirAchat/id/{id}")
    public ResponseEntity<List<ReglementAvoirAchatDto>> findByAvoirAchatId(@PathVariable Long id){
        return getResponse(service.findByAvoirAchatId(id));
    }
    @Operation(summary = "delete by avoirAchat id")
    @DeleteMapping("avoirAchat/id/{id}")
    public ResponseEntity<Integer> deleteByAvoirAchatId(@PathVariable Long id){
        return getResponse(service.deleteByAvoirAchatId(id));
    }



    public ReglementAvoirAchatRestAdmin (ReglementAvoirAchatAdminService service, ReglementAvoirAchatConverter converter) {
        super(service, converter);
    }




}
