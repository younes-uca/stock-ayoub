package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.AvoirAchat;
import ma.zs.easystock.infra.dao.criteria.core.stock.AvoirAchatCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.AvoirAchatAdminService;
import ma.zs.easystock.ws.converter.stock.AvoirAchatConverter;
import ma.zs.easystock.ws.dto.stock.AvoirAchatDto;
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
@RequestMapping("/api/admin/avoirAchat/")
public class AvoirAchatRestAdmin  extends AbstractController<AvoirAchat, AvoirAchatDto, AvoirAchatCriteria, AvoirAchatAdminService, AvoirAchatConverter> {

    @Override
    @Operation(summary = "Finds a list of all avoirAchats")
    @GetMapping("")
    public ResponseEntity<List<AvoirAchatDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all avoirAchats")
    @GetMapping("optimized")
    public ResponseEntity<List<AvoirAchatDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a avoirAchat by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AvoirAchatDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a avoirAchat by numeroFactureAvoirAchat")
    @GetMapping("numeroFactureAvoirAchat/{numeroFactureAvoirAchat}")
    public ResponseEntity<AvoirAchatDto> findByNumeroFactureAvoirAchat(@PathVariable String numeroFactureAvoirAchat){
        return getResponse(service.findByNumeroFactureAvoirAchat(numeroFactureAvoirAchat));
    }

    @Operation(summary = "Deletes a avoirAchat by numeroFactureAvoirAchat")
    @DeleteMapping("numeroFactureAvoirAchat/{numeroFactureAvoirAchat}")
    public ResponseEntity<Integer> deleteByNumeroFactureAvoirAchat(@PathVariable String numeroFactureAvoirAchat){
        return getResponse(service.deleteByNumeroFactureAvoirAchat(numeroFactureAvoirAchat));
    }

    @Override
    @Operation(summary = "Saves the specified  avoirAchat")
    @PostMapping("")
    public ResponseEntity<AvoirAchatDto> save(@RequestBody AvoirAchatDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  avoirAchat")
    @PutMapping("")
    public ResponseEntity<AvoirAchatDto> update(@RequestBody AvoirAchatDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified avoirAchat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by entrepriseSociete id")
    @GetMapping("entrepriseSociete/id/{id}")
    public ResponseEntity<List<AvoirAchatDto>> findByEntrepriseSocieteId(@PathVariable Long id){
        return getResponse(service.findByEntrepriseSocieteId(id));
    }
    @Operation(summary = "delete by entrepriseSociete id")
    @DeleteMapping("entrepriseSociete/id/{id}")
    public ResponseEntity<Integer> deleteByEntrepriseSocieteId(@PathVariable Long id){
        return getResponse(service.deleteByEntrepriseSocieteId(id));
    }
    @Operation(summary = "find by fournisseur id")
    @GetMapping("fournisseur/id/{id}")
    public ResponseEntity<List<AvoirAchatDto>> findByFournisseurId(@PathVariable Long id){
        return getResponse(service.findByFournisseurId(id));
    }
    @Operation(summary = "delete by fournisseur id")
    @DeleteMapping("fournisseur/id/{id}")
    public ResponseEntity<Integer> deleteByFournisseurId(@PathVariable Long id){
        return getResponse(service.deleteByFournisseurId(id));
    }
    @Operation(summary = "find by etatAvoirAchat id")
    @GetMapping("etatAvoirAchat/id/{id}")
    public ResponseEntity<List<AvoirAchatDto>> findByEtatAvoirAchatId(@PathVariable Long id){
        return getResponse(service.findByEtatAvoirAchatId(id));
    }
    @Operation(summary = "delete by etatAvoirAchat id")
    @DeleteMapping("etatAvoirAchat/id/{id}")
    public ResponseEntity<Integer> deleteByEtatAvoirAchatId(@PathVariable Long id){
        return getResponse(service.deleteByEtatAvoirAchatId(id));
    }



    public AvoirAchatRestAdmin (AvoirAchatAdminService service, AvoirAchatConverter converter) {
        super(service, converter);
    }




}
