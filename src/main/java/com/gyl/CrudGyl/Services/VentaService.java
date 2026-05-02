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

        Cliente clienteGenerico = clienteRepository.findById(1L)
                .orElseThrow(() -> new RecursosNoEncontradoException("Debe crear un cliente genérico con ID 1 primero"));

        venta.setCliente(clienteGenerico); // Asociamos el cliente fijo

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

    @Override
    public VentaResponseDto actualizar(Long id, VentaRequestDto dto) {
        Venta venta=ventaRepository.findById(id).orElseThrow(()->new RecursosNoEncontradoException(
                "No se encontro la venta con el id: "+id
        ));
        VentaMapper.updateEstado(venta,dto);
        Venta guardado=ventaRepository.save(venta);
        return VentaMapper.toDto(guardado);
    }

    @Override
    public void eliminar(Long id) {
        Venta venta=ventaRepository.findById(id)
                .orElseThrow(()->new RecursosNoEncontradoException(
                "No se encontro la venta con el id: "+id
        ));

        ventaRepository.delete(venta);
    }

    @Override
    public List<VentaResponseDto> listarVentasConEstadoTrue() {

        return ventaRepository.findByEstadoVentaTrue()
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
            // 1. Buscamos el producto real para obtener el precio actual de la DB
            Producto producto = productoRepository.findById(itemDto.id_producto())
                    .orElseThrow(() -> new RecursosNoEncontradoException("Producto no encontrado"));

            // 2. Creamos la entidad de detalle y seteamos sus valores calculados
            DetalleVenta detalle = new DetalleVenta();
            detalle.setProducto(producto);
            detalle.setCantidad(itemDto.cantidad());

            // El precio lo sacamos del producto, no del DTO (por seguridad)
            BigDecimal precioActual = BigDecimal.valueOf(producto.getPrecio());
            BigDecimal subTotal = precioActual.multiply(new BigDecimal(itemDto.cantidad()));

            detalle.setPrecioUnitario(precioActual);
            detalle.setSubTotal(subTotal);
            detalle.setEstadoDetalleVenta(true);

            // 3. Vinculamos el detalle con la venta (ambos sentidos)[cite: 1, 2]
            detalle.setVenta(venta);
            detallesEntities.add(detalle);

            // 4. Vamos sumando al total acumulado de la venta
            totalVenta = totalVenta.add(subTotal);
        }

        // Finalmente actualizamos la venta con los resultados
        venta.setDetalles(detallesEntities);
        venta.setTotal(totalVenta);
    }
}
