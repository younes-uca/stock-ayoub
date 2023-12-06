package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.easystock.domain.model.stock.Stock;
import ma.zs.easystock.infra.dao.criteria.core.stock.StockCriteria;
import ma.zs.easystock.domain.service.facade.admin.stock.StockAdminService;
import ma.zs.easystock.ws.converter.stock.StockConverter;
import ma.zs.easystock.ws.dto.stock.StockDto;
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
@RequestMapping("/api/admin/stock/")
public class StockRestAdmin  extends AbstractController<Stock, StockDto, StockCriteria, StockAdminService, StockConverter> {

    @Override
    @Operation(summary = "Finds a list of all stocks")
    @GetMapping("")
    public ResponseEntity<List<StockDto>> findAll(){
        return super.findAll();
    }


    @Override
    @Operation(summary = "Finds a stock by id")
    @GetMapping("id/{id}")
    public ResponseEntity<StockDto> findById(@PathVariable Long id){
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Saves the specified  stock")
    @PostMapping("")
    public ResponseEntity<StockDto> save(@RequestBody StockDto dto){
        return super.save(dto);
    }

    @Override
    @Operation(summary = "Updates the specified  stock")
    @PutMapping("")
    public ResponseEntity<StockDto> update(@RequestBody StockDto dto){
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Delete the specified stock")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Long id){
        return super.deleteById(id);
    }



    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public ResponseEntity<List<StockDto>> findByProduitId(@PathVariable Long id){
        return getResponse(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public ResponseEntity<Integer> deleteByProduitId(@PathVariable Long id){
        return getResponse(service.deleteByProduitId(id));
    }
    @Operation(summary = "find by depot id")
    @GetMapping("depot/id/{id}")
    public ResponseEntity<List<StockDto>> findByDepotId(@PathVariable Long id){
        return getResponse(service.findByDepotId(id));
    }
    @Operation(summary = "delete by depot id")
    @DeleteMapping("depot/id/{id}")
    public ResponseEntity<Integer> deleteByDepotId(@PathVariable Long id){
        return getResponse(service.deleteByDepotId(id));
    }



    public StockRestAdmin (StockAdminService service, StockConverter converter) {
        super(service, converter);
    }




}
