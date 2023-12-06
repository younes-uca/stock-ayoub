package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.AvoirVenteItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.AvoirVenteItemCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.AvoirVenteItemAdminService;
import ma.zs.easystock.ws.converter.stock.AvoirVenteItemConverter;
import ma.zs.easystock.ws.dto.stock.AvoirVenteItemDto;
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
@RequestMapping("/api/admin/avoirVenteItem/")
public class AvoirVenteItemRestAdmin  extends AbstractController<AvoirVenteItem, AvoirVenteItemDto, AvoirVenteItemCriteria, AvoirVenteItemAdminService, AvoirVenteItemConverter> {

    @Override
    @Operation(summary = "Finds a list of all avoirVenteItems")
    @GetMapping("")
    public ResponseEntity<List<AvoirVenteItemDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all avoirVenteItems")
    @GetMapping("optimized")
    public ResponseEntity<List<AvoirVenteItemDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a avoirVenteItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AvoirVenteItemDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a avoirVenteItem by barCode")
    @GetMapping("barCode/{barCode}")
    public ResponseEntity<AvoirVenteItemDto> findByBarCode(@PathVariable String barCode){
        return getResponse(service.findByBarCode(barCode));
    }

    @Operation(summary = "Deletes a avoirVenteItem by barCode")
    @DeleteMapping("barCode/{barCode}")
    public ResponseEntity<Integer> deleteByBarCode(@PathVariable String barCode){
        return getResponse(service.deleteByBarCode(barCode));
    }

    @Override
    @Operation(summary = "Saves the specified  avoirVenteItem")
    @PostMapping("")
    public ResponseEntity<AvoirVenteItemDto> save(@RequestBody AvoirVenteItemDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  avoirVenteItem")
    @PutMapping("")
    public ResponseEntity<AvoirVenteItemDto> update(@RequestBody AvoirVenteItemDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified avoirVenteItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by depot id")
    @GetMapping("depot/id/{id}")
    public ResponseEntity<List<AvoirVenteItemDto>> findByDepotId(@PathVariable Long id){
        return getResponse(service.findByDepotId(id));
    }
    @Operation(summary = "delete by depot id")
    @DeleteMapping("depot/id/{id}")
    public ResponseEntity<Integer> deleteByDepotId(@PathVariable Long id){
        return getResponse(service.deleteByDepotId(id));
    }
    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public ResponseEntity<List<AvoirVenteItemDto>> findByProduitId(@PathVariable Long id){
        return getResponse(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public ResponseEntity<Integer> deleteByProduitId(@PathVariable Long id){
        return getResponse(service.deleteByProduitId(id));
    }
    @Operation(summary = "find by taxe id")
    @GetMapping("taxe/id/{id}")
    public ResponseEntity<List<AvoirVenteItemDto>> findByTaxeId(@PathVariable Long id){
        return getResponse(service.findByTaxeId(id));
    }
    @Operation(summary = "delete by taxe id")
    @DeleteMapping("taxe/id/{id}")
    public ResponseEntity<Integer> deleteByTaxeId(@PathVariable Long id){
        return getResponse(service.deleteByTaxeId(id));
    }
    @Operation(summary = "find by avoirVente id")
    @GetMapping("avoirVente/id/{id}")
    public ResponseEntity<List<AvoirVenteItemDto>> findByAvoirVenteId(@PathVariable Long id){
        return getResponse(service.findByAvoirVenteId(id));
    }
    @Operation(summary = "delete by avoirVente id")
    @DeleteMapping("avoirVente/id/{id}")
    public ResponseEntity<Integer> deleteByAvoirVenteId(@PathVariable Long id){
        return getResponse(service.deleteByAvoirVenteId(id));
    }



    public AvoirVenteItemRestAdmin (AvoirVenteItemAdminService service, AvoirVenteItemConverter converter) {
        super(service, converter);
    }




}
