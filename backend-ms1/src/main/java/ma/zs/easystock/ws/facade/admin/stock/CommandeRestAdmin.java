package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.Commande;
import ma.zs.easystock.infra.dao.criteria.core.stock.CommandeCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.CommandeAdminService;
import ma.zs.easystock.ws.converter.stock.CommandeConverter;
import ma.zs.easystock.ws.dto.stock.CommandeDto;
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
@RequestMapping("/api/admin/commande/")
public class CommandeRestAdmin  extends AbstractController<Commande, CommandeDto, CommandeCriteria, CommandeAdminService, CommandeConverter> {

    @Override
    @Operation(summary = "Finds a list of all commandes")
    @GetMapping("")
    public ResponseEntity<List<CommandeDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all commandes")
    @GetMapping("optimized")
    public ResponseEntity<List<CommandeDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a commande by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CommandeDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a commande by numeroCommande")
    @GetMapping("numeroCommande/{numeroCommande}")
    public ResponseEntity<CommandeDto> findByNumeroCommande(@PathVariable String numeroCommande){
        return getResponse(service.findByNumeroCommande(numeroCommande));
    }

    @Operation(summary = "Deletes a commande by numeroCommande")
    @DeleteMapping("numeroCommande/{numeroCommande}")
    public ResponseEntity<Integer> deleteByNumeroCommande(@PathVariable String numeroCommande){
        return getResponse(service.deleteByNumeroCommande(numeroCommande));
    }

    @Override
    @Operation(summary = "Saves the specified  commande")
    @PostMapping("")
    public ResponseEntity<CommandeDto> save(@RequestBody CommandeDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  commande")
    @PutMapping("")
    public ResponseEntity<CommandeDto> update(@RequestBody CommandeDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified commande")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by client id")
    @GetMapping("client/id/{id}")
    public ResponseEntity<List<CommandeDto>> findByClientId(@PathVariable Long id){
        return getResponse(service.findByClientId(id));
    }
    @Operation(summary = "delete by client id")
    @DeleteMapping("client/id/{id}")
    public ResponseEntity<Integer> deleteByClientId(@PathVariable Long id){
        return getResponse(service.deleteByClientId(id));
    }
    @Operation(summary = "find by etatCommande id")
    @GetMapping("etatCommande/id/{id}")
    public ResponseEntity<List<CommandeDto>> findByEtatCommandeId(@PathVariable Long id){
        return getResponse(service.findByEtatCommandeId(id));
    }
    @Operation(summary = "delete by etatCommande id")
    @DeleteMapping("etatCommande/id/{id}")
    public ResponseEntity<Integer> deleteByEtatCommandeId(@PathVariable Long id){
        return getResponse(service.deleteByEtatCommandeId(id));
    }



    public CommandeRestAdmin (CommandeAdminService service, CommandeConverter converter) {
        super(service, converter);
    }




}
