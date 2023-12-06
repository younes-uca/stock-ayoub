package  ma.zs.easystock.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.gestionchequeffet.Banque;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.BanqueCriteria;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.BanqueAdminService;
import ma.zs.easystock.ws.converter.gestionchequeffet.BanqueConverter;
import ma.zs.easystock.ws.dto.gestionchequeffet.BanqueDto;
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
@RequestMapping("/api/admin/banque/")
public class BanqueRestAdmin  extends AbstractController<Banque, BanqueDto, BanqueCriteria, BanqueAdminService, BanqueConverter> {

    @Override
    @Operation(summary = "Finds a list of all banques")
    @GetMapping("")
    public ResponseEntity<List<BanqueDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a banque by id")
    @GetMapping("id/{id}")
    public ResponseEntity<BanqueDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  banque")
    @PostMapping("")
    public ResponseEntity<BanqueDto> save(@RequestBody BanqueDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  banque")
    @PutMapping("")
    public ResponseEntity<BanqueDto> update(@RequestBody BanqueDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified banque")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public BanqueRestAdmin (BanqueAdminService service, BanqueConverter converter) {
        super(service, converter);
    }




}
