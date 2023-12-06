package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.AvoirAchatItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.AvoirAchatItemCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.AvoirAchatItemAdminService;
import ma.zs.easystock.ws.converter.stock.AvoirAchatItemConverter;
import ma.zs.easystock.ws.dto.stock.AvoirAchatItemDto;
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
@RequestMapping("/api/admin/avoirAchatItem/")
public class AvoirAchatItemRestAdmin  extends AbstractController<AvoirAchatItem, AvoirAchatItemDto, AvoirAchatItemCriteria, AvoirAchatItemAdminService, AvoirAchatItemConverter> {

    @Override
    @Operation(summary = "Finds a list of all avoirAchatItems")
    @GetMapping("")
    public ResponseEntity<List<AvoirAchatItemDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all avoirAchatItems")
    @GetMapping("optimized")
    public ResponseEntity<List<AvoirAchatItemDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a avoirAchatItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AvoirAchatItemDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a avoirAchatItem by barCode")
    @GetMapping("barCode/{barCode}")
    public ResponseEntity<AvoirAchatItemDto> findByBarCode(@PathVariable String barCode){
        return getResponse(service.findByBarCode(barCode));
    }

    @Operation(summary = "Deletes a avoirAchatItem by barCode")
    @DeleteMapping("barCode/{barCode}")
    public ResponseEntity<Integer> deleteByBarCode(@PathVariable String barCode){
        return getResponse(service.deleteByBarCode(barCode));
    }

    @Override
    @Operation(summary = "Saves the specified  avoirAchatItem")
    @PostMapping("")
    public ResponseEntity<AvoirAchatItemDto> save(@RequestBody AvoirAchatItemDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  avoirAchatItem")
    @PutMapping("")
    public ResponseEntity<AvoirAchatItemDto> update(@RequestBody AvoirAchatItemDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified avoirAchatItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by depot id")
    @GetMapping("depot/id/{id}")
    public ResponseEntity<List<AvoirAchatItemDto>> findByDepotId(@PathVariable Long id){
        return getResponse(service.findByDepotId(id));
    }
    @Operation(summary = "delete by depot id")
    @DeleteMapping("depot/id/{id}")
    public ResponseEntity<Integer> deleteByDepotId(@PathVariable Long id){
        return getResponse(service.deleteByDepotId(id));
    }
    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public ResponseEntity<List<AvoirAchatItemDto>> findByProduitId(@PathVariable Long id){
        return getResponse(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public ResponseEntity<Integer> deleteByProduitId(@PathVariable Long id){
        return getResponse(service.deleteByProduitId(id));
    }
    @Operation(summary = "find by taxe id")
    @GetMapping("taxe/id/{id}")
    public ResponseEntity<List<AvoirAchatItemDto>> findByTaxeId(@PathVariable Long id){
        return getResponse(service.findByTaxeId(id));
    }
    @Operation(summary = "delete by taxe id")
    @DeleteMapping("taxe/id/{id}")
    public ResponseEntity<Integer> deleteByTaxeId(@PathVariable Long id){
        return getResponse(service.deleteByTaxeId(id));
    }
    @Operation(summary = "find by avoirAchat id")
    @GetMapping("avoirAchat/id/{id}")
    public ResponseEntity<List<AvoirAchatItemDto>> findByAvoirAchatId(@PathVariable Long id){
        return getResponse(service.findByAvoirAchatId(id));
    }
    @Operation(summary = "delete by avoirAchat id")
    @DeleteMapping("avoirAchat/id/{id}")
    public ResponseEntity<Integer> deleteByAvoirAchatId(@PathVariable Long id){
        return getResponse(service.deleteByAvoirAchatId(id));
    }



    public AvoirAchatItemRestAdmin (AvoirAchatItemAdminService service, AvoirAchatItemConverter converter) {
        super(service, converter);
    }




}
