package com.bunker.padel.rest;

import com.bunker.padel.model.BookingDTO;
import com.bunker.padel.params.BookingParams;
import com.bunker.padel.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {
    protected final BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<BookingDTO>> findBySearch(@ModelAttribute BookingParams params)
    {
        return ResponseEntity.ok(this.bookingService.findBySearch(params));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.bookingService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BookingDTO> create(@RequestBody BookingDTO bookingDTO) {
        return ResponseEntity.ok(this.bookingService.save(bookingDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.bookingService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
