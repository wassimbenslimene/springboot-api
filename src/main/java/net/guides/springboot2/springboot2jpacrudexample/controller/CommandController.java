package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;


import net.guides.springboot2.springboot2jpacrudexample.model.Command;

import net.guides.springboot2.springboot2jpacrudexample.repository.CommandRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class CommandController {
    @Autowired
    private CommandRepository commandRepository;

    @GetMapping("/commands")
    public List<Command> getAllCommands() {
        return commandRepository.findAll();
    }

    @GetMapping("/commands/{id}")
    public ResponseEntity<Command> getCommandById(@PathVariable(value = "id") Long commandId)
            throws ResourceNotFoundException {
        Command command = commandRepository.findById(commandId).orElseThrow(() -> new ResourceNotFoundException("Command not found for this id :: " + commandId));
        return ResponseEntity.ok().body(command);
    }

    @PostMapping("/commands")
    public Command createCommand(@Valid @RequestBody Command command) {
        return commandRepository.save(command);
    }

    @PutMapping("/commands/{id}")
    public ResponseEntity<Command> updateCommand(@PathVariable(value = "id") Long commandId,
                                                 @Valid @RequestBody Command commandDetails) throws ResourceNotFoundException {
        Command command = commandRepository.findById(commandId)
                .orElseThrow(() -> new ResourceNotFoundException("Command not found for this id :: " + commandId));

        command.setCommandNumber(commandDetails.getCommandNumber());
        command.setLastName(commandDetails.getLastName());
        command.setFirstName(commandDetails.getFirstName());
        command.setCommandName(commandDetails.getCommandName());
        command.setDate(commandDetails.getDate());
        command.setPrice(commandDetails.getPrice());
        command.setAmount(commandDetails.getAmount());
        final Command updatedCommand = commandRepository.save(command);
        return ResponseEntity.ok(updatedCommand);
    }

    @DeleteMapping("/commands/{id}")
    public Map<String, Boolean> deleteCommand(@PathVariable(value = "id") Long commandId)
            throws ResourceNotFoundException {
        Command command = commandRepository.findById(commandId)
                .orElseThrow(() -> new ResourceNotFoundException("Command not found for this id :: " + commandId));

        commandRepository.delete(command);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}