package  ma.zs.easystock.ws.facade.admin.depense;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.depense.Depense;
import ma.zs.easystock.infra.dao.criteria.core.depense.DepenseCriteria;
import ma.zs.easystock.domain.service.facade.admin.depense.DepenseAdminService;
import ma.zs.easystock.ws.converter.depense.DepenseConverter;
import ma.zs.easystock.ws.dto.depense.DepenseDto;
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
@RequestMapping("/api/admin/depense/")
public class DepenseRestAdmin  extends AbstractController<Depense, DepenseDto, DepenseCriteria, DepenseAdminService, DepenseConverter> {

    @Override
    @Operation(summary = "Finds a list of all depenses")
    @GetMapping("")
    public ResponseEntity<List<DepenseDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a depense by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DepenseDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  depense")
    @PostMapping("")
    public ResponseEntity<DepenseDto> save(@RequestBody DepenseDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  depense")
    @PutMapping("")
    public ResponseEntity<DepenseDto> update(@RequestBody DepenseDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified depense")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public DepenseRestAdmin (DepenseAdminService service, DepenseConverter converter) {
        super(service, converter);
    }




}
