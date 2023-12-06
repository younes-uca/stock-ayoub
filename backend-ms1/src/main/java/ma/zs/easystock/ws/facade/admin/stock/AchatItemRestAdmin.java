package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.AchatItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.AchatItemCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.AchatItemAdminService;
import ma.zs.easystock.ws.converter.stock.AchatItemConverter;
import ma.zs.easystock.ws.dto.stock.AchatItemDto;
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
@RequestMapping("/api/admin/achatItem/")
public class AchatItemRestAdmin  extends AbstractController<AchatItem, AchatItemDto, AchatItemCriteria, AchatItemAdminService, AchatItemConverter> {

    @Override
    @Operation(summary = "Finds a list of all achatItems")
    @GetMapping("")
    public ResponseEntity<List<AchatItemDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a achatItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AchatItemDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  achatItem")
    @PostMapping("")
    public ResponseEntity<AchatItemDto> save(@RequestBody AchatItemDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  achatItem")
    @PutMapping("")
    public ResponseEntity<AchatItemDto> update(@RequestBody AchatItemDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified achatItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public ResponseEntity<List<AchatItemDto>> findByProduitId(@PathVariable Long id){
        return getResponse(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public ResponseEntity<Integer> deleteByProduitId(@PathVariable Long id){
        return getResponse(service.deleteByProduitId(id));
    }
    @Operation(summary = "find by taxe id")
    @GetMapping("taxe/id/{id}")
    public ResponseEntity<List<AchatItemDto>> findByTaxeId(@PathVariable Long id){
        return getResponse(service.findByTaxeId(id));
    }
    @Operation(summary = "delete by taxe id")
    @DeleteMapping("taxe/id/{id}")
    public ResponseEntity<Integer> deleteByTaxeId(@PathVariable Long id){
        return getResponse(service.deleteByTaxeId(id));
    }
    @Operation(summary = "find by achat id")
    @GetMapping("achat/id/{id}")
    public ResponseEntity<List<AchatItemDto>> findByAchatId(@PathVariable Long id){
        return getResponse(service.findByAchatId(id));
    }
    @Operation(summary = "delete by achat id")
    @DeleteMapping("achat/id/{id}")
    public ResponseEntity<Integer> deleteByAchatId(@PathVariable Long id){
        return getResponse(service.deleteByAchatId(id));
    }
    @Operation(summary = "find by depot id")
    @GetMapping("depot/id/{id}")
    public ResponseEntity<List<AchatItemDto>> findByDepotId(@PathVariable Long id){
        return getResponse(service.findByDepotId(id));
    }
    @Operation(summary = "delete by depot id")
    @DeleteMapping("depot/id/{id}")
    public ResponseEntity<Integer> deleteByDepotId(@PathVariable Long id){
        return getResponse(service.deleteByDepotId(id));
    }



    public AchatItemRestAdmin (AchatItemAdminService service, AchatItemConverter converter) {
        super(service, converter);
    }




}
