package com.example.demo.utils;

import com.example.demo.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemServiceHelper {

    private final ItemRepository itemRepository;


}
