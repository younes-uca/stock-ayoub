package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.VenteItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.VenteItemCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.VenteItemAdminService;
import ma.zs.easystock.ws.converter.stock.VenteItemConverter;
import ma.zs.easystock.ws.dto.stock.VenteItemDto;
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
@RequestMapping("/api/admin/venteItem/")
public class VenteItemRestAdmin  extends AbstractController<VenteItem, VenteItemDto, VenteItemCriteria, VenteItemAdminService, VenteItemConverter> {

    @Override
    @Operation(summary = "Finds a list of all venteItems")
    @GetMapping("")
    public ResponseEntity<List<VenteItemDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all venteItems")
    @GetMapping("optimized")
    public ResponseEntity<List<VenteItemDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a venteItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<VenteItemDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a venteItem by barCode")
    @GetMapping("barCode/{barCode}")
    public ResponseEntity<VenteItemDto> findByBarCode(@PathVariable String barCode){
        return getResponse(service.findByBarCode(barCode));
    }

    @Operation(summary = "Deletes a venteItem by barCode")
    @DeleteMapping("barCode/{barCode}")
    public ResponseEntity<Integer> deleteByBarCode(@PathVariable String barCode){
        return getResponse(service.deleteByBarCode(barCode));
    }

    @Override
    @Operation(summary = "Saves the specified  venteItem")
    @PostMapping("")
    public ResponseEntity<VenteItemDto> save(@RequestBody VenteItemDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  venteItem")
    @PutMapping("")
    public ResponseEntity<VenteItemDto> update(@RequestBody VenteItemDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified venteItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by depot id")
    @GetMapping("depot/id/{id}")
    public ResponseEntity<List<VenteItemDto>> findByDepotId(@PathVariable Long id){
        return getResponse(service.findByDepotId(id));
    }
    @Operation(summary = "delete by depot id")
    @DeleteMapping("depot/id/{id}")
    public ResponseEntity<Integer> deleteByDepotId(@PathVariable Long id){
        return getResponse(service.deleteByDepotId(id));
    }
    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public ResponseEntity<List<VenteItemDto>> findByProduitId(@PathVariable Long id){
        return getResponse(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public ResponseEntity<Integer> deleteByProduitId(@PathVariable Long id){
        return getResponse(service.deleteByProduitId(id));
    }
    @Operation(summary = "find by taxe id")
    @GetMapping("taxe/id/{id}")
    public ResponseEntity<List<VenteItemDto>> findByTaxeId(@PathVariable Long id){
        return getResponse(service.findByTaxeId(id));
    }
    @Operation(summary = "delete by taxe id")
    @DeleteMapping("taxe/id/{id}")
    public ResponseEntity<Integer> deleteByTaxeId(@PathVariable Long id){
        return getResponse(service.deleteByTaxeId(id));
    }
    @Operation(summary = "find by vente id")
    @GetMapping("vente/id/{id}")
    public ResponseEntity<List<VenteItemDto>> findByVenteId(@PathVariable Long id){
        return getResponse(service.findByVenteId(id));
    }
    @Operation(summary = "delete by vente id")
    @DeleteMapping("vente/id/{id}")
    public ResponseEntity<Integer> deleteByVenteId(@PathVariable Long id){
        return getResponse(service.deleteByVenteId(id));
    }



    public VenteItemRestAdmin (VenteItemAdminService service, VenteItemConverter converter) {
        super(service, converter);
    }




}
