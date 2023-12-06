package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.AvoirVente;
import ma.zs.easystock.infra.dao.criteria.core.stock.AvoirVenteCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.AvoirVenteAdminService;
import ma.zs.easystock.ws.converter.stock.AvoirVenteConverter;
import ma.zs.easystock.ws.dto.stock.AvoirVenteDto;
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
@RequestMapping("/api/admin/avoirVente/")
public class AvoirVenteRestAdmin  extends AbstractController<AvoirVente, AvoirVenteDto, AvoirVenteCriteria, AvoirVenteAdminService, AvoirVenteConverter> {

    @Override
    @Operation(summary = "Finds a list of all avoirVentes")
    @GetMapping("")
    public ResponseEntity<List<AvoirVenteDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all avoirVentes")
    @GetMapping("optimized")
    public ResponseEntity<List<AvoirVenteDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a avoirVente by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AvoirVenteDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a avoirVente by numeroFactureAvoirVente")
    @GetMapping("numeroFactureAvoirVente/{numeroFactureAvoirVente}")
    public ResponseEntity<AvoirVenteDto> findByNumeroFactureAvoirVente(@PathVariable String numeroFactureAvoirVente){
        return getResponse(service.findByNumeroFactureAvoirVente(numeroFactureAvoirVente));
    }

    @Operation(summary = "Deletes a avoirVente by numeroFactureAvoirVente")
    @DeleteMapping("numeroFactureAvoirVente/{numeroFactureAvoirVente}")
    public ResponseEntity<Integer> deleteByNumeroFactureAvoirVente(@PathVariable String numeroFactureAvoirVente){
        return getResponse(service.deleteByNumeroFactureAvoirVente(numeroFactureAvoirVente));
    }

    @Override
    @Operation(summary = "Saves the specified  avoirVente")
    @PostMapping("")
    public ResponseEntity<AvoirVenteDto> save(@RequestBody AvoirVenteDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  avoirVente")
    @PutMapping("")
    public ResponseEntity<AvoirVenteDto> update(@RequestBody AvoirVenteDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified avoirVente")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by entrepriseSociete id")
    @GetMapping("entrepriseSociete/id/{id}")
    public ResponseEntity<List<AvoirVenteDto>> findByEntrepriseSocieteId(@PathVariable Long id){
        return getResponse(service.findByEntrepriseSocieteId(id));
    }
    @Operation(summary = "delete by entrepriseSociete id")
    @DeleteMapping("entrepriseSociete/id/{id}")
    public ResponseEntity<Integer> deleteByEntrepriseSocieteId(@PathVariable Long id){
        return getResponse(service.deleteByEntrepriseSocieteId(id));
    }
    @Operation(summary = "find by client id")
    @GetMapping("client/id/{id}")
    public ResponseEntity<List<AvoirVenteDto>> findByClientId(@PathVariable Long id){
        return getResponse(service.findByClientId(id));
    }
    @Operation(summary = "delete by client id")
    @DeleteMapping("client/id/{id}")
    public ResponseEntity<Integer> deleteByClientId(@PathVariable Long id){
        return getResponse(service.deleteByClientId(id));
    }
    @Operation(summary = "find by etatAvoirVente id")
    @GetMapping("etatAvoirVente/id/{id}")
    public ResponseEntity<List<AvoirVenteDto>> findByEtatAvoirVenteId(@PathVariable Long id){
        return getResponse(service.findByEtatAvoirVenteId(id));
    }
    @Operation(summary = "delete by etatAvoirVente id")
    @DeleteMapping("etatAvoirVente/id/{id}")
    public ResponseEntity<Integer> deleteByEtatAvoirVenteId(@PathVariable Long id){
        return getResponse(service.deleteByEtatAvoirVenteId(id));
    }
    @Operation(summary = "find by achat id")
    @GetMapping("achat/id/{id}")
    public ResponseEntity<List<AvoirVenteDto>> findByAchatId(@PathVariable Long id){
        return getResponse(service.findByAchatId(id));
    }
    @Operation(summary = "delete by achat id")
    @DeleteMapping("achat/id/{id}")
    public ResponseEntity<Integer> deleteByAchatId(@PathVariable Long id){
        return getResponse(service.deleteByAchatId(id));
    }



    public AvoirVenteRestAdmin (AvoirVenteAdminService service, AvoirVenteConverter converter) {
        super(service, converter);
    }




}
