package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.InventaireItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.InventaireItemCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.InventaireItemAdminService;
import ma.zs.easystock.ws.converter.stock.InventaireItemConverter;
import ma.zs.easystock.ws.dto.stock.InventaireItemDto;
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
@RequestMapping("/api/admin/inventaireItem/")
public class InventaireItemRestAdmin  extends AbstractController<InventaireItem, InventaireItemDto, InventaireItemCriteria, InventaireItemAdminService, InventaireItemConverter> {

    @Override
    @Operation(summary = "Finds a list of all inventaireItems")
    @GetMapping("")
    public ResponseEntity<List<InventaireItemDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a inventaireItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<InventaireItemDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  inventaireItem")
    @PostMapping("")
    public ResponseEntity<InventaireItemDto> save(@RequestBody InventaireItemDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  inventaireItem")
    @PutMapping("")
    public ResponseEntity<InventaireItemDto> update(@RequestBody InventaireItemDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified inventaireItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public ResponseEntity<List<InventaireItemDto>> findByProduitId(@PathVariable Long id){
        return getResponse(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public ResponseEntity<Integer> deleteByProduitId(@PathVariable Long id){
        return getResponse(service.deleteByProduitId(id));
    }
    @Operation(summary = "find by inventaire id")
    @GetMapping("inventaire/id/{id}")
    public ResponseEntity<List<InventaireItemDto>> findByInventaireId(@PathVariable Long id){
        return getResponse(service.findByInventaireId(id));
    }
    @Operation(summary = "delete by inventaire id")
    @DeleteMapping("inventaire/id/{id}")
    public ResponseEntity<Integer> deleteByInventaireId(@PathVariable Long id){
        return getResponse(service.deleteByInventaireId(id));
    }



    public InventaireItemRestAdmin (InventaireItemAdminService service, InventaireItemConverter converter) {
        super(service, converter);
    }




}
