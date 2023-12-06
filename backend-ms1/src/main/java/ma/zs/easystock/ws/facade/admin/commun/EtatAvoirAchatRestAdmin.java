package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.commun.EtatAvoirAchat;
import ma.zs.easystock.infra.dao.criteria.core.commun.EtatAvoirAchatCriteria;
import ma.zs.easystock.domain.service.facade.admin.commun.EtatAvoirAchatAdminService;
import ma.zs.easystock.ws.converter.commun.EtatAvoirAchatConverter;
import ma.zs.easystock.ws.dto.commun.EtatAvoirAchatDto;
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
@RequestMapping("/api/admin/etatAvoirAchat/")
public class EtatAvoirAchatRestAdmin  extends AbstractController<EtatAvoirAchat, EtatAvoirAchatDto, EtatAvoirAchatCriteria, EtatAvoirAchatAdminService, EtatAvoirAchatConverter> {

    @Override
    @Operation(summary = "Finds a list of all etatAvoirAchats")
    @GetMapping("")
    public ResponseEntity<List<EtatAvoirAchatDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a etatAvoirAchat by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatAvoirAchatDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  etatAvoirAchat")
    @PostMapping("")
    public ResponseEntity<EtatAvoirAchatDto> save(@RequestBody EtatAvoirAchatDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  etatAvoirAchat")
    @PutMapping("")
    public ResponseEntity<EtatAvoirAchatDto> update(@RequestBody EtatAvoirAchatDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified etatAvoirAchat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public EtatAvoirAchatRestAdmin (EtatAvoirAchatAdminService service, EtatAvoirAchatConverter converter) {
        super(service, converter);
    }




}
