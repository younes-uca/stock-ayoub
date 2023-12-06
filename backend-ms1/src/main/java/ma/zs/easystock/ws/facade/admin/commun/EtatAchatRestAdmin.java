package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.commun.EtatAchat;
import ma.zs.easystock.infra.dao.criteria.core.commun.EtatAchatCriteria;
import ma.zs.easystock.domain.service.facade.admin.commun.EtatAchatAdminService;
import ma.zs.easystock.ws.converter.commun.EtatAchatConverter;
import ma.zs.easystock.ws.dto.commun.EtatAchatDto;
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
@RequestMapping("/api/admin/etatAchat/")
public class EtatAchatRestAdmin  extends AbstractController<EtatAchat, EtatAchatDto, EtatAchatCriteria, EtatAchatAdminService, EtatAchatConverter> {

    @Override
    @Operation(summary = "Finds a list of all etatAchats")
    @GetMapping("")
    public ResponseEntity<List<EtatAchatDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a etatAchat by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatAchatDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  etatAchat")
    @PostMapping("")
    public ResponseEntity<EtatAchatDto> save(@RequestBody EtatAchatDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  etatAchat")
    @PutMapping("")
    public ResponseEntity<EtatAchatDto> update(@RequestBody EtatAchatDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified etatAchat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public EtatAchatRestAdmin (EtatAchatAdminService service, EtatAchatConverter converter) {
        super(service, converter);
    }




}
