package br.com.cepedi.e_drive.service.brand;

import br.com.cepedi.e_drive.model.entitys.Brand;
import br.com.cepedi.e_drive.model.records.brand.details.DataBrandDetails;
import br.com.cepedi.e_drive.model.records.brand.input.DataRegisterBrand;
import br.com.cepedi.e_drive.model.records.brand.input.DataUpdateBrand;
import br.com.cepedi.e_drive.repository.BrandRepository;
import br.com.cepedi.e_drive.service.brand.validations.disabled.BrandValidatorDisabled;
import br.com.cepedi.e_drive.service.brand.validations.register.ValidationBrandRegister;
import br.com.cepedi.e_drive.service.brand.validations.update.ValidationBrandUpdate;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@DisplayName("BrandService Tests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BrandServiceTest {

    @InjectMocks
    private BrandService brandService;

    @Mock
    private BrandRepository brandRepository;

    @Mock
    private List<ValidationBrandRegister> brandValidationRegisterList;

    @Mock
    private List<ValidationBrandUpdate> brandValidationUpdateList;

    @Mock
    private List<BrandValidatorDisabled> brandValidatorDisabledList;

    private Faker faker;
    private DataRegisterBrand dataRegisterBrand;
    private DataUpdateBrand dataUpdateBrand;
    private Brand brand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        faker = new Faker();

        // Arrange: Initialize test data
        dataRegisterBrand = new DataRegisterBrand(faker.company().name());
        dataUpdateBrand = new DataUpdateBrand(faker.company().name());

        brand = new Brand(dataRegisterBrand);
        brand.setId(faker.number().randomNumber());
        brand.setActivated(true);
    }

    @Test
    @DisplayName("Should register a brand successfully")
    void register_ValidData_BrandRegistered() {
        // Arrange
        when(brandRepository.save(any(Brand.class))).thenReturn(brand);
        

        // Act
        DataBrandDetails result = brandService.register(dataRegisterBrand);

        // Assert
        ArgumentCaptor<Brand> brandCaptor = ArgumentCaptor.forClass(Brand.class);
        verify(brandRepository).save(brandCaptor.capture());
        Brand capturedBrand = brandCaptor.getValue();

        assertAll("Brand registration",
            () -> assertNotNull(result, "Result should not be null"),
            () -> assertEquals(dataRegisterBrand.name(), capturedBrand.getName(), 
                () -> "Brand name should match the input data"),
            () -> verify(brandRepository, times(1)).save(any(Brand.class))
        );
    }

    @Test
    @DisplayName("Should get brand by ID successfully")
    void getById_ExistingId_BrandReturned() {
        // Arrange
        when(brandRepository.findById(anyLong())).thenReturn(Optional.of(brand));

        // Act
        DataBrandDetails result = brandService.getById(brand.getId());

        // Assert
        assertAll("Get brand by ID",
            () -> assertNotNull(result, "Result should not be null"),
            () -> assertEquals(brand.getName(), result.name(), 
                () -> "Returned brand name should match the expected name"),
            () -> verify(brandRepository, times(1)).findById(anyLong())
        );
    }

    @Test
    @DisplayName("Should throw exception when brand not found by ID")
    void getById_NonExistingId_ThrowsException() {
        // Arrange
        when(brandRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, 
            () -> brandService.getById(brand.getId()), 
            () -> "Expected an exception to be thrown when brand is not found"
        );
        verify(brandRepository, times(1)).findById(anyLong());
    }

    @Test
    @DisplayName("Should list all brands")
    void listAll_BrandsReturned() {
        // Arrange
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<Brand> brandPage = new PageImpl<>(List.of(brand));
        when(brandRepository.findAll(pageRequest)).thenReturn(brandPage);

        // Act
        Page<DataBrandDetails> result = brandService.listAll(pageRequest);

        // Assert
        assertAll("List all brands",
            () -> assertNotNull(result, "Result should not be null"),
            () -> assertEquals(1, result.getTotalElements(), 
                () -> "Total elements should match the expected number of brands"),
            () -> verify(brandRepository, times(1)).findAll(pageRequest)
        );
    }

    @Test
    @DisplayName("Should list all activated brands")
    void listAllActivated_BrandsReturned() {
        // Arrange
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<Brand> brandPage = new PageImpl<>(List.of(brand));
        when(brandRepository.findAllByActivatedTrue(pageRequest)).thenReturn(brandPage);

        // Act
        Page<DataBrandDetails> result = brandService.listAllActivated(pageRequest);

        // Assert
        assertAll("List all activated brands",
            () -> assertNotNull(result, "Result should not be null"),
            () -> assertEquals(1, result.getTotalElements(), 
                () -> "Total elements should match the expected number of activated brands"),
            () -> verify(brandRepository, times(1)).findAllByActivatedTrue(pageRequest)
        );
    }
  
    @Test
    @DisplayName("Should activate a brand successfully")
    void activated_ValidId_BrandActivated() {
        // Arrange
        when(brandRepository.getReferenceById(anyLong())).thenReturn(brand);

        // Act
        brandService.activated(brand.getId());

        // Assert
        assertAll("Activate brand",
            () -> verify(brandRepository, times(1)).getReferenceById(brand.getId()), // Verifica que a marca foi recuperada pelo ID
            () -> assertTrue(brand.getActivated(), "Brand should be activated"),      // Verifica que o estado da marca é 'ativado'
            () -> verify(brandRepository, times(1)).save(brand)                        // Verifica que a marca foi salva com o estado atualizado
        );
    }
    
    @Test
    @DisplayName("Should throw exception when trying to activate a non-existing brand")
    void activated_NonExistingId_ThrowsException() {
        // Arrange
        when(brandRepository.getReferenceById(anyLong())).thenThrow(new RuntimeException("Brand not found"));

        // Act & Assert
        assertThrows(RuntimeException.class,
            () -> brandService.activated(faker.number().randomNumber()), // Passa um ID inexistente
            "Expected an exception to be thrown when trying to activate a non-existing brand"
        );

        verify(brandRepository, times(1)).getReferenceById(anyLong());
        verify(brandRepository, never()).save(any(Brand.class));
    }
    
    @Test
    @DisplayName("Should update a brand successfully")
    void update_ValidData_BrandUpdated() {
        // Arrange
        when(brandRepository.getReferenceById(anyLong())).thenReturn(brand);
        // Mock the behavior of the brand validation list
        doNothing().when(brandValidationUpdateList).forEach(any());

        // Act
        DataBrandDetails result = brandService.update(dataUpdateBrand, brand.getId());

        // Assert
        assertAll("Brand update",
            () -> assertNotNull(result, "Result should not be null"),
            () -> assertEquals(dataUpdateBrand.name(), result.name(), 
                () -> "Updated brand name should match the input data"),
            () -> verify(brandValidationUpdateList, times(1)).forEach(any()),
            () -> verify(brandRepository, times(1)).getReferenceById(anyLong())
        );
    }

    
    @Test
    @DisplayName("Should disable a brand successfully")
    void disabled_ValidId_BrandDisabled() {
        // Arrange
        when(brandRepository.getReferenceById(anyLong())).thenReturn(brand);
        // Mock the behavior of the brand validator list
        doNothing().when(brandValidatorDisabledList).forEach(any());

        // Act
        brandService.disabled(brand.getId());

        // Assert
        assertAll("Disable brand",
            () -> verify(brandValidatorDisabledList, times(1)).forEach(any()),
            () -> verify(brandRepository, times(1)).getReferenceById(anyLong()),
            () -> assertFalse(brand.getActivated(), "Brand should be deactivated")
        );
    }

    @Test
    @DisplayName("Should register a brand successfully")
    void register_Valid_BrandRegistered() {
        // Arrange
        DataRegisterBrand dataRegisterBrand = new DataRegisterBrand("brandName");
        doNothing().when(brandValidationRegisterList).forEach(any()); 

        // Act
        brandService.register(dataRegisterBrand);

        // Assert
        verify(brandValidationRegisterList, times(1)).forEach(any()); 
        verify(brandRepository, times(1)).save(any());
    }




}
