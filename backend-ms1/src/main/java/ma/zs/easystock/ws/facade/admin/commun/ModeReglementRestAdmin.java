package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.commun.ModeReglement;
import ma.zs.easystock.infra.dao.criteria.core.commun.ModeReglementCriteria;
import ma.zs.easystock.domain.service.facade.admin.commun.ModeReglementAdminService;
import ma.zs.easystock.ws.converter.commun.ModeReglementConverter;
import ma.zs.easystock.ws.dto.commun.ModeReglementDto;
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
@RequestMapping("/api/admin/modeReglement/")
public class ModeReglementRestAdmin  extends AbstractController<ModeReglement, ModeReglementDto, ModeReglementCriteria, ModeReglementAdminService, ModeReglementConverter> {

    @Override
    @Operation(summary = "Finds a list of all modeReglements")
    @GetMapping("")
    public ResponseEntity<List<ModeReglementDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a modeReglement by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ModeReglementDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  modeReglement")
    @PostMapping("")
    public ResponseEntity<ModeReglementDto> save(@RequestBody ModeReglementDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  modeReglement")
    @PutMapping("")
    public ResponseEntity<ModeReglementDto> update(@RequestBody ModeReglementDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified modeReglement")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public ModeReglementRestAdmin (ModeReglementAdminService service, ModeReglementConverter converter) {
        super(service, converter);
    }




}
