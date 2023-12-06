package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.commun.Depot;
import ma.zs.easystock.infra.dao.criteria.core.commun.DepotCriteria;
import ma.zs.easystock.domain.service.facade.admin.commun.DepotAdminService;
import ma.zs.easystock.ws.converter.commun.DepotConverter;
import ma.zs.easystock.ws.dto.commun.DepotDto;
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
@RequestMapping("/api/admin/depot/")
public class DepotRestAdmin  extends AbstractController<Depot, DepotDto, DepotCriteria, DepotAdminService, DepotConverter> {

    @Override
    @Operation(summary = "Finds a list of all depots")
    @GetMapping("")
    public ResponseEntity<List<DepotDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a depot by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DepotDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  depot")
    @PostMapping("")
    public ResponseEntity<DepotDto> save(@RequestBody DepotDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  depot")
    @PutMapping("")
    public ResponseEntity<DepotDto> update(@RequestBody DepotDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified depot")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public DepotRestAdmin (DepotAdminService service, DepotConverter converter) {
        super(service, converter);
    }




}
