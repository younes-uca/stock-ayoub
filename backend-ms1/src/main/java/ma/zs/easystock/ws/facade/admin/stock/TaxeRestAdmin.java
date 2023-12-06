package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.Taxe;
import ma.zs.easystock.infra.dao.criteria.core.stock.TaxeCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.TaxeAdminService;
import ma.zs.easystock.ws.converter.stock.TaxeConverter;
import ma.zs.easystock.ws.dto.stock.TaxeDto;
import ma.zs.easystock.zynerator.controller.AbstractController;
import ma.zs.easystock.zynerator.dto.AuditEntityDto;
import ma.zs.easystock.zynerator.helper.PaginatedList;



import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.easystock.zynerator.process.Result;

import org.springframework.http.HttpEntity;


@RestController
@RequestMapping("/api/admin/taxe/")
public class TaxeRestAdmin  extends AbstractController<Taxe, TaxeDto, TaxeCriteria, TaxeAdminService, TaxeConverter> {

    @Override
    @Operation(summary = "Finds a list of all taxes")
    @GetMapping("")
    public ResponseEntity<List<TaxeDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a taxe by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TaxeDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  taxe")
    @PostMapping("")
    public ResponseEntity<TaxeDto> save(@RequestBody TaxeDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  taxe")
    @PutMapping("")
    public ResponseEntity<TaxeDto> update(@RequestBody TaxeDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified taxe")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public TaxeRestAdmin (TaxeAdminService service, TaxeConverter converter) {
        super(service, converter);
    }




}
