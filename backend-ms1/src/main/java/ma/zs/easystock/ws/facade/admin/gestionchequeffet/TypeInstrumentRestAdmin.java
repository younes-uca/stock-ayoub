package  ma.zs.easystock.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.gestionchequeffet.TypeInstrument;
import ma.zs.easystock.infra.dao.criteria.core.gestionchequeffet.TypeInstrumentCriteria;
import ma.zs.easystock.domain.service.facade.admin.gestionchequeffet.TypeInstrumentAdminService;
import ma.zs.easystock.ws.converter.gestionchequeffet.TypeInstrumentConverter;
import ma.zs.easystock.ws.dto.gestionchequeffet.TypeInstrumentDto;
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
@RequestMapping("/api/admin/typeInstrument/")
public class TypeInstrumentRestAdmin  extends AbstractController<TypeInstrument, TypeInstrumentDto, TypeInstrumentCriteria, TypeInstrumentAdminService, TypeInstrumentConverter> {

    @Override
    @Operation(summary = "Finds a list of all typeInstruments")
    @GetMapping("")
    public ResponseEntity<List<TypeInstrumentDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a typeInstrument by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypeInstrumentDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  typeInstrument")
    @PostMapping("")
    public ResponseEntity<TypeInstrumentDto> save(@RequestBody TypeInstrumentDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  typeInstrument")
    @PutMapping("")
    public ResponseEntity<TypeInstrumentDto> update(@RequestBody TypeInstrumentDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified typeInstrument")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public TypeInstrumentRestAdmin (TypeInstrumentAdminService service, TypeInstrumentConverter converter) {
        super(service, converter);
    }




}
