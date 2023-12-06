package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.Produit;
import ma.zs.easystock.infra.dao.criteria.core.stock.ProduitCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.ProduitAdminService;
import ma.zs.easystock.ws.converter.stock.ProduitConverter;
import ma.zs.easystock.ws.dto.stock.ProduitDto;
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
@RequestMapping("/api/admin/produit/")
public class ProduitRestAdmin  extends AbstractController<Produit, ProduitDto, ProduitCriteria, ProduitAdminService, ProduitConverter> {

    @Override
    @Operation(summary = "Finds a list of all produits")
    @GetMapping("")
    public ResponseEntity<List<ProduitDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all produits")
    @GetMapping("optimized")
    public ResponseEntity<List<ProduitDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a produit by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ProduitDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a produit by barCode")
    @GetMapping("barCode/{barCode}")
    public ResponseEntity<ProduitDto> findByBarCode(@PathVariable String barCode){
        return getResponse(service.findByBarCode(barCode));
    }

    @Operation(summary = "Deletes a produit by barCode")
    @DeleteMapping("barCode/{barCode}")
    public ResponseEntity<Integer> deleteByBarCode(@PathVariable String barCode){
        return getResponse(service.deleteByBarCode(barCode));
    }

    @Override
    @Operation(summary = "Saves the specified  produit")
    @PostMapping("")
    public ResponseEntity<ProduitDto> save(@RequestBody ProduitDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  produit")
    @PutMapping("")
    public ResponseEntity<ProduitDto> update(@RequestBody ProduitDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified produit")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by entrepriseSociete id")
    @GetMapping("entrepriseSociete/id/{id}")
    public ResponseEntity<List<ProduitDto>> findByEntrepriseSocieteId(@PathVariable Long id){
        return getResponse(service.findByEntrepriseSocieteId(id));
    }
    @Operation(summary = "delete by entrepriseSociete id")
    @DeleteMapping("entrepriseSociete/id/{id}")
    public ResponseEntity<Integer> deleteByEntrepriseSocieteId(@PathVariable Long id){
        return getResponse(service.deleteByEntrepriseSocieteId(id));
    }
    @Operation(summary = "find by categorie id")
    @GetMapping("categorie/id/{id}")
    public ResponseEntity<List<ProduitDto>> findByCategorieId(@PathVariable Long id){
        return getResponse(service.findByCategorieId(id));
    }
    @Operation(summary = "delete by categorie id")
    @DeleteMapping("categorie/id/{id}")
    public ResponseEntity<Integer> deleteByCategorieId(@PathVariable Long id){
        return getResponse(service.deleteByCategorieId(id));
    }
    @Operation(summary = "find by marque id")
    @GetMapping("marque/id/{id}")
    public ResponseEntity<List<ProduitDto>> findByMarqueId(@PathVariable Long id){
        return getResponse(service.findByMarqueId(id));
    }
    @Operation(summary = "delete by marque id")
    @DeleteMapping("marque/id/{id}")
    public ResponseEntity<Integer> deleteByMarqueId(@PathVariable Long id){
        return getResponse(service.deleteByMarqueId(id));
    }
    @Operation(summary = "find by uniteMesure id")
    @GetMapping("uniteMesure/id/{id}")
    public ResponseEntity<List<ProduitDto>> findByUniteMesureId(@PathVariable Long id){
        return getResponse(service.findByUniteMesureId(id));
    }
    @Operation(summary = "delete by uniteMesure id")
    @DeleteMapping("uniteMesure/id/{id}")
    public ResponseEntity<Integer> deleteByUniteMesureId(@PathVariable Long id){
        return getResponse(service.deleteByUniteMesureId(id));
    }



    public ProduitRestAdmin (ProduitAdminService service, ProduitConverter converter) {
        super(service, converter);
    }




}
