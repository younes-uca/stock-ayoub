package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.EntreeProduitItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.EntreeProduitItemCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.EntreeProduitItemAdminService;
import ma.zs.easystock.ws.converter.stock.EntreeProduitItemConverter;
import ma.zs.easystock.ws.dto.stock.EntreeProduitItemDto;
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
@RequestMapping("/api/admin/entreeProduitItem/")
public class EntreeProduitItemRestAdmin  extends AbstractController<EntreeProduitItem, EntreeProduitItemDto, EntreeProduitItemCriteria, EntreeProduitItemAdminService, EntreeProduitItemConverter> {

    @Override
    @Operation(summary = "Finds a list of all entreeProduitItems")
    @GetMapping("")
    public ResponseEntity<List<EntreeProduitItemDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a entreeProduitItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EntreeProduitItemDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  entreeProduitItem")
    @PostMapping("")
    public ResponseEntity<EntreeProduitItemDto> save(@RequestBody EntreeProduitItemDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  entreeProduitItem")
    @PutMapping("")
    public ResponseEntity<EntreeProduitItemDto> update(@RequestBody EntreeProduitItemDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified entreeProduitItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public ResponseEntity<List<EntreeProduitItemDto>> findByProduitId(@PathVariable Long id){
        return getResponse(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public ResponseEntity<Integer> deleteByProduitId(@PathVariable Long id){
        return getResponse(service.deleteByProduitId(id));
    }
    @Operation(summary = "find by entreeProduit id")
    @GetMapping("entreeProduit/id/{id}")
    public ResponseEntity<List<EntreeProduitItemDto>> findByEntreeProduitId(@PathVariable Long id){
        return getResponse(service.findByEntreeProduitId(id));
    }
    @Operation(summary = "delete by entreeProduit id")
    @DeleteMapping("entreeProduit/id/{id}")
    public ResponseEntity<Integer> deleteByEntreeProduitId(@PathVariable Long id){
        return getResponse(service.deleteByEntreeProduitId(id));
    }



    public EntreeProduitItemRestAdmin (EntreeProduitItemAdminService service, EntreeProduitItemConverter converter) {
        super(service, converter);
    }




}
