package  ma.zs.easystock.ws.facade.admin.Transfert;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.Transfert.Raison;
import ma.zs.easystock.infra.dao.criteria.core.Transfert.RaisonCriteria;
import ma.zs.easystock.domain.service.facade.admin.Transfert.RaisonAdminService;
import ma.zs.easystock.ws.converter.Transfert.RaisonConverter;
import ma.zs.easystock.ws.dto.Transfert.RaisonDto;
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
@RequestMapping("/api/admin/raison/")
public class RaisonRestAdmin  extends AbstractController<Raison, RaisonDto, RaisonCriteria, RaisonAdminService, RaisonConverter> {

    @Override
    @Operation(summary = "Finds a list of all raisons")
    @GetMapping("")
    public ResponseEntity<List<RaisonDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a raison by id")
    @GetMapping("id/{id}")
    public ResponseEntity<RaisonDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  raison")
    @PostMapping("")
    public ResponseEntity<RaisonDto> save(@RequestBody RaisonDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  raison")
    @PutMapping("")
    public ResponseEntity<RaisonDto> update(@RequestBody RaisonDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified raison")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public RaisonRestAdmin (RaisonAdminService service, RaisonConverter converter) {
        super(service, converter);
    }




}
