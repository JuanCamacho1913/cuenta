package com.co.api_rest_cuentas.controllers;

import com.co.api_rest_cuentas.models.Account;
import com.co.api_rest_cuentas.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/accound")
public class AccoundController {

    @Autowired
    protected AccountService accountService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            List<Account> accounts = accountService.findAll();
            for (Account account : accounts) {
                account.add(linkTo(methodOn(AccoundController.class).getOne(account.getId())).withSelfRel());
                account.add(linkTo(methodOn(AccoundController.class).getAll()).withRel(IanaLinkRelations.COLLECTION));
            }

            CollectionModel<Account> model = CollectionModel.of(accounts);
            model.add(linkTo(methodOn(AccoundController.class).getAll()).withSelfRel());

            return new ResponseEntity<>(accounts, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error. por favor intenta más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            Account account = accountService.findByID(id);

            account.add(linkTo(methodOn(AccoundController.class).getOne(account.getId())).withSelfRel());
            account.add(linkTo(methodOn(AccoundController.class).getAll()).withRel(IanaLinkRelations.COLLECTION));

            return new ResponseEntity<>(account, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error. por favor intenta más tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Account entity) {
        try {
            Account account = accountService.save(entity);

            account.add(linkTo(methodOn(AccoundController.class).getOne(account.getId())).withSelfRel());
            account.add(linkTo(methodOn(AccoundController.class).getAll()).withRel(IanaLinkRelations.COLLECTION));

            return new ResponseEntity<>(entity, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error. por favor intenta más tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Account entity) {
        try {
            Account account = accountService.save(entity);

            account.add(linkTo(methodOn(AccoundController.class).getOne(account.getId())).withSelfRel());
            account.add(linkTo(methodOn(AccoundController.class).getAll()).withRel(IanaLinkRelations.COLLECTION));

            return new ResponseEntity<>(entity, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error. por favor intenta más tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            accountService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error. por favor intenta más tarde.\"}");
        }
    }




}
