package  ma.zs.easystock.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.gestionchequeffet.TransfertItem;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.TransfertItemCriteria;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.TransfertItemAdminService;
import ma.zs.easystock.ws.converter.gestionchequeffet.TransfertItemConverter;
import ma.zs.easystock.ws.dto.gestionchequeffet.TransfertItemDto;
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
@RequestMapping("/api/admin/transfertItem/")
public class TransfertItemRestAdmin  extends AbstractController<TransfertItem, TransfertItemDto, TransfertItemCriteria, TransfertItemAdminService, TransfertItemConverter> {

    @Override
    @Operation(summary = "Finds a list of all transfertItems")
    @GetMapping("")
    public ResponseEntity<List<TransfertItemDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a transfertItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TransfertItemDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  transfertItem")
    @PostMapping("")
    public ResponseEntity<TransfertItemDto> save(@RequestBody TransfertItemDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  transfertItem")
    @PutMapping("")
    public ResponseEntity<TransfertItemDto> update(@RequestBody TransfertItemDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified transfertItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by depot id")
    @GetMapping("depot/id/{id}")
    public ResponseEntity<List<TransfertItemDto>> findByDepotId(@PathVariable Long id){
        return getResponse(service.findByDepotId(id));
    }
    @Operation(summary = "delete by depot id")
    @DeleteMapping("depot/id/{id}")
    public ResponseEntity<Integer> deleteByDepotId(@PathVariable Long id){
        return getResponse(service.deleteByDepotId(id));
    }
    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public ResponseEntity<List<TransfertItemDto>> findByProduitId(@PathVariable Long id){
        return getResponse(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public ResponseEntity<Integer> deleteByProduitId(@PathVariable Long id){
        return getResponse(service.deleteByProduitId(id));
    }
    @Operation(summary = "find by transfert id")
    @GetMapping("transfert/id/{id}")
    public ResponseEntity<List<TransfertItemDto>> findByTransfertId(@PathVariable Long id){
        return getResponse(service.findByTransfertId(id));
    }
    @Operation(summary = "delete by transfert id")
    @DeleteMapping("transfert/id/{id}")
    public ResponseEntity<Integer> deleteByTransfertId(@PathVariable Long id){
        return getResponse(service.deleteByTransfertId(id));
    }



    public TransfertItemRestAdmin (TransfertItemAdminService service, TransfertItemConverter converter) {
        super(service, converter);
    }




}
