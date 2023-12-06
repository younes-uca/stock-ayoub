package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.CommandeItem;
import ma.zs.easystock.infra.dao.criteria.core.stock.CommandeItemCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.CommandeItemAdminService;
import ma.zs.easystock.ws.converter.stock.CommandeItemConverter;
import ma.zs.easystock.ws.dto.stock.CommandeItemDto;
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
@RequestMapping("/api/admin/commandeItem/")
public class CommandeItemRestAdmin  extends AbstractController<CommandeItem, CommandeItemDto, CommandeItemCriteria, CommandeItemAdminService, CommandeItemConverter> {

    @Override
    @Operation(summary = "Finds a list of all commandeItems")
    @GetMapping("")
    public ResponseEntity<List<CommandeItemDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a commandeItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CommandeItemDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  commandeItem")
    @PostMapping("")
    public ResponseEntity<CommandeItemDto> save(@RequestBody CommandeItemDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  commandeItem")
    @PutMapping("")
    public ResponseEntity<CommandeItemDto> update(@RequestBody CommandeItemDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified commandeItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public ResponseEntity<List<CommandeItemDto>> findByProduitId(@PathVariable Long id){
        return getResponse(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public ResponseEntity<Integer> deleteByProduitId(@PathVariable Long id){
        return getResponse(service.deleteByProduitId(id));
    }
    @Operation(summary = "find by taxe id")
    @GetMapping("taxe/id/{id}")
    public ResponseEntity<List<CommandeItemDto>> findByTaxeId(@PathVariable Long id){
        return getResponse(service.findByTaxeId(id));
    }
    @Operation(summary = "delete by taxe id")
    @DeleteMapping("taxe/id/{id}")
    public ResponseEntity<Integer> deleteByTaxeId(@PathVariable Long id){
        return getResponse(service.deleteByTaxeId(id));
    }
    @Operation(summary = "find by commande id")
    @GetMapping("commande/id/{id}")
    public ResponseEntity<List<CommandeItemDto>> findByCommandeId(@PathVariable Long id){
        return getResponse(service.findByCommandeId(id));
    }
    @Operation(summary = "delete by commande id")
    @DeleteMapping("commande/id/{id}")
    public ResponseEntity<Integer> deleteByCommandeId(@PathVariable Long id){
        return getResponse(service.deleteByCommandeId(id));
    }



    public CommandeItemRestAdmin (CommandeItemAdminService service, CommandeItemConverter converter) {
        super(service, converter);
    }




}
