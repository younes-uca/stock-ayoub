package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.DevisItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.DevisItemCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.DevisItemAdminService;
import ma.zs.easystock.ws.converter.stock.DevisItemConverter;
import ma.zs.easystock.ws.dto.stock.DevisItemDto;
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
@RequestMapping("/api/admin/devisItem/")
public class DevisItemRestAdmin  extends AbstractController<DevisItem, DevisItemDto, DevisItemCriteria, DevisItemAdminService, DevisItemConverter> {

    @Override
    @Operation(summary = "Finds a list of all devisItems")
    @GetMapping("")
    public ResponseEntity<List<DevisItemDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a devisItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DevisItemDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  devisItem")
    @PostMapping("")
    public ResponseEntity<DevisItemDto> save(@RequestBody DevisItemDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  devisItem")
    @PutMapping("")
    public ResponseEntity<DevisItemDto> update(@RequestBody DevisItemDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified devisItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public ResponseEntity<List<DevisItemDto>> findByProduitId(@PathVariable Long id){
        return getResponse(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public ResponseEntity<Integer> deleteByProduitId(@PathVariable Long id){
        return getResponse(service.deleteByProduitId(id));
    }
    @Operation(summary = "find by taxe id")
    @GetMapping("taxe/id/{id}")
    public ResponseEntity<List<DevisItemDto>> findByTaxeId(@PathVariable Long id){
        return getResponse(service.findByTaxeId(id));
    }
    @Operation(summary = "delete by taxe id")
    @DeleteMapping("taxe/id/{id}")
    public ResponseEntity<Integer> deleteByTaxeId(@PathVariable Long id){
        return getResponse(service.deleteByTaxeId(id));
    }
    @Operation(summary = "find by devis id")
    @GetMapping("devis/id/{id}")
    public ResponseEntity<List<DevisItemDto>> findByDevisId(@PathVariable Long id){
        return getResponse(service.findByDevisId(id));
    }
    @Operation(summary = "delete by devis id")
    @DeleteMapping("devis/id/{id}")
    public ResponseEntity<Integer> deleteByDevisId(@PathVariable Long id){
        return getResponse(service.deleteByDevisId(id));
    }



    public DevisItemRestAdmin (DevisItemAdminService service, DevisItemConverter converter) {
        super(service, converter);
    }




}
