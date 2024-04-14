package kz.hacknu.krcm36.controller;

import kz.hacknu.krcm36.dto.CashBackDto;
import kz.hacknu.krcm36.dto.CompanyDto;
import kz.hacknu.krcm36.service.CashBackService;
import kz.hacknu.krcm36.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;
    private final CashBackService cashBackService;

    @GetMapping
    public ResponseEntity<List<CompanyDto.Response>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @GetMapping("/{id}/cashbacks")
    public ResponseEntity<List<CashBackDto.Response>> getCashbacksByCompanyId(@PathVariable Integer id) {
        return ResponseEntity.ok(cashBackService.findCashBacksByCompanyId(id));
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<CompanyDto>> getCompaniesByName(@PathVariable String name) {
        return ResponseEntity.ok(companyService.getCompaniesByName(name));
    }

    @PostMapping("/save")
    public ResponseEntity<CompanyDto.Response> saveCompany(@RequestBody CompanyDto.Request companyDto) {
        return ResponseEntity.ok(companyService.createCompany(companyDto));
    }
}
