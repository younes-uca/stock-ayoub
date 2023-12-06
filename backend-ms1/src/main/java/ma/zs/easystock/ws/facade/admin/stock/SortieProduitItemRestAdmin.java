package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.SortieProduitItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.SortieProduitItemCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.SortieProduitItemAdminService;
import ma.zs.easystock.ws.converter.stock.SortieProduitItemConverter;
import ma.zs.easystock.ws.dto.stock.SortieProduitItemDto;
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
@RequestMapping("/api/admin/sortieProduitItem/")
public class SortieProduitItemRestAdmin  extends AbstractController<SortieProduitItem, SortieProduitItemDto, SortieProduitItemCriteria, SortieProduitItemAdminService, SortieProduitItemConverter> {

    @Override
    @Operation(summary = "Finds a list of all sortieProduitItems")
    @GetMapping("")
    public ResponseEntity<List<SortieProduitItemDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a sortieProduitItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SortieProduitItemDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  sortieProduitItem")
    @PostMapping("")
    public ResponseEntity<SortieProduitItemDto> save(@RequestBody SortieProduitItemDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  sortieProduitItem")
    @PutMapping("")
    public ResponseEntity<SortieProduitItemDto> update(@RequestBody SortieProduitItemDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified sortieProduitItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public ResponseEntity<List<SortieProduitItemDto>> findByProduitId(@PathVariable Long id){
        return getResponse(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public ResponseEntity<Integer> deleteByProduitId(@PathVariable Long id){
        return getResponse(service.deleteByProduitId(id));
    }
    @Operation(summary = "find by sortieProduit id")
    @GetMapping("sortieProduit/id/{id}")
    public ResponseEntity<List<SortieProduitItemDto>> findBySortieProduitId(@PathVariable Long id){
        return getResponse(service.findBySortieProduitId(id));
    }
    @Operation(summary = "delete by sortieProduit id")
    @DeleteMapping("sortieProduit/id/{id}")
    public ResponseEntity<Integer> deleteBySortieProduitId(@PathVariable Long id){
        return getResponse(service.deleteBySortieProduitId(id));
    }



    public SortieProduitItemRestAdmin (SortieProduitItemAdminService service, SortieProduitItemConverter converter) {
        super(service, converter);
    }




}
