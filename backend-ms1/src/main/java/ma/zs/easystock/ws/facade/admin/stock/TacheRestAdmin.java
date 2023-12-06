package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.Tache;
import ma.zs.easystock.infra.dao.criteria.core.stock.TacheCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.TacheAdminService;
import ma.zs.easystock.ws.converter.stock.TacheConverter;
import ma.zs.easystock.ws.dto.stock.TacheDto;
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
@RequestMapping("/api/admin/tache/")
public class TacheRestAdmin  extends AbstractController<Tache, TacheDto, TacheCriteria, TacheAdminService, TacheConverter> {

    @Override
    @Operation(summary = "Finds a list of all taches")
    @GetMapping("")
    public ResponseEntity<List<TacheDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a tache by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TacheDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  tache")
    @PostMapping("")
    public ResponseEntity<TacheDto> save(@RequestBody TacheDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  tache")
    @PutMapping("")
    public ResponseEntity<TacheDto> update(@RequestBody TacheDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified tache")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by lierA id")
    @GetMapping("lierA/id/{id}")
    public ResponseEntity<List<TacheDto>> findByLierAId(@PathVariable Long id){
        return getResponse(service.findByLierAId(id));
    }
    @Operation(summary = "delete by lierA id")
    @DeleteMapping("lierA/id/{id}")
    public ResponseEntity<Integer> deleteByLierAId(@PathVariable Long id){
        return getResponse(service.deleteByLierAId(id));
    }



    public TacheRestAdmin (TacheAdminService service, TacheConverter converter) {
        super(service, converter);
    }




}
