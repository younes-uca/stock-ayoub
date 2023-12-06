package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.Achat;
import ma.zs.easystock.infra.dao.criteria.core.stock.AchatCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.AchatAdminService;
import ma.zs.easystock.ws.converter.stock.AchatConverter;
import ma.zs.easystock.ws.dto.stock.AchatDto;
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
@RequestMapping("/api/admin/achat/")
public class AchatRestAdmin  extends AbstractController<Achat, AchatDto, AchatCriteria, AchatAdminService, AchatConverter> {

    @Override
    @Operation(summary = "Finds a list of all achats")
    @GetMapping("")
    public ResponseEntity<List<AchatDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a achat by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AchatDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  achat")
    @PostMapping("")
    public ResponseEntity<AchatDto> save(@RequestBody AchatDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  achat")
    @PutMapping("")
    public ResponseEntity<AchatDto> update(@RequestBody AchatDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified achat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by entrepriseSociete id")
    @GetMapping("entrepriseSociete/id/{id}")
    public ResponseEntity<List<AchatDto>> findByEntrepriseSocieteId(@PathVariable Long id){
        return getResponse(service.findByEntrepriseSocieteId(id));
    }
    @Operation(summary = "delete by entrepriseSociete id")
    @DeleteMapping("entrepriseSociete/id/{id}")
    public ResponseEntity<Integer> deleteByEntrepriseSocieteId(@PathVariable Long id){
        return getResponse(service.deleteByEntrepriseSocieteId(id));
    }
    @Operation(summary = "find by fournisseur id")
    @GetMapping("fournisseur/id/{id}")
    public ResponseEntity<List<AchatDto>> findByFournisseurId(@PathVariable Long id){
        return getResponse(service.findByFournisseurId(id));
    }
    @Operation(summary = "delete by fournisseur id")
    @DeleteMapping("fournisseur/id/{id}")
    public ResponseEntity<Integer> deleteByFournisseurId(@PathVariable Long id){
        return getResponse(service.deleteByFournisseurId(id));
    }
    @Operation(summary = "find by etatAchat id")
    @GetMapping("etatAchat/id/{id}")
    public ResponseEntity<List<AchatDto>> findByEtatAchatId(@PathVariable Long id){
        return getResponse(service.findByEtatAchatId(id));
    }
    @Operation(summary = "delete by etatAchat id")
    @DeleteMapping("etatAchat/id/{id}")
    public ResponseEntity<Integer> deleteByEtatAchatId(@PathVariable Long id){
        return getResponse(service.deleteByEtatAchatId(id));
    }



    public AchatRestAdmin (AchatAdminService service, AchatConverter converter) {
        super(service, converter);
    }




}
