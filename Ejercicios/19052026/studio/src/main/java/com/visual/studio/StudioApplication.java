package com.visual.studio;

import com.visual.studio.model.*;
import com.visual.studio.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class StudioApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudioApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(
			CategoriaRepository categoriaRepository,
			ProductoRepository productoRepository,
			InventarioRepository inventarioRepository,
			VentaRepository ventaRepository,
			DetalleVentaRepository detalleVentaRepository) {
		
		return args -> {
			Scanner scanner = new Scanner(System.in);
			int opcion;

			do {
				System.out.println("\n╔══════════════════════════════════════════╗");
				System.out.println("║   SISTEMA DE GESTIÓN - STUDIO            ║");
				System.out.println("╚══════════════════════════════════════════╝");
				System.out.println("\n┌─── GESTIÓN DE CATEGORÍAS ───┐");
				System.out.println("│ 1. Crear Categoría           │");
				System.out.println("│ 2. Listar Categorías         │");
				System.out.println("│ 3. Buscar Categoría por ID   │");
				System.out.println("│ 4. Actualizar Categoría      │");
				System.out.println("│ 5. Eliminar Categoría        │");
				System.out.println("└──────────────────────────────┘");
				System.out.println("\n┌─── GESTIÓN DE PRODUCTOS ────┐");
				System.out.println("│ 6. Crear Producto            │");
				System.out.println("│ 7. Listar Productos          │");
				System.out.println("│ 8. Buscar Producto por ID    │");
				System.out.println("│ 9. Actualizar Producto       │");
				System.out.println("│ 10. Eliminar Producto        │");
				System.out.println("│ 11. Productos por Categoría  │");
				System.out.println("└──────────────────────────────┘");
				System.out.println("\n┌─── GESTIÓN DE INVENTARIO ───┐");
				System.out.println("│ 12. Registrar Inventario     │");
				System.out.println("│ 13. Listar Inventario        │");
				System.out.println("│ 14. Historial por Producto   │");
				System.out.println("└──────────────────────────────┘");
				System.out.println("\n┌─── GESTIÓN DE VENTAS ───────┐");
				System.out.println("│ 15. Crear Venta              │");
				System.out.println("│ 16. Listar Ventas            │");
				System.out.println("│ 17. Ver Detalle de Venta     │");
				System.out.println("└──────────────────────────────┘");
				System.out.println("\n┌─── DATOS DE PRUEBA ─────────┐");
				System.out.println("│ 18. Poblar Base de Datos     │");
				System.out.println("└──────────────────────────────┘");
				System.out.println("\n0. Salir");
				System.out.print("\nSeleccione una opción: ");
				
				opcion = scanner.nextInt();
				scanner.nextLine(); // Limpiar buffer

				switch (opcion) {
					case 1: // Crear Categoría
						System.out.print("Nombre de la categoría: ");
						String nombreCategoria = scanner.nextLine();
						Categoria categoria = new Categoria(nombreCategoria);
						categoriaRepository.save(categoria);
						System.out.println("✓ Categoría creada con ID: " + categoria.getId());
						break;

					case 2: // Listar Categorías
						List<Categoria> categorias = categoriaRepository.findAll();
						System.out.println("\n=== CATEGORÍAS ===");
						categorias.forEach(c -> System.out.println("ID: " + c.getId() + " | Nombre: " + c.getNombre()));
						break;

					case 3: // Buscar Categoría
						System.out.print("ID de la categoría: ");
						Long idCategoria = scanner.nextLong();
						Optional<Categoria> catEncontrada = categoriaRepository.findById(idCategoria);
						if (catEncontrada.isPresent()) {
							Categoria c = catEncontrada.get();
							System.out.println("ID: " + c.getId() + " | Nombre: " + c.getNombre());
						} else {
							System.out.println("✗ Categoría no encontrada");
						}
						break;

					case 4: // Actualizar Categoría
						System.out.print("ID de la categoría a actualizar: ");
						Long idActCategoria = scanner.nextLong();
						scanner.nextLine();
						Optional<Categoria> catAct = categoriaRepository.findById(idActCategoria);
						if (catAct.isPresent()) {
							System.out.print("Nuevo nombre: ");
							String nuevoNombre = scanner.nextLine();
							Categoria c = catAct.get();
							c.setNombre(nuevoNombre);
							categoriaRepository.save(c);
							System.out.println("✓ Categoría actualizada");
						} else {
							System.out.println("✗ Categoría no encontrada");
						}
						break;

					case 5: // Eliminar Categoría
						System.out.print("ID de la categoría a eliminar: ");
						Long idElimCat = scanner.nextLong();
						if (categoriaRepository.existsById(idElimCat)) {
							categoriaRepository.deleteById(idElimCat);
							System.out.println("✓ Categoría eliminada");
						} else {
							System.out.println("✗ Categoría no encontrada");
						}
						break;

					case 6: // Crear Producto
						System.out.print("Nombre del producto: ");
						String nombreProducto = scanner.nextLine();
						System.out.print("Descripción: ");
						String descripcion = scanner.nextLine();
						System.out.print("Precio: ");
						BigDecimal precio = scanner.nextBigDecimal();
						System.out.print("Stock: ");
						Integer stock = scanner.nextInt();
						System.out.print("ID de la categoría: ");
						Long idCatProducto = scanner.nextLong();
						
						Optional<Categoria> catProducto = categoriaRepository.findById(idCatProducto);
						if (catProducto.isPresent()) {
							Producto producto = new Producto(nombreProducto, descripcion, precio, stock);
							producto.setCategoria(catProducto.get());
							productoRepository.save(producto);
							System.out.println("✓ Producto creado con ID: " + producto.getId());
						} else {
							System.out.println("✗ Categoría no encontrada");
						}
						break;

					case 7: // Listar Productos
						List<Producto> productos = productoRepository.findAll();
						System.out.println("\n=== PRODUCTOS ===");
						productos.forEach(p -> System.out.println(
								"ID: " + p.getId() + 
								" | Nombre: " + p.getNombre() + 
								" | Precio: $" + p.getPrecio() + 
								" | Stock: " + p.getStock() +
								" | Categoría: " + (p.getCategoria() != null ? p.getCategoria().getNombre() : "N/A")));
						break;

					case 8: // Buscar Producto
						System.out.print("ID del producto: ");
						Long idProducto = scanner.nextLong();
						Optional<Producto> prodEncontrado = productoRepository.findById(idProducto);
						if (prodEncontrado.isPresent()) {
							Producto p = prodEncontrado.get();
							System.out.println("ID: " + p.getId());
							System.out.println("Nombre: " + p.getNombre());
							System.out.println("Descripción: " + p.getDescripcion());
							System.out.println("Precio: $" + p.getPrecio());
							System.out.println("Stock: " + p.getStock());
							System.out.println("Categoría: " + (p.getCategoria() != null ? p.getCategoria().getNombre() : "N/A"));
						} else {
							System.out.println("✗ Producto no encontrado");
						}
						break;

					case 9: // Actualizar Producto
						System.out.print("ID del producto a actualizar: ");
						Long idActProd = scanner.nextLong();
						scanner.nextLine();
						Optional<Producto> prodAct = productoRepository.findById(idActProd);
						if (prodAct.isPresent()) {
							Producto p = prodAct.get();
							System.out.print("Nuevo nombre (actual: " + p.getNombre() + "): ");
							p.setNombre(scanner.nextLine());
							System.out.print("Nueva descripción: ");
							p.setDescripcion(scanner.nextLine());
							System.out.print("Nuevo precio: ");
							p.setPrecio(scanner.nextBigDecimal());
							System.out.print("Nuevo stock: ");
							p.setStock(scanner.nextInt());
							productoRepository.save(p);
							System.out.println("✓ Producto actualizado");
						} else {
							System.out.println("✗ Producto no encontrado");
						}
						break;

					case 10: // Eliminar Producto
						System.out.print("ID del producto a eliminar: ");
						Long idElimProd = scanner.nextLong();
						if (productoRepository.existsById(idElimProd)) {
							productoRepository.deleteById(idElimProd);
							System.out.println("✓ Producto eliminado");
						} else {
							System.out.println("✗ Producto no encontrado");
						}
						break;

					case 11: // Productos por Categoría
						System.out.print("ID de la categoría: ");
						Long idCatFiltro = scanner.nextLong();
						List<Producto> productosCat = productoRepository.findByCategoria_Id(idCatFiltro);
						System.out.println("\n=== PRODUCTOS DE LA CATEGORÍA ===");
						productosCat.forEach(p -> System.out.println(
								"ID: " + p.getId() + " | Nombre: " + p.getNombre() + " | Precio: $" + p.getPrecio()));
						break;

					case 12: // Registrar Inventario
						System.out.print("ID del producto: ");
						Long idProdInv = scanner.nextLong();
						System.out.print("Cantidad: ");
						Integer cantidad = scanner.nextInt();
						
						Optional<Producto> prodInv = productoRepository.findById(idProdInv);
						if (prodInv.isPresent()) {
							Inventario inventario = new Inventario(prodInv.get(), cantidad, ZonedDateTime.now());
							inventarioRepository.save(inventario);
							System.out.println("✓ Inventario registrado con ID: " + inventario.getId());
						} else {
							System.out.println("✗ Producto no encontrado");
						}
						break;

					case 13: // Listar Inventario
						List<Inventario> inventarios = inventarioRepository.findAll();
						System.out.println("\n=== INVENTARIO ===");
						inventarios.forEach(i -> System.out.println(
								"ID: " + i.getId() + 
								" | Producto: " + i.getProducto().getNombre() + 
								" | Cantidad: " + i.getCantidad() +
								" | Fecha: " + i.getFecha()));
						break;

					case 14: // Historial por Producto
						System.out.print("ID del producto: ");
						Long idProdHist = scanner.nextLong();
						List<Inventario> historial = inventarioRepository.findByProducto_Id(idProdHist);
						System.out.println("\n=== HISTORIAL DE INVENTARIO ===");
						historial.forEach(i -> System.out.println(
								"Fecha: " + i.getFecha() + " | Cantidad: " + i.getCantidad()));
						break;

					case 15: // Crear Venta
						Venta venta = new Venta(ZonedDateTime.now(), BigDecimal.ZERO);
						ventaRepository.save(venta);
						System.out.println("✓ Venta creada con ID: " + venta.getId());
						System.out.println("Agregando productos a la venta...");
						
						BigDecimal totalVenta = BigDecimal.ZERO;
						String continuar;
						do {
							System.out.print("ID del producto: ");
							Long idProdVenta = scanner.nextLong();
							System.out.print("Cantidad: ");
							Integer cantVenta = scanner.nextInt();
							scanner.nextLine();
							
							Optional<Producto> prodVenta = productoRepository.findById(idProdVenta);
							if (prodVenta.isPresent()) {
								Producto p = prodVenta.get();
								BigDecimal subtotal = p.getPrecio().multiply(new BigDecimal(cantVenta));
								totalVenta = totalVenta.add(subtotal);
								
								DetalleVenta detalle = new DetalleVenta(venta, p, cantVenta, p.getPrecio());
								detalleVentaRepository.save(detalle);
								System.out.println("✓ Producto agregado. Subtotal: $" + subtotal);
							} else {
								System.out.println("✗ Producto no encontrado");
							}
							
							System.out.print("¿Agregar otro producto? (s/n): ");
							continuar = scanner.nextLine();
						} while (continuar.equalsIgnoreCase("s"));
						
						venta.setTotal(totalVenta);
						ventaRepository.save(venta);
						System.out.println("✓ Venta finalizada. Total: $" + totalVenta);
						break;

					case 16: // Listar Ventas
						List<Venta> ventas = ventaRepository.findAll();
						System.out.println("\n=== VENTAS ===");
						ventas.forEach(v -> System.out.println(
								"ID: " + v.getId() + " | Fecha: " + v.getFecha() + " | Total: $" + v.getTotal()));
						break;

					case 17: // Ver Detalle de Venta
						System.out.print("ID de la venta: ");
						Long idVenta = scanner.nextLong();
						List<DetalleVenta> detalles = detalleVentaRepository.findByVenta_Id(idVenta);
						System.out.println("\n=== DETALLE DE VENTA ===");
						detalles.forEach(d -> System.out.println(
								"Producto: " + d.getProducto().getNombre() +
								" | Cantidad: " + d.getCantidad() +
								" | Precio Unit: $" + d.getPrecioUnitario() +
								" | Subtotal: $" + d.getPrecioUnitario().multiply(new BigDecimal(d.getCantidad()))));
						break;

					case 18: // Poblar Base de Datos
						System.out.println("Poblando base de datos con datos de prueba...");
						
						// Crear categorías
						Categoria cat1 = categoriaRepository.save(new Categoria("Electrónica"));
						Categoria cat2 = categoriaRepository.save(new Categoria("Ropa"));
						Categoria cat3 = categoriaRepository.save(new Categoria("Alimentos"));
						
						// Crear productos
						Producto prod1 = new Producto("Laptop HP", "Laptop 16GB RAM", new BigDecimal("1200.00"), 10);
						prod1.setCategoria(cat1);
						productoRepository.save(prod1);
						
						Producto prod2 = new Producto("Mouse Logitech", "Mouse inalámbrico", new BigDecimal("25.00"), 50);
						prod2.setCategoria(cat1);
						productoRepository.save(prod2);
						
						Producto prod3 = new Producto("Camiseta Nike", "Talla M", new BigDecimal("30.00"), 20);
						prod3.setCategoria(cat2);
						productoRepository.save(prod3);
						
						Producto prod4 = new Producto("Café Premium", "500g", new BigDecimal("15.00"), 100);
						prod4.setCategoria(cat3);
						productoRepository.save(prod4);
						
						// Crear inventario
						inventarioRepository.save(new Inventario(prod1, 10, ZonedDateTime.now()));
						inventarioRepository.save(new Inventario(prod2, 50, ZonedDateTime.now()));
						inventarioRepository.save(new Inventario(prod3, 20, ZonedDateTime.now()));
						inventarioRepository.save(new Inventario(prod4, 100, ZonedDateTime.now()));
						
						// Crear venta de ejemplo
						Venta ventaPrueba = new Venta(ZonedDateTime.now(), new BigDecimal("55.00"));
						ventaRepository.save(ventaPrueba);
						detalleVentaRepository.save(new DetalleVenta(ventaPrueba, prod2, 2, prod2.getPrecio()));
						detalleVentaRepository.save(new DetalleVenta(ventaPrueba, prod4, 2, prod4.getPrecio()));
						
						System.out.println("✓ Base de datos poblada exitosamente!");
						System.out.println("  - 3 Categorías");
						System.out.println("  - 4 Productos");
						System.out.println("  - 4 Registros de Inventario");
						System.out.println("  - 1 Venta con 2 productos");
						break;

					case 0:
						System.out.println("\n¡Hasta pronto!");
						break;

					default:
						System.out.println("✗ Opción no válida");
				}

			} while (opcion != 0);
		};
	}
}
