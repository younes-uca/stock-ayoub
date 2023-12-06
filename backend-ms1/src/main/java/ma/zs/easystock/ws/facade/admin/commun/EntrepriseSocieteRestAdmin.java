package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.commun.EntrepriseSociete;
import ma.zs.easystock.infra.dao.criteria.core.commun.EntrepriseSocieteCriteria;
import ma.zs.easystock.domain.service.facade.admin.commun.EntrepriseSocieteAdminService;
import ma.zs.easystock.ws.converter.commun.EntrepriseSocieteConverter;
import ma.zs.easystock.ws.dto.commun.EntrepriseSocieteDto;
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
@RequestMapping("/api/admin/entrepriseSociete/")
public class EntrepriseSocieteRestAdmin  extends AbstractController<EntrepriseSociete, EntrepriseSocieteDto, EntrepriseSocieteCriteria, EntrepriseSocieteAdminService, EntrepriseSocieteConverter> {

    @Override
    @Operation(summary = "Finds a list of all entrepriseSocietes")
    @GetMapping("")
    public ResponseEntity<List<EntrepriseSocieteDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a entrepriseSociete by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EntrepriseSocieteDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  entrepriseSociete")
    @PostMapping("")
    public ResponseEntity<EntrepriseSocieteDto> save(@RequestBody EntrepriseSocieteDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  entrepriseSociete")
    @PutMapping("")
    public ResponseEntity<EntrepriseSocieteDto> update(@RequestBody EntrepriseSocieteDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified entrepriseSociete")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public EntrepriseSocieteRestAdmin (EntrepriseSocieteAdminService service, EntrepriseSocieteConverter converter) {
        super(service, converter);
    }




}
