package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.Vente;
import ma.zs.easystock.infra.dao.criteria.core.stock.VenteCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.VenteAdminService;
import ma.zs.easystock.ws.converter.stock.VenteConverter;
import ma.zs.easystock.ws.dto.stock.VenteDto;
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
@RequestMapping("/api/admin/vente/")
public class VenteRestAdmin  extends AbstractController<Vente, VenteDto, VenteCriteria, VenteAdminService, VenteConverter> {

    @Override
    @Operation(summary = "Finds a list of all ventes")
    @GetMapping("")
    public ResponseEntity<List<VenteDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all ventes")
    @GetMapping("optimized")
    public ResponseEntity<List<VenteDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a vente by id")
    @GetMapping("id/{id}")
    public ResponseEntity<VenteDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a vente by numeroFacture")
    @GetMapping("numeroFacture/{numeroFacture}")
    public ResponseEntity<VenteDto> findByNumeroFacture(@PathVariable String numeroFacture){
        return getResponse(service.findByNumeroFacture(numeroFacture));
    }

    @Operation(summary = "Deletes a vente by numeroFacture")
    @DeleteMapping("numeroFacture/{numeroFacture}")
    public ResponseEntity<Integer> deleteByNumeroFacture(@PathVariable String numeroFacture){
        return getResponse(service.deleteByNumeroFacture(numeroFacture));
    }

    @Override
    @Operation(summary = "Saves the specified  vente")
    @PostMapping("")
    public ResponseEntity<VenteDto> save(@RequestBody VenteDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  vente")
    @PutMapping("")
    public ResponseEntity<VenteDto> update(@RequestBody VenteDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified vente")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by entrepriseSociete id")
    @GetMapping("entrepriseSociete/id/{id}")
    public ResponseEntity<List<VenteDto>> findByEntrepriseSocieteId(@PathVariable Long id){
        return getResponse(service.findByEntrepriseSocieteId(id));
    }
    @Operation(summary = "delete by entrepriseSociete id")
    @DeleteMapping("entrepriseSociete/id/{id}")
    public ResponseEntity<Integer> deleteByEntrepriseSocieteId(@PathVariable Long id){
        return getResponse(service.deleteByEntrepriseSocieteId(id));
    }
    @Operation(summary = "find by client id")
    @GetMapping("client/id/{id}")
    public ResponseEntity<List<VenteDto>> findByClientId(@PathVariable Long id){
        return getResponse(service.findByClientId(id));
    }
    @Operation(summary = "delete by client id")
    @DeleteMapping("client/id/{id}")
    public ResponseEntity<Integer> deleteByClientId(@PathVariable Long id){
        return getResponse(service.deleteByClientId(id));
    }
    @Operation(summary = "find by etatVente id")
    @GetMapping("etatVente/id/{id}")
    public ResponseEntity<List<VenteDto>> findByEtatVenteId(@PathVariable Long id){
        return getResponse(service.findByEtatVenteId(id));
    }
    @Operation(summary = "delete by etatVente id")
    @DeleteMapping("etatVente/id/{id}")
    public ResponseEntity<Integer> deleteByEtatVenteId(@PathVariable Long id){
        return getResponse(service.deleteByEtatVenteId(id));
    }



    public VenteRestAdmin (VenteAdminService service, VenteConverter converter) {
        super(service, converter);
    }




}
