package com.gyl.CrudGyl.Services;

import com.gyl.CrudGyl.Dto.Request.VentaRequestDto;
import com.gyl.CrudGyl.Dto.Response.VentaResponseDto;
import com.gyl.CrudGyl.Services.Interfaces.IVentaService;

import java.util.List;

public class VentaService implements IVentaService {
    @Override
    public VentaResponseDto crear(VentaRequestDto dto) {
        return null;
    }

    @Override
    public List<VentaResponseDto> listarProductos() {
        return List.of();
    }

    @Override
    public VentaResponseDto buscarPorId(Long id) {
        return null;
    }

    @Override
    public VentaResponseDto actualizar(Long id, VentaRequestDto dto) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }
}
