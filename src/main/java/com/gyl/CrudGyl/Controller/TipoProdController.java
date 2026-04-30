package com.gyl.CrudGyl.Controller;

import com.gyl.CrudGyl.Entity.TipoProducto;
import com.gyl.CrudGyl.Services.TipoProductoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tipoProd")
public class TipoProdController {
    private final TipoProductoService tipoProductoService;

    public TipoProdController(TipoProductoService tipoProductoService) {
        this.tipoProductoService = tipoProductoService;
    }
}
