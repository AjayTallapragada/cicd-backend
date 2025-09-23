package com.app.inventory.Service;

import com.app.inventory.Model.Stock;
import com.app.inventory.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    // Get all stock items
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    // Get a single stock item by ID
    public Stock getStockById(Long id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found with id " + id));
    }

    // Add a new stock item
    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    // Update an existing stock item
    public Stock updateStock(Long id, Stock stock) {
        Stock existingStock = stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found with id " + id));
        existingStock.setName(stock.getName());
        existingStock.setQuantity(stock.getQuantity());
        existingStock.setPrice(stock.getPrice());
        return stockRepository.save(existingStock);
    }

    // Delete a stock item
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
