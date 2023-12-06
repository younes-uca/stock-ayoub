package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.commun.Ville;
import ma.zs.easystock.infra.dao.criteria.core.commun.VilleCriteria;
import ma.zs.easystock.domain.service.facade.admin.commun.VilleAdminService;
import ma.zs.easystock.ws.converter.commun.VilleConverter;
import ma.zs.easystock.ws.dto.commun.VilleDto;
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
@RequestMapping("/api/admin/ville/")
public class VilleRestAdmin  extends AbstractController<Ville, VilleDto, VilleCriteria, VilleAdminService, VilleConverter> {

    @Override
    @Operation(summary = "Finds a list of all villes")
    @GetMapping("")
    public ResponseEntity<List<VilleDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a ville by id")
    @GetMapping("id/{id}")
    public ResponseEntity<VilleDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  ville")
    @PostMapping("")
    public ResponseEntity<VilleDto> save(@RequestBody VilleDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  ville")
    @PutMapping("")
    public ResponseEntity<VilleDto> update(@RequestBody VilleDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified ville")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public VilleRestAdmin (VilleAdminService service, VilleConverter converter) {
        super(service, converter);
    }




}
