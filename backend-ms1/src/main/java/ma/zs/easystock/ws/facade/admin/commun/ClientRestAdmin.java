package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.commun.Client;
import ma.zs.easystock.infra.dao.criteria.core.commun.ClientCriteria;
import ma.zs.easystock.domain.service.facade.admin.commun.ClientAdminService;
import ma.zs.easystock.ws.converter.commun.ClientConverter;
import ma.zs.easystock.ws.dto.commun.ClientDto;
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
@RequestMapping("/api/admin/client/")
public class ClientRestAdmin  extends AbstractController<Client, ClientDto, ClientCriteria, ClientAdminService, ClientConverter> {

    @Override
    @Operation(summary = "Finds a list of all clients")
    @GetMapping("")
    public ResponseEntity<List<ClientDto>> findAll(){
        return super.findAll();
    }

    @Override
    @Operation(summary = "Finds an optimized list of all clients")
    @GetMapping("optimized")
    public ResponseEntity<List<ClientDto>> findAllOptimized(){
        return super.findAllOptimized();
    }

    @Override
    @Operation(summary = "Finds a client by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable Long id){
        return super.findById(id);
    }

    @Operation(summary = "Finds a client by cin")
    @GetMapping("cin/{cin}")
    public ResponseEntity<ClientDto> findByCin(@PathVariable String cin){
        return getResponse(service.findByCin(cin));
    }

    @Operation(summary = "Deletes a client by cin")
    @DeleteMapping("cin/{cin}")
    public ResponseEntity<Integer> deleteByCin(@PathVariable String cin){
        return getResponse(service.deleteByCin(cin));
    }

    @Override
    @Operation(summary = "Saves the specified  client")
    @PostMapping("")
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  client")
    @PutMapping("")
    public ResponseEntity<ClientDto> update(@RequestBody ClientDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified client")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }






    public ClientRestAdmin (ClientAdminService service, ClientConverter converter) {
        super(service, converter);
    }




}
