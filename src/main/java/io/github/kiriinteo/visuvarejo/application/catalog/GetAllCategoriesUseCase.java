package io.github.kiriinteo.visuvarejo.application.catalog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import io.github.kiriinteo.visuvarejo.core.domain.Category;
import io.github.kiriinteo.visuvarejo.core.port.CategoryRepository;

@Service
@RequiredArgsConstructor
public class GetAllCategoriesUseCase {

    private final CategoryRepository categoryRepository;

    public List<Category> execute() {
        return categoryRepository.findAll();
    }
}
