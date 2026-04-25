package com.refugio.service;

import com.refugio.model.Mascota;
import com.refugio.repository.MascotaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class MascotaServiceTest {

    @Mock
    private MascotaRepository mascotaRepository;

    @InjectMocks
    private MascotaService mascotaService;

    @Test
    void testObtenerTodasLasMascotas() {
        // 1. Datos falsos
        Mascota m1 = new Mascota();
        m1.setNombre("Thor");
        Mascota m2 = new Mascota();
        m2.setNombre("Luna");

        // 2. Simulación
        Mockito.when(mascotaRepository.findAll()).thenReturn(Arrays.asList(m1, m2));

        // 3. Ejecutamos (Usando el nombre real de tu método)
        List<Mascota> resultado = mascotaService.obtenerTodasLasMascotas();

        // 4. Verificamos
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("Thor", resultado.get(0).getNombre());
    }

    @Test
    void testGuardarMascota() {
        // 1. Datos
        Mascota nueva = new Mascota();
        nueva.setNombre("Rex");

        // 2. Simulación
        Mockito.when(mascotaRepository.save(any(Mascota.class))).thenReturn(nueva);

        // 3. Ejecutamos (Usando el nombre real de tu método)
        Mascota guardada = mascotaService.guardarMascota(nueva);

        // 4. Verificamos
        assertNotNull(guardada);
        assertEquals("Rex", guardada.getNombre());
    }
}