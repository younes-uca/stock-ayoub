package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.BonPourItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.BonPourItemCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.BonPourItemAdminService;
import ma.zs.easystock.ws.converter.stock.BonPourItemConverter;
import ma.zs.easystock.ws.dto.stock.BonPourItemDto;
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
@RequestMapping("/api/admin/bonPourItem/")
public class BonPourItemRestAdmin  extends AbstractController<BonPourItem, BonPourItemDto, BonPourItemCriteria, BonPourItemAdminService, BonPourItemConverter> {

    @Override
    @Operation(summary = "Finds a list of all bonPourItems")
    @GetMapping("")
    public ResponseEntity<List<BonPourItemDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a bonPourItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<BonPourItemDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  bonPourItem")
    @PostMapping("")
    public ResponseEntity<BonPourItemDto> save(@RequestBody BonPourItemDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  bonPourItem")
    @PutMapping("")
    public ResponseEntity<BonPourItemDto> update(@RequestBody BonPourItemDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified bonPourItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public ResponseEntity<List<BonPourItemDto>> findByProduitId(@PathVariable Long id){
        return getResponse(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public ResponseEntity<Integer> deleteByProduitId(@PathVariable Long id){
        return getResponse(service.deleteByProduitId(id));
    }
    @Operation(summary = "find by taxe id")
    @GetMapping("taxe/id/{id}")
    public ResponseEntity<List<BonPourItemDto>> findByTaxeId(@PathVariable Long id){
        return getResponse(service.findByTaxeId(id));
    }
    @Operation(summary = "delete by taxe id")
    @DeleteMapping("taxe/id/{id}")
    public ResponseEntity<Integer> deleteByTaxeId(@PathVariable Long id){
        return getResponse(service.deleteByTaxeId(id));
    }
    @Operation(summary = "find by bonPour id")
    @GetMapping("bonPour/id/{id}")
    public ResponseEntity<List<BonPourItemDto>> findByBonPourId(@PathVariable Long id){
        return getResponse(service.findByBonPourId(id));
    }
    @Operation(summary = "delete by bonPour id")
    @DeleteMapping("bonPour/id/{id}")
    public ResponseEntity<Integer> deleteByBonPourId(@PathVariable Long id){
        return getResponse(service.deleteByBonPourId(id));
    }



    public BonPourItemRestAdmin (BonPourItemAdminService service, BonPourItemConverter converter) {
        super(service, converter);
    }




}
