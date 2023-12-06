package  ma.zs.easystock.ws.facade.admin.chequeffet;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.chequeffet.Instrument;
import ma.zs.easystock.infra.dao.criteria.core.chequeffet.InstrumentCriteria;
import ma.zs.easystock.domain.service.facade.admin.chequeffet.InstrumentAdminService;
import ma.zs.easystock.ws.converter.chequeffet.InstrumentConverter;
import ma.zs.easystock.ws.dto.chequeffet.InstrumentDto;
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
@RequestMapping("/api/admin/instrument/")
public class InstrumentRestAdmin  extends AbstractController<Instrument, InstrumentDto, InstrumentCriteria, InstrumentAdminService, InstrumentConverter> {

    @Override
    @Operation(summary = "Finds a list of all instruments")
    @GetMapping("")
    public ResponseEntity<List<InstrumentDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a instrument by id")
    @GetMapping("id/{id}")
    public ResponseEntity<InstrumentDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  instrument")
    @PostMapping("")
    public ResponseEntity<InstrumentDto> save(@RequestBody InstrumentDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  instrument")
    @PutMapping("")
    public ResponseEntity<InstrumentDto> update(@RequestBody InstrumentDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified instrument")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by typeInstrument id")
    @GetMapping("typeInstrument/id/{id}")
    public ResponseEntity<List<InstrumentDto>> findByTypeInstrumentId(@PathVariable Long id){
        return getResponse(service.findByTypeInstrumentId(id));
    }
    @Operation(summary = "delete by typeInstrument id")
    @DeleteMapping("typeInstrument/id/{id}")
    public ResponseEntity<Integer> deleteByTypeInstrumentId(@PathVariable Long id){
        return getResponse(service.deleteByTypeInstrumentId(id));
    }
    @Operation(summary = "find by chequeEffet id")
    @GetMapping("chequeEffet/id/{id}")
    public ResponseEntity<List<InstrumentDto>> findByChequeEffetId(@PathVariable Long id){
        return getResponse(service.findByChequeEffetId(id));
    }
    @Operation(summary = "delete by chequeEffet id")
    @DeleteMapping("chequeEffet/id/{id}")
    public ResponseEntity<Integer> deleteByChequeEffetId(@PathVariable Long id){
        return getResponse(service.deleteByChequeEffetId(id));
    }



    public InstrumentRestAdmin (InstrumentAdminService service, InstrumentConverter converter) {
        super(service, converter);
    }




}
