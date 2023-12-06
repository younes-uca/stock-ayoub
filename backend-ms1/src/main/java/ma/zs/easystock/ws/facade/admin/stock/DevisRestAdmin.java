package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.Devis;
import ma.zs.easystock.infra.dao.criteria.core.stock.DevisCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.DevisAdminService;
import ma.zs.easystock.ws.converter.stock.DevisConverter;
import ma.zs.easystock.ws.dto.stock.DevisDto;
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
@RequestMapping("/api/admin/devis/")
public class DevisRestAdmin  extends AbstractController<Devis, DevisDto, DevisCriteria, DevisAdminService, DevisConverter> {

    @Override
    @Operation(summary = "Finds a list of all deviss")
    @GetMapping("")
    public ResponseEntity<List<DevisDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all deviss")
    @GetMapping("optimized")
    public ResponseEntity<List<DevisDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a devis by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DevisDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a devis by numeroDevis")
    @GetMapping("numeroDevis/{numeroDevis}")
    public ResponseEntity<DevisDto> findByNumeroDevis(@PathVariable String numeroDevis){
        return getResponse(service.findByNumeroDevis(numeroDevis));
    }

    @Operation(summary = "Deletes a devis by numeroDevis")
    @DeleteMapping("numeroDevis/{numeroDevis}")
    public ResponseEntity<Integer> deleteByNumeroDevis(@PathVariable String numeroDevis){
        return getResponse(service.deleteByNumeroDevis(numeroDevis));
    }

    @Override
    @Operation(summary = "Saves the specified  devis")
    @PostMapping("")
    public ResponseEntity<DevisDto> save(@RequestBody DevisDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  devis")
    @PutMapping("")
    public ResponseEntity<DevisDto> update(@RequestBody DevisDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified devis")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by client id")
    @GetMapping("client/id/{id}")
    public ResponseEntity<List<DevisDto>> findByClientId(@PathVariable Long id){
        return getResponse(service.findByClientId(id));
    }
    @Operation(summary = "delete by client id")
    @DeleteMapping("client/id/{id}")
    public ResponseEntity<Integer> deleteByClientId(@PathVariable Long id){
        return getResponse(service.deleteByClientId(id));
    }



    public DevisRestAdmin (DevisAdminService service, DevisConverter converter) {
        super(service, converter);
    }




}
