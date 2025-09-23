package com.app.inventory.Controller;

import com.app.inventory.Model.Stock;
import com.app.inventory.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
@CrossOrigin(origins = "http://localhost:5174") // React dev server
public class StockController {

    @Autowired
    private StockService stockService;

    // Get all stock items
    @GetMapping
    public List<Stock> getStock() {
        return stockService.getAllStock();
    }

    // Get a single stock item by ID
    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable Long id) {
        return stockService.getStockById(id);
    }

    // Add a new stock item
    @PostMapping
    public Stock addStock(@RequestBody Stock stock) {
        return stockService.addStock(stock);
    }

    // Update an existing stock item
    @PutMapping("/{id}")
    public Stock updateStock(@PathVariable Long id, @RequestBody Stock stock) {
        return stockService.updateStock(id, stock);
    }

    // Delete a stock item
    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
    }
}
