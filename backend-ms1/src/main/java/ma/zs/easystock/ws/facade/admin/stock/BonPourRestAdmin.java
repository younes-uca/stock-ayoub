package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.BonPour;
import ma.zs.easystock.infra.dao.criteria.core.stock.BonPourCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.BonPourAdminService;
import ma.zs.easystock.ws.converter.stock.BonPourConverter;
import ma.zs.easystock.ws.dto.stock.BonPourDto;
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
@RequestMapping("/api/admin/bonPour/")
public class BonPourRestAdmin  extends AbstractController<BonPour, BonPourDto, BonPourCriteria, BonPourAdminService, BonPourConverter> {

    @Override
    @Operation(summary = "Finds a list of all bonPours")
    @GetMapping("")
    public ResponseEntity<List<BonPourDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all bonPours")
    @GetMapping("optimized")
    public ResponseEntity<List<BonPourDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a bonPour by id")
    @GetMapping("id/{id}")
    public ResponseEntity<BonPourDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a bonPour by numeroBonPour")
    @GetMapping("numeroBonPour/{numeroBonPour}")
    public ResponseEntity<BonPourDto> findByNumeroBonPour(@PathVariable String numeroBonPour){
        return getResponse(service.findByNumeroBonPour(numeroBonPour));
    }

    @Operation(summary = "Deletes a bonPour by numeroBonPour")
    @DeleteMapping("numeroBonPour/{numeroBonPour}")
    public ResponseEntity<Integer> deleteByNumeroBonPour(@PathVariable String numeroBonPour){
        return getResponse(service.deleteByNumeroBonPour(numeroBonPour));
    }

    @Override
    @Operation(summary = "Saves the specified  bonPour")
    @PostMapping("")
    public ResponseEntity<BonPourDto> save(@RequestBody BonPourDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  bonPour")
    @PutMapping("")
    public ResponseEntity<BonPourDto> update(@RequestBody BonPourDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified bonPour")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by client id")
    @GetMapping("client/id/{id}")
    public ResponseEntity<List<BonPourDto>> findByClientId(@PathVariable Long id){
        return getResponse(service.findByClientId(id));
    }
    @Operation(summary = "delete by client id")
    @DeleteMapping("client/id/{id}")
    public ResponseEntity<Integer> deleteByClientId(@PathVariable Long id){
        return getResponse(service.deleteByClientId(id));
    }



    public BonPourRestAdmin (BonPourAdminService service, BonPourConverter converter) {
        super(service, converter);
    }




}
