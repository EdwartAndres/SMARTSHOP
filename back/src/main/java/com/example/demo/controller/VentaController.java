package com.example.demo.controller;

import com.example.demo.Entidad.Venta;
import com.example.demo.service.VentaService;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    // ...

    @Autowired
    private VentaService ventaService;

    @PostMapping
    public ResponseEntity<Venta> createVenta(@RequestBody Venta venta) {
        try {
            // Lógica para generar PDF y guardar en la base de datos
            byte[] pdfBytes = generarPDFVenta(venta);
            venta.setPdf(pdfBytes);

            // Guardar la venta en la base de datos
            Venta nuevaVenta = ventaService.createVenta(venta);

            return new ResponseEntity<>(nuevaVenta, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/generar-factura")
    public ResponseEntity<String> generarFactura(@RequestBody Venta venta) {
        try {
            byte[] pdfBytes = generarPDFVenta(venta);
            venta.setPdf(pdfBytes);
            ventaService.createVenta(venta);
            return new ResponseEntity<>("Factura generada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al generar la factura", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para generar el PDF con los detalles de la venta
    private byte[] generarPDFVenta(Venta venta) throws Exception {
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);

        document.open();
        document.add(new Paragraph("Detalles de la Venta"));
        document.add(new Paragraph("Fecha: " + venta.getFecha()));
        document.add(new Paragraph("Empleado: " + venta.getEmpleado().getNomEmpleado()));
        document.add(new Paragraph("Cliente: " + venta.getCliente().getNomCliente()));

        // Puedes agregar más detalles aquí...

        document.close();

        return baos.toByteArray();
    }
}
