package com.gyl.CrudGyl.Services;

import com.gyl.CrudGyl.Dto.Request.DetalleVentaRequestDto;
import com.gyl.CrudGyl.Dto.Request.VentaRequestDto;
import com.gyl.CrudGyl.Dto.Response.VentaResponseDto;
import com.gyl.CrudGyl.Entity.Cliente;
import com.gyl.CrudGyl.Entity.DetalleVenta;
import com.gyl.CrudGyl.Entity.Producto;
import com.gyl.CrudGyl.Entity.Venta;
import com.gyl.CrudGyl.Exceptions.RecursosNoEncontradoException;
import com.gyl.CrudGyl.Mapper.ProductoMapper;
import com.gyl.CrudGyl.Mapper.VentaMapper;
import com.gyl.CrudGyl.Repository.ClienteRepository;
import com.gyl.CrudGyl.Repository.ProductoRepository;
import com.gyl.CrudGyl.Repository.VentaRepository;
import com.gyl.CrudGyl.Services.Interfaces.IVentaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService {

    private VentaRepository ventaRepository;
    private ClienteRepository clienteRepository;
    private ProductoRepository productoRepository;


    public VentaService(VentaRepository ventaRepository, ClienteRepository clienteRepository, ProductoRepository productoRepository) {
        this.ventaRepository = ventaRepository;
        this.clienteRepository = clienteRepository;
        this.productoRepository = productoRepository;
    }
    @Override
    @Transactional
    public VentaResponseDto crear(VentaRequestDto dto) {
        Venta venta = new Venta();
        Cliente clienteGenerico = clienteRepository.findById(dto.id_cliente())//1L
                .orElseThrow(() -> new RecursosNoEncontradoException("Debe crear un cliente genérico con ID 1 primero"));

        venta.setCliente(clienteGenerico);

        procesarItems(venta, dto.items());
        return VentaMapper.toDto(ventaRepository.save(venta));
    }

    @Override
    public List<VentaResponseDto> listarVentas() {

        return ventaRepository.findAll()
                .stream()
                .map(VentaMapper::toDto)
                .toList();
    }

    @Override
    public VentaResponseDto buscarPorId(Long id) {

        return ventaRepository.findById(id)
                .map(VentaMapper::toDto)
                .orElseThrow(()->new RecursosNoEncontradoException(
                "No se encontro el id: "+id
        ));
    }

    //Terminar metodo
    @Override
    @Transactional
    public VentaResponseDto actualizar(Long id, VentaRequestDto dto) {
        Venta venta = ventaRepository.findById(id).orElseThrow(() -> new RecursosNoEncontradoException(
                "No se encontro la venta con el id: " + id
        ));
        VentaMapper.updateEntity(venta, dto);

        if (venta.getDetalles() != null) {
            venta.getDetalles().clear();
        }

        procesarItems(venta, dto.items());

        Venta guardado = ventaRepository.save(venta);
        return VentaMapper.toDto(guardado);
    }

    @Override
    public VentaResponseDto eliminar(Long id) {
        Venta venta=ventaRepository.findById(id)
                .orElseThrow(()->new RecursosNoEncontradoException(
                "No se encontro la venta con el id: "+id
        ));

        ventaRepository.delete(venta);
        return VentaMapper.toDto(venta);
    }

    @Override
    public List<VentaResponseDto> listarVentasConEstadoTrue() {

        return ventaRepository.findByEstadoVentaTrue()
                .stream()
                .map(VentaMapper::toDto)
                .toList();
    }

    @Override
    public List<VentaResponseDto> listarVentasConEstadoFalse() {
        return ventaRepository.findByEstadoVentaFalse()
                .stream()
                .map(VentaMapper::toDto)
                .toList();
    }

    @Override
    public VentaResponseDto actualizarEstado(Long id, VentaRequestDto dto) {
        Venta venta=ventaRepository.findById(id).orElseThrow(()-> new RecursosNoEncontradoException(
                "No se encontro una venta con el id: "+id
        ));
        VentaMapper.updateEstado(venta,dto);

        Venta guardado=ventaRepository.save(venta);
        return VentaMapper.toDto(guardado);
    }

    private void procesarItems(Venta venta, List<DetalleVentaRequestDto> itemsDto) {
        BigDecimal totalVenta = BigDecimal.ZERO;
        List<DetalleVenta> detallesEntities = new ArrayList<>();

        for (DetalleVentaRequestDto itemDto : itemsDto) {
            Producto producto = productoRepository.findById(itemDto.id_producto())
                    .orElseThrow(() -> new RecursosNoEncontradoException("Producto no encontrado"));

            DetalleVenta detalle = new DetalleVenta();
            detalle.setProducto(producto);
            detalle.setCantidad(itemDto.cantidad());

            BigDecimal precioActual = BigDecimal.valueOf(producto.getPrecio());
            BigDecimal subTotal = precioActual.multiply(new BigDecimal(itemDto.cantidad()));

            detalle.setPrecioUnitario(precioActual);
            detalle.setSubTotal(subTotal);
            detalle.setEstadoDetalleVenta(true);
            detalle.setVenta(venta);
            detallesEntities.add(detalle);

            totalVenta = totalVenta.add(subTotal);
        }
        venta.setDetalles(detallesEntities);
        venta.setTotal(totalVenta);
    }
}
